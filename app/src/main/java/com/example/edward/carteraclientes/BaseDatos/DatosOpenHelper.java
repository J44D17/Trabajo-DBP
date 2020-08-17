package com.example.edward.carteraclientes.BaseDatos;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatosOpenHelper extends SQLiteOpenHelper{

   public DatosOpenHelper(Context context){
       super(context,"DATOS", null,1);
   }

    public DatosOpenHelper(Context applicationContext, String datos, Object o, int i) {
        super(applicationContext,"DATOS", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       StringBuilder sql = new StringBuilder();
       sql.append("CREATE TABLE IF NOT EXISTS CLIENTE(");
       sql.append("NOMBRE VARCHAR(250), ");
       sql.append("DIRECCION VARCHAR(250), ");
       sql.append("EMAIL VARCHAR(200), ");
       sql.append("TELEFONO VARCHAR(20)) ");

       sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int buscar_reg(String buscar, String buscard,String mon){
       int a=0;
       String b;
        SQLiteDatabase database=this.getWritableDatabase();
        String n ="SELECT * FROM CLIENTE WHERE NOMBRE ='"+buscar+"'";
        String d ="SELECT * FROM CLIENTE WHERE DIRECCION ='"+buscard+"'";
        Cursor registros = database.rawQuery(n,null);
        Cursor registros2 = database.rawQuery(d,null);
        if(registros.moveToFirst() && registros2.moveToNext()){
            mon =registros.getString(3);;
            a++;
        }else{
            a=0;
        }
        return a;
    }

    public String Recargar(String buscar2, String cantidad, String codigo){
       String mensaje = "";

           SQLiteDatabase database = this.getWritableDatabase();
           ContentValues contenedor = new ContentValues();
                contenedor.put("TELEFONO", cantidad);
                int cant = database.update("CLIENTE", contenedor, "NOMBRE='" + buscar2 + "'", null);
                if (cant != 0) {
                        mensaje = "Recarga Exitosa";
                } else {
                    mensaje = "usuario incorrecto";
                }
                database.close();

       return mensaje;
    }

    public String[] buscar_reg2(String b){
        String[] da= new String[3];
        SQLiteDatabase database=this.getWritableDatabase();
        String q ="SELECT * FROM CLIENTE WHERE NOMBRE ='"+b+"'";
        Cursor regis = database.rawQuery(q,null);
       if(regis.moveToFirst()){
           da[0]=regis.getString(3);
           da[1]=regis.getString(0);
           da[2]="hola "+da[1]+"!";

        }else{
            da[2]="usuario incorrecto";
        }
        return da;

    }


}

