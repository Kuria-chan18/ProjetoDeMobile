package com.example.joquempo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private Switch option1;
    private Switch option2;
    private Switch option3;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backButton = findViewById(R.id.button_back);

        option1 = findViewById(R.id.switch_option1);
        option2 = findViewById(R.id.switch_option2);
        option3 = findViewById(R.id.switch_option3);

        // Defina os listeners de clique ou lógica adicional para as opções, se necessário
        option1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Lógica para a opção 1
        });

        option2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Lógica para a opção 2
        });

        option3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Lógica para a opção 3
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para a tela principal
                finish();
            }
        });
    }
}
