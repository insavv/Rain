package com.firsttry.rain.level.tile;

import com.firsttry.rain.graphics.Screen;
import com.firsttry.rain.graphics.Sprite;


class rockTile extends Tile {

    public rockTile(Sprite sprite) {
        super(sprite);
    }
    
     public void render(int x, int y, Screen screen){
        screen.renderTile(x << 4, y << 4, this);
    }

}
