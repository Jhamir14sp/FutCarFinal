package com.example.invitado2.futurecar;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class GestionarLuz extends AppCompatActivity {
    Button btn_atras1,btn_encedido,btn_apagado;
    http durl =new http();
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
        btn_encedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GestionarLuz.CargarDatos().execute("http://"+ durl.getIp()+"/?led1_on");

            }
        });
        btn_apagado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GestionarLuz.CargarDatos().execute("http://"+ durl.getIp()+"/?led1_off");

            }
        });

    }
    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return durl.downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
    }
}

