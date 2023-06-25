package beam.game.wordHunt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.BinaryOperator;

public class KeyHandler implements KeyListener {
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
            upPressed = true;
        if(code == KeyEvent.VK_S)
            downPressed = true;
        if(code == KeyEvent.VK_D)
            rightPressed = true;
        if(code == KeyEvent.VK_A)
            leftPressed = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
            upPressed = false;
        if(code == KeyEvent.VK_S)
            downPressed = false;
        if(code == KeyEvent.VK_D)
            rightPressed = false;
        if(code == KeyEvent.VK_A)
            leftPressed = false;


    }
}
