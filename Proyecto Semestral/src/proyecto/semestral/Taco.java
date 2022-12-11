package proyecto.semestral;

import geometricas.RellenaConPuntos;
import java.awt.*;
import static java.lang.Math.*;

/**
 * Clase taco, pinta el taco, posiciona al rededor de la bola blanca, y se
 * actualiza.
 */
public class Taco {

    public int x1, x2;
    public int y1, y2;
    Polygon poligono;

    public Taco() {
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public float magnitudX() {
        return (float) sqrt((x2 - x1) * (x2 - x1));
    }

    public float magnitudY() {
        return (float) sqrt((y2 - y1) * (y2 - y1));

    }

    /**
     * Cambia la posicion del taco dependiendo de las teclas que presione el
     * jugador
     *
     * @param angulo angulo en grados sexagesimales que varía según el jugardor
     * presione las teclas
     */
    public void actualizarTaco(int angulo, BolaBlanca bolaBlanca) {
        //System.out.println("ANGULO: " + angulo * 180 / PI);
        poligono = new Polygon();
        x1 = (int) (bolaBlanca.getCentro().getX() + (bolaBlanca.getRadio() + 5) * cos(Math.toRadians(angulo)));
        y1 = (int) (bolaBlanca.getCentro().getY() + (bolaBlanca.getRadio() + 5) * sin(Math.toRadians(angulo)));
        x2 = (int) (bolaBlanca.getCentro().getX() + (bolaBlanca.getRadio() + 150) * cos(Math.toRadians(angulo)));
        y2 = (int) (bolaBlanca.getCentro().getY() + (bolaBlanca.getRadio() + 150) * sin(Math.toRadians(angulo)));
        poligono.addPoint(x1, y1);
        poligono.addPoint(x2, y2);

        //se le otorga grosor y perspectiva al taco
        poligono.addPoint(x2, y2 - 10);
        RellenaConPuntos.nuevaLinea(x1, y1, x2, y2, poligono);

    }

    /**
     * Pinta el taco dibujando una linea poligonal
     *
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillPolygon(poligono.xpoints, poligono.ypoints, poligono.npoints);
    }
}
