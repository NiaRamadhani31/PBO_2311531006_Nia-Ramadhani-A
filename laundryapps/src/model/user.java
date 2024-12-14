package model;

public class user {
String id,  nama, username, password;

public user(String uname, String pass) {
	this.username = uname;
	this.password = pass;
}

public user() {
	// TODO Auto-generated constructor stub
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
