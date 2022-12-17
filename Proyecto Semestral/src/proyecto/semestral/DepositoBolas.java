package proyecto.semestral;

import geometricas.Angular;
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
            depositoBolas.remove(depositoBolas.indexOf(bola));
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
     * Método que se usa para verificar que no hayan bolas de color sobrepuestas.
     * @param depositoBolas: deposito de bolas las cuales se verificarán.
     * @param radio: radio de las bolas.
     * @return true cuando logra reacomodar todas las bolas.
     */
    public boolean verificarPosBolas(DepositoBolas depositoBolas, float radio){
        for (int i = 0; i < depositoBolas.size(); i++) {
            int centroBolaAux1X = (int) (depositoBolas.get(i).x + depositoBolas.get(i).radio);
            int centroBolaAux1Y = (int) (depositoBolas.get(i).y + depositoBolas.get(i).radio);
            for (int j = 0; j < depositoBolas.size(); j++){
                if(i!=j){
                    int centroBolaAux2X = (int) (depositoBolas.get(j).x + depositoBolas.get(j).radio);
                    int centroBolaAux2Y = (int) (depositoBolas.get(j).y + depositoBolas.get(j).radio);
                    if(Angular.distEntre2Puntos(centroBolaAux1X, centroBolaAux1Y, centroBolaAux2X, centroBolaAux2Y) < 2 * radio){
                        depositoBolas.get(i).descolisionar(depositoBolas.get(j));
                        j=100;
                        i=-1;
                    }
                }
            }
        }
        return true;
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
