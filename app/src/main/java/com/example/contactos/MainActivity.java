package com.example.contactos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button btnAdd;
private RecyclerView recyclerView;
//private RecyclerView.Adapter mAdapter;
private MyAdapter myAdapter;
private RecyclerView.LayoutManager layoutManager;
private ArrayList<Contacto> listContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAgregarC);

        createListContacto();
        buildRecyclerView();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivitySecond.class);
                //intent.putExtra("Contacto",listContact.get(position));
                startActivityForResult(intent,1000);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000){
            if (requestCode==RESULT_OK){
                //Toast.makeText(this,"Mensaje enviado exitoso", Toast.LENGTH_LONG).show();
                //Contacto c = new Contacto();
                //ActivitySecond as = new ActivitySecond();

                //c.usuario=as.txtUser.getText().toString();
                //c.email=as.txtEmail.getText().toString();
                //c.twitter=as.txtTwitter.getText().toString();
                //c.telefono=as.txtTelefono.getText().toString();
                //c.fechaNac=as.txtFechaNac.getText().toString();
                //myAdapter = new MyAdapter();
                //MyAdapter m = new MyAdapter();
                //m.mdataSet.add(c);
                //recyclerView.setAdapter(m);
            }else if(resultCode==RESULT_CANCELED){
                //Toast.makeText(this, "mensaje no eviado"+ "Error: "+data.getStringExtra("error"),Toast.LENGTH_LONG).show();
            }
        }
    }

    public void createListContacto(){
        listContact = new ArrayList<>();
        Contacto c = new Contacto();
        ActivitySecond as = new ActivitySecond();

        c.usuario=as.txtUser.getText().toString();
        c.email=as.txtEmail.getText().toString();
        c.twitter=as.txtTwitter.getText().toString();
        c.telefono=as.txtTelefono.getText().toString();
        c.fechaNac=as.txtFechaNac.getText().toString();
        listContact.add(c);
    }

    public void buildRecyclerView(){
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        myAdapter= new MyAdapter(listContact);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this,ActivitySecond.class);
                intent.putExtra("Contacto", listContact.get(position));
                startActivity(intent);
            }
        });


    }
}
