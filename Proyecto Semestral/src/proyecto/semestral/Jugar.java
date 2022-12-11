package proyecto.semestral;

import geometricas.RellenaConPuntos;
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
    private Polygon paredSuperior;
    private Polygon paredInferior;
    private Polygon paredIzquierda;
    private Polygon paredDerecha;

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
        paredSuperior = new Polygon();
        paredInferior = new Polygon();
        paredIzquierda = new Polygon();
        paredDerecha = new Polygon();

        crearContornosMesa();
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
            BolaColor bolaAux1 = new BolaColor((int) (Math.random() * 1200) + 10, (int) (Math.random() * 600) + 20, radio);

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
                break;
            case 37:
                angulo--;
                break;
            case 39:
                angulo++;
                break;
        }
        taco.actualizarTaco(angulo);
        panel.repaint();
    }

    /**
     * Verifica si todas las bolas tienen o no tienen movimiento
     *
     * @return booleano: true si es que no se mueven
     */
    public boolean sePuedeMover() {
        boolean estado = true;
        if (bolaBlanca.vx != 0 || bolaBlanca.vy != 0) {
            estado = false;
        } else {
            for (int i = 0; i < depositoBolas.size(); i++) {
                if (depositoBolas.get(i).vx != 0 || depositoBolas.get(i).vy != 0) {
                    estado = false;
                    break;
                }
            }
        }
        return estado;
    }

    /**
     * Golpea la bola blanca, se le asigna una velocidad en x e y, esta
     * velocidad depende del alguno en el cual se encuentra el taco. Dado que a
     * que pueden exitir infinitos angulos que son iguales, este se determina
     * según las posiciones x's e y's del taco
     */
    public void golpearBola() {
        if (sePuedeMover()) {
            // caso 1er cuadrante
            if (taco.getX1() <= taco.getX2() && taco.getY1() >= taco.getY2()) {
                System.out.println("primer cuadrante");
                bolaBlanca.vx = -(taco.magnitudX() / 10);
                bolaBlanca.vy = taco.magnitudY() / 10;
            } else {
                // caso 2do cuadrante
                if (taco.getX1() >= taco.getX2() && taco.getY1() >= taco.getY2()) {
                    System.out.println("segundo cuadrante");

                    bolaBlanca.vx = taco.magnitudX() / 10;
                    bolaBlanca.vy = taco.magnitudY() / 10;
                } else {
                    // caso 3er cuadrante
                    if (taco.getX1() >= taco.getX2() && taco.getY1() <= taco.getY2()) {
                        System.out.println("tercer cuadrante");

                        bolaBlanca.vx = taco.magnitudX() / 10;
                        bolaBlanca.vy = -(taco.magnitudY() / 10);
                    } else {
                        // caso 4to cuadrante
                        if (taco.getX1() <= taco.getX2() && taco.getY1() <= taco.getY2()) {
                            System.out.println("cuarto cuadrante");

                            bolaBlanca.vx = -(taco.magnitudX() / 10);
                            bolaBlanca.vy = -(taco.magnitudY() / 10);
                        }
                    }
                }
            }
        } else {
            System.out.println("La bola blanca sigue en movimiento");
        }
    }

    /**
     * Interaccion entre todas las bolas, tanto de color como la blanca. Esta
     * interaccion corresponde a verificar si estan colisionando, y lo que
     * provoca dicha colision
     */
    public void moverse() {
        bolaBlanca.mover();
        for (int i = 0; i < depositoBolas.size(); i++) {
            Bola.colisionar(bolaBlanca, depositoBolas.get(i));
            depositoBolas.get(i).mover();
            if (conjuntoTroneras.verificarTroneras(depositoBolas.get(i)) == 1) {
                depositoBolas.eliminarBola(depositoBolas.get(i));
            }

        }
        for (int i = 0; i < depositoBolas.size() - 1; i++) {
            for (int j = i + 1; j < depositoBolas.size(); j++) {
                Bola.colisionar(depositoBolas.get(i), depositoBolas.get(j));
            }
        }
        conjuntoTroneras.verificarTroneras(bolaBlanca);
        taco.actualizarTaco(angulo);
        panel.repaint();
    }

    /**
     * ES POSIBLE QUE ESTE METODO SE DEBA ELIMINAR Metodo que agrega puntos a
     * los bordes de la mesa, cada borde corresponde a un Polygon
     */
    public void crearContornosMesa() {
        Point esquina1 = new Point(0, 0);
        Point esquina2 = new Point(1280, 0);
        Point esquina3 = new Point(0, 680);
        Point esquina4 = new Point(1280, 680);

        RellenaConPuntos.nuevaLinea(esquina1, esquina2, paredSuperior);
        RellenaConPuntos.nuevaLinea(esquina2, esquina3, paredDerecha);
        RellenaConPuntos.nuevaLinea(esquina3, esquina4, paredIzquierda);
        RellenaConPuntos.nuevaLinea(esquina4, esquina1, paredInferior);

    }

    /**
     * Pinta todos los elementos de una partida
     *
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        conjuntoTroneras.paint(g);
        depositoBolas.paint(g);
        bolaBlanca.paint(g);
        if (sePuedeMover()) {
            taco.paint(g);
        }
    }

}
