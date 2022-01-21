//package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    JTextPane areaEscritura;
    JMenu fontType, fontStyle, fontSize;
    Font letras;

    public MenuPanel() {
        JPanel panelMenuSuperior = new JPanel();
        JMenuBar barraMenuSuperior = new JMenuBar();
        areaEscritura = new JTextPane();

        fontType = new JMenu("Fuente");
        fontStyle = new JMenu("Estilo");
        fontSize = new JMenu("Tamaño");

        setLayout(new BorderLayout());
        add(panelMenuSuperior, BorderLayout.NORTH);
        add(areaEscritura, BorderLayout.CENTER);

        panelMenuSuperior.add(barraMenuSuperior);
        barraMenuSuperior.add(fontType);
        barraMenuSuperior.add(fontStyle);
        barraMenuSuperior.add(fontSize);

    }

    public void configurarMenu(String rotulo, String menu, String tipoLetra, int estilo, int sizeLetra){

    }

}
