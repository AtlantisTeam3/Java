/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.integration;

import com.alantis.domain.Device;
import com.alantis.domain.Value;
import com.atlantis.Database.ConnectionDataBase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
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
public class MapDeviceDataDAO implements DeviceDataDAO {
    @EJB
    ConnectionDataBase Mongo;
    
    //MPobile
    //Recupération all device for 1 user
    @Override
    public List<Device> getDeviceMobile(String Id_user) {
        
        List<Device> devices =new ArrayList();

        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("device");
        System.out.println(Id_user);
        FindIterable<Document>listdevice = collection.find(eq("id_user",Id_user));

        
        for (Document doc : listdevice) {
            Device device = new Device();
            Value value = new Value();
            //device_id
            device.setDevice_mac(doc.getString("id_device"));
            System.out.println(device.getDevice_mac());
            //device_name
            device.setDevice_name(doc.getString("name_device"));
            //device_type
            device.setType(doc.getString("type_device"));
            //dernière valeur enregistrer
            
            List<Document> metrics = (List<Document>) doc.get("values");
            for(Document valeur : metrics){
            value.setValue(valeur.getString("metrics"));}
            
            device.setValue(value);
            devices.add(device);
        }
        return devices;
    }
    
    //Change name of device
    @Override
    public boolean changeName(String id_device, String new_name){
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("device");
        UpdateResult Ischange = collection.updateOne(eq("id_device", id_device),set("name_device", new_name) );
        return Ischange.getMatchedCount() != 0;
    }
    
    //Collecte all value for one device
    @Override
    public List<Value> getData(String id_device){
        List<Value> devicesdata =new ArrayList();
        
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("device");
        
        FindIterable<Document>listdevice = collection.find(eq("id_device",id_device));
        
        for (Document doc : listdevice) {
            
            
            List<Document> metrics = (List<Document>) doc.get("values");
            metrics.stream().map((valeur) -> {
                Value value = new Value();
                value.setValue(valeur.getString("metrics"));
                value.setDateTime(valeur.getString("date_metrics"));
                return value;
            }).forEachOrdered((value) -> {
                devicesdata.add(value);
            });
            
        }
        
        return devicesdata;
    }
    
    //Backoffice
    @Override
    public List<Device> getListAllDevice (){
        List<Device> devices =new ArrayList();

        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("device");
        
        FindIterable<Document>listdevice = collection.find();

        
        for (Document doc : listdevice) {
            Device device = new Device();
            //device_id
            device.setDevice_mac(doc.getString("id_device"));
            //device_name
            device.setDevice_name(doc.getString("name_device"));
            //device_type
            device.setType(doc.getString("type_device"));
            //id_user
            device.setUser(doc.getString("id_user"));
            devices.add(device);
        }
        return devices;
    }
    
    @Override
    public boolean changeUserDevice (String id_device, String id_user){
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("device");
        UpdateResult Ischange = collection.updateOne(eq("id_device", id_device),set("id_user", id_user) );
        return Ischange.getMatchedCount() != 0;
    }
}
