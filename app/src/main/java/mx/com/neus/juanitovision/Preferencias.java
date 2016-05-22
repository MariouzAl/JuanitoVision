package mx.com.neus.juanitovision;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Preferencias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences prefer = getSharedPreferences("XD", MODE_PRIVATE);
        final AppCompatEditText phoneNumber = (AppCompatEditText) findViewById(R.id.phone_number);
        final AppCompatEditText message = (AppCompatEditText) findViewById(R.id.mensaje);

        message.setText(prefer.getString("UserMessage",""));
        phoneNumber.setText(prefer.getString("UserPhone",""));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = phoneNumber.getText().toString();
                String mensaje = message.getText().toString();
                salvar(numero, mensaje);

                Intent i = new Intent(Preferencias.this, MainActivityFragment.class);
                startActivity(i);

                Snackbar.make(view, "Se ha guardado Exitósamente" + numero, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void salvar(String number,String mensaje) {
        SharedPreferences settings = getSharedPreferences("XD", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString("UserMessage", mensaje);
        prefEditor.putString("UserPhone", number);
        prefEditor.commit();
    }

}
