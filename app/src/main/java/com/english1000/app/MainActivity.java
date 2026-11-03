
package com.english1000.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    private final int background = Color.rgb(7, 15, 30);
    private final int blue = Color.rgb(30, 136, 255);
    private LinearLayout list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setBackgroundColor(background);
        main.setPadding(16, 15, 16, 10);

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
        title.setTextSize(25);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(5, 10, 5, 5);
        main.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("1000 English Words");
        subtitle.setTextColor(blue);
        subtitle.setTextSize(15);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(5, 0, 5, 15);
        main.addView(subtitle);

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(false);

        list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);

        scroll.addView(list);
        main.addView(scroll, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));

        setContentView(main);

        loadWords();
    }

    private void loadWords() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            getAssets().open("words.txt"), "UTF-8"));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 4);

                if (parts.length == 4) {
                    addWord(parts[0], parts[1], parts[2], parts[3]);
                }
            }

            reader.close();

        } catch (Exception e) {
            TextView error = new TextView(this);
            error.setText("Хатогӣ ҳангоми кушодани луғат: "
                    + e.getMessage());
            error.setTextColor(Color.RED);
            error.setTextSize(16);
            list.addView(error);
        }
    }

    private void addWord(String number, String english,
                         String pronunciation, String translation) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(15, 12, 15, 12);

        GradientDrawable shape = new GradientDrawable();
        shape.setColor(Color.rgb(15, 29, 52));
        shape.setCornerRadius(16);
        shape.setStroke(1, Color.rgb(30, 75, 125));
        card.setBackground(shape);

        TextView word = new TextView(this);
        word.setText(number + ". " + english);
        word.setTextColor(Color.WHITE);
        word.setTextSize(19);
        word.setTypeface(null, Typeface.BOLD);
        card.addView(word);

        TextView sound = new TextView(this);
        sound.setText("🔊 " + pronunciation);
        sound.setTextColor(blue);
        sound.setTextSize(15);
        sound.setPadding(0, 5, 0, 5);
        card.addView(sound);

        TextView meaning = new TextView(this);
        meaning.setText(translation);
        meaning.setTextColor(Color.rgb(210, 220, 235));
        meaning.setTextSize(15);
        card.addView(meaning);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(0, 0, 0, 10);
        list.addView(card, params);
    }
            }
