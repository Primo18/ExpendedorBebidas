package ventana;

import apps.Comprador;
import apps.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel implements MouseListener {
    private Comprador comprador;
    private Expendedor expendedor;

    public PanelPrincipal() {
        expendedor = new Expendedor(10, 1500, 500, 100);
        comprador = new Comprador(expendedor, 100, 100);
        this.setBackground(Color.LIGHT_GRAY);
        this.addMouseListener(this); // habilita la captura de eventos del mouse
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (expendedor != null) expendedor.paint(g);
        if (comprador != null) comprador.paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= 125 && e.getX() <= 275 && e.getY() >= 125 & e.getY() <= 165) {
            comprador.comprar(1);
        }
        if (e.getX() >= 125 && e.getX() <= 275 && e.getY() >= 175 & e.getY() <= 215) {
            comprador.comprar(2);
        }
        if (e.getX() >= 125 && e.getX() <= 275 && e.getY() >= 225 & e.getY() <= 265) {
            comprador.comprar(3);
        }
        if (e.getX() >= 516 && e.getX() <= 876 && e.getY() >= 610 & e.getY() <= 690) {
            if (SwingUtilities.isRightMouseButton(e)) {
                while (comprador.getVuelto() != null) {
                    comprador.getVuelto();
                }
            }
            if (SwingUtilities.isLeftMouseButton(e)) {
                comprador.getVuelto();
            }
        }
        if (e.getX() >= 916 && e.getX() <= 1096 && e.getY() >= 630 & e.getY() <= 680) {
            comprador.getProducto();
        }
        if (e.getX() >= 150 && e.getX() <= 290 && e.getY() >= 290 & e.getY() <= 315) {
            comprador.addMoneda100();
        }
        if (e.getX() >= 150 && e.getX() <= 250 && e.getY() >= 320 & e.getY() <= 345) {
            comprador.addMoneda500();
        }
        if (e.getX() >= 150 && e.getX() <= 250 && e.getY() >= 350 & e.getY() <= 375) {
            comprador.addMoneda1000();
        }
        if (e.getX() >= 150 && e.getX() <= 250 && e.getY() >= 380 & e.getY() <= 405) {
            comprador.addMoneda1500();
        }
        if (e.getX() >= 916 && e.getX() <= 1096 && e.getY() >= 116 & e.getY() <= 516) {
            if (expendedor.isDepositoCafeEmpty()) {
                expendedor.rellenarCafe();
            }
        }
        if (e.getX() >= 516 && e.getX() <= 696 && e.getY() >= 116 & e.getY() <= 516) {
            if (expendedor.isDepositoCocaColaEmpty()) {
                expendedor.rellenarCocaCola();
            }
        }
        if (e.getX() >= 716 && e.getX() <= 896 && e.getY() >= 116 & e.getY() <= 516) {
            if (expendedor.isDepositoSpriteEmpty()) {
                expendedor.rellenarSprite();
            }
        }
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}






