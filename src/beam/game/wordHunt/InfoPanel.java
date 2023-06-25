package beam.game.wordHunt;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    Label scoreLabel = new Label("SCORE: 9999           TIME: 999");
    Label vocabLable = new Label("WORD ?:  MANIFEST");
    public InfoPanel() {
        scoreLabel.setBackground(Color.white);
        scoreLabel.setForeground(Color.black);
        vocabLable.setBackground(Color.white);
        vocabLable.setForeground(Color.black);
        this.setLayout(new GridLayout(2,1));
        this.add(scoreLabel);
        this.add(vocabLable);

    }
}
