package proyecto.semestral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel implements ActionListener {

    public Jugar jugar;
    private int posX, posY;

    public PanelPrincipal(HolderNumBolas numBolas) {
        super();
        setXY(0, 0);
        setLayout(null);
        setBounds(posX, posY, 1280, 640);
        JLabel background = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/background.jpg")));
        background.setBounds(0, 0, 1280, 720);
        add(background);
        jugar = new Jugar(this, numBolas);
        Timer t = new Timer(16, this);
        t.start();
    }

    /**
     * Setea la posicion de inicio de PanelPrincipal
     *
     * @param x: ubicacion inicial en x
     * @param y: ubicacion inicial en y
     */
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
        jugar.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jugar.moverse();
    }
}
