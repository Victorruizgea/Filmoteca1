package es.ua.eps.filmoteca1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FilmAdapter(context: Context?, resource: Int,
    objects: List<Film>?) : ArrayAdapter<Film>(context!!, resource, objects!!) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View = convertView?: LayoutInflater.from(this.context).inflate(R.layout.item_film, parent, false)
        val nombreFilm = view.findViewById(R.id.nombre) as TextView
        val directorFilm = view.findViewById(R.id.director) as TextView
        val imageFilm = view.findViewById(R.id.icono) as ImageView

        getItem(position)?.let {
            nombreFilm.text = it.title
            directorFilm.text = it.director
            imageFilm.setImageResource(it.imageResId)
        }
        return view
    }
}