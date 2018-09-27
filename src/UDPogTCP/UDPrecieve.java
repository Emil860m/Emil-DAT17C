package UDPogTCP;

import java.io.IOException;
import java.net.*;

public class UDPrecieve {
    public static void main(String [] args){
        final int PORT_IN = 5657;
        final int PORT_OUT = 5656;
        String message = "";
//        final String IP = "127.0.0.1";

        try {
            DatagramSocket socket = new DatagramSocket(PORT_IN);

            do{
                byte[] data = new byte[1024];


                DatagramPacket packet = new DatagramPacket(data, data.length);

                socket.receive(packet);
                message = new String(data).trim();
                System.out.println(message);
            }while(!message.equalsIgnoreCase("quit"));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
