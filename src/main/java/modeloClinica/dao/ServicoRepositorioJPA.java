package modeloClinica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modeloClinica.Servico;


/**
 *
 * @author legitx
 */
public class ServicoRepositorioJPA implements InterfaceBD {

    EntityManager entity;
    EntityManagerFactory factory;

    public ServicoRepositorioJPA() {
        factory = Persistence.createEntityManagerFactory("pu_lpoo_E1_LuiggiMathewScortegagna");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            
            if(!entity.contains(o)){
                o = entity.merge(o);
            }
            entity.remove(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();

        }
        return entity;
    }

    public List<Servico> getAllServicos() {
        entity = getEntityManager();
        try {
            Query query = entity.createQuery("Select s from Servico s ORDER BY s.id ASC", Servico.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Serviços: " + e);
            return null;
        }
    }
    
    
    public List<Servico> getServicoFiltro(String descricao){
        entity = getEntityManager();
        try {
            Query query;
           
            query = entity.createQuery("Select s from Servico s WHERE LOWER(s.descricao) LIKE LOWER(:descricao) ORDER BY s.id ASC", Servico.class); 
                
            query.setParameter("descricao", "%" + descricao + "%");
                         
            return query.getResultList();
            
        } catch (Exception e) {
            System.err.println("Erro ao buscar Serviços: " + e);
            return null;
        }
    }
    
   
}
