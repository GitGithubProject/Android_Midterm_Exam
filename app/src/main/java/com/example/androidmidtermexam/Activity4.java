package com.example.androidmidtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    TextView bankName, acctNumber, balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        bankName = findViewById(R.id.txtBankNameFromActivity3);

        acctNumber = findViewById(R.id.txtAcctNoFromActivity3);

        balance = findViewById(R.id.txtBalanceFromActivity3);

        Account acctInfo = getIntent().getParcelableExtra("acctInfo");


        balance.setText(Double.toString(acctInfo.getBalance()));
        acctNumber.setText(Integer.toString(acctInfo.getAccountNumber()));
        bankName.setText(acctInfo.getBankName());
    }
}