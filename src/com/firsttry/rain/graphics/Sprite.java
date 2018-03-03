
package com.firsttry.rain.graphics;


public class Sprite {
    
    public  final int SIZE;
    private int x,y;
    public int[] pixels;
    private SpriteSheet sheet;
    
    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16,0xFFFFFF);
    public static Sprite player_forward = new Sprite(16,3,0,SpriteSheet.playerTile);
    public static Sprite player_back = new Sprite(16,0,0,SpriteSheet.playerTile);
    public static Sprite player_side = new Sprite(16,6,0,SpriteSheet.playerTile);
    public static Sprite flower = new Sprite(16,1,0,SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16,2,0,SpriteSheet.tiles);
    
    public static Sprite player_backward_1 = new Sprite(16, 1, 0, SpriteSheet.playerTile);
    public static Sprite player_backward_2 = new Sprite(16, 2, 0, SpriteSheet.playerTile);
    public static Sprite player_forward_1 = new Sprite(16, 4, 0, SpriteSheet.playerTile);
    public static Sprite player_forward_2 = new Sprite(16, 5, 0, SpriteSheet.playerTile);
    public static Sprite player_left_1 = new Sprite(16, 7, 0, SpriteSheet.playerTile);
    public static Sprite player_left_2 = new Sprite(16, 8, 0, SpriteSheet.playerTile);
    
    public Sprite(int size, int x, int y, SpriteSheet sheet){
        this.SIZE = size;
        pixels = new int[SIZE*SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
        
    }
    
    public Sprite (int size, int colour){
        SIZE = size;
        pixels = new int [SIZE * SIZE];
        setColour(colour);
    }
    
    private void setColour(int colour){
        for(int i = 0; i < SIZE*SIZE; i++){
            pixels[i] = colour;
        }
    }
    
    private void load(){
       for(int y = 0; y < SIZE; y++){
           for(int x=0; x<SIZE; x++){
               pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)*sheet.SIZE ];
           }
       } 
    }
}
