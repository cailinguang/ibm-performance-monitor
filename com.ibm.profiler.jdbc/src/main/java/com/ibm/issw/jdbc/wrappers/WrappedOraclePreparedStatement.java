/*
 * Copyright 2017 Steve McDuff
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.issw.jdbc.wrappers;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import com.ibm.issw.jdbc.profiler.JdbcEvent;

import oracle.jdbc.OracleParameterMetaData;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleResultSetCache;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public class WrappedOraclePreparedStatement extends WrappedPreparedStatement implements OraclePreparedStatement{
	
	private final OraclePreparedStatement oraclePs;

	public WrappedOraclePreparedStatement(PreparedStatement preparedStatement,
			String sql, String ref, String transaction, Connection connection) {
		super(preparedStatement, sql, ref, transaction, connection);
		oraclePs = (OraclePreparedStatement) preparedStatement;
	}

	@Override
	public void clearDefines() throws SQLException {
		oraclePs.clearDefines();
	}

	@Override
	public void defineColumnType(int paramInt1, int paramInt2)
			throws SQLException {
		oraclePs.defineColumnType(paramInt1, paramInt2);
	}

	@Override
	public void defineColumnType(int paramInt1, int paramInt2, int paramInt3)
			throws SQLException {
		oraclePs.defineColumnType(paramInt1, paramInt2, paramInt3);
		
	}

	@Override
	public void defineColumnType(int paramInt1, int paramInt2, int paramInt3,
			short paramShort) throws SQLException {
		oraclePs.defineColumnType(paramInt1, paramInt2, paramInt3, paramShort);
		
	}

	@Override
	public void defineColumnTypeBytes(int paramInt1, int paramInt2,
			int paramInt3) throws SQLException {
		oraclePs.defineColumnTypeBytes(paramInt1, paramInt2, paramInt3);
		
	}

	@Override
	public void defineColumnTypeChars(int paramInt1, int paramInt2,
			int paramInt3) throws SQLException {
		oraclePs.defineColumnTypeChars(paramInt1, paramInt2, paramInt3);
		
	}

	@Override
	public void defineColumnType(int paramInt1, int paramInt2,
			String paramString) throws SQLException {
		oraclePs.defineColumnType(paramInt1, paramInt2, paramString);
		
	}

	@Override
	public int getRowPrefetch() {
		return oraclePs.getRowPrefetch();
	}

	@Override
	public void setResultSetCache(OracleResultSetCache paramOracleResultSetCache)
			throws SQLException {
		oraclePs.setResultSetCache(paramOracleResultSetCache);
		
	}

	@Override
	public void setRowPrefetch(int paramInt) throws SQLException {
		oraclePs.setRowPrefetch(paramInt);
		
	}

	@Override
	public void closeWithKey(String paramString) throws SQLException {
		oraclePs.closeWithKey(paramString);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public int creationState() {
		return oraclePs.creationState();
	}

	@Override
	public boolean isNCHAR(int paramInt) throws SQLException {
		return oraclePs.isNCHAR(paramInt);
	}

	@Override
	public void setDatabaseChangeRegistration(
			DatabaseChangeRegistration paramDatabaseChangeRegistration)
			throws SQLException {
		oraclePs.setDatabaseChangeRegistration(paramDatabaseChangeRegistration);
	}

	@Override
	public String[] getRegisteredTableNames() throws SQLException {
		return oraclePs.getRegisteredTableNames();
	}

	@Override
	public long getRegisteredQueryId() throws SQLException {
		return oraclePs.getRegisteredQueryId();
	}

	@Override
	public void defineParameterTypeBytes(int paramInt1, int paramInt2,
			int paramInt3) throws SQLException {
		oraclePs.defineParameterTypeBytes(paramInt1, paramInt2, paramInt3);
	}

	@Override
	public void defineParameterTypeChars(int paramInt1, int paramInt2,
			int paramInt3) throws SQLException {
		oraclePs.defineParameterTypeChars(paramInt1, paramInt2, paramInt3);
	}

	@Override
	public void defineParameterType(int paramInt1, int paramInt2, int paramInt3)
			throws SQLException {
		oraclePs.defineParameterType(paramInt1, paramInt2, paramInt3);
		
	}

	@Override
	public int getExecuteBatch() {
		return oraclePs.getExecuteBatch();
	}

	@Override
	public int sendBatch() throws SQLException {
		return oraclePs.sendBatch();
	}

	@Override
	public void setARRAY(int paramInt, ARRAY paramARRAY) throws SQLException {
		oraclePs.setARRAY(paramInt, paramARRAY);
		
	}

	@Override
	public void setBfile(int paramInt, BFILE paramBFILE) throws SQLException {
		oraclePs.setBfile(paramInt, paramBFILE);
		
	}

	@Override
	public void setBFILE(int paramInt, BFILE paramBFILE) throws SQLException {
		oraclePs.setBFILE(paramInt, paramBFILE);
		
	}

	@Override
	public void setBLOB(int paramInt, BLOB paramBLOB) throws SQLException {
		oraclePs.setBLOB(paramInt, paramBLOB);
		
	}

	@Override
	public void setCHAR(int paramInt, CHAR paramCHAR) throws SQLException {
		oraclePs.setCHAR(paramInt, paramCHAR);
		
	}

	@Override
	public void setCLOB(int paramInt, CLOB paramCLOB) throws SQLException {
		oraclePs.setCLOB(paramInt, paramCLOB);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setCursor(int paramInt, ResultSet paramResultSet)
			throws SQLException {
		oraclePs.setCursor(paramInt, paramResultSet);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setCustomDatum(int paramInt, CustomDatum paramCustomDatum)
			throws SQLException {
		oraclePs.setCustomDatum(paramInt, paramCustomDatum);
		
	}

	@Override
	public void setORAData(int paramInt, ORAData paramORAData)
			throws SQLException {
		oraclePs.setORAData(paramInt, paramORAData);
		
	}

	@Override
	public void setDATE(int paramInt, DATE paramDATE) throws SQLException {
		oraclePs.setDATE(paramInt, paramDATE);
		
	}

	@Override
	public void setExecuteBatch(int paramInt) throws SQLException {
		oraclePs.setExecuteBatch(paramInt);
		
	}

	@Override
	public void setFixedCHAR(int paramInt, String paramString)
			throws SQLException {
		oraclePs.setFixedCHAR(paramInt, paramString);
		
	}

	@Override
	public void setNUMBER(int paramInt, NUMBER paramNUMBER) throws SQLException {
		oraclePs.setNUMBER(paramInt, paramNUMBER);
		
	}

	@Override
	public void setBinaryFloat(int paramInt, float paramFloat)
			throws SQLException {
		oraclePs.setBinaryFloat(paramInt, paramFloat);
		
	}

	@Override
	public void setBinaryFloat(int paramInt, BINARY_FLOAT paramBINARY_FLOAT)
			throws SQLException {
		oraclePs.setBinaryFloat(paramInt, paramBINARY_FLOAT);
		
	}

	@Override
	public void setBinaryDouble(int paramInt, double paramDouble)
			throws SQLException {
		oraclePs.setBinaryDouble(paramInt, paramDouble);
		
	}

	@Override
	public void setBinaryDouble(int paramInt, BINARY_DOUBLE paramBINARY_DOUBLE)
			throws SQLException {
		oraclePs.setBinaryDouble(paramInt, paramBINARY_DOUBLE);
		
	}

	@Override
	public void setOPAQUE(int paramInt, OPAQUE paramOPAQUE) throws SQLException {
		oraclePs.setOPAQUE(paramInt, paramOPAQUE);
		
	}

	@Override
	public void setOracleObject(int paramInt, Datum paramDatum)
			throws SQLException {
		oraclePs.setOracleObject(paramInt, paramDatum);
		
	}

	@Override
	public void setStructDescriptor(int paramInt,
			StructDescriptor paramStructDescriptor) throws SQLException {
		oraclePs.setStructDescriptor(paramInt, paramStructDescriptor);
		
	}

	@Override
	public void setRAW(int paramInt, RAW paramRAW) throws SQLException {
		oraclePs.setRAW(paramInt, paramRAW);
		
	}

	@Override
	public void setREF(int paramInt, REF paramREF) throws SQLException {
		oraclePs.setREF(paramInt, paramREF);
		
	}

	@Override
	public void setRefType(int paramInt, REF paramREF) throws SQLException {
		oraclePs.setRefType(paramInt, paramREF);
		
	}

	@Override
	public void setROWID(int paramInt, ROWID paramROWID) throws SQLException {
		oraclePs.setROWID(paramInt, paramROWID);
		
	}

	@Override
	public void setSTRUCT(int paramInt, STRUCT paramSTRUCT) throws SQLException {
		oraclePs.setSTRUCT(paramInt, paramSTRUCT);
		
	}

	@Override
	public void setTIMESTAMP(int paramInt, TIMESTAMP paramTIMESTAMP)
			throws SQLException {
		oraclePs.setTIMESTAMP(paramInt, paramTIMESTAMP);
		
	}

	@Override
	public void setTIMESTAMPTZ(int paramInt, TIMESTAMPTZ paramTIMESTAMPTZ)
			throws SQLException {
		oraclePs.setTIMESTAMPTZ(paramInt, paramTIMESTAMPTZ);
		
	}

	@Override
	public void setTIMESTAMPLTZ(int paramInt, TIMESTAMPLTZ paramTIMESTAMPLTZ)
			throws SQLException {
		oraclePs.setTIMESTAMPLTZ(paramInt, paramTIMESTAMPLTZ);
		
	}

	@Override
	public void setINTERVALYM(int paramInt, INTERVALYM paramINTERVALYM)
			throws SQLException {
		oraclePs.setINTERVALYM(paramInt, paramINTERVALYM);
		
	}

	@Override
	public void setINTERVALDS(int paramInt, INTERVALDS paramINTERVALDS)
			throws SQLException {
		oraclePs.setINTERVALDS(paramInt, paramINTERVALDS);
		
	}

	@Override
	public void setNullAtName(String paramString1, int paramInt,
			String paramString2) throws SQLException {
		oraclePs.setNullAtName(paramString1, paramInt, paramString2);
		
	}

	@Override
	public void setNullAtName(String paramString, int paramInt)
			throws SQLException {
		oraclePs.setNullAtName(paramString, paramInt);
		
	}

	@Override
	public void setBooleanAtName(String paramString, boolean paramBoolean)
			throws SQLException {
		oraclePs.setBooleanAtName(paramString, paramBoolean);
		
	}

	@Override
	public void setByteAtName(String paramString, byte paramByte)
			throws SQLException {
		oraclePs.setByteAtName(paramString, paramByte);
		
	}

	@Override
	public void setShortAtName(String paramString, short paramShort)
			throws SQLException {
		oraclePs.setShortAtName(paramString, paramShort);
		
	}

	@Override
	public void setIntAtName(String paramString, int paramInt)
			throws SQLException {
		oraclePs.setIntAtName(paramString, paramInt);
		
	}

	@Override
	public void setLongAtName(String paramString, long paramLong)
			throws SQLException {
		oraclePs.setLongAtName(paramString, paramLong);
		
	}

	@Override
	public void setFloatAtName(String paramString, float paramFloat)
			throws SQLException {
		oraclePs.setFloatAtName(paramString, paramFloat);
		
	}

	@Override
	public void setDoubleAtName(String paramString, double paramDouble)
			throws SQLException {
		oraclePs.setDoubleAtName(paramString, paramDouble);
		
	}

	@Override
	public void setBinaryFloatAtName(String paramString, float paramFloat)
			throws SQLException {
		oraclePs.setBinaryFloatAtName(paramString, paramFloat);
		
	}

	@Override
	public void setBinaryFloatAtName(String paramString,
			BINARY_FLOAT paramBINARY_FLOAT) throws SQLException {
		oraclePs.setBinaryFloatAtName(paramString, paramBINARY_FLOAT);
		
	}

	@Override
	public void setBinaryDoubleAtName(String paramString, double paramDouble)
			throws SQLException {
		oraclePs.setBinaryDoubleAtName(paramString, paramDouble);
		
	}

	@Override
	public void setBinaryDoubleAtName(String paramString,
			BINARY_DOUBLE paramBINARY_DOUBLE) throws SQLException {
		oraclePs.setBinaryDoubleAtName(paramString, paramBINARY_DOUBLE);
		
	}

	@Override
	public void setBigDecimalAtName(String paramString,
			BigDecimal paramBigDecimal) throws SQLException {
		oraclePs.setBigDecimalAtName(paramString, paramBigDecimal);
		
	}

	@Override
	public void setStringAtName(String paramString1, String paramString2)
			throws SQLException {
		oraclePs.setStringAtName(paramString1, paramString2);
		
	}

	@Override
	public void setStringForClob(int paramInt, String paramString)
			throws SQLException {
		oraclePs.setStringForClob(paramInt, paramString);
		
	}

	@Override
	public void setStringForClobAtName(String paramString1, String paramString2)
			throws SQLException {
		oraclePs.setStringForClobAtName(paramString1, paramString2);
		
	}

	@Override
	public void setFixedCHARAtName(String paramString1, String paramString2)
			throws SQLException {
		oraclePs.setFixedCHARAtName(paramString1, paramString2);
		
	}

	@Override
	public void setCursorAtName(String paramString, ResultSet paramResultSet)
			throws SQLException {
		oraclePs.setCursorAtName(paramString, paramResultSet);
		
	}

	@Override
	public void setROWIDAtName(String paramString, ROWID paramROWID)
			throws SQLException {
		oraclePs.setROWIDAtName(paramString, paramROWID);
		
	}

	@Override
	public void setArrayAtName(String paramString, Array paramArray)
			throws SQLException {
		oraclePs.setArrayAtName(paramString, paramArray);
		
	}

	@Override
	public void setARRAYAtName(String paramString, ARRAY paramARRAY)
			throws SQLException {
		oraclePs.setARRAYAtName(paramString, paramARRAY);
		
	}

	@Override
	public void setOPAQUEAtName(String paramString, OPAQUE paramOPAQUE)
			throws SQLException {
		oraclePs.setOPAQUEAtName(paramString, paramOPAQUE);
		
	}

	@Override
	public void setStructDescriptorAtName(String paramString,
			StructDescriptor paramStructDescriptor) throws SQLException {
		oraclePs.setStructDescriptorAtName(paramString, paramStructDescriptor);
		
	}

	@Override
	public void setSTRUCTAtName(String paramString, STRUCT paramSTRUCT)
			throws SQLException {
		oraclePs.setSTRUCTAtName(paramString, paramSTRUCT);
		
	}

	@Override
	public void setRAWAtName(String paramString, RAW paramRAW)
			throws SQLException {
		oraclePs.setRAWAtName(paramString, paramRAW);
		
	}

	@Override
	public void setCHARAtName(String paramString, CHAR paramCHAR)
			throws SQLException {
		oraclePs.setCHARAtName(paramString, paramCHAR);
		
	}

	@Override
	public void setDATEAtName(String paramString, DATE paramDATE)
			throws SQLException {
		oraclePs.setDATEAtName(paramString, paramDATE);
		
	}

	@Override
	public void setNUMBERAtName(String paramString, NUMBER paramNUMBER)
			throws SQLException {
		oraclePs.setNUMBERAtName(paramString, paramNUMBER);
		
	}

	@Override
	public void setBLOBAtName(String paramString, BLOB paramBLOB)
			throws SQLException {
		oraclePs.setBLOBAtName(paramString, paramBLOB);
		
	}

	@Override
	public void setBlobAtName(String paramString, Blob paramBlob)
			throws SQLException {
		oraclePs.setBlobAtName(paramString, paramBlob);
		
	}

	@Override
	public void setBlobAtName(String paramString, InputStream paramInputStream,
			long paramLong) throws SQLException {
		oraclePs.setBlobAtName(paramString, paramInputStream, paramLong);
		
	}

	@Override
	public void setBlobAtName(String paramString, InputStream paramInputStream)
			throws SQLException {
		oraclePs.setBlobAtName(paramString, paramInputStream);
		
	}

	@Override
	public void setCLOBAtName(String paramString, CLOB paramCLOB)
			throws SQLException {
		oraclePs.setCLOBAtName(paramString, paramCLOB);
		
	}

	@Override
	public void setClobAtName(String paramString, Clob paramClob)
			throws SQLException {
		oraclePs.setClobAtName(paramString, paramClob);
		
	}

	@Override
	public void setClobAtName(String paramString, Reader paramReader,
			long paramLong) throws SQLException {
		oraclePs.setClobAtName(paramString, paramReader, paramLong);
		
	}

	@Override
	public void setClobAtName(String paramString, Reader paramReader)
			throws SQLException {
		oraclePs.setClobAtName(paramString, paramReader);
		
	}

	@Override
	public void setBFILEAtName(String paramString, BFILE paramBFILE)
			throws SQLException {
		oraclePs.setBFILEAtName(paramString, paramBFILE);
		
	}

	@Override
	public void setBfileAtName(String paramString, BFILE paramBFILE)
			throws SQLException {
		oraclePs.setBfileAtName(paramString, paramBFILE);
		
	}

	@Override
	public void setBytesAtName(String paramString, byte[] paramArrayOfByte)
			throws SQLException {
		oraclePs.setBytesAtName(paramString, paramArrayOfByte);
		
	}

	@Override
	public void setBytesForBlob(int paramInt, byte[] paramArrayOfByte)
			throws SQLException {
		oraclePs.setBytesForBlob(paramInt, paramArrayOfByte);
		
	}

	@Override
	public void setBytesForBlobAtName(String paramString,
			byte[] paramArrayOfByte) throws SQLException {
		oraclePs.setBytesForBlobAtName(paramString, paramArrayOfByte);
		
	}

	@Override
	public void setDateAtName(String paramString, Date paramDate)
			throws SQLException {
		oraclePs.setDateAtName(paramString, paramDate);
		
	}

	@Override
	public void setDateAtName(String paramString, Date paramDate,
			Calendar paramCalendar) throws SQLException {
		oraclePs.setDateAtName(paramString, paramDate, paramCalendar);
		
	}

	@Override
	public void setTimeAtName(String paramString, Time paramTime)
			throws SQLException {
		oraclePs.setTimeAtName(paramString, paramTime);
		
	}

	@Override
	public void setTimeAtName(String paramString, Time paramTime,
			Calendar paramCalendar) throws SQLException {
		oraclePs.setTimeAtName(paramString, paramTime, paramCalendar);
		
	}

	@Override
	public void setTimestampAtName(String paramString, Timestamp paramTimestamp)
			throws SQLException {
		oraclePs.setTimestampAtName(paramString, paramTimestamp);
		
	}

	@Override
	public void setTimestampAtName(String paramString,
			Timestamp paramTimestamp, Calendar paramCalendar)
			throws SQLException {
		oraclePs.setTimestampAtName(paramString, paramTimestamp, paramCalendar);
		
	}

	@Override
	public void setINTERVALYMAtName(String paramString,
			INTERVALYM paramINTERVALYM) throws SQLException {
		oraclePs.setINTERVALYMAtName(paramString, paramINTERVALYM);
		
	}

	@Override
	public void setINTERVALDSAtName(String paramString,
			INTERVALDS paramINTERVALDS) throws SQLException {
		oraclePs.setINTERVALDSAtName(paramString, paramINTERVALDS);
		
	}

	@Override
	public void setTIMESTAMPAtName(String paramString, TIMESTAMP paramTIMESTAMP)
			throws SQLException {
		oraclePs.setTIMESTAMPAtName(paramString, paramTIMESTAMP);
		
	}

	@Override
	public void setTIMESTAMPTZAtName(String paramString,
			TIMESTAMPTZ paramTIMESTAMPTZ) throws SQLException {
		oraclePs.setTIMESTAMPTZAtName(paramString, paramTIMESTAMPTZ);
		
	}

	@Override
	public void setTIMESTAMPLTZAtName(String paramString,
			TIMESTAMPLTZ paramTIMESTAMPLTZ) throws SQLException {
		oraclePs.setTIMESTAMPLTZAtName(paramString, paramTIMESTAMPLTZ);
		
	}

	@Override
	public void setAsciiStreamAtName(String paramString,
			InputStream paramInputStream, int paramInt) throws SQLException {
		oraclePs.setAsciiStreamAtName(paramString, paramInputStream, paramInt);
		
	}

	@Override
	public void setAsciiStreamAtName(String paramString,
			InputStream paramInputStream, long paramLong) throws SQLException {
		oraclePs.setAsciiStreamAtName(paramString, paramInputStream, paramLong);
		
	}

	@Override
	public void setAsciiStreamAtName(String paramString,
			InputStream paramInputStream) throws SQLException {
		oraclePs.setAsciiStreamAtName(paramString, paramInputStream);
		
	}

	@Override
	public void setBinaryStreamAtName(String paramString,
			InputStream paramInputStream, int paramInt) throws SQLException {
		oraclePs.setBinaryStreamAtName(paramString, paramInputStream, paramInt);
		
	}

	@Override
	public void setBinaryStreamAtName(String paramString,
			InputStream paramInputStream, long paramLong) throws SQLException {
		oraclePs.setBinaryStreamAtName(paramString, paramInputStream, paramLong);
		
	}

	@Override
	public void setBinaryStreamAtName(String paramString,
			InputStream paramInputStream) throws SQLException {
		oraclePs.setBinaryStreamAtName(paramString, paramInputStream);
		
	}

	@Override
	public void setCharacterStreamAtName(String paramString,
			Reader paramReader, long paramLong) throws SQLException {
		oraclePs.setCharacterStreamAtName(paramString, paramReader, paramLong);
		
	}

	@Override
	public void setCharacterStreamAtName(String paramString, Reader paramReader)
			throws SQLException {
		oraclePs.setCharacterStreamAtName(paramString, paramReader);
		
	}

	@Override
	public void setUnicodeStreamAtName(String paramString,
			InputStream paramInputStream, int paramInt) throws SQLException {
		oraclePs.setUnicodeStreamAtName(paramString, paramInputStream, paramInt);
		
	}

	@Override
	public void setCustomDatumAtName(String paramString,
			CustomDatum paramCustomDatum) throws SQLException {
		oraclePs.setCustomDatumAtName(paramString, paramCustomDatum);
		
	}

	@Override
	public void setORADataAtName(String paramString, ORAData paramORAData)
			throws SQLException {
		oraclePs.setORADataAtName(paramString, paramORAData);
		
	}

	@Override
	public void setObjectAtName(String paramString, Object paramObject,
			int paramInt1, int paramInt2) throws SQLException {
		oraclePs.setObjectAtName(paramString, paramObject, paramInt1, paramInt2);
		
	}

	@Override
	public void setObjectAtName(String paramString, Object paramObject,
			int paramInt) throws SQLException {
		oraclePs.setObjectAtName(paramString, paramObject, paramInt );
		
	}

	@Override
	public void setRefTypeAtName(String paramString, REF paramREF)
			throws SQLException {
		oraclePs.setRefTypeAtName(paramString, paramREF);
		
	}

	@Override
	public void setRefAtName(String paramString, Ref paramRef)
			throws SQLException {
		oraclePs.setRefAtName(paramString, paramRef);
		
	}

	@Override
	public void setREFAtName(String paramString, REF paramREF)
			throws SQLException {
		oraclePs.setREFAtName(paramString, paramREF);
		
	}

	@Override
	public void setObjectAtName(String paramString, Object paramObject)
			throws SQLException {
		oraclePs.setObjectAtName(paramString, paramObject);
		
	}

	@Override
	public void setOracleObjectAtName(String paramString, Datum paramDatum)
			throws SQLException {
		oraclePs.setOracleObjectAtName(paramString, paramDatum);
		
	}

	@Override
	public void setURLAtName(String paramString, URL paramURL)
			throws SQLException {
		oraclePs.setURLAtName(paramString, paramURL);
		
	}

	@Override
	public void setCheckBindTypes(boolean paramBoolean) {
		oraclePs.setCheckBindTypes(paramBoolean);
		
	}

	@Override
	public void setPlsqlIndexTable(int paramInt1, Object paramObject,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5)
			throws SQLException {
		oraclePs.setPlsqlIndexTable(paramInt1, paramObject, paramInt2, paramInt3, paramInt4, paramInt5);
		
	}

	@Override
	public void setFormOfUse(int paramInt, short paramShort) {
		oraclePs.setFormOfUse(paramInt, paramShort);
		
	}

	@Override
	public void setDisableStmtCaching(boolean paramBoolean) {
		oraclePs.setDisableStmtCaching(paramBoolean);
		
	}

	@Override
	public OracleParameterMetaData OracleGetParameterMetaData()
			throws SQLException {
		
		return oraclePs.OracleGetParameterMetaData();
	}

	@Override
	public void registerReturnParameter(int paramInt1, int paramInt2)
			throws SQLException {
		oraclePs.registerReturnParameter(paramInt1, paramInt2);
		
	}

	@Override
	public void registerReturnParameter(int paramInt1, int paramInt2,
			int paramInt3) throws SQLException {
		oraclePs.registerReturnParameter(paramInt1, paramInt2, paramInt3);
		
	}

	@Override
	public void registerReturnParameter(int paramInt1, int paramInt2,
			String paramString) throws SQLException {
		oraclePs.registerReturnParameter(paramInt1, paramInt2, paramString);
		
	}

	@Override
	public ResultSet getReturnResultSet() throws SQLException {
		return oraclePs.getReturnResultSet();
	}

	@Override
	public void setNCharacterStreamAtName(String paramString,
			Reader paramReader, long paramLong) throws SQLException {
		oraclePs.setNCharacterStreamAtName(paramString, paramReader, paramLong);
		
	}

	@Override
	public void setNCharacterStreamAtName(String paramString, Reader paramReader)
			throws SQLException {
		oraclePs.setNCharacterStreamAtName(paramString, paramReader);
		
	}

	@Override
	public void setNClobAtName(String paramString, NClob paramNClob)
			throws SQLException {
		oraclePs.setNClobAtName(paramString, paramNClob);
		
	}

	@Override
	public void setNClobAtName(String paramString, Reader paramReader,
			long paramLong) throws SQLException {
		oraclePs.setNClobAtName(paramString, paramReader, paramLong);
		
	}

	@Override
	public void setNClobAtName(String paramString, Reader paramReader)
			throws SQLException {
		oraclePs.setNClobAtName(paramString, paramReader);
		
	}

	@Override
	public void setNStringAtName(String paramString1, String paramString2)
			throws SQLException {
		oraclePs.setNStringAtName(paramString1, paramString2);
		
	}

	@Override
	public void setRowIdAtName(String paramString, RowId paramRowId)
			throws SQLException {
		oraclePs.setRowIdAtName(paramString, paramRowId);
		
	}

	@Override
	public void setSQLXMLAtName(String paramString, SQLXML paramSQLXML)
			throws SQLException {
		oraclePs.setSQLXMLAtName(paramString, paramSQLXML);
	}

    @Override
    protected ResultSet wrapResultSet(JdbcEvent jdbcEvent,
    		ResultSet executeQuery, String ref) {
        if (executeQuery instanceof OracleResultSet)
        {
			return WrappedOracleStatement.wrapOracleResultSet(
					(OracleResultSet) executeQuery, ref, jdbcEvent, this);
        }

        return super.wrapResultSet(jdbcEvent, executeQuery, ref);
    }
}
