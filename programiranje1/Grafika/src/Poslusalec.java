import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Poslusalec implements ActionListener{

    JButton[][] gumbi;
    JButton zgornjiGumb;

    public Poslusalec(JButton[][] gumbi,JButton zgornjiGumb) {
        this.gumbi = gumbi;
        this.zgornjiGumb=zgornjiGumb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //gumb ki je bil pritisnjen

        JButton gumb = (JButton)e.getSource();//vrne objekt ki je sprožil event
        //izpis koordinat pritisnjenega gumba
        for (int i = 0; i < gumbi.length; i++) {
            for (int j = 0; j < gumbi.length; j++) {
                if (gumb==gumbi[i][j]){
                    System.out.println("Pritisnil si gumb: "+i+","+j);
                }
            }
        }

        if (gumb.getBackground().equals(Color.RED)) {
            gumb.setBackground(Color.CYAN);
        }else {
            gumb.setBackground(Color.RED);
        }



        String tmp=zgornjiGumb.getText();
        int n = Integer.parseInt(tmp);
        n++;
        zgornjiGumb.setText(""+n);


    }
}
