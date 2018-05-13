package gamefestival;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class ListaUtilizadores implements Serializable {
    private TreeMap<String, Utilizador> lista;

    public class UtilizadorNaoExistenteException extends Exception {
        public UtilizadorNaoExistenteException() { }
        public UtilizadorNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class UtilizadorDuplicadoException extends Exception {
        public UtilizadorDuplicadoException() { }
        public UtilizadorDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaUtilizadores() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Utilizador utilizador) throws UtilizadorDuplicadoException {
        if (utilizador == null) {
            throw new NullPointerException("O parâmetro 'utilizador' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(utilizador.getUsername())) {
            lista.put(utilizador.getUsername(), utilizador);
        }else{
            throw new UtilizadorDuplicadoException(String.format("O utilizador '%s' já existe na coleção", utilizador.getUsername()));
        }
        
    }        
    
    public boolean existe(String username) {
        return lista.containsKey(username);
    }
    
    public int size() {
        return lista.size();
    }
    
    public Utilizador getUtilizador(String username) throws UtilizadorNaoExistenteException {
        if (lista.containsKey(username)){
            return lista.get(username);
        }else{
            throw new UtilizadorNaoExistenteException("O utilizador '%s' já existe na lista");
        }
    }
    
    public ArrayList<Utilizador> todos() {
        return new ArrayList<>(lista.values());
    }
    
}
