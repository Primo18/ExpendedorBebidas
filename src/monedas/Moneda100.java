package monedas;

import java.awt.*;

public class Moneda100 extends Moneda {
    public Moneda100(int serie, int x, int y) {
        super(serie, x, y);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(x, y, 70, 70);
        g.setColor(Color.black);
        g.drawOval(x, y, 70, 70);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(100), x + 25, y + 35);
    }

    @Override
    public int getValor() {
        return 100;
    }
}
