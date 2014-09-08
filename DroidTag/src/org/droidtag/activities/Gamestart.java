package org.droidtag.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import org.droidtag.R;

public class Gamestart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
    }

    public void gameStartClickListener(View view){
        Intent i= new Intent(this, LobbyActivity.class);
        startActivity(i);
    }

    public void gameJoinClickListener(View view){
        Intent i= new Intent(this, JoinGameActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gamestart, menu);
        return true;
    }

}
