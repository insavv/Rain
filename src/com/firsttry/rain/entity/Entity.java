
package com.firsttry.rain.entity;

import com.firsttry.rain.graphics.Screen;
import com.firsttry.rain.level.Level;
import java.util.Random;


public abstract class Entity {                   //invisible object we make to keep track of certain thing
    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();
    
     public void update(){}
     
     public void render (Screen screen){}
     
     public void remove(){
         removed = true;                        //remove entity from level
     }
     
     public boolean isRemoved(){
         return removed;
     }
}
