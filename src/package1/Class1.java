package package1;

/**
 * Created by Student on 03.06.2015.
 */

import javax.swing.JFrame;

public class Class1 {
    public static void main(String[] args) {
        Class2 r = new Class2("lab4");
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700, 600);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
    }
}
