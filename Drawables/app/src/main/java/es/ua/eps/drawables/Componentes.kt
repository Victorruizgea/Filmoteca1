package es.ua.eps.drawables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast

class Componentes : AppCompatActivity() {
     lateinit var grafica: GraficaView
     lateinit var bar: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_componentes)

        grafica=findViewById(R.id.graficaView)
        bar= findViewById(R.id.seekBar)
        bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                grafica.setPercentage(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@Componentes,"Cambiando de porcentaje",Toast.LENGTH_LONG).show()

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@Componentes,"Parado",Toast.LENGTH_LONG).show()

            }


        })


    }
}