package proyecto.semestral;

import java.awt.Color;

/**
 * BolaColor extiende a Bola y toma sus propiedades, asigna un color randomico a
 * la bola
 */
public class BolaColor extends Bola {

    // ? Posible asignacion de color, mediante colores previamente asignados en un
    // ? arreglo, esto evitaria el posible color Blanco
    // TODO: limitar con rango, excluir claras
    /**
     * Constructor de BolaColor, llama al constructor de Bola y asigna un color
     * aleatorio
     *
     * @param x define la "x" de la bola correspondiente
     * @param y define la "y" de la bola correspondiente
     * @param radio define el radio de la bola correspondiente
     */
    public BolaColor(float x, float y, int radio) {
        super(x, y, radio, new Color((int) (Math.random() * 0x1000000)));
    }
}
