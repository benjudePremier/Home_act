package com.example.home_act;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import Models.Clientes;

public class firebase_act extends AppCompatActivity {
    // Declaraciones de variables
    private EditText ednombre, eddestino, edpromocion;
    private Button btn;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        // Llmo aqui los elementos por id
        ednombre = (EditText) findViewById(R.id.etnombre);
        eddestino = (EditText) findViewById(R.id.etdestino);
        edpromocion = (EditText) findViewById(R.id.etpromocion);
        btn = (Button) findViewById(R.id.button9);


        inicializarFireBase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!ednombre.equals("")) {
                    Clientes c = new Clientes();

                    c.setId(UUID.randomUUID().toString());
                    c.setNombre(ednombre.getText().toString());
                    c.setDestino(eddestino.getText().toString());
                    c.setPromocion(edpromocion.getText().toString());

                    databaseReference.child("Clientes").child(c.getId()).setValue(c);

                    Toast.makeText(getBaseContext(), "Se ha guardo un cliente", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getBaseContext(), "No se ha guardado", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    // Obtengo la intencia de mi base de datos cloud
    public void inicializarFireBase() {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}

