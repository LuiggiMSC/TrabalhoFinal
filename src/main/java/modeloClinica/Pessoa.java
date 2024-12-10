package modeloClinica;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author legitx
 */

@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="nome", length = 150)
    private String nome;
    
    @Column(name="telefone", length = 9)
    private String telefone;
    
    @Column(name="cpf", length = 11)
    private String cpf;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
