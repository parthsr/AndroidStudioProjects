package com.example.admin.listview_with_diff_images;

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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] titlearray;
    String descarray[];
    int images[]={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
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
        Resources res=getResources();
        list= (ListView) findViewById(R.id.listView);
        titlearray=res.getStringArray(R.array.titles);
        descarray=res.getStringArray(R.array.descriptions);

        parthadapter adapter=new parthadapter(this,titlearray,descarray,images);
        list.setAdapter(adapter);
    }



}

class parthadapter extends ArrayAdapter<String>
{
    String t[];
    String d[];
    int i[];
    Context context;
    parthadapter(Context c, String titles[],String des[],int im[])
    {
        super(c,R.layout.single_row,R.id.textView,titles);
        this.context=c;
        this.t=titles;
        this.d=des;
        this.i=im;
    }

    class myViewHolder
    {
        TextView mytitle;
        ImageView img;
        TextView mydescription;
        myViewHolder(View row)
        {
            TextView mytitle= (TextView) row.findViewById(R.id.textView);
            ImageView img=(ImageView)row.findViewById(R.id.imageView);
            TextView mydescription= (TextView) row.findViewById(R.id.textView2);

        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row=convertView;
        myViewHolder holder =null;
            if(row==null) {
                LayoutInflater inflator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row = inflator.inflate(R.layout.single_row, parent, false);
                holder=new myViewHolder(row);
                row.setTag(holder);
            }
        else
            {
                holder= (myViewHolder) row.getTag();
            }
        holder.mytitle.setText(t[position]);

        holder.mydescription.setText(d[position]);

        holder.img.setImageResource(i[position]);
        return row;

    }

}