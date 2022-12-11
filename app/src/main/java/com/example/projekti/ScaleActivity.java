package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScaleActivity extends AppCompatActivity {

    private TextView viimeisenPaivanTextView;
    private TextView kaTextView;
    private Mieliala asteikko;
    private double ka;
    private String kaString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        asteikko = new Mieliala();

        viimeisenPaivanTextView = findViewById(R.id.viimeisenPaivanTextView);
        kaTextView = findViewById(R.id.kaTextView);
    }

    private void updateTextViews(){
        ka = asteikko.getKa();
        kaString = String.format("%.2f", ka);
        if(asteikko.getMaara() < 7) {
            viimeisenPaivanTextView.setText(String.format("Viimeisen " + asteikko.getMaara() + " päivän keskiarvosi:"));
        } else {
            viimeisenPaivanTextView.setText(String.format("Viimeisen " + 7 + " päivän keskiarvosi:"));
        }
        kaTextView.setText(kaString);
    }

    public void onButtonClicked(View v) {

        switch (v.getId()) {
            case R.id.buttonLoistava:
                asteikko.lisaaMaara();
                asteikko.lisaaSumma(5);
                break;
            case R.id.buttonHyvä:
                asteikko.lisaaMaara();
                asteikko.lisaaSumma(4);
                break;
            case R.id.buttonKohtalainen:
                asteikko.lisaaMaara();
                asteikko.lisaaSumma(3);
                break;
            case R.id.buttonHuono:
                asteikko.lisaaMaara();
                asteikko.lisaaSumma(2);
                break;
            case R.id.buttonSurkea:
                asteikko.lisaaMaara();
                asteikko.lisaaSumma(1);
                break;
            case R.id.takaisinButton:
                startActivity(new Intent(ScaleActivity.this, MainActivity.class));
                break;
        }
        updateTextViews();
    }
}