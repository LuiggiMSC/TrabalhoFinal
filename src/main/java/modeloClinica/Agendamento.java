package modeloClinica;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;

/**
 *
 * @author legitx
 */

@Entity
@Table(name="tb_agendamento")
public class Agendamento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="data")
    private Date data;
    
    @ManyToOne
    @JoinColumn(name="agenda_id")
    private Agenda agenda;
    
    
    
    public Agendamento(){
        
    }
    
    
    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "id= " + id + ", " + servico.getDescricao() + ", cliente= " + cliente.getNome() + ", " + data + ", agenda= " + agenda.getFuncionario().getNome();
    }
    
    
}
