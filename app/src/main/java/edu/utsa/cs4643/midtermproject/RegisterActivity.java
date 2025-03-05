package edu.utsa.cs4643.midtermproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.registerUsername);
        password = findViewById(R.id.registerPassword);
        registerButton = findViewById(R.id.registerSubmitButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        RegisterActivity.this,
                        String.format(
                                "Username: %s Password %s",
                                username.getText(),
                                password.getText()),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }
}