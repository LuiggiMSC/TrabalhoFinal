package modeloClinica;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author legitx
 */
@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa implements Serializable {

    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipoFuncionario;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Agenda agenda;

    public Funcionario() {

    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "[ID]- " + super.getId() + ". [NOME]- " + super.getNome() + " .[CARGO]- " + tipoFuncionario;
    }
}
