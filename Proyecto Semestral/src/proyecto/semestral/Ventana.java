package proyecto.semestral;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
/**
 * Ventana que se usa durante todo el código, se van cambiando sus parametros entre
 * el menu inicial y la mesa
 * 
 */
public class Ventana extends JFrame implements KeyListener {

    private PanelPrincipal panel1;
    private PanelSecundario panel2;

    public Ventana(HolderNumBolas numBolas) {
        HolderScore score = new HolderScore();
        crearVentana();
        panel1 = new PanelPrincipal(numBolas, score);
        add(panel1);
        panel2 = new PanelSecundario(this, numBolas, score);
        addKeyListener(this);
    }

    public void crearVentana() {
        setVisible(false);
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
