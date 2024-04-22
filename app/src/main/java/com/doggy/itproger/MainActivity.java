package com.doggy.itproger;

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

    private EditText num_level, num_temp;
    private TextView level, litr, litr20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        num_level = findViewById(R.id.num_level);
        num_temp = findViewById(R.id.num_temp);
        Button button = findViewById(R.id.button);
        level = findViewById(R.id.level);
        litr = findViewById(R.id.litr);
        litr20 = findViewById(R.id.litr20);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float lev = Float.parseFloat(num_level.getText().toString());
                float temp = Float.parseFloat(num_temp.getText().toString());
                float res_lev_nado = (float) (40 - (30 - temp) * 0.6);
                float res_lev_razn = res_lev_nado - lev;
                float res_litr = (float) (res_lev_razn / 5 * 0.21 * 112);
                float res_litr20 = (float) (res_litr * 1.2);

                level.setText(String.valueOf(res_lev_nado));
                litr.setText(String.valueOf(res_litr));
                litr20.setText(String.valueOf(res_litr20));

            }
        });
    }
}