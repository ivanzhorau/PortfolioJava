package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass extends Thread{
	
	private boolean active=true;
	 private Socket clientSocket; 
	 private ServerSocket server; 
	 private ObjectInputStream OIS;
	 private  ObjectOutputStream OOS; 
	 @Override
     public void run() {
		 try {
			 
			server = new ServerSocket(4004);
			System.out.println("Server zapuščany");
			while(active) {
				System.out.println("Server pracuje");
				clientSocket = server.accept();
				OIS = new ObjectInputStream(clientSocket.getInputStream());
				OOS = new ObjectOutputStream(clientSocket.getOutputStream());
				RecievePackage rp = (RecievePackage)OIS.readObject();
				switch(rp.getCom()) {
					case autorisation:
						rp = DataManipulator.autorisation(rp);
					break;
					case registration:
						rp = DataManipulator.registration(rp);
					break;
					case sendMessage:
						rp = DataManipulator.addMessage(rp);
					break;
					case getChats:
						rp = DataManipulator.getChats(rp);
					break;
					case getLastMessages:
						rp = DataManipulator.getLastMessages(rp);
					break;
					case sendUserData:
						rp = DataManipulator.updUserData(rp);
					break;
					case getAllMessages:
						rp = DataManipulator.getAllMessages(rp);
					break;
					case addToChat:
						rp = DataManipulator.addToChat(rp);
					break;
					case checkChatUsers:
						rp = DataManipulator.getChatUsers(rp);
					break;
					case getUsersChat:
						rp = DataManipulator.getChats(rp);
					break;
				default:
					break;
				}
				OOS.writeObject(rp);
				OOS.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
     }
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
