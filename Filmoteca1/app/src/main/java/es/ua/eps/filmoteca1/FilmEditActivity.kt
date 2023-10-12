package es.ua.eps.filmoteca1

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import es.ua.eps.filmoteca1.databinding.ActivityFilmEditBinding


class FilmEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFilmEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pos=intent.getIntExtra("pos",0)

        binding.guardarBoton.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent() )
            binding.spinnerFormat.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    FilmDataSource.films[pos].format=  p0?.getItemAtPosition(p2) as Int
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
            binding.spinnerGenro.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    FilmDataSource.films[pos].genre=  p0?.getItemAtPosition(p2) as Int
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
            if(!binding.comentariosEdit.text.isEmpty()) {
                FilmDataSource.films[pos].comments = binding.comentariosEdit.text.toString()
            }
            if(!binding.editUrl.text.isEmpty()) {
                FilmDataSource.films[pos].imdbUrl=binding.editUrl.text.toString()


            }
            if(!binding.editAnio.text.isEmpty()) {
                FilmDataSource.films[pos].year=  binding.editAnio.text.toString().toInt()


            }
            if(!binding.editTitulo.text.isEmpty()) {
            FilmDataSource.films[pos].title=  binding.editTitulo.text.toString()


        }
            if(!binding.editDirector.text.isEmpty()) {
            FilmDataSource.films[pos].director=binding.editDirector.text.toString()


        }



            finish()
        }
        binding.cancelarBoton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED, Intent())
            finish()
        }

        binding.botonCamara.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
            }else{
                openCamera()
            }

        }
        binding.botonImagen.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 2)

            }else{
                openGallery()
            }
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivity(intent)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(packageManager)!=null){
            startActivity(intent)
        }
    }
}