package productos;

import java.awt.*;

public class Sprite extends Bebida {
    public Sprite(int serie, int x, int y) {
        super(serie, x, y);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 150, 25);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(getSerie()), x + 70, y + 18);
    }

    public String beber() {
        return "sprite";
    }
}