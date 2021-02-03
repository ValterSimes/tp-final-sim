import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class Render extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta = new JLabel();
        etiqueta.setBackground(super.getBackground());
        etiqueta.setText(String.valueOf(value));

        if (value instanceof String) {
            etiqueta.setBackground(Color.YELLOW);
            etiqueta.setOpaque(true);
            if (isSelected)
                etiqueta.setBackground(Color.GREEN);
        }
        return etiqueta;
    }
}