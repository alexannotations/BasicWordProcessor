//package src;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    JTextPane areaEscritura;
    JMenu fontType, fontStyle, fontSize;
    Font letras;

    public MenuPanel() {
        JPanel panelMenuSuperior = new JPanel();
        JPanel areaInfo = new JPanel();
        JMenuBar barraMenuSuperior = new JMenuBar();
        areaEscritura = new JTextPane();

        fontType = new JMenu("Fuente");
        fontStyle = new JMenu("Estilo");
        fontSize = new JMenu("Tamaño");

        setLayout(new BorderLayout());
        add(panelMenuSuperior, BorderLayout.NORTH);
        add(areaEscritura, BorderLayout.CENTER);
        add(areaInfo, BorderLayout.SOUTH);

        panelMenuSuperior.add(barraMenuSuperior);
        areaInfo.add(new JLabel("Ejemplo de info ..."));
        barraMenuSuperior.add(fontType);
        barraMenuSuperior.add(fontStyle);
        barraMenuSuperior.add(fontSize);
        /* -- -- -- -- -- -- -- -- -- -- -- -- TODO refactorizar-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/
        configurarMenu("Arial","Fuente","Arial",9,11);
        configurarMenu("Consolas","Fuente","Consolas",9,11);
        configurarMenu("Verdana","Fuente","Verdana",9,11);

        configurarMenu("Negrita","Estilo","",Font.BOLD,1);
        configurarMenu("Cursiva","Estilo","",Font.ITALIC,1);

        configurarMenu("12","Tamaño","",9,12);
        configurarMenu("16","Tamaño","",9,16);
        configurarMenu("20","Tamaño","",9,20);
        configurarMenu("24","Tamaño","",9,24);

    }

    /** Un metodo que ponga los elementos a la escucha y que tambien los construya */
    public void configurarMenu(String rotuloMenuSuperior, String jbotonMenuSup, String tipoLetra, int estiloLetra, int sizeLetra){
        // Construye los items para cada submenu
        JMenuItem menuElement = new JMenuItem(rotuloMenuSuperior);
        if (jbotonMenuSup=="Fuente"){
            fontType.add(menuElement);
            if (tipoLetra=="Arial"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Arial"));
            }else if (tipoLetra=="Consolas"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Consolas"));
            }else if(tipoLetra=="Verdana"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Verdana"));
            }

        }else if(jbotonMenuSup=="Estilo"){
            fontStyle.add(menuElement);
            if (estiloLetra==Font.BOLD){
                menuElement.addActionListener(new StyledEditorKit.BoldAction());
            } else if (estiloLetra==Font.ITALIC){
                menuElement.addActionListener(new StyledEditorKit.ItalicAction());
            }

        }else if(jbotonMenuSup=="Tamaño"){
            fontSize.add(menuElement);
            menuElement.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamañ",sizeLetra));
        }

    }



}
