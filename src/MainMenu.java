import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class MainMenu extends Container {
        private JButton SignIn;
        private JButton Create;
        private JButton Exit;
        private JLabel welcome,welcome2,welcome3;
        private JLabel or;
        public MainMenu() {
            setSize(500, 400);
            setLayout(null);
            welcome=new JLabel("Welcome to our server! ");
            welcome.setBounds(180,80,300,40);
            add(welcome);

            welcome2=new JLabel("Here you can find out how much money is left on the account.");
            welcome2.setBounds(80,100,400,40);
            add(welcome2);

            welcome3=new JLabel(" Log in to your account");
            welcome3.setBounds(180,120,400,40);
            add(welcome3);

            SignIn=new JButton("Log in");
            SignIn.setBounds(100,200,300,40);
            SignIn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //
                    Main.frame.mainwindow.setVisible(false);
                    Main.frame.signinwindow.setVisible(true);

                }
            });
            add(SignIn);
            or=new JLabel("or");
            or.setBounds(250,160,300,30);


            Create=new JButton("Create new account");
            Create.setBounds(100,240,300,40);
            Create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //
                    Main.frame.mainwindow.setVisible(false);
                    Main.frame.createwindow.setVisible(true);
                }
            });
           add(Create);



            Exit=new JButton("Exit");
            Exit.setBounds(100,280,300,40);
            Exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            add(Exit);



        }

    }
