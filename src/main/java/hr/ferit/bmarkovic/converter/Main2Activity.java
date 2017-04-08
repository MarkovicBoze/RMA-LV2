package hr.ferit.bmarkovic.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main2Activity extends Activity implements View.OnClickListener {

    public static final String STARTVALUE = "startValue";
    public static final String STARTUNIT = "startUnit";
    public static final String OUTPUTVALUE = "outputValue";
    public static final String OUTPUTUNIT = "outputUnit";


    EditText startvalue;
    double output;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupUI();
        this.spinner1();
        this.spinner2();
    }

    private void spinner2() {
        Spinner spinner2 = (Spinner) findViewById(R.id.spTemp2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spTemp, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
    }

    private void spinner1() {
        Spinner spinner1 = (Spinner) findViewById(R.id.spTemp1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spTemp, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }

    private void setupUI() {
        this.startvalue = (EditText) findViewById(R.id.etTemp);
        this.convert = (Button) findViewById(R.id.bConvert);
        this.convert.setOnClickListener(this);
       
    }

    @Override
    public void onClick(View v) {

        Spinner spinner1 = (Spinner) findViewById(R.id.spTemp1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spTemp2);
        double input = Double.parseDouble(startvalue.getText().toString());
        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        switch (sp1){

            case "Kelvin":
                if(!sp2.equals("Kelvin"))
                    output  = ( sp2.equals("Celsius"))?  input - 273.15 :  input * 9 / 5 - 459.67;
                else output=input;
                break;
            case "Celsius":
                if(!sp2.equals("Celsius"))
                    output  = ( sp2.equals("Kelvin"))? input + 273.15 : input * 1.8 - 32;
                else output=input;
                break;
            case "Fahrenheit":
                if(!sp2.equals("Fahrenheit  "))
                    output  = ( sp2.equals("Celsius"))?  (input - 32) / 1.8 : (input + 459.67) * 5 / 9;
                else output=input;
                break;

        }

        Intent resultact = new Intent(getApplicationContext(), Output.class);
        resultact.putExtra(STARTVALUE, String.valueOf(input));
        resultact.putExtra(STARTUNIT, sp1);
        resultact.putExtra(OUTPUTVALUE, String.valueOf(output));
        resultact.putExtra(OUTPUTUNIT, sp2);
        this.startActivity(resultact);


    }
}
