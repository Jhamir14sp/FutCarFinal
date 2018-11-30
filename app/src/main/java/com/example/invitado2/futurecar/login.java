package com.example.invitado2.futurecar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {
    TextView tv_registrar;
    Button    btn_iniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_iniciar= (Button)  findViewById(R.id.btn_iniciar) ;
        tv_registrar= (TextView) findViewById(R.id.tv_registrar) ;



        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentreg = new Intent(login.this, registro.class);
                login.this.startActivity(intentreg);
            }
        });
        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentreg = new Intent(login.this, MenuPrincipal.class);
                login.this.startActivity(intentreg);
            }
        });




    }
}