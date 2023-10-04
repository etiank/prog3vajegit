import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class MojGumb extends JButton implements ActionListener {

    public GUI gui;


    public MojGumb(String text, GUI gui){
        super(text);
        this.addActionListener(this);
        this.gui=gui;

    }

}
