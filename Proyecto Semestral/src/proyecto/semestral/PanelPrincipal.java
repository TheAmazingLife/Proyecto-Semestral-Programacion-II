package proyecto.semestral;

import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {

    public Jugar jugar;
    private int posX, posY;

    public PanelPrincipal(JFrame v) {
        setXY(0, 0);
        setLayout(null);
        setBounds(posX, posY, 1280, 640);
        setBackground(new Color(11, 122, 37));
        jugar = new Jugar(this);
    }

    /**
     * Setea la posicion de inicio de PanelPrincipal
     *
     * @param x: ubicacion inicial en x
     * @param y: ubicacion inicial en y
     */
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

    public void paint(Graphics g) {
        super.paint(g);
        jugar.paint(g);
    }
}
