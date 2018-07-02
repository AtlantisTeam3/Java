/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.facade;

import com.atlantis.Database.ConnectionDataBase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.bson.Document;

/**
 *
 * @author cesi
 */
@Stateless
public class BackofficeBean implements BackofficeRemote{
    @EJB
    ConnectionDataBase Mongo;
    
    @Override
    public boolean validationPermission(String id_user,String password){
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");
        long result = collection.count(and(eq("user",id_user),eq("password",password)));
        return result != 0;
    }
}
