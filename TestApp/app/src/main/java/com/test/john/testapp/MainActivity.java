package com.test.john.testapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //static variable to be used to store the email/username and send it to MenuActivity
    public final static String userString = "com.test.john.testapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
            MainActivity.this.startActivity(myIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    //tells the login button what to do
    public void loginButton(View view) {
        EditText username = (EditText) findViewById(R.id.emailText);
        String message = username.getText().toString();
        EditText password = (EditText) findViewById(R.id.passwordText);
        String pass = password.getText().toString();

        if (Objects.equals(message, "admin") && Objects.equals(pass, "admin")) {
            Intent myIntent = new Intent(MainActivity.this, MenuActivity.class);
            myIntent.putExtra(userString, message);
            MainActivity.this.startActivity(myIntent);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect Email/User or Password";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    //tells the forgot password button what to do
    public void forgotPassButton(View view){
        Intent myIntent = new Intent(MainActivity.this, ForgotPassActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    //tells the create account button what to do
    public void createAccountButton(View vew){
        Intent myIntent = new Intent(MainActivity.this, CreateAccountActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

}
