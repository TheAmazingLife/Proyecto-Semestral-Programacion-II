package proyecto.semestral;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class PanelSecundario extends JPanel {

    private JPanel panel;
    public MenuBarraInferior menu;
    private int posX, posY;

    public PanelSecundario(Ventana v, HolderNumBolas numBolas) {
        //setXY(0, 640);
        panel = new JPanel();
        panel.setBounds(posX, posY, 1280, 40);
        menu = new MenuBarraInferior(posX, posY, panel, numBolas, v);
        panel.setBackground(new Color(128, 64, 0));
        v.getContentPane().add(panel, BorderLayout.SOUTH);
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
}
