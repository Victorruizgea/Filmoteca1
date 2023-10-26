package es.ua.eps.filmoteca1

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerListActivity : Activity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_list)

        recyclerView = findViewById(R.id.lista_peliculas)
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        val adapter = FilmAdapterRecycler(FilmDataSource.films)
        recyclerView?.adapter = adapter
        this.adapter = adapter
    }
}