package Assignment3_final.server.serversidenetworking;

import Assignment3_final.client.clientsidenetworking.ChatClient;
import Assignment3_final.server.model.fileClass;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl1 implements ChatServer {

    private List<ChatClient> clientsForBroadcast;
    private List<String> messages;
    fileClass file;


    public ServerImpl1() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        clientsForBroadcast = new ArrayList<>();
        file = fileClass.getFileClassInstance();
        //messages = new ArrayList<String>();
    }



    private void updateClients(String result, ChatClient dontBroadcastToMe) {
        for (ChatClient client : clientsForBroadcast) {
            if(client.equals(dontBroadcastToMe)) continue;

            try {
                client.update(result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registerClient(ChatClient clientToRegister) {

        clientsForBroadcast.add(clientToRegister);
    }

    @Override
    public synchronized String receivedMessage(String str, ChatClient client)
            throws RemoteException {

        try {
            Thread.sleep(10);

        } catch (Exception e) {}  {

        }
       updateClients(str, client);
        file.addText(str);
        System.out.println(str);
        return str;



    }
}
