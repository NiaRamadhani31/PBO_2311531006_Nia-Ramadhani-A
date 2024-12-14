package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainUI extends JFrame {

    public MainUI() {
        setTitle("Laundry Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(900, 600);

        // Panel Kiri: Form Input
        JPanel leftPanel = new JPanel(new GridLayout(10, 2, 5, 5));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        leftPanel.add(new JLabel("Order ID:"));
        JTextField orderIdField = new JTextField();
        leftPanel.add(orderIdField);

        leftPanel.add(new JLabel("Pelanggan:"));
        JButton pilihButton = new JButton("Pilih");
        leftPanel.add(pilihButton);

        leftPanel.add(new JLabel("Tanggal:"));
        JTextField tanggalField = new JTextField();
        leftPanel.add(tanggalField);

        leftPanel.add(new JLabel("Tanggal Pengambilan:"));
        JTextField tanggalPengambilanField = new JTextField();
        leftPanel.add(tanggalPengambilanField);

        leftPanel.add(new JLabel("Status:"));
        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Dalam Antrian", "Sedang Diproses", "Selesai"});
        leftPanel.add(statusComboBox);

        leftPanel.add(new JLabel("Total:"));
        JLabel totalLabel = new JLabel("Rp10.000");
        leftPanel.add(totalLabel);

        leftPanel.add(new JLabel("Pembayaran:"));
        JComboBox<String> pembayaranComboBox = new JComboBox<>(new String[]{"Cash", "Transfer"});
        leftPanel.add(pembayaranComboBox);

        leftPanel.add(new JLabel("Status Pembayaran:"));
        JComboBox<String> statusPembayaranComboBox = new JComboBox<>(new String[]{"Belum Bayar", "Sudah Bayar"});
        leftPanel.add(statusPembayaranComboBox);

        JButton selesaiButton = new JButton("Selesai");
        JButton batalButton = new JButton("Batal");
        leftPanel.add(selesaiButton);
        leftPanel.add(batalButton);

        // Panel Tengah: Tabel Layanan
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnNames = {"ID", "Layanan", "Status", "Harga", "Jumlah", "Total"};
        Object[][] data = {
                {"17", "Sprei", "Sedang Diproses", 105000, 3, 350000},
                {"18", "Sprei", "Dalam Antrian", 70000, 2, 140000},
                {"19", "Pakaian", "Dalam Antrian", 25000, 5, 125000},
                {"20", "Gaun", "Dalam Antrian", 50000, 1, 50000},
                {"21", "Jas", "Dalam Antrian", 80000, 4, 320000}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(table);
        centerPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Panel Bawah Tabel (Harga/Satuan, Jumlah, Total, Tombol Aksi)
        JPanel bottomOfTablePanel = new JPanel(new BorderLayout(5, 5));

        // Form Input di Bawah Tabel
        JPanel hargaPanel = new JPanel(new GridLayout(1, 6, 5, 5));
        hargaPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        hargaPanel.add(new JLabel("Harga/Satuan:"));
        JTextField hargaField = new JTextField();
        hargaPanel.add(hargaField);

        hargaPanel.add(new JLabel("Jumlah:"));
        JTextField jumlahField = new JTextField();
        hargaPanel.add(jumlahField);

        hargaPanel.add(new JLabel("Total:"));
        JTextField totalField = new JTextField();
        hargaPanel.add(totalField);

        bottomOfTablePanel.add(hargaPanel, BorderLayout.NORTH);

        // Tombol Aksi di Bawah Form Input
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton simpanButton = new JButton("Simpan");
        JButton ubahButton = new JButton("Ubah");
        JButton hapusButton = new JButton("Hapus");
        JButton batalButton2 = new JButton("Batal");

        buttonPanel.add(simpanButton);
        buttonPanel.add(ubahButton);
        buttonPanel.add(hapusButton);
        buttonPanel.add(batalButton2);

        bottomOfTablePanel.add(buttonPanel, BorderLayout.SOUTH);

        // Tambahkan komponen ke frame
        centerPanel.add(bottomOfTablePanel, BorderLayout.SOUTH);
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainUI frame = new MainUI();
            frame.setVisible(true);
        });
    }
}
