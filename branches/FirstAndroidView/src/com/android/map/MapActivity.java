
package com.android.map;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 * <p>
 * Notice how we deal with the possibility that the Google Play services APK is not
 * installed/enabled/updated on a user's device.
 */
public class MapActivity extends android.support.v4.app.FragmentActivity {
    /**
     * Note that this may be null if the Google Play services APK is not available.
     */
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        
        //Si le GPS est disponible, on s'y abonne
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            abonnementGPS();
        }
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void onResume() {
        super.onResume();
 
        //Obtention de la r�f�rence du service
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
 
        //Si le GPS est disponible, on s'y abonne
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            abonnementGPS();
        }
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onPause() {
        super.onPause();
 
        //On appelle la m�thode pour se d�sabonner
        desabonnementGPS();
    }
 
    /**
     * M�thode permettant de s'abonner � la localisation par GPS.
     */
    public void abonnementGPS() {
        //On s'abonne
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
    }
 
    /**
     * M�thode permettant de se d�sabonner de la localisation par GPS.
     */
    public void desabonnementGPS() {
        //Si le GPS est disponible, on s'y abonne
        locationManager.removeUpdates(this);
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onLocationChanged(final Location location) {
        //On affiche dans un Toat la nouvelle Localisation
        final StringBuilder msg = new StringBuilder("lat : ");
        msg.append(location.getLatitude());
        msg.append( "; lng : ");
        msg.append(location.getLongitude());
 
        Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show();
 
        //Mise � jour des coordonn�es
        final LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());      
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        marker.setPosition(latLng);
    }
 
    public void onProviderDisabled(final String provider) {
        //Si le GPS est d�sactiv� on se d�sabonne
        if("gps".equals(provider)) {
            desabonnementGPS();
        }       
    }
 

    public void onProviderEnabled(final String provider) {
        //Si le GPS est activ� on s'abonne
        if("gps".equals(provider)) {
            abonnementGPS();
        }
    }
 
    public void onStatusChanged(final String provider, final int status, final Bundle extras) { }
}
