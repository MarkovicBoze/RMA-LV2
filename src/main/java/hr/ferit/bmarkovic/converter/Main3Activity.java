package hr.ferit.bmarkovic.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main3Activity extends Activity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main3);
        setupUI();
        this.spinner1();
        this.spinner2();
    }

    private void spinner2() {
        Spinner spinner2 = (Spinner) findViewById(R.id.spDist2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spDist, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
    }

    private void spinner1() {
        Spinner spinner1 = (Spinner) findViewById(R.id.spDist);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spDist, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }

    private void setupUI() {
        this.startvalue = (EditText) findViewById(R.id.etDist);
        this.convert = (Button) findViewById(R.id.bConvert);
        this.convert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Spinner spinner1 = (Spinner) findViewById(R.id.spDist);
        Spinner spinner2 = (Spinner) findViewById(R.id.spDist2);
        double input = Double.parseDouble(startvalue.getText().toString());
        String sp1 = spinner1.getSelectedItem().toString();
        String sp2 = spinner2.getSelectedItem().toString();

        switch (sp1){

            case "kilometer":
                if(!sp2.equals("kilometer"))
                    output  = ( sp2.equals("mile"))?  input *0.62137 :  input * 0.53996;
                else output=input;
                break;
            case "mile":
                if(!sp2.equals("mile"))
                    output  = ( sp2.equals("kilometer"))? input *1.609 : input *0.869;
                else output=input;
                break;
            case "nautic mile":
                if(!sp2.equals("nautic mile"))
                    output  = ( sp2.equals("kilometer"))?  input *1.852 : input *1.15078;
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
