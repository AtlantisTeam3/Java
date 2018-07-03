/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.facade;

import com.alantis.domain.Device;
import com.alantis.domain.User;
import com.alantis.domain.Value;
import java.util.List;

/**
 *
 * @author cesi
 */
@javax.ejb.Remote
public interface MobileServiceRemote {    
    //public boolean saveData(String user);
    public List<Device> getListDevice(String id_user);

    public User getInfoUser(String id_user);
    
    public boolean changeNameDevice(String id_device, String name_device);
    
    public List<Value> getDatatDevice(String id_device);
}
