package com.example.practica1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // variables de la interfaz
    EditText num01, num02;
    TextView resultado;
    Button suma, resta, multiplicacion, division;
    Button limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // conectar con el layout
        setContentView(R.layout.activity_main);

        //codigo obtenido del internet para evita que el contenido choque con la barra de notificaciones
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            // obtiene tamaño de barras del sistema
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // agrega espacio arriba, abajo y lados
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        });

        // conectar variables con xml
        num01 = findViewById(R.id.num01);
        num02 = findViewById(R.id.num02);
        resultado = findViewById(R.id.resultado);

        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        multiplicacion = findViewById(R.id.multiplicacion);
        division = findViewById(R.id.division);

        limpiar = findViewById(R.id.limpiar);

        // limpiar campos y resultado
        limpiar.setOnClickListener(v -> {
            num01.setText("");
            num02.setText("");
            resultado.setText("resultado: ---");
        });

        // botones llaman al metodo calcular con su operacion
        suma.setOnClickListener(v -> calcular("+"));
        resta.setOnClickListener(v -> calcular("-"));
        multiplicacion.setOnClickListener(v -> calcular("*"));
        division.setOnClickListener(v -> calcular("/"));
    }

    // metodo que hace las operaciones
    private void calcular(String operacion){

        // validar campos vacios
        if(num01.getText().toString().isEmpty() || num02.getText().toString().isEmpty()){
            resultado.setText("ingrese valores");
            return;
        }

        // convertir texto a numeros
        double n1 = Double.parseDouble(num01.getText().toString());
        double n2 = Double.parseDouble(num02.getText().toString());
        double res = 0;

        // segun la operacion se calcula
        switch (operacion){

            case "+":
                res = n1 + n2;
                break;

            case "-":
                res = n1 - n2;
                break;

            case "*":
                res = n1 * n2;
                break;

            case "/":
                // evitar division entre cero
                if(n2 == 0 ){
                    resultado.setText("no se puede dividir entre 0");
                    return;
                }
                res = n1 / n2;
                break;
        }

        // mostrar resultado
        resultado.setText(String.valueOf(res));
    }
}