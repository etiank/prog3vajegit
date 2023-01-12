import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Shrani extends MojGumb {


    public Shrani(GUI gui) {
        super("Shrani", gui);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        System.out.println(buttonsString());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text fajli","txt");
        chooser.setFileFilter(filter);
        int ret = chooser.showSaveDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());

            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("Numbers");
                writer.newLine();
                writer.write(buttonsString());
                writer.close();
                System.out.println("Shranjeno");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public String buttonsString() {
        Component[] komponente = gui.vsebina.getComponents();
        String res = "";
        for (Component k : komponente) {//for each
            res += ((JButton) k).getText() + " ";
        }
        return res;
    }


}
