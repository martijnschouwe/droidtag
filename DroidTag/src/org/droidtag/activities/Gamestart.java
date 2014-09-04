package org.droidtag.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import org.droidtag.R;

public class Gamestart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gamestart, menu);
        return true;
    }

}
