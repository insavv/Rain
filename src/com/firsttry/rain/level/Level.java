/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.firsttry.rain.level;

import com.firsttry.rain.graphics.Screen;
import com.firsttry.rain.level.tile.Tile;


public class Level {
    
    protected int width, height;
    protected int [] tilesInt;
    protected int [] tiles;
    
    
    public Level (int width,int height){
        this.height = height;
        this.width = width;
        tilesInt = new int [width * height];
        generateLevel();
    }
    public Level(String path){
        loadLevel(path);
    }
    
    private void generateLevel(){
    }
    
    protected void loadLevel(String path) {
    }
    
    public void update(){
    }
    
    private void time(){
    
    }
    
    public void render (int xScroll, int yScroll, Screen screen){
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;
        
        for (int y = y0; y < y1; y++){
            for (int x = x0; x < x1; x++){
                getTile(x,y).render(x, y, screen);
            }
        }
    }
    
    // Grass = 0x4B7F39
     // Flower = 0xFFF87A
     // Rock = 0x919191
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height ) return Tile.voidTile;
        if(tiles [x + y * width] == 0xFF4B7F39) return Tile.grass;
        if(tiles [x + y * width] == 0xFFFFF87A) return Tile.flower;
        if(tiles [x + y * width] == 0xFF919191) return Tile.rock;
        return Tile.voidTile;
    }

    
        
}

