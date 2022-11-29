package proyecto.semestral;

import java.awt.Color;
import java.awt.Point;

/**
 * BolaBlanca extiende a Bola y toma sus propiedades, asigna color Blanco a la
 * bola
 */
public class BolaBlanca extends Bola {
    /**
     * Constructor de BolaBlanca, llama al constructor de Bola y asigna un color
     * blanco
     * 
     * @param x     define la "x" de la bola correspondiente
     * @param y     define la "y" de la bola correspondiente
     * @param radio define el radio de la bola correspondiente
     */
    public BolaBlanca(int x, int y, int radio) {
        super(x, y, radio, Color.white);
    }

    /**
     * Retorna la posicion central de la bola
     * 
     * @return Posicion en pixeles del centro de la bola blanca
     */
    public Point getCentro() {
        Point centro = new Point(x + radio, y + radio);
        return centro;
    }
}
