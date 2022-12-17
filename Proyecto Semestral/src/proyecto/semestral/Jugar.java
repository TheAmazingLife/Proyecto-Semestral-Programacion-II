package proyecto.semestral;

import geometricas.Angular;
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
    HolderNumBolas numBolas;
    HolderScore score;
    private ConjuntoTroneras conjuntoTroneras;

    /**
     * Constructor recibe la ventana e inicializa las bolas
     *
     * @param panel Recibe el panel en la cual mostrarse
     */
    public Jugar(JPanel panel, HolderNumBolas numBolas, HolderScore score) {
        radio = 20;
        angulo = 0;
        this.numBolas = numBolas;
        this.score = score;
        this.panel = panel;
        depositoBolas = new DepositoBolas();
        resetBolaBlanca();
        taco = new Taco();
        conjuntoTroneras = new ConjuntoTroneras();
    }

    public void setNumeroBolas() {
        numeroInicialBolas = numBolas.getNumeroBolas();
        inciarBolas();
    }

    /**
     * La bola blanca aparece en una posicion randomica
     */
    public void resetBolaBlanca() {
        float posXBolaBlanca = (float) (Math.random() * (1280 - 200) + 100);
        float posYBolaBlanca = (float) (Math.random() * (640 - 200) + 100);
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

    /**
     * Inicia las bolas, generando bolas en posiciones randomicas, establece su
     * radio y las agrega a la lista de bolas.
     */
    public void inciarBolas() {
        for (int i = 0; i < numeroInicialBolas; i++) {
            BolaColor bola = new BolaColor((int) (Math.random() * (1280 - 200) + 100), (int) (Math.random() * (640 - 200) + 100), radio);
            depositoBolas.addBola(bola);
            System.out.println("Soy de color" + depositoBolas.get(i).getColor());
        }
        System.out.println("Stop\n.\n");
        for (int i = 0; i < depositoBolas.size(); i++) {
            int centroBolaAux1X = (int) (depositoBolas.get(i).x + depositoBolas.get(i).radio);
            int centroBolaAux1Y = (int) (depositoBolas.get(i).y + depositoBolas.get(i).radio);
            for (int j = 0; j < depositoBolas.size(); j++){
                if(i!=j){
                    int centroBolaAux2X = (int) (depositoBolas.get(j).x + depositoBolas.get(j).radio);
                    int centroBolaAux2Y = (int) (depositoBolas.get(j).y + depositoBolas.get(j).radio);
                    if(Angular.distEntre2Puntos(centroBolaAux1X, centroBolaAux1Y, centroBolaAux2X, centroBolaAux2Y) < 2 * radio){
                        depositoBolas.get(i).descolisionar(depositoBolas.get(j));
                        j=100;
                        i=-1;
                    }
                }
            }
        }
        for (int i = 0; i < depositoBolas.size(); i++) {
            int centroBolaAux2X = (int) (bolaBlanca.x + bolaBlanca.radio);
            int centroBolaAux2Y = (int) (bolaBlanca.y + bolaBlanca.radio);
            int centroBolaAux1X = (int) (depositoBolas.get(i).x + depositoBolas.get(i).radio);
            int centroBolaAux1Y = (int) (depositoBolas.get(i).y + depositoBolas.get(i).radio);
            if(Angular.distEntre2Puntos(centroBolaAux1X, centroBolaAux1Y, centroBolaAux2X, centroBolaAux2Y) < 2 * radio){
                depositoBolas.get(i).descolisionar(bolaBlanca);
                i=-1;
            }
        }
        /*boolean aux=false;
        BolaColor bolaBool = new BolaColor(0,0,0);
        BolaColor bolaAux1 = new BolaColor((int) (Math.random() * (1280 - 200) + 100), (int) (Math.random() * (640 - 200) + 100), radio);
        depositoBolas.addBola(bolaAux1);
        int centroBolaAux1X = (int) (bolaAux1.x + bolaAux1.radio);
        int centroBolaAux1Y = (int) (bolaAux1.y + bolaAux1.radio);
        for (int i = 0; i < numeroInicialBolas; i++) {
            BolaColor bolaAux2 = new BolaColor((int) (Math.random() * (1280 - 200) + 100), (int) (Math.random() * (640 - 200) + 100), radio);
            int centroBolaAux2X = (int) (bolaAux2.x + bolaAux2.radio);
            int centroBolaAux2Y = (int) (bolaAux2.y + bolaAux2.radio);
            if(Angular.distEntre2Puntos(centroBolaAux1X, centroBolaAux1Y, centroBolaAux2X, centroBolaAux2Y) < 2 * radio){
                while(aux==false){
                bolaAux1.descolisionar(bolaBool);
                int centroBolaBoolX= (int) (bolaBool.x + bolaBool.radio);
                int centroBolaBoolY= (int) (bolaBool.y + bolaBool.radio);
                    for (int j = 0; j < depositoBolas.size(); j++) {
                        if(Angular.distEntre2Puntos(centroBolaAux1X, centroBolaAux1Y, centroBolaBoolX, centroBolaBoolY) < 2 * radio){
                            j=+100;
                        }
                        if(j==depositoBolas.size() && Angular.distEntre2Puntos(centroBolaAux1X, centroBolaAux1Y, centroBolaBoolX, centroBolaBoolY) > 2 * radio){
                            aux=true;
                            bolaAux2.setX(bolaBool.getX());
                            bolaAux2.setY(bolaBool.getY());
                        }
                    }
                }
            }else{
                depositoBolas.addBola(bolaAux2);
            }
            System.out.println("Soy de color" + depositoBolas.get(i).getColor());
        }*/
    }

    public void verificarPosBolas() {
        for (int i = 0; i < depositoBolas.size(); i++) {
            for (int j = 1; j < depositoBolas.size() - 1; j++) {
                if (!depositoBolas.get(i).bienPosicionado(depositoBolas.get(j))) {
                    depositoBolas.get(i).descolisionar(depositoBolas.get(j));
                }
            }
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
        taco.actualizarTaco(angulo, bolaBlanca);
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
     *
     * Los cuadrantes se definen considerando el centro de la bolaBlanca como el
     * centro del sistema de referencia, con el eje y mirando hacia arriba
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
                if (conjuntoTroneras.verificarTroneras(bolaBlanca) != 2) {
                    modificarPuntaje(1);
                } else {
                    resetBolaBlanca();
                }
            } else {
                if (conjuntoTroneras.verificarTroneras(bolaBlanca) == 2) {
                    modificarPuntaje(-1);
                    resetBolaBlanca();
                }
            }
        }
        for (int i = 0; i < depositoBolas.size() - 1; i++) {
            for (int j = i + 1; j < depositoBolas.size(); j++) {
                Bola.colisionar(depositoBolas.get(i), depositoBolas.get(j));
            }
        }
        numBolas.setNumeroBolas(depositoBolas.size());
        taco.actualizarTaco(angulo, bolaBlanca);
        panel.repaint();
    }

    public void modificarPuntaje(int puntaje) {
        score.setScore(score.getScore() + puntaje);
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