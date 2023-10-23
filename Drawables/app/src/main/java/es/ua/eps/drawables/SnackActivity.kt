package es.ua.eps.drawables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import java.lang.reflect.Array

class SnackActivity : AppCompatActivity() {
    lateinit var listaTareas: ArrayList<String>
    lateinit var editText: EditText
    lateinit var listaText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack)

        var button= findViewById<Button>(R.id.boton1)
        listaTareas=ArrayList()
        editText=findViewById(R.id.editTareas)
        listaText=findViewById(R.id.listaTareas)

        button.setOnClickListener{
            if(editText.text.isEmpty()){
                Snackbar.make(it, "Escribe algo", Snackbar.LENGTH_LONG).show()

            }else{
                listaTareas.add(editText.text.toString())
                listaText.append( editText.text.toString()+"\n")
                Snackbar.make(it, "Tarea añadida", Snackbar.LENGTH_LONG)
                    .setAction("Deshacer"){
                        listaTareas.removeLast()
                        val listaTareasTexto = listaTareas.joinToString("\n")
                        listaText.text=listaTareasTexto
                    }
                    .show()
                editText.setText("")
            }

        }
    }
}