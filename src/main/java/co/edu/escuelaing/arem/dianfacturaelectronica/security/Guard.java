/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.security;
/**
 *
 * @author monitor
 */
public interface Guard {
    void authenticate(RequestAction ra) throws SecurityException;
    void authorization(RequestAction ra) throws SecurityException;
}
