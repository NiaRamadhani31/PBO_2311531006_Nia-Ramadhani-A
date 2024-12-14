package model;

public class Customer {
String id, nama, alamat, noHP;

public Customer(String id, String nama, String alamat, String nohp) {
	this.id = id;
	this.nama = nama;
	this.alamat = alamat;
	this.noHP = nohp;
}

public String getId() {
	return id;
}

public String getNama() {
	return nama;
}

public String getAlamat() {
	return alamat;
}

public String getNoHP() {
	return noHP;
}


}