package Assignment3_final.client.view.chat;

import Assignment3_final.client.view.ViewHandler;
import Assignment3_final.client.viewmodel.ChatViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;

public class ChatViewController {
    private ViewHandler viewHandler;
    private ChatViewModel chatVM;
    @FXML
    ListView<String> messagesListView;
    @FXML
    TextField inputTextField;
    @FXML
    Label accountNameLabel;

    public void init(ViewHandler viewHandler, ChatViewModel chatVM){
        this.viewHandler = viewHandler;
        this.chatVM = chatVM;
        accountNameLabel.textProperty().bindBidirectional(chatVM.getAccountNameLabelProperty());
        inputTextField.textProperty().bindBidirectional(chatVM.getMessageInputProperty());
        messagesListView.setItems(chatVM.getMessagesList());


    }
    @FXML
    private void onLogoutBtn(){
        viewHandler.openLogInView();
    }
    @FXML
    private void onSentBtn() throws RemoteException {
        chatVM.sentMessage();
    }
}
