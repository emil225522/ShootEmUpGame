package com.example.emil.shootemupgame;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background {

    private Bitmap image;
    private int x, y, dx = -10;


    public  Background (Bitmap res, int x, int y){
        this.x = x;
        this.y = y;
        image = res;
    }
    //updates games
    public void update(){
        x+=GamePanel.MOVESPEED;
        if (x < -GamePanel.WIDTH - GamePanel.MOVESPEED)
            x = GamePanel.WIDTH;
    }
    public void draw(Canvas canvas){
        canvas.drawBitmap(image, x, y, null);

    }
    public void setVector(int dx){
        this.dx = dx;
    }
}
