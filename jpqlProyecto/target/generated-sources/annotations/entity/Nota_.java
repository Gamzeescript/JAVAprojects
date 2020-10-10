package entity;

import entity.Categoria;
import entity.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-14T16:19:04")
@StaticMetamodel(Nota.class)
public class Nota_ { 

    public static volatile SingularAttribute<Nota, Date> fecha;
    public static volatile SingularAttribute<Nota, String> comentarioAdmin;
    public static volatile SingularAttribute<Nota, Integer> codigo;
    public static volatile SingularAttribute<Nota, Persona> codigo_persona;
    public static volatile SingularAttribute<Nota, Categoria> codigo_categoria;
    public static volatile SingularAttribute<Nota, String> encabezado;
    public static volatile SingularAttribute<Nota, Short> valoracion;
    public static volatile SingularAttribute<Nota, String> cuerpo;

}