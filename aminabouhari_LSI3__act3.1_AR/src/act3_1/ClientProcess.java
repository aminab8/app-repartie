package act3_1;

import java.io.IOException;
import java.net.Socket;

public class ClientProcess extends Thread {
	 Socket socket ; 
	int clientoreder ;
	public ClientProcess(Socket socket, int clientoreder) {
		super();
		this.socket = socket;
		this.clientoreder = clientoreder;
	}
	//le traitement effectué par le client 
	public void run() {
		System.out.println("le client est de numero"+clientoreder+"est connecté");
		//socket est fermé:
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
