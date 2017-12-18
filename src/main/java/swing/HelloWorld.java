package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HelloWorld extends JFrame {
    private JTextField text;
    private JTextArea textarea;

    public static void main(String[] args) {
        new HelloWorld();
    }

    public HelloWorld() throws HeadlessException {
        super();

        setTitle("Hello world");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(Color.GREEN);
        //setSize(500,400);
        setPreferredSize(new Dimension(500,400));
        addComponent(getContentPane());
        pack();

        setVisible(true);
    }

    private void addComponent(Container contentPane) {
        final DefaultListModel model = new DefaultListModel();
        contentPane.setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        jp.setBackground(Color.BLUE);
        contentPane.add(jp, BorderLayout.NORTH);
        final ButtonAction action = new ButtonAction("Click me!");
        JButton button = new JButton(action);
          text = new JTextField("Hello");
        contentPane.add(button,BorderLayout.WEST);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked...");
                textarea.setText(text.getText());
                textarea.setBackground(Color.YELLOW);
                model.addElement("Four");
            }
        });

        contentPane.add(text,BorderLayout.SOUTH);
         textarea = new JTextArea("Hello World :)");
        contentPane.add(textarea,BorderLayout.CENTER);
        textarea.addPropertyChangeListener("background", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(String.format("Old: %s, New: %s", evt.getOldValue(), evt.getNewValue()));
                action.setEnabled(false);
            }

        });


        JList list = new JList();
        list.setPreferredSize(new Dimension(100,100));
        contentPane.add(list,BorderLayout.EAST);


        list.setModel(model);
        model.addElement("One");
        model.addElement("Two");
        model.addElement("Three");
    }
}
