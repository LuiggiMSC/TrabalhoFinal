import modeloClinica.dao.PersistenciaJPA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteConexao {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TesteConexao() {
    }
    
    @Before
    public void setUp() {
        if(jpa.conexaoAberta()){
            System.out.println("Conexão aberta");
        } else {
            System.out.println("Erro ao abrir conexao");
        }
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testeConexao() {
        System.out.println("Conexão realizada com sucesso");
    }
}
