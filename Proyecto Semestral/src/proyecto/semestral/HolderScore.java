package proyecto.semestral;

/**
 * Patron utilizado para que tanto la ventana del menu inicial como la ventana
 * del juego conozcan la cantidad de bolas elegidas por el usuario
 */
public class HolderScore {

    private int score;

    public HolderScore() {
    }

    public void setScore(int numero) {
        score = numero;
    }

    public int getScore() {
        return score;
    }

}
