/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.security;

import co.edu.escuelaing.arem.dianfacturaelectronica.security.authentication.AuthenticationValidate;
import java.util.HashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author andres
 */
@Service
public class securityGuard implements Guard{
    
    
    private AuthenticationValidate authentication=new AuthenticationValidate();
    
    public securityGuard(){
    
    }
    @Override
    public void authenticate(RequestAction ra) throws SecurityException {
       boolean resp =authentication.authenticate(ra);
       if(resp)
           authorization(ra);
    }

    @Override
    public void authorization(RequestAction ra) throws SecurityException {
        
    }
    
}
