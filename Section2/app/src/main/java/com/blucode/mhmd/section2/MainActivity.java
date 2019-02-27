package com.blucode.mhmd.section2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.login_usename_edittext);
        password = findViewById(R.id.login_password_edittext);
        login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInput();
            }
        });
    }

    public void fetchInput() {
        String username = this.username.getText().toString().trim();
        String password = this.password.getText().toString().trim();
        Toast.makeText(this, "User: " + username + "  Pass: " + password, Toast.LENGTH_LONG).show();
    }
}
