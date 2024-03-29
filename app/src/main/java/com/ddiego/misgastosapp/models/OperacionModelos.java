package com.ddiego.misgastosapp.models;

public class OperacionModelos {
    private String fecha;
    private String tipo;
    private String monto;
    private String saldo;


    public OperacionModelos(String fecha, String tipo, String monto, String saldo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.saldo = saldo;
    }

    public OperacionModelos() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
