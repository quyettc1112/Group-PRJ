/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.dto;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Categories implements Serializable{
    private int CateId;
    private String CateName;

    public Categories() {
    }

    public Categories(int CateId, String CateName) {
        this.CateId = CateId;
        this.CateName = CateName;
    }

    
    public int getCateId() {
        return CateId;
    }

    public void setCateId(int CateId) {
        this.CateId = CateId;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }
    
    
}
