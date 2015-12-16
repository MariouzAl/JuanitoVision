package mx.com.neus.juanitovision;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;

public class PuntosConfigurationActivity extends FragmentActivity {
    private AppCompatEditText logitud;
    private AppCompatEditText latitud;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos_configuration);
  //      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        logitud= (AppCompatEditText) findViewById(R.id.logitud);
        latitud= (AppCompatEditText) findViewById(R.id.latitud);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String longitudText = logitud.getText().toString();
                String latitudText = logitud.getText().toString();

                Snackbar.make(view, "Longitud "+longitudText+" Latitud: "+ latitudText  , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
