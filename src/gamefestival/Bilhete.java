
package gamefestival;

import gamefestival.GameFestival;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bilhete implements Serializable{
    protected static  float preco;
    protected int numero = 0;
    protected LocalDateTime data;
    private GameFestival game;
    
    
    public Bilhete(){
        numero++;
    
           
        this.preco = preco;
        this.numero = numero;
        this.data = data;
    }

    public Bilhete(int numero, LocalDateTime data){
        this.preco = preco;
        this.numero = numero;
        this.data = data;
 
        numero++;
     
    }

    public float getPreco() {
        return preco;
        
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getData() {
        return data;
    }
  
    
    
    
    
}
