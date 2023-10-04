import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JPanel vsebina;

    public GUI() {
        constructGUI(null);
    }

    public void constructGUI(String[] tokens) {
        //nastavimo okno
        this.setTitle("Numbers");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setVisible(true);

        //vsebina
        vsebina = new JPanel();
        if (tokens != null) {
            for (String s : tokens) {
                vsebina.add(new JButton(s));
            }
        }
        //menu
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1, 4));

        //ustvarimo gumbe na menuju
        JButton shrani = new Shrani(this);
        JButton nalozi = new Nalozi(this);
        JButton zbrisi = new Zbrisi(this);
        JTextField vnosnoPolje = new VnosnoPolje(this);
        //dodamo komponente na menu
        menu.add(shrani);
        menu.add(nalozi);
        menu.add(zbrisi);
        menu.add(vnosnoPolje);

        //prilepimo vsebino in menu na okno
        this.add(vsebina);
        this.add(menu, BorderLayout.SOUTH);

        //refreshaj prikaz okna
        this.revalidate();

    }


    public static void main(String[] args) {
        GUI gui = new GUI();
    }

}
