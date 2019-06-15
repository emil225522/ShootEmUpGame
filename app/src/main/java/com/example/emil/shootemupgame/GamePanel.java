package com.example.emil.shootemupgame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static int WIDTH = 856;
    public static int HEIGHT = 480;
    public static final int MOVESPEED = -15;
    public int bulletTimer = 0;
    private MainThread thread;
    private Background bg1;
    private Background bg2;
    private Player player;
    public ArrayList<Bullet> bullets = new ArrayList<>();


    public GamePanel(Context context)
    {
        super(context);


        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //make gamePanel focusable so it can handle events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(retry)
        {
            try{thread.setRunning(false);
                thread.join();

            }catch(InterruptedException e){e.printStackTrace();}
            retry = false;
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

        bg1 = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.grassbg1),0,0);
        WIDTH = bg1.image.getWidth();
        HEIGHT = bg1.image.getHeight();
        bg2 = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.grassbg1),GamePanel.WIDTH,0);
        player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.ship),getWidth(),getHeight());


        //we can safely start the game loop
        thread.setRunning(true);
        thread.start();

    }
    public void CreateBullet(){
        bullets.add(new Bullet(BitmapFactory.decodeResource(getResources(), R.drawable.shipbullet), player.x + player.image.getWidth(),player.y));
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            if(!player.getPlaying())
            {
                player.setPlaying(true);
            }
            else
            {
                player.setUp(true);
            }
            return true;
        }
        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            player.setUp(false);
            return true;
        }

        return super.onTouchEvent(event);
    }

    public void update()
    {
        if(player.getPlaying()) {
            bulletTimer++;
            if (bulletTimer > 10){
                bulletTimer = 0;
                CreateBullet();
            }
            for (int i = 0; i < bullets.size(); i++){
                bullets.get(i).update();
            }
            for (int i = 0; i < bullets.size(); i++){
               if ( bullets.get(i).isDead){
                   bullets.remove(i);
               }
            }
            bg1.update();
            bg2.update();
            player.update();
        }
    }
    @Override
    public void draw(Canvas canvas)
    {
        System.out.println(getWidth());
        super.draw(canvas);
        final float scaleFactorX = WIDTH/getWidth();
        final float scaleFactorY = HEIGHT/getHeight();

        if(canvas!=null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            bg1.draw(canvas);
            bg2.draw(canvas);
            player.draw(canvas);
            for (int i = 0; i < bullets.size(); i++){
                bullets.get(i).draw(canvas);
            }
            canvas.restoreToCount(savedState);
        }
    }


}
