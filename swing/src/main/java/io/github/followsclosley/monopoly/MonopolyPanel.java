package io.github.followsclosley.monopoly;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MonopolyPanel extends JPanel {

        protected final Dimension DEFAULT_MINIMUM_SIZE = new Dimension(700, 700);

    public MonopolyPanel() throws IOException {
    }


    @Override
        public Dimension getPreferredSize() {
            return DEFAULT_MINIMUM_SIZE;
        }
//center
    final Image image = ImageIO.read(new File("swing/src/main/resources/Background.jpg")).getScaledInstance(DEFAULT_MINIMUM_SIZE.height, DEFAULT_MINIMUM_SIZE.height, Image.SCALE_SMOOTH);

    @Override
    public void paint(Graphics g) {//1500 1500
        g.drawImage(image, 0, 0, null);

//        piece
        g.fillRoundRect(20,20,20,20,20,20);
        g.fillRoundRect(100,20,20,20,20,20);
    }

        public void xpaint(Graphics g) {

//            Background
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, DEFAULT_MINIMUM_SIZE.width, DEFAULT_MINIMUM_SIZE.height);


/*           Lines

            Draw the horizontal lines on the board.     (-----------)*/

            g.setColor(Color.GRAY);
            g.fillRect(0, 100, 200, 5);
            g.setColor(Color.BLUE);
            g.fillRect(0, 400, 200, 5);

            /*Extrudes 2nd top line*/
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 150, 200, 5);
            /*Line at bottom for price TODO:delete after we add price*/
//TODO:            DARK GREEN AREA IS PRICE AREA
            g.setColor(Color.GREEN.darker());
            g.fillRect(0, 400-20, 200, 5);
            g.setColor(Color.GREEN.darker());
            g.fillRect(0, 400-60, 200, 5);


            /*
            Draw the vertical lines on the board.
            ( |
              | )*/
            g.setColor(Color.BLACK);
            g.fillRect(0, 100, 5, 305);
            g.setColor(Color.GREEN);
            g.fillRect(200, 100, 5, 305);

        }
}
