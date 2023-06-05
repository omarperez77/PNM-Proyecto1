package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;
import java.sql.*;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AdminPageRegister extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Connection con;
    TextView nombreUsuario;
    TextView nombreCompleto;
    TextView correo;
    TextView telefono;
    TextView contrasena;
    TextView fecha;
    String tipoDeUser;
    RadioGroup radioGroup;
    int tipoDeUsuario;
    public AdminPageRegister(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9621802", "sql9621802", "yhM3ulC4DX");
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de acceso al driver de mysql");
        } catch (SQLException ex) {
            System.out.println("Error de conexion con la base de datos");
        }


    }
    public AdminPageRegister getConexion() {
        return (AdminPageRegister) con;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        nombreUsuario = findViewById(R.id.txtUsuario);
        nombreCompleto = findViewById(R.id.txtNombreCompleto);
        correo = findViewById(R.id.txtCorreo);
        telefono = findViewById(R.id.txtTelefono);
        contrasena = findViewById(R.id.txtContrasena);
        radioGroup = findViewById(R.id.radioGroup);
        tipoDeUsuario = radioGroup.getCheckedRadioButtonId();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
    public void insertarDatos(View v){
        AdminPageRegister bd = new AdminPageRegister();
        Connection nc = (Connection) bd.getConexion();
        //Consultar datos
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
/*
        try {
            ps = nc.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                //Llenar el combo
                String nombreUsuario = rs.getString("nombreUsuario");
                String duraacionCurso = rs.getString("duracion");
                String descripcionCurso = rs.getString("descripcion");
                System.out.println("Nombre: " + nombreCurso);
                System.out.println("Duracion: " + duracionCurso);
                System.out.println("Descripcion: " + descripcionCurso);
            }
        } catch (SQLException ex) {
            System.out.println("Excepción = " + ex.getMessage());
        }
        */

        //Insertar registros


        if(tipoDeUsuario!=-1){
            switch (tipoDeUsuario){
                case 1:
                    tipoDeUser = "administrador";
                    break;
                case 2:
                    tipoDeUser = "cocinero";
                    break;
                case 3:
                    tipoDeUser = "cliente";
                    break;
            }
        }else{
            Toast.makeText(bd, "Seleccione un rol para el usuario", Toast.LENGTH_SHORT).show();
        }

        if(nombreUsuario.getText() !=null && nombreCompleto.getText()!=null && correo.getText()!=null && contrasena.getText()!=null && telefono.getText()!=null && tipoDeUsuario !=-1){
            sql = "INSERT INTO usuarios(nombreUsuario,nombreCompleto,correo,contrasena,telefono,tipoDeUsuario) "
                    + "VALUES('"+nombreUsuario.getText().toString()+"',"
                    + "'"+nombreCompleto.getText().toString()+"','"+correo.getText().toString()+"','"+contrasena.getText().toString()+"','"+telefono.getText().toString()+"','"+tipoDeUser+"')";
            try {
                ps = nc.prepareStatement(sql);

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    System.out.println("Registro de usuario correcto");
                }

            } catch (SQLException ex) {
                System.out.println("Error de query para registrar usuario");
            }
        }

        /*
        sql = "INSERT INTO usuarios(nombreUsuario,nombreCompleto,correo,contrasena,telefono,tipoDeUsuario) "
                + "VALUES('roman',"
                + "'Roman Ramos Vazquez','roman@gmail.com','roman123','3153545893','administrador')";
  */


    }
}




