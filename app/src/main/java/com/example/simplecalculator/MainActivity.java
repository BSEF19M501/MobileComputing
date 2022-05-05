package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;

    String workings = "";
    boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
    }

    private void initTextView()
    {
        workingsTV = (TextView)findViewById(R.id.workingsTextView);
        resultsTV = (TextView)findViewById(R.id.resultsTextView);
    }

    private void setWorkings(String givenValue)
    {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equalsOnCLick(View view)
    {
        Double result = null;
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("rhino");

        try {
            result = (double) engine.eval(workings);
        }
        catch(ScriptException ex){
            Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null){
            resultsTV.setText(String.valueOf(result.doubleValue()));
        }
    }

    public void clearOnClick(View view)
    {
        workingsTV.setText("Enter Expression");
        resultsTV.setText("Answer");
        workings = "";
    }

    //there should be separate buttons for nested parenthesesy
    public void bracketsOnClick(View view)
    {
        if (b == false)
        {
            setWorkings("(");
            b = true;
        }
        else
        {
            setWorkings(")");
            b = false;
        }

    }

    public void percentageOnClick(View view)
    {
        setWorkings(" % ");
    }

    public void divideOnClick(View view)
    {
        setWorkings(" / ");
    }

    public void multiplyOnClick(View view)
    {
        setWorkings(" * ");
    }

    public void subtractOnClick(View view)
    {
        setWorkings(" - ");
    }

    public void addOnClick(View view)
    {
        setWorkings(" + ");
    }

    public void decimalOnClick(View view)
    {
        setWorkings(".");
    }

    public void zeroOnClick(View view)
    {
        setWorkings("0");
    }

    public void oneOnClick(View view)
    {
        setWorkings("1");
    }

    public void twoOnClick(View view)
    {
        setWorkings("2");
    }

    public void threeOnClick(View view)
    {
        setWorkings("3");
    }

    public void fourOnClick(View view)
    {
        setWorkings("4");
    }

    public void fiveOnClick(View view)
    {
        setWorkings("5");
    }

    public void sixOnClick(View view)
    {
        setWorkings("6");
    }

    public void sevenOnClick(View view)
    {
        setWorkings("7");
    }

    public void eightOnClick(View view)
    {
        setWorkings("8");
    }

    public void nineOnClick(View view)
    {
        setWorkings("9");
    }

    public void signOnClick(View view)
    {
        setWorkings("0");
    }

    public void backspaceOnClick(View view)
    {
        if(workings.length() > 0)
        {
            workings = workings.substring(0, workings.length() - 1);
        }
        else
        {
            workings = "Enter Expression";
        }
        workingsTV.setText(workings);
    }
}