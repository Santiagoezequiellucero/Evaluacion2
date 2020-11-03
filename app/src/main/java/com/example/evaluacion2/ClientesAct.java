package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class ClientesAct extends AppCompatActivity {
    private EditText edcodigo, ednombre, edsalario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        edcodigo = (EditText)findViewById(R.id.txtCodigo);
        ednombre = (EditText)findViewById(R.id.txtNombreBD);
        edsalario = (EditText)findViewById(R.id.txtSalario);
    }
    public void AddClientes(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edcodigo.getText().toString();
        if(!codigo.isEmpty()){
            ContentValues cont = new ContentValues();
            cont.put("codigo",edcodigo.getText().toString());
            cont.put("nombre",ednombre.getText().toString());
            cont.put("salario",edsalario.getText().toString());
            db.insert("clientes",null,cont);
            db.close();
            Toast.makeText(this,"Has guardado un valor",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Debe ingresar un valor", Toast.LENGTH_SHORT).show();
        }
    }
    public void ShowClientes(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edcodigo.getText().toString();
        if(!codigo.isEmpty()){
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo = "+codigo,null);
            if(fila.moveToFirst()){
                ednombre.setText(fila.getString(0));
                edsalario.setText(fila.getString(1));
            }
            else{
                Toast.makeText(this, "no hay campos en la entidad clientes", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "No hay cliente al codigo ingresado", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    public void DeleteClientes(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edcodigo.getText().toString();
        db.delete("clientes","codigo="+codigo,null);
        db.close();
        Toast.makeText(this, "Has eliminado al cliente", Toast.LENGTH_SHORT).show();
        edcodigo.setText("");
        ednombre.setText("");
        edsalario.setText("");
    }
    public void UpdateClientes(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edcodigo.getText().toString();
        ContentValues cont = new ContentValues();
        cont.put("codigo",edcodigo.getText().toString());
        cont.put("nombre",ednombre.getText().toString());
        cont.put("salario",edsalario.getText().toString());
        if(!codigo.isEmpty()){
            db.update("clientes",cont,"codigo="+codigo,null);
            db.close();
            Toast.makeText(this, "Has actualizado un campo", Toast.LENGTH_SHORT).show();
        }
    }
}
