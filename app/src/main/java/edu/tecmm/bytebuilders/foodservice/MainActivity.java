package edu.tecmm.bytebuilders.foodservice;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
=======
import android.os.Bundle;
<<<<<<< HEAD
>>>>>>> 52b66d5e45ea24eb2fef92a6b7054aa3e297dd54
=======
>>>>>>> 438aec8a6bbea04ed3ac832a16be7a60706876d6
>>>>>>> camarena

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);


        TextView codeliaTextView = findViewById(R.id.codeliaTextView);
        ImageView logoImgeView = findViewById(R.id.logoImagenView);


        codeliaTextView.setAnimation(animacion2);
        logoImgeView.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }

}
=======
        setContentView(R.layout.activity_main);
    }
}
<<<<<<< HEAD
>>>>>>> 52b66d5e45ea24eb2fef92a6b7054aa3e297dd54
=======
>>>>>>> 438aec8a6bbea04ed3ac832a16be7a60706876d6
>>>>>>> camarena
