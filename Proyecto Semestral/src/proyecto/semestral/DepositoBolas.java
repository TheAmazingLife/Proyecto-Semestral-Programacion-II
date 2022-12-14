package proyecto.semestral;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Clase contenedora de las Bolas en el tablero, almacena, indica tamanio y
 * pinta
 */
public class DepositoBolas {

    private ArrayList<Bola> depositoBolas;

    /**
     * Constructor del deposito de bolas
     */
    public DepositoBolas() {
        depositoBolas = new ArrayList<Bola>();
    }

    /**
     * Agrega una bola a depositoBolas
     *
     * @param bola recibe la bola para anadirla al arreglo depositoBolas
     */
    public void addBola(Bola bola) {
        depositoBolas.add(bola);
    }

    /**
     * Retorna una bola en especifico del deposito de Bolas
     *
     * @param i la i-esima bola a retornar
     */
    public Bola get(int i) {
        return depositoBolas.get(i);
    }

    // TODO: eliminar bola del arreglo
    /**
     * Elimina la bola del depositoBolas
     */
    public void eliminarBola(Bola bola) {
        if (depositoBolas.indexOf(bola) >= 0) {
            depositoBolas.remove(depositoBolas.indexOf(bola));
        }
    }

    /**
     * Retorna el tamanio del deposito para saber la canditad de bolas
     * existentes
     *
     * @return Tamanio del deposito (la cantidad de bolas)
     */
    public int size() {
        return depositoBolas.size();
    }

    /**
     * Pinta todas las bolas existentes en el depositoBolas
     *
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        //System.out.println(depositoBolas.size()); // Indicador de la cantidad de bolas en pantalla
        for (int i = 0; i < depositoBolas.size(); i++) {
            depositoBolas.get(i).paint(g);
        }
    }
}
