package com.beast.toolkit;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 35, 20, 25);
        root.setBackgroundColor(Color.rgb(5, 10, 8));

        scroll.addView(root);

        TextView title = new TextView(this);
        title.setText("BEAST MODE");
        title.setTextSize(32);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("ULTIMATE CONTROL PANEL");
        subtitle.setTextColor(Color.GRAY);
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle);

        addCard("RAM MONITOR", "
package com.beast.toolkit;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 35, 20, 25);
        root.setBackgroundColor(Color.rgb(5, 10, 8));

        scroll.addView(root);

        TextView title = new TextView(this);
        title.setText("BEAST MODE");
        title.setTextSize(32);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("ULTIMATE CONTROL PANEL");
        subtitle.setTextColor(Color.GRAY);
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle);

        addCard("RAM MONITOR", "package com.beast.toolkit;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 35, 20, 25);
        root.setBackgroundColor(Color.rgb(5, 10, 8));

        scroll.addView(root);

        TextView title = new TextView(this);
        title.setText("BEAST MODE");
        title.setTextSize(32);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("ULTIMATE CONTROL PANEL");
        subtitle.setTextColor(Color.GRAY);
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle);

        addCard("RAM MONITOR", "Check device memory", 0);
        addCard("STORAGE MONITOR", "Check storage usage", 1);
        addCard("BATTERY MONITOR", "Battery information", 2);
        addCard("GAMING MODE", "Gaming settings", 3);
        addCard("REFRESH RATE", "Display information", 4);

        setContentView(scroll);
    }

    void addCard(String name, String detail, int type) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(20, 22, 20, 22);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(15, 25, 19));
        bg.setCornerRadius(25);
        bg.setStroke(2, Color.GREEN);
        card.setBackground(bg);

        TextView heading = new TextView(this);
        heading.setText("⚡ " + name);
        heading.setTextSize(18);
        heading.setTextColor(Color.GREEN);
        heading.setTypeface(null, Typeface.BOLD);

        TextView description = new TextView(this);
        description.setText(detail);
        description.setTextColor(Color.LTGRAY);
        description.setTextSize(13);

        card.addView(heading);
        card.addView(description);

        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 15, 0, 5);
        root.addView(card, p);

        card.setOnClickListener(v -> {
            if (type == 0) showRAM();
            else if (type == 1) showStorage();
            else {
                Toast.makeText(this, "Coming Soon!",
                    Toast.LENGTH_SHORT).show();
            }
        });
    }

    void showRAM() {
        ActivityManager manager =
            (ActivityManager)getSystemService(ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo info =
            new ActivityManager.MemoryInfo();

        manager.getMemoryInfo(info);

        long total = info.totalMem / 1048576;
        long free = info.availMem / 1048576;

        show("RAM MONITOR",
            "Total: " + total + " MB\n" +
            "Used: " + (total - free) + " MB\n" +
            "Free: " + free + " MB");
    }

    void showStorage() {
        StatFs stat = new StatFs(
            Environment.getDataDirectory().getPath());

        long total = stat.getTotalBytes() / 1048576;
        long free = stat.getAvailableBytes() / 1048576;

        show("STORAGE MONITOR",
            "Total: " + total + " MB\n" +
            "Used: " + (total - free) + " MB\n" +
            "Free: " + free + " MB");
    }

    void show(String title, String message) {
        new AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show();
    }
}


