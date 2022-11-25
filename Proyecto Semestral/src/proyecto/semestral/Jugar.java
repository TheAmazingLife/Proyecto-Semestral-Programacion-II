package proyecto.semestral;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Clase que deberia poseer todas las propiedes necesarias para una partida de
 * pool
 *
 * @author Pablo Sanhueza
 */
public class Jugar {

    private ArrayList<Bola> listaBolas;
    private int numeroInicialBolas;

    public Jugar(JFrame ventana) {
        listaBolas = new ArrayList<Bola>();
        numeroInicialBolas = 12;
        reiniciarBolas();
    }

    public Bola getBolas(int i) {
        return listaBolas.get(i);
    }

    public int getNumBolas() {
        return listaBolas.size();
    }

    public void reiniciarBolas() {
        for (int i = 0; i < numeroInicialBolas; i++) {
            BolaColor bolaAux = new BolaColor((int) (Math.random() * 1280), (int) (Math.random() * 640), 10);
            listaBolas.add(bolaAux);
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < listaBolas.size(); i++) {
            listaBolas.get(i).paint(g);
        }
    }
}
