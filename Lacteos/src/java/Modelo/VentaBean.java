/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Michelle Giron
 */
public class VentaBean {
    
    private int idventa;
    private ClienteBean idcliente;
    private LacteoBean idlacteo;
    private double precio;
    private Date fecha;

    public VentaBean(int idventa) {
        this.idventa = idventa;
    }

    public VentaBean() {
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public ClienteBean getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(ClienteBean idcliente) {
        this.idcliente = idcliente;
    }

    public LacteoBean getIdlacteo() {
        return idlacteo;
    }

    public void setIdlacteo(LacteoBean idlacteo) {
        this.idlacteo = idlacteo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
}
