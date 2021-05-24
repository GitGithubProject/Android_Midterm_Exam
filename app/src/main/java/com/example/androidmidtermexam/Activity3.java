package com.example.androidmidtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button submitBtn = (Button)findViewById(R.id.btnSubmitToMain);

        Button submitBtn4 = (Button)findViewById(R.id.btnSubmitActivity4);

        EditText acctNumber1 = findViewById(R.id.txtAccountNumber);
        EditText acctBalance = findViewById(R.id.txtBalance);
        EditText acctBankName = findViewById(R.id.txtBankName);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = acctBankName.getText().toString();
                double balance = Double.valueOf(acctBalance.getText().toString());
                int acctNumber = Integer.parseInt(acctNumber1.getText().toString());

                Account acctInfo = new Account(name, balance, acctNumber);

                Intent  intent = new Intent(Activity3.this, MainActivity.class);

                intent.putExtra("acctInfo",acctInfo);



                startActivity(intent);
            }
        });

        submitBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = acctBankName.getText().toString();
                double balance = Double.valueOf(acctBalance.getText().toString());
                int acctNumber = Integer.parseInt(acctNumber1.getText().toString());

                Account acctInfo = new Account(name, balance, acctNumber);

                Intent  intent = new Intent(Activity3.this, Activity4.class);

                intent.putExtra("acctInfo",acctInfo);



                startActivity(intent);
            }
        });
    }
}