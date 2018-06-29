/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.integration;

import com.alantis.domain.User;
import java.util.List;

/**
 *
 * @author cesi
 */
public interface UserDataDAO {
    public  List<User> getUser(String Id_user);
}
