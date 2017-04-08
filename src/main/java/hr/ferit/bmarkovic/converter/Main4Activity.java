package hr.ferit.bmarkovic.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main4Activity extends Activity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main4);
        setupUI();
        this.spinner1();
        this.spinner2();
    }

    private void spinner2() {
        Spinner spinner2 = (Spinner) findViewById(R.id.spWeight2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spWeight, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
    }

    private void spinner1() {
        Spinner spinner1 = (Spinner) findViewById(R.id.spWeight);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spWeight, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }

    private void setupUI() {
        this.startvalue = (EditText) findViewById(R.id.etWeight);
        this.convert = (Button) findViewById(R.id.bConvert);
        this.convert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Spinner spinner1 = (Spinner) findViewById(R.id.spWeight);
        Spinner spinner2 = (Spinner) findViewById(R.id.spWeight2);
        double input = Double.parseDouble(startvalue.getText().toString());
        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        switch (sp1){

            case "kilogram":
                if(!sp2.equals("kilogram"))
                    output  = ( sp2.equals("gram"))?  input *1000 :  input * 2.2046;
                else output=input;
                break;
            case "gram":
                if(!sp2.equals("gram"))
                    output  = ( sp2.equals("kilogram"))? input /1000 : input * 0.0022046;
                else output=input;
                break;
            case "pound":
                if(!sp2.equals("pound"))
                    output  = ( sp2.equals("gram"))?  input *453.592 : input * 0.453592;
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
