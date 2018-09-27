package UDPogTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
    public static void main(String [] args){
        final int PORT_IN = 5656;
        final int PORT_OUT = 5657;

        try {
            ServerSocket server = new ServerSocket(PORT_IN);

            Socket socket = server.accept();
            


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
