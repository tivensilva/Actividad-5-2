package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lado, volumen, superficie;
    private JTextField campoLado;
    private JButton calcular;
    private JLabel imagenLabel;

    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lado = new JLabel();
        lado.setText("Lado (cms):");
        lado.setBounds(20, 20, 135, 23);
        campoLado = new JTextField();
        campoLado.setBounds(120, 20, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(120, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 80, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 110, 135, 23);

        ImageIcon icono = new ImageIcon("img/cubo.png");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(240, 200, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel = new JLabel(iconoRedimensionado);
        imagenLabel.setBounds(20, 140, 240, 200);

        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent event) {
        Cubo cubo;
        boolean error = false;
        double lado = 0;
        try {
            lado = Double.parseDouble(campoLado.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        if (!error) {
            cubo = new Cubo(lado);
            double volumenResult = cubo.calcularVolumen();
            double superficieResult = cubo.calcularSuperficie();
            volumen.setText("Volumen (cm3): " + volumenResult);
            superficie.setText("Superficie (cm2): " + superficieResult);
        }
    }
}
