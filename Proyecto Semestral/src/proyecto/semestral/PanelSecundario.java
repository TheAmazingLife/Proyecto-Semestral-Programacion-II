
package proyecto.semestral;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
 * Este es el panel en el que se usará la clase MenuBarraInferior.
 * 
 */
public class PanelSecundario extends JPanel {

    private JPanel panel;
    public MenuBarraInferior menu;
    private int posX, posY;
    /**
     * Constructor de PanelSecundario.
     * Define su tamaño, su posicion, crea el menuBarraInferior con los datos necesarios,
     * determina su color y lo agrega todo a la ventana
     * @param v: Ventana en la que se coloca el panel
     * @param numBolas: es el Holder que permite saber el numero de bolas para pasarlo 
     * a la clase MenuBarraInferior
     * @param score: Lo mismo que el parametro anterior pero con el puntaje 
     */
    public PanelSecundario(Ventana v, HolderNumBolas numBolas, HolderScore score) {
        //setXY(0, 640);
        panel = new JPanel();
        panel.setBounds(posX, posY, 1280, 40);
        menu = new MenuBarraInferior(posX, posY, panel, numBolas, score, v);
        panel.setBackground(new Color(128, 64, 0));
        v.getContentPane().add(panel, BorderLayout.SOUTH);
    }

    private void setXY(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }
}