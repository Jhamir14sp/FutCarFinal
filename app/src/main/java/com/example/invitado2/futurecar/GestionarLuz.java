package com.example.invitado2.futurecar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GestionarLuz extends AppCompatActivity {
    Button btn_atras1,btn_encedido,btn_apagado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_luz);

        btn_atras1= (Button) findViewById(R.id.btn_atras1);
        btn_encedido=(Button)findViewById(R.id.btn_encendido) ;
        btn_apagado=(Button) findViewById(R.id.btn_apagado);

        btn_atras1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentrg = new Intent(GestionarLuz.this, MenuPrincipal.class);
                GestionarLuz.this.startActivity(intentrg);
            }
        });
    }
}
