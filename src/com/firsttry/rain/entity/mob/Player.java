
package com.firsttry.rain.entity.mob;

import com.firsttry.rain.graphics.Screen;
import com.firsttry.rain.graphics.Sprite;
import com.firsttry.rain.input.Keyboard;

public class Player extends Mob {
    
    private Keyboard input;
    private Sprite sprite;
    public static int anim = 0;
    private boolean walking = false;
   
    
    
    public Player (Keyboard input){
        this.input = input;
    }
    
    public Player(int x, int y, Keyboard input){
        this.input = input;
        this.x = x;
        this.y = y;
    }
    
    public void update(){
      int xa = 0, ya = 0;
      
      if(anim < 7500) anim++ ;
      else anim = 0;
      
      if(input.up) ya--;
      if(input.down) ya++;
      if(input.left) xa--;
      if(input.right) xa++;
      
      if( xa != 0 || ya != 0) {
          move(xa,ya);
          walking = true;
      }
      else{
          walking = false;
      }
    }
    
    public void render(Screen screen){
         int flip = 0;
        if (dir == 0 ) {
            sprite = Sprite.player_forward;
            if(walking){
                if(anim % 40 > 30){
                    sprite = Sprite.player_forward_1;
                }
                else if ( anim % 40 > 20){
                    sprite = Sprite.player_forward;
                }
                
                else if (anim % 40 > 10){
                    sprite = Sprite.player_forward_2;
                }
                else{
                    sprite = sprite.player_forward;
                }
            }
        }
        if (dir == 1) {
            sprite = Sprite.player_side;
            flip = 1;
            
             if(walking){
                if(anim % 40 > 30 ){
                    sprite = Sprite.player_left_1;
                }
               else if(anim %40 > 20){
                    sprite = Sprite.player_side;
                }
               else if (anim % 40 > 10){
                    sprite = Sprite.player_left_1;
                }
               else {
                   sprite = Sprite.player_side;
               }
            }
        }
        if (dir == 2 ) {
            sprite = Sprite.player_back;
             if(walking){
                if(anim % 40 > 30){
                    sprite = Sprite.player_backward_1;
                }
                else if ( anim % 40 > 20){
                    sprite = Sprite.player_back;
                }
                
                else if (anim % 40 > 10){
                    sprite = Sprite.player_backward_2;
                }
                else{
                    sprite = sprite.player_back;
                }
            }
        }
        if (dir == 3 ) {
            
            sprite = Sprite.player_side;
            
            
             if(walking){
                if(anim % 40 > 30 ){
                    sprite = Sprite.player_left_1;
                }
               else if(anim %40 > 20){
                    sprite = Sprite.player_side;
                }
               else if (anim % 40 > 10){
                    sprite = Sprite.player_left_1;
                }
               else {
                   sprite = Sprite.player_side;
               }
            }
        }
           
        
        screen.renderPlayer(x, y, sprite, flip);
    }
}
