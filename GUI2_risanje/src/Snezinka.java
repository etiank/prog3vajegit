import java.awt.*;
import java.awt.geom.AffineTransform;

public class Snezinka {

    float x;
    float y;
    int hitrost;
    int velikost;
    float delta;
    float offsetRotacije;
    float korakRotacije;
    float stevec;


    public Snezinka(float x, float y, int hitrost, int velikost,float delta,float offsetRotacije,float korakRotacije,float stevec) {
        this.x = x;
        this.y = y;
        this.hitrost = hitrost;
        this.velikost = velikost;
        this.delta=delta;
        this.offsetRotacije=offsetRotacije;
        this.korakRotacije=korakRotacije;
        this.stevec=stevec;
    }

    public void padaj(){
        this.y+=velikost/2;
        if (this.y > 600) {
            this.y=-10;
        }
        float delta=(float)Math.cos(stevec+this.velikost);
        this.x+=delta;

        if (delta > 0) {
            offsetRotacije+=korakRotacije+delta;
        }else {
            offsetRotacije-=korakRotacije+delta;
        }

    }

    public void narisi(Graphics g){
        int details=8;
        double kot =Math.toRadians(360/details);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.CYAN);
        g2D.setStroke(new BasicStroke(2));
        AffineTransform old = g2D.getTransform();
        g2D.rotate(offsetRotacije,x,y);


        for (int i = 0; i < details; i++) {
            g2D.rotate(kot,this.x,this.y);
            g2D.drawLine((int)x,(int)y,(int)x+velikost,(int) y+velikost);
        }

        g2D.setTransform(old);
        }

    }

