package proyecto.semestral;

import java.awt.Color;
import javax.swing.*;

public class PanelSecundario extends JPanel {

    private JPanel panel;
    private Menu menu;
    private int posX, posY;

    // TODO: mejorar el contructor, solo llamando crear ventana una vez por singleton
    public PanelSecundario(JFrame v) {
        setXY(0, 640);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(posX, posY, 1280, 40);
        panel.setBackground(Color.red);
        menu = new Menu(posX, posY, panel); // ! COMO LLEGA HASTA ACÁ?
        v.getContentPane().add(panel);
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
