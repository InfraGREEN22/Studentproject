package Server;

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) throws IOException {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6794);
        Runtime.getRuntime().addShutdownHook(new Thread(){public void run(){
            try {
                welcomeSocket.close();
                System.out.println("The server is shut down!");
            } catch (IOException e) { /* failed */ }
        }});
        //dfdsa
        while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                if(connectionSocket.isConnected()==true)
                    System.out.println("Connected");
                BufferedReader inFromClient =
                        new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                System.out.println("Received: " + clientSentence);
                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                outToClient.writeBytes(capitalizedSentence+" <- From server");
                    }
    }
}
