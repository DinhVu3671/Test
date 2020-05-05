import display.Display;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.management.BufferPoolMXBean;

public class Game implements Runnable{
    private Display display;

    public int with, height;
    public String title;
    private boolean running = false;
    private Thread thread;


    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage testImage;

    public Game(String title,int with,int height){
        this.with = with;
        this.height = height;
        this.title = title;

    }
    private void init(){
        display = new Display(title, with, height);
        testImage = ImageLoader.loadImage("/textures/test.png");

    }
    private void tick(){

    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // clear screen
        g.clearRect(0,0,with,height);
        //Draw Here
        g.drawImage(testImage, 20, 20, null);
       // g.fillRect(0,0,20,20);

        //end here

        g.dispose();
        bs.show();
    }

    public void run(){

        init();

        while (running){
            tick();
            render();
        }
        stop();
    }
    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if (running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
