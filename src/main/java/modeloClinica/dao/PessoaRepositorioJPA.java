package modeloClinica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modeloClinica.Cliente;
import modeloClinica.Funcionario;
import modeloClinica.PerfilCliente;
import modeloClinica.TipoFuncionario;

/**
 *
 * @author legitx
 */
public class PessoaRepositorioJPA implements InterfaceBD {

    EntityManager entity;
    EntityManagerFactory factory;

    public PessoaRepositorioJPA() {
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

            if (!entity.contains(o)) {
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

    public List<Cliente> getAllClientes() {
        entity = getEntityManager();
        try {
            Query query = entity.createQuery("Select c from Cliente c ORDER BY c.id ASC", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Clientes: " + e);
            return null;
        }
    }

    public List<Funcionario> getAllFuncionarios() {
        entity = getEntityManager();
        try {
            Query query = entity.createQuery("Select f from Funcionario f ORDER BY f.id ASC", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionarios: " + e);
            return null;
        }
    }

    public List<Cliente> getClienteFiltro(String nome, PerfilCliente perfil) {
        entity = getEntityManager();
        try {
            Query query;
            if (perfil == null && (nome != null && !nome.isEmpty())) {

                query = entity.createQuery("Select c from Cliente c WHERE LOWER(c.nome) LIKE LOWER(:nome) ORDER BY c.id ASC", Cliente.class);

                query.setParameter("nome", "%" + nome + "%");

            } else if (perfil != null && (nome == null || nome.isEmpty())) {

                query = entity.createQuery("Select c from Cliente c WHERE c.perfilCliente LIKE :perfil ORDER BY c.id ASC", Cliente.class);

                query.setParameter("perfil", perfil);

            } else {

                query = entity.createQuery("Select c from Cliente c WHERE c.perfilCliente LIKE :perfil AND LOWER(c.nome) LIKE LOWER(:nome) ORDER BY c.id ASC", Cliente.class);

                query.setParameter("nome", "%" + nome + "%");

                query.setParameter("perfil", perfil);
            }

            return query.getResultList();

        } catch (Exception e) {
            System.err.println("Erro ao buscar Clientes: " + e);
            return null;
        }
    }

    public List<Funcionario> getFuncionarioFiltro(String nome, TipoFuncionario tipo) {
        entity = getEntityManager();
        try {
            Query query;
            if (tipo == null && (nome != null && !nome.isEmpty())) {

                query = entity.createQuery("Select f from Funcionario f WHERE LOWER(f.nome) LIKE LOWER(:nome) ORDER BY f.id ASC", Funcionario.class);

                query.setParameter("nome", "%" + nome + "%");

            } else if (tipo != null && (nome == null || nome.isEmpty())) {

                query = entity.createQuery("Select f from Funcionario f WHERE f.tipoFuncionario LIKE :tipo ORDER BY f.id ASC", Funcionario.class);

                query.setParameter("tipo", tipo);

            } else {

                query = entity.createQuery("Select f from Funcionario f WHERE f.tipoFuncionario LIKE :tipo AND LOWER(f.nome) LIKE LOWER(:nome) ORDER BY f.id ASC", Funcionario.class);

                query.setParameter("nome", "%" + nome + "%");

                query.setParameter("tipo", tipo);
            }

            return query.getResultList();

        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionarios: " + e);
            return null;
        }
    }

}
