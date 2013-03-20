package com.example.ballcatch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

public class FlatView extends View {
	
	int screen_width;
	int screen_height;
	
	int score = 0;
	BallManager ballManager;
	GateManager gateManager;
	final int ballsize = 50;
	
	final int RED_BALL = 0;
	final int BLUE_BALL = 1;
	final int GREEN_BALL = 2;
	final int ORANGE_BALL = 3;
	
	Bitmap bitmaps[];
    
    private final Paint mPaint = new Paint();
    
    public FlatView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFlatView();
    }
    
    public FlatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFlatView();
    }
    
    public void initFlatView()
    {
        
    	Resources res = getContext().getResources();
    	
    	//String screen_width1 = (String) res.getText(R.string.screen_width);
    	screen_width = 720;  //Integer.parseInt(screen_width1);
    	
    	//String screen_height1 = (String) res.getText(R.string.screen_height);
    	screen_height = 1280; //Integer.parseInt(screen_height1);
    	
        ballManager = new BallManager(screen_width, screen_height);
        gateManager = new GateManager();
    }
    
    public void resetBitmaps()
    {
    	bitmaps = new Bitmap[4];
    }

    public void loadImage(int key, Drawable obj) {
        Bitmap bitmap = Bitmap.createBitmap(ballsize, ballsize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        obj.setBounds(0, 0, ballsize, ballsize);
        obj.draw(canvas);
        bitmaps[key] = bitmap;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Score: " + score, 0, 0, new Paint());
        
        for (int i = 0; i < 4; i++)
        {
        	int radius = gateManager.getRadius();
        	gateManager.getGate(i).draw(canvas, radius);
        }
        
        for (int i = 0; i < ballManager.get_number_of_balls(); i++)
        {
        	Ball ball = ballManager.getBall(i);
       		//canvas.drawBitmap(bitmaps[ball.bitmapId], ball.getX(), ball.getY(), mPaint);
        }
    }
}
