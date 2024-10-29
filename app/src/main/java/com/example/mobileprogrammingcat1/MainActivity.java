package com.example.mobileprogrammingcat1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText hours;
    EditText rate;
    TextView total;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        hours = (EditText)(findViewById(R.id.etHours));
        rate = (EditText)(findViewById(R.id.etRate)) ;
        total=(TextView)findViewById(R.id.tvTotal);
        button=(Button)findViewById(R.id.buttonCalc);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Double NoHours = Double.parseDouble(hours.getText().toString());
             Double NoRate = Double.parseDouble(rate.getText().toString());
             double wages = NoHours * NoRate;
             total.setText(Double.toString(wages));

         }
     });

    }
}