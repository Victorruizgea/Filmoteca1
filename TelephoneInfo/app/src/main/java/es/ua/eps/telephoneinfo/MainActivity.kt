package es.ua.eps.telephoneinfo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.TextView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var telefono: TelephonyManager
    lateinit var txt1: TextView
    lateinit var txt2: TextView
    lateinit var txt3: TextView
    lateinit var txt4: TextView
    lateinit var txt5: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         telefono= getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        txt1=findViewById(R.id.textSim)
        txt2=findViewById(R.id.operatorName)
        txt3=findViewById(R.id.networkType)
        txt4=findViewById(R.id.subscriberId)
        txt5=findViewById(R.id.deviceId)

        //txt1.text=telefono.simSerialNumber
        txt2.text=telefono.simOperatorName
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
       txt3.text= telefono.networkType.toString()
        txt4.text=telefono.subscriberId
        txt5.text=telefono.deviceId

    }
}