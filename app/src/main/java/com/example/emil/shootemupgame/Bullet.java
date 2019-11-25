package com.example.emil.shootemupgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Bullet extends GameObject {

        private Bitmap image;
        public int x, y, dx = 20;
    public Rect rectangle;


        public  Bullet (Bitmap res, int x, int y){
            this.x = x;
            this.y = y;
            image = res;
            rectangle = new Rect(x, y, x+image.getWidth(), y+image.getHeight());
        }
        //updates games
        public void update(){

            x+=dx;
            if (x > GamePanel.WIDTH){
                isDead = true;
            }
            rectangle = new Rect(x, y, x+image.getWidth(), y+image.getHeight());
        }
        public void draw(Canvas canvas){
            canvas.drawBitmap(image, x, y, null);
        }
    }
