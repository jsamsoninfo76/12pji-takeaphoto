
package com.android.map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
    private GoogleMap gMap;
    private Intent intent ;
    final Context context = this ;
    final String EXTRA_LOGIN = "user_login";
    MarkerOptions markerOptions = new MarkerOptions();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        intent = getIntent();

        setUpMapIfNeeded();
        
       gMap.setOnMapLongClickListener(new OnMapLongClickListener() {
    	    public void onMapLongClick(LatLng point) {
    	    	// Setting the position for the marker
    	        markerOptions.position(point);

                AlertDialog.Builder alert = new AlertDialog.Builder(context);

                alert.setTitle("Description de la photo voulue :");

                // Set an EditText view to get user input 
                final EditText input = new EditText(context);
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                  setMarker(input.getText().toString()) ;
                  }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int whichButton) {
                    // Canceled.
                  }
                });

                alert.show();
 
             // Animating to the touched position
                gMap.animateCamera(CameraUpdateFactory.newLatLng(point));
                
    	    }
    	});
    }

    
    private void setMarker(String result){

        // Setting the title for the marker.
        // This will be displayed on taping the marker
        if (intent != null && intent.getStringExtra(EXTRA_LOGIN) != null) 
            markerOptions.title(intent.getStringExtra(EXTRA_LOGIN));
        else
        	markerOptions.title("Unregistered User (developpement)") ;
        markerOptions.snippet(result) ;
        
        // Clears the previously touched position
        gMap.clear();

        // Placing a marker on the touched position
        gMap.addMarker(markerOptions);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (gMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            gMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            gMap.setMyLocationEnabled(true);
        }
    }
    
    
}
