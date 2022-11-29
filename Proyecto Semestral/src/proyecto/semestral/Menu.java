package proyecto.semestral;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// ! Renombrar la clase, se confunde con Menu, nombre adecuado pordia ser "barraInferior" o "barraVentana"
/**
 * Menu que se encuentra debajo de la mesa de pool, util para visualizar score,
 * bolas restantes y resetear la partida
 */
public class Menu {

    private JPanel panel;
    //private DepositoBolas depositoBolas; // ! atributo no necesario, se puede obtene
    private int menuPosX, menuPosY;

    ActionListener botonResetAl;

    /**
     * Constructor de la barrInferior, asigna su panel y define su posicion x,y
     * 
     * @param posX  define la "x" del panel
     * @param posY  define la "y" del panel
     * @param panel define el panel correspondiente
     */
    public Menu(int posX, int posY, JPanel panel) {
        this.panel = panel;
        // this.depositoBolas = depositoBolas; // ! En desuso
        menuPosX = posX;
        menuPosY = posY;
        iniciarEscuchadores();
        mostrarPuntaje();
        mostrarReset();
        mostrarNumeroBolas();
    }

    /**
     * Muesta en la pantalla lo el puntaje correspondiente
     */
    private void mostrarPuntaje() {
        // * tip: .getPuntaje() o hacer variable global que guarde el puntaje
        // ! falta actualizar puntaje
        JLabel puntaje = new JLabel("SCORE: ", SwingConstants.CENTER);
        puntaje.setBounds(menuPosX + 50, menuPosY + 5, 160, 30);
        puntaje.setForeground(Color.BLACK); // color de la letra de la etiqueta
        puntaje.setOpaque(true); // establecemos pintar el fondo de la etiqueta
        // puntaje.setFont(new Font("arial", 3, 20));
        panel.add(puntaje);
    }

    /**
     * Muestra en pantalla el numero de bolas
     */
    private void mostrarNumeroBolas() {
        // TODO: mostrar las bolas restantes
        // ! falta actualizar el numero de bolas restantes
        // * tip: depositoBolas.getSize() o hacer variable global del juego
        JLabel bolas = new JLabel("BALLS: ", SwingConstants.CENTER);
        bolas.setBounds(menuPosX + 220, menuPosY + 5, 160, 30);
        bolas.setForeground(Color.BLACK); // color de la letra de la etiqueta
        bolas.setOpaque(true); // establecemos pintar el fondo de la etiqueta
        // puntaje.setFont(new Font("arial", 3, 20));
        panel.add(bolas);
    }

    /**
     * Muestra en pantalla el boton "reset" y otorga la funcionalidad de boton
     */
    private void mostrarReset() {
        JButton botonReset = new JButton("RESET");
        botonReset.setBounds(menuPosX + 800, menuPosY + 5, 80, 30);
        botonReset.setForeground(Color.black);
        // botonReset.setFont(new Font("arial", 3, 20));
        botonReset.setEnabled(true); // si es false, el boton esta "apagado"
        botonReset.setMnemonic('r'); // la tecla funciona con alt + letra

        botonReset.addActionListener(botonResetAl);

        panel.add(botonReset);
    }

    /**
     * Inicia los escuchadores de los botones disponibles en la barra inferior
     */
    public void iniciarEscuchadores() {
        botonResetAl = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("hola pablo"); // TODO: Hacer que reinicie el juego
            }
        };
    }
}
