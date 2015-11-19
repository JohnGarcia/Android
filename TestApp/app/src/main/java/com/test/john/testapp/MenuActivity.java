package com.test.john.testapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //email/username used in a greeting
        Intent intent = getIntent();
        String user = intent.getStringExtra(MainActivity.userString);

        //user greeting
        Context context = getApplicationContext();
        CharSequence text = "Welcome " + user;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //tells settings button what to do (the little gear)
        if (id == R.id.action_favorite) {
            Intent myIntent = new Intent(MenuActivity.this, SettingsActivity.class);
            MenuActivity.this.startActivity(myIntent);
        }

        //tells the logout button what to do
        else if(id == R.id.Logout){
            Intent myIntent = new Intent(MenuActivity.this, MainActivity.class);
            MenuActivity.this.startActivity(myIntent);
        }

        return super.onOptionsItemSelected(item);
    }

}
