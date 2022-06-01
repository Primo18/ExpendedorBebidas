package depositos;

import interfaces.Producto;

import java.awt.*;
import java.util.ArrayList;

public class Deposito {
    private int x, y, aux;
    private ArrayList<Producto> lista;

    public Deposito(int x, int y) {
        this.x = x + 16;
        this.y = y + 16;
        lista = new ArrayList<>();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, 180, 400);
        for (int i = lista.size() - 1; i >= 0; i--) {
            Producto p = lista.get(i);
            p.paint(g);
        }
    }

    public void addProducto(Producto producto) {
        lista.add(producto);
        producto.setXY(x + 16, y + 330 + aux);
        aux -= 35;
    }

    public Producto getProducto() {
        if (lista.size() == 0) {
            System.out.println("El deposito esta vacio! Prueba a comprar otro producto!");
            return null;
        }
        aux = 0;
        return lista.remove(0);
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }
}