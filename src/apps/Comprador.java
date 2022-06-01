package apps;

import interfaces.Producto;
import monedas.*;

import java.awt.*;
import java.util.ArrayList;

public class Comprador {
    public ArrayList<Moneda> monedero;
    private int x, y, dinero, auxProductos;
    private int posMoneda100, posMoneda500, posMoneda1000, posMoneda1500, posVuelto;
    private int serieMoneda = 500;
    private ArrayList<Producto> listaProductos;
    private Expendedor expendedor;

    public Comprador(Expendedor expendedor, int x, int y) {
        this.x = x;
        this.y = y;
        this.expendedor = expendedor;
        monedero = new ArrayList<>();
        listaProductos = new ArrayList<>();
    }

    public void addMoneda100() {
        Moneda m = new Moneda100(serieMoneda++, 0, 0);
        m.setXY(x + 25 + posMoneda100, y + 340);
        System.out.println("Serie Moneda " + m.getValor() + ": " + m.getSerie());
        monedero.add(m);
        posMoneda100 -= 2;
        dinero += m.getValor();
    }

    public void addMoneda500() {
        Moneda m = new Moneda500(serieMoneda++, 0, 0);
        m.setXY(x + 115 + posMoneda500, y + 340);
        System.out.println("Serie Moneda " + m.getValor() + ": " + m.getSerie());
        monedero.add(m);
        posMoneda500 -= 2;
        dinero += m.getValor();
    }

    public void addMoneda1000() {
        Moneda m = new Moneda1000(serieMoneda++, 0, 0);
        m.setXY(x + 25 + posMoneda1000, y + 415);
        System.out.println("Serie Moneda " + m.getValor() + ": " + m.getSerie());
        monedero.add(m);
        posMoneda1000 -= 2;
        dinero += m.getValor();
    }

    public void addMoneda1500() {
        Moneda m = new Moneda1500(serieMoneda++, 0, 0);
        m.setXY(x + 115 + posMoneda1500, y + 415);
        System.out.println("Serie Moneda " + m.getValor() + ": " + m.getSerie());
        monedero.add(m);
        posMoneda1500 -= 2;
        dinero += m.getValor();
    }

    public Moneda getVuelto() {
        Moneda m = expendedor.getDepositoVuelto();
        if (m != null) {
            dinero += m.getValor();
            System.out.println("Vuelto: " + m.getValor() + "  Serie: " + m.getSerie());
            m.setXY(x + 235, y + 30 + posVuelto);
            posVuelto += 2;
            monedero.add(m);
        }
        return m;
    }

    public void comprar(int cual) {
        resetPosMonedas();
        dinero = 0;
        expendedor.comprarProducto(monedero, cual);
        monedero.clear();
    }

    public void getProducto() {
        Producto p = expendedor.getDepositoProducto();
        if (p != null) {
            auxProductos += 30;
            System.out.println("Producto: " + p.beber() + "  Serie: " + p.getSerie());
            p.setXY(x + 195, y + 315 + auxProductos);
            listaProductos.add(p);
        }
    }

    public void resetPosMonedas() {
        posMoneda100 = 0;
        posMoneda500 = 0;
        posMoneda1000 = 0;
        posMoneda1500 = 0;
        posVuelto = 0;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        String textoComprador = "Dinero Total: $" + dinero;
        g.drawString(textoComprador, x, y - 10);
        g.drawRect(x, y, 350, 600);

        // Selección de Bebidas
        g.drawString("Seleccione Bebida o Café", x + 25, y + 20);
        g.setColor(Color.red);
        g.fillRect(x + 25, y + 25, 150, 40);
        g.setColor(Color.WHITE);
        g.drawString("Coca Cola", x + 70, y + 50);
        g.setColor(Color.green);
        g.fillRect(x + 25, y + 75, 150, 40);
        g.setColor(Color.WHITE);
        g.drawString("Sprite", x + 85, y + 100);
        g.setColor(Color.orange);
        g.fillRect(x + 25, y + 125, 150, 40);
        g.setColor(Color.WHITE);
        g.drawString("Café", x + 85, y + 150);

        // Selección Monedas
        g.setColor(Color.black);
        g.drawString("Saque dinero del cajero", x + 30, y + 182);
        g.setColor(Color.orange);
        g.fillRect(x + 50, y + 190, 100, 25);
        g.setColor(Color.WHITE);
        g.drawString("$100", x + 88, y + 208);
        g.setColor(Color.cyan);
        g.fillRect(x + 50, y + 220, 100, 25);
        g.setColor(Color.WHITE);
        g.drawString("$500", x + 88, y + 238);
        g.setColor(Color.MAGENTA);
        g.fillRect(x + 50, y + 250, 100, 25);
        g.setColor(Color.WHITE);
        g.drawString("$1000", x + 85, y + 268);
        g.setColor(Color.green);
        g.fillRect(x + 50, y + 280, 100, 25);
        g.setColor(Color.WHITE);
        g.drawString("$1500", x + 85, y + 298);

        // Vuelto
        g.setColor(Color.black);
        g.drawString("Dinero en el monedero", x + 35, y + 330);
        g.drawString("Producto Comprado", x + 215, y + 330);
        g.drawString("Vuelto", x + 250, y + 20);
        g.drawString("Copyright © Todos los derechos reservados 2022", x, y + 625);

        for (Moneda moneda : monedero) {
            moneda.paint(g);
        }
        for (Producto producto : listaProductos
        ) {
            producto.paint(g);
        }
    }
}
