package modeloClinica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author legitx
 */
@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa implements Serializable {

    @Enumerated(EnumType.STRING)
    private PerfilCliente perfilCliente;

    public Cliente() {

    }

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
    private List<Mascote> mascotes;

    public PerfilCliente getPerfilCliente() {
        return perfilCliente;
    }

    public void setPerfilCliente(PerfilCliente perfilCliente) {
        this.perfilCliente = perfilCliente;
    }

    @Override
    public String toString() {
        return "[" + super.getId() + "]: " + super.getNome() + ", perfil: " + perfilCliente;
    }
}
