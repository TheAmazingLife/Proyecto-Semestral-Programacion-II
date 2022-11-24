
package proyecto.semestral;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelSecundario {
        private JPanel panel;
    
    public PanelSecundario(JFrame v){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 680, 1280, 40);
        v.getContentPane().add(panel);
    }
}
