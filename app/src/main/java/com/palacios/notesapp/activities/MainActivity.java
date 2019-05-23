package com.palacios.notesapp.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.palacios.notesapp.R;
public class MainActivity extends AppCompatActivity {
    private EditText tituloinput;
    private EditText contenidoinput;
    private ListView contact_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       tituloinput = findViewById(R.id.titulo_input);
       contact_list = findViewById(R.id.contact_list);

       ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
       contact_list.setAdapter(adapter);
    }
    public void callRegister(View view) {
        Intent intent = new Intent(this, createActivity.class);
        startActivityForResult(intent, 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity","requestCode:" + requestCode + " - resultCode:" + resultCode + " - data:" + data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                if(bundle != null){

                    String fullname = bundle.getString("titulo");
                    Log.d("createActivity", "Contacto " + fullname);

                    // Añadir un elemento al listview
                    ArrayAdapter<String> adapter = (ArrayAdapter<String>)contact_list.getAdapter();
                    adapter.add(fullname);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}
