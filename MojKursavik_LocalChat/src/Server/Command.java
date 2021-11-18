package Server;

public enum Command {
	autorisation,
	registration,
	sendMessage, //adsyłka paviedamleńnia
	getChats,//atrymka śpisu čataŭ
	getLastMessages,//atrymka apošnich paviedamleńniaŭ u čacie
	sendUserData, //adsyłka UserNejma, avatarki i h.d.
	getAllMessages,//atrymka usiaho listavańnia u čacie
	addToChat, //uvachod u čat
	checkChatUsers, //atrymka karystalnikaŭ čata
	getUsersChat,//atrymka čataŭ karystalnika
	registrationSuccesful,
	registrationFailed,
	autorisationSuccesful,
	autorisationFailed
	
}
