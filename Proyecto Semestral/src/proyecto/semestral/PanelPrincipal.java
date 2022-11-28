package proyecto.semestral;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class PanelPrincipal extends JPanel {

    private Jugar jugar;
    private int posX, posY;
    private DepositoBolas depositoBolas;
    private BolaBlanca bolaBlanca;
    private int radio;
    private int PosXCentro, PosYCentro;
    private Taco taco;
    private int angulo;

    public PanelPrincipal(JFrame v) {
        setXY(0, 0);
        setLayout(null);
        setBounds(posX, posY, 1280, 640);
        setBackground(new Color(11, 122, 37));
        radio = 10;
        angulo = 0;
        jugar = new Jugar(v);
        depositoBolas = new DepositoBolas();
        setBolas();
        resetBolaBlanca();
        taco = new Taco(angulo, bolaBlanca);

    }

    public void setBolas() {
        for (int i = 0; i < jugar.getNumBolas(); i++) {
            depositoBolas.addBola(jugar.getBolas(i));
        }
    }

    public void resetBolaBlanca() {
        int posXBolaBlanca = (int) (Math.random() * 1280);
        int posYBolaBlanca = (int) (Math.random() * 640);
        bolaBlanca = new BolaBlanca(posXBolaBlanca, posYBolaBlanca, radio);
    }

    private void setXY(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public void paint(Graphics g) {
        super.paint(g);
        depositoBolas.paint(g);
        bolaBlanca.paint(g);
        taco.paint(g);
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
        this.repaint();
    }

}
