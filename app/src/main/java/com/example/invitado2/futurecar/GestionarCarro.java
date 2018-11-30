package com.example.invitado2.futurecar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GestionarCarro extends AppCompatActivity {
    Button btn_avanzar,btn_derecha,btn_izquierda,btn_retroceso,btn_atras2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_carro);
        btn_avanzar = (Button) findViewById(R.id.btn_avanzar);
        btn_derecha = (Button) findViewById(R.id.btn_derecha);
        btn_izquierda = (Button) findViewById(R.id.btn_izquierda);
        btn_retroceso = (Button) findViewById(R.id.btn_retroceso);
        btn_atras2 = (Button) findViewById(R.id.btn_atras2);

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
                solicita("");//comando avanzar
            }
        });
        btn_derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solicita("");
            }
        });
        btn_izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solicita("");
            }
        });
        btn_retroceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solicita("");
            }
        });
    }
    public void solicita(String comando){
        ConnectivityManager connMgr =(ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()) {
            String url= "http//192.168.0.36/";
            new solicitaDatos().execute(url+comando);
        }else{
            Toast.makeText(GestionarCarro.this,"Conexion detectada ",Toast.LENGTH_LONG).show();
        }
    }
    private class solicitaDatos extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... url) {
            return Conexion.getDatos(url[0]);
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            if(resultado!=null){
                if(resultado.contains("btn1on")){
                    btn_avanzar.setEnabled(true);
                }
                else{
                    btn_avanzar.setEnabled(false);
                }
                if(resultado.contains("btn2on")){
                    btn_derecha.setEnabled(true);
                }
                else{
                    btn_derecha.setEnabled(false);
                }
                if(resultado.contains("btn3on")){
                    btn_izquierda.setEnabled(true);
                }
                else{
                    btn_izquierda.setEnabled(false);
                }
                if(resultado.contains("btn4on")){
                    btn_retroceso.setEnabled(true);
                }
                else{
                    btn_retroceso.setEnabled(false);
                }
            }else{
                Toast.makeText(GestionarCarro.this,"Ocurrio un error ",Toast.LENGTH_LONG).show();
            }
        }
    }
}
