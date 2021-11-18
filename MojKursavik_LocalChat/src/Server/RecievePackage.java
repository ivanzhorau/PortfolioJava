package Server;
//paviedamleńni zachoŭvajucca u vyhladzie html kodu
public class RecievePackage  implements java.io.Serializable{
	private int userId, chatId,lastMessageId=0;
	private String[] newMessages, chats,chatUsers;
	private int[] Ids;
	private String message,login,pass,userInfo,ChatInfo;
	private Command com;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLastMessageId() {
		return lastMessageId;
	}
	public void setLastMessageId(int lastMessageId) {
		this.lastMessageId = lastMessageId;
	}
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String[] getChats() {
		return chats;
	}
	public void setChats(String[] chats) {
		this.chats = chats;
	}
	public String[] getNewMessages() {
		return newMessages;
	}
	public void setNewMessages(String[] newMessages) {
		this.newMessages = newMessages;
	}
	public int[] getIds() {
		return Ids;
	}
	public void setIds(int[] Ids) {
		this.Ids = Ids;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Command getCom() {
		return com;
	}
	public void setCom(Command com) {
		this.com = com;
	}
	public String[] getChatUsers() {
		return chatUsers;
	}
	public void setChatUsers(String[] chatUsers) {
		this.chatUsers = chatUsers;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public String getChatInfo() {
		return ChatInfo;
	}
	public void setChatInfo(String chatInfo) {
		ChatInfo = chatInfo;
	}
	
}
