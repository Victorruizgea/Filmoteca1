package es.ua.eps.acelerometro

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.SensorManager.SENSOR_DELAY_FASTEST
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(),SensorEventListener {

    private var sensor: Sensor? = null
    private lateinit var sensorManager: SensorManager
    private lateinit var txt_X: TextView
    private lateinit var txt_Y:TextView
    private lateinit var txt_Z:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt_X=findViewById(R.id.posX)
        txt_Y=findViewById(R.id.posY)
        txt_Z=findViewById(R.id.posZ)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if(sensorManager!=null){
            sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        }
        if(sensor!=null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also{
                sensorManager.registerListener(this,sensor,SENSOR_DELAY_FASTEST,SENSOR_DELAY_FASTEST)
            }
        }



    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type==Sensor.TYPE_ACCELEROMETER){
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            txt_X.text="X: ${x.toInt()}";
            txt_Y.text="Y: ${y.toInt()}";
            txt_Z.text="Z: ${z.toInt()}";

        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")

    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this)

        super.onDestroy()
    }
}