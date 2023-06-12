package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCono extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radioLabel, alturaLabel, volumenLabel, superficieLabel;
    private JTextField radioField, alturaField;
    private JButton calcularButton;
    private JLabel imagenLabel;

    public VentanaCono() {
        inicio();
        setTitle("Cono");
        setSize(280, 450);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radioLabel = new JLabel("Radio (cms):");
        radioLabel.setBounds(20, 20, 135, 23);
        radioField = new JTextField();
        radioField.setBounds(120, 20, 135, 23);

        alturaLabel = new JLabel("Altura (cms):");
        alturaLabel.setBounds(20, 50, 135, 23);
        alturaField = new JTextField();
        alturaField.setBounds(120, 50, 135, 23);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(120, 80, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel();
        volumenLabel.setText("Volumen (cm3):");
        volumenLabel.setBounds(20, 110, 135, 23);

        superficieLabel = new JLabel();
        superficieLabel.setText("Superficie (cm2):");
        superficieLabel.setBounds(20, 140, 135, 23);

        imagenLabel = new JLabel();
        imagenLabel.setBounds(20, 170, 240, 240);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon icono = new ImageIcon("img/Cono.png");
        Image imagen = icono.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
        imagenLabel.setIcon(new ImageIcon(imagen));

        contenedor.add(radioLabel);
        contenedor.add(radioField);
        contenedor.add(alturaLabel);
        contenedor.add(alturaField);
        contenedor.add(calcularButton);
        contenedor.add(volumenLabel);
        contenedor.add(superficieLabel);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent event) {
        Cono cono;
        boolean error = false;
        double radio = 0;
        double altura = 0;

        try {
            radio = Double.parseDouble(radioField.getText());
            altura = Double.parseDouble(alturaField.getText());
            cono = new Cono(radio, altura);

            volumenLabel.setText("Volumen (cm3): " + String.format("%.2f", cono.calcularVolumen()));
            superficieLabel.setText("Superficie (cm2): " + String.format("%.2f", cono.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
