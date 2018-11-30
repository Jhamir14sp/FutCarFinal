package com.example.invitado2.futurecar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {
    Button btn_luz,btn_carro,btn_alarma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btn_luz= (Button) findViewById(R.id.btn_luz);
        btn_carro=(Button) findViewById(R.id.btn_carro);
        btn_alarma= (Button) findViewById(R.id.btn_alarma) ;


        btn_luz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentreg = new Intent(MenuPrincipal.this, GestionarLuz.class);
                MenuPrincipal.this.startActivity(intentreg);
            }
        });
        btn_carro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentreg = new Intent(MenuPrincipal.this, GestionarCarro.class);
                MenuPrincipal.this.startActivity(intentreg);
            }
        });
        btn_alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentreg = new Intent(MenuPrincipal.this, Alarma.class);
                MenuPrincipal.this.startActivity(intentreg);
            }
        });
            }

    }

