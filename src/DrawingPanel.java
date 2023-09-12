import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawingPanel extends JPanel {

    private long lastTime;
    private int frames;
    public int f=0;
    private int it=240, size=4, arr=it*it, st=4500;

    public cell[] c = new cell[arr];
    public DrawingPanel(){

    }
    public void paintComponent(Graphics g){

        g.setColor(Color.white);

//        f++;
//        if(f%100==0)cellAliveR();
//        cellAliveR();
        countNeighbours();
        updateNeighbours();
        countNeighboursDown();
//        pretty();
        int ind=0;
        for(int i=0;i<it;i++){
            for(int j=0;j<it;j++){

                if(c[ind].alive==1){
                    g.fillRect(c[ind].x,c[ind].y,size,size);
                }
                ind++;
            }
        }


//        for(int i=0;i<=640;i+=16){
//            g.drawLine(i,0,i,640);
//        }
//        for(int i=0;i<=640;i+=16){
//            g.drawLine(0,i,640,i);
//        }
        callfps();

    }

    public void initialize(){
        int ind=0;
        for(int i=0;i<it;i++){
            for(int j=0;j<it;j++){
                c[ind]=new cell();
                c[ind].x=j*size;
                c[ind].y=i*size;
                c[ind].neighbours=0;
                c[ind].alive=0;
                ind++;
            }
        }



    }
    private void callfps() {
        frames++;
        if(System.currentTimeMillis()-lastTime>=1000){
            System.out.println("FPS: "+frames);
            frames=0;
            lastTime=System.currentTimeMillis();
        }
    }

    public void countNeighboursDown(){
        for(int i=it+1;i<arr-it-1;i++) {

            if (c[i + 1].alive == 0&&c[i].neighbours>0)c[i].neighbours--;

            if (c[i - 1].alive == 0&&c[i].neighbours>0)c[i].neighbours--;

            if (c[i + it].alive == 0&&c[i].neighbours>0)c[i].neighbours--;
            if (c[i + it+1].alive == 0&&c[i].neighbours>0)c[i].neighbours--;
            if (c[i + it-1].alive == 0&&c[i].neighbours>0)c[i].neighbours--;

            if (c[i - it].alive == 0&&c[i].neighbours>0)c[i].neighbours--;
            if (c[i - it+1].alive == 0&&c[i].neighbours>0)c[i].neighbours--;
            if (c[i - it-1].alive == 0&&c[i].neighbours>0)c[i].neighbours--;

        }
    }
    public void countNeighbours(){
        for(int i=it+1;i<arr-it-1;i++) {

            if (c[i + 1].alive == 1&&c[i].neighbours<4)c[i].neighbours++;

            if (c[i - 1].alive == 1&&c[i].neighbours<4)c[i].neighbours++;

            if (c[i + it].alive == 1&&c[i].neighbours<4)c[i].neighbours++;
            if (c[i + it+1].alive == 1&&c[i].neighbours<4)c[i].neighbours++;
            if (c[i + it-1].alive == 1&&c[i].neighbours<4)c[i].neighbours++;

            if (c[i - it].alive == 1&&c[i].neighbours<4)c[i].neighbours++;
            if (c[i - it+1].alive == 1&&c[i].neighbours<4)c[i].neighbours++;
            if (c[i - it-1].alive == 1&&c[i].neighbours<4)c[i].neighbours++;

        }
    }

    public void updateNeighbours(){
        for(int i=it;i<arr-it;i++) {

            if(c[i].alive==1) {
                if (c[i].neighbours < 2) c[i].alive = 0;
                if (c[i].neighbours > 2 && c[i].neighbours < 3) c[i].alive = 1;
                if ( c[i].neighbours > 3) c[i].alive = 0;
            }
            if (c[i].alive == 0 && c[i].neighbours == 3) c[i].alive = 1;

        }
    }

    public void pretty(){
        for(int i=it;i<arr-it;i++) {

            if (c[i].alive == 1)c[i+1].alive=1;
            if (c[i].alive == 1)c[i-1].alive=1;
            if (c[i].alive == 1)c[i+it].alive=1;
            if (c[i].alive == 1)c[i-it].alive=1;
        }
    }
    public void cellAliveR(){
        Random random = new Random();
        for(int i=0; i<st;i++){
            int ind = (random.nextInt(arr-it)+it);
            c[ind].alive=1;
        }



    }

}
