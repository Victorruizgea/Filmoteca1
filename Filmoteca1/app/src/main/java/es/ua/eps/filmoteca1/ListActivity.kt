package es.ua.eps.filmoteca1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca1.databinding.ActivityListBinding


class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val valores = FilmDataSource.films
        val adaptor= FilmAdapter(this,R.layout.item_film,valores)
        binding.lista.adapter=adaptor

        binding.lista.setOnItemClickListener{parent, view, position, id ->
            val film = valores[position]
            val intentFilmData = Intent(this, FilmDataActivity::class.java)
            intentFilmData.putExtra("pos", position)

            startActivity(intentFilmData)

        }
    }




}


