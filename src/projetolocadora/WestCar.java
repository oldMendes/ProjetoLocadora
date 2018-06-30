package projetolocadora;

public class WestCar extends Locadora {

    public WestCar() {
        this.setPrecoNormalSemana(530.0);
        this.setPrecoFidelidadeSemana(150.0);
        this.setPrecoNormalFds(200.0);
        this.setPrecoFidelidadeFds(90.0);
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
        return "Normal".equalsIgnoreCase(tipo) ? ((getPrecoNormalSemana() * diasNormais) + (getPrecoNormalFds() * diasFds))
                : ((getPrecoFidelidadeSemana() * diasNormais) + (getPrecoFidelidadeFds() * diasFds));
    }

}
