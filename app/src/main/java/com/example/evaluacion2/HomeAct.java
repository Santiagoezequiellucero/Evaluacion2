package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HomeAct extends AppCompatActivity {

    private ViewFlipper slider;
    private int [] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        slider = (ViewFlipper)findViewById(R.id.slider);

        for (int i = 0; i<images.length;i++)
        {
            flip_image(images[i]);
        }

    }

    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        slider.addView(view);
        slider.setAutoStart(true);
        slider.setFlipInterval(3500);

        slider.setInAnimation(this, android.R.anim.slide_in_left);
        slider.setInAnimation(this, android.R.anim.slide_out_right);

    }

    public void Clientes (View v)
    {
        Intent i = new Intent(this, ClientesAct.class);
        startActivity(i);
    }

    public void Prestamos (View v)
    {
        Intent i = new Intent(this, PrestamosAct.class);
        startActivity(i);
    }

    public void Seguridad (View v)
    {
        Intent i = new Intent(this, SeguridadAct.class);
        startActivity(i);
    }

    public void Informacion (View v)
    {
        Intent i = new Intent(this, InfoAct.class);
        startActivity(i);
    }
}