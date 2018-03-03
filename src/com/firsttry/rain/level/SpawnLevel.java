
package com.firsttry.rain.level;

import com.firsttry.rain.graphics.Sprite;
import com.firsttry.rain.level.tile.GrassTile;
import com.firsttry.rain.level.tile.Tile;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SpawnLevel extends Level {

    
   
   
    
    public SpawnLevel(String path) {
        super(path);        
    }
    
     protected void loadLevel(String path){
         try{
             BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
             int w = width = image.getWidth();
             int h = height = image.getHeight();
             tiles = new int [w * h];
             image.getRGB(0, 0, w, h, tiles, 0 , w);
         }catch(IOException e){
             System.out.println(" Exception! Could not load level file!");
         }
    }
     
     
     // Grass = 0x4B7F39
     // Flower = 0xFFF87A
     // Rock = 0x919191
     protected void generateLevel(){
         
     }
}
