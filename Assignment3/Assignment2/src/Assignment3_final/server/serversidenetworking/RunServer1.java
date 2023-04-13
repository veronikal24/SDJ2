package Assignment3_final.server.serversidenetworking;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer1 {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        ChatServer server = new ServerImpl1();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("Server started");
    }
}
