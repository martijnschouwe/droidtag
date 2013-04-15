package org.droidtag.activities;

import org.droidtag.R;
import org.droidtag.R.layout;
import org.droidtag.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			//just continue
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
