package edu.tecmm.bytebuilders.foodservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Platillos1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platillos1);
    }
    public void verPlatillo(View view){
        Intent intent = new Intent(this, VerPlatilloActivity.class);
        startActivity(intent);
    }
}
