package com.ddiego.misgastosapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ddiego.misgastosapp.R;
import com.ddiego.misgastosapp.models.OperacionModelos;

import java.util.ArrayList;
import java.util.List;

public class OperacionAdapter extends RecyclerView.Adapter<OperacionAdapter.ViewHolder>{

    private List<OperacionModelos> operaciones;

    public void setOperaciones(List<OperacionModelos> operaciones) {
        this.operaciones = operaciones;
    }

    public OperacionAdapter(){
        this.operaciones = new ArrayList<>();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView monto, titulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            monto = itemView.findViewById(R.id.monto_transaccion);
            titulo = itemView.findViewById(R.id.titulo_transaccion);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_operation, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        OperacionModelos operation = this.operaciones.get(i);
        viewHolder.titulo.setText(operation.getFecha()+ " " + operation.getTipo() );
        viewHolder.monto.setText("S/. "+operation.getMonto()+"                                ");

    }

    @Override
    public int getItemCount() {
        return this.operaciones.size();
    }
}
