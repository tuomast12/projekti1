package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ScaleActivity extends AppCompatActivity {

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_KA = "ka";
    private static final String KEY_MAARA = "maara";
    private static final String KEY_SUMMA = "summa";

    SharedPreferences prefs;

    private TextView viimeisenPaivanTextView;
    private TextView kaTextView;
    private Mieliala asteikko;
    private double vkoKa;
    private String stringKa;
    private String vkoKaString;
    private TextView testitext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        prefs = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        int summa = prefs.getInt(KEY_SUMMA, 0);
        int maara = prefs.getInt(KEY_MAARA, 0);

        asteikko = new Mieliala(summa, maara);

        viimeisenPaivanTextView = findViewById(R.id.viimeisenPaivanTextView);
        kaTextView = findViewById(R.id.kaTextView);

    }

    private void updateTextViews(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        stringKa = prefs.getString(KEY_KA,"");
        vkoKa = asteikko.getKa();
        vkoKaString = String.format("%.2f", vkoKa);
        if(asteikko.getMaara() < 7) {
            viimeisenPaivanTextView.setText(String.format("Viimeisen " + asteikko.getMaara() + " päivän keskiarvosi:"));
        } else {
            viimeisenPaivanTextView.setText(String.format("Viimeisen " + 7 + " päivän keskiarvosi:"));
        }
        kaTextView.setText(stringKa);
    }

    public void onButtonClicked(View v) {

        SharedPreferences.Editor editor = prefs.edit();
        String savedDate = prefs.getString("date", "");
        String dateNow = DateFormat.format("MM/dd/yyyy", new Date((new Date()).getTime())).toString();

        switch (v.getId()) {
            case R.id.buttonLoistava:
                if("".equals(savedDate)){
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(5);
                } else if(savedDate.equals(dateNow)) {
                    Toast.makeText(getApplicationContext(), "Olet jo painanut nappia tänään.", Toast.LENGTH_SHORT).show();
                } else {
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(5);
                }
                break;
            case R.id.buttonHyvä:
                if("".equals(savedDate)){
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(4);
                } else if(savedDate.equals(dateNow)) {
                    Toast.makeText(getApplicationContext(), "Olet jo painanut nappia tänään.", Toast.LENGTH_SHORT).show();
                } else {
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(4);
                }
                break;
            case R.id.buttonKohtalainen:
                if("".equals(savedDate)){
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(3);
                } else if(savedDate.equals(dateNow)) {
                    Toast.makeText(getApplicationContext(), "Olet jo painanut nappia tänään.", Toast.LENGTH_SHORT).show();
                } else {
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(3);
                }
                break;
            case R.id.buttonHuono:
                if("".equals(savedDate)){
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(2);
                } else if(savedDate.equals(dateNow)) {
                    Toast.makeText(getApplicationContext(), "Olet jo painanut nappia tänään.", Toast.LENGTH_SHORT).show();
                } else {
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(2);
                }
                break;
            case R.id.buttonSurkea:
                if("".equals(savedDate)){
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(1);
                } else if(savedDate.equals(dateNow)) {
                    Toast.makeText(getApplicationContext(), "Olet jo painanut nappia tänään.", Toast.LENGTH_SHORT).show();
                } else {
                    asteikko.lisaaMaara();
                    asteikko.lisaaSumma(1);
                }
                break;
            case R.id.takaisinButton:
                startActivity(new Intent(ScaleActivity.this, MainActivity.class));
                break;
        }
        stringKa = asteikko.getStringKa();
        String dateString = DateFormat.format("MM/dd/yyyy", new Date((new Date()).getTime())).toString();
        editor.putString("date", dateString);
        editor.putString(KEY_KA,stringKa);
        editor.commit();
        updateTextViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateTextViews();
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_KA, asteikko.getStringKa()).putInt(KEY_SUMMA, asteikko.getSumma()).putInt(KEY_MAARA, asteikko.getMaara()).apply();
    }
}