package controller;

import ejb.CategoriaFacadeLocal;
import ejb.NotaFacadeLocal;
import ejb.PersonaFacadeLocal;
import entity.Categoria;
import entity.Nota;
import entity.Persona;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "notaController")
@SessionScoped
public class NotaController implements Serializable {

    @EJB
    private NotaFacadeLocal notaEJB;
    private Nota nota;
    private List<Nota> listaNota;
    
    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;
    private List<Persona> listaPersona;
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;
    private List<Categoria> listaCategoria;

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public List<Nota> getListaNota() {
        return listaNota;
    }

    public void setListaNota(List<Nota> listaNota) {
        this.listaNota = listaNota;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    @PostConstruct
    private void init() {
        nota = new Nota();
        persona = new Persona();
        categoria = new Categoria();
    }
    public void consultarCategoria(){
        try {
            listaCategoria = categoriaEJB.findAll();
        } catch (Exception e) {
            //
        }
    }
    public void consultarPersona(){
        try {
            listaPersona = personaEJB.findAll();
        } catch (Exception e) {
            //
        }
    }
    public void insertar(){
        try {
            nota.setCodigo_persona(persona);
            nota.setCodigo_categoria(categoria);
            notaEJB.create(nota);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Su registro fue guardado", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }
    }
    public void consultar(){
        try {
            listaNota = notaEJB.consulta();
        } catch (Exception e) {
        }
    }
}
    


