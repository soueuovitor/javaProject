
package gamefestival;




public class ColaboradorPago extends Colaborador {
    private static float salario;
    private long nif;
    

    
    
    public ColaboradorPago(){}
    
    
    public ColaboradorPago( String nome, String morada, String  numTel, String funcao,float salario, long nif) {
        super(nome, morada, numTel, funcao);
        this.salario = salario;
        this.nif = nif;
       
        
        
        
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
       
        if ( salario >= 0.0 )
        this.salario = salario;
          
            else
        throw new IllegalArgumentException(
             "Base salary must be >= 0.0" );
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif =  nif;
    }

  
    
    
    
    
    
    
}
