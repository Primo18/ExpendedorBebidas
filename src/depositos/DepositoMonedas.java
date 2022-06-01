package depositos;

import monedas.*;

import java.awt.*;
import java.util.ArrayList;

public class DepositoMonedas {
    private int x, y, aux;
    private ArrayList<Moneda> monedas;

    public DepositoMonedas(int x, int y) {
        this.x = x + 110;
        this.y = y + 422;
        monedas = new ArrayList<>();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Deposito interno:", x - 100, y + 40);
        g.drawRect(x, y, 485, 80);
        for (Moneda moneda : monedas) {
            moneda.paint(g);
        }
    }

    public void addMoneda(Moneda moneda) {
        monedas.add(moneda);
        moneda.setXY(x + 410 + aux, y + 5);
        aux -= 3;
    }
}