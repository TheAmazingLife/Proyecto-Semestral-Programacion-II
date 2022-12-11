package proyecto.semestral;

/**
 * Llama a la ventana e inicia el juego
 *
 * @author Pablo Sanhueza
 * @author Joaquin San Martin
 * @author Luciano Argomedo
 */
public class ProyectoSemestral {

    public static void main(String[] args) {
        HolderNumBolas numBolas = new HolderNumBolas();
        Ventana ventana = new Ventana(numBolas);
        ventana.setVisible(false);
        MenuInicial menuInicial = new MenuInicial(ventana, numBolas);
        menuInicial.setVisible(true);
    }
}
