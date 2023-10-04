import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Sneg extends JFrame {

        public Snezinka[] snezinke =new Snezinka[100];

        public Sneg() {

            Random r = new Random();

            for (int i = 0; i < snezinke.length; i++) {
                int velikost = r.nextInt(10)+1;//vrednost od 1 do 10
                snezinke[i]= new Snezinka(r.nextInt(800),r.nextInt(600),velikost,velikost,(float)velikost,5f,5f,0f);
            }

            JPanel p = new JPanel(){
                //Overriding metode printComponent
                protected void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.fillRect(0,0,this.getWidth(),this.getHeight());
                    g.setColor(Color.BLACK);//background
                    for (int i = 0; i < snezinke.length; i++) {
                        snezinke[i].padaj();
                        snezinke[i].narisi(g);
                    }

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    super.repaint();
                }
            };

            add(p);
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);


        }

        public static void main(String[] args) {
            Sneg snezi = new Sneg();


        }
    }
