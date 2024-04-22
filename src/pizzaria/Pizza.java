package pizzaria;

public class Pizza {
    private String sabor;
    private double valor;

    public Pizza(String sabor, double valor) {
        this.sabor = sabor;
        this.valor = valor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
