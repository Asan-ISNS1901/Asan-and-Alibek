import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            database manager = new database();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;
            while ( (packageData=(PackageData)inputStream.readObject())!=null ){
                if(packageData.getOperationType().equals("CREATE")){///
                    Client studentFromClient = packageData.getClient();
                    manager.CREATE(studentFromClient);
                }
                else if(packageData.getOperationType().equals("DATA")){
                    ArrayList<Client> infoForClient = manager.getAllClients();
                    PackageData toClient = new PackageData(infoForClient);
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
