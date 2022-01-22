

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    static int contadorFrame =0;
    public MenuFrame() throws HeadlessException {
        System.out.println("\t\tInicioFrame "+ ++contadorFrame);
        setBounds(550,300,850,350);
        setTitle("Procesador de texto basico");
        add(new MenuPanel());
        setVisible(true);
        System.out.println("\t\tFinFrame "+contadorFrame);
    }

}
