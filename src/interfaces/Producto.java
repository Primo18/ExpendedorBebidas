package interfaces;

import java.awt.*;

public interface Producto {
    void paint(Graphics g);

    void setXY(int x, int y);

    int getSerie();

    String beber();
}