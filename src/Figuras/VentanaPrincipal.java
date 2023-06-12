package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, pirámide, cono, prisma, cubo;

    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(new GridLayout(2, 3, 10, 10));

        cilindro = new JButton();
        cilindro.setText("Cilindro");
        cilindro.addActionListener(this);

        esfera = new JButton();
        esfera.setText("Esfera");
        esfera.addActionListener(this);

        pirámide = new JButton();
        pirámide.setText("Pirámide");
        pirámide.addActionListener(this);

        cono = new JButton();
        cono.setText("Cono");
        cono.addActionListener(this);

        prisma = new JButton();
        prisma.setText("Prisma");
        prisma.addActionListener(this);

        cubo = new JButton();
        cubo.setText("Cubo");
        cubo.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(pirámide);
        contenedor.add(cono);
        contenedor.add(prisma);
        contenedor.add(cubo);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esfera) {
            VentanaEsfera esfera = new VentanaEsfera();
            esfera.setVisible(true);
        }
        if (evento.getSource() == cilindro) {
            VentanaCilindro cilindro = new VentanaCilindro();
            cilindro.setVisible(true);
        }
        if (evento.getSource() == pirámide) {
            VentanaPirámide pirámide = new VentanaPirámide();
            pirámide.setVisible(true);
        }
        if (evento.getSource() == cono) {
            VentanaCono cono = new VentanaCono();
            cono.setVisible(true);
        }
        if (evento.getSource() == prisma) {
            VentanaPrisma prisma = new VentanaPrisma();
            prisma.setVisible(true);
        }
        if (evento.getSource() == cubo) {
            VentanaCubo cubo = new VentanaCubo();
            cubo.setVisible(true);
        }
    }
}
