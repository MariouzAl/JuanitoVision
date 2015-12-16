package mx.com.neus.juanitovision;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import mx.com.neus.juanitovision.vo.Punto;
import mx.com.neus.juanitovision.vo.PuntosDAO;

public class ListaPuntosActivity extends AppCompatActivity {
    PuntosDAO dao;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_puntos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dao = new PuntosDAO(context);
        ListView listView = (ListView) findViewById(R.id.lista);
        ArrayList<Punto> puntos = dao.getAllPuntos();
        ArrayAdapter<Punto> adaptador = new ArrayAdapter<Punto>(this, android.R.layout.simple_list_item_1, puntos);
        listView.setAdapter(adaptador);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(view.getContext(),PuntosConfigurationActivity.class);
                //intent.putExtra(EXTRA, frases);
                startActivity(intent);

            }
        });
    }

}
