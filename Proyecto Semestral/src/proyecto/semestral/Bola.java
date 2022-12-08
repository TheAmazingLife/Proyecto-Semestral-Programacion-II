package proyecto.semestral;

import java.awt.*;

/**
 * Clase abstracta Bola, contiene las atributos de la bola, x, y, color y radio,
 * ademas se pintan en pantalla. Getters y Setters de cada atributo, ademas de
 * Paint.
 */
abstract class Bola {

    private Color color;
    private Velocidad velocidad;
    protected float x, y;
    protected float radio;
    private final float friccion;

    /**
     * Constructor de la bola
     *
     * @param x define la "x" de la bola correspondiente
     * @param y define la "y" de la bola correspondiente
     * @param radio define el "radio" de la bola correspondiente
     * @param color define el "color" de la bola correspondiente
     */
    public Bola(float x, float y, float radio, Color color) {
        velocidad = new Velocidad(0, 0);
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
        friccion = (float) 0.25;
    }

    public void setVelocidad(Velocidad v) {
        velocidad = v;
    }

    public Velocidad getVelocidad() {
        return velocidad;
    }

    /**
     * Obtiene la "x" de la bola
     *
     * @return posicion "x" de la bola
     */
    public float getX() {
        return x;
    }

    /**
     * Obtiene la "y" de la bola
     *
     * @return posicion "y" de la bola
     */
    public float getY() {
        return y;
    }

    /**
     * Obtiene el radio de la bola
     *
     * @return "radio" de la bola
     */
    public float getRadio() {
        return radio;
    }

    /**
     * Obtiene el color de la bola
     *
     * @return "color" de la bola
     */
    public Color getColor() {
        return color;
    }

    /**
     * Asigna el color de la bola
     *
     * @param ballColor color a asignar a la bola
     */
    public void setColor(Color ballColor) {
        this.color = ballColor;
    }

    /**
     * Asigna la "x" para la bola
     *
     * @param x "x" a asignar a la bola
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Asigna la "y" para la bola
     *
     * @param y "y" a asignar a la bola
     */
    public void setY(float y) {
        this.y = y;
    }

    public void mover() {
        x += velocidad.x;
        y += velocidad.y;

        // aplicar friccion
        float mag = velocidad.magnitud();
        if (mag < friccion) {
            velocidad.escalar(0);
        } else {
            velocidad.normalizar();
            velocidad.escalar(mag - friccion);
        }
    }

    public boolean hayColision(Bola b) {
        Velocidad v = new Velocidad(b.x - x, b.y - y);
        return v.magnitud() < radio * 2;
    }

    public void descolisionar(Bola b) {
        Velocidad puntoMedio = new Velocidad((x + b.x) / 2f, (y + b.y) / 2f);
        Velocidad normal = new Velocidad(b.x - x, b.y - y);
        normal.normalizar();

        b.setX(puntoMedio.x + normal.x * radio);
        b.setY(puntoMedio.y + normal.y * radio);

        this.setX(puntoMedio.x - normal.x * radio);
        this.setY(puntoMedio.y - normal.y * radio);
    }

    public void colisionar(Bola b) {
        Velocidad normal = new Velocidad(b.x - x, b.y - y);
        normal.normalizar();

        Velocidad tangente = new Velocidad(normal.y * -1, normal.x);

        float b1escalarNormal = Velocidad.punto(normal, this.velocidad);
        float b2escalarNormal = Velocidad.punto(normal, b.velocidad);

        float b1escalarTangente = Velocidad.punto(tangente, this.velocidad);
        float b2escalarTangente = Velocidad.punto(tangente, b.velocidad);

        Velocidad vectorB1_normal = new Velocidad(normal.x, normal.y);
        vectorB1_normal.escalar(b2escalarNormal);

        Velocidad vectorB2_normal = new Velocidad(normal.x, normal.y);
        vectorB2_normal.escalar(b1escalarNormal);

        Velocidad vectorB1_tan = new Velocidad(tangente.x, tangente.y);
        vectorB1_tan.escalar(b1escalarTangente);

        Velocidad vectorB2_tan = new Velocidad(tangente.x, tangente.y);
        vectorB2_tan.escalar(b2escalarTangente);

        this.setVelocidad(new Velocidad(vectorB1_tan.x + vectorB1_normal.x, vectorB1_tan.y + vectorB1_normal.y));
        b.setVelocidad(new Velocidad(vectorB2_tan.x + vectorB2_normal.x, vectorB2_tan.y + vectorB2_normal.y));
    }

    /**
     * Pinta la bola segun su color, posicion y radio
     *
     * @param g recibe la grafica g
     */
    // ? Asigna el color de manera correcta?
    // ? Metodo abstracto paint?
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, (int) radio * 2, (int) radio * 2);
    }
}
