package controller;

import ejb.CategoriaFacadeLocal;
import entity.Categoria;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

@Named(value = "categoriaController")
@SessionScoped
public class CategoriaController implements Serializable {

    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;
    private List<Categoria> listaCategoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategoria() {
        listaCategoria = categoriaEJB.findAll();
        return listaCategoria;
    }

    public void setLista(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    @PostConstruct
    public void init() {
        categoria = new Categoria();
    }
    
    

}
