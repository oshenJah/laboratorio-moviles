package com.example.laboratorio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    public static String nacionalidad="";

    public static boolean deportes_ex=false;
    public static boolean deportes_in=false;
    public static boolean deportes_extre=false;
    public static boolean deportes_acon=false;
    public static boolean nin=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        String[] opciones = {"Costarricense", "Nicaraguense", "Panameño","Otro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                nacionalidad = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                nacionalidad = "";
            }

        });

        CheckBox deportes_exterior=findViewById(R.id.deportes_exterior);
        CheckBox deportes_interior=findViewById(R.id.deportes_interior);
        CheckBox deportes_extremos=findViewById(R.id.deportes_extremos);
        CheckBox deportes_acondicionamiento=findViewById(R.id.deportes_acondicionamiento);
        CheckBox ninguno=findViewById(R.id.ninguno);

        Button enviar=findViewById(R.id.boton_enviar);





        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (deportes_extremos.isChecked()){
                    deportes_extre=true;

                }
                if (deportes_exterior.isChecked()){
                    deportes_ex=true;

                }
                if (deportes_interior.isChecked()){
                    deportes_in=true;

                }

                if (deportes_acondicionamiento.isChecked()){
                    deportes_acon=true;

                }

                if (deportes_extremos.isChecked()){
                    nin=true;

                }


                if (!nacionalidad.equals("")){
            if (deportes_ex || deportes_acon || deportes_in || nin || deportes_extre) {

                        Intent intent = new Intent(MainActivity.this, SegundaActividad.class);
                        startActivity(intent);
                        finish();


            }else{
                Toast.makeText(MainActivity.this, "Debes seleccionar un checkbox al menos", Toast.LENGTH_SHORT).show();

            }

        }else{
            Toast.makeText(MainActivity.this, "Debes seleccionar una nacionalidad", Toast.LENGTH_SHORT).show();

        }

            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}