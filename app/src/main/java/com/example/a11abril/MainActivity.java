package com.example.a11abril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //atributos-variables
    private TextView txtResultado;
    private EditText etPalabra;
    private Button btnProcesar;
    private Button btnMensaje;

    private String palabra;
    private String invertido;

    //metodos - funciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        /*
        al configurar un boton para decirle que este pendiente al evento clicj de ese boton en pantalla
        con el uso del metodo .setOnClickListener()
        Lo que ese mètodo esta esperando como parametro o argunmento es una funcion que serà
        la funciòn click que activara las funciones a realizar cuando se presione el boton.
        CuANDO SE PASA UNA FUNCION COMO PARAMENTRO ESTAS GENERALMENTE SON CONOCIDAD COMO FUNCINES ANONIMAS
        la idea es que esa funcion ejecute su proceimiento a partir del metodo que la recibe como parametro.
         */

        //this: ambito o contexto de la misma clase.  busca la respuesta en la clase

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Este metodo onclick solo existe en el ambito del boton btnProcesar, lo que se haga a ca solo sirve para ese boton
                recibirInformacion();
                invertirPalabra();
            }
        });
        btnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarMensaje();
            }
        });
    }

    private void mostrarMensaje() {
        /*
        Para mostrar mensajes en pantalla, ustedes pueden usar
        una ventana emergente temporal llamada Toast que basicamente
        sirve para mostrar información al usuario acerca de ciertos
        procesos que hayan pasado, confirmaciones, mostrar algun mensaje
        y otros.
         */
        //estatico
        /*
        El Toast tiene un metodo llamado makeText que es donde configuraran
        lo que quieren mostrar al usuario, para ello deben pasar estos parametros:
         - contexto (ambito) de la pantalla donde se va a dibujar ese mensaje.
         - cadena de caracteres: el mensaje a mostrar.
         - una constante de duracion del mensaje en pantalla para que dure mas o menos
         Finalmente deben decirle al Toast que se muestre con esa configuracion
         y para ello usan el método o envento .show()
         */
        //ese metodo devuelve un string
        String mensajeMostrar = evaluarPalindromo();
        Toast.makeText(this,mensajeMostrar,Toast.LENGTH_LONG).show();
    }

    private void invertirPalabra() {
        //Una anera directa de inveritr una cadena
        //Netamente codigo java
        //palabra = new StringBuilder(palabra).reverse().toString();
        invertido = "";
        //La idea es que traten la cadena String como si fuera un Array
        //donde cada letra esta en una posicion del array partiendo desde 0
        //para tal efecto los Strings tienen un metodo que les permite
        //devolver un caracter de una posicion como si fuera un array
        //el metodo se llama .charAt(indice)
        for (int i = this.palabra.length() - 1; i >= 0 ; i--) {
            invertido += this.palabra.charAt(i);
        }
        txtResultado.setText(invertido);
    }

    private void recibirInformacion() {
        palabra = etPalabra.getText().toString();
    }

    //Evaluar palindromo
    private String evaluarPalindromo(){
        String mensaje = "No es palindromo";
        if (palabra.equals(invertido)) {
            mensaje = "Es palindromo";
        }
        return mensaje;
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
        etPalabra = findViewById(R.id.etPalabra);
        etPalabra = findViewById(R.id.etPalabra);
        btnProcesar = findViewById(R.id.btnProcesar);
        btnMensaje = findViewById(R.id.btnMensaje);
    }


}