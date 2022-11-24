
package proyecto.semestral;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    private PanelPrincipal panel1;
    private PanelSecundario panel2;
            
    public Ventana() {
        crearVentana();
        panel1 = new PanelPrincipal(this);
        panel2 = new PanelSecundario(this);
    }
    
    public void crearVentana(){
        setTitle("Mesa de Pool");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280, 720);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
