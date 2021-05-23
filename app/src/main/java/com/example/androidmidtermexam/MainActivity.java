package com.example.androidmidtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonHandler btnhandler = new ButtonHandler();

        Button btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity2.setOnClickListener(btnhandler);

        Button btnActivity3 = findViewById(R.id.btnActivity3);
        btnActivity3.setOnClickListener(btnhandler);

    }
    //define OnClickEvent
    private class ButtonHandler implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //all the button clicks end up here

            if(view.getId()==R.id.btnActivity2){

                Intent intent = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);

            }else if(view.getId()==R.id.btnActivity3){
                Intent intent = new Intent(MainActivity.this,Activity3.class);
                startActivity(intent);

            }
        }
    }
}