/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.facade;

import javax.ejb.Remote;

/**
 *
 * @author cesi
 */
@Remote
public interface BackofficeRemote {
    public boolean validationPermission(String id_user,String password);
}
