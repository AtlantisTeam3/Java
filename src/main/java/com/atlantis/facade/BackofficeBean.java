/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.facade;

import com.alantis.domain.Device;
import com.alantis.domain.User;
import com.atlantis.Database.ConnectionDataBase;
import com.atlantis.integration.DeviceDataDAO;
import com.atlantis.integration.UserDataDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.rabbitmq.client.*;
import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.bson.Document;

/**
 *
 * @author cesi
 */
@Stateless
public class BackofficeBean implements BackofficeRemote{
    private final static String QUEUE_NAME = "hello";
    
    @EJB
    ConnectionDataBase Mongo;
    
    @Inject
    private DeviceDataDAO DeviceData;
    
    @Inject
    private UserDataDAO UserData;
     
    //Check name and password for connection backoffive 
    @Override
    public boolean validationPermission(String id_user,String password){
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");
        long result = collection.count(and(eq("name",id_user),eq("password",password)));
        return result != 0;
    }
    
    //Collect all user for backoffice
    @Override
    public List<User> getListAllUser(){
        return UserData.getUser();
    }
    //Collect all devices for backoffice
    @Override
    public List<Device> getListAllDevice(){
        return DeviceData.getListAllDevice();
    }
    
    //atribute a device to a user
    @Override
    public boolean changeUserDevice(String id_device,String id_user){
        return DeviceData.changeUserDevice(id_device, id_user) ;
    }
    
    
    
    @Override
    public void test() {
//        try {
            ConnectionFactory factory = new ConnectionFactory();
//            factory.setUsername("guest");
//            factory.setPassword("guest");
//            factory.setVirtualHost("/");
//            factory.setHost("127.0.0.1");
//            factory.setPort(5672);
//             Connection conn = null;
//            try {
////                conn = factory.newConnection();
//            } catch (TimeoutException ex) {
//                Logger.getLogger(BackofficeBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Channel channel = conn.createChannel();
//            String exchangeName = "myExchange";
//            String routingKey = "testRoute";
//            byte[] messageBodyBytes = "Hello, world!".getBytes();
//            channel.basicPublish(exchangeName, routingKey,MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes) ;
//            try {
//                channel.close();
//            } catch (TimeoutException ex) {
//                Logger.getLogger(BackofficeBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            conn.close();
//        } catch (IOException ex) {
//            Logger.getLogger(BackofficeBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
