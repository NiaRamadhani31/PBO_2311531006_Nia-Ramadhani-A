package ui;

import javax.swing.*;

public class MainFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
        // Set title and basic configurations
        setTitle("Main Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Label Welcome
        JLabel lblWelcome = new JLabel("Welcome to the Main Application!");
        lblWelcome.setBounds(150, 50, 300, 30);
        add(lblWelcome);

        // Add Logout Button
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(250, 200, 100, 30);
        add(btnLogout);

        // Action Listener for Logout Button
        btnLogout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", 
                                                        "Logout Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                this.dispose(); // Close MainFrame
                SwingUtilities.invokeLater(() -> {
                    new LoginFrame().setVisible(true); // Reopen LoginFrame
                });
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
