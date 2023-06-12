package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel baseLabel, alturaLabel, profundidadLabel, volumenLabel, superficieLabel;
    private JTextField baseField, alturaField, profundidadField;
    private JButton calcularButton;
    private JLabel imagenLabel;

    public VentanaPrisma() {
        iniciar();
        setTitle("Prisma");
        setSize(280, 380);
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

        profundidadLabel = new JLabel();
        profundidadLabel.setText("Profundidad (cms):");
        profundidadLabel.setBounds(20, 80, 135, 23);
        profundidadField = new JTextField();
        profundidadField.setBounds(160, 80, 95, 23);

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

        ImageIcon icono = new ImageIcon("img/prisma.jpg");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(240, 120, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel = new JLabel(iconoRedimensionado);
        imagenLabel.setBounds(20, 200, 240, 120);

        contenedor.add(baseLabel);
        contenedor.add(baseField);
        contenedor.add(alturaLabel);
        contenedor.add(alturaField);
        contenedor.add(profundidadLabel);
        contenedor.add(profundidadField);
        contenedor.add(calcularButton);
        contenedor.add(volumenLabel);
        contenedor.add(superficieLabel);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent event) {
        Prisma prisma;
        boolean error = false;
        double base = 0;
        double altura = 0;
        double profundidad = 0;
        try {
            base = Double.parseDouble(baseField.getText());
            altura = Double.parseDouble(alturaField.getText());
            profundidad = Double.parseDouble(profundidadField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        if (!error) {
            prisma = new Prisma(base, altura, profundidad);
            double volumenResult = prisma.calcularVolumen();
            double superficieResult = prisma.calcularSuperficie();
            volumenLabel.setText("Volumen (cm3): " + volumenResult);
            superficieLabel.setText("Superficie (cm2): " + superficieResult);
        }
    }
}
