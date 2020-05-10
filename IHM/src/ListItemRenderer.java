import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

public class ListItemRenderer implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Component component = (Component) value;

        if (isSelected) {
            System.out.println(index);
        }

        return component;
    }

    public static void main(String[] args){

        ListItem temp1 = new ListItem("coucou", true);
        ListItem temp2 = new ListItem("yooooooooo",false);
        ArrayList<ListItem> addedItems = new ArrayList<>();
        for (int i = 0; i<26; i++) {
            addedItems.add(Math.random()>0.5 ? temp1 : temp2);
        }

        JList<ListItem> list = new JList(addedItems.toArray());

        list.setCellRenderer(new ListItemRenderer());
        JScrollPane scroll1 = new JScrollPane(list);

        JFrame frame = new JFrame();
        frame.getContentPane().add(scroll1);
        frame.pack();
        frame.setPreferredSize(new Dimension(690, 800));
        frame.setMaximumSize(new Dimension(690, 800));
        frame.setMinimumSize(new Dimension(690, 800));
        frame.setVisible(true);
    }
}

