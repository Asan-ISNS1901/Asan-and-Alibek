import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.prefs.BackingStoreException;

public class CREATE extends Container {
    private JLabel cardnumber;
    private JLabel pin;
    private JLabel name;
    private JLabel surname;
    private JLabel welcome;
    private JLabel money;
    private JTextField cardnumbertext;
    private JPasswordField pintext;
    private JTextField nametext;
    private JTextField surnametext;
    private JTextField moneytext;
    private JButton BACK;
    private JButton create;
    public CREATE() {
        setSize(500, 400);
        setLayout(null);
        welcome = new JLabel("Please,enter the data to create account");
        welcome.setBounds(120, 20, 270, 30);
        add(welcome);

        money=new JLabel("Money");
        money.setBounds(90,60,60,30);
        add(money);

        moneytext=new JTextField();
        moneytext.setBounds(150,60,150,30);
        add(moneytext);

        name=new JLabel("Name");
        name.setBounds(90,100,60,30);
        add(name);

        nametext=new JTextField();
        nametext.setBounds(150,100,150,30);
        add(nametext);

        surname=new JLabel("Surname");
        surname.setBounds(90,140,60,30);
        add(surname);

        surnametext=new JTextField();
        surnametext.setBounds(150,140,150,30);
        add(surnametext);

        cardnumber = new JLabel("Card");
        cardnumber.setBounds(90, 180, 60, 30);
        add(cardnumber);

        cardnumbertext = new JTextField();
        cardnumbertext.setBounds(150, 180, 150, 30);
        add(cardnumbertext);

        pin = new JLabel("PIN");
        pin.setBounds(90, 220, 60, 30);
        add(pin);

        pintext = new JPasswordField();
        pintext.setBounds(150, 220, 150, 30);
        add(pintext);

        create=new JButton("CREATE");
        create.setBounds(90,260,210,30);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nametext.getText();
                String surname=surnametext.getText();
                String cardnumber=cardnumbertext.getText();
                String pin=pintext.getText();
                String money=moneytext.getText();

                Client client=new Client(null ,name,surname,cardnumber,pin,money);
                packagedata PD=new packagedata("CREATE",client);
                Main.connect(PD);


                nametext.setText("");
                surnametext.setText("");
                cardnumbertext.setText("");
                pintext.setText("");
                moneytext.setText("");

            }
        });
        add(create);

        BACK = new JButton("BACK");

        BACK.setBounds(90, 300, 210, 30);
        BACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainwindow.setVisible(true);
                Main.frame.createwindow.setVisible(false);

            }
        });
        add(BACK);



    }

}

