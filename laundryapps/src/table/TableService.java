package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Service;

public class TableService extends AbstractTableModel {
    private List<Service> serviceList;
    private String[] columnNames = { "ID", "Jenis", "Satuan", "Status", "Harga"};
	

    public TableService(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public int getRowCount() {
        return serviceList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Service service = serviceList.get(rowIndex);
        switch (columnIndex) {
            case 0: return service.getId();
            case 1: return service.getJenis();
            case 2: return service.getSatuan();
            case 3: return service.getStatus();
            case 4: return service.getHarga();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}