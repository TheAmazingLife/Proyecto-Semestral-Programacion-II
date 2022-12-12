package proyecto.semestral;

/**
 * Patron utilizado para que tanto la ventana del menu inicial como la ventana
 * del juego conozcan la cantidad de bolas elegidas por el usuario
 */
public class HolderNumBolas {

    private int numeroBolas;

    public HolderNumBolas() {
    }

    public void setNumeroBolas(int numero) {
        numeroBolas = numero;
    }

    public int getNumeroBolas() {
        return numeroBolas;
    }

}
