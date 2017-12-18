package swing;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ButtonAction extends AbstractAction {
    public ButtonAction(String name) {
        super(name);
    }

    public ButtonAction(String name, Icon icon) {
        super(name, icon);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("action clicked");

    }
}
