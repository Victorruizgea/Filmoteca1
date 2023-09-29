package es.ua.eps.filmoteca1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca1.databinding.ActivityFilmListBinding
class FilmListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataFilmIntent= Intent(this,FilmDataActivity::class.java)

        binding.peliculaA.setOnClickListener {
            startActivity(dataFilmIntent);
        }
        binding.peliculaB.setOnClickListener {
            startActivity(dataFilmIntent);
        }
        binding.acerca.setOnClickListener {
            startActivity(Intent(this,AboutActivity::class.java))
        }
    }
}