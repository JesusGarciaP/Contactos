package com.example.contactos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button btnAdd;
private RecyclerView recyclerView;
private RecyclerView.Adapter mAdapter;
private RecyclerView.LayoutManager layoutManager;

ArrayList<String> lista = new ArrayList<>();
Contacto nuevoContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAgregarC);

        recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivitySecond.class);
                startActivityForResult(intent,1000);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {

            nuevoContacto = (Contacto) data.getParcelableExtra("Parcelable");
            String usuario = nuevoContacto.getUsuario();
            String email = nuevoContacto.getEmail();
            String twitter = nuevoContacto.getTwitter();
            String telefono = nuevoContacto.getTelefono();
            String fechaNacimiento = nuevoContacto.getFechaNac();

            Toast.makeText(MainActivity.this, "Usuario: " + usuario + "\n"
                    + "Email: " + email + "\n"
                    + "Twitter: " + twitter + "\n"
                    + "Teléfono: " + telefono + "\n"
                    + "Fecha de nacimiento: " + fechaNacimiento, Toast.LENGTH_LONG).show();

            lista.add("Usuario: "+usuario + "   Correo: " + email);
            mAdapter = new MyAdapter(lista, this);
            recyclerView.setAdapter(mAdapter);

        } else {
            Toast.makeText(MainActivity.this, "La creacion del contacto ha sido cancelada",
                    Toast.LENGTH_LONG).show();
        }
    }

}
