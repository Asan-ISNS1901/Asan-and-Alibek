import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class information extends Container {
    public static JTextArea AREA;
    private JButton BACK;
    private JButton INFO;
    public information() {
        setSize(500, 400);
        setLayout(null);
        AREA=new JTextArea();
        AREA.setBounds(50,50,250,250);
        add(AREA);

        INFO=new JButton("DATA");
        INFO.setBounds(350,50,100,50);
        INFO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               PackageData pd=new PackageData("DATA");
                Main.connect(pd);
                



            }
        });
        add(INFO);



        BACK=new JButton("Back");

        BACK.setBounds(350,100,100,50);
        BACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainwindow.setVisible(true);
                Main.frame.nextwindow.setVisible(false);
            }
        });
        add(BACK);


    }

}

