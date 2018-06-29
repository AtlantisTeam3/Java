/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.integration;

import com.alantis.domain.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.bson.Document;

/**
 *
 * @author cesi
 */
@ApplicationScoped
public class MapUserDataDAO implements UserDataDAO {
    
    @Override
    public  List<User> getUser(String Id_user){
        List<User> users = new ArrayList<>();
        User user=new User();
        
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");
        FindIterable<Document>  device = collection.find(eq("id_user",Id_user));
        System.out.println("******************************************************************************");
        for(Document doc :device){
            user.setName(doc.getString("name"));
            System.out.println(user.getName());
            
            user.setId_user(doc.getString("id_user"));
            System.out.println(user.getName());
            
            user.setEmail(doc.getString("email"));
            System.out.println(user.getName());
            
            user.setPassword(doc.getString("password"));
            System.out.println(user.getName());
            
            users.add(user);
            System.out.println(users.toString());
            System.out.println("--------------------------------------------------------------------------");
        }
        System.out.println("******************************************************************************");
        return users;
    }
    
}
