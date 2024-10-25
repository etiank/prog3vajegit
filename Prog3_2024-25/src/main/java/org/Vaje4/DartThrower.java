package org.Vaje4;

import java.awt.*;
import java.util.Random;

public class DartThrower extends Thread{

    private long endTime;
    private GUI gui;
    int hits=0;
    int total=0;

    public DartThrower(long endTime, GUI gui) {
        this.endTime = endTime;
        this.gui = gui;
    }

    @Override
    public void run() {
        Random rand = new Random();

        while (System.currentTimeMillis()<endTime) {

            float x = rand.nextFloat(-1.0f, 1.0f);
            float y = rand.nextFloat(-1.0f, 1.0f);
            //float x = rand.nextFloat()*2-1f; //ce ne obstaja bound operacija
            //float y = rand.nextFloat()*2-1f;
            double xsquared = Math.pow(x, 2);
            double ysquared = Math.pow(y, 2);
            //ker imamo krog radija 1 je sqrt useless ker rabimo samo ali je vsota vecja ali manjsa od 1 ker 1 na kvadrat je 1
            //double disFromCenter = Math.sqrt(xsquared + ysquared);
            double disFromCenter=xsquared+ysquared;

            //Color pointColor;
            if (disFromCenter <=1) {
              //  pointColor = Color.MAGENTA;
                hits++;
            }//else {
                //pointColor = Color.CYAN;
            //}
            total++;

            //gui.drawPoint(x, y, pointColor);
        }


    }

    public int getTotal(){
        return total;
    }
    public int getHits(){
        return hits;
    }

}
