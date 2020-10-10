
package Modelo;

public class RopaBean {
    
    private int idropa; 
    private MarcaBean idmarca; 
    private TallaBean idtalla ;
    private ProveedorBean idproveedor;
    private DepartamentoBean iddepartamento;
    private String nombre;  
    private Double precio;

    public RopaBean(int idropa) {
        this.idropa = idropa;
    }

    public int getIdropa() {
        return idropa;
    }

    public void setIdropa(int idropa) {
        this.idropa = idropa;
    }

    public MarcaBean getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(MarcaBean idmarca) {
        this.idmarca = idmarca;
    }

    public TallaBean getIdtalla() {
        return idtalla;
    }

    public void setIdtalla(TallaBean idtalla) {
        this.idtalla = idtalla;
    }

    public ProveedorBean getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(ProveedorBean idproveedor) {
        this.idproveedor = idproveedor;
    }

    public DepartamentoBean getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(DepartamentoBean iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    
    
    
    
}
