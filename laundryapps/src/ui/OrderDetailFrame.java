package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.OrderDetailRepo;
import DAO.OrderRepo;
import DAO.ServiceRepo;
import model.Customer;
import model.Order;
import model.OrderDetail;
import model.Service;
import table.TableOrderDetail;
import table.TableService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class OrderDetailFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtOrderID;
	private JTextField txtHargaKg;
	private JTextField txtJumlah;
	private JTextField txtTotal;
	private JDateChooser tanggal;
	private JDateChooser tanggal_kembali;
	private JComboBox boxStatus;
	private JLabel lblTotalHargaShow;
	private JComboBox boxPembayaran;
	private JComboBox boxPembayaran_1;
	public String id;
	private JTable tableService;
	public String id_ord;
	public static String id_order;
	private JTable tableOrderDetail;
	public int total_harga;
	private JTextField txtCostumer;
	public String tgl;
	public String tgl_kbl;

	
	OrderRepo opo = new OrderRepo();
	List<Order> ls_opo;
	
	ServiceRepo srv = new ServiceRepo();
	List<Service> ls;
	
	OrderDetailRepo ord = new OrderDetailRepo();
	List<OrderDetail> ls_ord;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailFrame frame = new OrderDetailFrame();
					frame.setVisible(true);
					frame.loadTable();
					frame.loadTableOrderDetail();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setTanggal(Date date) {
        tanggal.setDate(date); 
    }
	public void setTanggal_kembali(Date date) {
        tanggal_kembali.setDate(date); 
    }
	
	public void setStatus(String status) {
		boxStatus.setSelectedItem(status);
	}
	public void setLblTotalHargaShow(String total) {
		lblTotalHargaShow.setText("Rp. " + total);
	}
	public void setBoxPembayaran(String pembayaran) {
		boxPembayaran.setSelectedItem(pembayaran);
	}
	public void setBoxPembayaran_1(String pembayaran) {
		boxPembayaran_1.setSelectedItem(pembayaran);
	}
	
	public void reset() {
		txtHargaKg.setText("");
		txtJumlah.setText("");
		txtTotal.setText("");
	}
	
	public void resetOrder() {
		txtOrderID.setText("");
		
	}
	
	public static void setId_order(String orderId) {
	    id_order = orderId; 

	}
	public void loadTable() {
		ls = srv.show();
		TableService ts = new TableService(ls);
		tableService.setModel(ts);
		tableService.getTableHeader().setVisible(true);
	}
	
	public void loadTableOrderDetail() {
		ls_ord = ord.showById(id_order);
		TableOrderDetail tod = new TableOrderDetail(ls_ord);
		tableOrderDetail.setModel(tod);
		tableOrderDetail.getTableHeader().setVisible(true);
		updateTotalHarga();
		
	}
	
	public void updateTotalHarga() {
        int totalHarga = ord.total(id_order);
        total_harga = totalHarga;
    }
	
	public void setCostumer(Customer costumer) {
	    txtCostumer.setText(costumer.getNama()); 
	}
	
	public void setOrderID(String id_order) {
	    txtOrderID.setText(id_order); 
	}
	
	public JTextField getTxtOrderId() {
        return txtOrderID; 
    }
	
	public void setTxtCostumer(String cust) {
		txtCostumer.setText(cust);;
	}
	
	public String setTanggal(String tanggal) {
		return tgl = tanggal;
	}
	
	public void resetAll() {
		id_ord = null;
		id_order = null;
		total_harga = 0;
		tgl = null;
		tgl_kbl = null;
		setTxtCostumer("");
		setTanggal("");
		setTanggal_kembali(null);
		setLblTotalHargaShow("");
	}
	
	/**
	 * Create the frame.
	 */
	public OrderDetailFrame() {
		
		setBackground(new Color(246, 246, 246));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(246, 246, 246));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderId.setBounds(20, 27, 81, 25);
		contentPane.add(lblOrderId);
		
		txtOrderID = new JTextField();
		txtOrderID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				id_order = txtOrderID.getText();
			}
		});
		txtOrderID.setBounds(143, 20, 130, 45);
		contentPane.add(txtOrderID);
		txtOrderID.setColumns(10);
		txtOrderID.setEnabled(false);
		
		JLabel lblPelanggan = new JLabel("Pelanggan");
		lblPelanggan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPelanggan.setBounds(20, 83, 81, 25);
		contentPane.add(lblPelanggan);
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTanggal.setBounds(20, 142, 81, 25);
		contentPane.add(lblTanggal);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(20, 255, 81, 25);
		contentPane.add(lblStatus);
		
		boxStatus = new JComboBox();
		boxStatus.setModel(new DefaultComboBoxModel(new String[] {"Progress", "Selesai", "Diambil"}));
		boxStatus.setBounds(143, 248, 130, 45);
		contentPane.add(boxStatus);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(20, 312, 53, 25);
		contentPane.add(lblTotal);
		
		
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPembayaran.setBounds(20, 356, 103, 25);
		contentPane.add(lblPembayaran);
		
		boxPembayaran = new JComboBox();
		boxPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Tunai", "Non-Tunai"}));
		boxPembayaran.setBounds(143, 402, 130, 45);
		contentPane.add(boxPembayaran);
		
		JLabel lblStatusPembayaran = new JLabel("Status Pembayaran");
		lblStatusPembayaran.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatusPembayaran.setBounds(20, 411, 113, 25);
		contentPane.add(lblStatusPembayaran);
		
		boxPembayaran_1 = new JComboBox();
		boxPembayaran_1.setModel(new DefaultComboBoxModel(new String[] {"Lunas", "Belum Lunas"}));
		boxPembayaran_1.setBounds(143, 349, 130, 45);
		contentPane.add(boxPembayaran_1);
		
		JLabel lblLayanan = new JLabel("Layanan");
		lblLayanan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLayanan.setBounds(283, 20, 103, 25);
		contentPane.add(lblLayanan);
		
		JLabel lblHargakg = new JLabel("Harga/Kg");
		lblHargakg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHargakg.setBounds(283, 484, 81, 25);
		contentPane.add(lblHargakg);
		
		JLabel lblId_layanan = new JLabel("");
		lblId_layanan.setEnabled(false);
		lblId_layanan.setVisible(false);
		lblId_layanan.setBounds(400, 248, 326, 13);
		contentPane.add(lblId_layanan);
		
		txtHargaKg = new JTextField();
		txtHargaKg.setColumns(10);
		txtHargaKg.setBounds(353, 490, 140, 19);
		contentPane.add(txtHargaKg);
		txtHargaKg.setEnabled(false);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJumlah.setBounds(500, 484, 103, 25);
		contentPane.add(lblJumlah);
		
		txtJumlah = new JTextField();
		txtJumlah.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String jumlahText = txtJumlah.getText();
		        String hargaKgText = txtHargaKg.getText();
		        if (!jumlahText.isEmpty() && !hargaKgText.isEmpty()) {
		            try {
		                int jumlah = Integer.parseInt(jumlahText);
		                int hargaKg = Integer.parseInt(hargaKgText);
		                int totalharga = jumlah * hargaKg;
		                txtTotal.setText(String.valueOf(totalharga));
		            } catch (NumberFormatException ex) {
		                txtTotal.setText("0"); 
		            }
		        } else {
		            txtTotal.setText("0"); 
		        }
			}
		});
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(556, 490, 140, 19);
		contentPane.add(txtJumlah);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal_1.setBounds(706, 484, 103, 25);
		contentPane.add(lblTotal_1);
		
		JLabel lblId_order = new JLabel("");
		lblId_order.setEnabled(false);
		lblId_order.setVisible(false);
		lblId_order.setBounds(400, 248, 326, 13);
		contentPane.add(lblId_order);
		
		lblTotalHargaShow = new JLabel("Rp. " + ord.total(txtOrderID.getText()));
		lblTotalHargaShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalHargaShow.setBounds(143, 303, 130, 43);
		contentPane.add(lblTotalHargaShow);
		updateTotalHarga();
		lblTotalHargaShow.setText("Rp. " + total_harga);
		
		tanggal = new JDateChooser();
		tanggal.setBounds(143, 133, 130, 45);
		contentPane.add(tanggal);
		tanggal.getDateEditor().addPropertyChangeListener("date", evt -> {
		    if (tanggal.getDate() != null) {
		        SimpleDateFormat sdf_tanggal = new SimpleDateFormat("yyyy-MM-dd");
		        tgl = sdf_tanggal.format(tanggal.getDate());
		    }

		});
		
		tanggal_kembali = new JDateChooser();
		tanggal_kembali.setBounds(143, 188, 130, 46);
		contentPane.add(tanggal_kembali);
		tanggal_kembali.getDateEditor().addPropertyChangeListener("date", evt -> {
		    if (tanggal_kembali.getDate() != null) {
		    	SimpleDateFormat sdf_tanggal_kembali = new SimpleDateFormat("yyy-MM-dd");
		        tgl_kbl = sdf_tanggal_kembali.format(tanggal_kembali.getDate());
		    }
		});
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(746, 490, 140, 19);
		contentPane.add(txtTotal);
		txtTotal.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(283, 48, 593, 213);
		contentPane.add(scrollPane);
		
		tableService = new JTable();
		tableService.getTableHeader().setVisible(true);
		tableService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tableService.getSelectedRow();

		        if (selectedRow != -1) {
		            String idLayanan = tableService.getValueAt(selectedRow, 0).toString();
		            txtHargaKg.setText(tableService.getValueAt(selectedRow, 3).toString());
		            lblId_layanan.setText(idLayanan);
		            if (ord.exists(id_order, idLayanan)) {
		                JOptionPane.showMessageDialog(null, "Service sudah ada di order detail.");
		            } else { 
		            }
		        }
			}
		});
		scrollPane.setViewportView(tableService);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_order != null) {
					if (id_order != null) {
			            String idLayanan = lblId_layanan.getText();
			            if (ord.exists(id_order, idLayanan)) {
			                JOptionPane.showMessageDialog(null, "Layanan ini sudah ada dalam detail order.", "Error", JOptionPane.ERROR_MESSAGE);
			            } else {
			                String jumlahText = txtJumlah.getText();
			                String totalText = txtTotal.getText();

			                if (jumlahText.isEmpty()) {
			                    JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
			                    return; 
			                }
			                
			                if (totalText.isEmpty()) {
			                    JOptionPane.showMessageDialog(null, "Total tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
			                    return;
			                }
			                try {
			                    int jumlah = Integer.parseInt(jumlahText);
			                    int total = Integer.parseInt(totalText);
			                    OrderDetail orderdetail = new OrderDetail();
			                    orderdetail.setId_order(id_order);
			                    orderdetail.setId_layanan(idLayanan);
			                    orderdetail.setJumlah(jumlah);
			                    orderdetail.setTotal(total);
			                    ord.save(orderdetail);
			                    reset();
			                    loadTableOrderDetail();
			                    lblTotalHargaShow.setText("Rp. " + total_harga);
			                } catch (NumberFormatException ex) {
			                    JOptionPane.showMessageDialog(null, "Jumlah dan total harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
			                }
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan disimpan");
			        }
				}
			}
		});
		btnSimpan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSimpan.setBounds(283, 519, 140, 34);
		contentPane.add(btnSimpan);
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_ord != null) {
					OrderDetail orderdetail = new OrderDetail();
					orderdetail.setId_order(id_order);
					orderdetail.setId_layanan(lblId_layanan.getText());
					orderdetail.setJumlah(Integer.parseInt(txtJumlah.getText()));
					orderdetail.setTotal(Integer.parseInt(txtTotal.getText()));
					orderdetail.setId_order_detail(id_ord);
					ord.update(orderdetail);
					reset();
					loadTableOrderDetail();
					lblTotalHargaShow.setText("Rp. " + total_harga);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan diedit");
				}
			}
		});
		btnUbah.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUbah.setBounds(421, 519, 155, 34);
		contentPane.add(btnUbah);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_ord != null) {
					ord.delete(id_ord);
					reset();
					loadTableOrderDetail();
					lblTotalHargaShow.setText("Rp. " + total_harga);
					
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan dihapus");
				}
			}
		});
		btnHapus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHapus.setBounds(571, 519, 155, 34);
		contentPane.add(btnHapus);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnBatal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBatal.setBounds(721, 519, 155, 34);
		contentPane.add(btnBatal);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(283, 303, 591, 170);
		contentPane.add(scrollPane_1);
		
		tableOrderDetail = new JTable();
		tableOrderDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id_ord = tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 0).toString();
				int selectedRow = tableOrderDetail.getSelectedRow();
				if (selectedRow != -1) {
					String idLayanan = tableOrderDetail.getValueAt(selectedRow, 2).toString();
					for (Service service : ls) {
						if (service.getId().equals(idLayanan)) {
							txtHargaKg.setText(String.valueOf(service.getHarga()));
							break;
						}
					}
				}
				
				txtJumlah.setText(tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 3).toString());
				txtTotal.setText(tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 4).toString());
				id_order = tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 1).toString();
				lblId_layanan.setText(tableOrderDetail.getValueAt(tableOrderDetail.getSelectedRow(), 2).toString());
				
				
			}
		});
		scrollPane_1.setViewportView(tableOrderDetail);
		
		JButton btnSimpanOrder = new JButton("Simpan");
		btnSimpanOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_order != null) {
					Order order = new Order();
					order.setId_order(id_order);
					order.setNama(txtCostumer.getText());
					order.setTanggal(tgl);
					order.setTanggal_kembali(tgl_kbl);
					order.setStatus(boxStatus.getSelectedItem().toString());
					order.setTotal_harga(total_harga);
					order.setPembayaran(boxPembayaran.getSelectedItem().toString());
					order.setStatus_bayar(boxPembayaran_1.getSelectedItem().toString());
					opo.save(order);
					OrderFrame.loadTable();
					OrderDetailFrame.this.dispose();
					resetAll();
					
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan disimpan");
				}
			}
		});
		btnSimpanOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSimpanOrder.setBounds(20, 467, 130, 48);
		contentPane.add(btnSimpanOrder);
		
		JButton btnBatalOrder = new JButton("Batal");
		btnBatalOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBatalOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBatalOrder.setBounds(143, 467, 130, 48);
		contentPane.add(btnBatalOrder);
		
		txtCostumer = new JTextField();
		txtCostumer.setEditable(false);
		txtCostumer.setColumns(10);
		txtCostumer.setBounds(143, 75, 130, 19);
		contentPane.add(txtCostumer);
		
		JLabel lblTanggalPengambilan = new JLabel("Tanggal Pengambilan");
		lblTanggalPengambilan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTanggalPengambilan.setBounds(20, 196, 113, 25);
		contentPane.add(lblTanggalPengambilan);
		
		JLabel lblOrderDetail = new JLabel("Order Detail");
		lblOrderDetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderDetail.setBounds(283, 268, 103, 25);
		contentPane.add(lblOrderDetail);
		
		JButton btnNewButton = new JButton("Pilih");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogPelanggan dialog = new DialogPelanggan(OrderDetailFrame.this);
				dialog.setVisible(true);
				dialog.loadTable();
			}
		});
		btnNewButton.setBounds(143, 98, 130, 25);
		contentPane.add(btnNewButton);
	}
	
}
