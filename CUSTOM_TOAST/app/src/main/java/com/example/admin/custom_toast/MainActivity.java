package com.example.admin.custom_toast;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

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
public void button_click(View view)
{
    Toast toast=new Toast(this);
    toast.setDuration(toast.LENGTH_SHORT);
    toast.setGravity(Gravity.BOTTOM, 0, 0);

    LayoutInflater inflaterrr= getLayoutInflater();
    View appearnce= inflaterrr.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.root));
    toast.setView(appearnce);
    toast.show();
}

}