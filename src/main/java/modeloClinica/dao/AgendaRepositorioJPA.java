/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloClinica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modeloClinica.Agenda;
import modeloClinica.Agendamento;
import modeloClinica.Cliente;
import modeloClinica.Funcionario;
import modeloClinica.Servico;



/**
 *
 * @author ggbra
 */
public class AgendaRepositorioJPA implements InterfaceBD {

    EntityManager entity;
    EntityManagerFactory factory;

    public AgendaRepositorioJPA() {
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
   
    public List<Agendamento> getAllAgendamentosByAgenda(Agenda agenda){
        entity = getEntityManager();
        try {
            Query query = entity.createQuery(
                "SELECT ag FROM Agendamento ag WHERE ag.agenda = :agenda ORDER BY ag.id ASC", Agendamento.class);
            query.setParameter("agenda", agenda);
            return query.getResultList();
           
        }catch (Exception e) {
            System.err.println("Erro ao buscar Agendamentos: " + e);
            return null;
        }
        
    }
    
    public List<Agendamento> getAllAgendamentos(){
        entity = getEntityManager();
        try {
            Query query = entity.createQuery(
                "SELECT ag FROM Agendamento ag ORDER BY ag.id ASC", Agendamento.class);
            return query.getResultList();
           
        }catch (Exception e) {
            System.err.println("Erro ao buscar Agendamentos: " + e);
            return null;
        }
        
    }
    
    public List<Agenda> getAllAgenda() {
        entity = getEntityManager();
        try {
            Query query = entity.createQuery("Select a from Agenda a ORDER BY a.id ASC", Agenda.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Agenda: " + e);
            return null;
        }
    }
    
   public List<Agendamento> getAgendaFuncionarioFiltros(Cliente cliente, Servico servico, Agenda agenda) {
    entity = getEntityManager();
    try {
        StringBuilder jpql = new StringBuilder("SELECT ag FROM Agendamento ag WHERE ag.agenda = :agenda");
        
        if (cliente != null) {
            jpql.append(" AND ag.cliente = :cliente");
        }
        if (servico != null) {
            jpql.append(" AND ag.servico = :servico");
        }
        jpql.append(" ORDER BY ag.id ASC");
        
        Query query = entity.createQuery(jpql.toString(), Agendamento.class);
        query.setParameter("agenda", agenda);
        
        if (cliente != null) {
            query.setParameter("cliente", cliente);
        }
        if (servico != null) {
            query.setParameter("servico", servico);
        }
        
        return query.getResultList();
    } finally {
        entity.close();
    }
}

   
   public List<Agendamento> getAgendamentosFiltros(Cliente cliente, Servico servico) {
    entity = getEntityManager();
    try {
        StringBuilder jpql = new StringBuilder("SELECT ag FROM Agendamento ag ");
        
        jpql.append("WHERE 1=1 ");
        if (cliente != null) {
            jpql.append(" AND ag.cliente = :cliente ");
        }
        if (servico != null) {
            jpql.append(" AND ag.servico = :servico ");
        }
        jpql.append(" ORDER BY ag.id ASC ");
        
        Query query = entity.createQuery(jpql.toString(), Agendamento.class);
        
        if (cliente != null) {
            query.setParameter("cliente", cliente);
        }
        if (servico != null) {
            query.setParameter("servico", servico);
        }
        
        return query.getResultList();
    } finally {
        entity.close();
    }
}


}
