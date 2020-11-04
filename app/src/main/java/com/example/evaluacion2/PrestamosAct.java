package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class PrestamosAct extends AppCompatActivity {
    private Spinner spinClientes, spinCredito;
    private HashMap<String,Integer> hashclientes;
    private TextView edResultado;
    private  final int [] creditos = {1000000,500000};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos);
        edResultado = (TextView) findViewById(R.id.tvResultado);
        spinClientes = (Spinner)findViewById(R.id.spnClientes);
        spinCredito = (Spinner)findViewById(R.id.spnCredito);
        hashclientes = (HashMap<String, Integer>) getIntent().getSerializableExtra("Clientes");
        String [] listadoClientes = {"(Seleccione Cliente)","Axel","Roxana","Betzabe","Matias"};
        String [] listadoCreditos = {"(Seleccione Credito)","Credito Hipotecario","Credito Automotriz"};
        ArrayAdapter<String> adaptClientes = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listadoClientes);
        spinClientes.setAdapter(adaptClientes);
        ArrayAdapter<String> adaptCreditos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listadoCreditos);
        spinCredito.setAdapter(adaptCreditos);
    }
    public void CalcularPrestamo(View view){
        String resultado;
        if(spinCredito.getSelectedItemPosition() == 1 && (spinClientes.getSelectedItemPosition() == 1 || spinClientes.getSelectedItemPosition() == 2) ){
            resultado = ("Su saldo es = $" + String.valueOf((hashclientes.get(spinClientes.getSelectedItem().toString())+creditos[0])));
            edResultado.setText(resultado);
        }
        else if(spinCredito.getSelectedItemPosition() == 2 && (spinClientes.getSelectedItemPosition() == 1 || spinClientes.getSelectedItemPosition() == 2)){
            resultado = ("Su saldo es = $" + String.valueOf((hashclientes.get(spinClientes.getSelectedItem().toString())+creditos[1])));
            edResultado.setText(resultado);
        }
    }
    public void CalcularDeuda(View view){
        String resultado;
        if(spinCredito.getSelectedItemPosition() == 1 && (spinClientes.getSelectedItemPosition() == 1 || spinClientes.getSelectedItemPosition() == 2)){
            resultado = ("El valor de sus cuotas es = $" + String.valueOf((hashclientes.get(spinClientes.getSelectedItem().toString())+creditos[0]) /12 ) + "\nA 12 cuotas" );
            edResultado.setText(resultado);
        }
        else if(spinCredito.getSelectedItemPosition() == 2 && (spinClientes.getSelectedItemPosition() == 1 || spinClientes.getSelectedItemPosition() == 2)){
            resultado = ("El valor de sus cuotas es = $" + String.valueOf((hashclientes.get(spinClientes.getSelectedItem().toString())+creditos[1])/8) + "\nA 8 cuotas");
            edResultado.setText(resultado);
        }
    }
}