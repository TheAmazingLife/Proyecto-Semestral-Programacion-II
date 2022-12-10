package proyecto.semestral;

/**
 * Cada bola debe tener una velocidad asociada, esta define si posee o no
 * movimiento.
 *
 */
public class Vector {

    public float x;
    public float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static float punto(Vector a, Vector b) {
        return a.x * b.x + a.y * b.y;
    }

    public void escalar(float e) {
        x *= e;
        y *= e;
    }

    public float magnitud() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public void normalizar() {
        double mag = magnitud();
        x /= mag;
        y /= mag;
    }
}
