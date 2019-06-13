package com.example.emil.shootemupgame;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background {

    private Bitmap image;
    private int x, y, dx = -5;


    public  Background (Bitmap res, int x, int y){
        this.x = x;
        this.y = y;
        image = res;
    }
    //updates games
    public void update(){
        x+=GamePanel.MOVESPEED;
        if (x < -GamePanel.WIDTH*3f)
            x = GamePanel.WIDTH*3;
    }
    public void draw(Canvas canvas){
        canvas.drawBitmap(image, x, y, null);

        if (x <0){
            canvas.drawBitmap(image, x+ GamePanel.WIDTH*3, y, null);
        }

    }
    public void setVector(int dx){
        this.dx = dx;
    }
}
