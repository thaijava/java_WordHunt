package beam.game.wordHunt;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame mainWin = new JFrame();

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.setResizable(true);
        mainWin.setTitle("Word Hunt");
        mainWin.setLayout(new BorderLayout());

        GamePanel gamePanel = new GamePanel();
        InfoPanel infoPanel = new InfoPanel();

        mainWin.add(infoPanel, BorderLayout.PAGE_START);
        mainWin.add(gamePanel, BorderLayout.CENTER);


        mainWin.pack();

        mainWin.setLocationRelativeTo(null);
        mainWin.setVisible(true);

        gamePanel.startGameThread();

    }

}
