package es.ua.eps.filmoteca1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmAdapterRecycler(films: MutableList<Film>) : RecyclerView.Adapter<FilmAdapterRecycler.ViewHolder?>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var nombre: TextView
        var director: TextView
        var icono: ImageView

        fun bind(l: Film) {
            nombre.text = l.title
            director.text = l.director
            icono.setImageResource(l.imageResId)
        }

        init {
            nombre = v.findViewById(R.id.nombre)
            director = v.findViewById(R.id.director)
            icono = v.findViewById(R.id.icono)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return FilmDataSource.films.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(FilmDataSource.films[position])
    }
}