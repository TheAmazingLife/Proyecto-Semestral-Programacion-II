/**
 * Clase que contiene propiedades de las bolas y ademas, se imprimen en la pantalla
 */
package proyecto.semestral;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 *
 * @author Pablo Sanhueza
 */
abstract class Bola {

    private Color color;
    protected int x, y;
    protected int radio;

    public Bola(int x, int y, int radio, Color color) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getRadio() {
        return radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color ballColor) {
        this.color = ballColor;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {

        g.setColor(color);
        g.fillOval(x, y, 2 * radio, 2 * radio);
    }
}
