package proyecto.semestral;

import java.awt.Color;
import javax.swing.*;

public class PanelPrincipal extends JPanel {

    private JPanel panel;
    private Jugar jugar;
    private int posX, posY;

    public PanelPrincipal(JFrame v) {
        setXY(0, 0);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(posX, posY, 1280, 640);
        panel.setBackground(Color.green);
        v.getContentPane().add(panel);
        jugar = new Jugar(v);
        
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
