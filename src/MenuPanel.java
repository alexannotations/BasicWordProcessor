//package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    JTextPane areaEscritura;

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
        JMenuItem consolas = new JMenuItem("Consolas");
        JMenuItem verdana = new JMenuItem("Verdana");

        fontType.add(arial);
        fontType.add(consolas);
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

        areaEscritura = new JTextPane();
        add(areaEscritura, BorderLayout.CENTER);


        arial.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                areaEscritura.setFont(new Font("Arial", Font.PLAIN, 12));
            }
        });
        // Dos formas de instanciar el listener, en la primera se invoca el constructor
        // junto con los metodos entre corchetes

        GestionaMenus fontTypeEvent = new GestionaMenus();
        consolas.addActionListener(fontTypeEvent);

        verdana.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                areaEscritura.setFont(new Font("Verdana", Font.PLAIN, 12));
            }
        });
        
    }

    private class GestionaMenus implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            areaEscritura.setFont(new Font("Consolas", Font.PLAIN, 12));
        }
    }
}
