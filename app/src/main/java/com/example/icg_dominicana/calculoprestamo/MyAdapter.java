package com.example.icg_dominicana.calculoprestamo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import java.util.List;

/**
 * Created by Javis Cedano on 15/3/2018.
 */

//clase mi adaptador para modifificar el listview
public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private int NumMes;
    private Double  periodo, Interes,Capital,PagoMes,SaldoFinal;
    private List<Datos> ListaDatos;

    public MyAdapter(Context context, int layout, List<Datos> listaDatos) {
        this.context = context;
        this.layout = layout;
        ListaDatos = listaDatos;
    }
    @Override
    public int getCount() {return ListaDatos.size(); } //devuelve la cantidad de elemento de la lista de datos
    @Override
    public Object getItem(int position) {return ListaDatos.get(position);}
    @Override
    public long getItemId(int id) {return ListaDatos.get(id).getId();}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //copiamos la vista que tenemos
        View v  =  convertView;

        //inflamos la vista con nuestro layout personalizado
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_result,null);

        //Referenciamos el elemento a rellenar y lo rellenamos
        EditText editNumMes = v.findViewById(R.id.NumMesResult);
        EditText editInteres = v.findViewById(R.id.InteresResult);
        EditText editCapital = v.findViewById(R.id.CapitalResult);
        EditText editPagoMes = v.findViewById(R.id.PagoMesResult);
        EditText editSaldoFinal = v.findViewById(R.id.SaldoFinalResult);

        //setiamos el valor en la campo correspondiente para el layout actualizado
        editNumMes.setText(ListaDatos.get(position).getId()+"");
        editInteres.setText(String.format("%,.1f",ListaDatos.get(position).getInteres()));
        editCapital.setText(String.format("%,.1f",ListaDatos.get(position).getCapital()));
        editPagoMes.setText(String.format("%,.1f",ListaDatos.get(position).getpMensual()));
        editSaldoFinal.setText(String.format("%,.1f",ListaDatos.get(position).getsFinal()));

        //devolvemos la vista modificada
        return v;
    }
}
