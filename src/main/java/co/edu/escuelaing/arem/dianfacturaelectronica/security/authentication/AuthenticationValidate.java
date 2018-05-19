/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.security.authentication;

import co.edu.escuelaing.arem.dianfacturaelectronica.security.RequestAction;
import java.util.HashMap;

/**
 *
 * @author andres
 */
public class AuthenticationValidate {
    
    private HashMap<String,String> users = new HashMap<>();
        
    public AuthenticationValidate(){
        users.put("toyota","-926002285");
        users.put("cinecolombia","-854841508");
    }
    
    public boolean authenticate(RequestAction ra) throws co.edu.escuelaing.arem.dianfacturaelectronica.security.SecurityException {
        boolean allow= false;
        if(users.get(ra.getUserName()).equals(ra.getPasswd())){
            allow=true;
        }
        return allow;
    }
}
