package com.example.admin.simpleloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public static Button button_sbm;
    public static EditText username;
    public static EditText password;
    public static int counter=5;
    public static TextView cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickLoginButton();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void OnClickLoginButton()
    {
        button_sbm=(Button)findViewById(R.id.button_login);
        username=(EditText)findViewById(R.id.editText_user);
        password=(EditText)findViewById(R.id.editText_password);
        cont=(TextView)findViewById(R.id.textView_attempts_count);

        cont.setText(Integer.toString(counter));
        button_sbm.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        if(username.getText().toString().equals("user")&&password.getText().toString().equals("password"))
                        {
                            Toast.makeText(Login.this,"login username and password are correct!!",Toast.LENGTH_LONG).show();
                            Intent intent= new Intent("com.activity_login.User") ;
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(Login.this,"login username and password are not correct!!",Toast.LENGTH_LONG).show();
                            counter--;
                            if(counter==0)
                            {
                                button_sbm.setEnabled(false);
                            }

                        }
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
