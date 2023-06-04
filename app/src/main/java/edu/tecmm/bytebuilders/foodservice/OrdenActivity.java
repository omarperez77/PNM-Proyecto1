package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdenActivity extends AppCompatActivity {
    private Connection con;
    private TextView tv1;

    RadioButton dom;
    CheckBox op1,op2,op3,op4,op5,op6,op7,op8;
    Button bguardar, bcancelar;
    TextView ttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);

        dom = findViewById(R.id.rbdomicilio);
        op1 = findViewById(R.id.t1);
        op2 = findViewById(R.id.t2);
        op3 = findViewById(R.id.t3);
        op4 = findViewById(R.id.t4);
        op5 = findViewById(R.id.t5);
        op6 = findViewById(R.id.t6);
        op7 = findViewById(R.id.t7);
        op8 = findViewById(R.id.t8);
        ttotal = findViewById(R.id.pagar);


        tv1 = findViewById(R.id.tv1);
        new Async().execute();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9621802", "sql9621802", "yhM3ulC4DX");
            tv1.setText("Conexión exitosa");
        } catch (ClassNotFoundException ex) {
            tv1.setText("Error de acceso al driver de mysql" + "\n" + ex.getMessage());
        } catch (SQLException ex) {
            tv1.setText(ex.getMessage());//"Error de conexion con la base de datos";
        }
    }

    public void calcular (View v){
        Double total=0.0;
        if (dom.isChecked())
            total=total+10;

        if (op1.isChecked())
            total=total+17;

        if (op2.isChecked())
            total=total+15;

        if (op3.isChecked())
            total=total+15;

        if (op4.isChecked())
            total=total+15;

        if (op5.isChecked())
            total=total+25;

        if (op6.isChecked())
            total=total+25;

        if (op7.isChecked())
            total=total+20;

        if (op8.isChecked())
            total=total+25;

        ttotal.setText("Total:" + total);
    }

    public void cancelar (View v){
        dom.setChecked(false);
        op1.setChecked(false);
        op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);

        ttotal.setText("Total=0");

    }

    class Async extends AsyncTask<Void, Void, Void> {
        String records = "", error = "";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9621802", "sql9621802", "yhM3ulC4DX");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orden");
                
            } catch (Exception e) {
                error = e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            tv1.setText(records);
            if (error != "")
                tv1.setText(error);
            super.onPostExecute(aVoid);
        }
    }


}