package es.ua.eps.drawables

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class EdicionBorrable: LinearLayout {
    var editText : EditText? = null
    var button : Button? = null

    constructor(context: Context?) : super(context){
        inicializar()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        inicializar()
    }


    private fun inicializar() {
        // Creamos la interfaz a partir del layout
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        li.inflate(R.layout.edicionborrable,this,true)

        // Obtenemos las referencias a las vistas hijas
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        button!!.setOnClickListener{editText!!.setText("")}

    }
}