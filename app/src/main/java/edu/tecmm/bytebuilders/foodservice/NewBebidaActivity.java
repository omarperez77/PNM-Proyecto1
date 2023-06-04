package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class NewBebidaActivity extends AppCompatActivity {
    TextView nombre;
    TextView ingredientes;
    RadioGroup radioGroup;
    RadioGroup tipodebebida;
    String bebida;
    String costo;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bebida);
        //Poner el icono en el action Bar
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.icon_launcher);*/
        nombre = findViewById(R.id.editTextTextPersonName);
        tipodebebida = findViewById(R.id.RadioGrupo);
        costo = findViewById(R.id.editTextNumber2);
        ingredientes = findViewById(R.id.editTextTextMultiLine2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuinicio, menu);
        return true;
    }

    public void registrarBebidas(View v) {

        int selectedTipoBebidaId = tipodebebida.getCheckedRadioButtonId();
        if (selectedTipoBebidaId != -1) {
            switch (selectedTipoBebidaId) {
                case 1:
                    bebida = "cerveza";
                    break;
                case 2:
                    bebida = "bebida mixta";
                    break;
                case 3:
                    bebida = "agua";
                    break;
                case 4:
                    bebida = "refresco";
                    break;

            }else{
                Toast.makeText(this, "Seleccione un tipo de bebida", Toast.LENGTH_SHORT).show();
            }
            if (nombre.getText() != null && selectedTipoBebidaId != -1 && ingredientes.getText() != null) {
                sql = "INSERT INTO bebidas(nombre, tipodebebidas, costo, ingredientes) "
                        + "VALUES('" + nombre.getText().toString() + "',"
                        + "'" + bebida + "','" + costo.toString() + "','" + ingredientes.getText().toString() + "')";
                try {
                    ps = nc.prepareStatement(sql);

                    int registro = ps.executeUpdate();
                    if (registro > 0) {
                        System.out.println("Registro de beebida correcto");
                    }

                } catch (SQLException ex) {
                    System.out.println("Error de query para registrar la bebida");
                }
                @Override
                public boolean onOptionsItemSelected (MenuItem item){
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
        }
    }
}