package UDPogTCP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPsend {
    public static void main(String [] args) {
        final int PORT_IN = 5656;
        final int PORT_OUT = 5657;
        final String IP = "127.0.0.1";
        
        try {
            DatagramSocket socket = new DatagramSocket(PORT_IN);
            while(true) {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();

                byte[] data = message.getBytes();
                InetAddress address = InetAddress.getByName(IP);

                DatagramPacket packet = new DatagramPacket(data, data.length, address, PORT_OUT);

                socket.send(packet);
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
