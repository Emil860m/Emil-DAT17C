package MandatoryAssignment1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String [] args) {
        System.out.println("Server");
        final int PORT_IN = 5656;
        final int PORT_OUT = 5657;


        System.out.println("starting TCP Server main program");



        try {
            ServerSocket server = new ServerSocket(PORT_IN);
            System.out.println("waiting for a connection");
            Socket socket = server.accept();
            System.out.println("we are connected");
            String clientIp = socket.getInetAddress().getHostAddress();
            System.out.println("IP: " + clientIp);
            System.out.println("PORT: " + socket.getPort());
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

            boolean test = true;
            do {
                String clientInput = null;

                clientInput = inFromClient.readLine();
                System.out.println("FROM CLIENT: " + clientInput);
                outToClient.writeBytes(clientInput + '\n');
                if(clientInput.equalsIgnoreCase("quit"))test = false;
            }while(test);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
