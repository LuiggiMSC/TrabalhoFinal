package modeloClinica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author legitx
 */
@Entity
@Table(name = "tb_agenda")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agendamento> agendamentos;

    @OneToOne
    @JoinColumn(name = "funcionario_id", unique = true)
    private Funcionario funcionario;

    public Agenda() {
        this.agendamentos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void addAgendamentos(Agendamento agendamento) {
        this.agendamentos.add(agendamento);
    }

    @Override
    public String toString() {
        return "agendas de " + funcionario.getNome().toUpperCase();
    }

}
