package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        con = new Conexion();
        //bd = con.getConexion();
        llenarDepartamentos();
        ban = 0;
    }

    private void llenarDepartamentos() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = bd.prepareStatement("SELECT * FROM departamento");
            rs = ps.executeQuery();

            while (rs.next()) {
                //Llenar el combo
                String depto = rs.getString("nombreDepto");
               // comboDepartamentos.addItem(depto);
            }
        } catch (SQLException ex) {
            System.out.println("Excepción = " + ex.getMessage());
        }
    }
    private void btnActualizar(View view){
        ban=2;
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