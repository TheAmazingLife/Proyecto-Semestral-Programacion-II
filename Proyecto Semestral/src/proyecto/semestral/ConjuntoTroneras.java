package proyecto.semestral;

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
     * de las troneras, o bien, las que poseen mas de la mitad de su radio mas
     * un cuarto del radio dentro de la tronera
     *
     * @param bola: bola a verificar
     */
    public int verificarTroneras(Bola bola) {
        // tipoBola = 0: no hay bola en la tronera
        // tipoBola = 1: hay bola de color en la tronera
        // tipoBola = 2: hay bola blanca en la tronera

        int tipoBola = 0;

        for (int i = 0; i < conjuntoTroneras.size(); i++) {
            if (i < 3) {
                if (bola.getX() + bola.getRadio() + bola.getRadio() / 3 >= conjuntoTroneras.get(i).getX()
                        && bola.getX() + bola.getRadio() + bola.getRadio() / 3 <= conjuntoTroneras.get(i).getX() + 2 * conjuntoTroneras.get(i).getRadio()
                        && bola.getY() + 2 * bola.getRadio() <= conjuntoTroneras.get(i).getY() + 2 * conjuntoTroneras.get(i).getRadio()) {
                    System.out.println("PILLADO ARRIBA" + " " + bola.getClass());
                    if ("class proyecto.semestral.BolaBlanca".equals(bola.getClass() + "")) {
                        System.out.println("BOLA BLANCAA");
                        tipoBola = 2;
                    } else {
                        tipoBola = 1;
                    }
                }
            } else {
                if (bola.getX() >= conjuntoTroneras.get(i).getX()
                        && bola.getX() + bola.getRadio() + bola.getRadio() / 3 <= conjuntoTroneras.get(i).getX() + 2 * conjuntoTroneras.get(i).getRadio()
                        && bola.getY() + bola.getRadio() + bola.getRadio() / 3 >= conjuntoTroneras.get(i).getY()) {
                    System.out.println("PILLADO ABAJO");
                    if ("class proyecto.semestral.BolaBlanca".equals(bola.getClass() + "")) {
                        System.out.println("BOLA BLANCAA");
                        tipoBola = 2;
                    } else {
                        tipoBola = 1;
                    }
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
