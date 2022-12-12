package proyecto.semestral;

import java.awt.*;

/**
 *
 *
 */
public class Tronera {

    private int posX, posY;
    private int radio;

    public Tronera(int posX, int posY, int radio) {
        this.posX = posX;
        this.posY = posY;
        this.radio = radio;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getRadio() {
        return radio;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(posX, posY, 2 * radio, 2 * radio);
    }
}
