/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.restcontrollers;

import co.edu.escuelaing.arem.dianfacturaelectronica.model.Bill;
import static co.edu.escuelaing.arem.dianfacturaelectronica.model.Bill.IVA_PERCENTAGE;
import co.edu.escuelaing.arem.dianfacturaelectronica.security.Guard;
import co.edu.escuelaing.arem.dianfacturaelectronica.security.RequestAction;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/sesion")
public class ApiController {
    
     @Autowired
        private Guard secGuard;

    private static int idBill = 1;

    public static final String HEROKU_LINK = "https://restapidianform.herokuapp.com/bill?";
        
    @RequestMapping(method = RequestMethod.POST, path="/bills")
    public ResponseEntity<?> addOrder(@RequestBody Bill bill) {
        try {
            bill.setIvaPrice((bill.getPurchasePrice() * Bill.IVA_PERCENTAGE) / 100);
            bill.setId(idBill);
            bill.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            bill.setTotal(bill.getPurchasePrice() + bill.getIvaPrice());
            String herokuQueryLink = "id="+bill.getId()
                    +"&date="+bill.getDate()
                    +"&nameEmployee="+bill.getNameEmployee()
                    +"&idEmployee="+bill.getIdEmployee()
                    +"&companysNit="+bill.getCompanysNit()
                    +"&companysPhone="+bill.getCompanysPhone()
                    +"&consumerName="+bill.getConsumerName()
                    +"&consumerId="+bill.getConsumerId()
                    +"&consumerPhone="+bill.getConsumerPhone()
                    +"&consumerEmail="+bill.getConsumerEmail()
                    +"&purchasePrice="+bill.getPurchasePrice()
                    +"&ivaPercentage="+Bill.IVA_PERCENTAGE
                    +"&ivaPrice="+bill.getIvaPrice()
                    +"&total="+bill.getTotal();
            
            idBill++;
            URL link = new URL(HEROKU_LINK+herokuQueryLink.replace("/", "%2f").replace(" ", "%20").replace(":", "%3a"));

            File file = new File("target/classes/static/bill.json");
            file.getParentFile().mkdirs();

            PrintWriter writer = new PrintWriter(file);
            //writer.println(bill.getId());
            try (BufferedReader reader
                    = new BufferedReader(new InputStreamReader(link.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    writer.println(inputLine);
                }
            } catch (IOException x) {
                System.err.println(x);
            }
            writer.close();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(ApiController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
        }

    }
    
            
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addSesion(@RequestBody RequestAction ra) throws co.edu.escuelaing.arem.dianfacturaelectronica.security.SecurityException {
        System.out.println("entra");
        secGuard.authenticate(ra);
        return new ResponseEntity<> ("ok",HttpStatus.OK);
    }

    


}
