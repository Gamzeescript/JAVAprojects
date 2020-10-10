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
public class InventarioBean {
    
    private int idinventario;
    private ProveedorBean idproveedor; 
    private JoyeriaBean idjoyeria; 
    private RopaBean idropa; 
    private DepartamentoBean iddepartamento; 
    private int existencia; 
    private int stock; 
    private Date fecha_entrada;
    private Date fecha_salida; 

    public InventarioBean(int idinventario) {
        this.idinventario = idinventario;
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public ProveedorBean getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(ProveedorBean idproveedor) {
        this.idproveedor = idproveedor;
    }

    public JoyeriaBean getIdjoyeria() {
        return idjoyeria;
    }

    public void setIdjoyeria(JoyeriaBean idjoyeria) {
        this.idjoyeria = idjoyeria;
    }

    public RopaBean getIdropa() {
        return idropa;
    }

    public void setIdropa(RopaBean idropa) {
        this.idropa = idropa;
    }

    public DepartamentoBean getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(DepartamentoBean iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
    

    }