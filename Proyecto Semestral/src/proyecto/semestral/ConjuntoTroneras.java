package proyecto.semestral;

import geometricas.Angular;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Para evitar exceso de código en PanelPrincipal, ConjuntoTroneras es una clase
 * que, dentro de ella, crea cada tronera, verifica si hay alguna bola dentro de
 * cada una de ellas, y , además, también pinta las troneras
 */
public class ConjuntoTroneras {

    private ArrayList<Tronera> conjuntoTroneras;

    private Tronera tronera1;
    private Tronera tronera2;
    private Tronera tronera3;
    private Tronera tronera4;
    private Tronera tronera5;
    private Tronera tronera6;

    /**
     * Constructor del deposito de bolas
     */
    public ConjuntoTroneras() {
        conjuntoTroneras = new ArrayList<Tronera>();
        inicializar();
    }

    /**
     * Inicializa las troneras, dado que tiene siempre una cantidad fija,
     * siempre se crean las mismas seis, y siempre en las mismas posiciones
     */
    public void inicializar() {
        tronera1 = new Tronera(-10, -20, 50);
        tronera2 = new Tronera(620, -20, 50);
        tronera3 = new Tronera(1200, -20, 50);
        tronera4 = new Tronera(-10, 570, 50);
        tronera5 = new Tronera(620, 570, 50);
        tronera6 = new Tronera(1200, 570, 50);
        conjuntoTroneras.add(tronera1);
        conjuntoTroneras.add(tronera2);
        conjuntoTroneras.add(tronera3);
        conjuntoTroneras.add(tronera4);
        conjuntoTroneras.add(tronera5);
        conjuntoTroneras.add(tronera6);
    }

    /**
     * Verifica si alguna bola es entronerada, se procede a verificar cada una
     * de las seis troneras de la mesa
     *
     * Las bolas entroneradas correspondan a las que: caben completamente dentro
     * de las troneras, o bien, las que poseen una distancia euclidiana desde su
     * centro hasta el centro de la tronera que sea menor al radio de la bola
     *
     * @param bola: bola a verificar
     */
    public int verificarTroneras(Bola bola) {
        // tipoBola = 0: no hay bola en la tronera
        // tipoBola = 1: hay bola de color en la tronera
        // tipoBola = 2: hay bola blanca en la tronera

        int tipoBola = 0;

        for (int i = 0; i < conjuntoTroneras.size(); i++) {
            int centroBolaX = (int) (bola.x + bola.radio);
            int centroBolaY = (int) (bola.y + bola.radio);
            int centroTroneraX = (int) (conjuntoTroneras.get(i).getX() + conjuntoTroneras.get(i).getRadio());
            int centroTroneraY = (int) (conjuntoTroneras.get(i).getY() + conjuntoTroneras.get(i).getRadio());
            if (Angular.distEntre2Puntos(centroBolaX, centroBolaY, centroTroneraX, centroTroneraY) < 2 * bola.radio) {
                if ("class proyecto.semestral.BolaBlanca".equals(bola.getClass() + "")) {
                    System.out.println("BOLA BLANCAA");
                    tipoBola = 2;
                } else {
                    tipoBola = 1;
                }
            }
        }
        return tipoBola;
    }

    /**
     * Pinta todas las troneras
     *
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        //System.out.println(conjuntoTroneras.size()); // Indicador de la cantidad de bolas en pantalla
        for (int i = 0; i < conjuntoTroneras.size(); i++) {
            conjuntoTroneras.get(i).paint(g);
        }
    }
}
