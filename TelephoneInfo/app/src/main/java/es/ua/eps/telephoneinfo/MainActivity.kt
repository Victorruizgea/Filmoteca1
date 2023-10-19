package es.ua.eps.telephoneinfo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.telephony.TelephonyManager.NETWORK_TYPE_EDGE
import android.telephony.TelephonyManager.NETWORK_TYPE_GPRS
import android.telephony.TelephonyManager.NETWORK_TYPE_HSDPA
import android.telephony.TelephonyManager.NETWORK_TYPE_HSPA
import android.telephony.TelephonyManager.NETWORK_TYPE_HSUPA
import android.telephony.TelephonyManager.NETWORK_TYPE_LTE
import android.telephony.TelephonyManager.NETWORK_TYPE_UMTS
import android.telephony.TelephonyManager.NETWORK_TYPE_UNKNOWN
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


        val imei = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            telefono.imei
        } else {

        }
        val operatorName = telefono.networkOperatorName
        val imsi = telefono.subscriberId
        val iccid = telefono.simSerialNumber
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        val networkType = when (telefono.networkType) {
            NETWORK_TYPE_GPRS -> "GPRS"
            NETWORK_TYPE_EDGE -> "EDGE"
            NETWORK_TYPE_UMTS -> "UMTS"
            NETWORK_TYPE_HSDPA -> "HSDPA"
            NETWORK_TYPE_HSUPA -> "HSUPA"
            NETWORK_TYPE_HSPA -> "HSPA"
            NETWORK_TYPE_LTE -> "LTE"
            NETWORK_TYPE_UNKNOWN -> "Desconocido"
            else -> "Otro"
        }
        txt1.text=iccid
        txt2.text=operatorName
        txt3.text= networkType
        txt4.text=imsi
        txt5.text= imei.toString()

    }
}