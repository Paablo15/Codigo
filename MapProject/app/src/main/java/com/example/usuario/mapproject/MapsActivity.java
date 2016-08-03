package com.example.usuario.mapproject;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Ubicacion ub= new Ubicacion(this);
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
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Ubicacion ub= new Ubicacion(this);
        LatLng miUbicacion = new LatLng(ub.getLatitud().latitude,ub.getLatitud().longitude);
        mMap.addMarker(new MarkerOptions().position(miUbicacion).title("Mi ubicacion"));
        float zoom=16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miUbicacion,zoom));
    }
    public void zoomUbicacion(View view){

        Ubicacion ub= new Ubicacion(this);
        LatLng miUbicacion = new LatLng(ub.getLatitud().latitude,ub.getLatitud().longitude);
        float zoom=20;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miUbicacion,zoom));

    }

}
