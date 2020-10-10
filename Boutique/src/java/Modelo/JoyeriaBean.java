
package Modelo;


public class JoyeriaBean {
    
    private int idjoyeria;
    private MetalBean idmetal;
    private ProveedorBean idproveedor;
    private DepartamentoBean iddepartamento;
    private String nombre; 
    private Double precio;

    public JoyeriaBean(int idjoyeria) {
        this.idjoyeria = idjoyeria;
    }

    public int getIdjoyeria() {
        return idjoyeria;
    }

    public void setIdjoyeria(int idjoyeria) {
        this.idjoyeria = idjoyeria;
    }

    public MetalBean getIdmetal() {
        return idmetal;
    }

    public void setIdmetal(MetalBean idmetal) {
        this.idmetal = idmetal;
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
