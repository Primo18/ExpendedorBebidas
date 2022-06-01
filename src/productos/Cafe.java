package productos;

import interfaces.Producto;

import java.awt.*;

public class Cafe implements Producto {
    private int x, y;
    private int serie;

    public Cafe(int serie, int x, int y) {
        this.serie = serie;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, 150, 25);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(getSerie()), x + 70, y + 18);
    }

    @Override
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getSerie() {
        return this.serie;
    }

    public String beber() {
        return "cafe";
    }
}