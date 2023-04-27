package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class AyudaActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    ArrayList<String> listGroup = new ArrayList<>();
    HashMap<String, ArrayList<String>> listCHild = new HashMap<>();
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        //Poner el icono en el action Bar
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.icon_launcher);*/


        expandableListView = findViewById(R.id.exp_list_view);

        for (int i = 0; i < 1; i++) {
            listGroup.add(i, "Bebidas");
            //inicializa la lista del array
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("En este apartado se podran realizar acciones como:");
            arrayList.add("    - Registrar bebidas                - Editar\n    - Visualizar registro                - Eliminar");
            listCHild.put(listGroup.get(i), arrayList);
        }
        for (int i = 0; i < 1; i++) {
            listGroup.add(i, "Platillos");
            //inicializa la lista del array
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("En este apartado se podran realizar acciones como:");
            arrayList.add("    - Registrar Platillos                - Editar\n    - Visualizar registro                - Eliminar");
            listCHild.put(listGroup.get(i), arrayList);
        }
        for (int i = 0; i < 1; i++) {
            listGroup.add(i, "Empleados");
            //inicializa la lista del array
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("En este apartado se podran realizar acciones como:");
            arrayList.add("    - Registrar Empleados             - Editar\n    - Visualizar registro                  - Eliminar");
            listCHild.put(listGroup.get(i), arrayList);
        }



        adapter = new MainAdapter(listGroup, listCHild);
        expandableListView.setAdapter(adapter);
    }

}