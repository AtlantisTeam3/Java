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
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Sorts;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Iterator;
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

    //Recupération all device pour 1 user
    @Override
    public List<Device> getDevice(String Id_user) {
        
        List<Device> devices =new ArrayList();
        Device device = new Device();
        Value value = new Value();
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("device");
        //MongoCollection<Document> listedevice = collection.aggregate(.match(eq("id_user",Id_user)));
        FindIterable<Document>listdevice = collection.find(eq("id_user",Id_user));//.sort(Sorts.ascending("values.date_metrics"));
        System.out.println("*************************************************************************");
        
        for (Document doc : listdevice) {
            //device_id
            device.setDevice_mac(doc.getString("id_device"));
            //device_name
            device.setDevice_name(doc.getString("name_device"));
            //device_type
            device.setType(doc.getString("type_device"));
            //dernière valeur enregistrer
            List<Document> metrics = (List<Document>) doc.get("values");
           /// value.setValue(metrics.getString(metrics.size()-1));
            devices.add(device);
        }
        return devices;
    }
    
    @Override
    public boolean changeName(String id_device, String new_name){
        MongoClient mongoClient = Mongo.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");
        UpdateResult Ischange = collection.updateOne(eq("Id_device", id_device),set("name device", new_name) );
        if(Ischange.getMatchedCount()==0){
            return false;
        }else{
            return true;
        }
    }
}
