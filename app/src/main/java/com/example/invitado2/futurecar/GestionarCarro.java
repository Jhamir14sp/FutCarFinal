package com.example.invitado2.futurecar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class GestionarCarro extends AppCompatActivity {
    Button btn_avanzar,btn_derecha,btn_izquierda,btn_retroceso,btn_detener,btn_atras2;
    http durl =new http();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_carro);
        btn_avanzar = (Button) findViewById(R.id.btn_avanzar);
        btn_derecha = (Button) findViewById(R.id.btn_derecha);
        btn_izquierda = (Button) findViewById(R.id.btn_izquierda);
        btn_retroceso = (Button) findViewById(R.id.btn_retroceso);
        btn_detener=(Button) findViewById(R.id.btn_detener);
        btn_atras2 =  findViewById(R.id.btn_atras2);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        btn_atras2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentrg = new Intent(GestionarCarro.this, MenuPrincipal.class);
                GestionarCarro.this.startActivity(intentrg);

            }
        });
        btn_avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CargarDatos().execute("http://"+ durl.getIp()+"/?ADELANTE");
            }
        });
        btn_derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CargarDatos().execute("http://"+ durl.getIp()+"/?DERECHA");
            }
        });
        btn_izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CargarDatos().execute("http://"+ durl.getIp()+"/?IZQUIERDA");
            }
        });
        btn_retroceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CargarDatos().execute("http://"+ durl.getIp()+"/?ATRAS");

            }
        });
        btn_detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CargarDatos().execute("http://"+ durl.getIp()+"/?PARAR");
            }
        });
    }



    class CargarDatos extends AsyncTask<String, Void, String> {
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
