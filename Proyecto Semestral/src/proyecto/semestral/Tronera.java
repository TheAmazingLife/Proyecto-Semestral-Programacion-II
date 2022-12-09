package proyecto.semestral;

import java.awt.*;

/**
 *
 *
 */
public class Tronera {

    int posX, posY;
    int radio;

    public Tronera(int posX, int posY, int radio) {
        this.posX = posX;
        this.posY = posY;
        this.radio = radio;
    }

    public void verificarTronera() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(posX, posY, 2 * radio, 2 * radio);
    }
}
