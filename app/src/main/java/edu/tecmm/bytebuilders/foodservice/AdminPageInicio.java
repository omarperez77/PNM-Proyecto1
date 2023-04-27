package edu.tecmm.bytebuilders.foodservice;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AdminPageInicio extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page_inicio);
        btn = findViewById(R.id.button5);
    }


    public void nuevo(){
        Intent i = new Intent(this,AdminPageRegister.class);
        startActivity(i);
    }

}