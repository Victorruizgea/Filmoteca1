package es.ua.eps.filmoteca1

object FilmDataSource {
    val films: MutableList<Film> = mutableListOf<Film>()

    init {
        var f = Film()
        f.title = "Regreso al futuro"
        f.director = "Robert Zemeckis"
        f.imageResId = R.mipmap.ic_launcher
        f.comments = ""
        f.format = Film.Companion.FORMAT_DIGITAL
        f.genre = Film.Companion.GENRE_SCIFI
        f.imdbUrl = "http://www.imdb.com/title/tt0088763"
        f.year = 1985
        films.add(f)

        var f1 = Film()
        f1.title = "Regreso al futuro II"
        f1.director = "Robert Zemeckis"
        f1.imageResId = R.mipmap.ic_launcher
        f1.comments = ""
        f1.format = Film.Companion.FORMAT_DIGITAL
        f1.genre = Film.Companion.GENRE_SCIFI
        f1.imdbUrl = "http://www.imdb.com/title/tt0088763"
        f1.year = 1986
        films.add(f1)
        var f2 = Film()
        f2.title = "Regreso al futuro III"
        f2.director = "Robert Zemeckis"
        f2.imageResId = R.mipmap.ic_launcher
        f2.comments = ""
        f2.format = Film.Companion.FORMAT_DIGITAL
        f2.genre = Film.Companion.GENRE_SCIFI
        f2.imdbUrl = "http://www.imdb.com/title/tt0088763"
        f2.year = 1986
        films.add(f2)

        var f3 = Film()
        f3.title = "Los cazafantasmas"
        f3.director = "Robert Zemeckis"
        f3.imageResId = R.mipmap.ic_launcher
        f3.comments = ""
        f3.format = Film.Companion.FORMAT_DIGITAL
        f3.genre = Film.Companion.GENRE_SCIFI
        f3.imdbUrl = "http://www.imdb.com/title/tt0088763"
        f3.year = 1986
        films.add(f3)



        // Añade tantas películas como quieras!
    }
}