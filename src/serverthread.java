import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class serverthread extends Thread{
    private Socket socket;

    public serverthread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            database admin = new database();
            admin.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            packagedata packageData = null;
            while ( (packageData=(packagedata)inputStream.readObject())!=null ){
                if(packageData.getOperationType().equals("CREATE")){
                    Client clientfromuser = packageData.getStudent();
                    admin.addClient(clientfromuser);
                }
                else if(packageData.getOperationType().equals("DATA")){
                    ArrayList<Client> infoForClient = admin.getAllCLients();
                    packagedata toClient = new packagedata(infoForClient);
                    outputStream.writeObject(toClient);

                }
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
