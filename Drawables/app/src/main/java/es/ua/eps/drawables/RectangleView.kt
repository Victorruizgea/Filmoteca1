package es.ua.eps.drawables

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat

class RectangleView: View , GestureDetector.OnGestureListener{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    var mX:Float = 0f
    var mY:Float = 0f
    var colorRect=false
    var mDetector = GestureDetectorCompat(context, this)
    var fling = false
    var flingStartX: Float = 0f
    var flingStartY: Float = 0f
    var flingEndX: Float=0f
    var flingEndY: Float=0f
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            mDetector?.onTouchEvent(event)
        }
        return true

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var paint=Paint()
        paint.style= Paint.Style.FILL
        if(!colorRect){
            paint.color= Color.RED
        }else{
            paint.color= Color.BLUE
        }


        canvas?.drawRect(mX, mY, mX + 50, mY + 50, paint)
        if(fling){
            var paint2=Paint()
            paint2.style= Paint.Style.FILL
            paint2.color=Color.BLACK
            canvas?.drawLine(flingStartX,flingStartY,flingEndX,flingEndY,paint2)
            fling=false
        }

    }

    override fun onDown(p0: MotionEvent): Boolean {
        var a = p0.x >= mX && p0.x <= mX + 50 && p0.y >= mY && p0.y <= mY + 50
        this.invalidate()
        return a

    }

    override fun onShowPress(p0: MotionEvent) {

        this.invalidate()

    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        colorRect = !colorRect
        this.invalidate()
        return true
    }

    override fun onScroll(p0: MotionEvent, p1: MotionEvent, p2: Float, p3: Float): Boolean {
            mX = p1.x
            mY = p1.y
            this.invalidate()

        return true
    }

    override fun onLongPress(p0: MotionEvent) {


        this.invalidate()
    }

    override fun onFling(p0: MotionEvent, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        fling=true
        flingStartX=p0.x
        flingStartY=p0.y
        flingEndX=p1.x
        flingEndY=p1.y

        mX=flingEndX
        mY=flingEndY
        this.invalidate()
        return true
    }


}