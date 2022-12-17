
package proyecto.semestral;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 *Test unitario para el deposito de bolas.
 * Se crean una cantidad de bolas con la misma posición y otras de forma al azar,
 * luego de esto se proceden a chequear las posición y cambiar para que ninguna 
 * bola este sobrepuesta.
 *
 */
public class DepositoBolasTest {
    
    private DepositoBolas depositoBolas;
    private BolaBlanca bolaBlanca;
    
    public DepositoBolasTest() {
        depositoBolas = new DepositoBolas();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TestVerificarPos(){
        BolaColor bola1 = new BolaColor((int) (Math.random() * (1280 - 200) + 100), (int) (Math.random() * (640 - 200) + 100), 20);
        BolaColor bola2 = new BolaColor((int) (bola1.getX()), (int) (bola1.getY()), 20);
        BolaColor bola3 = new BolaColor((int) (Math.random() * (1280 - 200) + 100), (int) (Math.random() * (640 - 200) + 100), 20);
        BolaColor bola4 = new BolaColor((int) (bola3.getX()), (int) (bola3.getY()), 20);
        BolaColor bola5 = new BolaColor((int) (Math.random() * (1280 - 200) + 100), (int) (Math.random() * (640 - 200) + 100), 20);
        BolaColor bola6 = new BolaColor((int) (bola5.getX()), (int) (bola5.getY()), 20);
        bolaBlanca = new BolaBlanca((int) (Math.random() * (1280 - 200) + 100), (int) (Math.random() * (640 - 200) + 100), 20);
        depositoBolas.addBola(bola1);
        depositoBolas.addBola(bola2);
        depositoBolas.addBola(bola3);
        depositoBolas.addBola(bola4);
        depositoBolas.addBola(bola5);
        depositoBolas.addBola(bola6);
        for (int i = 7; i < 21; i++) {
            BolaColor bola = new BolaColor((int) (Math.random() * (1280 - 200) + 100), (int) (Math.random() * (640 - 200) + 100), 20);
            depositoBolas.addBola(bola);
        }
        Assertions.assertTrue(true==depositoBolas.verificarPosBolas(depositoBolas, 20));
        Assertions.assertTrue(true==bolaBlanca.verificarPosBolaBlanca(depositoBolas, 20));
    }
    
}
