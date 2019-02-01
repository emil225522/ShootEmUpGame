package com.example.emil.shootemupgame;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background {

    private Bitmap image;
    private int x, y, dx = -5;


    public  Background (Bitmap res){
        image = res;
    }
    //updates games
    public void update(){
        x+=GamePanel.MOVESPEED;
        if (x < -GamePanel.WIDTH)
            x = 0;
    }
    public void draw(Canvas canvas){
        canvas.drawBitmap(image, x, y, null);

        if (x <0){
            canvas.drawBitmap(image, x+ GamePanel.WIDTH , y, null);
        }

    }
    public void setVector(int dx){
        this.dx = dx;
    }
}
