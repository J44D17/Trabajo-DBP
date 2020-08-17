package com.example.edward.carteraclientes;

import android.content.Intent;
import android.os.Bundle;

import com.example.edward.carteraclientes.BaseDatos.DatosOpenHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buscar extends AppCompatActivity implements View.OnClickListener {
    Button btnBuscar, btnEliminar;
    EditText Bnombre, Bdireccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bnombre=(EditText)findViewById(R.id.Bnombre);
        Bdireccion=(EditText)findViewById(R.id.Bdireccion);
        btnBuscar=(Button)findViewById(R.id.btnBuscar2);
        //btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnBuscar.setOnClickListener(this);
      //  btnEliminar.setOnClickListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnBuscar.setOnClickListener(new  View.OnClickListener(){
            public void onClick(View v){
                DatosOpenHelper db = new DatosOpenHelper(getApplicationContext(),null,null,1);
                String  buscar = Bnombre.getText().toString();
                String  buscard = Bdireccion.getText().toString();
                String mon ="";
                Bundle parametros = new Bundle();
                parametros.putString("nom", buscar);

                int a;
                a=db.buscar_reg(buscar,buscard,mon);
                if (a!=0){
                    Intent it = new Intent(Buscar.this,Inicio.class);
                    it.putExtras(parametros);
                    //it.putExtras(parametrosmo);
                    startActivity(it);
                    Toast.makeText(getApplicationContext(),"sesion iniciada",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}