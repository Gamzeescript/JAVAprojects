
package entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="nota")
public class Nota implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @ManyToOne
    @JoinColumn(name="codigo_persona", referencedColumnName = "codigo" )
    private Persona codigo_persona;
    
    @ManyToOne
    @JoinColumn(name="codigo_categoria", referencedColumnName = "codigo" )
    private Categoria codigo_categoria;
    
    @Column(name="encabezado")
    private String encabezado;
    
    @Column(name="cuerpo")
    private String cuerpo;
    
    @Temporal( TemporalType.DATE)
    @Column(name="fecha")
    private Date fecha = new Date();
    
    @Column(name="comentarioAdmin")
    private String comentarioAdmin;
    
    @Column(name="valoracion") 
    private short valoracion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Persona getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(Persona cdigo_persona) {
        this.codigo_persona = cdigo_persona;
    }

    public Categoria getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(Categoria codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarioAdmin() {
        return comentarioAdmin;
    }

    public void setComentarioAdmin(String comentarioAdmin) {
        this.comentarioAdmin = comentarioAdmin;
    }

    public short getValoracion() {
        return valoracion;
    }

    public void setValoracion(short valoracion) {
        this.valoracion = valoracion;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nota{" + "codigo=" + codigo + '}';
    }
    
    
}
