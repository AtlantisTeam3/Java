/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.integration;

import com.alantis.domain.User;
import com.atlantis.Database.ConnectionDataBase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import org.bson.Document;

/**
 *
 * @author cesi
 */
@ApplicationScoped
public class MapUserDataDAO implements UserDataDAO {
    
    @EJB
    ConnectionDataBase Mongo;
    
    @Override
    public  List<User> getUser(){
        
        List<User> users = new ArrayList<>();
        
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");
        
        
        FindIterable<Document>  device = collection.find();
        
        for(Document doc :device){
            User user=new User();
            user.setName(doc.getString("name"));
            
            user.setId_user(doc.getString("id_user"));
            
            users.add(user);
        }
        
        return users;
    }
    
    @Override
    public User getUserData (String id_user){   
        User user=new User();
        
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");
        FindIterable<Document> doc = collection.find(eq("id_user",id_user));
        for(Document info :doc){
        user.setName(info.getString("name"));
        user.setEmail(info.getString("email"));
        }
        return user;
    }
    
}
