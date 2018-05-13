/*
 * Copyright (C) 2017 vhoa1
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gamefestival;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author vhoa1
 */
public class Bilheteira implements Serializable{
    protected Bilhete bilhete = new Bilhete();
    
    protected ArrayList<Bilhete> bilhetes;
    
    public Bilheteira(){
        
        bilhetes = new ArrayList<>();
         
    }
    public  void comprarBilhete(Bilhete x) {
        bilhetes.add(x);
        
    }
    
    public int size(){
       return bilhetes.size();
    }
    
    public int getMaxDia(Dia a){
        int i = 0;
        for(Bilhete e : bilhetes){
           if(e.getData().equals(a.getDia())){
               i++;
           }
        }
       return i;
    }
    
    public void alterarPreco(Float a){
        bilhete.setPreco(a);
    }
   
    public int getLotMax(Dia a){
        
       return a.getCapMax();
    }
  
     public float TotalPreco(){
       float b = 0;
        for (Bilhete a : bilhetes){
           
            b +=  a.getPreco();
        }
        return b;
       
   }
    
}
    

