import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.util.Scanner;
public class client
{
    public static void main(String args[]) throws RemoteException {
        client c = new client();
        c.connectRemote();
    }
    private void connectRemote() throws RemoteException{
        try{
            Scanner sc = new Scanner(System.in);
            Registry reg = LocateRegistry.getRegistry("localhost",2326);
            adder ad = (adder)reg.lookup("Hi Server");
            System.out.println("Enter two numbers");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("The sum of given two numbers is: "+ad.add(a,b)); 
        }
        catch(NotBoundException|RemoteException e)
        {
            System.out.println("exception"+e);
        }
    }
}