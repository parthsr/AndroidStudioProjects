package com.example.admin.grids;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

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

        GridView grid= (GridView) findViewById(R.id.gridView);
        grid.setAdapter(new parthAdapter(this));
        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent= new Intent(this, MyDailogue.class);
        startActivity(intent);
    }
}

class object
{
    String name; int image;
    object (String x, int y)
    {
        name=x;
        image=y;
    }
}

class parthAdapter extends BaseAdapter {

    Context context;
    ArrayList<object> ob;
    parthAdapter(Context context) {
        this.context=context;
        ob = new ArrayList<object>();
        Resources res= context.getResources();
        String temp[]= res.getStringArray(R.array.names);
        int images[]= {R.drawable.images,R.drawable.can,R.drawable.gt,R.drawable.hi,R.drawable.ho,R.drawable.hy,R.drawable.in,R.drawable.us};
        for(int i=0;i<8;i++)
        {
            object o=new object(temp[i],images[i]);
            ob.add(o);
        }
    }
    @Override
    public int getCount() {
        return ob.size();
    }

    @Override
    public Object getItem(int position) {
        return ob.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infaltor=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v=infaltor.inflate(R.layout.cell,parent,false);
        ImageView im= (ImageView) v.findViewById(R.id.imageView);
        object o= ob.get(position);
        im.setImageResource(o.image);
        return v;
    }
}