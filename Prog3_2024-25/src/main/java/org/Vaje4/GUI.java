package org.Vaje4;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private JFrame frame;
    private JPanel panel;
    private static final int FRAMEWIDTH = 800;
    private static final int FRAMEHEIGHT = 800;

    public GUI() {
        frame = new JFrame("CALCULATING PI");
        panel = new JPanel();

        frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.setVisible(true);

    }

    public void drawPoint(float x, float y, Color color) {
        Graphics2D gfx = (Graphics2D) panel.getGraphics();
        gfx.setColor(color);
        int translatedX= (int) ((FRAMEWIDTH/2) *x)+FRAMEWIDTH/2;
        int translatedY= (int) ((FRAMEHEIGHT/2) *y)+FRAMEHEIGHT/2;

        gfx.fillOval(translatedX,translatedY,10,10);

    }

    public void close(){
        frame.dispose();
    }


}
