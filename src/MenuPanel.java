//package src;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        setLayout(new BorderLayout());

        JMenu fontType = new JMenu("Fuente");
        JMenu fontStyle = new JMenu("Estilo");
        JMenu fontSize = new JMenu("Tamaño");

        JMenuBar barraMenuSuperior = new JMenuBar();
        barraMenuSuperior.add(fontType);
        barraMenuSuperior.add(fontStyle);
        barraMenuSuperior.add(fontSize);

        JMenuItem arial = new JMenuItem("Arial");
        JMenuItem courier = new JMenuItem("Courier");
        JMenuItem verdana = new JMenuItem("Verdana");

        fontType.add(arial);
        fontType.add(courier);
        fontType.add(verdana);

        fontStyle.add(new JMenuItem("Negrita"));
        fontStyle.add(new JMenuItem("Cursiva"));

        fontSize.add(new JMenuItem("12"));
        fontSize.add(new JMenuItem("16"));
        fontSize.add(new JMenuItem("20"));
        fontSize.add(new JMenuItem("24"));

        JPanel laminaMenu = new JPanel();
        laminaMenu.add(barraMenuSuperior);
        add(laminaMenu, BorderLayout.NORTH);

    }
}
