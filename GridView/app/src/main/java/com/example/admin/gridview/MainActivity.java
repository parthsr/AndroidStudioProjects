package com.example.admin.gridview;

import android.content.Context;
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
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gb= (GridView)findViewById(R.id.gridView);
        gb.setAdapter(new parthadapter(this));
    }


}

class country
{
    String country_name;
    int image;
    country(String country_name, int image)
    {
        this.country_name=country_name;
        this.image=image;
    }
}
class ViewHolder {
    ImageView myCountry;

    ViewHolder(View v) {
        myCountry = (ImageView) v.findViewById(R.id.imageView);
    }
}

class parthadapter extends BaseAdapter {
    ArrayList<country> cont ;
    Context context;

    parthadapter(Context context) {
        cont = new ArrayList<country>();
        this.context = context;
        int images[] = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
        Resources res = context.getResources();
        String name[] = res.getStringArray(R.array.flags);
        for (int i = 0; i < 8; i++) {
            country temp = new country(name[i], images[i]);
            cont.add(temp);
        }
    }

    @Override
    public int getCount() {
        return cont.size();
    }

    @Override
    public Object getItem(int position) {
        return cont.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (position);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder viewHolder = null;
        if (row == null) {
            LayoutInflater inflator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            inflator.inflate(R.layout.cell, parent, false);
            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) row.getTag();
        }
        country temp= cont.get(position);
        viewHolder.myCountry.setImageResource(temp.image);
        return row;
    }
}