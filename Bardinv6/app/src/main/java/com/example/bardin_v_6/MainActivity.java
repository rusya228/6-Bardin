package com.example.bardin_v_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button in = (Button)  findViewById(R.id.in);
        in.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {
        EditText txLogin = (EditText) findViewById(R.id.txLogin);
        EditText txPassword = (EditText) findViewById(R.id.txPassword);
        Intent intent = new Intent(MainActivity.this,PersonalaAreaActivity.class);
        startActivity(intent);
        String Login = txLogin.getText().toString();
        String Password = txPassword.getText().toString();
        if (!Login.isEmpty())| !Password.isEmpty() {
            SQLiteDatabase db = getBaseContext().openOrCreateDatabase("db.db",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS user (id INEGER PRIMARY KEY AUTOINCREMENT, login TEXT, password TEXT)",null);
            db.execSQL(String.format("iNSERT INTO users (login, password) VALUES ('%s',')"));

        }

    }
}