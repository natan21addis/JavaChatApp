import javax.imageio.IIOException;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
public static ArrayList<ClientHandler> clientHandlers= new ArrayList<>();
private Socket socket;
private BufferReader bufferReader;
private String clientUsername;

public ClientHandler(Socket socket){
    try {
        this.socket=socket;
        this.bufferedWriter=new buffredWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.bufferedReader=new buffredReader(new InputStreamReader(socket.getInputStream()));
        this.clientUsername=bufferedReader.readLine();
        ClientHandler.add(this);

        broadcastMessage("server : " + clientUsername + "has entred the chat !" );
} catch(IOException e){
        closeEverything(socket, bufferedReader,bufferedWriter);
    }


    @Override
    public void run() {
string messageFromClient;
while(socket.isConnected()){
    try{
        if(!clientHandler.clientUsername.equals(clientUsername)){
            clientHandler.bufferedWriter.write(messageToSend);
            clientHandler.bufferedWriter.newLine();
            clientHandler.bufferedWriter.flush();
        }
    } catch(IOException e){
        closeEverything(socket,bufferedReader,bufferedWriter);
    }
}
    }
    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage(messageToSend: "server : " + clientUsername + "has left the chat!");

    }
    public void closedEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try {
            if(bufferedReader !=null){
                bufferReader.close();
            }
            if(bufferedWriter !=null){
                bufferWriter.close();
            }
            if(socket != null) {
                socket.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
