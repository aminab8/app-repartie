package act3_2;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	 int ord = 0;
	    public static void main(String[] args) {
	        new Server().start();
	    }
	    public void run() {
	        try{
	            ServerSocket server = new ServerSocket(500);
	            while (true){
	                Socket client = server.accept();
	                ClientProcess clientProcess = new ClientProcess(client,++ord);
	                clientProcess.start(); }
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }

	    public class ClientProcess extends Thread {
	        private Socket client;
	        private int ord;
	        public ClientProcess(Socket client,int ord){
	            super();
	            this.client=client;
	            this.ord=ord;
	        }

	        @Override
	        public void run() {
	            try{
	                System.out.println("Un client est connecté "+client.getRemoteSocketAddress()+" a l'ordre "+ord);
	                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
	                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
	                Operation op  = (Operation) ois.readObject();
	                int nb1=op.getNb1();
	                int nb2=op.getNb2();
	                char operation=op.getOp();
	                int res;

	                switch (operation){
	                    case '+':  res=nb1+nb2;
	                        break;
	                    case '-':  res=nb1-nb2;
	                        break;
	                    case '*':  res=nb1*nb2;
	                        break;
	                    case '/':  res=nb1/nb2;
	                        break;
	                    default:res=0;
	                }
	                op.setRes(res);
	                oos.writeObject(op);
	                Client.close();
	            }catch (Exception e){
	                e.printStackTrace();
	            }
	        }
	    }
	}

}
