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
        tronera1 = new Tronera(-10, -10, 20);
        tronera2 = new Tronera(620, -10, 20);
        tronera3 = new Tronera(1235, -10, 20);
        tronera4 = new Tronera(-10, 610, 20);
        tronera5 = new Tronera(620, 610, 20);
        tronera6 = new Tronera(1235, 610, 20);
        conjuntoTroneras.add(tronera1);
        conjuntoTroneras.add(tronera2);
        conjuntoTroneras.add(tronera3);
        conjuntoTroneras.add(tronera4);
        conjuntoTroneras.add(tronera5);
        conjuntoTroneras.add(tronera6);
    }

    /**
     * Pinta todas las troneras
     *
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        System.out.println(conjuntoTroneras.size()); // Indicador de la cantidad de bolas en pantalla
        for (int i = 0; i < conjuntoTroneras.size(); i++) {
            conjuntoTroneras.get(i).paint(g);
        }
    }
}
