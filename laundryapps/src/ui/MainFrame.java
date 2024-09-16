package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor untuk frame utama
    public MainFrame() {
        // Judul frame
        setTitle("Nia Laundry");
        
        // Ukuran frame
        setSize(400, 300);
        
        // Mengatur layout dan membuat panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 10, 10)); // 3x3 grid dengan spasi antar tombol

        // Membuat tombol
        JButton penggunaButton = new JButton("Pengguna");
        JButton layananButton = new JButton("Layanan");
        JButton pelangganButton = new JButton("Pelanggan");
        JButton pesananButton = new JButton("Pesanan");
        JButton profilButton = new JButton("Profil");
        JButton laporanButton = new JButton("Laporan");
        JButton keluarButton = new JButton("Keluar");

        // Menambahkan tombol ke panel
        panel.add(penggunaButton);
        panel.add(layananButton);
        panel.add(pelangganButton);
        panel.add(pesananButton);
        panel.add(profilButton);
        panel.add(laporanButton);
        panel.add(new JLabel()); // Kosong untuk penempatan yang sesuai
        panel.add(keluarButton);
        panel.add(new JLabel()); // Kosong untuk penempatan yang sesuai

        // Menambahkan panel ke frame
        add(panel);

        // Menutup aplikasi saat window ditutup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat tombol "Keluar" agar bisa keluar dari aplikasi
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Menutup aplikasi
            }
        });
    }

    // Main method untuk menjalankan aplikasi
    public static void main(String[] args) {
        // Membuat instance dari frame
       MainFrame frame = new MainFrame();
        
        // Menampilkan frame
        frame.setVisible(true);
    }
}