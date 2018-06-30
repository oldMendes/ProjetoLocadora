package projetolocadora;

public class NorthCar extends Locadora {

    public NorthCar() {
        this.setPrecoNormalSemana(630.0);
        this.setPrecoFidelidadeSemana(580.0);
        this.setPrecoNormalFds(600.0);
        this.setPrecoFidelidadeFds(590.0);
    }

    @Override
    public double calcularValorNormal(int diasNormais, int diasFds) {
        return ((getPrecoNormalSemana() * diasNormais) + (getPrecoNormalFds() * diasFds));
    }

    public double calcularValorPremium(int diasNormais, int diasFds) {
        return ((getPrecoFidelidadeSemana() * diasNormais) + (getPrecoFidelidadeFds() * diasFds));
    }

    @Override
    public double calcularValor(String tipo, int diasNormais, int diasFds) {
        return "Normal".equalsIgnoreCase(tipo) ? ((getPrecoNormalSemana() * diasNormais) + (getPrecoNormalFds() * diasFds)) :
                ((getPrecoFidelidadeSemana() * diasNormais) + (getPrecoFidelidadeFds() * diasFds));
    }

}
