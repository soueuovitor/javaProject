
package gamefestival;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;


public class GameDesigner implements Serializable {
    protected String nome;
    protected String morada;
    protected String numTel;
    protected int nif;
    protected float cache;
    protected LocalDateTime hora;
    protected String jogo;
    
    

    public GameDesigner(String nome, String morada,String numTel, int nif, float cache, LocalDateTime hora,String jogo) {
        this.nome = nome;
        this.morada = morada;
        this.numTel = numTel;
        this.nif = nif;
        this.cache = cache;
        this.hora = hora;
        this.jogo = jogo;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public float getCache() {
        return cache;
    }

    public void setCache(float cache) {
        this.cache = cache;
    }

   
    

    public LocalDateTime getHora() {
       
        return hora;
    }
    
    public String getDateFormatted(){
        return hora.getYear()+"/"+ getMesFormatado()+"/"+hora.getDayOfMonth();
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
        
    }

    public String getMesFormatado(){
        String g = "0";
       int a =  hora.getMonthValue();
       if( a <= 9 ){
          
           g += a;
        
       }else{
           g = Integer.toString(a);
      
        }
      return g;
    }
   
    public String getHoraFormatada(){
     return Integer.toString(hora.getHour());
    }
    
     public String getHoraSessaoFormatada(){
     return Integer.toString(hora.getHour())+":00";
    }
    
    
    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }
    
    public String getHoraFormatted(){
        return hora.getHour()+":"+hora.getMinute();
    }
    

    
}
