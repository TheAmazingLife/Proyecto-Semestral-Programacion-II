package proyecto.semestral;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Pablo Sanhueza
 */
public class DepositoBolas {

    private ArrayList<Bola> depositoBolas;

    public DepositoBolas() {
        depositoBolas = new ArrayList<Bola>();
    }

    public void addBola(Bola bola) {
        depositoBolas.add(bola);
    }

    public int size() {
        return depositoBolas.size();
    }

    public void paint(Graphics g) {
        System.out.println(depositoBolas.size());
        for (int i = 0; i < depositoBolas.size(); i++) {
            depositoBolas.get(i).paint(g);
        }
    }
}
