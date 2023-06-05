package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.api.Response;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlatillosActivity extends AppCompatActivity {
    Conexion con;
    Connection bd;
    ListView listView;
    Adapter adapter;
    public static ArrayList<Platillos>platillosArrayList= new ArrayList<>();
    //String url="SELECT * FROM platillos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platillos);
        con = new Conexion();
        bd= con.getConexion();
        new Async().execute();
        listView = findViewById(R.id.listMostrar);
        adapter = new Adapter(this,platillosArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog processDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogoItem ={"Ver Platillo", "Editar Platillo", "Eliminar Platillo"};
                builder.setTitle(platillosArrayList.get(position).getNombre());
                builder.setItems(dialogoItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                //ver un platillo
                                startActivity(new Intent(getApplicationContext(), VerPlatilloActivity.class).
                                        putExtra("position", position));
                                break;
                            case 1:
                                //editar un platillo
                                startActivity(new Intent(getApplicationContext(), VerPlatilloActivity.class).
                                        putExtra("position", position));
                                break;
                            case 2:
                                //Eliminar un platillo
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });


    }
    class Async extends AsyncTask<Void, Void, Void> {

        String records = "", error = "";
        int id;
        String nombre ="",ingredientes="",precio ="",temperatura ="",estado ="",imagen ="";
        Platillos platillos;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                con.getConexion();
                System.out.println("2Conexion establecida en doInBackground "+con);
               Statement statement = con.getConexion().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM platillo");
                System.out.println("===========================>>>> "+resultSet);
                while (resultSet.next()) {
                    records += resultSet.getString(1) + " " + resultSet.getString(2) + "\n";
                    id = resultSet.getInt(1);
                    nombre = resultSet.getString(2);
                    ingredientes = resultSet.getString(3);
                    precio = resultSet.getString(4);
                    temperatura = resultSet.getString(5);
                    estado = resultSet.getString(6);
                    imagen = resultSet.getString(7);
                    System.out.println("///////////////nombre//////////////////-> "+nombre);
                    platillos = new Platillos(id, nombre, precio, ingredientes, temperatura, estado, imagen);
                    System.out.println("///////////////platillos//////////////////-> "+precio);
                    platillosArrayList.add(platillos);
                }
            } catch (Exception e) {
                error = e.toString();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            System.out.println("-------1--------->    " + records);
            adapter.notifyDataSetChanged();
            //tv1.setText(records);
            if (error != "")
                System.out.println("--------------Error-----------------> " + error);
            //tv1.setText(error);
            super.onPostExecute(aVoid);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuinicio, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch (item.getItemId()){

            case R.id.inicio:
                intent =new Intent(this,PanelAdmin.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void verPlatillo(View view){
        Intent intent = new Intent(this, VerPlatilloActivity.class);
        startActivity(intent);
    }
    public void NuevoPlatillo(View view){
        Intent intent = new Intent(this, NewPlatilloActivity.class);
        startActivity(intent);
    }

}