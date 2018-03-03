
package com.firsttry.rain.level.tile;

import com.firsttry.rain.graphics.Screen;
import com.firsttry.rain.graphics.Sprite;


public class Tile {
    
    public int x,y;
    public Sprite sprite;
    
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new voidTile(Sprite.voidSprite);
    public static Tile flower = new flowerTile(Sprite.flower);
    public static Tile rock = new rockTile(Sprite.rock);
    
    public Tile(Sprite sprite){
        this.sprite = sprite;
    }
    
    public void render(int x, int y, Screen screen){
    }
    
    
    public boolean solid (){
    
        return false;
    }
}
