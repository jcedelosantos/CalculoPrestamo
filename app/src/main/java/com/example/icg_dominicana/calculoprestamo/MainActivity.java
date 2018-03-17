package com.example.icg_dominicana.calculoprestamo;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//declaracion de variables
    private ListView listView_Calculo;
    private ArrayList<Datos> Lista;

    private static int periodo;
    private static int tasa;
    private static int monto;
    private static int nummes;
    private static Double interes;
    private static Double capital;
    private static Double pagomensual;

    private EditText myMontoEdit;
    private EditText myPeridoEdit;
    private EditText myTasaEdit;

    private Button button_Calcular;
    //metodo onCreate es el primero que corre caundo habre la aplicacion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancia de la vista del calculo
        listView_Calculo = (ListView) findViewById(R.id.list_result);
        //creacion he instanciacion del boton
         button_Calcular =  findViewById(R.id.button_calcular);
         button_Calcular.setOnClickListener(this);

        //carga el icono de la aplicacion en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_calc_pres);

    }
        //metodo onClick, da accion al botón calcular
    @Override
    public void onClick(View v) {
        //se crea una lista nueva siempre que se calcula
        //de lo contrario se monta sobre es resultado anterior
        Lista = new ArrayList<Datos>();

        //capturamos los valores insertados en los campos editext de la aplicacion
        //monto
        myMontoEdit = (EditText) findViewById(R.id.monto_numero);
        monto = (Integer.parseInt(myMontoEdit.getText().toString()));
        //periodo
        myPeridoEdit = (EditText) findViewById(R.id.periodo_num_id);
        periodo = Integer.parseInt(myPeridoEdit.getText().toString());
        //tasa
        myTasaEdit = (EditText) findViewById(R.id.tasa_num_id);
        tasa = Integer.parseInt(myTasaEdit.getText().toString());

        //varibles del metodo, se usan para el calculo del prestamo,
        int count = 1;
        Double porciento = 100d;
        int montofijo = monto;
        int periodofijo = periodo;

        //iteracion para carcular el prestamo
        while (periodo > 0) { //si el periodo es mayor que cero continuara

            if (monto<=0){// si el monto es menor o igual que cero termina el calculo
                break;
            }else {
                nummes = count; //asigna un numero de mes
                interes = Double.valueOf((((tasa/porciento)/periodofijo)*monto)); //calcula el interes por el nuevo monto
                capital = Double.valueOf(montofijo/periodofijo); //capital fijo para las cuotas
                pagomensual = interes + capital; //pago mensual es el interes mas el capital
                monto = (int) (monto - capital); // es el monto nuevo a calcular l

                //agrega los valores a la lista de nuestra estructura de datos
                Lista.add(new Datos(nummes,interes,capital,pagomensual, monto+0.0));
                count++; //aumenta el contador
                periodo--; //descrece el periodo para fines de terminar el calculo
            }
            //Enlace del adaptador con el nuestro list view, y la lista de datos actualizada
            MyAdapter myAdapter = new MyAdapter(this, R.layout.list_result,Lista);
            listView_Calculo.setAdapter(myAdapter);
        }
    }
}
