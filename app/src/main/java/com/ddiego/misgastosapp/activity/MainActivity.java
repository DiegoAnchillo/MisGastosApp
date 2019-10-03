package com.ddiego.misgastosapp.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ddiego.misgastosapp.R;
import com.ddiego.misgastosapp.repositorio.OperacionRepositorio;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    ImageView imagen1;
    ImageView imagen2;
    ImageView imagen3;
    TextView saldo1;
    TextView saldo2;
    TextView saldo3;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton=findViewById(R.id.floatingActionButton);
        imagen1=findViewById(R.id.imageView);
        imagen2=findViewById(R.id.imageView2);
        imagen3=findViewById(R.id.imageView3);
        saldo1=findViewById(R.id.saldo1);
        saldo2=findViewById(R.id.saldo2);
        saldo3=findViewById(R.id.saldo3);
        progressBar=findViewById(R.id.progreso);

        Double numero = OperacionRepositorio.total_global();
        Log.e("main asgfasgagasgba","monto: "+numero);
        progressBar.setProgress((int)Math.round(numero));

        saldo1.setText("S/."+String.valueOf(OperacionRepositorio.total("Ahorro")));
        saldo2.setText("S/."+String.valueOf(OperacionRepositorio.total("Tarjeta de Crédito")));
        saldo3.setText("S/."+String.valueOf(OperacionRepositorio.total("Efectivo")));


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(), DetallesActivity.class);
                a.putExtra("valor", "Ahorro");
                startActivity(a);
            }
        });
        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tc=new Intent(getApplicationContext(),DetallesActivity.class);
                tc.putExtra("valor", "Tarjeta de Crédito");
                startActivity(tc);
            }
        });
        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f=new Intent(getApplicationContext(),DetallesActivity.class);
                f.putExtra("valor", "Efectivo");
                startActivity(f);
            }
        });
    }
}
