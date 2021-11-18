package Server;

import java.util.ArrayList;

public class DataManipulator {
	private static WWSQL sql = WWSQL.getInstance();
	public static RecievePackage registration(RecievePackage rp) {
		rp = autorisation(rp);
		if(rp.getCom()==Command.autorisationFailed) {
			sql.getFromDB("INSERT INTO `chat`.`user` (`login`, `password`, `userinfo`) VALUES ('"+rp.getLogin()+"', '"+rp.getPass()+"', '"+rp.getUserInfo()+"');");
			rp.setCom(Command.registrationSuccesful);
		}else {
			rp.setCom(Command.registrationFailed);
		}
		
		return rp;
	}
	public static RecievePackage autorisation(RecievePackage rp) {
		String login = rp.getLogin();
		String pass = rp.getPass();
		ArrayList<String[]> ret = sql.getFromDB("SELECT id,userinfo FROM chat.user where login = '"+login+"' and password = '"+pass+"';");
		if(ret.size()==0) {
			rp.setCom(Command.autorisationFailed);}
		else {
			rp.setUserId(Integer.parseInt(ret.get(0)[0]));
			rp.setUserInfo(ret.get(0)[1]);
			rp.setCom(Command.autorisationSuccesful);
		}
		return rp;
	}
	public static RecievePackage addMessage(RecievePackage rp) {
		sql.getFromDB("INSERT INTO `chat`.`massages` (`massagetext`, `idchat`) VALUES ('"+rp.getMessage()+"', '"+rp.getChatId()+"');");
		return rp;
	}
	public static RecievePackage getChats(RecievePackage rp) {
		ArrayList<String[]> ret = sql.getFromDB("SELECT * FROM chat.chat;");
		int[] ids = new int[ret.toArray().length];
		String[] infos = new String[ret.toArray().length];
		for(int i= 0; i<ids.length;i++) {
			ids[i] = Integer.parseInt(ret.get(i)[0]);
			infos[i] = ret.get(i)[1];
		}
		rp.setIds(ids);
		rp.setChats(infos);
		return rp;
	}
	public static RecievePackage getLastMessages(RecievePackage rp) {
		ArrayList<String[]> ret = sql.getFromDB("SELECT * FROM chat.massages where id>"+rp.getLastMessageId()+" and idchat="+rp.getChatId()+";");
		String[] mess = new String[ret.toArray().length];
		int lmi = 0;
		for(int i = 0; i<mess.length;i++) {
			mess[i] = ret.get(i)[1];
			lmi = Integer.parseInt(ret.get(i)[0]);
		}
		rp.setNewMessages(mess);
		rp.setLastMessageId(lmi);
		return rp;
	}
	public static RecievePackage updUserData(RecievePackage rp) {
		sql.getFromDB("UPDATE `chat`.`user` SET `userinfo` = '"+rp.getUserInfo()+"' WHERE (`id` = '"+rp.getUserId()+"');"); 
		return rp;
	}
	public static RecievePackage getAllMessages(RecievePackage rp) {
		ArrayList<String[]> ret = sql.getFromDB("SELECT * FROM chat.massages where idchat="+rp.getChatId()+";");
		String[] mess = new String[ret.toArray().length];
		int lmi = 0;
		for(int i = 0; i<mess.length;i++) {
			mess[i] = ret.get(i)[1];
			lmi = Integer.parseInt(ret.get(i)[0]);
		}
		rp.setNewMessages(mess);
		rp.setLastMessageId(lmi);
		return rp;
	}
	public static RecievePackage addToChat(RecievePackage rp) {
		ArrayList<String[]> ret = sql.getFromDB("SELECT * FROM chat.chatuser where iduser='"+rp.getUserId()+"' and idchat = '"+rp.getChatId()+"';");
		if(ret.toArray().length==0) {
			sql.getFromDB("INSERT INTO `chat`.`chatuser` (`iduser`, `idchat`) VALUES ('"+rp.getUserId()+"', '"+rp.getChatId()+"');"); 
		}
		return rp;
	}
	public static RecievePackage getChatUsers(RecievePackage rp) {
		ArrayList<String[]> ret = sql.getFromDB("SELECT * FROM chat.chatuser where idchat = '"+rp.getChatId()+"';");
		int[] ids = new int[ret.toArray().length];
		String[] users = new String[ids.length];
		for(int i =0; i<ids.length; i++) {
			ids[i] = Integer.parseInt(ret.get(i)[1]);
			ArrayList<String[]> ret1 = sql.getFromDB("SELECT * FROM chat.user where id='"+ids[i]+"';");
			users[i] = ret1.get(0)[3];
		}
		rp.setIds(ids);
		rp.setChatUsers(users);
		return rp;
	}
	public static void addChat(String s) {
		sql.getFromDB("INSERT INTO `chat`.`chat` (`chatinfo`) VALUES ('"+s+"');");
	}
	public static String[] getChatsInf() {
		ArrayList<String[]> ret = sql.getFromDB("SELECT * FROM chat.chat;");
		int[] ids = new int[ret.toArray().length];
		String[] infos = new String[ret.toArray().length];
		for(int i= 0; i<ids.length;i++) {
			ids[i] = Integer.parseInt(ret.get(i)[0]);
			infos[i] = ret.get(i)[1];
		}
		
		return infos;
	}
	public static int[] getChatsIs() {
		ArrayList<String[]> ret = sql.getFromDB("SELECT * FROM chat.chat;");
		int[] ids = new int[ret.toArray().length];
		String[] infos = new String[ret.toArray().length];
		for(int i= 0; i<ids.length;i++) {
			ids[i] = Integer.parseInt(ret.get(i)[0]);
			infos[i] = ret.get(i)[1];
		}
		
		return ids;
	}
	public static void delChat(int idChat) {
		sql.getFromDB("DELETE FROM `chat`.`massages` WHERE (`idchat` = '"+idChat+"');");
		sql.getFromDB("DELETE FROM `chat`.`chatuser` WHERE (`idchat` = '"+idChat+"');");
		sql.getFromDB("Delete FROM chat.chat where id = "+idChat+";");
		
	}
	public static void updChat(int idChat, String s) {
		sql.getFromDB("UPDATE `chat`.`chat` SET `chatinfo` = '"+s+"' WHERE (`id` = '"+idChat+"');");
		
	}
}
