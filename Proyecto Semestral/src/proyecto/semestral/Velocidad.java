package proyecto.semestral;

import static java.lang.Math.*;

/**
 * Cada bola debe tener una velocidad asociada, esta define si posee o no
 * movimiento
 *
 */
public class Velocidad {

    private double x = 0;
    private double y = 0;

    public Velocidad(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Velocidad() {
        x = 0;
        y = 0;
    }

    public void setX(double velocidad) {
        x = velocidad;
    }

    public void setY(double velocidad) {
        y = velocidad;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getComponent(double theta) {
        return cos(theta) * x + sin(theta) * y;
    }

    public void aumentarX(double velocidad) {
        x += velocidad;
    }

    public void aumentarY(double velocidad) {
        y += velocidad;
    }

    public void restarX(double velocidad) {
        x -= velocidad;
    }

    public void restarY(double velocidad) {
        y -= velocidad;
    }

    public boolean isEmpty() {
        if (x == 0 && y == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addComponent(double theta, double velocidad) {
        x += cos(theta) * velocidad;
        y += sin(theta) * velocidad;
    }
}
