package MandatoryAssignment1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    private String userName;
    private Socket socket;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private int clientNr;
    private static int clientCount;

    public Client(String userName, Socket socket, BufferedReader inFromClient, DataOutputStream outToClient, int clientNr) {
        this.userName = userName;
        this.socket = socket;
        this.inFromClient = inFromClient;
        this.outToClient = outToClient;
        this.clientNr = clientNr;
    }

    public Client() {
    }
    public static int getClientCount(){
        return clientCount;
    }
    public static void incrementClientCount(){
        clientCount++;
    }

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

    public BufferedReader getInFromClient() {
        return inFromClient;
    }

    public void setInFromClient(BufferedReader inFromClient) {
        this.inFromClient = inFromClient;
    }

    public DataOutputStream getOutToClient() {
        return outToClient;
    }

    public void setOutToClient(DataOutputStream outToClient) {
        this.outToClient = outToClient;
    }
}
