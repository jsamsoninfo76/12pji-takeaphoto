package com.takeaphoto.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.takeaphoto.database.Demande;
import com.takeaphoto.database.DemandesBDD;

public class ManagerActivity extends ListFragment {

	final String EXTRA_LOGIN = "user_login";
	private DemandesBDD demandeBdd ;
	private Activity mainActivity ;
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
                 
        
        demandeBdd.open() ;
        ArrayList<Demande> demandes = demandeBdd.getDemandeWithLogin(mainActivity.getIntent().getStringExtra(EXTRA_LOGIN)) ;
        demandeBdd.close() ;
        
        if(demandes != null){
	        String[] tableauDescription = new String[demandes.size()]  ;
	        
	        for(int i = 0 ; i < demandes.size(); i++){         
	        	tableauDescription[i] = demandes.get(i).getDescription() ;
	        }
	        
	        setListAdapter(new ArrayAdapter<String>(getActivity(),
	                android.R.layout.simple_list_item_1, tableauDescription));
        }
        else
        	setListAdapter(null) ;
                  
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       
    }
    
    public void setMainActivity(Activity main) {
		mainActivity = main ;
	}
    
    public void setDemandeBdd(DemandesBDD demandeBdd){
    	this.demandeBdd = demandeBdd ;
    }
}
