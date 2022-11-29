package proyecto.semestral;

import geometricas.RellenaConPuntos;
import java.awt.*;
import static java.lang.Math.*;

/**
 * Clase taco, pinta el taco, posiciona al rededor de la bola blanca, y se
 * actualiza.
 */
public class Taco {

    Polygon poligono;
    BolaBlanca bolaBlanca;
    int angulo;

    // determina si el taco es visible, si se golpea la bola blanca, debe
    // desaparecer el taco
    // private boolean dibujarTaco;

    // TODO: Hacer un constructor vacio, que solo se le asigne una bola y que llame
    // * actualizar taco, no es buena practica tener un constructor tan complejo
    // ? Mas efectivo constructor vacio, y solo llamar a actualizar taco
    /**
     * Constructor del taco, lo posiciona en referencia a la bola blanca
     * 
     * @param angulo     Angulo en grados de el taco
     * @param bolaBlanca Bola blanca en cual ocupar de referencia
     */
    public Taco(int angulo, BolaBlanca bolaBlanca) {
        //dibujarTaco = false;
        this.bolaBlanca = bolaBlanca;
        this.angulo = 0;
        actualizarTaco(angulo);
    }

    /**
     * Cambia la posicion del taco dependiendo de las teclas que presione el
     * jugador
     *
     * @param angulo angulo en grados sexagesimales que varía según el jugardor
     *               presione las teclas
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
        System.out.println(
                "Bola blanca: (" + bolaBlanca.getCentro().getX() + ", " + bolaBlanca.getCentro().getY() + " )");
        System.out.println("pos1: (" + x1 + ", " + y1 + " )");
        System.out.println("pos2: (" + x2 + ", " + y2 + " )");
        RellenaConPuntos.nuevaLinea(x1, y1, x2, y2, poligono);

    }

    /**
     * Pinta el taco dibujando una linea poligonal
     * 
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        System.out.println("puntos: " + poligono.npoints);
        g.drawPolyline(poligono.xpoints, poligono.ypoints, poligono.npoints);
        g.setColor(Color.black);
    }
}
