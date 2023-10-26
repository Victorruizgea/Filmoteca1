package es.ua.eps.drawables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Estilos2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estilos2)
        val button = findViewById<Button>(R.id.volverEstilos)
        button.setOnClickListener { startActivity(Intent(this,Estilos1::class.java)) }
    }
}