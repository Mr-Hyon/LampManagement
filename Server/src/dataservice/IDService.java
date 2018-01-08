package dataservice;

import java.rmi.Remote;

import java.rmi.RemoteException;

public interface IDService extends Remote {

    public String getID(String type)throws RemoteException;

}

