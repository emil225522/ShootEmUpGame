package com.example.emil.shootemupgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bullet extends GameObject {

        private Bitmap image;
        private int x, y, dx = 20;


        public  Bullet (Bitmap res, int x, int y){
            this.x = x;
            this.y = y;
            image = res;
        }
        //updates games
        public void update(){

            x+=dx;
            if (x > GamePanel.WIDTH){
                isDead = true;
            }
        }
        public void draw(Canvas canvas){
            canvas.drawBitmap(image, x, y, null);
        }
    }
