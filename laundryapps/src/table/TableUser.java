package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.user;

public class TableUser extends AbstractTableModel {
    private List<user> userList;
    private String[] columnNames = { "ID", "Name", "Username", "Password" };

    public TableUser(List<user> userList) {
        this.userList = userList;
    }

    @Override
    public int getRowCount() {
        return userList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        user user = userList.get(rowIndex);
        switch (columnIndex) {
            case 0: return user.getId();
            case 1: return user.getNama();
            case 2: return user.getUsername();
            case 3: return user.getPassword();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}