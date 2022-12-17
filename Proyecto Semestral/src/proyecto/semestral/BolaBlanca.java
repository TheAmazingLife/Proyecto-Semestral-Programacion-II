package proyecto.semestral;

import geometricas.Angular;
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
     * @param x define la "x" de la bola correspondiente
     * @param y define la "y" de la bola correspondiente
     * @param radio define el radio de la bola correspondiente
     */
    public BolaBlanca(float x, float y, float radio) {
        super(x, y, radio, Color.white);
    }
    /**
     * Método para asegurarse que la bola blanca no esté sobrepuesta con una bola
     * de color.
     * @param depositoBolas: deposito de las bolas de color que se comprobarán.
     * @param radio: radio de las bolas.
     * @return true cuando logra reacomodar las bolas
     */
    public boolean verificarPosBolaBlanca(DepositoBolas depositoBolas, float radio){
        for (int i = 0; i < depositoBolas.size(); i++) {
            int centroBolaAux2X = (int) (this.x + this.radio);
            int centroBolaAux2Y = (int) (this.y + this.radio);
            int centroBolaAux1X = (int) (depositoBolas.get(i).x + depositoBolas.get(i).radio);
            int centroBolaAux1Y = (int) (depositoBolas.get(i).y + depositoBolas.get(i).radio);
            if(Angular.distEntre2Puntos(centroBolaAux1X, centroBolaAux1Y, centroBolaAux2X, centroBolaAux2Y) < 2 * radio){
                depositoBolas.get(i).descolisionar(this);
                i=-1;
            }
        } 
        return true;
    }
    
    /**
     * Retorna la posicion central de la bola
     *
     * @return Posicion en pixeles del centro de la bola blanca
     */
    public Point getCentro() {
        Point centro = new Point((int) (x + radio), (int) (y + radio));
        return centro;
    }
}
