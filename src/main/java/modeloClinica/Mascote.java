package modeloClinica;

import javax.persistence.*;


/**
 *
 * @author legitx
 */
@Entity
@Table(name = "tb_mascote")
public class Mascote {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private int idade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMascote tipo;

    @ManyToOne(optional = false)
    private Cliente dono;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public TipoMascote getTipo() {
        return tipo;
    }

    public void setTipo(TipoMascote tipo) {
        this.tipo = tipo;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }


    public Mascote() {
        //    
    }
}
