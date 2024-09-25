package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Customer;

public class TableCustomer extends AbstractTableModel {
    private List<Customer> customerList;
    private String[] columnNames = { "ID", "Name", "Alamat", "NoHP" };
	

    public TableCustomer(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public int getRowCount() {
        return customerList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = customerList.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getId();
            case 1: return customer.getNama();
            case 2: return customer.getAlamat();
            case 3: return customer.getNoHP();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}