
package gamefestival;

import java.io.Serializable;


public class Colaborador implements Serializable{
    protected String nome;
    protected String morada;
    protected String  numTel;
    protected String funcao;
  
   
   public Colaborador(){}   
   public Colaborador(String nome, String morada, String numTel, String funcao) {
        this.nome = nome;
        this.morada = morada;
        this.numTel = numTel;
        this.funcao = funcao;
 
        
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    

}
