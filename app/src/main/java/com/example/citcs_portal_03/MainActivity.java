package com.example.citcs_portal_03;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText etStudentNumber = findViewById(R.id.etStudentNumber);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        ImageButton img_CITCS = findViewById(R.id.img_CITCS);

        img_CITCS.setOnClickListener(v -> {
                    Intent gotoCITCS_intent = new Intent(Intent.ACTION_VIEW);
                    gotoCITCS_intent.setData(Uri.parse("https://plmun.edu.ph/college-of-information-technology-and-computer-studies.php"));
                    startActivity(gotoCITCS_intent);
                });

        btnLogin.setOnClickListener(v -> {
            String username = etStudentNumber.getText().toString();
            String password = etPassword.getText().toString();
            String studentName = "Danilo Lucban";

            if(username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            }
            else {
                if(username.equals("24175587") && password.equals("1234")) {
                    Toast.makeText(MainActivity.this, "Hello " + studentName, Toast.LENGTH_SHORT).show();

                    Intent gotoDashboard_intent = new Intent(MainActivity.this, Dashboard.class);
                    gotoDashboard_intent.putExtra("studentName", studentName);
                    startActivity(gotoDashboard_intent);

                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}