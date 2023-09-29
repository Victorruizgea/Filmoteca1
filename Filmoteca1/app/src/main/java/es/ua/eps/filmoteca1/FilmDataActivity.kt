package es.ua.eps.filmoteca1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.filmoteca1.databinding.ActivityFilmDataBinding
class FilmDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFilmDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nombre = intent.getStringExtra("EXTRA_FILM_TITLE")
        binding.textViewData.text = "Datos de la $nombre"
        binding.botonRelacionada.setOnClickListener {
            val filmRelacionadaIntent = Intent(this, FilmDataActivity::class.java)
            filmRelacionadaIntent.putExtra("EXTRA_FILM_TITLE","pelicula relacionada")

            startActivity(filmRelacionadaIntent)
        }

        binding.botonEditar.setOnClickListener {
            startActivity(Intent(this,FilmEditActivity::class.java))
        }
        binding.volver.setOnClickListener {
            val volverIntent=Intent(this,FilmListActivity::class.java)
            volverIntent.flags = Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS

            startActivity(volverIntent)
        }
    }
}