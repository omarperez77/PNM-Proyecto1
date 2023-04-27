package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    EditText name, email, password;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.txtNombre);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        db = FirebaseDatabase.getInstance().getReference();
    }
    public void listUsuarios(View view){
        Intent intent = new Intent(this, VerUsuarioActivity.class);
        startActivity(intent);
    }
    public void gFirebase(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        String p = password.getText().toString();

        if (n.equals("") || e.equals("") || p.equals("")) {
            validacion();
        } else {
            Usuario user = new Usuario(n, e, p);
            db.child("Usurious").child(user.getUserName()).setValue(user);
            Toast.makeText(this, "Registrado...", Toast.LENGTH_SHORT).show();
            limpiar();
        }


    }


    private void validacion() {
        String n = name.getText().toString();
        String e = email.getText().toString();
        String p = password.getText().toString();
        if (n.equals("")) {
            name.setError("Requerido");
        } else if (e.equals("")) {
            email.setError("Requerido");
        } else if (p.equals("")) {
            password.setError("Requerido");
        }
    }

    private void limpiar() {
        name.setText("");
        email.setText("");
        password.setText("");

    }

    public void PanelAdmin(View view) {
        Intent intent = new Intent(this, PanelAdmin.class);
        startActivity(intent);

    }

}