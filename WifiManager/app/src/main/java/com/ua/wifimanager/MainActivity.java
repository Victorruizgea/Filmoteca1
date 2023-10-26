package com.ua.wifimanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String service= Context.WIFI_SERVICE;
        WifiManager wifi= (WifiManager) getSystemService(service);
        WifiInfo info= wifi.getConnectionInfo();
        DhcpInfo dhcpInfo = wifi.getDhcpInfo();
        String bssid = info.getBSSID();
        if(bssid!=null){
            int strength = WifiManager.calculateSignalLevel(info.getRssi(),5);
            int speed = info.getLinkSpeed();
            String units=WifiInfo.LINK_SPEED_UNITS;
            int frequency = info.getFrequency();
            String ssid = info.getSSID().toString();
            int ipAddress = dhcpInfo.ipAddress;
            int gateway = dhcpInfo.gateway;
            int subnetMask = dhcpInfo.netmask;
            String ip = intToIp(ipAddress);
            String gatewayIp = intToIp(gateway);
            String subnetMaskIp = intToIp(subnetMask);
            boolean isHidden = info.getHiddenSSID();
            String cSummary= String.format("Connected to %s at %s%s. Strength %s/5",ssid,speed,units,strength);
            String textWifi = "SSID: " + ssid + "\n" +
                    "BSSID: " + bssid + "\n" +
                    "Frecuencia: " + frequency + " MHz\n" +
                    "Velocidad: " + speed + " Mbps\n" +
                    "Fuerza de señal: " + strength + " dBm\n" +
                    "¿Está oculta la red?: " + isHidden + "\n" +
                    "Dirección IP: " + ip + "\n" +
                    "Puerta de enlace: " + gatewayIp + "\n" +
                    "Máscara de subred: " + subnetMaskIp+"\n"+"\n"+cSummary;


            TextView text= findViewById(R.id.textWifi);
            text.setText(textWifi);

        }
    }
    private static String intToIp(int ipAddress) {
        return ((ipAddress & 0xFF) + "." + ((ipAddress >> 8) & 0xFF) + "." +
                ((ipAddress >> 16) & 0xFF) + "." + (ipAddress >> 24 & 0xFF));
    }
}