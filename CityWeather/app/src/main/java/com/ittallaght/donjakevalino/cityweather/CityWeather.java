package com.ittallaght.donjakevalino.cityweather;

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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class CityWeather extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView weatherConditionPic;
    Spinner spinner;
    TextView temp;

    public ArrayList<WeatherInformation> citiesWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);

        citiesWeather = new ArrayList<WeatherInformation>();

        // Populate the city weather
        citiesWeather.add(new WeatherInformation("Dublin", 18, WeatherCondition.Cloudy));
        citiesWeather.add(new WeatherInformation("Manila", 30, WeatherCondition.Sunny));
        citiesWeather.add(new WeatherInformation("LA", 25, WeatherCondition.Rainy));

        spinner = (Spinner) findViewById(R.id.citiesSpinner);

        List<String> cities = new ArrayList<String>();
        for(int i = 0; i < citiesWeather.size(); i++)
        {
            cities.add(citiesWeather.get(i).GetCity());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // hook in handler for selections on spinner
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_city_weather, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long ll) {

        String city = parent.getItemAtPosition(position).toString();
        temp = (TextView) findViewById(R.id.temp);
        weatherConditionPic = (ImageView) findViewById(R.id.weatherConditionPic);

        for(WeatherInformation w : citiesWeather)
        {
            if(w.GetCity().equalsIgnoreCase(city))
            {
                temp.setText("Temperature:" + w.GetTemperature() + "°C");

                if(w.GetCityCondition() == WeatherCondition.Cloudy)
                {
                    weatherConditionPic.setImageResource(R.drawable.cloudy);
                }else if(w.GetCityCondition() == WeatherCondition.Rainy)
                {
                    weatherConditionPic.setImageResource(R.drawable.rain);
                }else if(w.GetCityCondition() == WeatherCondition.Sunny)
                {
                    weatherConditionPic.setImageResource(R.drawable.sunny);
                }
            }
        }


        /*
        switch (position){
            case 0 :

                Toast.makeText(getApplicationContext(), city, Toast.LENGTH_LONG).show();

                temp.setText("Temperature: 18 °C");
                weatherConditionPic.setImageResource(R.drawable.cloudy);
                break;
            case 1 :
                Toast.makeText(getApplicationContext(), city, Toast.LENGTH_LONG).show();
                temp.setText("Temperature: 30 °C");
                weatherConditionPic.setImageResource(R.drawable.sunny);
                break;
            case 2 :
                Toast.makeText(getApplicationContext(), city, Toast.LENGTH_LONG).show();
                temp.setText("Temperature: 25 °C");
                weatherConditionPic.setImageResource(R.drawable.rain);
                break;
            default:

                break;
        }*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
