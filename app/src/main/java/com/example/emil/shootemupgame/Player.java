package com.example.emil.shootemupgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Player extends GameObject{
    private Bitmap image;
    private int score;
    private double dya;
    private boolean up;
    private boolean playing;
    private long startTime;

    public Player(Bitmap image) {

        x = 100;
        y = GamePanel.HEIGHT / 2;
        dy = 0;
        this.image = image;
        score = 0;
        startTime = System.nanoTime();

    }

    public void setUp(boolean b){up = b;}

    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed>100)
        {
            score++;
            startTime = System.nanoTime();
        }

        if(up){
            dy = (int)(dya-=1.1);

        }
        else{
            dy = (int)(dya+=1.1);
        }

        if(dy>14)dy = 14;
        if(dy<-14)dy = -14;

        if (y > GamePanel.HEIGHT) {
            y = 0;
        }
        if (y < 0){
            y = GamePanel.HEIGHT;
        }
        y += dy*2;
        dy = 0;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y, null);
    }
    public int getScore(){return score;}
    public boolean getPlaying(){return playing;}
    public void setPlaying(boolean b){playing = b;}
    public void resetDYA(){dya = 0;}
    public void resetScore(){score = 0;}
}