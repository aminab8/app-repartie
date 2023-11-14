package act3_1;

import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s;
		try {
			System.out.println("je suis un client pas encore connecté");
			s =new Socket("localhost",1234);
			System.out.println("le client est connecté");
			//fermeture de socket
			s.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
