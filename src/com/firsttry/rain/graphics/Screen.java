package com.firsttry.rain.graphics;

import com.firsttry.rain.entity.mob.Player;
import com.firsttry.rain.level.tile.Tile;
import java.util.Random;

 public class Screen {

    public int width,height;
    public int[] pixels;
    public final int MAP_SIZE=64;                           //no of pixel in tile  
    public final int MAP_SIZE_MASK=MAP_SIZE - 1;            //because array starts from zero
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];      //mapsize i.e 64*64 tiles map  
 
    
    public int xOffset, yOffset;                            //offset for player movement
    
    private Random random = new Random();
    
    public Screen(int width,int height){
        this.width=width;
        this.height=height;
        pixels=new int[width*height];                       //array to use in render method
        
      
    }
    
    public void clear(){
        for(int i=0;i<pixels.length;i++){
            pixels[i]=0;
        }
    }

    
    public void renderTile(int xp, int yp,Tile tile){
        
        xp -= xOffset;
        yp -= yOffset;
        
        for (int y=0; y < tile.sprite.SIZE; y++){
            int ya = y + yp;
             for (int x=0; x < tile.sprite.SIZE; x++){
                 int xa = x + xp;
                 if(xa < -tile.sprite.SIZE || xa >= width|| ya <0 || ya >= height) break;
                 if (xa < 0) xa = 0;
                 pixels[xa + ya*width] = tile.sprite.pixels[x + y*tile.sprite.SIZE];
             }
        
        }

    }
    
    public void renderPlayer(int xp, int yp, Sprite sprite, int flip){
       xp -= xOffset;
        yp -= yOffset;
        
        for (int y=0; y < 16; y++){
            int ya = y + yp;
            int ys = y;
            if (flip == 2 || flip == 3)  ys = 15 - y;
             for (int x=0; x < 16; x++){
                 int color;
                 int xa = x + xp;
                 int xs = x;
                 if (flip == 1 || flip == 3) xs = 15 - x;
                 if(xa < -16 || xa >= width|| ya <0 || ya >= height) break;
                 if (xa < 0) xa = 0;
                 int col = sprite.pixels[xs + ys * 16];
                 if( col != 0xFFFF23F0 ){
                    pixels[xa + ya*width] = col;
                 }
             }
        
        }  
    }   
    
    public void setOffset (int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}


