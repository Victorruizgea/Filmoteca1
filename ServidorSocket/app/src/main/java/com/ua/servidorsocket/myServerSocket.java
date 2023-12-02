package com.ua.servidorsocket;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class myServerSocket extends Thread implements  Runnable{
    private ServerSocket serverSocket;
    private int port;
    private boolean serverRunning;
    private int count=0;


    public myServerSocket(int port){
        this.port=port;
    }

    public void startServer(){
        serverRunning=true;
        start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            Log.d("Server","Esperando clientes");

            while(serverRunning){
                Socket clientSocket=serverSocket.accept();
                count++;
                Log.d("Cliente con ip:"+clientSocket.getInetAddress()," Conectado");
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.write("Hola, cliente!"+count);
                out.flush();

                clientSocket.close();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public void stopServer() {
        serverRunning=false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }).start();

    }

    public String getIp() {
        return serverSocket.getInetAddress().getHostAddress();
    }
    public int getPort(){
        return serverSocket.getLocalPort();
    }
}
