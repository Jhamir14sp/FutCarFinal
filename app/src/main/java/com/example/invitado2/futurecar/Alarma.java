package com.example.invitado2.futurecar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Alarma extends AppCompatActivity {
    Button btn_atras3;
    TextView txt_temp;
     http durl = new http();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        btn_atras3 = (Button) findViewById(R.id.btn_atras3);
        txt_temp=  findViewById(R.id.txt_temp);

        txt_temp.setText(temp());


        btn_atras3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentrg = new Intent(Alarma.this, MenuPrincipal.class);
                Alarma.this.startActivity(intentrg);
            }
        });
    }

    String temp (){
        String a="";
        String[] parts= new String[5];
        try {
            //http://localhost/java/iinicio.php?n=david&p=david
            a = durl.downloadUrl("http://"+ durl.getIp());
            parts = a.split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parts[2];
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
