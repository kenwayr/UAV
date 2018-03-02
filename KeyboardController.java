import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

/**
 * Abstraction of Controller for any device
 */
abstract class Controller implements ActionListener, KeyListener{
    boolean exitFlag = false;
    boolean goingUp = false;
    boolean goingDown = false;
    boolean goingLeft = false;
    boolean goingRight = false;
    boolean goingAbove = false;
    boolean goingBelow = false;
    abstract void onKeyTyped(KeyEvent e);
    abstract void onKeyPressed(KeyEvent e);
    abstract void onKeyReleased(KeyEvent e);
    abstract void onActionPerformed(ActionEvent e);
    public void keyTyped(KeyEvent e){
        onKeyTyped(e);
    }
    public void keyPressed(KeyEvent e){
        onKeyPressed(e);
    }
    public void keyReleased(KeyEvent e){
        onKeyReleased(e);
    }
    public void actionPerformed(ActionEvent e){
        onActionPerformed(e);
    }
    public void close(){
        exitFlag = true;
    }
}

/**
 * Keyboard Controller Bindings
 */
public class KeyboardController extends Controller{
    Interface Inf;
    KeyboardController(){
         Inf = new Interface();
    }
    void onKeyTyped(KeyEvent e){
        
    }
    void onKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            arrowUp(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            arrowDown(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            arrowLeft(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            arrowRight(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_Q){
            ascend(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_E){
            descend(true);
        }
    }
    void onKeyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            arrowUp(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            arrowDown(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            arrowLeft(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            arrowRight(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_Q){
            ascend(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_E){
            descend(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.close();
        }
    }
    void onActionPerformed(ActionEvent e){
        
    }
    
    void arrowUp(boolean state){
        String response = Inf.send("UP-"+state);
        this.goingUp = state;
    }
    void arrowDown(boolean state){
        String response = Inf.send("DOWN-"+state);
        this.goingDown = state;
    }
    void arrowLeft(boolean state){
        String response = Inf.send("LEFT-"+state);
        this.goingLeft = state;
    }
    void arrowRight(boolean state){
        String response = Inf.send("RIGHT-"+state);
        this.goingRight = state;
    }
    void ascend(boolean state){
        String response = Inf.send("ASCEND-"+state);
        this.goingAbove = state;
    }
    void descend(boolean state){
        String response = Inf.send("DESCEND-"+state);
        this.goingBelow = state;
    }
    
    public static void main (String[] args){
        Controller kc = new KeyboardController();
        while(true){
            if(!kc.exitFlag)
                continue;
            else
                break;
        }
    }
}