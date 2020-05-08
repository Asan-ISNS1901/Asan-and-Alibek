import java.io.Serializable;

public class Client implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String cardnumber;
    private String pin;
    private String money;

    public Client(Integer id, String name, String surname, String cardnumber, String pin, String money) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cardnumber = cardnumber;
        this.pin = pin;
        this.money = money;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String toString(){
        return id+" "+name+" "+surname+" "+money+"Тг";
    }

}
