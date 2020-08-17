package com.example.edward.carteraclientes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.edward.carteraclientes.BaseDatos.DatosOpenHelper;

import java.util.ArrayList;

public class Recaragar extends AppCompatActivity implements View.OnClickListener {
    Button btnRecargar2;
    EditText Rusuario,Rcodigo,Rcantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recaragar);
        btnRecargar2=(Button)findViewById(R.id.btnRecargar2);
        Rusuario=(EditText)findViewById(R.id.Rusuario);
        Rcodigo=(EditText)findViewById(R.id.RCodigo);
        Rcantidad=(EditText)findViewById(R.id.Rcantidad);

        btnRecargar2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnRecargar2:
                    DatosOpenHelper db = new DatosOpenHelper(getApplicationContext(), null, null, 1);
                    String buscar2 = Rusuario.getText().toString();
                    String cantidad =Rcantidad.getText().toString();
                    String codigo = Rcodigo.getText().toString();
                    if (codigo.equals("20011022")) {
                      String mensaje = db.Recargar(buscar2, cantidad, codigo);
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getApplicationContext(), "Codigo Incorrecto", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

    }
}