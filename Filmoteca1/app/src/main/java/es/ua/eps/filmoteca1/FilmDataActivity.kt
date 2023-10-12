package es.ua.eps.filmoteca1

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import es.ua.eps.filmoteca1.databinding.ActivityFilmDataBinding
class FilmDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmDataBinding
    val MOVIE_RESULT=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFilmDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val startForResult =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->

                onActivityResult(MOVIE_RESULT, result.resultCode, result.data)
            }
        val pos=intent.getIntExtra("pos",0)

        binding.nombrePelicula.text = FilmDataSource.films.get(pos).title
        binding.anioPelicula.text= FilmDataSource.films.get(pos).year.toString()
        binding.cartelPelicula.setImageResource(FilmDataSource.films.get(pos).imageResId)
        binding.directorPelicula.text=FilmDataSource.films.get(pos).director
        when(FilmDataSource.films.get(pos).format){
            Film.FORMAT_BLURAY-> binding.formatoPelicula.text= "FORMAT_BLURAY"
            Film.FORMAT_DIGITAL -> binding.formatoPelicula.text="FORMAT_DIGITAL"
            Film.FORMAT_DVD -> binding.formatoPelicula.text="FORMAT_DVD"
        }
        when(FilmDataSource.films.get(pos).genre){
            Film.GENRE_ACTION-> binding.generoPelicula.text= "GENRE_ACTION"
            Film.GENRE_SCIFI->  binding.generoPelicula.text="GENRE_SCIFI"
            Film.GENRE_COMEDY -> binding.generoPelicula.text="GENRE_COMEDY"
            Film.GENRE_DRAMA -> binding.generoPelicula.text="GENRE_DRAMA"
            Film.GENRE_HORROR ->binding.generoPelicula.text="GENRE_HORROR"
        }




        binding.imdb.setOnClickListener {
            val filmRelacionadaIntent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.imdb.text as String?))
            startActivity(filmRelacionadaIntent)
        }

        binding.editarPelicula.setOnClickListener {
            val intent = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
            intent.putExtra("pos",pos)
            if(Build.VERSION.SDK_INT >= 30) {
                startForResult.launch(intent)
            }
            else {
                @Suppress("DEPRECATION")
                startActivityForResult(intent, MOVIE_RESULT)
            }

        }
        binding.volver.setOnClickListener {
            val volverIntent=Intent(this,ListActivity::class.java)
            volverIntent.flags = Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS

            startActivity(volverIntent)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("KKK", "onActivityResult: requestCode=${requestCode}, resultCode=${resultCode}")
        if(requestCode==MOVIE_RESULT) {//valor que devuelve el intent
            if(resultCode== Activity.RESULT_OK){ //valor que devuelve el result de la otra activity
                Toast.makeText(this, "RESULT OK", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "RESULT CANCELLED", Toast.LENGTH_LONG).show()

            }
        }
    }


}