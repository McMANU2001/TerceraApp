package com.example.terceraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtResultado;
    private Button btnMostrar, btnInvertir;
    private EditText etNombre, etNumero;
    private String nombre;
    private int celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        //van a configurar al boton para que
        // este pendiente de un evento en pantalla, en este caso el evento
        //de que un usuario haga click al boton


        //Parametro de la funcion que espera que le mandes
        // tu logica desarrollada que quieres que haga en un click
        btnMostrar.setOnClickListener(this);
        btnInvertir.setOnClickListener(this);
    }

    private void inicializarVistas() {
        //Inicializamos vistas y referenciamos nuestros
        // componentes visuales diseñados
        // con los atributos o variables que hemos creado
        txtResultado = findViewById(R.id.txtResultado);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnInvertir = findViewById(R.id.btnInvertir);
        etNombre = findViewById(R.id.etNombre);
        etNumero = findViewById(R.id.etNumero);

    }

    private void InvertirNumero(){
        //invertir el numero
        //12345->54321
        int resto = 0, invertido = 0;
        while (this.celular > 0)
        {
            resto = this.celular % 10;
            invertido = invertido * 10 + resto;
            this.celular = this.celular / 10;
        }
        txtResultado.setText("Invertido: " + invertido);
    }

    private void mostrarTexto(){
        //como obtener los datos que el usuario
        // que ingreso al componenete de texto
        //to.String() -> convierte la cadean de texto del campo definido
        nombre = etNombre.getText().toString();
        String celularTexto = etNumero.getText().toString();
        //Usar conocimientos de Java para Parsear una variable
        celular = Integer.parseInt(celularTexto);
        txtResultado.setText("Nombre: " + this.nombre+ ", Celular: " + celularTexto);
    }

    @Override
    public void onClick(View view) {
        mostrarTexto();
        //El parametro View es un objeto que recibe la
        // inforamacion del componenete visual que el usuario ha
        // presionado en pantalla si presiona el boton invertir view es igual a ese
        // boton y de ese boton u otra vista pueden
        // obtener informacion como por ejemplo el atributo
        // que los identifica como algo unico.

        switch (view.getId())  {
            case R.id.btnMostrar:
                mostrarTexto();
                break;
            case R.id.btnInvertir:
                InvertirNumero();
                break;
        }
    }
}