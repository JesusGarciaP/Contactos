package com.example.contactos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivitySecond extends AppCompatActivity {

EditText txtUser, txtEmail, txtTwitter, txtTelefono, txtFechaNac;
Button btnGuardar, btnCancel;
Intent i;
private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_segundo);
        txtUser = findViewById(R.id.txtUsuario);
        txtEmail = findViewById(R.id.txtEmail);
        txtTwitter = findViewById(R.id.txtTwitter);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtFechaNac = findViewById(R.id.txtFechaNac);

        i=getIntent();


        btnGuardar = findViewById(R.id.btnGuardarC);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ActivitySecond.this,"hola"+txtUser.getText().toString(),Toast.LENGTH_LONG).show();
                setResult(RESULT_OK);
                finish();
            }
        });
    }




    public void btnCancel_click(View v){
        Intent i = new Intent();
        //i.putExtra("error", "numero no disponible");
        setResult(RESULT_CANCELED,i);
        finish();
    }
}
