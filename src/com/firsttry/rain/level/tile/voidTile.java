/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firsttry.rain.level.tile;

import com.firsttry.rain.graphics.Screen;
import com.firsttry.rain.graphics.Sprite;


class voidTile extends Tile {

    public voidTile(Sprite sprite) {
        super(sprite);
    }
    
     public void render(int x, int y, Screen screen){
        screen.renderTile(x << 4, y << 4, this);
    }
    
}
