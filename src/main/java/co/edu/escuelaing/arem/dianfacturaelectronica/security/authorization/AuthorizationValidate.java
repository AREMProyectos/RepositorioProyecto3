/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.security.authorization;

import co.edu.escuelaing.arem.dianfacturaelectronica.security.RequestAction;
import java.util.HashMap;

/**
 *
 * @author andres
 */
public class AuthorizationValidate {
    private HashMap<String,String> typesOfUsers;
    private HashMap<String,String> permissions;
    
    public AuthorizationValidate(){
        typesOfUsers=new HashMap<>();
        permissions=new HashMap<>();
        typesOfUsers.put("toyota","company");
        typesOfUsers.put("cinecolombia","company");
        permissions.put("company","billGenerator");
    }
    
    public String getPermissions(RequestAction ra){
        return permissions.get(typesOfUsers.get(ra.getUserName()));
    }
}
