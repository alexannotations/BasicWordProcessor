

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    JTextPane areaEscrituraPanel;
    JMenu fontTypeMenu, fontStyleMenu, fontSizeMenu;
    Font letras;
    String[] fontsNames = {"Algerian","Consolas","Lucida Handwriting"};

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
        areaInfo.add(new JLabel("Tipo: " + "tipoLetra" +". Estilo: " + "style" +". Tamaño: " + "size"));
        barraMenuSuperior.add(fontTypeMenu);
        barraMenuSuperior.add(fontStyleMenu);
        barraMenuSuperior.add(fontSizeMenu);
        /* -- -- -- -- -- -- -- -- -- -- -- -- TODO refactorizar-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/
        configurarMenu(fontsNames[0],"Fuente",fontsNames[0],9,11);
        configurarMenu(fontsNames[1],"Fuente",fontsNames[1],9,11);
        configurarMenu(fontsNames[2],"Fuente",fontsNames[2],9,11);

        configurarMenu("Negrita","Estilo","",Font.BOLD,1);
        configurarMenu("Cursiva","Estilo","",Font.ITALIC,1);
        configurarMenu("Normal","Estilo","",Font.PLAIN,1);

        configurarMenu("12","Tamaño","",9,12);
        configurarMenu("16","Tamaño","",9,16);
        configurarMenu("20","Tamaño","",9,20);
        configurarMenu("24","Tamaño","",9,24);
    }

    /** Un metodo que ponga los elementos a la escucha y que tambien los construya */
    public void configurarMenu(String itemMenuSuperior, String jMenuRotuloSup, String fontName, int fontStyle, int fontSize){
        // Construye los items para cada submenu
        JMenuItem menuElement = new JMenuItem(itemMenuSuperior);
        if (jMenuRotuloSup=="Fuente"){
            fontTypeMenu.add(menuElement);
        }else if(jMenuRotuloSup=="Estilo"){
            fontStyleMenu.add(menuElement);
        }else if(jMenuRotuloSup=="Tamaño"){
            fontSizeMenu.add(menuElement);
        }
        // Ponemos a la escucha al elemento item del menu desplegable
        menuElement.addActionListener(new GestionaEventos(itemMenuSuperior, fontName, fontStyle, fontSize));

    }   // END configurarMenu()


    // Clase interna
    private class GestionaEventos implements ActionListener{

        private String itemSubmenuSelected, fontName;
        private int fontStyle, fontSize;

        // Constructor que detectara que item del menu se selecciono
        GestionaEventos(String itemSelected, String fontName, int fontStyle, int fontSize) {
            itemSubmenuSelected = itemSelected;
            this.fontName = fontName;
            this.fontStyle = fontStyle;
            this.fontSize = fontSize;

        }   // END constructor

        /** Cambia el tipo de letra, estilo y tamaño */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Nombre: " + fontName +"\t\t Estilo: " + fontStyle +"\t\t Tamaño: " + fontSize);                // BORRAR ESTA LINEA
            letras = areaEscrituraPanel.getFont();       // Captura el tipo de letra del area de texto, variable global de la clase externa

            if (itemSubmenuSelected ==fontsNames[0] || itemSubmenuSelected ==fontsNames[1] || itemSubmenuSelected ==fontsNames[2]){  /* FontName */
                fontStyle = letras.getStyle();
                fontSize = letras.getSize();
            } else
            if (itemSubmenuSelected =="Negrita" || itemSubmenuSelected =="Cursiva" || itemSubmenuSelected =="Normal"){  /* Style: plain, bold, italic, bold+italic */
                if (letras.getStyle()==0 || letras.getStyle()==1 || letras.getStyle()==2 || letras.getStyle()==3 ){
                    /* TODO: NO se conservan las negritas y cursivas juntas al cambiar de fuente de letra, tampoco funciona plain
                        Aunque segun se cambien los tipos de fuentes parece mostrar comportamiento diferente, tal vez por las propiedades de la fuente */
                }
                fontName = letras.getFontName();
                fontSize = letras.getSize();
            }else
            if (itemSubmenuSelected =="12" || itemSubmenuSelected =="16" || itemSubmenuSelected =="20" || itemSubmenuSelected =="24"){  /* Size */
                fontStyle = letras.getStyle();
                fontName = letras.getFontName();
            }

            areaEscrituraPanel.setFont(new Font(fontName, fontStyle, fontSize));
            System.out.println("Nombre: " + fontName +"\t\t Estilo: " + fontStyle +"\t\t Tamaño: " + fontSize);  // TODO: Agregar a la areaInfo

        }   // END actionPerformed()

    }   // END inner class that implements ActionListener

}
