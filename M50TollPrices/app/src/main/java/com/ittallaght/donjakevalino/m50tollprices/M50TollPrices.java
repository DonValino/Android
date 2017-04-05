package com.ittallaght.donjakevalino.m50tollprices;

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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class M50TollPrices extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    private M50Toll toll;
    Spinner vehicleTypeSpinner;
    List<VehicleType> types;
    String vehicleType;
    TextView answerTitleText;
    TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m50_toll_prices);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vehicleTypeSpinner = (Spinner) findViewById(R.id.vehicleTypeSpinner);

        types = new ArrayList<VehicleType>();
        types.add(VehicleType.Cars);
        types.add(VehicleType.Busses);
        types.add(VehicleType.HGV);
        types.add(VehicleType.Service);

        ArrayAdapter<VehicleType> adapter = new ArrayAdapter<VehicleType>(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(adapter);

        vehicleTypeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_m50_toll_prices, menu);
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

    public void calculate(View v) throws ParseException {
        VehicleType type = VehicleType.valueOf(vehicleType);

        java.util.Date date = new java.util.Date();

        toll = new M50Toll(type, date);
        toll.calculate();

        answerTitleText = (TextView) findViewById(R.id.answerTitleTextView);
        answerTitleText.setText("Cost: ");
        answerText = (TextView) findViewById(R.id.answerTextView);
        answerText.setText("€ "+ toll.getCost());



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        vehicleType = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
