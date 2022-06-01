package depositos;

import interfaces.Producto;

import java.awt.*;

public class DepositoRetiroProducto {
    private int x, y;
    private Producto producto;

    public DepositoRetiroProducto(int x, int y) {
        this.x = x + 416;
        this.y = y + 530;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Retiro Producto", x, y - 5);
        g.drawRect(x, y, 180, 50);
        if (producto != null) {
            producto.setXY(x + 16, y + 10);
            producto.paint(g);
        }
    }

    public void depositarProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto entregarProducto() {
        Producto p = producto;
        producto = null;
        return p;
    }
}