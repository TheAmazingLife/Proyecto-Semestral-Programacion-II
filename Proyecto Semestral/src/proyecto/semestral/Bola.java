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
class Bola extends JPanel {

    private Color color;
    private double x, y;
    private double radio;

    public Bola(double x, double y, double radio, Color color) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
    }

    /*
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
     */
    public double getRadio() {
        return radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color ballColor) {
        this.color = ballColor;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void paint(Graphics2D g) {

        super.paint(g);
        g.setColor(color);
        g.fillOval(0, 0, 100, 100);
    }

}
