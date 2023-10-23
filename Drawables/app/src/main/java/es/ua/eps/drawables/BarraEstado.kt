package es.ua.eps.drawables

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService

class BarraEstado : AppCompatActivity() {
    val CHANNEL_ID = "channel_id"
    var cont = 0
    var NOTIF_ID= 15
    lateinit var botonIniciar: Button
    lateinit var botonDetener: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barra_estado)
        botonIniciar= findViewById(R.id.iniciarBoton)
        botonDetener = findViewById(R.id.detenerBoton)

        createNotificationChannel();
        val notificationIntent = Intent(this, Inicio::class.java)
        val pi = PendingIntent.getActivity(this, 0, notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.icono_notificacion)
            .setContentTitle("Notificacion")
            .setContentText("Tareas iniciadas: $cont")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        builder.setContentIntent(pi)

        val notificationManager = NotificationManagerCompat.from(this)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.POST_NOTIFICATIONS)) {
                // Mostrar explicación adicional
            } else {
                // Solicitamos el permiso...
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
            }
            return
        }

        botonIniciar.setOnClickListener {
            cont++
            builder.setContentText("Tareas iniciadas: $cont")
            notificationManager.notify(1, builder.build())



        }

        botonDetener.setOnClickListener {
            cont--
            if(cont==0){
                notificationManager.cancel(1)
            }else {
                builder.setContentText("Tareas iniciadas: $cont")
                notificationManager.notify(1, builder.build())
            }
        }



    }




    private fun createNotificationChannel() {
        // Crear el canal solo para API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Tareas"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = "Es un canal de prueba"

            // Registramos el canal en el sistema
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}