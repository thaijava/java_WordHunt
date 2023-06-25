package beam.game.wordHunt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {
    int x;
    int y;
    int speed = 3;
    Color color = Color.white;

    int sizeX = 50, sizeY = 50;

    BufferedImage selfImage;

    public Player(int x, int y, int sizeX, int sizeY) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        try {
            selfImage = ImageIO.read(this.getClass().getResourceAsStream("/asset/redcar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveLeft() {
        x -=  speed;

    }

    public void moveRight() {
        x += speed;
    }

    public void moveUp() {
        y -= speed;

    }

    public void moveDown() {
        y += speed;

    }

    void paint(Graphics g) {

        g.setColor(color);
        g.drawImage(selfImage, x, y, sizeX, sizeY, null);
    }
}
