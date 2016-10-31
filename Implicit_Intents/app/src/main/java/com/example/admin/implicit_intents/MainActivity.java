package com.example.admin.implicit_intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void process(View view) {
        Intent intent = null, choose = null;
        if (view.getId() == R.id.button) {
            intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.8777"));
            choose = Intent.createChooser(intent, "Launch Maps");
            startActivity(choose);

        }
        if(view.getId()==R.id.Market)
        {
            intent=new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
            choose=Intent.createChooser(intent,"Open google play");
            startActivity(choose);
        }

    }
}
