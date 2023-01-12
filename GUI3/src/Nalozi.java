import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.*;

public class Nalozi extends MojGumb{



    public Nalozi(GUI gui){
        super("Nalozi",gui);
    }









    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text fajli","txt");
        chooser.setFileFilter(filter);
        int ret = chooser.showOpenDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());

            try{
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                if (! line.equals("Numbers")) {
                    throw new Exception("Wrong file!");
                }
                line = reader.readLine();
                gui.getContentPane().removeAll();
                gui.constructGUI(line.split(" "));


            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
