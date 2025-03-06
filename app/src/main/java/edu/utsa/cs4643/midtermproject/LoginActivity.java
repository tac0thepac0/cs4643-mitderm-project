package edu.utsa.cs4643.midtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import edu.utsa.cs4643.midtermproject.Model.User;

public class LoginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private TextView registerButton;
    private Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginSubmitButton);
        registerButton = findViewById(R.id.loginRegisterButton);

        loginButton.setOnClickListener(v -> {
            Toast.makeText(
                    LoginActivity.this,
                    String.format(
                            "Username: %s Password: %s",
                            username.getText(),
                            password.getText()
                    ),
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(LoginActivity.this, SwipeActivity.class);
            intent.putExtra("USER", new User(username.getText().toString(), password.getText().toString()));
            startActivity(intent);
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        LoginActivity.this,
                        "Register button clicked!",
                        Toast.LENGTH_SHORT
                ).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}