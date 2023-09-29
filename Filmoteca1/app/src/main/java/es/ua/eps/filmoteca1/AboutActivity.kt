package es.ua.eps.filmoteca1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.ua.eps.filmoteca1.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val supportIntent=Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:victorruizgea@gmail.com"))
            if(supportIntent.resolveActivity(packageManager)!=null){
                startActivity(supportIntent)
            }

        }
        binding.button2.setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            if (webIntent.resolveActivity(packageManager) != null) { //para comprobar si encuentra alguna actividad que cumpla con la funcion
                startActivity(webIntent)
            }
        }
        binding.button3.setOnClickListener {
            finish()
        }

    }
}