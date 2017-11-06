package com.example.asus.funfact.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.funfact.R;
import com.example.asus.funfact.komponen.ColorWheel;
import com.example.asus.funfact.komponen.FactBook;

import java.util.Random;

public class FunfactActivity extends AppCompatActivity implements View.OnClickListener {

    // statik variabel
    public static final boolean ENGLISH_LANG = true;
    public static final boolean INDONESIAN_LANG = false;

    TextView textfact; // life timenya lebih dari class sebelumnya
    Button btnShowFact, btnToggleLang , btnShowListFact;
    RelativeLayout relLayout;
    TextView labelTop;
    // variable komponen
    FactBook factbook;
    ColorWheel colorwheel;
    private boolean statLanguage = ENGLISH_LANG; // 0 untuk bahasa inggris 1 : bahasa indonesia
    // method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // akan hidup ketika sekali dipanggil
        // impelent class activity
        super.onCreate(savedInstanceState);
        // load layout
        setContentView(R.layout.activity_funfact);
        // rujuk view
        initView();


        // set listener
        btnShowFact.setOnClickListener(this);
        btnToggleLang.setOnClickListener(this);
        btnShowListFact.setOnClickListener(this);
    }
    private void initView(){
        // merujuk buton pada view kedalam object button
        btnShowFact = (Button) findViewById(R.id.button_funfact);
        // btnShowFact.setText("Show button changed text"); untuk mengubah teks pada button
        // merujuk text pada view
        textfact = (TextView) findViewById(R.id.fact_text);
        // merujuk realative
        relLayout = (RelativeLayout) findViewById(R.id.activity_funfact);
        // merujung button toggle language
        btnToggleLang = (Button) findViewById(R.id.toggle_lang);
        // merujuk label
        labelTop = (TextView) findViewById(R.id.label_top);
        // merujuk button show list fact
        btnShowListFact = (Button) findViewById(R.id.show_list);
    }

    // coba bikin
    // language controller
    //
    // tombol bahasa : toggle bahasa
    //
    @Override
    public void onClick(View view) {


        if ( view == btnShowFact){

            // random sebuah integer i
            factbook = new FactBook();
            // change text fact
            textfact.setText(factbook.getFact());
            // merandom warna
            colorwheel = new ColorWheel();
            int color = colorwheel.getColor();
            // change background
            relLayout.setBackgroundColor(color); // memanfaatkan static function
            btnShowFact.setTextColor(color);
    } else if (view == btnToggleLang) {
            // toggle language

            // mengubah setiap text view ke dalam bhasa id-en

            // toggle state language (0-- 1 1 --> 0)
            if (statLanguage == ENGLISH_LANG) {
                statLanguage = INDONESIAN_LANG;
                labelTop.setText(R.string.id_label_funfact_activity);
                btnShowFact.setText(R.string.id_button_funfact);
                btnToggleLang.setText(R.string.id_toggle_en);
                btnShowListFact.setText(R.string.id_showlist);
            } else {
                statLanguage = ENGLISH_LANG;
                labelTop.setText(R.string.en_label_funfact_activity);
                btnShowFact.setText(R.string.en_button_funfact);
                btnToggleLang.setText(R.string.en_toggle_en);
                btnShowListFact.setText(R.string.en_showlist);
            }
            // statlang -> textview
        }else if (view == btnShowListFact)
        {
            Intent intent = new Intent(getApplicationContext(), FunfactlistActivity.class);
            startActivity(intent);
            // tambahin extra

        }
        // untuk memunculkan tulisan ketika di click
        //Toast.makeText(getApplicationContext(), "Button clicked", Toast.LENGTH_SHORT).show();
    }
}
