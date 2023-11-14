package act3_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//création d'un thread :
		new ServerMT().start();}
	public void run() {
		try {
			System.out.println(" je suis un serveur en attend de la connexion du client");
			ServerSocket ss =new ServerSocket(1234);
			int clientoreder=1;
			//attendre le connexion du plusieurs client :
			while(true) {
				Socket s =ss.accept();
				System.out.println("client est connecté ");
				System.out.println("nouvelle connexion du client:"+s.getRemoteSocketAddress());
				ClientProcess clientprocess = new ClientProcess(s,clientoreder);
				clientprocess.start();
				clientoreder++;
				ss.close();}
			}catch(IOException e) {
				e.printStackTrace();
			}
	}

	}
