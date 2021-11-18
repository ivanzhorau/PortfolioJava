package Server;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.MysqlDataSource;


/*
 Тут выкарыстаны Singleton адзін з самых лёгкіх патэрнаў.
 Гэтая кляса адказвае за непасрэдную сувязь з MySQL.
  
 */
public class WWSQL {
	private static String usname = "root";
	private static String pass = "nonserviam"; 
	private static String url = "jdbc:mysql://127.0.0.1:3306?serverTimezone=Europe/Moscow&useSSL=false";
	private static WWSQL instance = new WWSQL();
	public static synchronized WWSQL getInstance() {
		if (instance == null) {
			instance = new WWSQL();
		}
		return instance;
	}
	public  ArrayList<String[]> getFromDB(String SQL){
		ArrayList<String[]> res = new ArrayList<String[]>();
		ResultSet rs = null;
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUrl(url);
		ds.setUser(usname);
		ds.setPassword(pass);
		System.out.println(SQL);
		try (Connection conn = ds.getConnection()){
			
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        	 Statement st = conn.createStatement();
        	if(SQL.toLowerCase().contains("select")) {
	         rs = st.executeQuery(SQL);
	         ResultSetMetaData rsmd = rs.getMetaData();
	         
	         while(rs.next()) {
	        	 String[] s = new String[rsmd.getColumnCount()];
	        	 for(int i=0;i<s.length;i++) {
	        		 s[i] = rs.getString(i+1);
	        	 }
	        	 res.add(s);
	         }}else {
	        	st.executeUpdate(SQL); 
	         }
            
            conn.close();
         } catch (SQLException|InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException
				|NoSuchMethodException|SecurityException|ClassNotFoundException e) {e.printStackTrace();}
	
		return res;
	}

}
