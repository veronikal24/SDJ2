package Assignment3_final.server.serversidenetworking;

import Assignment3_final.client.clientsidenetworking.ChatClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServer extends Remote {
    //String sendMessage(String str, ChatClient client) throws RemoteException;

    void registerClient(ChatClient clientToRegister) throws RemoteException;
    String receivedMessage(String str, ChatClient client) throws RemoteException;
}