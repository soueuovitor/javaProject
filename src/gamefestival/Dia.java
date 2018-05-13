package gamefestival;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;


public class Dia implements Serializable {
   private LocalDateTime dia;
   protected int capMax;


   
   public Dia(){}
    public Dia(LocalDateTime dia, int capMax) {
        this.dia = dia;
 
    }

    public LocalDateTime getDia() {
        return dia;
    }
    
   public void setDia(LocalDateTime dia) {
       
       this.dia = dia;
   }

    public int getCapMax() {
        return capMax;
    }

    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }

    public int getAno() {
       return dia.getYear();
    }
   
    public Month getMes() {
        return dia.getMonth();
    }
    

    public String dataFormatada(){
        return dia.getDayOfMonth() + "/" + getMesFormatado() +"/"+dia.getYear();
    }
    
    public String CompararData() {
        return dia.getYear()+"/" +getMesFormatado()+"/"+dia.getDayOfMonth();
    }
    
        public String getMesFormatado(){
        String g = "0";
       int a =  dia.getMonthValue();
       if( a <= 9 ){
          
           g += a;
        
       }else{
           g = Integer.toString(a);
      
        }
      return g;
    }
    /**
     *
     * @return
     */
    public int getDiaDoMes() {
        return dia.getDayOfMonth();
    }
 
    public String getHour() {
        return dia.getHour() +":"+ dia.getMinute();
        
    }
 }
    
    
    


