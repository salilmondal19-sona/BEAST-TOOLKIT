package com.beast.toolkit;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.StatFs;
import android.os.Environment;
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
        root.setOrientation(1);
        root.setPadding(20, 30, 20, 20);
        root.setBackgroundColor(Color.rgb(5, 10, 8));

        scroll.addView(root);

        TextView title = new TextView(this);
        title.setText("BEAST MODE");
        title.setTextSize(32);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        root.addView(title);

        TextView sub = new TextView(this);
        sub.setText("ULTIMATE CONTROL PANEL");
        sub.setTextColor(Color.GRAY);
        sub.setGravity(Gravity.CENTER);
        root.addView(sub);

        addCard("RAM MONITOR", 0);
        addCard("STORAGE MONITOR", 1);
        addCard("BATTERY MONITOR", 2);
        addCard("GAMING MODE", 3
package com.beast.toolkit;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.StatFs;
import android.os.Environment;
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
        root.setOrientation(1);
        root.setPadding(20, 30, 20, 20);
        root.setBackgroundColor(Color.rgb(5, 10, 8));

        scroll.addView(root);

        TextView title = new TextView(this);
        title.setText("BEAST MODE");
        title.setTextSize(32);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        root.addView(title);

        TextView sub = new TextView(this);
        sub.setText("ULTIMATE CONTROL PANEL");
        sub.setTextColor(Color.GRAY);
        sub.setGravity(Gravity.CENTER);
        root.addView(sub);

        addCard("RAM MONITOR", 0);
        addCard("STORAGE MONITOR", 1);
        addCard("BATTERY MONITOR", 2);
        addCard("GAMING MODE", 3);
        addCard("REFRESH RATE", 4);

        setContentView(scroll);
    }

    void addCard(String name, int type) {
        TextView card = new TextView(this);
        card.setText("⚡  " + name + "\nTap to open");
        card.setTextSize(18);
        card.setTextColor(Color.GREEN);
        card.setPadding(25, 30, 20, 30);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(15, 25, 19));
        bg.setCornerRadius(25);
        bg.setStroke(2, Color.GREEN);
        card.setBackground(bg);

        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 15, 0, 5);
        root.addView(card, p);

        card.setOnClickListener(v -> {
            if (type == 0) showRAM();
            else if (type == 1) showStorage();
            else if (type == 2) showBattery();
            else if (type == 3) show("GAMING MODE",
                "Use your phone's built-in Game Mode.");
            else showRefresh();
        });
    }

    void show(String title, String message) {
        new AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show();
    }

    void showRAM() {
        ActivityManager m =
            (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo i =
            new ActivityManager.MemoryInfo();
        m.getMemoryInfo(i);

        long total = i.totalMem / 1048576;
        long free = i.availMem / 1048576;

        show("RAM MONITOR",
            "Total: " + total + " MB\n" +
            "Used: " + (total-free) + " MB\n" +
            "Free: " + free + " MB");
    }

    void showStorage() {
        StatFs s = new StatFs(
            Environment.getDataDirectory().getPath());

        long total = s.getTotalBytes() / 1048576;
        long free = s.getAvailableBytes() / 1048576;

        show("STORAGE MONITOR",
            "Total: " + total + " MB\n" +
            "Used: " + (total-free) + " MB\n" +
            "Free: " + free + " MB");
    }

    void showBattery() {
        android.content.Intent i = registerReceiver(
            null,
            new android.content.IntentFilter(
                android.content.Intent.ACTION_BATTERY_CHANGED));

        if (i == null) return;

        int level = i.getIntExtra("level", 0);
        int temp = i.getIntExtra("temperature", 0);

        show("BATTERY MONITOR",
            "Battery: " + level + "%\n" +
            "Temperature: " + (temp / 10.0) + " C");
    }

    void showRefresh() {
        float rate = getWindowManager()
            .getDefaultDisplay().getRefreshRate();

        show("DISPLAY INFO",
            "Refresh Rate: " + rate + " Hz");
    }
}
