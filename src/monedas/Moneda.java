package monedas;

import java.awt.*;

public abstract class Moneda {
    protected int x, y;
    protected int serie;

    public Moneda(int serie, int x, int y) {
        this.serie = serie;
        this.x = x;
        this.y = y;
    }

    public abstract void paint(Graphics g);

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSerie() {
        return serie;
    }

    public abstract int getValor();
}
