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

import Interface.Patrocinador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author vhoa1
 */
public class ListaPatrocinios implements Serializable {
   
    protected ArrayList<Patrocinio> patrocinios;
    
    
    
    public ListaPatrocinios(){
      patrocinios  = new ArrayList<>();
    }
    public void adicionarPatrocinio(Patrocinio x) {
        patrocinios.add(x);
    }
   
    public int size() {
        return patrocinios.size();
    }
    public  Patrocinio getPatrocinio(int i) {
        sort();
        return patrocinios.get(i);
    }
  public float salarioTotalPatrocinioss(){
       float b = 0;
        for (Patrocinio a :patrocinios){
           
            b +=  a.getContribuicao();
        }
        return b;
    }
  public void sort(){
      int result = 0;
  
        Collections.sort(patrocinios , (Patrocinio o1, Patrocinio o2) -> {
            int result1 = Float.compare(o2.getContribuicao(), o1.getContribuicao());
          return result1;
          });}
}