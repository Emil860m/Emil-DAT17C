package UDPogTCP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPsend {
    public static void main(String [] args) {
        final int PORT_IN = 5656;
        final int PORT_OUT = 5657;
        final String IP = "127.0.0.1";
        String message = "";
        
        try {
            DatagramSocket socket = new DatagramSocket(PORT_IN);
            do {
                System.out.println("Type yo message!");
                Scanner scanner = new Scanner(System.in);
                message = scanner.nextLine();

                byte[] data = message.getBytes();
                InetAddress address = InetAddress.getByName(IP);

                DatagramPacket packet = new DatagramPacket(data, data.length, address, PORT_OUT);

                socket.send(packet);
                System.out.println("Sick message, bro!");
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
