/*
 ******************************************************************************
 * 
 * IBM Confidential
 * 
 * OCO Source Materials
 * 
 * 5725D06, 5725Q72
 * 
 * (C) Copyright IBM Corp. 2013, 2015
 * 
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has
 * been deposited with the U.S. Copyright Office.
 *
 *******************************************************************************
 */
package com.ibm.commerce.cache;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * This class aggregates statistics about operation executions on the system.
 * 
 * Divides time into discrete and constant sized intervals beginning at
 * construction. The size and number of intervals can be configured at
 * construction.
 * 
 * The {@link #getStatistics(long, boolean)} method will traverse through the
 * intervals within range of the argument and aggregate all the statistics.
 * 
 * This class is thread safe, high concurrency
 * 
 * @author mcduffs
 * 
 */
public final class TimeIntervalStatisticsAggregator extends TimeIntervalAggregator<OperationStatistics>{

	private OperationStatistics cachedStatistics;

	/**
	 * Constructor
	 * 
	 * @param intervalWidthInNanos
	 *            The width of a time interval in nano seconds
	 * @param intervalCount
	 *            maximum number of intervals that is tracked
	 */
	public TimeIntervalStatisticsAggregator(final long intervalWidthInNanos,
			final int intervalCount) {
		super( intervalWidthInNanos, intervalCount);
	}

	/**
	 * Get statistics for the specified time period. This method works by
	 * looking at all the stored time intervals and aggregating the ones that
	 * are within the specified time window.
	 * 
	 * @param sinceNanosAgo
	 *            The amount of time to cover in the aggregated statistics. This
	 *            number will be rounded to the closest time interval boundary.
	 * @param skipCurrentInterval
	 *            An option to skip the current time interval in statistics
	 *            aggregation since that interval is still accumulating data.
	 *            Setting this to true increases the counter accuracy.
	 * @return The aggregated statistics of the desired time interval.
	 */
	public OperationStatistics getStatistics(final long sinceNanosAgo,
			boolean skipCurrentInterval) {
		long nanoTime = System.nanoTime();

		return getStatisticsAtTime(sinceNanosAgo, skipCurrentInterval, nanoTime);
	}

	/**
	 * Get statistics for the specified time period. This method works by
	 * looking at all the stored time intervals and aggregating the ones that
	 * are within the specified time window.
	 * 
	 * @param sinceNanosAgo
	 *            The amount of time to cover in the aggregated statistics. This
	 *            number will be rounded to the closest time interval boundary.
	 * @param skipCurrentInterval
	 *            An option to skip the current time interval in statistics
	 *            aggregation since that interval is still accumulating data.
	 *            Setting this to true increases the counter accuracy.
	 * @param nanoTime
	 *            the time at which to take the statistics snapshot.
	 * @return The aggregated statistics of the desired time interval.
	 */
	public OperationStatistics getStatisticsAtTime(final long sinceNanosAgo,
			boolean skipCurrentInterval, long nanoTime) {
		long intervalWidthInNanos = getIntervalWidthInNanos();
		long maximumIndex = nanoTime / intervalWidthInNanos;
		long minimumIndex = maximumIndex
				- (sinceNanosAgo / intervalWidthInNanos);

		if (skipCurrentInterval) {
			maximumIndex -= 1;
			minimumIndex -= 1;
		}

		OperationStatistics statistics = cachedStatistics;
		if (!skipCurrentInterval || statistics == null
				|| statistics.getIndex() != maximumIndex
				|| statistics.getMinimumIndex() != minimumIndex) {
			statistics = new OperationStatistics();
			AtomicReferenceArray<OperationStatistics> intervalArray = getIntervalArray();
			int length = intervalArray.length();
			for (int i = 0; i < length; ++i) {
				OperationStatistics operationStatistics = intervalArray.get(i);
				statistics.aggregateStatisticsIfInInterval(operationStatistics,
						minimumIndex, maximumIndex);
			}
			if (skipCurrentInterval) {
				cachedStatistics = statistics;
			}
		}

		return statistics;
	}

	@Override
	protected OperationStatistics createNewInterval() {
		return new OperationStatistics();
	}

}
