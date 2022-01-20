package src;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {

    public MenuFrame() throws HeadlessException {
        setBounds(550,300,850,350);
        setTitle("Procesador de texto basico");
        setVisible(true);
        add(new MenuPanel());
    }

}
