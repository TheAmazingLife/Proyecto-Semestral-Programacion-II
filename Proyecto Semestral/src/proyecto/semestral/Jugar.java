package proyecto.semestral;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Clase que deberia poseer todas las propiedes necesarias para una partida de
 * pool
 *
 */
public class Jugar {
    // ! Usar DepositoBolas en vez de un arreglo de bolas, metodos redundatnes
    private ArrayList<Bola> listaBolas; // ? atributo dudoso
    private int numeroInicialBolas;

    // ! Mejorar estructura del programa, ideal tener una mesa e iniciar juego
    // ! (pintar bolas, movimiento etc)
    /**
     * Constructor recibe la ventana e inicializa las bolas
     * 
     * @param ventana Recibe la ventana en la cual mostrarse
     */
    public Jugar(JFrame ventana) {
        listaBolas = new ArrayList<Bola>();
        numeroInicialBolas = 12;
        reiniciarBolas();
    }

    /**
     * Recibe un i y retorna la bola en esa i-esima posicion
     * 
     * @param i posicion de bola solicitada
     * @return la bola ubicada en la i-esima posicion
     */
    public Bola getBolas(int i) {
        return listaBolas.get(i);
    }

    /**
     * Retorna el numero de bolas en la mesa
     * 
     * @return tamanio del arreglo, es decir las bolas en la mesa
     */
    public int getNumBolas() {
        return listaBolas.size();
    }

    // ? Agrega las bolas a un arreglo, posible mejora ocupando DepositoBolas
    // ! asignacion confusa.
    // ! nombre confuso, asignar nombre adecuado, posiblemente iniciarBolas, ya que
    // ! puede ser llamado mas de una vez.
    // TODO: limitar posiciones de la generacion de bolas (limitar x e y)
    // ! Reemplazar por DepositoBolas, para facilidad de pintado
    /**
     * Inicia las bolas, generando bolas en posiciones randomicas, establece su
     * radio y las agrega a la lista de bolas
     */
    public void reiniciarBolas() {
        for (int i = 0; i < numeroInicialBolas; i++) {
            BolaColor bolaAux = new BolaColor((int) (Math.random() * 1280), (int) (Math.random() * 640), 10);
            listaBolas.add(bolaAux);
        }
        // BolaBlanca bolaAux = new BolaBlanca((int) (Math.random() * 1280), (int)
        // (Math.random() * 640), 10);
        // listaBolas.add(bolaAux);
    }

    // ! Metodo redundante, mejor tener DepositoBolas y llamar su metodo paint
    /**
     * Pinta todas las bolas existentes en la lista de bolas
     * 
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        for (int i = 0; i < listaBolas.size(); i++) {
            listaBolas.get(i).paint(g);
        }
    }
}
