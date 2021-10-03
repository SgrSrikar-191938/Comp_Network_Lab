import java.io.*;
import java.net.*;
class ChatClient{
    public static void main(String args[])
    {
        try{
            Socket s = new Socket(InetAddress.getLocalHost(),6218);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgin=" ";
            String msgout =" ";
            while(!msgin.equals("end"))
            {
                msgout = br.readLine();
                dout.writeUTF(msgout);
                msgin=din.readUTF();
                System.out.println(msgin);
        }
    }
         catch(Exception e){
             
         }
}
}