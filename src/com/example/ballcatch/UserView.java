package com.example.ballcatch;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class UserView extends FlatView {
	
	public UserView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initUserView(context);
	}
	
	public UserView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initUserView(context);
	}
	
	private void initUserView(Context context)
	{
		setFocusable(true);
		
		Resources r = context.getResources();
		
		resetBitmaps();
		//loadImage(RED_BALL, r.getDrawable(R.drawable.red));
		//loadImage(BLUE_BALL, r.getDrawable(R.drawable.blue));
		//loadImage(GREEN_BALL, r.getDrawable(R.drawable.green));
		//loadImage(ORANGE_BALL, r.getDrawable(R.drawable.orange));
		
		ballManager.assignBallBitmaps();
	}
	
	public boolean onTouchEvent(MotionEvent event)
	{
		switch (event.getAction())
		{
		case MotionEvent.ACTION_MOVE:
			for (int i = 0; i < ballManager.get_number_of_balls(); i++)
			{
				Ball ball = ballManager.getBall(i);
				if ((event.getX() > (ball.getX())) && (event.getX() < (ball.getX() + 50)) && (event.getY() > (ball.getY())) && (event.getY() < (ball.getY() + 50)))
				{
					int rad = gateManager.getRadius();
					if ((event.getX() > ((screen_width/2)-rad)) && (event.getX() < ((screen_width/2)+rad)) && (event.getY() < rad)) // top gate
					{
						ballManager.findNewPosition(i);
					}
					else
					{
						ball.setX((int)(event.getX() - 25));
						ball.setY((int)(event.getY() - 25));
						break;
					}
				}
			}
			break;
		default:
			break;
		}
		invalidate();
		return true;
	}
}