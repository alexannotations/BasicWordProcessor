

import javax.swing.*;

public class Main {
    static int contadorMain =0;
    public static void main(String[] args) {
        System.out.println("\tInicioMain "+ ++contadorMain);
        MenuFrame miFrame = new MenuFrame();
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("\tFinMain "+contadorMain);
    }
}
