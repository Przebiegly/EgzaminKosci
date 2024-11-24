package com.example.egzaminkosci;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final int[] diceImages = {
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
    };

    private ImageView[] imgLoyout;
    private TextView wyniklosowania, wynikgry;
    private Button rollButton, resetButton;
    private int wynik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imgLoyout = new ImageView[]{
                findViewById(R.id.image1),
                findViewById(R.id.image2),
                findViewById(R.id.image3),
                findViewById(R.id.image4),
                findViewById(R.id.image5)
        };

        wyniklosowania = findViewById(R.id.wyniklosowania);
        wynikgry = findViewById(R.id.wynikgry);
        rollButton = findViewById(R.id.rollButton);
        resetButton = findViewById(R.id.resetButton);

        rollButton.setOnClickListener(v -> rollDice());

        resetButton.setOnClickListener(v -> resetGame());
    }

    private void rollDice() {
        Random random = new Random();
        int rollResult = 0;

        // Losowanie dla 5 kostek
        for (ImageView diceImageView : imgLoyout) {
            int diceValue = random.nextInt(6);
            diceImageView.setImageResource(diceImages[diceValue]);
            rollResult += (diceValue + 1);
        }

        wyniklosowania.setText("Wynik tego losowania: " + rollResult);

        wynik += rollResult;
        wynikgry.setText("Wynik gry: " + wynik);
    }

    private void resetGame() {
        for (ImageView diceImageView : imgLoyout) {
            diceImageView.setImageResource(R.drawable.img_6);
        }

        wyniklosowania.setText("Wynik tego losowania: 0");
        wynik = 0;
        wynikgry.setText("Wynik gry: 0");
    }
}
