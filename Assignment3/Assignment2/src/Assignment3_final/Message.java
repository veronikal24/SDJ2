package Assignment3_final;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Message extends UnicastRemoteObject {
    // needs serializable to be able to be send
    private String text;
    private User sender;
    public Message() throws RemoteException {
        super();
    }
    public Message(User sender,String text) throws RemoteException {
        super();

        this.text = text;
        this.sender =sender;
    }
    public String getText(){

        return text;
    }
    public User getSender(){

        return sender;
    }

}
