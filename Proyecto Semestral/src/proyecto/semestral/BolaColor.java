package proyecto.semestral;

import java.awt.Color;

/**
 * BolaColor
 */
public class BolaColor extends Bola {

    public BolaColor(int x, int y, int radio) {
        super(x, y, radio, new Color((int)(Math.random() * 0x1000000)));
    }
}
