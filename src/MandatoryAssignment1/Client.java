package MandatoryAssignment1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String [] args) throws IOException {
        System.out.println("Client");
        int port;
        String ip;
        String userName;




        System.out.println("starting TCPClient main");
        Scanner input = new Scanner(System.in);


        System.out.println("Write server ip: ");
        ip = input.next();
        System.out.println("Write port:");
        port = input.nextInt();
        System.out.println("Write Username:");
        userName = input.next();
        System.out.println("trying to connect");

        String joinCMD = "JOIN " + userName + ", " + ip + ":" + port;

        String finalIp = ip;
        Socket clientSocket = new Socket(finalIp, port);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Thread send = new Thread(()->{
            try {
                boolean test = true;
                do {
                    Scanner clientInput = new Scanner(System.in);
                    String inFromUser;

                    //System.out.println("Please type your text: ");
                    inFromUser = clientInput.nextLine();
                    if(inFromUser.equals("JOIN")){
                        outToServer.writeBytes(joinCMD + '\n');
                    }
                    else {
                        outToServer.writeBytes(inFromUser + '\n');
                    }
                    if(inFromUser.equalsIgnoreCase("quit"))test = false;
                }while(test);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread receive = new Thread(()->{
            try{
                boolean test = true;
                do{
                    String serverInput = null;
                    serverInput = inFromServer.readLine();
                    System.out.println("From server: " + serverInput);
                    if(serverInput.equalsIgnoreCase("quit"))test=false;
                }while(test);
            }catch (Exception e){

            }
        });

        send.start();
        receive.start();
        try {
            send.join();
            receive.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }







    }
}
