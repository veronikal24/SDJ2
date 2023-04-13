package Assignment3_final;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class User extends UnicastRemoteObject {
    // needs to have Serializable to be able to be send
    private String userName;
    private String ipAddress;
    public User(String name, String IP) throws RemoteException {
        super();
        userName = name;
        ipAddress = IP;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public void setIpAddress(String ipAddress) {

        this.ipAddress = ipAddress;
    }

    public String getUserName(){

        return userName;
    }
    public String getIpAddress(){
        return ipAddress;
    }
}
