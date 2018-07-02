/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.Database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import javax.annotation.PostConstruct;
import javax.ejb.*;

/**
 *
 * @author cesi
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ConnectionDataBase {
    
    private MongoClient mongoClient = null;
    
    @Lock(LockType.READ)
	public MongoClient getMongoClient(){	
		return mongoClient;
	}
	
	@PostConstruct
	public void init() {
		
            mongoClient = MongoClients.create(); 
	}
    
    
}
