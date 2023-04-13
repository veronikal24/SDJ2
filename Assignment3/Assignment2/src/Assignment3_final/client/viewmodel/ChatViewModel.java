package Assignment3_final.client.viewmodel;

import Assignment3_final.client.common.Observer;
import Assignment3_final.client.model.ClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;


public class ChatViewModel implements Observer {
    private ClientModel clientModel;

    private StringProperty messageInputProperty = new SimpleStringProperty("");
    private StringProperty accountNameLabelProperty;
    private ObservableList<String> messageList;


    public ChatViewModel(ClientModel model){
        clientModel = model;
        clientModel.attachObserver(this);
        messageList = FXCollections.observableArrayList();
        accountNameLabelProperty = new SimpleStringProperty("Welcome " + clientModel.getUserName());
    }

    public StringProperty getMessageInputProperty(){
        return messageInputProperty;
    }
    public StringProperty getAccountNameLabelProperty(){
        return accountNameLabelProperty;
    }
    public ObservableList<String> getMessagesList(){
        return messageList;
    }

    public void sentMessage() throws RemoteException {
        try {
            clientModel.sendMessage(String.valueOf(messageInputProperty.get()));
            messageInputProperty.setValue("");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void updateMessageList(){
        System.out.println(clientModel.getMessagesArrayList().size());
         int length = clientModel.getMessagesArrayList().size() -1;
         System.out.println(length+1);
        messageList.add(clientModel.getMessagesArrayList().get(length));
        System.out.println(messageList);
    }

    @Override
    public void update() {
        System.out.println("ChatViewModel::update");
        updateMessageList();
    }
}
