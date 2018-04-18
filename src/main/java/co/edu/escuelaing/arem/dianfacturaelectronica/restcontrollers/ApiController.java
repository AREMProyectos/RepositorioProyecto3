/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.restcontrollers;

import co.edu.escuelaing.arem.dianfacturaelectronica.model.Bill;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2110805
 */
@Service
@RestController
@RequestMapping(value = "/bills")
public class ApiController {

    public static final String HEROKU_LINK = "falta.herokuapp.com?id={id}";

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addOrder(@RequestBody Bill bill) {
        try {
            String alteredHerokuLink = HEROKU_LINK.replace("{id}", bill.getId() + "");
            //URL link = new URL(alteredHerokuLink);

            PrintWriter writer = new PrintWriter("bill.json");
            writer.println("ITS WORKING");
            /*try (BufferedReader reader
                    = new BufferedReader(new InputStreamReader(link.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    writer.println(inputLine);
                }
            } catch (IOException x) {
                System.err.println(x);
            }*/
            writer.close();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(ApiController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

}
