package Figuras;

public class Pirámide extends FiguraGeométrica {
    private double base;
    private double altura;
    private double apotema;

    public Pirámide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        establecerVolumen(calcularVolumen());
        establecerSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = (Math.pow(base, 2.0) * altura) / 3.0;
        return volumen;
    }

    public double calcularSuperficie() {
        double areaBase = Math.pow(base, 2.0);
        double areaLado = 2.0 * base * apotema;
        return areaBase + areaLado;
    }
}
