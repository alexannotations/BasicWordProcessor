
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class MenuPanel extends JPanel {

    JTextPane areaEscrituraPanel;
    JMenu fontTypeMenu, fontStyleMenu, fontSizeMenu;

    public MenuPanel() {
        JPanel panelMenuSuperior = new JPanel();
        JPanel areaInfo = new JPanel();
        JMenuBar barraMenuSuperior = new JMenuBar();
        areaEscrituraPanel = new JTextPane();

        fontTypeMenu = new JMenu("Fuente");
        fontStyleMenu = new JMenu("Estilo");
        fontSizeMenu = new JMenu("Tamaño");

        setLayout(new BorderLayout());
        add(panelMenuSuperior, BorderLayout.NORTH);
        add(areaEscrituraPanel, BorderLayout.CENTER);
        add(areaInfo, BorderLayout.SOUTH);

        panelMenuSuperior.add(barraMenuSuperior);
        areaInfo.add(new JLabel("Ejemplo de info ..."));
        barraMenuSuperior.add(fontTypeMenu);
        barraMenuSuperior.add(fontStyleMenu);
        barraMenuSuperior.add(fontSizeMenu);
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

    }   // END MenuPanel

    /** Un metodo que ponga los elementos a la escucha y que tambien los construya */
    public void configurarMenu(String rotuloMenuSuperior, String jbotonMenuSup, String tipoLetra, int estiloLetra, int sizeLetra){
        // Construye los items para cada submenu
        JMenuItem menuElement = new JMenuItem(rotuloMenuSuperior);
        if (jbotonMenuSup=="Fuente"){
            fontTypeMenu.add(menuElement);
            if (tipoLetra=="Arial"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Arial"));
            }else if (tipoLetra=="Consolas"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Consolas"));
            }else if(tipoLetra=="Verdana"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Verdana"));
            }

        }else if(jbotonMenuSup=="Estilo"){
            fontStyleMenu.add(menuElement);
            if (estiloLetra==Font.BOLD){
                menuElement.addActionListener(new StyledEditorKit.BoldAction());
            } else if (estiloLetra==Font.ITALIC){
                menuElement.addActionListener(new StyledEditorKit.ItalicAction());
            }

        }else if(jbotonMenuSup=="Tamaño"){
            fontSizeMenu.add(menuElement);
            menuElement.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamañ",sizeLetra));
        }

    }   // END configurarMenu



}   // END MenuPanel
