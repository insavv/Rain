package com.firsttry.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SpriteSheet {
    private String path;
    public final int SIZE;
    public int[] pixels;
    
    public static SpriteSheet tiles = new SpriteSheet("/texture/tiles/spritesheet.png", 256);
     public static SpriteSheet playerTile = new SpriteSheet("/texture/mobs/player.png", 256);
    
    public SpriteSheet(String path, int size){
        this.path = path;
        this.SIZE = size;
        pixels = new int[SIZE*SIZE];
        load();
    }
    
    private void load(){
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
