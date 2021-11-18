package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import Server.RecievePackage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Services {
	  
	public static RecievePackage rp;
	public static String css = 
			"<style type=\"text/css\"> \r\n" + 
			"	h4{ \r\n" + 
			"		height: 15px;\r\n" + 
			"		margin: 3; \r\n" + 
			"	}	\r\n" + 
			"	h3{\r\n" + 
			"		height: 10px;\r\n" + 
			"		margin: 3; \r\n" + 
			"	}	\r\n" + 
			"	ui{\r\n" + 
			"		display:flex; \r\n" + 
			"		flex-direction: row;\r\n" + 
			"		margin: 3px; \r\n" + 
			"	}\r\n" + 
			"	ci{\r\n" + 
			"		display:flex; \r\n" + 
			"		flex-direction: row;\r\n" + 
			"		margin: 3px; \r\n" + 
			"		border-radius: 5px;\r\n" + 
			"		background-color: #56ffc5;\r\n" +
			"		width: 345px;\r\n" + 
			"	}\r\n" + 
			"	addtext{ \r\n" + 
			"		display:flex; \r\n" + 
			"		flex-direction: column; \r\n" + 
			"		margin-left: 1px;\r\n" + 
			"        border-radius: 5px;\r\n" + 
			"		background-color: #56c5ff;\r\n" + 
			"		width: 300px;\r\n" + 
			"		\r\n" + 
			"	} \r\n" + 
			"	img{\r\n" + 
			"		margin-left: 6px;\r\n" + 
			"		margin-bottom: 6px;\r\n" + 
			"		margin-top: 6px;\r\n" + 
			"		border-radius: 5px;\r\n" + 
			"	}\r\n" + 
			"	p{\r\n" + 
			"		margin: 6px;\r\n" + 
			"		width: 60px;\r\n" + 
			"	} \r\n" + 
			"</style>";
	public static void Alert(AlertType type,String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	public static void Send() {
		Socket s;
		ObjectInputStream OIS;
		ObjectOutputStream OOS;
		try {
			
			//while(true) 
			{
				//s = new Socket(InetAddress.getByName("192.168.0.107"),1488);
				s = new Socket(InetAddress.getByName("127.0.0.1"),4004);
				OOS = new ObjectOutputStream(s.getOutputStream());
				OOS.flush();
				OIS = new ObjectInputStream(s.getInputStream());
				OOS.writeObject(rp);
				rp = (RecievePackage)OIS.readObject();
				
				
			}
			
		} catch (IOException e) {e.printStackTrace();} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
		
	}
	
}
