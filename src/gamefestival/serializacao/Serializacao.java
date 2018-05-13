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
package gamefestival.serializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import gamefestival.GameFestival;
import gamefestival.ListaGameDesigners;
import gamefestival.ListaColaboradores;


public class Serializacao {
     private final File ficheiro;

    public Serializacao(String ficheiro) {
        this.ficheiro = new File(ficheiro);
    }

    public File getFicheiro() {
        return ficheiro;
    }          
    
    //Carrega/lê o sistema de ficheiro
    public GameFestival carregar() {
        try (FileInputStream fileIn = new FileInputStream(ficheiro); 
        ObjectInputStream in = new ObjectInputStream(fileIn)) {
            GameFestival game = (GameFestival) in.readObject();
            return game;
        }catch(IOException | ClassNotFoundException ex) {
            throw new RuntimeException(String.format(
                  "Ocorreu um erro ao ler o ficheiro de dados: %s", 
                  ex.getLocalizedMessage()), ex);        
        }              
    }
    
    //Guarda o sistema em ficheiro
    public void guardar(GameFestival game) {
        try (FileOutputStream fileOut = new FileOutputStream(ficheiro); 
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            try {
                out.writeObject(game);
            } catch (IOException ex) {
                throw new RuntimeException(String.format(
                        "Ocorreu um erro ao guardar o ficheiro de dados: %s", 
                        ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
             throw new RuntimeException(String.format(
                        "Ocorreu um erro ao guardar o ficheiro de dados: %s", 
                        ex.getLocalizedMessage()), ex);
        }
    }
    
    
}


