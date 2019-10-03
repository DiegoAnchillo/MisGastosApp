package com.ddiego.misgastosapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


import com.ddiego.misgastosapp.R;
import com.ddiego.misgastosapp.repositorio.OperacionRepositorio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegistroActivity extends AppCompatActivity {
    private EditText monto;
    private CheckBox ingreso;
    private CheckBox egreso;
    private Button registro;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        spinner=findViewById(R.id.tipo3);
        monto=findViewById(R.id.monto);
        ingreso=findViewById(R.id.checkBox);
        egreso=findViewById(R.id.checkBox2);
        registro=findViewById(R.id.registro);


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });
    }

    public void registro(){
        String saldo = spinner.getSelectedItem().toString();
        String cantidad = monto.getText().toString();
        String tipo;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        if(ingreso.isChecked()){
            tipo = "Ingresos";
        }else{
            tipo="Egresos";
        }
        OperacionRepositorio.agregar(date, tipo, cantidad, saldo);
        Intent e = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(e);
        finish();
    }
}
