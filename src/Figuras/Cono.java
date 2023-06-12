package Figuras;

public class Cono {
    private double radio;
    private double altura;

    public Cono(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    public double calcularVolumen() {
        return (Math.PI * radio * radio * altura) / 3.0;
    }

    public double calcularSuperficie() {
        double generatriz = Math.sqrt(radio * radio + altura * altura);
        return Math.PI * radio * (radio + generatriz);
    }
}
