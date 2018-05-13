
package gamefestival;

import java.io.Serializable;


public  class Patrocinio implements Serializable{
    protected String nome;
    protected float contribuicao;

    public Patrocinio(String nome, float contribuicao) {
        this.nome = nome;
        this.contribuicao = contribuicao;
    
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(float contribuicao) {
        this.contribuicao = contribuicao;
    }
    


  


 
}
