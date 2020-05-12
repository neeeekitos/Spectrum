import javax.swing.*;
import java.util.ArrayList;

/** Hérite de ListModel et définit le modèle pour les messages
 * @author Roman HOCHHAUSEN
 */
public class MessageListModel extends AbstractListModel<ListItem> {

    ArrayList<ListItem> list=new ArrayList<>();

    /** Getter de la taille de la liste
     * @return size int
     */
    public int getSize() {
        return list.size();
    }

    /** Retourne un élément à la position donnée
     * @param index position
     * @return listeItem l'élément de la liste
     */
    public ListItem getElementAt(int index) {
        return list.get(index);
    }

    /** Ajoute un élément dans la liste (le message dans notre cas)
     * @param index position
     * @param item l'élément de la liste
     */
    public void add(int index, ListItem item) {
        list.add(index, item);
        fireIntervalAdded(this, index, index);
    }
}