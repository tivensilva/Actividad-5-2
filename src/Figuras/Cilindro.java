package Figuras;

public class Cilindro extends FiguraGeométrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        establecerVolumen(calcularVolumen());
        establecerSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = Math.PI * altura * Math.pow(radio, 2.0);
        return volumen;
    }

    public double calcularSuperficie() {
        double areaLateral = 2.0 * Math.PI * radio * altura;
        double areaBase = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return areaLateral + areaBase;
    }
}
