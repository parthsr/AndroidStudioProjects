package com.example.admin.frame_layout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        i1=(ImageView)findViewById(R.id.imageView1);
        i2=(ImageView)findViewById(R.id.imageView2);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void doSomething(View view)
    {
        if(view.getId()==R.id.imageView1)
        {
            i1.setVisibility(View.GONE);
            i2.setVisibility(View.VISIBLE);

        }
        else
        {

            i2.setVisibility(View.GONE);
            i1.setVisibility(View.VISIBLE);
        }
    }


}

