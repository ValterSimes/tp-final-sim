import javax.swing.table.DefaultTableModel;

class Modelo extends DefaultTableModel {

    @Override
    public Class getColumnClass(int columna) {
        if (columna == 3 || columna == 5)
            return String.class;
        return Object.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}