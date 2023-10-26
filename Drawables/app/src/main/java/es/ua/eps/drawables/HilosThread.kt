package es.ua.eps.drawables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HilosThread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_hilos)

        val tvCrono = findViewById<TextView>(R.id.tvCrono)
        Thread {
            var t = 10
            while (t > 0) {
                runOnUiThread {
                    tvCrono.text = "Contador: $t"
                }
                Thread.sleep(1000)
                t--
            }
            runOnUiThread {
                tvCrono.text = "Contador terminado"
            }
        }.start()
    }
}