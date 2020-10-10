/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Michelle Giron
 */
public class LacteoBean {
    
     private int idlacteo;
     private String nombrelacteo;

    public LacteoBean(int idlacteo) {
        this.idlacteo = idlacteo;
    }

    public LacteoBean() {
    }

    public int getIdlacteo() {
        return idlacteo;
    }

    public void setIdlacteo(int idlacteo) {
        this.idlacteo = idlacteo;
    }

    public String getNombrelacteo() {
        return nombrelacteo;
    }

    public void setNombrelacteo(String nombrelacteo) {
        this.nombrelacteo = nombrelacteo;
    }
     
     
    
}
