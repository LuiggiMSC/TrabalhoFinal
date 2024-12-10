
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloClinica.Agenda;
import modeloClinica.Agendamento;
import modeloClinica.Cliente;
import modeloClinica.Funcionario;
import modeloClinica.PerfilCliente;
import modeloClinica.Servico;
import modeloClinica.TipoFuncionario;
import modeloClinica.dao.PersistenciaJPA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author legitx
 */
public class TestePersistencia {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistencia() {
    }

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testePersistencia() {

        Cliente c = new Cliente();
        c.setCpf("0154378051");
        c.setNome("LuiggiMSC");
        c.setTelefone("15435789");
        c.setPerfilCliente(PerfilCliente.ECONOMICO);

        Funcionario f = new Funcionario();
        f.setCpf("612987364");
        f.setTelefone("123243289");
        f.setTipoFuncionario(TipoFuncionario.CIRURGIA);
        f.setNome("Miguel");

        Servico s = new Servico();
        s.setDescricao("Banho");
        s.setValorUnitario(5.00);
        s.setMaximoDesconto(1.00);

        Agenda agenda = new Agenda();
        agenda.setFuncionario(f);

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(c);

        String dataString = "01-02-2001 09:00";
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        try {
            Date data = formato.parse(dataString);
            agendamento.setData(data);
        } catch (ParseException ex) {
            Logger.getLogger(TestePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        agendamento.setAgenda(agenda);
        agenda.addAgendamentos(agendamento);
        f.setAgenda(agenda);

        try {
            jpa.persist(c);
            jpa.persist(f);
            jpa.persist(s);
            jpa.persist(agenda);
            jpa.persist(agendamento);
        } catch (Exception ex) {
            System.err.println("Erro ao persistir dados.");
        }

    }
}
