package com.example.icg_dominicana.calculoprestamo;

/**
 * Created by ICG_DOMINICANA on 16/3/2018.
 */
//clase de la estructura de datos que vamos a usar
public class Datos {
    //declaracion de variables
    private int Id;
    private  Double interes;
    private  Double pMensual;
    private  Double capital;
    private  Double sFinal;

//constructor del metodo Datos
    public Datos( int id, Double interes, Double capital, Double pMensual, Double sFinal) {
        Id = id;
        //this.mes = mes;
        this.interes = interes;
        this.capital =capital;
        this.pMensual = pMensual;
        this.sFinal = sFinal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    //metodos Get y Set por variable
    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public Double getpMensual() {
        return pMensual;
    }

    public void setpMensual(Double pMensual) {
        this.pMensual = pMensual;
    }

    public Double getsFinal() {
        return sFinal;
    }

    public void setsFinal(Double sFinal) {
        this.sFinal = sFinal;
    }
}
