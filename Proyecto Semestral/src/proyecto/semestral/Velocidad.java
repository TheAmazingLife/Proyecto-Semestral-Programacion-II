package proyecto.semestral;

/**
 * Cada bola debe tener una velocidad asociada, esta define si posee o no
 * movimiento
 *
 */
public class Velocidad {

    public float x;
    public float y;

    public Velocidad(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static float punto(Velocidad a, Velocidad b) {
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
