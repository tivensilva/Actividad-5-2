package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel etiquetaRadio, etiquetaVolumen, etiquetaSuperficie;
    private JTextField campoRadio;
    private JButton botonCalcular;
    private JLabel imagenLabel;

    public VentanaEsfera() {
        iniciar();
        setTitle("Esfera");
        setSize(280, 270);
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

        botonCalcular = new JButton();
        botonCalcular.setText("Calcular");
        botonCalcular.setBounds(100, 50, 135, 23);
        botonCalcular.addActionListener(this);

        etiquetaVolumen = new JLabel();
        etiquetaVolumen.setText("Volumen (cm3):");
        etiquetaVolumen.setBounds(20, 90, 135, 23);

        etiquetaSuperficie = new JLabel();
        etiquetaSuperficie.setText("Superficie (cm2):");
        etiquetaSuperficie.setBounds(20, 120, 135, 23);

        imagenLabel = new JLabel();
        imagenLabel.setBounds(20, 150, 240, 80);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon icono = new ImageIcon("img/esfera.png");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel.setIcon(iconoRedimensionado);

        contenedor.add(etiquetaRadio);
        contenedor.add(campoRadio);
        contenedor.add(botonCalcular);
        contenedor.add(etiquetaVolumen);
        contenedor.add(etiquetaSuperficie);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == botonCalcular) {
            boolean error = false;
            try {
                double radio = Double.parseDouble(campoRadio.getText());
                Esfera esfera = new Esfera(radio);
                etiquetaVolumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
                etiquetaSuperficie.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()));
            } catch (Exception e) {
                error = true;
            } finally {
                if (error) {
                    JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
