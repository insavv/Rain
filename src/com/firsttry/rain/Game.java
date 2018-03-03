
package com.firsttry.rain;

import com.firsttry.rain.entity.mob.Player;
import com.firsttry.rain.graphics.Screen;                 //imports
import com.firsttry.rain.input.Keyboard;
import com.firsttry.rain.level.Level;
import com.firsttry.rain.level.SpawnLevel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{           //extends canvas for frame and stuff
    private static final long serialversionUID=1L;      
    
    public static int width=300;
    public static int height=width/16*9;   // 16:9 for the resoution 
    public static int scale=3;             
    public static String title="Rain";
    
    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Level level;
    private Player player;
    private boolean running=false;
    private Screen screen;
    
    private BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
    private int[] pixels=((DataBufferInt)image.getRaster().getDataBuffer()).getData(); // get data stored in the buffer
    
    public Game(){
        
        
        Dimension size = new Dimension(width*scale,height*scale);       //dimension for our window
        setPreferredSize(size);
        screen= new Screen(width,height);
        frame=new JFrame();
        key = new Keyboard();
        level = new SpawnLevel("/texture/levels/level.png");
        player = new Player(key);
        
        
        addKeyListener(key);
    }
    
    public synchronized void start(){ //syncronizing thread so it any other thread running wont interfere with it
        running=true;
        thread = new Thread(this,"Display"); // passing current thread object as parameter 
        thread.start();  // starting thread
    }
    public synchronized void stop(){
        running=false;          //setting running== false so we can terminate our game loop and stop game running
    try {
        thread.join();          //end this thread
    }
     catch(InterruptedException e){
         e.printStackTrace();
    }
    }

   
    public void run() {
        long lastTime = System.nanoTime();      // current system time in nanosecond(10^9) 
        long timer=System.currentTimeMillis();  // getting current time in millisecond
        final double ns = 1000000000.0/60.0;    /* number of times we want to update our screen per second
                                                (i.e we divide one second in nanosecond by numeber of times we want to update )*/
        
        double delta = 0;   //store difference of time between last update and current time
        int frames = 0;     // to store frames per second
        int updates = 0;    // to store updates per second
        requestFocus();
        while(running){
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;   //so we can calculate time for an update cycle
            lastTime=now;
            while(delta>=1){    //to update our game state by a finite number of times
                update();       //call update method
                updates++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis() - timer>1000){        //so that ups and fps would only be printed per second
                timer+=1000;    //to make up for the time passed and so that above condition works properly      `
                System.out.println(updates + "ups, " + frames + "fps");
                frame.setTitle(title +"    " + updates +"ups, " + frames + "fps");
                updates=0;
                frames=0;
            }
        }
        stop();
    }
    
   
    public void update(){       //method to update our game loop. all changes you want to make to game loop goes here
        key.update();
        player.update();
    }
    
    public void render(){                               //method to render stuff on frame
        BufferStrategy bs = getBufferStrategy();        //getting a bufferstrategy object which buffers our image before rendering it
        if(bs==null){
            createBufferStrategy(3);                    //creating a lvl 3 bufferstrategy (i.e think pipelining)
            return;
        }
        
        screen.clear();
        int xScroll = player.x - screen.width/2;
        int yScroll = player.y - screen.height/2;
        level.render(xScroll, yScroll, screen);
        player.render(screen);
       
        for(int i=0;i<pixels.length;i++){
            pixels[i]=screen.pixels[i];                 //coping image render in screen class to this buffer
        }
        
        Graphics g = bs.getDrawGraphics();              //basic class required to draw stuff on/off screen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(),getHeight());
        g.drawImage(image, 0, 0, getWidth(),getHeight(),null);
        g.dispose();                                    //dispose all resources in use to clearup memory
        bs.show();                                      //release buffer
    }
    
    public static void main(String[] arg){
        Game game=new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(Game.title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        game.start();
    }
}
