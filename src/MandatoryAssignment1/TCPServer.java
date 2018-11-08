package MandatoryAssignment1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer {
    final static ArrayList<Client> clients = new ArrayList<>();
    public static void main(String [] args){
        final int PORT = 5656;


        try{
            ServerSocket server = new ServerSocket(PORT);
            while(true) {

                final Socket socket = server.accept();
                System.out.println("Client connected");

                try {
                    InputStream input = socket.getInputStream();
                    byte[] dataIn = new byte[1024];
                    input.read(dataIn);
                    String message = new String(dataIn);
                    message = message.trim();
                    System.out.println(message);
                    if (message.contains("JOIN")) {

                        int indexOfComma = message.lastIndexOf(",");
                        String userName = message.substring(5, indexOfComma);
                        Client client = new Client();
                        client.setSocket(socket);
                        client.setOutToClient(socket.getOutputStream());
                        client.setInFromClient(socket.getInputStream());
                        if (usernameChecker(userName)) {

                            client.setUserName(userName);
                        client.setIP(socket.getInetAddress().getHostAddress());
                        client.setPort(socket.getPort());
                        client.setConnected(true);

                        clients.add(client);
                        client.getOutToClient().write("J_OK \n".getBytes());
                        sendMessageToAll("List of clients: " + clients.toString());
                            System.out.println(clients.toString());
                        System.out.println("Client added");
                        //client.StartThread();

                        ArrayList<Thread> receiveThreads = new ArrayList<>();
                        Thread receive = new Thread(() -> {
                            while (client.isConnected()) {
                                try {
                                    InputStream inputStream = client.getInFromClient();
                                    byte[] inFromClient = new byte[1024];
                                    inputStream.read(inFromClient);
                                    String msg = new String(inFromClient);
                                    msg.trim();
                                    System.out.println(client.getUserName() + ", " + msg);
                                    if (msg.contains("IMAV")) {
                                        client.setSecondsSinceIMAV(0);
                                    } else if (msg.contains("QUIT")) {
                                        System.out.println("Client disconnected!");
                                        client.getOutToClient().write("QUIT".getBytes());
                                        client.setConnected(false);
                                        client.getSocket().close();
                                        sendMessageToAll(client.getUserName() + " disconnected!");
                                        clients.remove(client);
                                        break;
                                    } else if (msg.contains("DATA")) {
                                        msg = msg.replaceAll("DATA ", "");
                                        String msgToAll = client.getUserName() + ": " + msg;

                                        System.out.println(msgToAll);
                                        sendMessageToAll(msgToAll);
                                    } else {
                                        client.getOutToClient().write("J_ER: Try one of these commands: DATA <<Free text>> or QUIT".getBytes());
                                    }


                                } catch (Exception e) {

                                }
                            }
                        });
                        receiveThreads.add(receive);
                        for (Thread t : receiveThreads) {
                            t.start();
                        }
                    }else{
                            client.getOutToClient().write("J_ER: Duplicate username!\n".getBytes());
                        }

                    }


                } catch (Exception e) {

                }

            }

        }catch (Exception e){

        }




    }


    public static void send(OutputStream output, String message){
        try{
            byte[] dataToSend = message.getBytes();
            output.write(dataToSend);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void sendMessageToAll(String message){
        for (Client c:clients) {
            if(c.isConnected()){
                send(c.getOutToClient(), message);
            }
        }
    }

    public static boolean usernameChecker(String username){
        for(Client c: clients){
            if(c.getUserName().equalsIgnoreCase(username)){
              return false;
            }
        }
        return true;
    }
}
