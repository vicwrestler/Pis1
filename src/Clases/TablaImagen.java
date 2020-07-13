
package Clases;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

//Esta clase es para que la tabla pueda integrar las imagenes y el boton 
public class TablaImagen extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
        if(value instanceof Component){
            Component lbl=(Component) value;
            return lbl;
        }
        /*else if(value instanceof JButton){
            JButton btn = (JButton)value;
            return btn;
        }*/
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
