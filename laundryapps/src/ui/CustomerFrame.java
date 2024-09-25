package ui;

import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.CustomerRepo;
import model.Customer;
import table.TableCustomer;

public class CustomerFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtAlamat;
    private JTextField txtNoHP;
    private JTable table;
    private CustomerRepo customerRepo; // Corrected variable name
    private String selectedId = null; 

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerFrame frame = new CustomerFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void reset() {
        txtName.setText("");
        txtAlamat.setText("");
        txtNoHP.setText("");
        selectedId = null;
    }

    public void loadTable() {
        List<Customer> customerList = customerRepo.show(); // Changed from 'user' to 'Customers'
        TableCustomer model = new TableCustomer(customerList); // Changed to TableCustomers
        table.setModel(model);
    }

    public CustomerFrame() {
        customerRepo = new CustomerRepo(); // Corrected variable initialization
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nama");
        lblNewLabel.setBounds(10, 20, 80, 25);
        contentPane.add(lblNewLabel);

        txtName = new JTextField();
        txtName.setBounds(100, 20, 200, 25);
        contentPane.add(txtName);
        txtName.setColumns(10);

        JLabel lblAlamat = new JLabel("Alamat");
        lblAlamat.setBounds(10, 60, 80, 25);
        contentPane.add(lblAlamat);

        txtAlamat = new JTextField();
        txtAlamat.setBounds(100, 60, 200, 25);
        contentPane.add(txtAlamat);
        txtAlamat.setColumns(10);

        JLabel lblNoHP = new JLabel("NoHP");
        lblNoHP.setBounds(10, 100, 80, 25);
        contentPane.add(lblNoHP);

        txtNoHP = new JTextField();
        txtNoHP.setBounds(100, 100, 200, 25);
        contentPane.add(txtNoHP);
        txtNoHP.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    Customer customer = new Customer(); // Changed to 'Customers'
                    customer.setNama(txtName.getText());
                    customer.setAlamat(txtAlamat.getText()); // Changed field to 'Alamat'
                    customer.setNoHP(txtNoHP.getText()); // Changed field to 'NoHP'
                    customerRepo.save(customer);
                    reset();
                    loadTable();
                    JOptionPane.showMessageDialog(null, "Customer saved successfully!");
                }
            }
        });
        btnSave.setBounds(50, 150, 80, 30);
        contentPane.add(btnSave);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedId != null && validateInput()) {
                    Customer customer = new Customer(); // Changed to 'Customers'
                    customer.setId(selectedId);
                    customer.setNama(txtName.getText());
                    customer.setAlamat(txtAlamat.getText()); // Changed field to 'Alamat'
                    customer.setNoHP(txtNoHP.getText()); // Changed field to 'NoHP'
                    customerRepo.update(customer);
                    reset();
                    loadTable();
                    JOptionPane.showMessageDialog(null, "Customer updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Select a customer first!");
                }
            }
        });
        btnUpdate.setBounds(140, 150, 80, 30);
        contentPane.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedId != null) {
                    customerRepo.delete(selectedId); 
                    reset();
                    loadTable();
                    JOptionPane.showMessageDialog(null, "Customer deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Select a customer first!");
                }
            }
        });
        btnDelete.setBounds(230, 150, 80, 30);
        contentPane.add(btnDelete);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        btnCancel.setBounds(320, 150, 80, 30);
        contentPane.add(btnCancel);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 200, 460, 250);
        contentPane.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 460, 250);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    selectedId = table.getModel().getValueAt(row, 0).toString();
                    txtName.setText(table.getModel().getValueAt(row, 1).toString());
                    txtAlamat.setText(table.getModel().getValueAt(row, 2).toString()); // 'Alamat' instead of 'Username'
                    txtNoHP.setText(table.getModel().getValueAt(row, 3).toString()); // 'NoHP' instead of 'Password'
                }
            }
        });

        loadTable();
    }

    private boolean validateInput() {
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty!");
            return false;
        }
        if (txtAlamat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Alamat cannot be empty!");
            return false;
        }
        if (txtNoHP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "NoHP cannot be empty!");
            return false;
        }
        return true;
    }
}