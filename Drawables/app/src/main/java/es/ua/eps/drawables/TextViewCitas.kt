package es.ua.eps.drawables

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import java.util.Random

class TextViewCitas @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr), View.OnClickListener {
    private var citas: Array<String> = arrayOf(
    "La vida es como una bicicleta, para mantener el equilibrio, debes seguir adelante. - Albert Einstein",
    "No dejes para mañana lo que puedas hacer hoy. - Benjamin Franklin",
    "El único modo de hacer un gran trabajo es amar lo que haces. - Steve Jobs",
    "El éxito es la suma de pequeños esfuerzos repetidos día tras día. - Robert Collier"
    )
    private val random= Random()
    init {
        setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val indice = random.nextInt(citas.size)
        text= citas[indice]

    }


}