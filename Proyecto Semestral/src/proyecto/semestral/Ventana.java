package proyecto.semestral;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame implements KeyListener {

    private PanelPrincipal panel1;
    private PanelSecundario panel2;

    public Ventana(HolderNumBolas numBolas) {
        crearVentana();
        panel1 = new PanelPrincipal(numBolas);
        add(panel1);
        panel2 = new PanelSecundario(this, numBolas);
        addKeyListener(this);
    }

    public void crearVentana() {
        setVisible(true);
        setTitle("Mesa de Pool");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        ImageIcon iconoVentana = new ImageIcon(this.getClass().getResource("/recursos/icono.png"));
        this.setIconImage(iconoVentana.getImage()); // set iconoVentana como el icono de Ventana
    }

    public void actualizarBolas() {
        panel1.jugar.setNumeroBolas();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        panel1.jugar.interaccion(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
