package es.ua.eps.drawables

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Notificaciones : AppCompatActivity() {
    lateinit var boton: Button
    lateinit var editText: EditText
    lateinit var textoDialog: TextView
    lateinit var colorBoton: Button
    lateinit var tamBoton: Button
    lateinit var barraEstadoBoton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones)

        boton= findViewById(R.id.botonNot)
        colorBoton=findViewById(R.id.botonColor)
        tamBoton=findViewById(R.id.botonTam)
        textoDialog=findViewById(R.id.textDialog)
        barraEstadoBoton=findViewById(R.id.barraBoton)
        editText=findViewById(R.id.editNotification)
        val layout = layoutInflater.inflate(R.layout.toast_layout, null)

        boton.setOnClickListener{
            if(editText.text.isEmpty()){
                layout!!.findViewById<TextView>(R.id.txtMensaje).text = "Escribe algo"
            }else{
                layout!!.findViewById<TextView>(R.id.txtMensaje).text = editText.text
                editText.setText("")
            }
            val t3 = Toast(this@Notificaciones)
            t3.duration = Toast.LENGTH_LONG
            t3.setGravity(Gravity.CENTER, 0, 0)

            t3.view = layout
            t3.show()
        }

        var botonSnack= findViewById<Button>(R.id.snackBarEj)
        botonSnack.setOnClickListener{
            startActivity(Intent(this,SnackActivity::class.java))
        }
        barraEstadoBoton.setOnClickListener { startActivity(Intent(this,BarraEstado::class.java)) }

        colorBoton.setOnClickListener {
            val colores = arrayOf("Blanco y Negro", "Negro y Blanco", "Negro y Verde")

            AlertDialog.Builder(this)
                .setTitle("Selecciona tu idioma")
                .setItems(colores) { dialog, which ->
                    when (which){
                        0 -> cambiarColor(Color.WHITE,Color.BLACK)
                        1-> cambiarColor(Color.BLACK,Color.WHITE)
                        2-> cambiarColor(Color.BLACK,Color.GREEN)
                    }
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
        tamBoton.setOnClickListener {
            val tam = arrayOf("Pequeño", "Normal", "Grande")

            AlertDialog.Builder(this)
                .setTitle("Selecciona tu idioma")
                .setItems(tam) { dialog, which ->
                    when (which){
                        0 -> cambiarTam(8F)
                        1-> cambiarTam(10F)
                        2-> cambiarTam(12F)
                    }
                }
                .setNegativeButton("Cancelar", null)
                .show() }




    }
    private fun cambiarColor(colorFondo: Int, colorTexto: Int) {
        textoDialog.setBackgroundColor(colorFondo)
        textoDialog.setTextColor(colorTexto)
    }

    private fun cambiarTam(tam: Float) {
        textoDialog.textSize = tam
    }
}