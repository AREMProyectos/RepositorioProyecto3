/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.security;

import org.springframework.stereotype.Service;

/**
 *
 * @author andres
 */
@Service
public class securityGuard implements Guard{


    @Override
    public void authenticate(RequestAction ra) throws SecurityException {
        System.out.println(ra.getPasswd());
       
    }
    
}
