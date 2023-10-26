package es.ua.eps.filmoteca1

import android.content.Intent
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView.MultiChoiceModeListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import es.ua.eps.filmoteca1.databinding.ActivityListBinding


class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding


    companion object {
        private val ID_MENU_FILM = Menu.FIRST
        private val ID_MENU_ABOUT = Menu.FIRST+1
    }
    private var cont=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)

        val valores = FilmDataSource.films
        val adaptor= FilmAdapter(this,R.layout.item_film,valores)
        binding.lista.adapter=adaptor

        binding.lista.setOnItemClickListener{parent, view, position, id ->
            val film = valores[position]
            val intentFilmData = Intent(this, FilmDataActivity::class.java)
            intentFilmData.putExtra("pos", position)

            startActivity(intentFilmData)

        }
        binding.lista.choiceMode=ListView.CHOICE_MODE_MULTIPLE
        binding.lista.setMultiChoiceModeListener(object: MultiChoiceModeListener{
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                val inflater = p0?.menuInflater
                inflater?.inflate(R.menu.menu_contextual, p1)
                return true
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                if (p1 != null) {
                    return when (p1.itemId) {
                        R.id.action_settings -> {
                            accionConItemsSeleccionados(binding.lista.checkedItemIds)
                            p0?.finish()
                            return true
                        }

                        else -> return false
                    }
                }
                return false
            }

            override fun onDestroyActionMode(p0: ActionMode?) {
                TODO("Not yet implemented")
            }

            override fun onItemCheckedStateChanged(
                p0: ActionMode?,
                p1: Int,
                p2: Long,
                p3: Boolean
            ) {

            }
        })


    }

    private fun accionConItemsSeleccionados(selectedItemIds: LongArray) {
        for (id in selectedItemIds) {
            FilmDataSource.films.removeAt(id.toInt())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        // Creamos el elemento con todos estos datos
        menu?.add(Menu.NONE, ID_MENU_FILM, Menu.NONE, "Añadir pelicula")
        menu?.add(Menu.NONE, ID_MENU_ABOUT, Menu.NONE, "Acerca de")
        return true
    }
    override fun onOptionsItemSelected(elemento: MenuItem): Boolean {
        super.onOptionsItemSelected(elemento)
        when (elemento.itemId) {
            ID_MENU_FILM -> {
                cont++
                val film= Film()
                film.title= "Pelicula nueva $cont"
                film.genre= 0
                film.director="Director1"
                film.imdbUrl = "http://www.imdb.com/title/tt0088763"
                film.year= 2022
                film.format=0
                film.imageResId=R.mipmap.ic_launcher
                film.comments="--------"
                FilmDataSource.films.add(film)
                val listAdapter = findViewById<ListView>(R.id.lista).adapter as FilmAdapter
                listAdapter.notifyDataSetChanged()
                //val recyclerAdapter = findViewById<RecyclerView>(R.id.lista_peliculas).adapter as FilmAdapterRecycler
               // recyclerAdapter.notifyDataSetChanged()
                return true
            }
            ID_MENU_ABOUT-> {
                startActivity(Intent(this, AboutActivity::class.java))
                return true
            }
        }

        return false
    }





}


