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
        configurarMenu("Arial","Fuente","Arial",1,8);
        configurarMenu("Consolas","Fuente","Consolas",1,10);
        configurarMenu("Verdana","Fuente","Verdana",0,11);

        configurarMenu("Negrita","Estilo","",Font.BOLD,11);
        configurarMenu("Cursiva","Estilo","",Font.ITALIC,11);
        configurarMenu("Normal","Estilo","",Font.PLAIN,11);

        configurarMenu("12","Tamaño","",0,12);
        configurarMenu("16","Tamaño","",0,16);
        configurarMenu("20","Tamaño","",0,20);
        configurarMenu("24","Tamaño","",0,24);

    }

    /** Un metodo que ponga los elementos a la escucha y que tambien los construya */
    public void configurarMenu(String rotuloMenuSuperior, String jbotonMenuSup, String tipoLetra, int estiloLetra, int sizeLetra){
        // Construye los items para cada submenu
        JMenuItem menuElement = new JMenuItem(rotuloMenuSuperior);
        if (jbotonMenuSup=="Fuente"){
            fontType.add(menuElement);
        }else if(jbotonMenuSup=="Estilo"){
            fontStyle.add(menuElement);
        }else if(jbotonMenuSup=="Tamaño"){
            fontSize.add(menuElement);
        }
        // Ponemos a la escucha al menu desplegable
        menuElement.addActionListener(new GestionaEventos(rotuloMenuSuperior, jbotonMenuSup, estiloLetra, sizeLetra));

    }

    // Clase interna
    private class GestionaEventos implements ActionListener{

        private String tipoLetra, menuSelecionado;
        private int style, size;

        // Constructor que detectara que item del menu se selecciono
        GestionaEventos(String elementoSeleccionado, String botonFuente, int estiloLetra, int tamLetra) {
            tipoLetra = elementoSeleccionado;
            menuSelecionado = botonFuente;
            style = estiloLetra;
            size = tamLetra;

        }

        /** Cambia el tipo de letra, estilo y tamaño */
        @Override
        public void actionPerformed(ActionEvent e) {

            letras = areaEscritura.getFont();       // Captura el tipo de letra del area de texto

            if (menuSelecionado =="Arial" || menuSelecionado =="Consolas" || menuSelecionado =="Verdana"){
                style = letras.getStyle();
                size = letras.getSize();
            } else
            if (menuSelecionado =="Negrita" || menuSelecionado =="Cursiva" || menuSelecionado =="Normal"){
                tipoLetra = letras.getFontName();
                size = letras.getSize();
            }else
            if (menuSelecionado =="12" || menuSelecionado =="16" || menuSelecionado =="20" || menuSelecionado =="24"){
                style = letras.getStyle();
                tipoLetra = letras.getFontName();
            }

            areaEscritura.setFont(new Font(tipoLetra, style, size));
            System.out.println("Tipo: " + tipoLetra +" Estilo: " + style +" Tamaño: " + size);  // TODO: Agregar a la areaInfo
        }

    }

}
