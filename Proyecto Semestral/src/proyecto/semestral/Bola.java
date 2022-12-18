package proyecto.semestral;

import java.awt.*;
import static java.lang.Math.*;

/**
 * Clase abstracta Bola, contiene las atributos de la bola, x, y, color y radio,
 * ademas se pintan en pantalla. Getters y Setters de cada atributo, ademas de
 * Paint.
 */
abstract class Bola {

    private Color color;
    protected float x, y;
    protected float radio;
    protected final float friccion;
    public float vx, vy;
    private float masa;

    /**
     * Constructor de la bola
     *
     * @param x define la "x" de la bola correspondiente
     * @param y define la "y" de la bola correspondiente
     * @param radio define el "radio" de la bola correspondiente
     * @param color define el "color" de la bola correspondiente
     */
    public Bola(float x, float y, float radio, Color color) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
        friccion = (float) 0.07;
        vx = 0;
        vy = 0;
        masa = radio / 50;
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

    /**
     * Permite el desplazamiento de la bola por el mapa, lo limita solamente a
     * las dimensiones dela mesa
     */
    public void mover() {
        x += vx;
        y += vy;
        if (x > 1240 - radio) {
            x = 1240 - radio;
            vx = -vx;
        }
        if (x < 0) {
            x = radio;
            vx = -vx;
        }
        if (y > 615 - radio) {
            y = 615 - radio;
            vy = -vy;
        }
        if (y < 0) {
            y = radio;
            vy = -vy;
        }
        float mag = (float) sqrt(vx * vx + vy * vy);
        if (mag < friccion) {
            vx = 0;
            vy = 0;
        } else {
            vx /= mag;
            vy /= mag;
            vx *= mag - friccion;
            vy *= mag - friccion;
        }
    }

    /**
     * Verifica si es que la bola está o no está encima de otra
     *
     * @param b2: la bola con la cual se compara
     * @return: el valor de verdad true si es que no esta encima de otra, de lo
     * contrario, false
     */
    public boolean bienPosicionado(Bola b2) {
        boolean estado = true;
        if (x + 2 * radio <= b2.x + 2 * b2.radio
                && x + 2 * radio >= b2.x
                && y >= b2.y
                && y <= b2.y + 2 * b2.radio) {
            estado = false;
        } else if (x + 2 * radio <= b2.x + 2 * b2.radio
                && x + 2 * radio >= b2.x
                && y + 2 * radio >= b2.y
                && y + 2 * radio <= b2.y + 2 * b2.radio) {
            estado = false;
        } else if (x >= b2.x
                && x <= b2.x + 2 * b2.radio
                && y >= b2.y
                && y <= b2.y + 2 * b2.radio) {
            estado = false;
        } else if (x >= b2.x
                && x <= b2.x + 2 * b2.radio
                && y + 2 * radio >= b2.y
                && y + 2 * radio <= b2.y + 2 * b2.radio) {
            estado = false;
        }
        return estado;
    }

    /**
     * Separa la bola de otra, o "las bolas que están una encima de otra"
     *
     * @param b2: bola con la cual se separa
     */
    public void descolisionar(Bola b2 ) {
        b2.setX((int) (Math.random() * (1280 - 200) + 100));
        b2.setY((int) (Math.random() * (640 - 200) + 100));
            
    }

    /**
     * Simula las colisiones de dos bolas
     *
     * @param b1: bola colisionante numero 1
     * @param b2: bola colisionante numero 2
     */
    public static void colisionar(Bola b1, Bola b2) {
        float dx = b2.x - b1.x;
        float dy = b2.y - b1.y;
        float dist = (float) sqrt(dx * dx + dy * dy);

        if (dist < b1.radio + b2.radio) {
            float angle = (float) atan2(dy, dx);
            float sin = (float) sin(angle), cos = (float) cos(angle);

            float x1 = 0, y1 = 0;
            float x2 = dx * cos + dy * sin;
            float y2 = dy * cos - dx * sin;

            // rotate velocity
            float vx1 = b1.vx * cos + b1.vy * sin;
            float vy1 = b1.vy * cos - b1.vx * sin;
            float vx2 = b2.vx * cos + b2.vy * sin;
            float vy2 = b2.vy * cos - b2.vx * sin;

            float vx1final = ((b1.masa - b2.masa) * vx1 + 2 * b2.masa * vx2) / (b1.masa + b2.masa);
            float vx2final = ((b2.masa - b1.masa) * vx2 + 2 * b1.masa * vx1) / (b1.masa + b2.masa);

            vx1 = vx1final;
            vx2 = vx2final;

            float x2final = x2 * cos - y2 * sin;
            float y2final = y2 * cos + x2 * sin;

            b2.x = b1.x + x2final;
            b2.y = b1.y + y2final;

            b1.vx = vx1 * cos - vy1 * sin;
            b1.vy = vy1 * cos + vx1 * sin;
            b2.vx = vx2 * cos - vy2 * sin;
            b2.vy = vy2 * cos + vx2 * sin;

        }
    }

    /**
     * Pinta la bola segun su color, posicion y radio. Incluyendo tambien el
     * contorno (en negro) de cada bola
     *
     * @param g recibe la grafica g
     */
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, (int) radio * 2, (int) radio * 2);
        g.setColor(Color.black);
        g.drawOval((int) x, (int) y, (int) radio * 2, (int) radio * 2);
    }
}
