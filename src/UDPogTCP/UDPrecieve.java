package UDPogTCP;

import java.io.IOException;
import java.net.*;

public class UDPrecieve {
    public static void main(String [] args){
        final int PORT_IN = 5657;
        final int PORT_OUT = 5656;
//        final String IP = "127.0.0.1";

        try {
            DatagramSocket socket = new DatagramSocket(PORT_IN);
//            String message = "Hello from UDPrecieve";

            byte[] data = new byte[1024];
//            InetAddress address = InetAddress.getByName(IP);

            DatagramPacket packet = new DatagramPacket(data, data.length);
            while (true) {
                socket.receive(packet);
                String message = new String(data);
                System.out.println(message);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
