package proyecto.semestral;

import java.awt.Color;
import java.awt.Point;

/**
 * BolaBlanca
 */
public class BolaBlanca extends Bola {

    public BolaBlanca(int x, int y, int radio) {
        super(x, y, radio, Color.white);
    }
/**
 * retorna la posicion exacta, en pixeles. del centro de la bola blanca
 * @return 
 */
    public Point getCentro() {
        Point centro = new Point(x + radio, y + radio);
        return centro;
    }
}
