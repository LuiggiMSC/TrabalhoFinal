package modeloClinica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author legitx
 */
@Entity
@Table(name="tb_cliente")
public class Cliente extends Pessoa implements Serializable{
    
    @Enumerated(EnumType.STRING)
    private PerfilCliente perfilCliente;
     
    
    public Cliente(){
        
    }

    
    
    
    public PerfilCliente getPerfilCliente() {
        return perfilCliente;
    }

    public void setPerfilCliente(PerfilCliente perfilCliente) {
        this.perfilCliente = perfilCliente;
    }
    
    @Override
    public String toString() {
        return  "id: " + super.getId() + ", nome: " + super.getNome() + ", perfil: " + perfilCliente;
    }
}
