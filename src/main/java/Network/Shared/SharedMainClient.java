package Network.Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SharedMainClient extends Remote {
    void printMessage(String s) throws RemoteException;
}