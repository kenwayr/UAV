import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Controls visual layout and interface. Links controller and other functions to 
 * User display.
 */
public class View{
    JFrame mainFrame;
    Controller ctrl;
    
    JLabel lb;
    View(){
        lb = new JLabel("Keyboard Event Display", SwingConstants.CENTER);
        lb.setSize(50,100);
        mainFrame = new JFrame("UAV Controls");
        ctrl = new KeyboardController();
        mainFrame.addKeyListener(ctrl);
        mainFrame.add(lb);
        mainFrame.setSize(400,400);
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.blue);
    }
    public static void main (String[] args){
        View view = new View();
        while(!view.ctrl.exitFlag){
            if(view.ctrl.goingUp){
                view.lb.setText("<html><span style='color:#8c00b7;'>"+"Going Forward"+"</span><br/>Press ESC to quit</html>");
            }
            else if(view.ctrl.goingDown){
                view.lb.setText("<html><span style='color:#ff402b;'>"+"Going Backward"+"</span><br/>Press ESC to quit</html>");
            }
            else if(view.ctrl.goingLeft){
                view.lb.setText("<html><span style='color:#019dc4;'>"+"Going Left"+"</span><br/>Press ESC to quit</html>");
            }
            else if(view.ctrl.goingRight){
                view.lb.setText("<html><span style='color:#019dc4;'>"+"Going Right"+"</span><br/>Press ESC to quit</html>");
            }
            else if(view.ctrl.goingAbove){
                view.lb.setText("<html><span style='color:#ff9000;'>"+"Going Up"+"</span><br/>Press ESC to quit</html>");
            }
            else if(view.ctrl.goingBelow){
                view.lb.setText("<html><span style='color:#78c103;'>"+"Going Down"+"</span><br/>Press ESC to quit</html>");
            }
            else{
                view.lb.setText("<html>"+"Waiting for instructions"+"<br/>Press ESC to quit</html>");
            }
        }
        
        
        view.mainFrame.dispatchEvent(new WindowEvent(view.mainFrame, WindowEvent.WINDOW_CLOSING));
    }
}