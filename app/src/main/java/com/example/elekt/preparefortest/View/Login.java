package com.example.elekt.preparefortest.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elekt.preparefortest.Presenter.UserManager;
import com.example.elekt.preparefortest.R;

/**
 * Created by elekt on 03.07.2017.
 */

public class Login extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization_login_layout);
    }

    public void onClickOKLogin(View view) {
        EditText loginEditText = (EditText) findViewById(R.id.editTextLogin);
        String login = loginEditText.getText().toString();
        EditText passwordEditText = (EditText) findViewById(R.id.editTextPassword);
        String password = passwordEditText.getText().toString();
        if (UserManager.isValid(login, password, Login.this))  {
            startActivity(new Intent(this, MainScreen.class));
        } else {
            Toast.makeText(Login.this, "Login or password is wrong!", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickRegistrationLogin(View view) {
        startActivity(new Intent(this, Register.class));
    }
}
