import java.sql.*;
import java.util.ArrayList;

public class database {
    private Connection connection;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");///
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clienttable?useUnicode=true&serverTimezone=UTC", "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO client (id, name, surname, cardnumber, pin,money) " +
                    "VALUES (NULL, ?, ?, ?, ?,?)"
            );
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setString(3, client.getCardnumber());
            statement.setString(4, client.getPin());
            statement.setString(5, client.getMoney());

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Client> getAllCLients() {
        ArrayList<Client> clientlist = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM client");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String cardnumber = resultSet.getString("cardnumber");
                String pin = resultSet.getString("pin");
                String money = resultSet.getString("money");

                clientlist.add(new Client(id, name, surname, cardnumber, pin, money));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientlist;
    }


}

