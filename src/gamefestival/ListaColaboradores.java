
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
import java.util.*;

/**
 *
 * @author vhoa1
 */
public class ListaColaboradores implements Serializable {
    private ColaboradorPago colaborador = new ColaboradorPago();
   
    protected  ArrayList<Colaborador> colaboradores = new ArrayList<>();
    
    public  void adicionarColaborador(Colaborador x) {
        colaboradores.add(x);
        
        }
   
    public Colaborador getColaboradores(int i) {
        return colaboradores.get(i);
    }
    
  
 
    public int size() {
        return colaboradores.size();
    }
    
      public float salarioTotalColaboradores(){
       float b = 0;
        for (Colaborador a :colaboradores){
            
            if (a instanceof ColaboradorPago){
           
            b += ((ColaboradorPago )a).getSalario();
        }else{
            }
            }
        return b;
    }
    
public void alterarPreco(float a){
    colaborador.setSalario(a);
}

public float buscaSalario(){
    return colaborador.getSalario();
    
}
}
    
    


    
    

