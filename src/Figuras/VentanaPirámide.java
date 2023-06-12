package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPirámide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel etiquetaBase, etiquetaAltura, etiquetaApotema, etiquetaVolumen, etiquetaSuperficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton botonCalcular;
    private JLabel imagenLabel;

    public VentanaPirámide() {
        iniciar();
        setTitle("Pirámide");
        setSize(280, 450);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void iniciar() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        etiquetaBase = new JLabel();
        etiquetaBase.setText("Base (cms):");
        etiquetaBase.setBounds(20, 20, 135, 23);

        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        etiquetaAltura = new JLabel();
        etiquetaAltura.setText("Altura (cms):");
        etiquetaAltura.setBounds(20, 50, 135, 23);

        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        etiquetaApotema = new JLabel();
        etiquetaApotema.setText("Apotema (cms):");
        etiquetaApotema.setBounds(20, 80, 135, 23);

        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 135, 23);

        botonCalcular = new JButton();
        botonCalcular.setText("Calcular");
        botonCalcular.setBounds(120, 110, 135, 23);
        botonCalcular.addActionListener(this);

        etiquetaVolumen = new JLabel();
        etiquetaVolumen.setText("Volumen (cm3):");
        etiquetaVolumen.setBounds(20, 140, 135, 23);

        etiquetaSuperficie = new JLabel();
        etiquetaSuperficie.setText("Superficie (cm2):");
        etiquetaSuperficie.setBounds(20, 170, 135, 23);

        imagenLabel = new JLabel();
        imagenLabel.setBounds(20, 200, 240, 200);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon icono = new ImageIcon("img/Piramide.png");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel.setIcon(iconoRedimensionado);

        contenedor.add(etiquetaBase);
        contenedor.add(campoBase);
        contenedor.add(etiquetaAltura);
        contenedor.add(campoAltura);
        contenedor.add(etiquetaApotema);
        contenedor.add(campoApotema);
        contenedor.add(botonCalcular);
        contenedor.add(etiquetaVolumen);
        contenedor.add(etiquetaSuperficie);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent evento) {
        Pirámide piramide;
        boolean error = false;
        double base = 0;
        double altura = 0;
        double apotema = 0;
        try {
            base = Double.parseDouble(campoBase.getText());
            altura = Double.parseDouble(campoAltura.getText());
            apotema = Double.parseDouble(campoApotema.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }

        if (!error) {
            piramide = new Pirámide(base, altura, apotema);
            etiquetaVolumen.setText("Volumen (cm3): " + piramide.calcularVolumen());
            etiquetaSuperficie.setText("Superficie (cm2): " + piramide.calcularSuperficie());
        }
    }
}
