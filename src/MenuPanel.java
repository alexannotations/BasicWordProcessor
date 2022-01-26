/* *** ** ** ** ** **
 *
 * Iconos descargados de: https://iconos8.es/icon/
 *  */
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
        configurarMenu("Arial","Fuente","Arial",9,11,"");
        configurarMenu("Consolas","Fuente","Consolas",9,11,"");
        configurarMenu("Verdana","Fuente","Verdana",9,11,"");

        // TODO: falta agregar una función que obtenga el estado de negritas y cursivas
        //  por cada palabra de texto seleccionada
        JCheckBoxMenuItem negritaElementCheckBox = new JCheckBoxMenuItem("Negrita", new ImageIcon("archive/negrita-16.png"));
        JCheckBoxMenuItem cursivaElementCheckBox = new JCheckBoxMenuItem("Cursiva", new ImageIcon("archive/cursiva-16.png"));
        // Atajo de teclado con el metodo setAccelerator(KeyStroke obj) de la clase JMenuItem
        negritaElementCheckBox.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        cursivaElementCheckBox.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
        negritaElementCheckBox.addActionListener(new StyledEditorKit.BoldAction());
        cursivaElementCheckBox.addActionListener(new StyledEditorKit.ItalicAction());
        fontStyleMenu.add(negritaElementCheckBox);
        fontStyleMenu.add(cursivaElementCheckBox);

        ButtonGroup grupoSizeFonts = new ButtonGroup();
        JRadioButtonMenuItem  doceRadioButton = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem  dieciseisRadioButton = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem  veinteRadioButton = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem  veinticuatroRadioButton = new JRadioButtonMenuItem("24");
        // Atajo de teclado CTRL+D
        veinticuatroRadioButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        grupoSizeFonts.add(doceRadioButton);
        grupoSizeFonts.add(dieciseisRadioButton);
        grupoSizeFonts.add(veinteRadioButton);
        grupoSizeFonts.add(veinticuatroRadioButton);
        doceRadioButton.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",12));
        dieciseisRadioButton.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",16));
        veinteRadioButton.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",20));
        veinticuatroRadioButton.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",24));
        fontSizeMenu.add(doceRadioButton);
        fontSizeMenu.add(dieciseisRadioButton);
        fontSizeMenu.add(veinteRadioButton);
        fontSizeMenu.add(veinticuatroRadioButton);

        JPopupMenu menuEmergente =new JPopupMenu();
        JMenuItem negritaMEmergente=new JMenuItem("Negrita");
        JMenuItem cursivaMEmergente=new JMenuItem("Cursiva");
        menuEmergente.add(negritaMEmergente);
        menuEmergente.add(cursivaMEmergente);
        areaEscrituraPanel.setComponentPopupMenu(menuEmergente);

        negritaMEmergente.addActionListener(new StyledEditorKit.BoldAction());
        cursivaMEmergente.addActionListener(new StyledEditorKit.ItalicAction());

    }   // END constructor MenuPanel

    /** Un metodo que ponga los elementos a la escucha y que tambien los construya */
    public void configurarMenu(String rotuloMenuSuperior, String jbotonMenuSup, String tipoLetra, int estiloLetra, int sizeLetra, String iconPath){
        // Construye los items para cada submenu
        JMenuItem menuElement = new JMenuItem(rotuloMenuSuperior, new ImageIcon(iconPath));
        if (jbotonMenuSup=="Fuente"){
            fontTypeMenu.add(menuElement);
            if (tipoLetra=="Arial"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Arial"));
            }else if (tipoLetra=="Consolas"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Consolas"));
            }else if(tipoLetra=="Verdana"){
                menuElement.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Verdana"));
            }

        }else if(jbotonMenuSup=="Tamaño"){
            fontSizeMenu.add(menuElement);
            menuElement.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamañ",sizeLetra));
        }

    }   // END configurarMenu



}   // END MenuPanel
