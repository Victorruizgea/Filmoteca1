package es.ua.eps.drawables

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class GraficaView: View {
    private var percentage: Int = 0

    constructor(context: Context?) : super(context) { inicializar(null) }
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) { inicializar(attrs) }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) { inicializar(attrs) }

    private fun inicializar(attrs: AttributeSet?) {
        if (attrs == null) return
        val ta = context.obtainStyledAttributes(
            attrs, R.styleable.Grafica )
        this.percentage = ta.getInt(R.styleable.Grafica_percentage, 0)

    }
    fun setPercentage(percentage: Int) {
        this.percentage = percentage
        invalidate()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val width = canvas!!.clipBounds.width().toFloat()
        val height = canvas!!.clipBounds.height().toFloat()
        val radius = width.coerceAtMost(height) / 2f
        val centerX = width / 2
        val centerY = height / 2
        val oval = RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius)


        // Dibuja el sector rojo (porcentaje indicado)

        val paint2= Paint()
        paint2.style = Paint.Style.FILL
        paint2.color = Color.BLUE
        canvas!!.drawArc(oval,0f, 360f,true,paint2)

        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        canvas!!.drawArc(oval,270F, ((percentage.toFloat()*360F)/100),true,paint)




    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(200,200)
    }
}