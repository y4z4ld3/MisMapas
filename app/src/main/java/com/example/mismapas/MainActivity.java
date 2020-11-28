package com.example.mismapas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    GridView simpleGrid;
    int ciudades[] = {R.drawable.caracas, R.drawable.quito, R.drawable.roma, R.drawable.paris};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        if (miActionBar != null){
            setSupportActionBar(miActionBar);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_mundo);

        simpleGrid = (GridView) findViewById(R.id.grd_ciudades);
        GridAdaptador gridAdaptador = new GridAdaptador(getApplicationContext(), ciudades);
        simpleGrid.setAdapter(gridAdaptador);
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                double Lat, Long;
                String nombre_ciudad;
                int marcador = 0;
                switch (position){
                    case 0: Lat = 10.506098; //Caracas
                            Long = -66.9146017;
                            nombre_ciudad = getResources().getString(R.string.ciudad_caracas);
                            marcador = (R.drawable.arepas);
                            break;
                    case 1: Lat = -0.2274522; //Quito
                            Long = -78.51476571615603;
                            nombre_ciudad = getResources().getString(R.string.ciudad_quito);
                            marcador = (R.drawable.tamales);
                            break;
                    case 2: Lat = 41.85223935; //Roma
                            Long = 12.631036615953583;
                            nombre_ciudad = getResources().getString(R.string.ciudad_roma);
                            marcador = (R.drawable.pizza);
                            break;
                    case 3: Lat = 48.8588897; //paris
                            Long = 2.320041027461107;
                            nombre_ciudad = getResources().getString(R.string.ciudad_paris);
                            marcador = (R.drawable.crepe);
                            break;
                    default:
                            Lat = 0;
                            Long = 0;
                            nombre_ciudad = getResources().getString(R.string.pNombreCiudad);
                            break;
                }
                Bundle extras = new Bundle();
                extras.putDouble(getResources().getString(R.string.pLatitud), Lat);
                extras.putDouble(getResources().getString(R.string.pLongitud), Long);
                extras.putString(getResources().getString(R.string.pNombreCiudad), nombre_ciudad);
                extras.putInt(getResources().getString(R.string.pMarcadorCiudad), marcador);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}