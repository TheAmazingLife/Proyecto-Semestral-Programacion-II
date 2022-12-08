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
        radio = 20;
        angulo = 0;
        numeroInicialBolas = 12;
        this.panel = panel;
        depositoBolas = new DepositoBolas();
        resetBolaBlanca();
        taco = new Taco(angulo, bolaBlanca);
        conjuntoTroneras = new ConjuntoTroneras();
        inciarBolas();
    }

    /**
     * La bola blanca aparece en una posicion randomica
     */
    public void resetBolaBlanca() {
        float posXBolaBlanca = (float) (Math.random() * 1280);
        float posYBolaBlanca = (float) (Math.random() * 640);
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
     * radio y las agrega a la lista de bolas.
     */
    public void inciarBolas() {
        for (int i = 0; i < numeroInicialBolas; i++) {
            BolaColor bolaAux1 = new BolaColor((int) (Math.random() * 1200) + 30, (int) (Math.random() * 600) + 20, radio);

            // no permitir que aparezca "una bola encima de otra"
            for (int j = 0; j < depositoBolas.size(); j++) {
                BolaColor bolaAux2 = (BolaColor) depositoBolas.get(j);
                if (bolaAux1 != bolaAux2) {
                    if (bolaAux1.hayColision(bolaAux2)) {
                        bolaAux1.descolisionar(bolaAux2);
                    }
                }
            }

            // Una vez la bola tenga una posicion adecuada, se agrega al deposito
            depositoBolas.addBola(bolaAux1);
        }
    }

    /**
     * Son las opciones que tiene el usuario para realizar Estas son: Cambiar el
     * angulo del taco (moverse de "izquierda a derecha") Golpear la bola blanca
     *
     * @param tecla: corresponde a la opcion elegida por el usuario
     */
    public void interaccion(int tecla) {

        switch (tecla) {
            case 32:
                golpearBola();
                System.out.println("spc");
                break;
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

    /**
     * Golpea la bola blanca, se le asigna una velocidad
     */
    public void golpearBola() {
        Velocidad vel = new Velocidad(taco.getX2() - taco.getX1(), taco.getY2() - taco.getY1());
        vel.escalar(-0.25f);
        bolaBlanca.setVelocidad(vel);
    }

    /**
     * Interaccion entre todas las bolas, tanto de color como la blanca. Esta
     * interaccion corresponde a verificar si estan colisionando, lo que provoca
     * dicha colision
     */
    public void moverse() {
        for (int i = 0; i < depositoBolas.size(); i++) {
            Bola b1 = depositoBolas.get(i);

            b1.mover();
            bolaBlanca.mover();

            // hace lectura de todas las posibles colisiones
            for (int j = 0; j < depositoBolas.size(); j++) {
                if (i == j) {
                    continue;
                }

                Bola b2 = depositoBolas.get(j);

                if (b1.hayColision(b2)) {
                    b1.colisionar(b2);
                }
                if (bolaBlanca.hayColision(b2)) {
                    bolaBlanca.colisionar(b2);
                }
            }
        }
        taco.actualizarTaco(angulo);
        panel.repaint();
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

}
