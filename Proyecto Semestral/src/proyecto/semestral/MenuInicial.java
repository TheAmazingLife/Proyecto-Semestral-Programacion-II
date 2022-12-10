
package proyecto.semestral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class MenuInicial extends JFrame {
    
    private JPanel panel;
    private JLabel texto;
    private JButton boton;
    private Ventana v;
    
    public MenuInicial() {
        crearMenu();
        panel= new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        texto =new JLabel();
        boton= new JButton();
        panel.add(texto);
        panel.add(boton);
        texto.setText("<html>Bienvenido a la mesa de pool, para poder jugar, presiona el botón<p> jugar.Los controles del juego son los siguientes:<p>-Con la flecha izquierda y derecha cambias el ángulo del taco.<p>-Con la tecla espacio golpeas la bola blanca.<p>-Ganas cuando todas las bolas de colores entraron en las troneras.<p>En todo momento, podrás ver tu puntaje, cuantas bolas has metido<p> en las troneras y tendrás acceso al botón reset, el cual hará que el<p> juego vuelva a comenzar.<html>");
        texto.setBounds(0,0,700,120);
        boton.setText("Jugar");
        boton.setBounds(200, 300, 100, 40);
        boton.setEnabled(true);
        
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                v = new Ventana();
                v.setVisible(true);
                System.out.println("POCHITA");
            }
        };
        boton.addActionListener(oyente);

    }
    
    public void crearMenu() {
        setTitle("Menu Mesa de Pool");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,500);
        setVisible(true);
        setLocationRelativeTo(null);
        ImageIcon iconoVentana = new ImageIcon(this.getClass().getResource("/recursos/icono.png"));
        this.setIconImage(iconoVentana.getImage()); // set iconoVentana como el icono de Ventana
    }


}
