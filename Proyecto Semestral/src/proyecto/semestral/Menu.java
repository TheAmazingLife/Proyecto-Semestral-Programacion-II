package proyecto.semestral;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Menu que se encuentra debajo de la mesa de pool, util para visualizar score,
 * bolas restantes y resetear la partida
 *
 * @author Pablo Sanhueza
 */
public class Menu {

    private JPanel panel;
    private DepositoBolas depositoBolas;
    private int menuPosX, menuPosY;

    ActionListener botonResetAl;

    public Menu(int posX, int posY, JPanel panel) {
        this.panel = panel;
       // this.depositoBolas = depositoBolas;
        menuPosX = posX;
        menuPosY = posY;
        iniciarEscuchadores();
        mostrarPuntaje();
        mostrarReset();
        mostrarNumeroBolas();
    }

    private void mostrarPuntaje() {
        JLabel puntaje = new JLabel("SCORE: ", SwingConstants.CENTER);
        puntaje.setBounds(menuPosX + 50, menuPosY + 5, 160, 30);
        puntaje.setForeground(Color.BLACK); // color de la letra de la etiqueta
        puntaje.setOpaque(true); // establecemos pintar el fondo de la etiqueta
        //puntaje.setFont(new Font("arial", 3, 20));
        panel.add(puntaje);
    }

    private void mostrarNumeroBolas() {
        JLabel bolas = new JLabel("BALLS: ", SwingConstants.CENTER);
        bolas.setBounds(menuPosX + 220, menuPosY + 5, 160, 30);
        bolas.setForeground(Color.BLACK); // color de la letra de la etiqueta
        bolas.setOpaque(true); // establecemos pintar el fondo de la etiqueta
        //puntaje.setFont(new Font("arial", 3, 20));
        panel.add(bolas);
    }

    
    /**
     * mostrarReset()
     * Mostrar boton reset y funcionalidad de boton
     */
    private void mostrarReset() {
        JButton botonReset = new JButton("RESET");
        botonReset.setBounds(menuPosX + 800, menuPosY + 5, 80, 30);
        botonReset.setForeground(Color.black);
        //botonReset.setFont(new Font("arial", 3, 20));
        botonReset.setEnabled(true); // si es false, el boton esta "apagado"
        botonReset.setMnemonic('r'); // la tecla funciona con alt + letra

        botonReset.addActionListener(botonResetAl);

        panel.add(botonReset);
    }

    public void iniciarEscuchadores() {

        

        botonResetAl = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("hola pablo");
            }
        };
    }
}
