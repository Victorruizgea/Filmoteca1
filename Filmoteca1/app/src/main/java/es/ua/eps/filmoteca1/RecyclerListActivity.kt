package es.ua.eps.filmoteca1

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerListActivity : Activity() {
    var recyclerView: RecyclerView? = null
    var adapter: RecyclerView.Adapter<*>? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_list)

        recyclerView = findViewById(R.id.lista_peliculas)
        layoutManager = LinearLayoutManager(this)
        recyclerView?.setLayoutManager(layoutManager)
        val adapter = FilmAdapterRecycler(FilmDataSource.films)
        recyclerView?.setAdapter(adapter)
        this.adapter = adapter
    }
}