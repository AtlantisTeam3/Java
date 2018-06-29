/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.facade;




import com.alantis.domain.User;
import com.atlantis.integration.UserDataDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.bson.Document;



/**
 *
 * @author cesi
 */
@Stateless
public class MobileServiceBean implements MobileServiceRemote  {
    
    @Inject
    private UserDataDAO UserData;
    
    
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
    public List<User> getListDevice(String id_user){
        return UserData.getUser(id_user);    
    }
    
//    @Override
//    public static List<> getListDevice(String id_user,){
//        
//        
//    }
}


