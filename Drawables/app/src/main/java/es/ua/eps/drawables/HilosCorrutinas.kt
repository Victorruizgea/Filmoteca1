package es.ua.eps.drawables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HilosCorrutinas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilos_corrutinas)

        val tvCrono = findViewById<TextView>(R.id.tvCrono)
        val job = GlobalScope.launch {
            var t = 10
            while (t > 0) {
                withContext(Dispatchers.Main) {
                    tvCrono.text = "Contador: $t"
                }
                delay(1000)
                t--
            }
            withContext(Dispatchers.Main) {
                tvCrono.text = "Contador terminado"
            }
        }
        job.start()

    }
}