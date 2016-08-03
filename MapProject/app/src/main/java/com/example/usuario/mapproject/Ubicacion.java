package com.example.usuario.mapproject;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Usuario on 01/08/2016.
 */
public class Ubicacion implements LocationListener {
    private Context ctx;
    LocationManager locationManager;
    String proveedor;
    private boolean networkOn;
    public Ubicacion(Context ctx) {
        this.ctx = ctx;
        locationManager=(LocationManager)ctx.getSystemService(Context.LOCATION_SERVICE);
        proveedor=LocationManager.NETWORK_PROVIDER;
        locationManager.requestLocationUpdates(proveedor,1000,1,this);
        networkOn=locationManager.isProviderEnabled(proveedor);
        locationManager.requestLocationUpdates(proveedor,1000,1,this);
        getLocation();
    }
    private void getLocation(){
        if(networkOn) {

            Location lc = locationManager.getLastKnownLocation(proveedor);
            if (lc != null) {
               /* StringBuilder builder = new StringBuilder();
                builder.append("Altitud: ").append(lc.getAltitude()).append("Longitud: ").append(lc.getLongitude());
                Toast.makeText(ctx, builder.toString(), Toast.LENGTH_LONG).show();*/
            }
        }
    }
    public LatLng getLatitud(){
        LatLng ubicacion=null;
        if(networkOn){
            Location lc= locationManager.getLastKnownLocation(proveedor);
            if(lc!=null){
                ubicacion= new LatLng((double)lc.getLatitude(),(double)lc.getLongitude());

            }
        }
        return ubicacion;
    }


    @Override
    public void onLocationChanged(Location location) {
        getLocation();


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
