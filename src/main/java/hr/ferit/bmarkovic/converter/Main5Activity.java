package hr.ferit.bmarkovic.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main5Activity extends Activity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main5);
        setupUI();
        this.spinner1();
        this.spinner2();
    }

    private void spinner2() {
        Spinner spinner2 = (Spinner) findViewById(R.id.spVolume2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spVolume, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
    }

    private void spinner1() {
        Spinner spinner1 = (Spinner) findViewById(R.id.spVolume);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spVolume, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }

    private void setupUI() {
        this.startvalue = (EditText) findViewById(R.id.etVolume);
        this.convert = (Button) findViewById(R.id.bConvert);
        this.convert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Spinner spinner1 = (Spinner) findViewById(R.id.spVolume);
        Spinner spinner2 = (Spinner) findViewById(R.id.spVolume2);
        double input = Double.parseDouble(startvalue.getText().toString());
        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        switch (sp1){

            case "liter":
                if(!sp2.equals("liter"))
                    output  = ( sp2.equals("barrel"))?  input *0.00629 :  input /1000;
                else output=input;
                break;
            case "barrel":
                if(!sp2.equals("barrel"))
                    output  = ( sp2.equals("liter"))? input *158.99 : input *0.15899;
                else output=input;
                break;
            case "cubic meter":
                if(!sp2.equals("cubic meter"))
                    output  = ( sp2.equals("liter"))?  input *1000 : input *6.2898;
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
