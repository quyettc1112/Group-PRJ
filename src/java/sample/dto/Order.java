/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Order implements Serializable{
    private int orderID;
    private Date oderDate;
    private Date shopDate;
    private int status;
    private int accID;
    private String fullname;
    public Order() {
    }

    public Order(int orderID, Date oderDate, Date shopDate, int status, int accID) {
        this.orderID = orderID;
        this.oderDate = oderDate;
        this.shopDate = shopDate;
        this.status = status;
        this.accID = accID;
    }

    public Order(int orderID, Date oderDate, Date shopDate, int status, int accID, String fullname) {
        this.orderID = orderID;
        this.oderDate = oderDate;
        this.shopDate = shopDate;
        this.status = status;
        this.accID = accID;
        this.fullname = fullname;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOderDate() {
        return oderDate;
    }

    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    public Date getShopDate() {
        return shopDate;
    }

    public void setShopDate(Date shopDate) {
        this.shopDate = shopDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", oderDate=" + oderDate + ", shopDate=" + shopDate + ", status=" + status + ", accID=" + accID + ", fullname=" + fullname + '}';
    }
    
    
}
