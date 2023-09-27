package es.ua.eps.filmoteca1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.ua.eps.filmoteca1.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Toast.makeText(this, "Funcionalidad sin implementar", Toast.LENGTH_LONG).show();
        }
        binding.button2.setOnClickListener {
            Toast.makeText(this, "Funcionalidad sin implementar", Toast.LENGTH_LONG).show();
        }
        binding.button3.setOnClickListener {
            Toast.makeText(this, "Funcionalidad sin implementar", Toast.LENGTH_LONG).show();
        }

    }
}