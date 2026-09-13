package com.example.citcs_portal_03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;
import android.content.*;
import android.app.*;

import java.text.MessageFormat;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        TextView TV_Welcome = findViewById(R.id.TV_Welcome);
        Button BTN_Logout = findViewById(R.id.btn_logout);

        Intent GetUsernameintent = getIntent();
        String username = GetUsernameintent.getStringExtra("studentName");

        TV_Welcome.setText(MessageFormat.format("{0} {1}", getString(R.string.welcome_to_citcs_portal),username));

        BTN_Logout.setOnClickListener(v -> {

            showLogoutConfirmationDialog();

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showLogoutConfirmationDialog() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Are you sure you want to logout?")
                .setTitle("Logout Confirmation")
                .setIcon(android.R.drawable.ic_dialog_alert);


        // Add the buttons
        builder.setPositiveButton("Yes", (dialog, id) -> {
            // User clicked Yes button
            Intent logout_intent = new Intent(Dashboard.this, MainActivity.class);
            startActivity(logout_intent);
            finish(); // Close the current activity
        });
        builder.setNegativeButton("No", (dialog, id) -> {
            // User cancelled the dialog
            dialog.dismiss();
        });

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}