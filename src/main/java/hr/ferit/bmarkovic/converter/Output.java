package hr.ferit.bmarkovic.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static hr.ferit.bmarkovic.converter.Main2Activity.OUTPUTUNIT;
import static hr.ferit.bmarkovic.converter.Main2Activity.OUTPUTVALUE;
import static hr.ferit.bmarkovic.converter.Main2Activity.STARTUNIT;
import static hr.ferit.bmarkovic.converter.Main2Activity.STARTVALUE;

public class Output extends Activity {

    TextView inputvalue,inputunit,outputvalue,outputunit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        setupUI();
    }

    private void setupUI() {

        this.inputvalue = (TextView) findViewById(R.id.tvValue1);
        this.inputunit = (TextView) findViewById(R.id.tvUnit1);
        this.outputvalue = (TextView) findViewById(R.id.tvValue2);
        this.outputunit = (TextView) findViewById(R.id.tvUnit2);

        Intent startingIntent = this.getIntent();
        if(startingIntent.hasExtra(STARTVALUE)){
            String inputData = startingIntent.getStringExtra(STARTVALUE);
            inputvalue.setText(inputData);
        }
        if(startingIntent.hasExtra(STARTUNIT)){
            String inputUnit = startingIntent.getStringExtra(STARTUNIT);
            inputunit.setText(inputUnit);
        }
        if(startingIntent.hasExtra(OUTPUTVALUE)){
            String convertedData = startingIntent.getStringExtra(OUTPUTVALUE);
            outputvalue.setText(convertedData);
        }
        if(startingIntent.hasExtra(OUTPUTUNIT)){
            String convertedUnit = startingIntent.getStringExtra(OUTPUTUNIT);
            outputunit.setText(convertedUnit);
        }


    }
}
