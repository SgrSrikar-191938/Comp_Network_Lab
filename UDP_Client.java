import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
    public static void main(String args[]) throws SocketException, IOException{
        Scanner sc = new Scanner(System.in);
        InetAddress IP = InetAddress.getByName("localhost");
        DatagramSocket clientSocket = new DatagramSocket();
        while(true)
        {
            byte[] sendbuffer = new byte[1024];
            byte[] receivebuffer = new byte[1024];
            System.out.print("\nClient: ");
            String clientData = sc.nextLine();
            sendbuffer = clientData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, 6112);
            clientSocket.send(sendPacket);
            if(clientData.equalsIgnoreCase("bye"))
            {
                System.out.println("Connection ended by the client");
                break;
            }
            DatagramPacket receivePacket = new DatagramPacket(receivebuffer, receivebuffer.length);
            clientSocket.receive(receivePacket);
            String serverData = new String(receivePacket.getData());
            System.out.print("\nServer: "+ serverData);
        }
        clientSocket.close();
    }
}