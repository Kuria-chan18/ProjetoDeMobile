package com.example.joquempo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Ranking extends AppCompatActivity {

    private ListView rankingListView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankingListView = findViewById(R.id.ranking_list);
        backButton = findViewById(R.id.button_back);

        List<String> rankings = new ArrayList<>();
        // Adicione dados de exemplo para o ranking
        rankings.add("1. Player1 - 1000 pontos");
        rankings.add("2. Player2 - 900 pontos");
        rankings.add("3. Player3 - 850 pontos");
        // Continue adicionando dados conforme necessário

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rankings);
        rankingListView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para a tela principal
                finish();
            }
        });
    }
}
