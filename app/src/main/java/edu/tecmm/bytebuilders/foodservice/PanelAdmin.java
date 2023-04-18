package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class PanelAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_admin);
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch (item.getItemId()){

            case R.id.cerrarsecion:
                Toast.makeText(this,"Cerrando sesión...",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Ayuda:
                intent =new Intent(this,AyudaActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void empleados(View view){
        Intent intent = new Intent(this, EmpleadosActivity.class);
        startActivity(intent);
    }
    public void platillos(View view){
        Intent intent = new Intent(this, PlatillosActivity.class);
        startActivity(intent);
    }
    public void bebidas(View view){
        Intent intent = new Intent(this, BebidasActivity.class);
        startActivity(intent);
    }
}
