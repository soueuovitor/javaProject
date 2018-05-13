package gamefestival;

import java.io.Serializable;
import java.util.*;


public class GameFestival implements Serializable {
     private  ListaGameDesigners gameDesigners;
     private ListaColaboradores colaboradores;
     private ListaUtilizadores utilizadores;
     private Utilizador utilizadorLigado;
     private ListaPatrocinios patrocinios;
     private ListaDias dias;
     private Bilheteira bilhetes;

    
    
    
    
    public GameFestival(){
        utilizadores = new ListaUtilizadores();
        colaboradores = new ListaColaboradores();
        gameDesigners = new ListaGameDesigners();
        patrocinios = new ListaPatrocinios();
        dias = new ListaDias();
        bilhetes = new Bilheteira();
    }
    
    
    
    public  ListaGameDesigners getListaGameDesigners() {
        return gameDesigners;
    }
    
    public Bilheteira getBilheteira(){
        return bilhetes;
    }
    public void adicionarBilhete(Bilhete a){
        bilhetes.comprarBilhete(a);
    }
    
    public int getCapacidadeMax(Dia a) {
       return bilhetes.getLotMax(a);
    }
    
    public int getMaxCapacityDia(Dia a){
        return bilhetes.getMaxDia(a);
    }
    
    public int getAllBilhetes(){
        
        return bilhetes.size();
    }
    public  int getAllGames(){
        
        return gameDesigners.size();
    
    }
    
    public void removerUmDia(Dia a){
        dias.removerDia(a);
    }
    
    public  void adicionarGameDesigner(GameDesigner x) {
       gameDesigners.adicionarGameDesigner(x);
    }
    
    public void precoGameDesigners(){
        gameDesigners.salarioTotalGameDesigners();
    }

    public void adicionarColaborador(Colaborador x) {
        colaboradores.adicionarColaborador(x);
    }
    
    public int getAllColaboradores() {
        
        return colaboradores.size();
    }
    
    public ListaColaboradores getListaColaboradores() {
        return colaboradores;
    }
    
    public ListaPatrocinios getListaPatrocinios() {
        return patrocinios;
    }
    
    public int getAllPatrocionios(){
        return patrocinios.size();
    }
    
    public void adicionarPatrocinio (Patrocinio x) {
        patrocinios.adicionarPatrocinio(x);
    }
    
      public ListaUtilizadores getListaUtilizadores() {
        return utilizadores;
    }
      
    public void adicionarDia(Dia x){
        dias.adicionarDia(x);
    }
    
    public void setPrecoInicialBilhete() {
    float a = 10;
    getBilheteira().alterarPreco(a);
}
    
    public void setPrecoInicialColaborador(){
        float a = 50;
        getListaColaboradores().alterarPreco(a);
    }
    public ListaDias getListaDias(){
        return dias;
    
    }
    
    public int getAllDias(){
        return dias.size();
        
    }
    
  
    
    
    public boolean autenticarUtilizador(String username, String password) {        
        if (utilizadores.existe(username)) {
            try{
                Utilizador u = utilizadores.getUtilizador(username);                
                if (u.getPassword().equals(password)){
                    utilizadorLigado = u;
                    return true;
                }                
            }catch (Exception e) {}                        
        }        
        return false;        
    }
    
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }
    
    public void inicializar() throws ListaUtilizadores.UtilizadorDuplicadoException {
        utilizadores.adicionar(new Administrador("admin", "admin", "Aministrador"));
        utilizadores.adicionar(new Utilizador("user1", "1234", "Utilizador 1"));
        utilizadores.adicionar(new Utilizador("user2", "1234", "Utilizador 2"));        
    }
    
    public void terminar() {
        System.exit(0);
    }


   
    
    
  
    

    
    

}
    




    

