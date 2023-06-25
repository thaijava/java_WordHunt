package beam.game.wordHunt;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel  implements Runnable{

    int orgTileSize = 16; // base from 16x16 pixel
    int scale = 3;
    int tileSize = orgTileSize * scale;

    int screenWidth = GameModel.GameCol * tileSize; // cal panal width
    int screenHeight = GameModel.GameRow * tileSize;


    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    Player playerA = new Player(0, 0, tileSize, tileSize);

    Label charLabel[];


    public GamePanel(){
        this.setLayout(null);

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);


        String huntWord = "MANIFEST";
        charLabel = new Label[huntWord.length()];
        Random ran = new Random();
        for(int i=0; i< huntWord.length(); i++) {
            charLabel[i] = new Label(huntWord.substring(i, i+1));
            charLabel[i].setBackground(Color.white);
            charLabel[i].setForeground(Color.MAGENTA);
            int x = ran.nextInt(GameModel.GameCol) * tileSize;
            int y = ran.nextInt(GameModel.GameRow) * tileSize;

            charLabel[i].setLocation(x, y);
            charLabel[i].setSize(new Dimension(13, 20));
            this.add(charLabel[i]);

        }

        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double targetTime = 1000000000.0 / 60; // FPS
        double startTime;
        double oneFrameTime;
        double remainSleepTime;

        while (gameThread != null) {
            startTime = System.nanoTime();

            update();
            repaint();

            oneFrameTime = System.nanoTime() - startTime;

            if (oneFrameTime < targetTime ) {
                remainSleepTime = (targetTime - oneFrameTime) / 1000000;

                try {
                    Thread.sleep((long) remainSleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public void update() {
        if(keyHandler.upPressed)
            playerA.moveUp();
        else if(keyHandler.downPressed)
            playerA.moveDown();
        else if(keyHandler.leftPressed)
            playerA.moveLeft();
        else if (keyHandler.rightPressed)
            playerA.moveRight();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        playerA.paint(g);

    }

}
