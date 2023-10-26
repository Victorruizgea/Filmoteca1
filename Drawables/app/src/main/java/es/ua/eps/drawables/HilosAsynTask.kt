package es.ua.eps.drawables

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HilosAsynTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilos_asyn_task)
        val tvCrono = findViewById<TextView>(R.id.tvCrono)

        val asyncTask = object : AsyncTask<Unit, Int, Unit>() {
            override fun doInBackground(vararg params: Unit?) {
                var t = 10
                while (t > 0) {
                    publishProgress(t)
                    Thread.sleep(1000)
                    t--
                }
            }

            override fun onProgressUpdate(vararg values: Int?) {
                val t = values[0]
                tvCrono.text = "Contador: $t"
            }


            override fun onPostExecute(result: Unit?) {
                tvCrono.text = "Contador terminado"
            }
        }

        asyncTask.execute()
    }
}