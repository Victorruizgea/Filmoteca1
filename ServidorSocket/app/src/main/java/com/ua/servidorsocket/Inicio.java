package com.ua.servidorsocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    private Button iniciarChat,unirmeChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        iniciarChat= findViewById(R.id.iniciar);
        unirmeChat= findViewById(R.id.unirme);

        iniciarChat.setOnClickListener(view -> startActivity(new Intent(this,ServidorActivity.class)));

        unirmeChat.setOnClickListener(view -> startActivity(new Intent(this,ClienteActivity.class)));

    }
}