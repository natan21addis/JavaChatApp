import javax.imageio.IIOException;
import java.net.ServerSocket;
import java.net.Socket;
public class server {
private ServerSocket serverSocket;
public Server(ServerSocket serverSocket){
    this.serverSocket=serverSocket;
}
public void startServer(){
    try {
        while(!serverSocket.isClosed()){
            Socket socket= serverSocket.accept();
            system.out.println("a new client is connected");
            ClientHandler clientHandler=new ClientHandler(socket);

            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    } catch(IIOException e){

    }
}
public void closeServerSocket() {
    try {
        if(serverSocket != null){
            serverSocket.close();
        }


    }catch(IOException e){
        e.printStackTrace

    }
}

    public static void main(String[] args) {

    }
}
