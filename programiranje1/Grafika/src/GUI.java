import java.awt.*;
import javax.swing.*;

public class GUI {

    public static void main(String[] args) {

        JFrame okno = new JFrame();                              //class iz javax.swing za izris okna
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //ustavi program ko kliknemo X
        okno.setSize(800,600);                      //nastavi velikost
        okno.setTitle("Novo okno");                              //nastavimo ime okna

        JButton zgornjiGumb = new JButton("0");

        okno.add(zgornjiGumb,BorderLayout.NORTH);

        JPanel panel = new JPanel();

        JButton[][] gumbi = new JButton[9][9];//grid gumbov

        Poslusalec p = new Poslusalec(gumbi,zgornjiGumb);

        //JPanel je container za grupirati razne komponente
        panel.setLayout(new GridLayout(9,9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                gumbi[i][j]=new JButton("0");
                gumbi[i][j].setBackground(Color.RED);
                gumbi[i][j].addActionListener(p);//dodamo poslusalec
                panel.add(gumbi[i][j]);
            }
        }
        okno.add(panel);
        okno.setVisible(true);
    }
}


/*JButton gumb = new JButton("Moj prvi gumb");
        okno.add(gumb,BorderLayout.NORTH);
        //privzeta postavitev v JFrame je BorderLayout, ki ima 5 pozicij:
        //NORD,SOUTH,WEST,EAST,CENTER
        JButton gumbS = new JButton("Gumb spodaj");
        okno.add(gumbS,BorderLayout.SOUTH);

        JButton gumbD = new JButton("Gumb Desno");
        okno.add(gumbD,BorderLayout.EAST);

        JButton gumbGor = new JButton("Gumb zgoraj");
        okno.add(gumbGor,BorderLayout.NORTH);*/


/*
//default layout JPanela je FlowLayout
        panel.setLayout(new FlowLayout());
                JButton gumb1 = new JButton("Gumb1");
                JButton gumb2 = new JButton("Gumb2");

                //sprememba barve ozadja
                gumb1.setBackground(Color.CYAN);
                gumb2.setBackground(new Color(255,0,180));

                //sprememba barve napisa
                gumb1.setForeground(Color.RED);
                gumb2.setForeground(Color.ORANGE);

                panel.add(gumb1);
                panel.add(gumb2);

                okno.add(panel);

                okno.setVisible(true);//nastavi vidljivost

                //1D polje (array)
                int[] polje1D ={1,2,3};
                System.out.println(polje1D[2]);

                //2D polje (array)
                int[][] polje2D ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
                };
                System.out.println(polje2D[0][2]);*/
