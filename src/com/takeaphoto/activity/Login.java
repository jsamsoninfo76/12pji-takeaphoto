package com.takeaphoto.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Login extends Activity {

	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		final EditText login = (EditText) findViewById(R.id.user_email);
		final EditText pass = (EditText) findViewById(R.id.user_password);
		final Button loginButton = (Button) findViewById(R.id.connect);
		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final String loginTxt = login.getText().toString();
				final String passTxt = pass.getText().toString();

				if (loginTxt.equals("") || passTxt.equals("")) {
					Toast.makeText(Login.this,
							R.string.email_or_password_empty,
							Toast.LENGTH_SHORT).show();
					return;
				}

				// On d�clare le pattern que l�on doit suivre
				Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
				// On d�clare un matcher, qui comparera le pattern avec la
				// string pass�e en argument
				Matcher m = p.matcher(loginTxt);
				// Si l�adresse mail saisie ne correspond au format d�une
				// adresse mail
				if (!m.matches()) {
					// Toast est une classe fournie par le SDK Android
					// pour afficher les messages dans des minis pop up
					// Le premier argument est le Context, puis
					// le message et � la fin la dur�e de ce dernier
					Toast.makeText(Login.this,
							R.string.email_format_error, Toast.LENGTH_SHORT)
							.show();
					return;
				}

				Intent intent = new Intent(Login.this,
						MainActivity.class);
				intent.putExtra(EXTRA_LOGIN, loginTxt);
				intent.putExtra(EXTRA_PASSWORD, passTxt);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        return (LinearLayout) inflater.inflate(R.layout.activity_login, container, false);
    }

}
