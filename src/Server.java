import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket = serverSocket.accept();
            System.out.println("A new client added");

            // asking input from user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // taking input from socket
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // to send the message I need  pen
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream);

            String sendingMessage, receivingMessage;
            while (true){
                sendingMessage = userInput.readLine();
                out.println(sendingMessage);
                out.flush();
                receivingMessage = socketInput.readLine();
                System.out.println("Client:" + receivingMessage);
            }
        }

        catch(IOException e){
        throw new RuntimeException(e);
        }
    }
}