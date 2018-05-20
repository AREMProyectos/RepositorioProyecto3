/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.dianfacturaelectronica.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Juan David
 */
public class Bill {

    private int id;
    private String date;
    private String nameEmployee;
    private long idEmployee;
    private long companysNit;
    private long companysPhone;
    private String consumerName;
    private long consumerId;
    private long consumerPhone;
    private String consumerEmail;
    private float purchasePrice;
    private float ivaPrice;
    private float total;
    public static final int IVA_PERCENTAGE = 19;

    public Bill() {
    }

    public Bill(String nameEmployee,
            long idEmployee,
            long companysNit,
            long companysPhone,
            String consumerName,
            long consumerId,
            long consumerPhone,
            String consumerEmail,
            float purchasePrice) {
        this.date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.nameEmployee = nameEmployee;
        this.idEmployee = idEmployee;
        this.companysNit = companysNit;
        this.companysPhone = companysPhone;
        this.consumerName = consumerName;
        this.consumerId = consumerId;
        this.consumerPhone = consumerPhone;
        this.consumerEmail = consumerEmail;
        this.purchasePrice = purchasePrice;
        this.ivaPrice = (this.purchasePrice * IVA_PERCENTAGE) / 100;
        this.total = this.purchasePrice + this.ivaPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public long getCompanysNit() {
        return companysNit;
    }

    public void setCompanysNit(long companysNit) {
        this.companysNit = companysNit;
    }

    public long getCompanysPhone() {
        return companysPhone;
    }

    public void setCompanysPhone(long companysPhone) {
        this.companysPhone = companysPhone;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(long consumerId) {
        this.consumerId = consumerId;
    }

    public long getConsumerPhone() {
        return consumerPhone;
    }

    public void setConsumerPhone(long consumerPhone) {
        this.consumerPhone = consumerPhone;
    }

    public String getConsumerEmail() {
        return consumerEmail;
    }

    public void setConsumerEmail(String consumerEmail) {
        this.consumerEmail = consumerEmail;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getIvaPrice() {
        return ivaPrice;
    }

    public void setIvaPrice(float ivaPrice) {
        this.ivaPrice = ivaPrice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

   
    
    

}
