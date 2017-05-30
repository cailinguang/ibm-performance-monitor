/*
 * #%L
 * IBM 10x
 * 
 * IBM Confidential
 * OCO Source Materials
 * %%
 * Copyright (C) 2013 - 2015 IBM Corp.
 * %%
 * The source code for this program is not published or otherwise divested of
 * its trade secrets, irrespective of what has been deposited with the U.S.
 * Copyright Office.  IBM and the IBM logo are trademarks of IBM Corporation
 * in the United States other countries, or both.  Java and all Java-based
 * trademarks and logos are trademarks or registered trademarks of Oracle
 * and/or its affiliates. Other company, product or service names may be
 * trademarks or service marks of others.
 * #L%
 */
package com.ibm.profiler.mongo;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import com.ibm.commerce.cache.CacheUtilities;
import com.ibm.commerce.cache.OperationMetric;
import com.ibm.service.detailed.MongoLogger;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.CreateViewOptions;

/**
 * ProfiledMongoDatabase
 * 
 * @author Steve McDuff
 */
public class ProfiledMongoDatabase implements MongoDatabase
{
    private final MongoDatabase database;

    public ProfiledMongoDatabase(MongoDatabase database)
    {
        this.database = database;
    }

    @Override
    public String getName()
    {
        return database.getName();
    }

    @Override
    public CodecRegistry getCodecRegistry()
    {
        return database.getCodecRegistry();
    }

    @Override
    public ReadPreference getReadPreference()
    {
        return database.getReadPreference();
    }

    @Override
    public WriteConcern getWriteConcern()
    {
        return database.getWriteConcern();
    }

    @Override
    public ReadConcern getReadConcern()
    {
        return database.getReadConcern();
    }

    @Override
    public MongoDatabase withCodecRegistry(CodecRegistry codecRegistry)
    {
        return new ProfiledMongoDatabase(database.withCodecRegistry(codecRegistry));
    }

    @Override
    public MongoDatabase withReadPreference(ReadPreference readPreference)
    {
        return new ProfiledMongoDatabase(database.withReadPreference(readPreference));
    }

    @Override
    public MongoDatabase withWriteConcern(WriteConcern writeConcern)
    {
        return new ProfiledMongoDatabase(database.withWriteConcern(writeConcern));
    }

    @Override
    public MongoDatabase withReadConcern(ReadConcern readConcern)
    {
        return new ProfiledMongoDatabase(database.withReadConcern(readConcern));
    }

    @Override
    public MongoCollection<Document> getCollection(String collectionName)
    {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return new ProfiledMongoCollection<Document>(collection);
    }

    @Override
    public <TDocument> MongoCollection<TDocument> getCollection(String collectionName, Class<TDocument> documentClass)
    {
        MongoCollection<TDocument> collection = database.getCollection(collectionName, documentClass);
        return new ProfiledMongoCollection<TDocument>(collection);
    }

    protected OperationMetric startMetric(String function, List<String> keyValuePairs)
    {

        if (!MongoLogger.GATHERER.isEnabled())
        {
            return null;
        }

        OperationMetric metric = new OperationMetric();

        metric.startOperation(function, false);
        metric.setKeyValuePairList(keyValuePairs);
        addDatabaseInformation(metric);

        MongoLogger.GATHERER.gatherMetricEntryLog(metric);

        return metric;
    }

    public void addDatabaseInformation(OperationMetric metric)
    {
        metric.setProperty(MongoProperties.MONGO_DATABASE, getName());
    }

    protected void stopMetric(OperationMetric metric, int resultSize)
    {
        if (metric == null)
        {
            return;
        }
        metric.stopOperation(resultSize, false);
        MongoLogger.GATHERER.gatherMetric(metric);
    }

    @Override
    public Document runCommand(Bson command)
    {
        OperationMetric metric = null;

        if (MongoLogger.GATHERER.isEnabled())
        {
            metric = startMetric("runCommand", Arrays.asList("command", command.toString()));
        }
        Document runCommand = database.runCommand(command);
        int resultSize = 0;
        if (MongoLogger.isResultSetSizeMeasured())
        {
            resultSize = CacheUtilities.safeToString(runCommand).length();
        }
        stopMetric(metric, resultSize);
        return runCommand;
    }

    @Override
    public Document runCommand(Bson command, ReadPreference readPreference)
    {
        OperationMetric metric = null;

        if (MongoLogger.GATHERER.isEnabled())
        {
            metric = startMetric("runCommand", Arrays.asList("command", command.toString()));
        }
        Document runCommand = database.runCommand(command, readPreference);
        int resultSize = 0;
        if (MongoLogger.isResultSetSizeMeasured())
        {
            resultSize = CacheUtilities.safeToString(runCommand).length();
        }
        stopMetric(metric, resultSize);
        return runCommand;
    }

    @Override
    public <TResult> TResult runCommand(Bson command, Class<TResult> resultClass)
    {
        OperationMetric metric = null;

        if (MongoLogger.GATHERER.isEnabled())
        {
            metric = startMetric("runCommand", Arrays.asList("command", command.toString()));
        }
        TResult runCommand = database.runCommand(command, resultClass);
        int resultSize = 0;
        if (MongoLogger.isResultSetSizeMeasured())
        {
            resultSize = CacheUtilities.safeToString(runCommand).length();
        }
        stopMetric(metric, resultSize);
        return runCommand;
    }

    @Override
    public <TResult> TResult runCommand(Bson command, ReadPreference readPreference, Class<TResult> resultClass)
    {
        OperationMetric metric = null;

        if (MongoLogger.GATHERER.isEnabled())
        {
            metric = startMetric("runCommand", Arrays.asList("command", command.toString()));
        }
        TResult runCommand = database.runCommand(command, readPreference, resultClass);
        int resultSize = 0;
        if (MongoLogger.isResultSetSizeMeasured())
        {
            resultSize = CacheUtilities.safeToString(runCommand).length();
        }
        stopMetric(metric, resultSize);
        return runCommand;
    }

    @Override
    public void drop()
    {
        database.drop();
    }

    @Override
    public MongoIterable<String> listCollectionNames()
    {
        return database.listCollectionNames();
    }

    @Override
    public ListCollectionsIterable<Document> listCollections()
    {
        return database.listCollections();
    }

    @Override
    public <TResult> ListCollectionsIterable<TResult> listCollections(Class<TResult> resultClass)
    {
        return database.listCollections(resultClass);
    }

    @Override
    public void createCollection(String collectionName)
    {
        database.createCollection(collectionName);
    }

    @Override
    public void createCollection(String collectionName, CreateCollectionOptions createCollectionOptions)
    {
        database.createCollection(collectionName, createCollectionOptions);
    }

    @Override
    public void createView(String viewName, String viewOn, List<? extends Bson> pipeline)
    {
        database.createView(viewName, viewOn, pipeline);
    }

    @Override
    public void createView(String viewName, String viewOn, List<? extends Bson> pipeline,
        CreateViewOptions createViewOptions)
    {
        database.createView(viewName, viewOn, pipeline, createViewOptions);
    }
}
