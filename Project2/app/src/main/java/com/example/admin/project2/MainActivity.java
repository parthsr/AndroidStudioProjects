package com.example.admin.project2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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

   public void doSomething(View v)
   {

      check();
       Log.i("parth", "hi");
   }

    Random random= new Random();
    int rand=0;
    public void check()
    {
        if(rand==0)
        {
            empty();
            mulcheck();
        }
        else if(rand==1)
        {
            empty();
            addcheck();
        }
        else
        {
            empty();
            subcheck();
        }

    }
    public void empty()
    {
        EditText e= (EditText) findViewById(R.id.editText);
        String c= e.getText().toString();
        if(c.compareTo("")==0)
        {
            e.setText("0");
        }
    }

    public void mulcheck()
    {
        TextView text= (TextView) findViewById(R.id.num1);
        TextView text2= (TextView) findViewById(R.id.num2);
        int a= Integer.parseInt(text.getText().toString());
        int b=Integer.parseInt(text2.getText().toString());
        EditText e= (EditText) findViewById(R.id.editText);
        int c=Integer.parseInt(e.getText().toString());
        if(a*b==c) {
            e.setText("");
            prog();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

    }

    public void addcheck()
    {
        TextView text= (TextView) findViewById(R.id.num1);
        TextView text2= (TextView) findViewById(R.id.num2);
        int a= Integer.parseInt(text.getText().toString());
        int b=Integer.parseInt(text2.getText().toString());
        EditText e= (EditText) findViewById(R.id.editText);
        int c=Integer.parseInt(e.getText().toString());
        if(a+b==c) {
            e.setText("");
            prog();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

    }
    public void subcheck()
    {
        TextView text= (TextView) findViewById(R.id.num1);
        TextView text2= (TextView) findViewById(R.id.num2);
        int a= Integer.parseInt(text.getText().toString());
        int b=Integer.parseInt(text2.getText().toString());
        EditText e= (EditText) findViewById(R.id.editText);
        int c=Integer.parseInt(e.getText().toString());
        if(a-b==c) {
            e.setText("");
            prog();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

    }
    public void prog() {

        for (int i = 0; i < 10; i++) {
            switch (rand=(random.nextInt() % 3)) {
                case 0: {
                    multiplication();
                    break;
                }
                case 1: {
                    add();
                    break;
                }
                case 2: {
                    sub();
                    break;
                }

            }
        }
    }

    public void multiplication()
    {
        int num1= random.nextInt()%100;
        int num2= random.nextInt()%21;
        String n1=""+num1;
        String n2=""+num2;
        TextView text= (TextView) findViewById(R.id.num1);
        TextView text2= (TextView) findViewById(R.id.num2);
        TextView text3= (TextView) findViewById(R.id.sign);
        text.setText(n1);
        text2.setText(n2);
        text3.setText("*");
    }

    public void add()
    {
        int num1= random.nextInt()%100;
        int num2= random.nextInt()%100;
        String n1=""+num1;
        String n2=""+num2;
        TextView text= (TextView) findViewById(R.id.num1);
        TextView text2= (TextView) findViewById(R.id.num2);
        TextView text3= (TextView) findViewById(R.id.sign);
        text.setText(n1);
        text2.setText(n2);
        text3.setText("+");
    }

    public void sub()
    {
        int num1= random.nextInt()%100;
        int num2= random.nextInt()%100;
        String n1=""+num1;
        String n2=""+num2;
        TextView text= (TextView) findViewById(R.id.num1);
        TextView text2= (TextView) findViewById(R.id.num2);
        TextView text3= (TextView) findViewById(R.id.sign);
        text.setText(n1);
        text2.setText(n2);
        text3.setText("-");
    }
}
