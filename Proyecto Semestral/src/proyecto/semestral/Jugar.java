package proyecto.semestral;

import java.awt.*;
import javax.swing.*;

/**
 * Clase que deberia poseer todas las propiedes necesarias para una partida de
 * pool
 *
 */
public class Jugar {

    private int radio;
    private int angulo;
    private int numeroInicialBolas;
    private JPanel panel;
    private DepositoBolas depositoBolas;
    private BolaBlanca bolaBlanca;
    private Taco taco;
    private ConjuntoTroneras conjuntoTroneras;

    // ! Mejorar estructura del programa, ideal tener una mesa e iniciar juego
    // ! (pintar bolas, movimiento etc)
    /**
     * Constructor recibe la ventana e inicializa las bolas
     *
     * @param panel Recibe el panel en la cual mostrarse
     */
    public Jugar(JPanel panel) {
        radio = 10;
        angulo = 0;
        numeroInicialBolas = 12;
        this.panel = panel;
        depositoBolas = new DepositoBolas();
        resetBolaBlanca();
        taco = new Taco(angulo, bolaBlanca);
        conjuntoTroneras = new ConjuntoTroneras();
        inciarBolas();
    }

    public void resetBolaBlanca() {
        int posXBolaBlanca = (int) (Math.random() * 1280);
        int posYBolaBlanca = (int) (Math.random() * 640);
        bolaBlanca = new BolaBlanca(posXBolaBlanca, posYBolaBlanca, radio);
    }

    /**
     * Retorna el numero de bolas en la mesa
     *
     * @return tamanio del arreglo, es decir las bolas en la mesa
     */
    public int getNumBolas() {
        return depositoBolas.size();
    }

    // TODO: limitar posiciones de la generacion de bolas (limitar x e y)
    /**
     * Inicia las bolas, generando bolas en posiciones randomicas, establece su
     * radio y las agrega a la lista de bolas
     */
    public void inciarBolas() {
        for (int i = 0; i < numeroInicialBolas; i++) {
            BolaColor bolaAux = new BolaColor((int) (Math.random() * 1280), (int) (Math.random() * 640), 10);
            depositoBolas.addBola(bolaAux);
        }
    }

    /**
     * Pinta todos los elementos de una partida
     *
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        depositoBolas.paint(g);
        bolaBlanca.paint(g);
        taco.paint(g);
        conjuntoTroneras.paint(g);
    }

    public void modificarAngulo(int tecla) {
        switch (tecla) {
            case 37:
                System.out.println("izq");
                angulo--;
                break;
            case 39:
                System.out.println("der");
                angulo++;
                break;
        }
        taco.actualizarTaco(angulo);
        panel.repaint();
    }
}
