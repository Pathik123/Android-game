package com.example.ballcatch;

import java.util.Random;

public class Ball {
	int x;
	int y;
	int bitmapId;
	Random rand = new Random();
	
	int dir;
	
	public Ball()
	{
		x = 0;
		y = 0;
		dir = rand.nextInt(8);
	}
	
	public Ball(int xx, int yy)
	{
		x = xx;
		y = yy;
		dir = rand.nextInt(8);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int xx)
	{
		x = xx;
	}
	
	public void setY(int yy)
	{
		y = yy;
	}
	
	public void setBitmapId(int id)
	{
		bitmapId = id;
	}
	
	public void setDirection(int direction)
	{
		dir = direction;
	}
}
