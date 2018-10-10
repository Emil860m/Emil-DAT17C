package MandatoryAssignment1;

import java.io.*;
import java.net.Socket;

public class Client {
    private String userName;
    private Socket socket;
    private InputStream inFromClient;
    private OutputStream outToClient;
    //private int clientNr;
    //private static int clientCount;
    private String IP;
    private int Port;
    private int secondsSinceIMAV;
    private boolean connected;
    private Thread IMAVincrementer = new Thread(()->{
        while(connected){
            try{
                incrementIMAV();
                if(getSecondsSinceIMAV()<10){
                    connected = false;
                    break;
                }
                Thread.sleep(1000);
            }catch(Exception E){

            }
        }
    });

    public void incrementIMAV(){
        secondsSinceIMAV++;
    }
    public int getSecondsSinceIMAV() {
        return secondsSinceIMAV;
    }

    public void setSecondsSinceIMAV(int secondsSinceIMAV) {
        this.secondsSinceIMAV = secondsSinceIMAV;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public Client(String userName, Socket socket, InputStream inFromClient, OutputStream outToClient) {
        this.userName = userName;
        this.socket = socket;
        this.inFromClient = inFromClient;
        this.outToClient = outToClient;
        //this.clientNr = clientNr;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int port) {
        Port = port;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Client() {
    }
//    public static int getClientCount(){
//        return clientCount;
//    }
//    public static void incrementClientCount(){
//        clientCount++;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    public void setOutToClient(DataOutputStream outToClient) {
        this.outToClient = outToClient;
    }

    public InputStream getInFromClient() {
        return inFromClient;
    }

    public void setInFromClient(InputStream inFromClient) {
        this.inFromClient = inFromClient;
    }

    public OutputStream getOutToClient() {
        return outToClient;
    }

    public void setOutToClient(OutputStream outToClient) {
        this.outToClient = outToClient;
    }

//    public int getClientNr() {
//        return clientNr;
//    }
//
//    public void setClientNr(int clientNr) {
//        this.clientNr = clientNr;
//    }
//
//    public static void setClientCount(int clientCount) {
//        Client.clientCount = clientCount;
//    }

    public void sendToAll(String message){

    }

    @Override
    public String toString() {
        return getUserName();
    }
}
