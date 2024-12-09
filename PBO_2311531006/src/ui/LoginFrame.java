package ui;

import javax.swing.*;
import model.User;
import service.LoginService;
import util.ValidationUtil;
import error.ValidationException;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Label Title
        JLabel lblTitle = new JLabel("Login Form");
        lblTitle.setBounds(150, 20, 100, 30);
        add(lblTitle);

        // Username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(50, 70, 100, 30);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 70, 200, 30);
        add(txtUsername);

        // Password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, 120, 100, 30);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 120, 200, 30);
        add(txtPassword);

        // Button Login
        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 180, 100, 30);
        add(btnLogin);

        // Action Listener
        btnLogin.addActionListener(e -> onLoginButtonClicked());
    }

    private void onLoginButtonClicked() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        // Membuat objek User
        User user = new User(username, password);

        try {
            // Validasi Input
            ValidationUtil.validate(user);

            // Cek Login
            LoginService loginService = new LoginService();
            if (loginService.authenticate(user)) {
                System.out.println("Login successful!");
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new MainFrame().setVisible(true);
                dispose();
            } else {
                System.out.println("Invalid username or password.");
                JOptionPane.showMessageDialog(this, "Login Gagal, Invalid username or password.");
            }
        } catch (ValidationException | NullPointerException exception) {
            System.out.println("Data tidak valid: " + exception.getMessage());
            JOptionPane.showMessageDialog(this, "Login Gagal: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.out.println("Selalu di eksekusi!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });
    }
}