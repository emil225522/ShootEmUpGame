package com.example.emil.shootemupgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bullet extends GameObject {

        private Bitmap image;
        private int x, y, dx = -5;


        public  Bullet (Bitmap res, int x, int y){
            this.x = x;
            this.y = y;
            image = res;
        }
        //updates games
        public void update(){
            x+=GamePanel.MOVESPEED;
        }
        public void draw(Canvas canvas){
            canvas.drawBitmap(image, x, y, null);
        }
    }
