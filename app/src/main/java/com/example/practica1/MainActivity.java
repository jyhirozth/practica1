package com.example.practica1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // variables
    EditText num01, num02;
    TextView resultado;
    Button suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // conectar xml
        num01 = findViewById(R.id.num01);
        num02 = findViewById(R.id.num02);
        resultado = findViewById(R.id.resultado);
        suma = findViewById(R.id.suma);

        // boton suma
        suma.setOnClickListener(v -> {

            // validar campos vacios
            if(num01.getText().toString().isEmpty() || num02.getText().toString().isEmpty()){
                resultado.setText("ingrese valores");
                return;
            }

            // convertir a numero
            double n1 = Double.parseDouble(num01.getText().toString());
            double n2 = Double.parseDouble(num02.getText().toString());

            // suma
            double res = n1 + n2;

            // mostrar resultado
            resultado.setText(String.valueOf(res));
        });
    }
}