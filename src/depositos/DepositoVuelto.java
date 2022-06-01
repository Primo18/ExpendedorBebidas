package depositos;

import monedas.Moneda;

import java.awt.*;
import java.util.ArrayList;

public class DepositoVuelto {
    private int x, y, aux;
    private ArrayList<Moneda> monedas;

    public DepositoVuelto(int x, int y) {
        this.x = x + 16;
        this.y = y + 510;
        monedas = new ArrayList<>();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Deposito Vuelto", x, y - 5);
        g.drawString("* Click derecho en deposito vuelto para sacar todas las monedas a la vez", x - 10, y + 105);
        g.drawRect(x, y, 360, 80);
        for (Moneda moneda : monedas) {
            moneda.paint(g);
        }
    }

    public void addMoneda(Moneda moneda) {
        monedas.add(moneda);
        moneda.setXY(x + 280 + aux, y + 5);
        aux -= 3;
    }

    public Moneda getMoneda() {
        if (monedas.isEmpty()) {
            return null;
        }
        aux = 0;
        return monedas.remove(0);
    }
}