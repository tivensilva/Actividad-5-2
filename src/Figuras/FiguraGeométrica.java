package Figuras;

public class FiguraGeométrica {
    private double volumen;
    private double superficie;

    public void establecerVolumen(double volumen) {
        this.volumen = volumen;
    }

    public void establecerSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double obtenerVolumen() {
        return this.volumen;
    }

    public double obtenerSuperficie() {
        return this.superficie;
    }
}
