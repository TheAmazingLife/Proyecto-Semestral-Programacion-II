package proyecto.semestral;

import java.awt.event.*;
import javax.swing.*;

public class MenuInicial extends JFrame {

    private JPanel panel;
    private Ventana v;

    public MenuInicial(Ventana ventana, HolderNumBolas numBolas) {
        v = ventana;
        crearMenu();
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        JLabel instrucciones = new JLabel();
        JLabel consulta = new JLabel();
        JButton opcion4 = new JButton();
        JButton opcion8 = new JButton();
        JButton opcion12 = new JButton();
        JButton opcion15 = new JButton();
        JButton opcion18 = new JButton();
        JButton opcion21 = new JButton();

        panel.add(instrucciones);
        instrucciones.setText("<html>Bienvenido a la mesa de pool, para poder jugar, presiona el botón<p> jugar. Los controles del juego son los siguientes:<p>- Con la flecha izquierda y derecha cambias el ángulo del taco.<p>- Con la tecla espacio golpeas la bola blanca.<p>- El juego finaliza cuando todas las bolas de colores entraron<p> en las troneras.<p>En todo momento, podrás ver tu puntaje, cuantas bolas has metido<p> en las troneras y tendrás acceso al botón reset, el cual hará que el<p> juego vuelva a comenzar.<html>");
        instrucciones.setBounds(50, 50, 700, 150);

        panel.add(consulta);
        consulta.setText("¿Con cuántas bolas quieres jugar?");
        consulta.setBounds(50, 200, 700, 130);

        panel.add(opcion4);
        opcion4.setText("4");
        opcion4.setBounds(50, 300, 100, 40);
        opcion4.setEnabled(true);

        panel.add(opcion8);
        opcion8.setText("8");
        opcion8.setBounds(160, 300, 100, 40);
        opcion8.setEnabled(true);

        panel.add(opcion12);
        opcion12.setText("12");
        opcion12.setBounds(270, 300, 100, 40);
        opcion12.setEnabled(true);

        panel.add(opcion15);
        opcion15.setText("15");
        opcion15.setBounds(50, 390, 100, 40);
        opcion15.setEnabled(true);

        panel.add(opcion18);
        opcion18.setText("18");
        opcion18.setBounds(160, 390, 100, 40);
        opcion18.setEnabled(true);

        panel.add(opcion21);
        opcion21.setText("21");
        opcion21.setBounds(270, 390, 100, 40);
        opcion21.setEnabled(true);

        ActionListener oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numBolas.setNumeroBolas(4);
                v.actualizarBolas();
                setVisible(false);
                v.setVisible(true);
            }
        };

        ActionListener oyente8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numBolas.setNumeroBolas(8);
                v.actualizarBolas();
                setVisible(false);
                v.setVisible(true);
            }
        };

        ActionListener oyente12 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numBolas.setNumeroBolas(12);
                v.actualizarBolas();
                setVisible(false);
                v.setVisible(true);
            }
        };

        ActionListener oyente15 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numBolas.setNumeroBolas(15);
                v.actualizarBolas();
                setVisible(false);
                v.setVisible(true);
            }
        };

        ActionListener oyente18 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numBolas.setNumeroBolas(18);
                v.actualizarBolas();
                setVisible(false);
                v.setVisible(true);
            }
        };

        ActionListener oyente21 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numBolas.setNumeroBolas(21);
                v.actualizarBolas();
                setVisible(false);
                v.setVisible(true);
            }
        };

        opcion4.addActionListener(oyente4);
        opcion8.addActionListener(oyente8);
        opcion12.addActionListener(oyente12);
        opcion15.addActionListener(oyente15);
        opcion18.addActionListener(oyente18);
        opcion21.addActionListener(oyente21);

    }

    public void crearMenu() {
        setTitle("Menu Mesa de Pool");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        ImageIcon iconoVentana = new ImageIcon(this.getClass().getResource("/recursos/icono.png"));
        this.setIconImage(iconoVentana.getImage()); // set iconoVentana como el icono de Ventana
    }

}
