package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityLogin extends AppCompatActivity {

    private TextView lblGotoRegister;
    private Button Login;
    private EditText Email;
    private EditText Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.txtEmail);
        Pass = (EditText) findViewById(R.id.txtPass);
        Login = (Button) findViewById(R.id.btnLogin);


    }
    public void enviar(View view) {
        String email = Email.getText().toString();
        String password = Pass.getText().toString();

    }
}
