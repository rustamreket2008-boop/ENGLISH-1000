package com.english1000.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final int background = Color.rgb(7, 15, 30);
    private final int blue = Color.rgb(30, 136, 255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setBackgroundColor(background);
        main.setPadding(18, 20, 18, 15);

        TextView title = new TextView(this);
        title.setText("🇬🇧 ENGLISH-1000");
        title.setTextColor(Color.WHITE);
        title.setTextSize(25);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(5, 15, 5, 20);
        main.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("1000 English Words");
        subtitle.setTextColor(blue);
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(5, 0, 5, 20);
        main.addView(subtitle);

        ScrollView scroll = new ScrollView(this);

        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);

        TextView message = new TextView(this);
        message.setText("Луғати 1000 калима дар ин ҷо ҷойгир мешавад.");
        message.setTextColor(Color.WHITE);
        message.setTextSize(17);
        message.setPadding(12, 20, 12, 20);

        list.addView(message);
        scroll.addView(list);
        main.addView(scroll);

        setContentView(main);
    }
    }
