package model;

public class Laundry {
    private int id;       // ID untuk item laundry
    private String nama;  // Nama pelanggan
    private String jenis; // Jenis laundry
    private int jumlah;   // Jumlah item

    // Constructor tanpa parameter (opsional)
    public Laundry() {
    }

    // Constructor dengan parameter
    public Laundry(int id, String nama, String jenis, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
    }

    // Getter dan Setter untuk properti ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter dan Setter untuk properti Nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter untuk properti Jenis
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    // Getter dan Setter untuk properti Jumlah
    public int getJumlah() {
        return jumlah;
    }

    public void "setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}