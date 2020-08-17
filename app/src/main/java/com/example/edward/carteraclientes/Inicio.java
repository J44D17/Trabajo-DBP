package com.example.edward.carteraclientes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edward.carteraclientes.BaseDatos.DatosOpenHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
    Button btnRecargar,btnSalir,btnSaldo,ComprarLap,ComprarMando,ComprarCel, ComprarPc,Qlap,QCel,QMando,Qpc;
    TextView Bnombre,nombreusuario,PrecioLap,lapcom,celcom,compucom,mandocom,total;
    private ArrayAdapter<String> adaptador;

    private SQLiteDatabase conexion;
    private DatosOpenHelper datosOpenHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnRecargar = (Button) findViewById(R.id.btnRecargar);
        btnSaldo = (Button) findViewById(R.id.btnSaldo);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        Bnombre=(TextView)findViewById(R.id.Monedas);
        nombreusuario=(TextView)findViewById(R.id.nombreusuario);
        ComprarLap=(Button)findViewById(R.id.ComprarLap);
        PrecioLap=(TextView)findViewById(R.id.preciolap);
        lapcom=(TextView)findViewById(R.id.lapcom);
        celcom=(TextView)findViewById(R.id.celcom);
        compucom=(TextView)findViewById(R.id.compucom);
        mandocom=(TextView)findViewById(R.id.mandocom);
        total=(TextView)findViewById(R.id.total);
        ComprarCel=(Button)findViewById(R.id.ComprarCel);
        ComprarPc=(Button)findViewById(R.id.ComprarPc);
        ComprarMando=(Button)findViewById(R.id.ComprarMando);
        QCel=(Button)findViewById(R.id.QCel);
        Qlap=(Button)findViewById(R.id.QLap);
        QMando=(Button)findViewById(R.id.QMando);
        Qpc=(Button)findViewById(R.id.QPc);

        ComprarLap.setOnClickListener(this);
        ComprarCel.setOnClickListener(this);
        ComprarPc.setOnClickListener(this);
        ComprarMando.setOnClickListener(this);
        btnRecargar.setOnClickListener(this);
        btnSaldo.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
        Qpc.setOnClickListener(this);
        QMando.setOnClickListener(this);
        Qlap.setOnClickListener(this);
        QCel.setOnClickListener(this);

        Bundle parametros = this.getIntent().getExtras();
        final String buscar = parametros.getString("nom");
        nombreusuario.setText(buscar);

        String bd;
        DatosOpenHelper db = new DatosOpenHelper(getApplicationContext(),null,null,1);
        String  b =buscar;
        String[] datos;
        datos=db.buscar_reg2(b);
        Bnombre.setText(datos[0]);
        Toast.makeText(getApplicationContext(),"hola "+buscar+"!",Toast.LENGTH_SHORT).show();

        btnSaldo.setOnClickListener(new  View.OnClickListener(){
            public void onClick(View v){
                String bd;
                DatosOpenHelper db = new DatosOpenHelper(getApplicationContext(),null,null,1);
                String  b =buscar;
                String[] datos;
                datos=db.buscar_reg2(b);
                Bnombre.setText(datos[0]);

            }
        });


    }



    int w=0,l=0,c=0,p=0,m=0;
    @Override
    public void onClick(View view) {
       //int ;
       switch (view.getId()){
            case R.id.btnSalir:
                Intent i = new Intent(Inicio.this,ActMain.class);
                startActivity(i);
                finish();
                break;
           /*case R.id.btnSaldo:
               String bd;
               DatosOpenHelper db = new DatosOpenHelper(getApplicationContext(),null,null,1);
              // String  b =Usuario.getText().toString();
               String  b =buscar;
               String[] datos;
               datos=db.buscar_reg2(b);
               Bnombre.setText(datos[0]);
               nombreusuario.setText(datos[1]);
               Toast.makeText(getApplicationContext(),datos[2],Toast.LENGTH_SHORT).show();
               break;*/
           case R.id.btnRecargar:
               Intent i2 = new Intent(Inicio.this,Recaragar.class);
               startActivity(i2);

               break;
           case R.id.ComprarLap:
               w=w+2200;
               l++;
              lapcom.setText("Laptop agregada al Carrito("+l+")");
               break;
           case R.id.ComprarCel:
               w=w+850;
               c++;
               celcom.setText("Celular agregado al Carrito("+c+")");
               break;
           case R.id.ComprarPc:
               w=w+3400;
               p++;
               compucom.setText("PC agregada al Carrito("+p+")");
                break;
           case R.id.ComprarMando:
               w=w+200;
               m++;
               mandocom.setText("Mando agregado al Carrito("+m+")");
               break;
           case R.id.QCel:
               if (c>=1) {
                   c=c-1;
                   w = w - 850;
                   celcom.setText("Celular agregado al Carrito("+c+")");

               }else{
                   celcom.setText("Celular agregado al Carrito("+c+")");
               }

               break;
           case R.id.QLap:
               if (l>=1) {
                   l=l-1;
                   w = w - 2200;
                   lapcom.setText("Laptop agregado al Carrito("+l+")");

               }else{
                   lapcom.setText("Laptop agregado al Carrito("+l+")");
               }
               break;
           case R.id.QMando:
               if (m>=1) {
                   m=m-1;
                   w = w - 200;
                   mandocom.setText("Mando agregado al Carrito("+m+")");

               }else{
                   mandocom.setText("Mando agregado al Carrito("+m+")");
               }
               break;
           case R.id.QPc:
               if (p>=1) {
                   p=p-1;
                   w = w - 3400;
                   compucom.setText("Pc agregado al Carrito("+p+")");

               }else{
                   compucom.setText("Pc agregado al Carrito("+p+")");
               }
               break;
        }
       //w=c+l+m+p;
        total.setText("TOTAL                      :"+w);

    }
}