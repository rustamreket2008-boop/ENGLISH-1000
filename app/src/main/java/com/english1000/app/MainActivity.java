package com.english1000.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    private final int background = Color.rgb(7, 15, 30);
    private final int blue = Color.rgb(30, 136, 255);
    private final int yellow = Color.rgb(255, 210, 70);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setBackgroundColor(background);
        main.setPadding(14, 12, 14, 10);

        ImageView logo = new ImageView(this);
        logo.setImageResource(R.drawable.logo);
        logo.setScaleType(ImageView.ScaleType.FIT_CENTER);

        LinearLayout.LayoutParams logoParams =
                new LinearLayout.LayoutParams(90, 90);
        logoParams.gravity = Gravity.CENTER;
        main.addView(logo, logoParams);

        TextView title = new TextView(this);
        title.setText("ENGLISH-1000");
        title.setTextColor(Color.WHITE);
        title.setTextSize(24);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 5, 0, 15);
        main.addView(title);

        ScrollView scroll = new ScrollView(this);
        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            getAssets().open("words.txt"), "UTF-8"));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 4);

                if (parts.length == 4) {
                    LinearLayout card = new LinearLayout(this);
                    card.setOrientation(LinearLayout.VERTICAL);
                    card.setBackgroundColor(Color.rgb(13, 29, 52));
                    card.setPadding(14, 12, 14, 12);

                    LinearLayout.LayoutParams cardParams =
                            new LinearLayout.LayoutParams(
                                    -1, -2);
                    cardParams.setMargins(0, 0, 0, 9);
                    list.addView(card, cardParams);

                    TextView english = new TextView(this);
                    english.setText(parts[0] + ".  " + parts[1]);
                    english.setTextColor(Color.WHITE);
                    english.setTextSize(19);
                    english.setTypeface(null, Typeface.BOLD);
                    card.addView(english);

                    TextView pronunciation = new TextView(this);
                    pronunciation.setText("[" + parts[2] + "]");
                    pronunciation.setTextColor(blue);
                    pronunciation.setTextSize(16);
                    card.addView(pronunciation);

                    TextView translation = new TextView(this);
                    translation.setText(parts[3]);
                    translation.setTextColor(yellow);
                    translation.setTextSize(16);
                    card.addView(translation);
                }
            }

            reader.close();

        } catch (Exception e) {
            TextView error = new TextView(this);
            error.setText("Хатогӣ дар кушодани файли words.txt");
            error.setTextColor(Color.RED);
            list.addView(error);
        }

        scroll.addView(list);
        main.addView(scroll, new LinearLayout.LayoutParams(
                -1, 0, 1));

        setContentView(main);
    }
            }
