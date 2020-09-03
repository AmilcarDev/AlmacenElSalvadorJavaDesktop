package Clases;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Baltazar
 */
public class lista_rendere extends JLabel implements ListCellRenderer {

    final static ImageIcon gg = new ImageIcon("Agregar.png");
    ImageIcon img;
    public void lista_rendere(ImageIcon img) {
    this.img=img;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String valor = value.toString();
        setText(valor);
        
            setIcon(img);
        
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }

}
