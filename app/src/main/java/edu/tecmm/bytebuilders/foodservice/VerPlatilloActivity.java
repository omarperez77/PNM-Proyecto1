package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerPlatilloActivity extends AppCompatActivity {
   TextView nomPlatillo, ingredientes, precio, caliente, actDes;
    Conexion con;
    Connection bd;
    int ban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_platillo);
        //Poner el icono en el action Bar
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.icon_launcher);*/
        nomPlatillo =findViewById(R.id.txtNomPlatillo);
        ingredientes =findViewById(R.id.txtIngredientes);
        precio =findViewById(R.id.txtPrecio);
        caliente =findViewById(R.id.txtCaliente);
        actDes =findViewById(R.id.txtActDes);


    }

    //consulta
    class Async extends AsyncTask<Void, Void, Void> {
        String records = "", error = "";
        @Override
        protected Void doInBackground(Void... voids) {
            PreparedStatement ps=null;
            ResultSet rs = null;
            System.out.println("-----------aqui pasa----------------  ----------------------");

            try {
                con.getConexion();
                System.out.println("2 Conexion establecida en doInBackground "+con);
                Platillos platillos = new Platillos();
                String resultSet = ("SELECT * FROM platillo WHERE  id="+platillos.id);
                ps=con.getConexion().prepareStatement(resultSet);
                System.out.println("///////////////////////////////////////");
                System.out.println(ps);
                System.out.println("///////////////////////////////////////");
                //aqui van los datos de los campos que tiene la vista
                int registro = ps.executeUpdate();


                if (registro>0){
                    Toast.makeText(VerPlatilloActivity.this, "Registro de platillo correcto", Toast.LENGTH_SHORT).show();
                }


            } catch (Exception e) {
                System.out.println("-----------Error del query para insertar datos en la base de datos ----------------  ----------------------");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            System.out.println("-------1--------->    " + records);
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
}