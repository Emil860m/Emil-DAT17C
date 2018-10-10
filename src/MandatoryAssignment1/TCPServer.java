package MandatoryAssignment1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer {
    public static void main(String [] args) throws IOException {
        System.out.println("Server");
        final int PORT_IN = 5656;
        final int PORT_OUT = 5657;
        ArrayList<Client> clients = new ArrayList();



        System.out.println("starting TCP Server main program");

        Thread newClients = new Thread(()->{
        while(true){
            try {
                int clientCount = 0;
                ServerSocket server = new ServerSocket(PORT_IN);
                System.out.println("waiting for a connection");
                Socket socket = server.accept();
                Thread tempClient = new Thread(()->{
                    try {
                        Socket tempSocket = socket;
                        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                        String clientInput = null;
                        clientInput = inFromClient.readLine();
                        String[] tempArray = clientInput.split(",");
                        if(tempArray[0].equalsIgnoreCase("JOIN")){
                            Client.incrementClientCount();
                            Client client = new Client(tempArray[1], tempSocket, inFromClient, outToClient, Client.);
                        }
                    }catch (IOException e){

                    }
                });
                tempClient.start();
            }catch (Exception e){

            }
        }
    });

        try {
//            String clientIp = socket.getInetAddress().getHostAddress();
//            System.out.println("IP: " + clientIp);
//            System.out.println("PORT: " + socket.getPort());

            boolean test = true;
            do {
                String clientInput = null;

                //clientInput = inFromClient.readLine();
//                if(){//Join cmd
//                    outToClient.writeBytes("J_OK \n");
//                } else if(){
//
//                }else if(){
//
//                }
                System.out.println("FROM CLIENT: " + clientInput);
                //outToClient.writeBytes(clientInput + '\n');
                if(clientInput.equalsIgnoreCase("quit"))test = false;
            }while(test);
        } catch () {
            //e.printStackTrace();
        }

    }
}
