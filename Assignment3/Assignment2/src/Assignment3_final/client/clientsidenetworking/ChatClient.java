package Assignment3_final.client.clientsidenetworking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClient extends Remote {

    void update(String result) throws RemoteException;

    void sendMessage(String message) throws RemoteException;
}
