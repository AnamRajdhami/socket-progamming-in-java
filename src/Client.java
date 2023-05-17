import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;
import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("172.25.20.110", 12345);

            // asking user input with buffer
            BufferedReader userInputBuffer = new BufferedReader(new InputStreamReader(System.in));

            // taking data from socket buffer
            BufferedReader socketBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();

            PrintWriter out = new PrintWriter(outputStream);
            String sendingMessage, receivingMessage;

            while (true){
                receivingMessage = socketBuffer.readLine();
                System.out.println("Server: " + receivingMessage);
                sendingMessage = userInputBuffer.readLine();
                out.println(sendingMessage);
                out.flush();
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
