package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewPlatilloActivity extends AppCompatActivity {
    Conexion con;
    Connection bd;
    TextView txt1, txt2, txt3, t;
   RadioGroup btnEstado;
    RadioGroup btnStatus;
    String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newplatillo);
        con = new Conexion();
        bd= con.getConexion();
        txt1= findViewById(R.id.txt1);
        txt2= findViewById(R.id.txt2);
        txt3= findViewById(R.id.txt3);
        btnEstado = findViewById(R.id.GrupoEstado);
        btnStatus = findViewById(R.id.GrupoStatus);

    }

    public void agregar(View view){
        new Async().execute();
        String a = txt1.getText().toString();
        System.out.println("00000000000000000000000 ==================== "+a);
        //registrarEstado(t);
        //System.out.println("estado"+t);
        Intent intent =new Intent(this,PlatillosActivity.class);
        startActivity(intent);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuinicio, menu);
        return true;
    }


    //consulta


    class Async extends AsyncTask<Void, Void, Void> {
        PreparedStatement ps=null;
        String records = "", error = "";
        int id,registro;



        String nombre ="",ingredientes="",precio ="",temperatura ="",estado ="",imagen ="";
        Platillos platillos;
        @Override
        protected Void doInBackground(Void... voids) {
            String sql="INSERT INTO platillo(nombre, ingredientes, precio, ) VALUES(?,?,?,?)";
            try {
                con.getConexion();
                System.out.println("2 Conexion establecida en Nuevo platillo ");
                Statement statement = con.getConexion().createStatement();
                System.out.println("--------------------------- Aqui llega ------------------------ "+statement);
                PreparedStatement ps = con.getConexion().prepareStatement("INSERT INTO platillo(nombre, ingredientes, precio) VALUES('"+txt1.getText().toString()+"', '"+txt2.getText().toString()+"', '"+txt3.getText().toString()+"')");
                //System.out.println("==========================> "+ps);

                //System.out.println("==========================> "+txt1.getText().toString()+" "+txt2.getText().toString()+" "+txt3.getText().toString());
                registro = ps.executeUpdate();
                Looper.prepare();
                if (registro>0){
                    Toast.makeText(NewPlatilloActivity.this, "Registro de platillo correcto", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                error = e.toString();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {

            System.out.println("-------1--------->    " + registro);
            //adapter.notifyDataSetChanged();
            //tv1.setText(records);
            if (error != "")
                System.out.println("--------------Error-----------------> " + error);
            //tv1.setText(error);
            super.onPostExecute(aVoid);
        }
    }


    public void registrarEstado(View view){

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.btnCaliente:
                estado="Caliente";
                break;
            case R.id.btnTibio:
                estado="Tibio";
                break;
            case R.id.btnFrio:
                estado="Frio";
                break;
        }
    }

    //Para el menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.inicio:
                intent = new Intent(this, PanelAdmin.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}