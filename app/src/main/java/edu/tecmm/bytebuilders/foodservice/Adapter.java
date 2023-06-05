package edu.tecmm.bytebuilders.foodservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Platillos> {
    TextView txtNombre, txtPrecio;
    Context context;
    List<Platillos>arrayplatillos;
    public Adapter(@NonNull Context context, List<Platillos>arrayplatillos) {
       super(context, R.layout.activity_platillos1,arrayplatillos);
        this.context=context;
        this.arrayplatillos=arrayplatillos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_platillos1, null,true);

         txtNombre = view.findViewById(R.id.txtNombreP);
         txtPrecio = view.findViewById(R.id.txtPrecioP);

        txtNombre.setText(arrayplatillos.get(position).getNombre());
        txtPrecio.setText("$ "+arrayplatillos.get(position).getIngredientes()+".00");
        return view;
    }
}
