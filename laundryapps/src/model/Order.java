package model;

public class Order {
String id, id_customer, id_service, tanggalOrder, tanggalSelesai, status_bayar, status_pesanan, id_user;
int total;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getId_customer() {
	return id_customer;
}
public void setId_customer(String id_customer) {
	this.id_customer = id_customer;
}
public String getId_service() {
	return id_service;
}
public void setId_service(String id_service) {
	this.id_service = id_service;
}
public String getTanggalOrder() {
	return tanggalOrder;
}
public void setTanggalOrder(String tanggalOrder) {
	this.tanggalOrder = tanggalOrder;
}
public String getTanggalSelesai() {
	return tanggalSelesai;
}
public void setTanggalSelesai(String tanggalSelesai) {
	this.tanggalSelesai = tanggalSelesai;
}
public String getStatus_bayar() {
	return status_bayar;
}
public void setStatus_bayar(String status_bayar) {
	this.status_bayar = status_bayar;
}
public String getStatus_pesanan() {
	return status_pesanan;
}
public void setStatus_pesanan(String status_pesanan) {
	this.status_pesanan = status_pesanan;
}
public String getId_user() {
	return id_user;
}
public void setId_user(String id_user) {
	this.id_user = id_user;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
}
