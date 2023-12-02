package com.ua.servidorsocket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServidorActivity extends AppCompatActivity {
    private Button enviarmensaje;

    public static final int SERVER_PORT = 5050;
    private EditText message;
    private Button iniciar;
    private ServerSocket serverSocket;
    Thread serverThread = null;

    private Socket clientSocket;
    private LinearLayout msgList;
    private Handler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servidor);
        handler=new Handler();
        msgList=findViewById(R.id.msgList);

        iniciar=findViewById(R.id.start_server);
        enviarmensaje=findViewById(R.id.send_data);
        message=findViewById(R.id.edMessage);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               msgList.removeAllViews();
                showMessage("Server Started.", Color.BLACK, false);

                //this initiates the serverthread defined later and starts the thread
                serverThread = new Thread(new ServerThread());
                serverThread.start();
                view.setVisibility(View.GONE);

            }
        });
        enviarmensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = message.getText().toString().trim();
                showMessage("Server : " + msg, Color.BLUE, false);
                if (msg.length() > 0) {

                    sendMessage(msg);
                }
                message.setText("");
            }
        });
        String emulatorIpAddress = getEmulatorIpAddress();
        showMessage("Emulator IP Address: " + emulatorIpAddress, Color.BLACK, false);

    }
    private String getEmulatorIpAddress() {
        try {
            // Utiliza "10.0.2.2" para acceder al localhost del sistema anfitrión desde el emulador
            return InetAddress.getByName("10.0.2.2").getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Error obteniendo la dirección IP";
        }
    }
    public void showMessage(final String message, final int color, final Boolean value) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                msgList.addView(textView(message, color, value));
            }
        });
    }


    public TextView textView(String message, int color, Boolean value) {

        //it checks if the message is empty then displays empty message
        if (null == message || message.trim().isEmpty()) {
            message = "<Empty Message>";
        }
        TextView tv = new TextView(this);
        tv.setTextColor(color);
        tv.setText(message + " [" + getTime() +"]");
        tv.setTextSize(20);
        tv.setPadding(0, 5, 0, 0);
        if (value) {
            tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        }
        return tv;
    }
    private void sendMessage(final String message) {
        try {
            if (null != clientSocket) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PrintWriter out = null;
                        try {
                            out = new PrintWriter(new BufferedWriter(
                                    new OutputStreamWriter(clientSocket.getOutputStream())),
                                    true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        out.println(message);
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != serverThread) {
            sendMessage("Disconnect");
            serverThread.interrupt();
            serverThread = null;
        }
    }
    class ServerThread implements Runnable {

        public void run() {
            Socket socket;
            try {
                serverSocket = new ServerSocket(SERVER_PORT);

                //deactivates the visibility of the button
//               Button button = (Button) findViewById(R.id.start_server);
//               button.setVisibility(View.GONE);
            } catch (IOException e) {
                e.printStackTrace();
                showMessage("Error Starting Server : " + e.getMessage(), Color.RED, false);
            }

            //communicates to client and displays error if communication fails
            if (null != serverSocket) {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        socket = serverSocket.accept();
                        CommunicationThread commThread = new CommunicationThread(socket);
                        new Thread(commThread).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                        showMessage("Error Communicating to Client :" + e.getMessage(), Color.RED, false);
                    }
                }
            }
        }
    }
    class CommunicationThread implements Runnable {

        private Socket clientSocket;

        private BufferedReader input;

        public CommunicationThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
            clientSocket = clientSocket;
            try {
                this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
                showMessage("Error Connecting to Client!!", Color.RED, false);
            }
            showMessage("Connected to Client!!", ContextCompat.getColor(ServidorActivity.this,R.color.white), true);
        }

        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                try {

                    //checks to see if the client is still connected and displays disconnected if disconnected
                    String read = input.readLine();
                    if (null == read || "Disconnect".contentEquals(read)) {
                        Thread.interrupted();
                        read = "Offline....";
                        showMessage("Client : " + read, ContextCompat.getColor(ServidorActivity.this,R.color.white), true);
                        break;
                    }
                    showMessage("Client : " + read, ContextCompat.getColor(ServidorActivity.this,R.color.white), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}