package com.example.ballcatch;

import com.example.ballcatch.UserView;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;

public class MainActivity extends Activity {
	private UserView mUserView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Resources r = this.getBaseContext().getResources();
		
		Drawable redBall = r.getDrawable(R.drawable.red);
		
		///resetBitmaps();
		//loadImage(RED_BALL, r.getDrawable(R.drawable.red));
		//loadImage(BLUE_BALL, r.getDrawable(R.drawable.blue));
		//loadImage(GREEN_BALL, r.getDrawable(R.drawable.green));
		//loadImage(ORANGE_BALL, r.getDrawable(R.drawable.orange));
		
        mUserView = (UserView) findViewById(R.id.userView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
