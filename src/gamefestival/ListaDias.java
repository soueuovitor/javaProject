/*
 * Copyright (C) 2017 vitor
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
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class ListaDias implements Serializable {
    
    protected ArrayList<Dia> dias ;
    
    public ListaDias(){
        dias = new ArrayList<>();
    }
        
    
    public void adicionarDia(Dia x) {
         dias.add(x);
    }
    
    public void removerDia(Dia x){
        dias.remove(x);
    }
    public int size() {
        return dias.size();
    }
    public Dia getDia(int i) {
        return dias.get(i);
    }
  
    public ArrayList getListaDias(){
        return dias;
    }
    public boolean existe(LocalDateTime date) {
        return dias.contains(date);
    }
    
    public int getMaxCapacity(Dia a){
        return a.getCapMax();
    }
    
 
}
