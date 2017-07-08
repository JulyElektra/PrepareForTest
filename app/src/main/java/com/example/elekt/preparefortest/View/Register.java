package com.example.elekt.preparefortest.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elekt.preparefortest.Model.User;
import com.example.elekt.preparefortest.Presenter.UserManager;
import com.example.elekt.preparefortest.R;

/**
 * Created by elekt on 03.07.2017.
 */

public class Register extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization_registration_layout);
    }

    public void onClickRegisterOK(View view) {
        EditText loginTextView = findViewById(R.id.editTextRegLogin);
        String login = loginTextView.getText().toString();
        EditText passTextView = findViewById(R.id.editTextRegPassword);
        String password = passTextView.getText().toString();
        if (UserManager.isExists(login, Register.this)) {
            Toast.makeText(view.getContext(), "Account with such a login exists!",
                    Toast.LENGTH_LONG).show();
        } else {
            UserManager.addUser(login, password, Register.this);
            Toast.makeText(view.getContext(), "Account created!",
                    Toast.LENGTH_LONG).show();
            startActivity(new Intent(view.getContext(), Login.class));
        }
    }

    public void onClickRegisterCancel(View view) {
        startActivity(new Intent(this, Login.class));
    }
}
