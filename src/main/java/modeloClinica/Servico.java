package modeloClinica;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author legitx
 */

@Entity
@Table(name="tb_servico")
public class Servico implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="descricao", length = 150)
    private String descricao;
    
    @Column(name="valorunitario")
    private Double valorUnitario;
    
    @Column(name="maximodesconto")
    private Double maximoDesconto;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getMaximoDesconto() {
        return maximoDesconto;
    }

    public void setMaximoDesconto(Double maximoDesconto) {
        this.maximoDesconto = maximoDesconto;
    }

    @Override
    public String toString() {
        return "[" + id + "]: " + descricao;
    }
    
    
}
