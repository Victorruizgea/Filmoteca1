package es.ua.eps.drawables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Estilos1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estilos1)
        val button = findViewById<Button>(R.id.continuarEstilos)
        button.setOnClickListener { startActivity(Intent(this,Estilos2::class.java)) }
    }
}