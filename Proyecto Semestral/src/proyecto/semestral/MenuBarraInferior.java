package proyecto.semestral;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Menu que se encuentra debajo de la mesa de pool, util para visualizar score,
 * bolas restantes y resetear la partida
 */
public class MenuBarraInferior implements ActionListener {

    private JPanel panel;
    //private DepositoBolas depositoBolas; // ! atributo no necesario, se puede obtene
    private int menuPosX, menuPosY;
    HolderNumBolas numBolas;
    HolderScore score;
    private int intNumBolas;
    private int intScore;
    ActionListener botonResetAl;
    Ventana v;

    JLabel puntaje;
    JLabel bolas;

    /**
     * Constructor de la barrInferior, asigna su panel y define su posicion x,y
     *
     * @param posX define la "x" del panel
     * @param posY define la "y" del panel
     * @param panel define el panel correspondiente
     */
    public MenuBarraInferior(int posX, int posY, JPanel panel, HolderNumBolas numBolas, HolderScore score, Ventana v) {
        puntaje = new JLabel();
        bolas = new JLabel();
        this.panel = panel;
        this.numBolas = numBolas;
        this.score = score;
        this.v = v;
        menuPosX = posX;
        menuPosY = posY;
        intNumBolas = -1;
        intScore = -10;
        iniciarEscuchadores();
        mostrarReset();
        Timer t = new Timer(16, (ActionListener) this);
        t.start();
    }

    public void setScore() {
        if (intScore != score.getScore()) {
            intScore = score.getScore();
            System.out.println(intScore);
            mostrarPuntaje();
        }
    }

    public void setNumeroBolas() {
        if (intNumBolas != numBolas.getNumeroBolas()) {
            intNumBolas = numBolas.getNumeroBolas();
            mostrarNumeroBolas();
        }
    }

    /**
     * Muesta en la pantalla el puntaje correspondiente
     */
    private void mostrarPuntaje() {
        puntaje.setText("Score: " + Integer.toString(intScore));

        // puntaje.setBounds(menuPosX + 350, menuPosY + 10, 160, 30);
        puntaje.setForeground(Color.BLACK); // color de la letra de la etiqueta
        puntaje.setOpaque(true); // establecemos pintar el fondo de la etiqueta
        puntaje.setBackground(new Color(215, 230, 100)); // color de fondo de la etiqueta
        puntaje.setFont(new Font("arial", 3, 20));

        panel.add(puntaje);
        panel.repaint();
    }

    /**
     * Muestra en pantalla el numero de bolas que no han sido entroneradas
     */
    private void mostrarNumeroBolas() {
        System.out.println(intNumBolas);

        bolas.setText("Balls remaining: " + Integer.toString(intNumBolas));

        //bolas.setBounds(menuPosX + 50, menuPosY + 10, 185, 25);
        bolas.setForeground(Color.BLACK); // color de la letra de la etiqueta
        bolas.setOpaque(true); // establecemos pintar el fondo de la etiqueta
        bolas.setBackground(new Color(215, 230, 100)); // color de fondo de la etiqueta
        bolas.setFont(new Font("arial", 3, 20));

        panel.add(bolas);
        panel.repaint();
    }

    /**
     * Muestra en pantalla el boton "reset" y otorga la funcionalidad de boton
     */
    private void mostrarReset() {
        JButton botonReset = new JButton("Reset");
        botonReset.setBounds(menuPosX + 800, menuPosY + 5, 80, 30);
        botonReset.setForeground(Color.black);
        botonReset.setBackground(new Color(204, 255, 255)); // color de fondo de la etiqueta
        botonReset.setFont(new Font("arial", 3, 20));
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
                v.dispose();
                ProyectoSemestral.main(null);
            }
        };
    }

    /**
     * Verifica continuamente si es que hay cambios en bolas restantes y
     * puntaje.Esto gracias al Timer del constructor
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        setScore();
        setNumeroBolas();
    }
}
