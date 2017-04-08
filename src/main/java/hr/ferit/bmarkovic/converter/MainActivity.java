package hr.ferit.bmarkovic.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button bTemp, bDist, bWeight, bVolume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        Button bTemp  = (Button) findViewById(R.id.bTemperature);
        Button bDist  = (Button) findViewById(R.id.bDistance);
        Button bWeight  = (Button) findViewById(R.id.bWeight);
        Button bVolume= (Button) findViewById(R.id.bVolume);
        bTemp.setOnClickListener(this);
        bDist.setOnClickListener(this);
        bWeight.setOnClickListener(this);
        bVolume.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        if ( v.getId() == R.id.bTemperature)
            intent.setClass(getApplicationContext(), Main2Activity.class);
        else if ( v.getId() == R.id.bDistance)
            intent.setClass(getApplicationContext(), Main3Activity.class);
        else if ( v.getId() == R.id.bWeight)
            intent.setClass(getApplicationContext(), Main4Activity.class);
        else if ( v.getId() == R.id.bVolume)
            intent.setClass(getApplicationContext(), Main5Activity.class);

        this.startActivity(intent);
    }
}
