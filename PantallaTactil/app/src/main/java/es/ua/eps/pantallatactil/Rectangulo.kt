package es.ua.eps.pantallatactil

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Rectangulo: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private val paint= Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        crearRectangulo(canvas)
    }

    fun crearRectangulo(canvas: Canvas?){

        paint.style= Paint.Style.FILL
        paint.strokeWidth=5F
        paint.color= Color.RED
        canvas!!.drawRect(RectF(180F,20F,220F,80F),paint)
    }
}