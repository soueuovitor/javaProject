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
import java.util.Collections;

/**
 *
 * @author vhoa1
 */
public class ListaGameDesigners implements Serializable{
    protected  ArrayList<GameDesigner> gameDesigners;
    
    
    public ListaGameDesigners(){
        gameDesigners = new ArrayList<>();
    }
    
    
    public void adicionarGameDesigner(GameDesigner x) {
         gameDesigners.add(x);
    }
    public int size() {
        return gameDesigners.size();
    }
    public  GameDesigner getGameDesigner(int i) {
        return gameDesigners.get(i);
    }
    
    public float salarioTotalGameDesigners(){
       float b = 0;
        for (GameDesigner a : gameDesigners){
           
            b +=  a.getCache();
        }
        return b;
    }
  
 
}
