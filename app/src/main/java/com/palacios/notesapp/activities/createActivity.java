package com.palacios.notesapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.palacios.notesapp.R;

public class createActivity extends AppCompatActivity {
    private EditText tituloInput;
    private EditText contenidoInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        tituloInput = findViewById(R.id.titulo_input);
        contenidoInput = findViewById(R.id.contenido_input);
    }

    public void callDoRegister(View view) {

        String titulo = tituloInput.getText().toString();
        String contenido = contenidoInput.getText().toString();

        if (titulo.isEmpty() || contenido.isEmpty()) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        intent.putExtra("titulo", "TÍTULO"+ "\n "+ titulo + "\n " +"DESCRIPCIÓN "+ "\n " + contenido);
        setResult(RESULT_OK, intent);
        finish();
    }
}
