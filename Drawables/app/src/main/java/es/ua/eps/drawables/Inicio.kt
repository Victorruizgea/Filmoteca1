package es.ua.eps.drawables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.drawables.databinding.ActivityMain2Binding

class Inicio : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ejDrawables.setOnClickListener { startActivity(Intent(this,Drawables::class.java)) }
        binding.ejComponentes.setOnClickListener{startActivity(Intent(this,Componentes::class.java))}
        binding.notificaciones.setOnClickListener{startActivity(Intent(this,Notificaciones::class.java))}
        binding.pantallaTactil.setOnClickListener { startActivity(Intent(this,PantallaTactil::class.java)) }
        binding.estilosBoton.setOnClickListener { startActivity(Intent(this,Estilos1::class.java)) }
        binding.hilosThread.setOnClickListener { startActivity(Intent(this,HilosThread::class.java)) }
        binding.hilosCorrutinas.setOnClickListener { startActivity(Intent(this,HilosCorrutinas::class.java)) }
        binding.hilosAsyntask.setOnClickListener { startActivity(Intent(this,HilosAsynTask::class.java)) }

    }
}