package proyecto.semestral;

import geometricas.RellenaConPuntos;
import java.awt.*;
import static java.lang.Math.*;

/**
 *
 * @author Pablo Sanhueza
 */
public class Taco {

    Polygon poligono;
    BolaBlanca bolaBlanca;
    int angulo;

// determina si el taco es visible, si se golpea la bola blanca, debe desaparecer el taco
    private boolean dibujarTaco;

    public Taco(int angulo, BolaBlanca bolaBlanca) {
        dibujarTaco = false;
        this.bolaBlanca = bolaBlanca;
        this.angulo = 0;
        actualizarTaco(angulo);
    }

    /**
     * Cambia la posicion del taco dependiendo de las teclas que presione el
     * jugador
     *
     * @param angulo: angulo en grados sexagesimales que varía según el jugardor
     * presione las teclas
     */
    public void actualizarTaco(int angulo) {
        System.out.println("ANGULO: " + angulo * 180 / PI);
        poligono = new Polygon();
        int x1 = (int) (bolaBlanca.getCentro().getX() + (bolaBlanca.getRadio() + 5) * cos(Math.toRadians(angulo)));
        int y1 = (int) (bolaBlanca.getCentro().getY() + (bolaBlanca.getRadio() + 5) * sin(Math.toRadians(angulo)));
        int x2 = (int) (bolaBlanca.getCentro().getX() + (bolaBlanca.getRadio() + 100) * cos(Math.toRadians(angulo)));
        int y2 = (int) (bolaBlanca.getCentro().getY() + (bolaBlanca.getRadio() + 100) * sin(Math.toRadians(angulo)));
        poligono.addPoint(x1, y1);
        poligono.addPoint(x2, y2);
        System.out.println("Bola blanca: (" + bolaBlanca.getCentro().getX() + ", " + bolaBlanca.getCentro().getY() + " )");
        System.out.println("pos1: (" + x1 + ", " + y1 + " )");
        System.out.println("pos2: (" + x2 + ", " + y2 + " )");
        RellenaConPuntos.nuevaLinea(x1, y1, x2, y2, poligono);

    }

    public void paint(Graphics g) {
        System.out.println("puntos: " + poligono.npoints);
        g.drawPolyline(poligono.xpoints, poligono.ypoints, poligono.npoints);
        g.setColor(Color.black);
    }
}
