/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.facade;

import com.alantis.domain.Device;
import com.alantis.domain.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author cesi
 */
@Remote
public interface BackofficeRemote {
    public boolean validationPermission(String id_user,String password);
    public List<Device> getListAllDevice();
    public List<User> getListAllUser();
    public boolean changeUserDevice(String id_device,String id_user);
    public void test();
}
