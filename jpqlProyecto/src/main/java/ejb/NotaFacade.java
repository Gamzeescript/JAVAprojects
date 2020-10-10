/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Nota;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juan.bairesUSAM
 */
@Stateless
public class NotaFacade extends AbstractFacade<Nota> implements NotaFacadeLocal {

    @PersistenceContext(unitName = "conPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaFacade() {
        super(Nota.class);
    }
  
    
    
    
    
    
    public List<Nota> consulta(){
      String sql = "SELECT n FROM Nota n";
        
        List<Nota> lista = new LinkedList<>();
        try {
            Query q = em.createQuery(sql);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return lista;
        }
        return lista;
    }
    
    
    
    
    
    
    
    public List<Nota> consultaXid(int id){
      String sql = "SELECT n FROM Nota n where n.codigo = ?1";
        
        List<Nota> lista = new LinkedList<>();
        try {
            Query q = em.createQuery(sql);
            q.setParameter(1, id);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return lista;
        }
        return lista;
    
    }
}
