package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel etiquetaRadio, etiquetaAltura, etiquetaVolumen, etiquetaSuperficie;
    private JTextField campoRadio, campoAltura;
    private JButton botonCalcular;
    private JLabel imagenLabel;

    public VentanaCilindro() {
        iniciar();
        setTitle("Cilindro");
        setSize(280, 450);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void iniciar() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        etiquetaRadio = new JLabel();
        etiquetaRadio.setText("Radio (cms):");
        etiquetaRadio.setBounds(20, 20, 135, 23);

        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        etiquetaAltura = new JLabel();
        etiquetaAltura.setText("Altura (cms):");
        etiquetaAltura.setBounds(20, 50, 135, 23);

        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        botonCalcular = new JButton();
        botonCalcular.setText("Calcular");
        botonCalcular.setBounds(100, 80, 135, 23);
        botonCalcular.addActionListener(this);

        etiquetaVolumen = new JLabel();
        etiquetaVolumen.setText("Volumen (cm3):");
        etiquetaVolumen.setBounds(20, 120, 135, 23);

        etiquetaSuperficie = new JLabel();
        etiquetaSuperficie.setText("Superficie (cm2):");
        etiquetaSuperficie.setBounds(20, 150, 135, 23);

        imagenLabel = new JLabel();
        imagenLabel.setBounds(20, 180, 240, 200);

        ImageIcon icono = new ImageIcon("img/cilindro.jpg");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel.setIcon(iconoRedimensionado);

        contenedor.add(etiquetaRadio);
        contenedor.add(campoRadio);
        contenedor.add(etiquetaAltura);
        contenedor.add(campoAltura);
        contenedor.add(botonCalcular);
        contenedor.add(etiquetaVolumen);
        contenedor.add(etiquetaSuperficie);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double radio = 0;
        double altura = 0;

        try {
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura);
            etiquetaVolumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
            etiquetaSuperficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
