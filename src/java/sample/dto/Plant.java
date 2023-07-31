/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Plant implements Serializable{
    private  int id;
    private String name;
    private int price;
    private String imgpath;
    private String description;
    private int status;
    private int cateid;
    private String catename;

    public Plant() {
        
    }

    public Plant(int id, String name, int price, String imgpath, String description, int status, int cateid, String catename) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgpath = imgpath;
        this.description = description;
        this.status = status;
        this.cateid = cateid;
        this.catename = catename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    @Override
    public String toString() {
        return "Plant{" + "id=" + id + ", name=" + name + ", price=" + price + ", imgpath=" + imgpath + ", description=" + description + ", status=" + status + ", cateid=" + cateid + ", catename=" + catename + '}';
    }
    
    
    
}
