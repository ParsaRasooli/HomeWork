package com.parsa.tasks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//sakht edittext
         final EditText txtName = findViewById(R.id.txtName);
         final EditText txtAge = findViewById(R.id.txtAge);
         final EditText txtEmail = findViewById(R.id.txtEmail);
         final  EditText txtPhone = findViewById(R.id.txtphone);

//button submir => check kardan por bodane hameye field ha va ersal be activity badi
        Button BtnSubmit = findViewById(R.id.BtnSubmit);
        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check kardane por ya khali bodane textview ha va send kardan be activity confirm

                if (txtName.length()!=0&&txtAge.length()!=0&&txtEmail.length()!=0&&txtPhone.length()!=0)
                {
                    Intent intent = new Intent(MainActivity.this, CofirmActivity.class);
                    intent.putExtra("txtname", txtName.getText().toString());
                    intent.putExtra("txtemail", txtEmail.getText().toString());
                    intent.putExtra("txtphone", txtPhone.getText().toString());
                    intent.putExtra("txtage", txtAge.getText().toString());
                    startActivityForResult(intent, 1);



                }
                else
                    {
                        Toast.makeText(MainActivity.this, "Need to enter your info completely", Toast.LENGTH_SHORT).show();
                    }

            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1)
        {
            //check krdn okay bodan ya hamon click shodan roye button yes va bargasht be activity main va defualt krdn meghdar viewtext ha
            if (resultCode == Activity.RESULT_OK) {
                EditText txtName = findViewById(R.id.txtName);
                EditText txtAge = findViewById(R.id.txtAge);
                EditText txtEmail = findViewById(R.id.txtEmail);
                EditText txtPhone = findViewById(R.id.txtphone);
                txtName.setText("");
                txtEmail.setText("");
                txtAge.setText("");
                txtPhone.setText("");
                String txtresult = data.getStringExtra("result");
                Toast.makeText(this, txtresult, Toast.LENGTH_SHORT).show();

            }
            else
                {
                    Toast.makeText(this, data.getStringExtra("result").toString(), Toast.LENGTH_SHORT).show();
                }

        }
    }
}
