/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyecto.semestral;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author Pablo Sanhueza
 */
public class ConjuntoTronerasTest {

    private DepositoBolas depositoBolas;
    private ConjuntoTroneras conjuntoTroneras;

    public ConjuntoTronerasTest() {
        conjuntoTroneras = new ConjuntoTroneras();
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
    public void TestVerificar() {
        int radio = 20;
        BolaColor b1 = new BolaColor(10, 0, radio); // bola completa en tronera 1
        BolaColor b2 = new BolaColor(640, 0, radio); // bola completa en tronera 2
        BolaColor b3 = new BolaColor(1220, 0, radio); // bola completa en tronera 3
        BolaColor b4 = new BolaColor(0, 590, radio); // bola completa en tronera 4
        BolaColor b5 = new BolaColor(640, 590, radio); // bola completa en tronera 5
        BolaColor b6 = new BolaColor(1220, 590, radio); // bola completa en tronera 6
        BolaColor b7 = new BolaColor(10, 0, radio); // bola mayormente en tronera 1
        BolaColor b8 = new BolaColor(650, 0, radio); // bola mayormente en tronera 2
        BolaColor b9 = new BolaColor(1230, 0, radio); // bola mayormente en tronera 3
        BolaColor b10 = new BolaColor(5, 590, radio); // bola mayormente en tronera 4
        BolaColor b11 = new BolaColor(630, 590, radio); // bola mayormente en tronera 5
        BolaColor b12 = new BolaColor(1210, 590, radio); // bola mayormente en tronera 6
        BolaColor b13 = new BolaColor(100, 100, radio); // bola no contenida por ninguna tronera
        BolaColor b14 = new BolaColor(452, 425, radio); // bola no contenida por ninguna tronera
        BolaColor b15 = new BolaColor(53, 232, radio); // bola no contenida por ninguna tronera
        BolaBlanca b16 = new BolaBlanca(0, 0, radio); // bolablanca en tronera 1

        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b1));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b2));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b3));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b4));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b5));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b6));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b7));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b8));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b9));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b9));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b10));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b11));
        Assertions.assertTrue(1 == conjuntoTroneras.verificarTroneras(b12));
        Assertions.assertTrue(0 == conjuntoTroneras.verificarTroneras(b13));
        Assertions.assertTrue(0 == conjuntoTroneras.verificarTroneras(b14));
        Assertions.assertTrue(0 == conjuntoTroneras.verificarTroneras(b15));
        Assertions.assertTrue(2 == conjuntoTroneras.verificarTroneras(b16));

    }

}
