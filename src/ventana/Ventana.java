package ventana;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        this.setLayout(new BorderLayout());
        this.add(new PanelPrincipal(), BorderLayout.CENTER);
        this.setSize(1200, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
