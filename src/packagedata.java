import java.io.Serializable;
import java.util.ArrayList;

public class packagedata implements Serializable {
    private String operationType;// ADD, LIST
    private Client client;
    private ArrayList<Client> clients;

    public packagedata(String operationType, Client student) {////Send to server info about one student
        this.operationType = operationType;
        this.client = student;
    }

    public packagedata(String operationType) {/// List all info from server
        this.operationType = operationType;
    }

    public packagedata(ArrayList<Client> students) {/// Send back to client
        this.clients = students;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Client getStudent() {
        return client;
    }

    public void setStudent(Client student) {
        this.client = student;
    }

    public ArrayList<Client> getStudents() {
        return clients;
    }

    public void setStudents(ArrayList<Client> students) {
        this.clients = students;
    }
}
