package com.iteso.pdm18_scrollabletabs;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {
    EditText user, password;
    Button login;
    boolean isLogged;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Context context = this;
        SharedPreferences sharedPreferences = getSharedPreferences("User", context.MODE_PRIVATE);
        SharedPreferences sharedPreferences1 = getSharedPreferences("Pass", context.MODE_PRIVATE);


        user = findViewById(R.id.activity_main_user);
        password = findViewById(R.id.activity_main_password);
        login = findViewById(R.id.activity_main_login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getPreferences(context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Usuario", user.getText().toString());
                editor.commit();

                SharedPreferences sharedPreferences1 = getPreferences(context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor.putString("Contrasena", password.getText().toString());
                editor.commit();

                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                startActivity(intent);

            }
        });

    }
}
