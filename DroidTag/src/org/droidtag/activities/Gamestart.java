package org.droidtag.activities;

import org.droidtag.R;
import org.droidtag.R.layout;
import org.droidtag.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Gamestart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gamestart);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gamestart, menu);
		return true;
	}

}
