package model;

public class user {
String id,  nama, username, password;
public static boolean login(String username, String password) {
	boolean isLogin = false;
	user user = new user();
	user.setId("1");
	user.setNama("nia");
	user.setUsername("nia");
	user.setPassword("12345");

	if(user.getUsername().equalsIgnoreCase(username.trim())
			&& user.getPassword().equals(password)) {
		isLogin = true;
	} else {isLogin=false;}
	
	return isLogin;
}


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNama() {
	return nama;
}

public void setNama(String nama) {
	this.nama = nama;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
}
