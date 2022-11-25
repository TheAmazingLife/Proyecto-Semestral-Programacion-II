package proyecto.semestral;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class PanelPrincipal extends JPanel {

    private Jugar jugar;
    private int posX, posY;
    private DepositoBolas depositoBolas;

    public PanelPrincipal(JFrame v) {
        setXY(0, 0);
        setLayout(null);
        setBounds(posX, posY, 1280, 640);
        setBackground(Color.green);
        jugar = new Jugar(v);
        depositoBolas = new DepositoBolas();
        setBolas();
    }

    public void setBolas() {
        for (int i = 0; i < jugar.getNumBolas(); i++) {
            depositoBolas.addBola(jugar.getBolas(i));
        }
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
    }
}
