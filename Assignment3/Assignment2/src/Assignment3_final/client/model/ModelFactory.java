package Assignment3_final.client.model;

import java.rmi.RemoteException;

public class ModelFactory implements Model{
    private ClientModel clientModel = ClientModel.getClientModel();
    public ModelFactory() throws RemoteException {
    }
    public ClientModel getClientModel(){

        return clientModel;

    }
}
