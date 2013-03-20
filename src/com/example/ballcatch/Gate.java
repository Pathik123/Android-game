package com.example.ballcatch;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Gate {
	
	int mR;
	int mG;
	int mB;
	
	int xPos;
	int yPos;
	
	public Gate(int r, int g, int b, int x, int y)
	{
		mR = r;
		mG = g;
		mB = b;
		xPos = x;
		yPos = y;
	}
	
	public void setColor(int r, int g, int b)
	{
		mR = r;
		mG = g;
		mB = b;
	}
	
	public void draw(Canvas canvas, int radius)
	{
		Paint mPaint = new Paint();
		mPaint.setColor(Color.rgb(mR, mG, mB));
		canvas.drawCircle(xPos, yPos, radius, mPaint);
	}
}
