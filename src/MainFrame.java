import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu mainwindow;
    public static  Signin signinwindow;
     public static CREATE createwindow;
     public static information nextwindow;

public MainFrame() {
        setSize(500, 400);
        setLayout(null);
        setTitle("Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainwindow=new MainMenu();
        mainwindow.setLocation(0,0);
        add(mainwindow);

        signinwindow=new Signin ();
        signinwindow.setLocation(0,0);
        signinwindow.setVisible(false);
        add(signinwindow);

        createwindow=new CREATE();
        createwindow.setLocation(0,0);
        createwindow.setVisible(false);
        add(createwindow);

        nextwindow=new information();
        nextwindow.setLocation(0,0);
        nextwindow.setVisible(false);
        add(nextwindow);


        }
        }
