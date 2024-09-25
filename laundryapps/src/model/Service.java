package model;

public class Service {
	String id, jenis, satuan, status;
	int harga;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}