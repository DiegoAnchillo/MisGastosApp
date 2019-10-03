package com.ddiego.misgastosapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ddiego.misgastosapp.R;
import com.ddiego.misgastosapp.adapter.OperacionAdapter;
import com.ddiego.misgastosapp.repositorio.OperacionRepositorio;

public class DetallesActivity extends AppCompatActivity {

    TextView monto;
    TextView detail;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        detail = findViewById(R.id.detailTitulo);
        monto = findViewById(R.id.suma);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String valor = getIntent().getExtras().getString("valor");
        OperacionAdapter adapter = new OperacionAdapter();
        adapter.setOperaciones(OperacionRepositorio.getOperation(valor));
        monto.setText(String.valueOf(OperacionRepositorio.total(valor)));
        detail.setText("Saldo Actual "+valor);
        recyclerView.setAdapter(adapter);
    }
}
