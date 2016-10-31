package com.example.admin.xml_to_java;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   LinearLayout ll;
    Button b;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ll=new LinearLayout(this);
        b=new Button(this);
        t=new TextView(this);
        super.onCreate(savedInstanceState);
        ll.setOrientation(LinearLayout.VERTICAL);
        b.setText("Button");
        t.setText("MY NIGGA MY NIGGA");
        ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        ViewGroup.LayoutParams lr=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        b.setLayoutParams(lr);
        t.setLayoutParams(lr);


        ll.addView(b);
        ll.addView(t);
        setContentView(ll);

    }


}
