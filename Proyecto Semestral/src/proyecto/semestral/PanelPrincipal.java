
package proyecto.semestral;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
    private JPanel panel;
    
    public PanelPrincipal(JFrame v){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1280, 680);
        v.getContentPane().add(panel);
    }
}
