package com.example.minhasanotaes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Anotacoes preferencias;
    private EditText anotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anotacao = findViewById(R.id.editTextAnotacao);
        preferencias = new Anotacoes(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validar informações

                if (anotacao.getText().toString().equals("")) {
                    Snackbar.make(view, "Digite alguma anotação", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    preferencias.salvarAnotacoes(anotacao.getText().toString());
                    Snackbar.make(view, "Anotação adicionada", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }
        });

        //Recuperar Anotações
        String anottacao = preferencias.retornarAnotacao();
        if( !anottacao.equals("") ){
        anotacao.setText(anottacao);

        }
    }

}
