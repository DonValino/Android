package com.ittallaght.donjakevalino.insurancequote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InsuranceQuote extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Insurance quote;
    Spinner ageSpinner;
    int age;
    List<Integer> ages;
    EditText numberOfAccedentsEditText;
    CheckBox hasFullLicenseCheckBox;
    private RadioGroup readioComprehensiveGroup;
    private RadioButton radioButtonComprehensive;
    private double quoteEstimate;
    TextView answerTitleText;
    TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_quote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        answerTitleText = (TextView) findViewById(R.id.answerTextTitle);

        answerText = (TextView) findViewById(R.id.answerText);

        quoteEstimate = 0;

        ageSpinner = (Spinner) findViewById(R.id.ageSpinner);

        ages = new ArrayList<Integer>();

        for(int i = 0; i <= 100; i++)
        {
            ages.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, ages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);

        ageSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insurance_quote, menu);
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

    public void calculatePremium(View v)
    {
        readioComprehensiveGroup = (RadioGroup) findViewById(R.id.radioComprehensive);

        // Getting The selected Radio Button from the group
        int selected = readioComprehensiveGroup.getCheckedRadioButtonId();
        radioButtonComprehensive = (RadioButton) findViewById(selected);

        numberOfAccedentsEditText = (EditText) findViewById(R.id.numberOfAccidentEditText);
        hasFullLicenseCheckBox = (CheckBox) findViewById(R.id.fullLicenseCheckBox);

        if(hasFullLicenseCheckBox.isChecked()) {
            if(InsuranceType.valueOf(radioButtonComprehensive.getText().toString()) == InsuranceType.Comprehensive)
            {
                quote = new Insurance(age, Integer.parseInt(numberOfAccedentsEditText.getText().toString()), true, InsuranceType.Comprehensive);
                quoteEstimate = quote.calculateQuote();
            }else if(InsuranceType.valueOf(radioButtonComprehensive.getText().toString()) == InsuranceType.TPFT)
            {
                quote = new Insurance(age, Integer.parseInt(numberOfAccedentsEditText.getText().toString()), true, InsuranceType.TPFT);
                quoteEstimate = quote.calculateQuote();
            }else
            {
                quote = new Insurance(age, Integer.parseInt(numberOfAccedentsEditText.getText().toString()), true, InsuranceType.TP);
                quoteEstimate = quote.calculateQuote();
            }
            answerTitleText.setText("Quote Estimate: ");
            answerText.setText("€ "+quoteEstimate);

        }else
        {
            if(InsuranceType.valueOf(radioButtonComprehensive.getText().toString()) == InsuranceType.Comprehensive)
            {
                quote = new Insurance(age, Integer.parseInt(numberOfAccedentsEditText.getText().toString()), false, InsuranceType.valueOf(radioButtonComprehensive.getText().toString()));
                quoteEstimate = quote.calculateQuote();
            }else if(InsuranceType.valueOf(radioButtonComprehensive.getText().toString()) == InsuranceType.TPFT)
            {
                quote = new Insurance(age, Integer.parseInt(numberOfAccedentsEditText.getText().toString()), false, InsuranceType.TPFT);
                quoteEstimate = quote.calculateQuote();
            }else
            {
                quote = new Insurance(age, Integer.parseInt(numberOfAccedentsEditText.getText().toString()), false, InsuranceType.TP);
                quoteEstimate = quote.calculateQuote();
            }
            answerTitleText.setText("Quote Estimate: ");
            answerText.setText("€ "+quoteEstimate);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        age = Integer.parseInt(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
