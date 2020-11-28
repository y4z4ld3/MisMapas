package com.example.mismapas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double Latitud, Longitud;
    String nombre_ciudad;
    int marcador_ciudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        if (miActionBar != null){
            setSupportActionBar(miActionBar);
        }

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_mundo);

        Bundle parametros = this.getIntent().getExtras();
        Latitud = parametros.getDouble(getResources().getString(R.string.pLatitud));
        Longitud = parametros.getDouble(getResources().getString(R.string.pLongitud));
        nombre_ciudad = parametros.getString(getResources().getString(R.string.pNombreCiudad));
        marcador_ciudad = parametros.getInt(getResources().getString(R.string.pMarcadorCiudad));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        LatLng ciudad = new LatLng(Latitud,Longitud);

        mMap.addMarker(new MarkerOptions()
                            .position(ciudad)
                            .title(nombre_ciudad)
                            .icon(BitmapDescriptorFactory.fromResource(marcador_ciudad))
                       );
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ciudad));
    }
}