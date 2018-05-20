/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.security;

import co.edu.escuelaing.arem.dianfacturaelectronica.security.authentication.AuthenticationValidate;
import co.edu.escuelaing.arem.dianfacturaelectronica.security.authorization.AuthorizationValidate;
import java.util.HashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author andres
 */
@Service
public class securityGuard implements Guard{
    
    
    private AuthenticationValidate authentication=new AuthenticationValidate();
    private AuthorizationValidate authorization = new AuthorizationValidate();
    RequestAction ra= null;
    
    public securityGuard(){
    
    }
    
    @Override
    public String authenticate(RequestAction ra) throws SecurityException {
        String permission=null;
        boolean resp =authentication.authenticate(ra);
        if(resp)
            permission=authorization(ra);

        return permission;
    }

    @Override
    public String  authorization(RequestAction ra) throws SecurityException {
        return authorization.getPermissions(ra);   
    }
    
}
