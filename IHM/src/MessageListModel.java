import javax.swing.*;
import java.util.ArrayList;

public class MessageListModel extends AbstractListModel<ListItem> {

    ArrayList<ListItem> list=new ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public ListItem getElementAt(int index) {
        return list.get(index);
    }

    // if you need such updates:
    public void add(int index, ListItem item) {
        list.add(index, item);
        fireIntervalAdded(this, index, index);
    }

    public boolean remove(ListItem i) {
        int index = list.indexOf(i);
        if(index<0) return false;
        remove(index);
        return true;
    }

    public void remove(int index) {
        list.remove(index);
        fireIntervalRemoved(this, index, index);
    }
}