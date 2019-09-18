package com.example.contactos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ActivitySecond extends AppCompatActivity {

    Button btn;
    EditText txtUsuario, txtEmail, txtTwitter, txtTelefono, txtFechaNac;
    Intent i;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_segundo);
        btn = findViewById(R.id.btnGuardarC);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtEmail = findViewById(R.id.txtEmail);
        txtTwitter = findViewById(R.id.txtTwitter);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtFechaNac = findViewById(R.id.txtFechaNac);


        i = getIntent();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Contacto nuevoContacto = new Contacto(
                        txtUsuario.getText().toString(),
                        txtEmail.getText().toString(),
                        txtTwitter.getText().toString(),
                        txtTelefono.getText().toString(),
                        txtFechaNac.getText().toString());
                Bundle b = new Bundle();
                b.putParcelable("Parcelable", nuevoContacto);
                i.putExtras(b);
                setResult(MainActivity.RESULT_OK, i);
                finish();
            }
        });
    }

    public void btnCancel_click(View v){
        Intent i = new Intent();
        //i.putExtra("error", "Numero no disponible");
        setResult(RESULT_CANCELED  , i );
        finish();

    }

}
