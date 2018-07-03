/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.integration;

import com.alantis.domain.Device;
import com.alantis.domain.Value;
import java.util.List;

/**
 *
 * @author cesi
 */
public interface DeviceDataDAO {
    public List<Device> getDeviceMobile(String Id_user);
    public boolean changeName(String id_device, String new_name);
    public List<Device> getListAllDevice ();
    public List<Value> getData(String id_device);
    public boolean changeUserDevice (String id_device, String id_user);
}
