package package1;

/**
 * Created by Student on 03.06.2015.
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;


public class Class2 extends JFrame{


    // 	Home & Graphic
    JTextArea		lShow;
    JComboBox   cbSearch;
    JLabel      lFlag;


    public String[] getCountries() {
        File folder = new File("data/");

        String[] files = folder.list(new FilenameFilter() {
            @Override public boolean accept(File folder, String name) {
                return name.endsWith(".txt");
            }

        });
        String[] countries = new String[files.length+1];
        countries[0] = "";
        for (int i=0; i<files.length; i++) {
            countries[i+1] = files[i].replace(".txt", "");
        }
        return countries;
    }

    public class eHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JComboBox box = (JComboBox)e.getSource();
            String item = (String)box.getSelectedItem();
            try {
                lShow.setText(new Scanner(new File("data/"+item+".txt"), "UTF-8").useDelimiter("\\Z").next());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            };
            lFlag.setIcon(new ImageIcon("data/flags/"+item+".png"));
        }
    }

    public Class2(String s){
        super(s); //title
        setLayout(null);

        cbSearch = new JComboBox(getCountries());
        cbSearch.setVisible(true);
        cbSearch.setBounds(50,50,600,50);

        eHandler handler = new eHandler();

        lShow = new JTextArea("Выберите страну");
        lShow.setLineWrap(true);
        lShow.setWrapStyleWord(true);
        lShow.setEditable(false);
        lShow.setFont(new Font("SanSerif", Font.BOLD, 12));
        lShow.setBackground(new Color(238,238,238));
        lShow.setBounds(50,150,370,400);


        //ТАк вставляется картинка в JLabel
        lFlag = new JLabel("") ;
        //  lFlag.setIcon(new ImageIcon("Россия.png"));
        lFlag.setBounds(430, 150, 220, 146);


        add(lShow);
        add(cbSearch);
        add(lFlag);

       cbSearch.addActionListener(handler);



    }

}




