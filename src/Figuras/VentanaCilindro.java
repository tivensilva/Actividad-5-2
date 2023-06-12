package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radioLabel, alturaLabel, volumenLabel, superficieLabel;
    private JTextField radioField, alturaField;
    private JButton calcularButton;
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

        radioLabel = new JLabel();
        radioLabel.setText("Radio (cms):");
        radioLabel.setBounds(20, 20, 135, 23);

        radioField = new JTextField();
        radioField.setBounds(100, 20, 135, 23);

        alturaLabel = new JLabel();
        alturaLabel.setText("Altura (cms):");
        alturaLabel.setBounds(20, 50, 135, 23);

        alturaField = new JTextField();
        alturaField.setBounds(100, 50, 135, 23);

        calcularButton = new JButton();
        calcularButton.setText("Calcular");
        calcularButton.setBounds(100, 80, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel();
        volumenLabel.setText("Volumen (cm3):");
        volumenLabel.setBounds(20, 120, 135, 23);

        superficieLabel = new JLabel();
        superficieLabel.setText("Superficie (cm2):");
        superficieLabel.setBounds(20, 150, 135, 23);

        imagenLabel = new JLabel();
        imagenLabel.setBounds(20, 180, 240, 200);

        ImageIcon icono = new ImageIcon("img/cilindro.jpg");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel.setIcon(iconoRedimensionado);

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
        boolean error = false;
        double radio = 0;
        double altura = 0;

        try {
            radio = Double.parseDouble(radioField.getText());
            altura = Double.parseDouble(alturaField.getText());
            Cilindro cilindro = new Cilindro(radio, altura);
            volumenLabel.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
            superficieLabel.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
