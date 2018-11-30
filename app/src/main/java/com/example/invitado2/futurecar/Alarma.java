package com.example.invitado2.futurecar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Alarma extends AppCompatActivity {
    Button btn_atras3,btn_prender, btn_apagar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);

        btn_atras3 = (Button) findViewById(R.id.btn_atras3);
        btn_prender=(Button) findViewById(R.id.btn_prender);
        btn_apagar=(Button) findViewById(R.id.btn_apagar);

        btn_atras3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentrg = new Intent(Alarma.this, MenuPrincipal.class);
                Alarma.this.startActivity(intentrg);
            }
        });
    }
}
