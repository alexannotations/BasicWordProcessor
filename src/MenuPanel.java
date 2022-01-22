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
        areaInfo.add(new JLabel("Tipo: " + "tipoLetra" +". Estilo: " + "style" +". Tamaño: " + "size"));
        barraMenuSuperior.add(fontType);
        barraMenuSuperior.add(fontStyle);
        barraMenuSuperior.add(fontSize);
        /* -- -- -- -- -- -- -- -- -- -- -- -- TODO refactorizar-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/
        configurarMenu("Arial","Fuente","Arial",9,11);
        configurarMenu("Consolas","Fuente","Consolas",9,11);
        configurarMenu("Verdana","Fuente","Verdana",9,11);

        configurarMenu("Negrita","Estilo","",Font.BOLD,1);
        configurarMenu("Cursiva","Estilo","",Font.ITALIC,1);
        configurarMenu("Normal","Estilo","",Font.PLAIN,1);

        configurarMenu("12","Tamaño","",9,12);
        configurarMenu("16","Tamaño","",9,16);
        configurarMenu("20","Tamaño","",9,20);
        configurarMenu("24","Tamaño","",9,24);

    }

    /** Un metodo que ponga los elementos a la escucha y que tambien los construya */
    public void configurarMenu(String itemMenuSuperior, String jMenuRotuloSup, String tipoLetra, int estiloLetra, int sizeLetra){
        // Construye los items para cada submenu
        JMenuItem menuElement = new JMenuItem(itemMenuSuperior);
        if (jMenuRotuloSup=="Fuente"){
            fontType.add(menuElement);
        }else if(jMenuRotuloSup=="Estilo"){
            fontStyle.add(menuElement);
        }else if(jMenuRotuloSup=="Tamaño"){
            fontSize.add(menuElement);
        }
        // Ponemos a la escucha al elemento item del menu desplegable
        menuElement.addActionListener(new GestionaEventos(itemMenuSuperior, jMenuRotuloSup, tipoLetra, estiloLetra, sizeLetra));

    }   // END configurarMenu()


    // Clase interna
    private class GestionaEventos implements ActionListener{

        private String itemSubmenuSelected, menuSelecionado, tipoLetra;
        private int style, size;

        // Constructor que detectara que item del menu se selecciono
        GestionaEventos(String itemSelected, String menuFuente, String tipoLetra, int estiloLetra, int tamLetra) {
            itemSubmenuSelected = itemSelected;
            menuSelecionado = menuFuente;
            this.tipoLetra = tipoLetra;
            style = estiloLetra;
            size = tamLetra;

        }   // END constructor

        /** Cambia el tipo de letra, estilo y tamaño */
        @Override
        public void actionPerformed(ActionEvent e) {

            letras = areaEscritura.getFont();       // Captura el tipo de letra del area de texto, variable global de la clase externa

            if (itemSubmenuSelected =="Arial" || itemSubmenuSelected =="Consolas" || itemSubmenuSelected =="Verdana"){  /* FontName */
                style = letras.getStyle();
                size = letras.getSize();
            } else
            if (itemSubmenuSelected =="Negrita" || itemSubmenuSelected =="Cursiva" || itemSubmenuSelected =="Normal"){  /* Style: plain, bold, italic, bold+italic */
                if (letras.getStyle()==0 || letras.getStyle()==1 || letras.getStyle()==2 || letras.getStyle()==3 ){
                    // TODO: Checar si se conserva las negritas y cursivas
                }
                tipoLetra = letras.getFontName();
                size = letras.getSize();
            }else
            if (itemSubmenuSelected =="12" || itemSubmenuSelected =="16" || itemSubmenuSelected =="20" || itemSubmenuSelected =="24"){  /* Size */
                style = letras.getStyle();
                tipoLetra = letras.getFontName();
            }

            areaEscritura.setFont(new Font(tipoLetra, style, size));
            System.out.println("Nombre: " + tipoLetra +" Estilo: " + style +" Tamaño: " + size);  // TODO: Agregar a la areaInfo

        }   // END actionPerformed()

    }   // END inner class that implements ActionListener

}
