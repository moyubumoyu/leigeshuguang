package cn.itcast.application;
import java.util.HashMap;
import java.io.*;
public class DBUtil {
	private static DBUtil instance = null;
	private HashMap<String,User> users = new HashMap<String,User>();
	
	private DBUtil(){
		
		getUsersFromInputStream("user.txt");
	}
	
	public void processUserString(String userString){
		String [] userFields = userString.split(",");
		User u = new User();
		u.setCardId(userFields[0]);
		u.setCardPwd(userFields[1]);
		u.setUserName(userFields[2]);
		u.setCall(userFields[3]);
		u.setAccount(Integer.parseInt(userFields[4]));
		users.put(u.getCardId(),u);
	}
	
	public void addUser(User u){
		users.put(u.getCardId(),u);
	}
	
	private void getUsersFromInputStream(String isName){
		try{
			FileInputStream fs = new FileInputStream(isName);
			byte[] content = new byte[1024];
			int i=0;
			int conInteger = 0;
			while(true){
			    try{
			        conInteger = fs.read();
			    } catch (Exception e){
			       e.printStackTrace();
			    }
			    if(-1 == conInteger){
			         break;
			    }else if('\r' == (char)conInteger || '\n' == (char)conInteger){
			        try{
			            this.processUserString(new String(content,"GBK").trim());
			            i=0;
			        } catch (Exception e){
			           e.printStackTrace();
			        }
			        continue;
			    } else{
			        content[i] = (byte)conInteger;
			        i++;
			    }   
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static DBUtil getInstance(){
		if(instance == null){
			synchronized(DBUtil.class){
				if(instance == null){
					instance = new DBUtil();
				}
			}
		}
		return instance;
	}
	
	public User getUser(String cardId){
		User user = (User) users.get(cardId);
		return user;
	}
	
	public HashMap<String,User> getUsers(){
		return users;
	}

}
