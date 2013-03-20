package com.example.ballcatch;

import java.util.Random;

public class BallManager {
	Ball[] balls;
	int number_of_balls = 8;
	int ball_dimension = 50;
	int screen_width;
	int screen_height;
	
	public BallManager(int width, int height)
	{
		screen_width = width;
		screen_height = height;
		
		balls = new Ball[number_of_balls];
		for (int i = 0; i < number_of_balls; i++)
			balls[i] = new Ball();
		for (int i = 0; i < number_of_balls; i++)
			findNewPosition(i);
	}
	
	public void findNewPosition(int key)
	{
		boolean valid = false;
		Random randx = new Random();
		Random randy = new Random();

		while (valid == false)
		{
			int length = 0;
			
			int maxx = screen_width - (2 * ball_dimension);
			int minx = ball_dimension;
			
			int maxy = screen_height - (2 * ball_dimension);
			int miny = ball_dimension;
			
			int newx = minx + randx.nextInt(maxx - minx);
			int newy = miny + randy.nextInt(maxy - miny);
			
			for (int i = 0; i < number_of_balls; i++)
			{
				if (i == key)
					continue;
				
				int ballx = balls[i].getX();
				int bally = balls[i].getY();
				
				if ((newx > (ballx-ball_dimension)) && (newx < (ballx+ball_dimension)) && (newy > (bally-ball_dimension)) && (newy < (bally+ball_dimension)))
					break;
				else
					length++;
			}
			if (length == (number_of_balls - 1))
			{
				valid = true;
				balls[key].setX(newx);
				balls[key].setY(newy);
			}
		}
		balls[key].setBitmapId(randx.nextInt(4));
	}
	
	public void avoidCollision()
	{
		for (int i = 0; i < number_of_balls; i++)
		{
			Ball ball = balls[i];
			int ball_x = ball.getX();
			int ball_y = ball.getY();
			
			for (int j = 0; j < number_of_balls; j++)
			{
				if (i == j)
					continue;
				
				Ball ball1 = balls[j];
				int ball1_x = ball1.getX();
				int ball1_y = ball1.getY();
				
				//if (ball_x + )
			}
		}
	}
	
	public void assignBallBitmaps()
	{
		Random rand = new Random();
		for (int i = 0; i < number_of_balls; i++)
			balls[i].setBitmapId(rand.nextInt(4));
	}
	
	public Ball getBall(int key)
	{
		return balls[key];
	}
	
	public int get_number_of_balls()
	{
		return number_of_balls;
	}
}
