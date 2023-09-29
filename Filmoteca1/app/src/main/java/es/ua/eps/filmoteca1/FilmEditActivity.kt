package es.ua.eps.filmoteca1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca1.databinding.ActivityFilmEditBinding


class FilmEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFilmEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonGuardar.setOnClickListener { finish() }
        binding.botonCancelar.setOnClickListener { finish() }
    }
}