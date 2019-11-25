package com.example.emil.shootemupgame;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Enemy extends GameObject {

    private Bitmap image;
    public int x, y, dx = -10;
    public Rect rectangle;
    public int health;

    public  Enemy (Bitmap res, int x, int y){
        this.x = x;
        this.y = y;
        image = res;
        health = 6;
       rectangle = new Rect(x, y, x+image.getWidth(), y+image.getHeight());
    }

    public void update(){

        x+=dx;
        if (x < 0){
            isDead = true;
        }
        if ( health < 1){
            isDead = true;
        }
        rectangle = new Rect(x, y, x+image.getWidth(), y+image.getHeight());
    }
    public void draw(Canvas canvas){
        canvas.drawBitmap(image, x, y, null);
    }
}


