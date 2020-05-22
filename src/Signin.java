import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Signin extends Container {
    private JLabel welcome;
    private JLabel Cardnumber;
    private JLabel PIN;
    private JButton BACK;
    private JButton NEXT;
    private JTextField cardnumbertext;
    private JPasswordField pintext;

    public Signin() {
        setSize(500, 400);
        setLayout(null);
        welcome = new JLabel("Please,enter the data ");
        welcome.setBounds(150, 60, 220, 30);
        add(welcome);
        Cardnumber = new JLabel("Card");
        Cardnumber.setBounds(90, 100, 60, 30);
        add(Cardnumber);
        cardnumbertext = new JTextField();
        cardnumbertext.setBounds(150, 100, 150, 30);
        add(cardnumbertext);
        PIN = new JLabel("PIN");
        PIN.setBounds(90, 140, 60, 30);
        add(PIN);
        pintext = new JPasswordField();
        pintext.setBounds(150, 140, 150, 30);
        add(pintext);

        NEXT = new JButton("Next");
        NEXT.setBounds(90, 180, 210, 30);
        NEXT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardnumber =cardnumbertext.getText();
                String pin =pintext.getText();

                String query ="SELECT * FROM `client` WHERE `cardnumber`=? AND `pin`=?";
                PreparedStatement st;
                ResultSet rs;
                try {
                    st= DriverManager.getConnection("jdbc:mysql://localhost:3306/clienttable?useUnicode=true&serverTimezone=UTC","root","").prepareStatement(query);
                    st.setString(1, cardnumber);
                    st.setString(2, pin);
                    rs = st.executeQuery();
                    if(rs.next()){




                        Main.frame.signinwindow.setVisible(false);
                        Main.frame.nextwindow.setVisible(true);

                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid Card or PIN");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                cardnumbertext.setText("");
                pintext.setText("");

            }
        });
        add(NEXT);




        BACK=new JButton("Back");
        BACK.setBounds(90,220,210,30);
        BACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainwindow.setVisible(true);
                Main.frame.signinwindow.setVisible(false);

            }
        });
        add(BACK);




    }


    }





