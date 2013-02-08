package com.samson_paumier.pji.auth;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class Authentification extends Activity {

	private Button valider;
	private EditText password, username;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authentification);
		
		initUI();
	}

	public void initUI(){
		//EditText
		username = new EditText(this);
		username.setHint(R.string.username);
		username.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
		
		password = new EditText(this);
		password.setHint(R.string.password);
		password.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
		
		//Boutton Valider
		valider = new Button(this);
		valider.setText(R.string.valider);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_authentification, menu);
		return true;
	}

}
