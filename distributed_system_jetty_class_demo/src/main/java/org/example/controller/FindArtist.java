package org.example.controller;
import java.rmi.*;

public interface FindArtist extends Remote 
{
	public String FindArtist(String name) throws RemoteException;
}
