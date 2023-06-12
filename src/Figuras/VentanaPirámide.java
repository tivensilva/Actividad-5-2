package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPirámide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel baseLabel, alturaLabel, apotemaLabel, volumenLabel, superficieLabel;
    private JTextField baseField, alturaField, apotemaField;
    private JButton calcularButton;
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

        baseLabel = new JLabel();
        baseLabel.setText("Base (cms):");
        baseLabel.setBounds(20, 20, 135, 23);

        baseField = new JTextField();
        baseField.setBounds(120, 20, 135, 23);

        alturaLabel = new JLabel();
        alturaLabel.setText("Altura (cms):");
        alturaLabel.setBounds(20, 50, 135, 23);

        alturaField = new JTextField();
        alturaField.setBounds(120, 50, 135, 23);

        apotemaLabel = new JLabel();
        apotemaLabel.setText("Apotema (cms):");
        apotemaLabel.setBounds(20, 80, 135, 23);

        apotemaField = new JTextField();
        apotemaField.setBounds(120, 80, 135, 23);

        calcularButton = new JButton();
        calcularButton.setText("Calcular");
        calcularButton.setBounds(120, 110, 135, 23);
        calcularButton.addActionListener(this);

        volumenLabel = new JLabel();
        volumenLabel.setText("Volumen (cm3):");
        volumenLabel.setBounds(20, 140, 135, 23);

        superficieLabel = new JLabel();
        superficieLabel.setText("Superficie (cm2):");
        superficieLabel.setBounds(20, 170, 135, 23);

        imagenLabel = new JLabel();
        imagenLabel.setBounds(20, 200, 240, 200);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon icono = new ImageIcon("img/Piramide.png");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel.setIcon(iconoRedimensionado);

        contenedor.add(baseLabel);
        contenedor.add(baseField);
        contenedor.add(alturaLabel);
        contenedor.add(alturaField);
        contenedor.add(apotemaLabel);
        contenedor.add(apotemaField);
        contenedor.add(calcularButton);
        contenedor.add(volumenLabel);
        contenedor.add(superficieLabel);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent evento) {
        Pirámide piramide;
        boolean error = false;
        double base = 0;
        double altura = 0;
        double apotema = 0;
        try {
            base = Double.parseDouble(baseField.getText());
            altura = Double.parseDouble(alturaField.getText());
            apotema = Double.parseDouble(apotemaField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }

        if (!error) {
            piramide = new Pirámide(base, altura, apotema);
            volumenLabel.setText("Volumen (cm3): " + piramide.calcularVolumen());
            superficieLabel.setText("Superficie (cm2): " + piramide.calcularSuperficie());
        }
    }
}
