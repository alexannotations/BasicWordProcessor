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
        /* -- -- -- -- -- -- -- -- -- -- -- -- TODO refactorizar-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/
        configurarMenu("Arial","Fuente","",0,0);
        configurarMenu("Consolas","Fuente","",0,0);
        configurarMenu("Verdana","Fuente","",0,0);

        configurarMenu("Negrita","Estilo","",0,0);
        configurarMenu("Cursiva","Estilo","",0,0);

        configurarMenu("12","Tamaño","",0,0);
        configurarMenu("16","Tamaño","",0,0);
        configurarMenu("20","Tamaño","",0,0);
        configurarMenu("24","Tamaño","",0,0);

    }

    /** Un metodo que ponga los elementos a la escucha y que tamabien los construya */
    public void configurarMenu(String rotuloMenuSuperior, String jmenuSup, String tipoLetra, int estiloLetra, int sizeLetra){
        // Construye los items para cada submenu
        JMenuItem menuElement = new JMenuItem(rotuloMenuSuperior);
        if (jmenuSup=="Fuente"){
            fontType.add(menuElement);
        }else if(jmenuSup=="Estilo"){
            fontStyle.add(menuElement);
        }else if(jmenuSup=="Tamaño"){
            fontSize.add(menuElement);
        }
    }

}
