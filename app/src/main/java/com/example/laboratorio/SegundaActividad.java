package com.example.laboratorio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaActividad extends AppCompatActivity {

    public String deportes_extremos="";
    public String deportes_exteriores="";
    public String deportes_interiores="";
    public String deportes_acondicionamiento="";
    public String ninguno="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_actividad);

        TextView texto_nacionalidad=findViewById(R.id.texto_nacionalidad);
        TextView texto_deportes=findViewById(R.id.texto_deportes);

        texto_nacionalidad.setText("La nacionalidad es: "+MainActivity.nacionalidad);

        if (MainActivity.nin){
            ninguno="ninguno";
        }

        if (MainActivity.deportes_acon){
            deportes_acondicionamiento="deportes de acondicionamiento";
        }

        if(MainActivity.deportes_extre){
            deportes_extremos="deportes extremos";
        }

        if (MainActivity.deportes_ex){
            deportes_exteriores="deportes exteriores";
        }

        if(MainActivity.deportes_in){
            deportes_interiores="deportes de interiores";
        }


        texto_deportes.setText("los deportes elegidos son: "+ninguno+","+deportes_interiores+","+deportes_exteriores+","+deportes_extremos+","+deportes_acondicionamiento);



        Button regresar=findViewById(R.id.regresar);

        regresar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                MainActivity.nacionalidad="";
                MainActivity.deportes_extre=false;
                MainActivity.deportes_ex=false;
                MainActivity.deportes_in=false;
                MainActivity.nin=false;
                MainActivity.deportes_acon=false;


                Intent intent = new Intent(SegundaActividad.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}