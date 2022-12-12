package geometricas;

/**
 *
 * @author Pablo Sanhueza
 */
import java.awt.Point;
import java.awt.Polygon;

public class Angular {

    /**
     * obtiene un nuevo punto a una cierta distancia y angulo desde la
     * horizontal
     *
     * @param uno: punto actual
     * @param r: radio en pixeles
     * @param alfaGiro: angulo desde la horizontal en PI radianes
     * @return: punto nuevo
     */
    public static Point generaPunto(Point uno, double r, double alfaGiro) {
        int x = (int) ((double) uno.x + r * Math.cos(alfaGiro * Math.PI));
        int y = (int) ((double) uno.y - r * Math.sin(alfaGiro * Math.PI));
        Point p = new Point(x, y);
        return p;
    }

    /**
     *
     * @param uno: punto de referencia
     * @param dos: otro punto
     * @return: el ángulo con respecto a la horizontal
     */
    public static float anguloPI(Point uno, Point dos) {
        float angulo, alto, ancho;
        alto = dos.y - uno.y;
        ancho = dos.x - uno.x;
        angulo = (float) Math.atan2(-(double) alto, (double) ancho);
        return angulo / (float) Math.PI;
    }

    /**
     * Distancia en pixeles entre dos puntos
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double distEntre2Puntos(int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(
                ((double) x1 - (double) x2)
                * ((double) x1 - (double) x2)
                + ((double) y1 - (double) y2)
                * ((double) y1 - (double) y2)
        );
        return d;
    }

    /**
     * distancia en pixeles entre dos puntos
     *
     * @param uno
     * @param dos
     * @return
     */
    public static double distEntre2Puntos(Point uno, Point dos) {
        double d = Math.sqrt(
                ((double) uno.x - (double) dos.x)
                * ((double) uno.x - (double) dos.x)
                + ((double) uno.y - (double) dos.y)
                * ((double) uno.y - (double) dos.y)
        );
        return d;
    }
}
