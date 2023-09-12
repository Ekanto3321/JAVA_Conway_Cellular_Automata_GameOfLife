import javax.swing.*;
import java.awt.*;

public class GOL extends JFrame {
    private int w=960,h=1000;
    private double timePerFrame;
    private long lastFrame;

    private double framerate= 30.0;


    public GOL(){
        timePerFrame=1000000000.0/framerate;


        DrawingPanel d = new DrawingPanel();
        d.initialize();
        d.cellAliveR();
        setSize(w,h);
        setTitle("Game of Life");
        add(d);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setBackground(Color.black);
        setVisible(true);

    }
    private void loop() {
        while(true){
            if(System.nanoTime() - lastFrame >= timePerFrame){
                lastFrame=System.nanoTime();
                repaint();
            }
            else{
                //do nothing
            }

        }
    }


    public static void main(String[] args) {

        GOL gol= new GOL();
        gol.loop();


    }


}
