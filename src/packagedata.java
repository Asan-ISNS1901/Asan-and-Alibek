import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private Client client;
    private ArrayList<Client> clients;

    public PackageData(String operationType, Client client) {
        this.operationType = operationType;
        this.client = client;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public PackageData(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public String getOperationType() {
        return operationType;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}

