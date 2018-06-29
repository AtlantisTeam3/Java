/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.facade;




import com.alantis.domain.Device;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import javax.ejb.Stateless;
import org.bson.Document;



/**
 *
 * @author cesi
 */
@Stateless
public class MobileServiceBean implements MobileServiceRemote  {
    
//    @Override
//    public boolean saveData(String user){
//        MongoClient mongoClient = MongoClients.create();
//        MongoDatabase database = mongoClient.getDatabase("test");
//        
//        MongoCollection<Document> collection = database.getCollection("test");
//        
//        //Trouver et update document ou créer un si non présent
//        UpdateResult Ispresents = collection.updateOne(eq("Id_user", user),combine(set("user", user) ));
//    
//        if(Ispresents.getMatchedCount()==0){
//            //Ajouter document
//            Document document = new Document("Id_user", user);
//               /*.append("contact", new Document("phone", "228-555-0149")
//                                       .append("email", "cafeconleche@example.com")
//                                       .append("location",Arrays.asList(-73.92502, 40.8279556)))
//               .append("stars", 3)
//               .append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));*/
//
//        collection.insertOne(document);
//        }
//        
//        
//        
//        
//        return true;
//    }
    
    @Override
    public FindIterable<Document> getListDevice(String id_user){
//        MongoClient mongoClient = MongoClients.create();
//        MongoDatabase database = mongoClient.getDatabase("test");
//        MongoCollection<Document> collection = database.getCollection("test");
//        
//        FindIterable<Document> device = collection.find(eq("user","user"));
//        List<Document> device =new ArrayList<>(device);
        return null;
        
    }
}


