package proyecto.semestral;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 * Clase abstracta Bola, contiene las atributos de la bola, x, y, color y radio,
 * ademas se pintan en pantalla.
 * Getters y Setters de cada atributo, ademas de Paint.
 */
abstract class Bola {

    private Color color;
    private Velocidad velocidad;
    protected int x, y;
    protected int radio;

    /**
     * Constructor de la bola
     * 
     * @param x     define la "x" de la bola correspondiente
     * @param y     define la "y" de la bola correspondiente
     * @param radio define el "radio" de la bola correspondiente
     * @param color define el "color" de la bola correspondiente
     */
    public Bola(int x, int y, int radio, Color color) {
        velocidad = new Velocidad();
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
    }

    public Velocidad getVelocidad() {
        return velocidad;
    }

    public double getX() {
        return x;
    }

    /**
     * Obtiene la "y" de la bola
     * 
     * @return posicion "y" de la bola
     */
    public double getY() {
        return y;
    }

    /**
     * Obtiene el radio de la bola
     * 
     * @return "radio" de la bola
     */
    public int getRadio() {
        return radio;
    }

    /**
     * Obtiene el color de la bola
     * 
     * @return "color" de la bola
     */
    public Color getColor() {
        return color;
    }

    /**
     * Asigna el color de la bola
     * 
     * @param ballColor color a asignar a la bola
     */
    public void setColor(Color ballColor) {
        this.color = ballColor;
    }

    /**
     * Asigna la "x" para la bola
     * 
     * @param x "x" a asignar a la bola
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Asigna la "y" para la bola
     * 
     * @param y "y" a asignar a la bola
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Pinta la bola segun su color, posicion y radio
     * 
     * @param g recibe la grafica g
     */
    // ? Asigna el color de manera correcta?
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radio, 2 * radio);
    }
}
