/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.security;

/**
 *
 * @author andres
 */
public class RequestAction {
    private String userName;
    private String passwd;
    private String clientType=null;
    
    public RequestAction(){
        
    }
    
    public RequestAction(String userName,String passwd){
        this.userName = userName;
        this.passwd= passwd;
    }
    
    public String getUserName(){
        return userName;
    }
    public String getPasswd(){
        return passwd;
    }
    public String getClientType(){
        return clientType;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setPasswd(String passwd){
        this.passwd=passwd;
    }
    public void setClientType(String clientType){
        this.clientType=clientType;
    }
    
}
