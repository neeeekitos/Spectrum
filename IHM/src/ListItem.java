import com.sun.deploy.panel.JSmartTextArea;
import javafx.scene.layout.BackgroundFill;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.text.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class ListItem extends JPanel {

    private static final long serialVersionUID = 1L;
    public RoundJTextArea  textArea;
    private String text;
    private boolean myMessage;

    public ListItem(String text, boolean myMessage) {
        this.setLayout(new BorderLayout());
        this.text = text;
        this.myMessage = myMessage;

        //Create a text area.
        textArea = new RoundJTextArea();
        textArea.setText(text);
        textArea.setFont(new Font("Sans", Font.LAYOUT_LEFT_TO_RIGHT, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        areaScrollPane.setBorder(null);

        areaScrollPane.setPreferredSize(new Dimension(400, getContentHeight(text)));
        if (myMessage) {
            add(areaScrollPane, BorderLayout.LINE_END);
            textArea.setBackground(new Color(224, 203, 222));
        } else {
            add(areaScrollPane, BorderLayout.LINE_START);
            textArea.setBackground(new Color(237, 246, 249));
        }

        textArea.setBorder(BorderFactory.createEmptyBorder(11, 10, 12, 10));

        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public static int getContentHeight(String content) {
        JEditorPane dummyEditorPane=new JEditorPane();
        dummyEditorPane.setSize(400,Short.MAX_VALUE);
        dummyEditorPane.setFont(new Font("Sans", Font.LAYOUT_LEFT_TO_RIGHT, 12));
        dummyEditorPane.setText(content);

        return dummyEditorPane.getPreferredSize().height + 23; //23 = external margin in pixels
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.getContentPane().add(new ListItem("Lorem Ipsum is simply remaining essentially sum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        true));
        frame.pack();
        frame.setVisible(true);
        frame.setSize(690,800);
    }
}

class RoundJTextArea extends JTextArea {
    private Shape shape;
    public RoundJTextArea() {
        super();
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}

