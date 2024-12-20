package org.Vaje11;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarEntry;

public class Gui extends JPanel implements Runnable { //difference between "extends" & "implements"

    private BufferedImage floorImage = ImageIO.read(new File("Default size/Ground/ground_06.png"));
    private BufferedImage playerImage = ImageIO.read(new File("Default size/Player/player_05.png"));
    private BufferedImage coinImage = ImageIO.read(new File("Default size/Environment/environment_11.png"));
    private BufferedImage[] portalImages = {
            ImageIO.read(new File("Default size/Environment/environment_01.png")),
            ImageIO.read(new File("Default size/Environment/environment_04.png")),
            ImageIO.read(new File("Default size/Environment/environment_07.png")),
            ImageIO.read(new File("Default size/Environment/environment_09.png")),
            ImageIO.read(new File("Default size/Environment/environment_13.png")),
    };

    public Gui() throws IOException {
        JFrame frame = new JFrame("GAMZE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,836);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        Timer timer = new Timer(16, e -> this.repaint());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int col = 0 ; col < Map.WIDTH ; col++) {
            for (int row = 0; row < Map.HEIGHT; row++) {
                int x = col * 40;
                int y = row * 40;
                g.drawImage(floorImage, x, y, 40, 40, null);
            }
        }

        for (int i = 0; i < Map.portals.size(); i++){
            int x = Map.portals.get(i).getX() * 40;
            int y = Map.portals.get(i).getY() * 40;
            g.drawImage(portalImages[i], x, y, 40, 40, null);
            g.setColor(Color.RED);
            g.drawString(i + "",x ,y);
        }

        for(Location coin : Map.coins){
            int x = coin.getX() * 40;
            int y = coin.getY() * 40;
            g.drawImage(coinImage, x, y, 40, 40, null);
        }

        int x = Map.player.location.getX() * 40;
        int y = Map.player.location.getY() * 40;
        g.drawImage(playerImage, x, y, 40, 40, null);
    }
}
