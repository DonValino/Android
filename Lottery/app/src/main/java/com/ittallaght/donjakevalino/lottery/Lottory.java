package com.ittallaght.donjakevalino.lottery;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Lottory extends AppCompatActivity {

    ArrayList<Integer> lottoNumbers;
    Random randomGenerator;
    boolean alreadyInTheArray;
    int newNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        randomGenerator = new Random();
        lottoNumbers = new ArrayList<Integer>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lottory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // generate the numbers
    public void generate(View v)
    {
        lottoNumbers = new ArrayList<Integer>();

        alreadyInTheArray = false;

        while(lottoNumbers.size() < 6)
        {
            alreadyInTheArray = false;
            // Generate the next number 1 - 45
            newNumber = randomGenerator.nextInt((45 - 1) + 1) + 1;

            for(int i = 0; i < lottoNumbers.size(); i++)
            {
                if(lottoNumbers.get(i) == newNumber)
                {
                    alreadyInTheArray = true;
                }
            }

            if(alreadyInTheArray == false)
            {
                lottoNumbers.add(newNumber);
            }
        }
        // Bubble Sort
        this.bubbleSort();
        // Display Data
        this.displayData();
    }

    public void bubbleSort()
    {
        int n = lottoNumbers.size();
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (lottoNumbers.get(j - 1) > lottoNumbers.get(j)) {
                    temp = lottoNumbers.get(j - 1);
                    lottoNumbers.set(j - 1,lottoNumbers.get(j));
                    lottoNumbers.set(j,temp);
                }

            }
        }
    }

    public void displayData()
    {
        TextView descriptionText = (TextView) findViewById(R.id.description);

        TextView resultText = (TextView) findViewById(R.id.results);

        // Displaying the Data
        for(int i = 0; i < lottoNumbers.size(); i++)
        {
            if(i == 0)
            {
                descriptionText.setText("Generating Numbers From 1 - 45: ");
                resultText.setText(lottoNumbers.get(i) + ", ");
            }else
            {
                if(i == 5)
                {
                    resultText.append(lottoNumbers.get(i) + "");
                }else
                {
                    resultText.append(lottoNumbers.get(i) + ", ");
                }

            }
        }
    }

    // generate the numbers
    public void clearResult(View v)
    {
        if(lottoNumbers != null) {
            TextView resultText = (TextView) findViewById(R.id.results);
            TextView descriptionText = (TextView) findViewById(R.id.description);
            descriptionText.setText("");
            resultText.setText("");
            lottoNumbers.clear();
        }
    }
}
