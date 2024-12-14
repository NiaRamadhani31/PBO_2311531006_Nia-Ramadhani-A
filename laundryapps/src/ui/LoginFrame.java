package ui;

import javax.swing.*;

import error.ValidationException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.user;  // Import class user
import service.LoginService;
import util.ValidationUtil;

public class LoginFrame {

    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("Laundry Apps");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Membuat panel untuk memuat komponen
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        // Menampilkan frame
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);  // Mengatur layout menjadi null sehingga bisa mengatur posisi secara manual

        // Label judul
        JLabel titleLabel = new JLabel("LAUNDRY NIA");
        titleLabel.setBounds(150, 30, 100, 25);
        panel.add(titleLabel);

        // Label slogan
        JLabel sloganLabel = new JLabel("Mari Cuci Pakaian Anda di Laundry Nia");
        sloganLabel.setBounds(110, 60, 200, 25);
        panel.add(sloganLabel);

        // Label Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 80, 25);
        panel.add(userLabel);

        // Text field untuk Username
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 100, 165, 25);
        panel.add(userText);

        // Label Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 140, 80, 25);
        panel.add(passwordLabel);

        // Text field untuk Password
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 140, 165, 25);
        panel.add(passwordText);

        // Tombol Login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 180, 100, 25);
        panel.add(loginButton);

        // Action listener untuk tombol Login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String userValue = userText.getText();
				String passValue = passwordText.getText();
				
				user user = new user(userValue, passValue);
				
				try {
					ValidationUtil.validate(user);
					LoginService loginService = new LoginService();
					if(loginService.authenticate(user)) {
						System.out.println("Login Successful");
						new MainFrame().setVisible(true);
						frame.dispose();
					}else {
						System.out.println("Invalid username or password");
						JOptionPane.showMessageDialog(null, "Login Gagal");
					}
				}catch(ValidationException | NullPointerException exception) {
					System.out.println("Data tidak valid : " + exception.getMessage());
					JOptionPane.showMessageDialog(null, "Login Gagal: "+ exception.getMessage());
				}finally {
					System.out.println("Selalu di eksekusi");
				}
            }
        });
    }
}
