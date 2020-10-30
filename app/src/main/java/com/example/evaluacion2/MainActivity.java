package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, pass;
    private ProgressBar progressBar;
    private TextView mensaje;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtNombre);
        pass = (EditText)findViewById(R.id.txtPass);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        mensaje = (TextView)findViewById(R.id.txtMensaje);
        btn = (Button)findViewById(R.id.btnIngresar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute();
            }
        });
        progressBar.setVisibility(View.INVISIBLE);
    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            mensaje.setText("");
            String a =nombre.getText().toString();
            String b =pass.getText().toString();
            String c = mensaje.getText().toString();
            if(a.equalsIgnoreCase("Android") && b.equals("123")){
                progressBar.setVisibility(View.VISIBLE);
            }
            else {
                mensaje.setText(" usuario o contraseña incorrecto\n");
                nombre.setText("");
                pass.setText("");
            }
         }

        @Override
        protected String doInBackground(String... strings) {

            for (int i = 1; i < 5; i++) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {

            Intent i = new Intent(getBaseContext(), HomeAct.class);
            startActivity(i);
        }
    }

}