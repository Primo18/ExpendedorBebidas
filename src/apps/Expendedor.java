package apps;

import depositos.Deposito;
import depositos.DepositoMonedas;
import depositos.DepositoRetiroProducto;
import depositos.DepositoVuelto;
import interfaces.Producto;
import monedas.Moneda;
import monedas.Moneda100;
import productos.Cafe;
import productos.CocaCola;
import productos.Sprite;

import java.awt.*;
import java.util.ArrayList;

public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int CAFE = 3;
    int serieCocaCola = 100;
    int serieSprite = 200;
    int serieCafe = 300;
    private int x, y, precioProducto, serieMoneda100, cantidadProductos;
    private Deposito depositoCafe;
    private Deposito depositoCocaCola;
    private Deposito depositoSprite;
    private DepositoVuelto depositoVuelto;
    private DepositoRetiroProducto depositoRetiroProducto;
    private DepositoMonedas depositoMonedas;

    public Expendedor(int cantidadProductos, int precioProducto, int x, int y) {
        this.x = x;
        this.y = y;
        this.precioProducto = precioProducto;
        this.cantidadProductos = cantidadProductos;
        depositoVuelto = new DepositoVuelto(x, y);
        depositoMonedas = new DepositoMonedas(x, y);
        depositoCocaCola = new Deposito(x, y);
        depositoSprite = new Deposito(x + 200, y);
        depositoCafe = new Deposito(x + 400, y);
        depositoRetiroProducto = new DepositoRetiroProducto(x, y);
        rellenarCocaCola();
        rellenarSprite();
        rellenarCafe();
    }

    public void rellenarCocaCola() {
        for (int i = 0; i < cantidadProductos; i++) {
            depositoCocaCola.addProducto(new CocaCola(serieCocaCola++, x, y));
        }
        System.out.println("Se ha rellenado el deposito de bebidas CocaCola!");
    }

    public void rellenarSprite() {
        for (int i = 0; i < cantidadProductos; i++) {
            depositoSprite.addProducto(new Sprite(serieSprite++, x, y));
        }
        System.out.println("Se ha rellenado el deposito de bebidas Sprite!");
    }

    public void rellenarCafe() {
        for (int i = 0; i < cantidadProductos; i++) {
            depositoCafe.addProducto(new Cafe(serieCafe++, x, y));

        }
        System.out.println("Se ha rellenado el deposito de cafes!");
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        String textoExpendedor = "Precio Productos: $" + precioProducto;
        g.drawString(textoExpendedor, x, y - 10);
        g.drawRect(x, y, 615, 600);
        depositoCocaCola.paint(g);
        depositoSprite.paint(g);
        depositoCafe.paint(g);
        depositoVuelto.paint(g);
        depositoRetiroProducto.paint(g);
        depositoMonedas.paint(g);
    }

    public void comprarProducto(ArrayList<Moneda> monedas, int cual) {
        int vueltoDeposito = 0;
        if (!monedas.isEmpty()) {
            for (Moneda moneda : monedas) {
                vueltoDeposito += moneda.getValor();
                depositoMonedas.addMoneda(moneda);
            }
            if (vueltoDeposito < precioProducto) {
                System.out.println("No tienes suficiente dinero!");
            }
            Producto cocaColaBebida;
            Producto spriteBebida;
            Producto cafeBebida;

            if (cual == COCA && vueltoDeposito >= precioProducto) {
                cocaColaBebida = depositoCocaCola.getProducto();
                if (cocaColaBebida != null) {
                    vueltoDeposito -= precioProducto;
                    depositoRetiroProducto.depositarProducto(cocaColaBebida);
                }
            }
            if (cual == SPRITE && vueltoDeposito >= precioProducto) {
                spriteBebida = depositoSprite.getProducto();
                if (spriteBebida != null) {
                    vueltoDeposito -= precioProducto;
                    depositoRetiroProducto.depositarProducto(spriteBebida);
                }
            }
            if (cual == CAFE && vueltoDeposito >= precioProducto) {
                cafeBebida = depositoCafe.getProducto();
                if (cafeBebida != null) {
                    vueltoDeposito -= precioProducto;
                    depositoRetiroProducto.depositarProducto(cafeBebida);
                }
            }
            while (vueltoDeposito > 0) {
                depositoVuelto.addMoneda(new Moneda100(serieMoneda100, 0, 0));
                vueltoDeposito -= 100;
                serieMoneda100++;
            }
        } else {
            System.out.println("Tienes que ingresar dinero para comprar!");
        }
    }

    public Moneda getDepositoVuelto() {
        return depositoVuelto.getMoneda();
    }

    public Producto getDepositoProducto() {
        return depositoRetiroProducto.entregarProducto();
    }

    public boolean isDepositoCocaColaEmpty() {
        return depositoCocaCola.isEmpty();
    }

    public boolean isDepositoSpriteEmpty() {
        return depositoSprite.isEmpty();
    }

    public boolean isDepositoCafeEmpty() {
        return depositoCafe.isEmpty();
    }
}
