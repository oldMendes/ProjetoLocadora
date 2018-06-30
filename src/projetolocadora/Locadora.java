
package projetolocadora;


public abstract class Locadora {
    
    private double precoNormalSemana;
    private double precoNormalFds;
    private double precoFidelidadeSemana;
    private double precoFidelidadeFds;

    public abstract double calcularValorNormal( int diasNormais, int diasFds);
    public abstract double calcularValorPremium( int diasNormais, int diasFds);
    
    public abstract double calcularValor(String tipo, int diasNormais, int diasFds);

    protected double getPrecoNormalSemana() {
        return precoNormalSemana;
    }


    protected void setPrecoNormalSemana(double precoNormalSemana) {
        this.precoNormalSemana = precoNormalSemana;
    }


    protected double getPrecoNormalFds() {
        return precoNormalFds;
    }


    protected void setPrecoNormalFds(double precoNormalFds) {
        this.precoNormalFds = precoNormalFds;
    }

     protected double getPrecoFidelidadeSemana() {
        return precoFidelidadeSemana;
    }


    protected void setPrecoFidelidadeSemana(double precoFidelidadeSemana) {
        this.precoFidelidadeSemana = precoFidelidadeSemana;
    }


    protected double getPrecoFidelidadeFds() {
        return precoFidelidadeFds;
    }


    protected void setPrecoFidelidadeFds(double precoFidelidadeFds) {
        this.precoFidelidadeFds = precoFidelidadeFds;
    }
    
    
   
    
    
        
    
}
