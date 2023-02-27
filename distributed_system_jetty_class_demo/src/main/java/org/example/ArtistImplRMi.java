package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.example.controller.FindArtist;

public class ArtistImplRMi extends UnicastRemoteObject implements  FindArtist{

	protected ArtistImplRMi() throws RemoteException {
		super();
	}

	@Override
	public String FindArtist(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
