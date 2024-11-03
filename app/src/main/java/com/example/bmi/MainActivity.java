package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt_weight,edt_heightFt,edt_heightIn;
    LinearLayout main;
    Button btn_calculate;
    TextView tv_Result;

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
        initialization();

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(edt_weight.getText().toString());
                int heightFt = Integer.parseInt(edt_heightFt.getText().toString());
                int heightInch = Integer.parseInt(edt_heightIn.getText().toString());

                int totalInch = heightFt * 12 + heightInch;
                double totalCm = totalInch * 2.53;
                double totalM = totalCm / 100;
                double bmi = weight / (totalM * totalM);

                if (bmi > 25){
                    tv_Result.setText("You are Over Weight!");
                    main.setBackgroundColor(getResources().getColor(R.color.colorO));
                } else if (bmi < 18) {
                    tv_Result.setText("You are Under Weight!");
                    main.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }else {
                    tv_Result.setText("You are Healthy!");
                    main.setBackgroundColor(getResources().getColor(R.color.colorH));
                }

            }
        });

    }

    private void initialization(){
        edt_heightFt = findViewById(R.id.edt_heightFt);
        edt_weight = findViewById(R.id.edt_weight);
        edt_heightIn = findViewById(R.id.edt_heightIn);
        main = findViewById(R.id.main);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_Result = findViewById(R.id.tv_Result);
    }
}