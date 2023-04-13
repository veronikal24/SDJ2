package Assignment3_final.client.viewmodel;

import Assignment3_final.client.model.ClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LogInViewModel {
    private ClientModel clientModel;

    private StringProperty userNameProperty = new SimpleStringProperty("");
    private StringProperty ipProperty = new SimpleStringProperty("");
    private StringProperty errorLabelProperty = new SimpleStringProperty("");


    public LogInViewModel(ClientModel model){

        clientModel = model;
    }

    public StringProperty getUserNameProperty(){

        return userNameProperty;
    }
    public StringProperty getIpProperty(){

        return ipProperty;
    }
    public StringProperty getErrorLabelProperty(){

        return errorLabelProperty;
    }
    public void login() throws NotBoundException, RemoteException {
        clientModel.setUserName(userNameProperty.get());
        clientModel.setIpAddress(ipProperty.get());
        clientModel.login();
    }

    public boolean validate(){

        return clientModel.validate();
    }

    public void logInError(){

        errorLabelProperty.setValue("Invalid Login Info");
    }

}
