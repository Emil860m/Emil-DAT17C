package MandatoryAssignment1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
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
        //System.out.println("Connected \nType !join to join chat");
        OutputStream outToServer = clientSocket.getOutputStream();
        InputStream inFromServer = clientSocket.getInputStream();
        byte[] join = joinCMD.getBytes();
        outToServer.write(join);
        Thread send = new Thread(()->{
            try {
                boolean test = true;
                do {
                    Scanner clientInput = new Scanner(System.in);
                    String inFromUser;

                    //System.out.println("Please type your text: ");
                    inFromUser = clientInput.nextLine();
                        outToServer.write(inFromUser.getBytes());

                    if(inFromUser.equalsIgnoreCase("quit"))test = false;
                }while(test);
                Thread.currentThread().interrupt();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread receive = new Thread(()->{
            try{
                boolean test = true;
                do{
                    byte[] dataIn = new byte[1024];
                    inFromServer.read(dataIn);
                    String msgIn = new String(dataIn);
                    msgIn = msgIn.trim();


                    System.out.println(msgIn);
//                    String serverInput = null;
//                    serverInput = inFromServer.read();
//                    System.out.println("From server: " + serverInput);
                    if(msgIn.equalsIgnoreCase("QUIT"))test=false;
                }while(test);
                Thread.currentThread().interrupt();
            }catch (Exception e){

            }
        });

        Thread IMAV = new Thread(()->{
           while(true && send.isAlive()){
               try {
                   Thread.sleep(10000);
                   outToServer.write("IMAV".getBytes());
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
            Thread.currentThread().interrupt();
        });

        send.start();
        receive.start();
        IMAV.start();
        try {
            send.join();
            receive.join();
            IMAV.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }







    }
}
