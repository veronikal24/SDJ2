package Assignment3_final.client.view.logIn;

import Assignment3_final.client.view.ViewHandler;
import Assignment3_final.client.viewmodel.LogInViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class LogInViewController {
    private ViewHandler viewHandler;
    private LogInViewModel logInVM;

    @FXML
    TextField loginTextField;
    @FXML
    TextField ipTextField;
    @FXML
    Label errorLabel;


    public void init(ViewHandler viewHandler, LogInViewModel logInVM){
        this.viewHandler = viewHandler;
        this.logInVM = logInVM;
        loginTextField.textProperty().bindBidirectional(logInVM.getUserNameProperty());
        ipTextField.textProperty().bindBidirectional(logInVM.getIpProperty());
        errorLabel.textProperty().bindBidirectional(logInVM.getErrorLabelProperty());
    }


    @FXML
    public void onLoginBtn() throws NotBoundException, RemoteException {
        if(logInVM.validate()==true){
            logInVM.login();
            viewHandler.openChatView();
        }
        logInVM.logInError();
    }
}
