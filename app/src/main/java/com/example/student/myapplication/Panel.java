package com.example.student.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by student on 12/8/15.
 */
public class Panel extends SurfaceView implements SurfaceHolder.Callback{
    //GLOBAL VARIABLES
    Paint paint;
    private CanvasThread canvasthread;
    //Variable used to hold our bitmap
    Bitmap twoclubs;
    Bitmap threeclubs;
    Bitmap fourclubs;
    Bitmap fiveclubs;
    Bitmap sixclubs;
    Bitmap sevenclubs;
    Bitmap eightclubs;
    Bitmap nineclubs;
    Bitmap tenclubs;
    Bitmap jackclubs;
    Bitmap queenclubs;
    Bitmap kingclubs;
    Bitmap aceclubs;


    public Panel(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub

        getHolder().addCallback(this);
        canvasthread = new CanvasThread(getHolder(), this);
        setFocusable(true);
        paint = new Paint();

        twoclubs = BitmapFactory.decodeResource(getResources(), R.drawable.twoclubs);
        twoclubs = Bitmap.createScaledBitmap(twoclubs, twoclubs.getWidth()/3, twoclubs.getWidth()/3, false);

        threeclubs = BitmapFactory.decodeResource(getResources(), R.drawable.threeclubs);
        threeclubs = Bitmap.createScaledBitmap(threeclubs, threeclubs.getWidth() / 3, threeclubs.getWidth() / 3, false);

        fourclubs = BitmapFactory.decodeResource(getResources(), R.drawable.fourclubs);
        fourclubs = Bitmap.createScaledBitmap(fourclubs, fourclubs.getWidth() / 3, fourclubs.getWidth() / 3, false);

        fiveclubs = BitmapFactory.decodeResource(getResources(), R.drawable.fiveclubs);
        fiveclubs = Bitmap.createScaledBitmap(fiveclubs, fiveclubs.getWidth() / 3, fiveclubs.getWidth() / 3, false);

        sixclubs = BitmapFactory.decodeResource(getResources(), R.drawable.sixclubs);
        sixclubs = Bitmap.createScaledBitmap(sixclubs, sixclubs.getWidth() / 3, sixclubs.getWidth() / 3, false);

        sevenclubs = BitmapFactory.decodeResource(getResources(), R.drawable.sevenclubs);
        sevenclubs = Bitmap.createScaledBitmap(sevenclubs, sevenclubs.getWidth() / 3, sevenclubs.getWidth() / 3, false);

        eightclubs = BitmapFactory.decodeResource(getResources(), R.drawable.eightclubs);
        eightclubs = Bitmap.createScaledBitmap(eightclubs, eightclubs.getWidth() / 3, eightclubs.getWidth() / 3, false);

        nineclubs = BitmapFactory.decodeResource(getResources(), R.drawable.nineclubs);
        nineclubs = Bitmap.createScaledBitmap(nineclubs, nineclubs.getWidth() / 3, nineclubs.getWidth() / 3, false);

        tenclubs = BitmapFactory.decodeResource(getResources(), R.drawable.tenclubs);
        tenclubs = Bitmap.createScaledBitmap(tenclubs, tenclubs.getWidth() / 3, tenclubs.getWidth() / 3, false);

        jackclubs = BitmapFactory.decodeResource(getResources(), R.drawable.jackclubs);
        jackclubs = Bitmap.createScaledBitmap(jackclubs, jackclubs.getWidth() / 3, jackclubs.getWidth() / 3, false);

        queenclubs = BitmapFactory.decodeResource(getResources(), R.drawable.queenclubs);
        queenclubs = Bitmap.createScaledBitmap(queenclubs, queenclubs.getWidth() / 3, queenclubs.getWidth() / 3, false);

        kingclubs = BitmapFactory.decodeResource(getResources(), R.drawable.kingclubs);
        kingclubs = Bitmap.createScaledBitmap(kingclubs, kingclubs.getWidth() / 3, kingclubs.getWidth() / 3, false);

        aceclubs = BitmapFactory.decodeResource(getResources(), R.drawable.aceclubs);
        aceclubs = Bitmap.createScaledBitmap(aceclubs, aceclubs.getWidth()/3, aceclubs.getWidth()/3, false);



    }




    public Panel(Context context) {
        super(context);
        getHolder().addCallback(this);
        canvasthread = new CanvasThread(getHolder(), this);
        setFocusable(true);

    }


    @Override
    public void onDraw(Canvas canvas) {


        canvas.drawBitmap(twoclubs, 0.0f,0.0f, null);


        /**
        paint.setARGB(255, 255, 0, 0);
        //canvas.drawColor(Color.BLACK);
        canvas.drawCircle(200f, 200f, 30, paint);
    **/
         }

    public void update() {


    }



    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        canvasthread.setRunning(true);
        canvasthread.start();


    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        boolean retry = true;
        canvasthread.setRunning(false);
        while (retry) {
            try {
                canvasthread.join();
                retry = false;
            } catch (InterruptedException e) {
                // we will try it again and again...
            }
        }





    }


}