package edu.tecmm.bytebuilders.foodservice;
import android.os.AsyncTask;
import android.provider.Settings;
import android.widget.Toast;

import java.sql.*;

public class Conexion {

    private Connection connection;

    public Conexion() {
        new Async().execute();
    }
    public Connection getConexion() {
        return connection;
    }

    class Async extends AsyncTask<Void, Void, Void> {
        String records = "", error = "";
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                 connection = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9621802", "sql9621802", "yhM3ulC4DX");
                System.out.println("Conexion establecida en doInBackground "+connection);
               Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM platillo");
                System.out.println("===========================>>>> "+resultSet);
                while (resultSet.next()) {
                    records += resultSet.getString(1) + " " + resultSet.getString(2) + "\n";
                }
            } catch (Exception e) {
                error = e.toString();
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
}
