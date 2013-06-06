package it.gek.testClient;

import java.rmi.RemoteException;

import it.geek.test.TestServiceProxy;

public class Testarello {
	
	public static void main (String args[]){
		
		try {
			String ritorno = new TestServiceProxy().print("avantiLazio");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
