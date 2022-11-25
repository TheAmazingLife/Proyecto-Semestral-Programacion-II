/**
 *  Clase que deberia poseer todas las propiedes necesarias para una partida de pool
 */

package proyecto.semestral;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Pablo Sanhueza
 */
public class Jugar {

    private JFrame ventana;
    private ArrayList<Bola> listaBolas;
    private int numeroInicialBolas;

    public Jugar(JFrame ventana) {
        this.ventana = ventana;
        listaBolas = new ArrayList<Bola>();
        numeroInicialBolas = 12;
        reiniciarBolas();
    }

    public void reiniciarBolas() {
        for (int i = 0; i < numeroInicialBolas; i++) {
            //Bola bolaAux = new Bola((double) (Math.random() * panel.getX() + panel.getX()), (double) (Math.random() * panel.getY() + panel.getY()), 10, new Color((int) (Math.random() * 0x1000000)));
            Bola bolaAux = new Bola(10, 10, 10, Color.white);
            ventana.add(bolaAux);
            //listaBolas.add(bolaAux);
        }
    }
}
