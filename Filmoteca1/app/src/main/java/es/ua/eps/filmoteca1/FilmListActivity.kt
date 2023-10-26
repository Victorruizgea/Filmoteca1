package es.ua.eps.filmoteca1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import es.ua.eps.filmoteca1.databinding.ActivityFilmListBinding
class FilmListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmListBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataFilmIntent = Intent(this, FilmDataActivity::class.java)

        binding.peliculaA.setOnClickListener {
            dataFilmIntent.putExtra("EXTRA_FILM_TITLE", "pelicula A")
            startActivity(dataFilmIntent);
        }
        binding.peliculaB.setOnClickListener {
            dataFilmIntent.putExtra("EXTRA_FILM_TITLE", "pelicula B")
            startActivity(dataFilmIntent);
        }
        binding.acerca.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }




}