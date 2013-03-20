
package com.android.map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 * <p>
 * Notice how we deal with the possibility that the Google Play services APK is not
 * installed/enabled/updated on a user's device.
 */
public class MapAdd extends SupportMapFragment implements OnMarkerDragListener {
    /**
     * Note that this may be null if the Google Play services APK is not available.
     */
    private GoogleMap gMap;
    private Intent intent  ;
    private Context context ;
    final String EXTRA_LOGIN = "user_login";
    MarkerOptions markerOptions = new MarkerOptions();
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void setContext(Context context){
    	this.context=context ;
    }
    
    public void setIntent(Intent intent){
    	this.intent =intent ;
    }
    
    private void setMarker(String result){

        // Setting the title for the marker.
        // This will be displayed on taping the marker
        if (intent != null && intent.getStringExtra(EXTRA_LOGIN) != null) 
            markerOptions.title(intent.getStringExtra(EXTRA_LOGIN));
        else
        	markerOptions.title("Unregistered User (developpement)") ;
        markerOptions.snippet(result) ;
     
        markerOptions.draggable(true) ;
        // Clears the previously touched position
        gMap.clear();

        // Placing a marker on the touched position
        gMap.addMarker(markerOptions);
    }
    
    @Override
	public void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (gMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            gMap = getMap();
            gMap.setMyLocationEnabled(true);
            gMap.setOnMarkerDragListener(this) ;
            
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
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.map_add, menu) ;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.menu_save:
    		String desc = markerOptions.getSnippet() ;
    		AlertDialog.Builder alert = new AlertDialog.Builder(context);
    		
    		if(desc != null){
    			alert.setTitle("Voulez-vous vraiment valider cette demande ?");

                alert.setMessage("Description : \n" + markerOptions.getSnippet()) ;
                
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    
                      }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int whichButton) {
                    // Canceled.
                  }
                });
    		}
    		else{
    			alert.setTitle("Erreur");
    			alert.setMessage("Vous devez d'abord poser un marqueur et lui ajouter une description") ;
    			 alert.setNeutralButton ( "OK" , new DialogInterface.OnClickListener () {
    				 	public void  onClick (DialogInterface dialog, int whichButton) {
    				 		
    				 	}
    			 });
    		}
    		
            alert.show();
    		return true;
    		
    	case R.id.menu_search:
    		// Comportement du bouton "rechercher"
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    
    
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
    	
    	View myFragmentView = super.onCreateView(inflater, container, savedInstanceState) ;
		
		return myFragmentView;
    }

	@Override
	public void onMarkerDrag(Marker marker) {}

	@Override
	public void onMarkerDragEnd(Marker marker) {}

	@Override
	public void onMarkerDragStart(Marker marker) {}

}