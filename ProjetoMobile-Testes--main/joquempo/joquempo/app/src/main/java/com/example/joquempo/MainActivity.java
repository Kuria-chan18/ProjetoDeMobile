package com.example.joquempo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import android.content.Context;
import android.net.wifi.WifiManager;

public class MainActivity extends AppCompatActivity {

    private WifiManager wifiManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            // Inicializar WifiManager
            wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

            // Verificar se o Wi-Fi está habilitado
            if (!wifiManager.isWifiEnabled()) {
                // Habilitar Wi-Fi
                wifiManager.setWifiEnabled(true);
            }


    }
    public void  selecionadoPedra (View view) {
        this.opcaoSelecionada("pedra");
    }
    public void selecionadoPapel (View view) {
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura (View view) {
      this.opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imageResultado = findViewById(R.id.imageResultado);
         TextView textResultado = findViewById(R.id.textResultado);

        int numero= new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];
        switch (opcaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;}


        if ((opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
            (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
             (opcaoApp == "pedra" && opcaoSelecionada == "tesoura"))
        {
            textResultado.setText("Você perdeu :( ");
        } else if (
                (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura"))
        {
            textResultado.setText("Você ganhou! :D ");
        } else {
            textResultado.setText("Empatamos ;)");
        }


        System.out.println("foi clicado em" + opcaoSelecionada);
    }

}