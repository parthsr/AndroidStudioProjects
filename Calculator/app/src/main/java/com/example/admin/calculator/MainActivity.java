package com.example.admin.calculator;

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

public class MainActivity extends AppCompatActivity {
    private EditText Scr;
    private float NumberBf;
    private String Operation;
    private ButtonClickListener btnclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Scr=(EditText)findViewById(R.id.editText);
        Scr.setEnabled(false);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        int idList[]={R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,
                R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.buttondot,R.id.buttonadd,R.id.buttonsub,
                R.id.buttonmul,R.id.buttondiv,R.id.buttonequals,R.id.buttonC};

        for(int id:idList)
        {
            View v=(View)findViewById(id);
            v.setOnClickListener(btnclick);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public  void mMath(String str)
    {
        NumberBf = Float.parseFloat(Scr.getText().toString());
        Operation= str;
        Scr.setText("0");
    }

    public void getKeyboard(String str)
    {
        String ScrCurrent=Scr.getText().toString();
        if(ScrCurrent.equals("0"))
        {
            ScrCurrent="";
        }
        ScrCurrent += str;
        Scr.setText(ScrCurrent);
    }

    public void mResult()
    {
        float Numbf=Float.parseFloat(Scr.getText().toString());
        float result=0;
        if(Operation.equals("+"))
        {
            result=Numbf+NumberBf;
        }
        if(Operation.equals("-")) {
            result = Numbf - NumberBf;
        }
        if(Operation.equals("/")) {
            result = Numbf / NumberBf;
        }
        if(Operation.equals("*")) {
            result = Numbf * NumberBf;
        }
        Scr.setText(String.valueOf(result));
        }

     private class ButtonClickListener implements View.OnClickListener
     {
         public void onClick(View v)
         {
                switch(v.getId())
                {
                    case R.id.buttonC:
                    {
                        Scr.setText("0");
                        NumberBf=0;
                        Operation="";
                        break;
                    }
                    case R.id.buttonadd:
                    {
                        mMath("+");
                        break;
                    }
                    case R.id.buttonsub:
                    {
                        mMath("-");
                        break;
                    }
                    case R.id.buttonmul:
                    {
                        mMath("*");
                        break;
                    }
                    case R.id.buttondiv:
                    {
                        mMath("/");
                        break;
                    }
                    case R.id.buttonequals:
                    {
                        mResult();
                        break;
                    }
                    default:
                        String numb= ((Button)v).getText().toString();
                        getKeyboard(numb);
                        break;
                }
         }
     }

}
