import java.awt.event.ActionEvent;

public class Zbrisi extends MojGumb{

    public Zbrisi(GUI gui) {
        super("Zbrisi",gui);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gui.getContentPane().removeAll();//zbrise vse komponente z okna
        gui.constructGUI(null);
    }
}
