package proyecto.semestral;

import java.awt.*;

/**
 * Dentro del juego, la tronera es el agujero por donde caen las bolas, está clase
 * se usa en conjunto troneras, para así crear las 6 troneras
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
    /**
     * Pinta el area que abarcara la tronera
     *
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(posX, posY, 2 * radio, 2 * radio);
    }
}
