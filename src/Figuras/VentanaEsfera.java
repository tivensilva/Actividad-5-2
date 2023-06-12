package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radioLabel, volumenLabel, superficieLabel;
    private JTextField radioField;
    private JButton calcularButton;
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

        radioLabel = new JLabel();
        radioLabel.setText("Radio (cms):");
        radioLabel.setBounds(20, 20, 135, 23);

        radioField = new JTextField();
        radioField.setBounds(100, 20, 135, 23);

        calcularButton = new JButton();
        calcularButton.setText("Calcular");
        calcularButton.setBounds(100, 50, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel();
        volumenLabel.setText("Volumen (cm3):");
        volumenLabel.setBounds(20, 90, 135, 23);

        superficieLabel = new JLabel();
        superficieLabel.setText("Superficie (cm2):");
        superficieLabel.setBounds(20, 120, 135, 23);

        imagenLabel = new JLabel();
        imagenLabel.setBounds(20, 150, 240, 80);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon icono = new ImageIcon("img/esfera.png");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel.setIcon(iconoRedimensionado);

        contenedor.add(radioLabel);
        contenedor.add(radioField);
        contenedor.add(calcularButton);
        contenedor.add(volumenLabel);
        contenedor.add(superficieLabel);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcularButton) {
            boolean error = false;
            try {
                double radio = Double.parseDouble(radioField.getText());
                Esfera esfera = new Esfera(radio);
                volumenLabel.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
                superficieLabel.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()));
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
