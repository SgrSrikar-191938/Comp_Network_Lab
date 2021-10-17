import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
    public static void main(String args[]) throws SocketException, IOException{
        DatagramSocket serverSocket = new DatagramSocket(6112);
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            byte[] receivebuffer = new byte[1024];
            byte[] sendbuffer = new byte[1024];
            DatagramPacket recvdpkt = new DatagramPacket(receivebuffer, receivebuffer.length);
            serverSocket.receive(recvdpkt);
            InetAddress IP = recvdpkt.getAddress();
            int portno = recvdpkt.getPort();
            String clientdata = new String(recvdpkt.getData());
            System.out.println("\nClient : "+ clientdata);
            System.out.print("\nServer: ");
            String serverdata = sc.nextLine();
            sendbuffer = serverdata.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, portno);
            serverSocket.send(sendPacket);
            if(serverdata.equalsIgnoreCase("bye"))
            {
                System.out.println("Connection ended by server");
                break;
            }
        }
        serverSocket.close();
    }
}