package com.parsa.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CofirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofirm);

        // Tarif textview ha  baraye confirmation

        TextView txtNameConfirm = findViewById(R.id.txtNameConfirm);
        TextView txtEmailConfirm = findViewById(R.id.txtEmailconfirm);
        TextView txtAgeConfirm = findViewById(R.id.txtAgeConfirm);
        TextView txtPhoneConfirm = findViewById(R.id.txtPhoneConfirm);

        //tarif btn haye yes va no

        Button BtnYes = findViewById(R.id.BtnYes);
        Button BtnNo = findViewById(R.id.BtnNo);

        //Run shodne activity va gereftan meghdar va set kardan be textview haye confirmation

        Intent intent = getIntent() ;
        txtNameConfirm.setText(intent.getStringExtra("txtname"));
        txtEmailConfirm.setText(intent.getStringExtra("txtemail"));
        txtAgeConfirm.setText(intent.getStringExtra("txtage"));
        txtPhoneConfirm.setText(intent.getStringExtra("txtphone"));

        //BtnYes

        BtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","You signed up succesfully !");
                setResult(CofirmActivity.RESULT_OK,returnIntent);
                finish();
            }
        });

        BtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","You can change your info");
                setResult(CofirmActivity.RESULT_CANCELED,returnIntent);
                finish();
            }
        });

    }
}
