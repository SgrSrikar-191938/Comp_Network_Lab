import java.io.*;
import java.net.*;
class ChatServer
{
   public static void main(String args[])
  {
     try
    {
      ServerSocket ss = new ServerSocket(6218);
      Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgin=" ";
            String msgout =" ";
            while(!msgin.equals("end")){
                msgin=din.readUTF();
                System.out.println(msgin);
                msgout=br.readLine();
                dout.writeUTF(msgout);
                dout.flush();
            }
            s.close();
        }
        catch(Exception e){
            
        }
    }
}