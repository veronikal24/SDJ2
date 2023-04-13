package Assignment3_final.client.clientsidenetworking;


import Assignment3_final.Message;
import Assignment3_final.User;
import Assignment3_final.client.model.ClientModel;
import Assignment3_final.server.serversidenetworking.ChatServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient1 implements ChatClient {

    private ChatServer server;
    ClientModel clientModel;



    public RMIClient1(ClientModel clientModel) throws RemoteException {
       UnicastRemoteObject.exportObject(this, 0);
       this.clientModel = clientModel;

    }

    public void startClient() throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (ChatServer)registry.lookup("Server");
        server.registerClient(this);
    }



    @Override
    public void update(String result) throws RemoteException {


        System.out.println("Broadcasted > " + result);

        clientModel.receiveMessage(new Message(new User("temporary", "localhost") ,result));;
        //clientModel.notifyObservers();

    }

    @Override
    public synchronized void sendMessage(String message) throws RemoteException {

        String recent_message = server.receivedMessage(message, this);
        update(recent_message);



    }
}

