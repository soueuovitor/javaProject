
package gamefestival;

import gamefestival.Utilizador;
import java.io.Serializable;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class Administrador extends Utilizador implements Serializable {

    public Administrador() {
    }

    public Administrador(String username, String password, String nome) {
        super(username, password, nome);
    }    
    
    
}
