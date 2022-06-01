package productos;

import interfaces.Producto;

import java.awt.*;

public abstract class Bebida implements Producto {
    protected int x, y;
    private int serie;

    public Bebida(int serie, int x, int y) {
        this.serie = serie;
        this.x = x;
        this.y = y;
    }

    public int getSerie() {
        return this.serie;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}