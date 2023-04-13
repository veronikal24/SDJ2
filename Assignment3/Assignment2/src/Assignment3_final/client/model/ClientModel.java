package Assignment3_final.client.model;

import Assignment3_final.Message;
import Assignment3_final.User;
import Assignment3_final.client.clientsidenetworking.RMIClient1;
import Assignment3_final.client.common.Observer;
import Assignment3_final.client.common.Subject;
import javafx.application.Platform;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClientModel implements Subject {

                        //SINGLETON
    private User user;
    private final int PORT_NO = 1234;
    //private ClientSocketHandler clientSocketHandler;
    private int id;
    private ArrayList<Message> messages;
    private static ClientModel clientModel = null;
    RMIClient1 client;


    private ClientModel() throws RemoteException {
        user = new User(null, null);
        messages = new ArrayList<Message>();
    }

    public static ClientModel getClientModel() throws RemoteException {
        if(clientModel == null){
            clientModel = new ClientModel();
        }
        return clientModel;
    }


    public void runClient() throws NotBoundException, RemoteException {
            this.client = new RMIClient1(this);
            client.startClient();
            User user = new User("Veronika", "localhost");

        }


    public void setId(int nextId){

        id = nextId;
    }
    public int getId(){

        return id;
    }

    public void sendMessage(String messageText) throws RemoteException {
        //fake null guard
        if(messageText!= null) {

            if (messageText.equalsIgnoreCase("") == false) {
                System.out.println("ClientModel::sendMessage::" + messageText);
                client.sendMessage(messageText);
            }
        }
    }
    public void receiveMessage(Message messageFormServer){

        System.out.println("ClientModel::receiveMessage::" + messageFormServer.getText());
        messages.add(messageFormServer);
        notifyObservers();
    }
    public  ArrayList<String> getMessagesArrayList(){

        ArrayList<String> messagesStringArrayList = new ArrayList<String>();
        for(int i = 0; i < messages.size(); i++){

            messagesStringArrayList.add(messages.get(i).getText());
        }

        return messagesStringArrayList;
    }

    public boolean validate() {

        return true;
    }

    public void login() throws NotBoundException, RemoteException {
        System.out.println("ClientModel::login " + user.getUserName() +"-"+  user.getIpAddress());
        runClient();
    }

    public void setUserName(String name){
        user.setUserName(name);
        notifyObservers();
    }

    public String getUserName(){
        return user.getUserName();
    }
    public void setIpAddress(String ip){
        user.setIpAddress(ip);
        notifyObservers();
    }

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public synchronized void attachObserver( Observer observer )
    {
        observers.add( observer );
    }
    @Override
    public synchronized void detachObserver( Observer observer)
    {
        observers.remove( observer );
    }
    @Override
    public void notifyObservers()
    {
        for( Observer o: observers )
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    o.update();
                }
            });

    }


}
