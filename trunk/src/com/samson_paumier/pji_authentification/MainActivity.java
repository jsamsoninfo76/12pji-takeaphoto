package com.samson_paumier.pji_authentification;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EditText editTextUsername = new EditText(this);
        editTextUsername.setHint(R.string.username);
        editTextUsername.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        
        EditText editTextPassword = new EditText(this);
        editTextPassword.setHint(R.string.password);
        editTextPassword.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
