/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.facade;

import com.alantis.domain.User;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author cesi
 */
@javax.ejb.Remote
public interface MobileServiceRemote {    
    //public boolean saveData(String user);
    public List<User> getListDevice(String id_user);
    
}
