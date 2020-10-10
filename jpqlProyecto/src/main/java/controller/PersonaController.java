package controller;

import ejb.PersonaFacadeLocal;
import entity.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

@Named(value = "personaController")
@SessionScoped
public class PersonaController implements Serializable {

    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;
    private List<Persona> listaPersona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListaPersona() {
        listaPersona = personaEJB.findAll();
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }
    
    
    @PostConstruct
    public void init() {
        persona = new Persona();
    }
 
}
