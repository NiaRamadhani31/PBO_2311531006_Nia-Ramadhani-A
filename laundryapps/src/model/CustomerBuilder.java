package model;

public class CustomerBuilder {
	private String id, nama, alamat, nohp;
	
	public CustomerBuilder() {
		// TODO Auto-generated constructor stub
	}
	public CustomerBuilder setId(String id) {
		this.id = id;
		return this;
	}
	
	public CustomerBuilder setNama(String Nama) {
		this.nama = Nama;
		return this;
	}
	
	public CustomerBuilder setAlamat(String alamat) {
		this.alamat = alamat;
		return this;
	}
	
	public CustomerBuilder setNohp(String nohp) {
		this.nohp = nohp;
		return this;
	}
	
	public Customer build() {
		return new Customer(id, nama, alamat, nohp);
	}
}
