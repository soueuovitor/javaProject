/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Interface.JanelaPrincipal;

import gamefestival.Administrador;
import gamefestival.GameFestival;
import gamefestival.ListaUtilizadores;
import gamefestival.serializacao.Serializacao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Teste  {


public static void main(String[] args) throws ListaUtilizadores.UtilizadorDuplicadoException    {
    
   
              
        GameFestival game;        
        String ficheiroDados = String.format("%s\\utilizadores.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        
        
        
        
        
        
        Serializacao bd = new Serializacao(ficheiroDados);        
        
        //Se o ficheiro de base de dados nao existir
         if (! bd.getFicheiro().exists()) {
            //Cria uma instancia do sistema
            game = new GameFestival();      
            //Adiciona dois utilizadores para que possa ser possivel entrar no sistema
            game.getListaUtilizadores().adicionar(new Administrador("admin", "admin", "Aministrador"));
            game.getListaUtilizadores().adicionar(new gamefestival.Utilizador("user1", "1234", "Utilizador 1"));   
            game.setPrecoInicialBilhete();
            game.setPrecoInicialColaborador();
            
        }else{
            game = bd.carregar();  
         
        }                     
        
  
                
                JanelaLogin login = new JanelaLogin(game);               
                login.setVisible(true);
                
                JanelaPrincipal principal = new JanelaPrincipal(game, bd);
                principal.setVisible(true);
    



    
    
    
    
    
    
}
}

