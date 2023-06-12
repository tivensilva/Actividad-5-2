package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, profundidad, volumen, superficie;
    private JTextField campoBase, campoAltura, campoProfundidad;
    private JButton calcular;
    private JLabel imagenLabel;

    public VentanaPrisma() {
        inicio();
        setTitle("Prisma");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel();
        base.setText("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        profundidad = new JLabel();
        profundidad.setText("Profundidad (cms):");
        profundidad.setBounds(20, 80, 135, 23);
        campoProfundidad = new JTextField();
        campoProfundidad.setBounds(160, 80, 95, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(120, 110, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 140, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 170, 135, 23);

        ImageIcon icono = new ImageIcon("img/prisma.jpg");
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(240, 120, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        imagenLabel = new JLabel(iconoRedimensionado);
        imagenLabel.setBounds(20, 200, 240, 120);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(profundidad);
        contenedor.add(campoProfundidad);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagenLabel);
    }

    public void actionPerformed(ActionEvent event) {
        Prisma prisma;
        boolean error = false;
        double base = 0;
        double altura = 0;
        double profundidad = 0;
        try {
            base = Double.parseDouble(campoBase.getText());
            altura = Double.parseDouble(campoAltura.getText());
            profundidad = Double.parseDouble(campoProfundidad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        if (!error) {
            prisma = new Prisma(base, altura, profundidad);
            double volumenResult = prisma.calcularVolumen();
            double superficieResult = prisma.calcularSuperficie();
            volumen.setText("Volumen (cm3): " + volumenResult);
            superficie.setText("Superficie (cm2): " + superficieResult);
        }
    }
}
