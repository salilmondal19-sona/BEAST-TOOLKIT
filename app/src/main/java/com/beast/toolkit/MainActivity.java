package com.beast.toolkit;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.*;
import android.widget.*;
import android.graphics.drawable.GradientDrawable;
import java.io.File;

public class MainActivity extends Activity {

    LinearLayout root;

    GradientDrawable bg(int color) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(25);
        d.setStroke(1, Color.rgb(30, 220, 90));
        return d;
    }

    TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setTypeface(Typeface.DEFAULT_BOLD);
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 30, 20, 25);
        root.setBackgroundColor(Color.rgb(5, 10, 8));

        scroll.addView(root);

        TextView title = text("BEAST MODE", 30, Color.GREEN);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        TextView sub = text("LOW DEVICE BOOST EDITION", 12, Color.GRAY);
        sub.setGravity(Gravity.CENTER);
        root.addView(sub);

        TextView status = text("● SYSTEM ONLINE", 14, Color.GREEN);
        status.setPadding(0, 35, 0, 20);
        root.addView(status);

        addCard("RAM MONITOR", "Check device memory", 0);
        addCard("STORAGE MONITOR", "Check storage usage", 1);
        addCard("BATTERY MONITOR", "Battery information", 2);
        addCard("GAMING MODE", "Gaming settings", 3);
        addCard("REFRESH RATE", "Display information", 4);

        TextView footer = text("BEAST TOOLKIT  •  VERSION 1.0", 11, Color.GRAY);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, 35, 0, 10);
        root.addView(footer);

        setContentView(scroll);
    }

    private void addCard(String name, String detail, int type) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(20, 18, 20, 18);
        card.setBackground(bg(Color.rgb(15, 25, 19)));

        TextView heading = text("⚡ " + name, 18, Color.GREEN);
        TextView description = text(detail, 13, Color.LTGRAY);

        card.addView(heading);
        card.addView(description);

        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 10, 0, 10);
        root.addView(card, p);

        card.setOnClickListener(v -> {
            if (type == 0) showRAM();
            else if (type == 1) showStorage();
            else if (type == 2) showBattery();
            else if (type == 3) showGaming();
            else showRefresh();
        });
    }

    private void showRAM() {
        ActivityManager m =
            (ActivityManager)get
cd ~/BEAST-TOOLKIT

cat > app/src/main/java/com/beast/toolkit/MainActivity.java <<'EOF'
package com.beast.toolkit;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.*;
import android.widget.*;
import android.graphics.drawable.GradientDrawable;
import java.io.File;

public class MainActivity extends Activity {

    LinearLayout root;

    GradientDrawable bg(int color) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(25);
        d.setStroke(1, Color.rgb(30, 220, 90));
        return d;
    }

    TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setTypeface(Typeface.DEFAULT_BOLD);
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 30, 20, 25);
        root.setBackgroundColor(Color.rgb(5, 10, 8));

        scroll.addView(root);

        TextView title = text("BEAST MODE", 30, Color.GREEN);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        TextView sub = text("LOW DEVICE BOOST EDITION", 12, Color.GRAY);
        sub.setGravity(Gravity.CENTER);
        root.addView(sub);

        TextView status = text("● SYSTEM ONLINE", 14, Color.GREEN);
        status.setPadding(0, 35, 0, 20);
        root.addView(status);

        addCard("RAM MONITOR", "Check device memory", 0);
        addCard("STORAGE MONITOR", "Check storage usage", 1);
        addCard("BATTERY MONITOR", "Battery information", 2);
        addCard("GAMING MODE", "Gaming settings", 3);
        addCard("REFRESH RATE", "Display information", 4);

        TextView footer = text("BEAST TOOLKIT  •  VERSION 1.0", 11, Color.GRAY);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, 35, 0, 10);
        root.addView(footer);

        setContentView(scroll);
    }

    private void addCard(String name, String detail, int type) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(20, 18, 20, 18);
        card.setBackground(bg(Color.rgb(15, 25, 19)));

        TextView heading = text("⚡ " + name, 18, Color.GREEN);
        TextView description = text(detail, 13, Color.LTGRAY);

        card.addView(heading);
        card.addView(description);

        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 10, 0, 10);
        root.addView(card, p);

        card.setOnClickListener(v -> {
            if (type == 0) showRAM();
            else if (type == 1) showStorage();
            else if (type == 2) showBattery();
            else if (type == 3) showGaming();
            else showRefresh();
        });
    }

    private void showRAM() {
        ActivityManager m =
            (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo i =
            new ActivityManager.MemoryInfo();
        m.getMemoryInfo(i);

        long total = i.totalMem / 1048576;
        long free = i.availMem / 1048576;

        show("RAM MONITOR",
            "Total RAM: " + total + " MB\n" +
            "Used RAM: " + (total-free) + " MB\n" +
            "Free RAM: " + free + " MB");
    }

    private void showStorage() {
        StatFs s = new StatFs(
            Environment.getDataDirectory().getPath());

        long total = s.getTotalBytes() / 1048576;
        long free = s.getAvailableBytes() / 1048576;

        show("STORAGE MONITOR",
            "Total: " + total + " MB\n" +
            "Used: " + (total-free) + " MB\n" +
            "Free: " + free + " MB");
    }

    private void showBattery() {
        Intent i = registerReceiver(null,
            new android.content.IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        if (i == null) return;

        int level = i.getIntExtra("level", 0);
        int temp = i.getIntExtra("temperature", 0);

        show("BATTERY MONITOR",
            "Battery: " + level + "%\n" +
            "Temperature: " + (temp / 10.0) + " °C");
    }

    private void showGaming() {
        show("GAMING MODE",
            "Gaming settings panel\n\n" +
            "Use your phone's built-in Game Mode\n" +
            "for supported gaming options.");
    }

    private void showRefresh() {
        android.view.Display d =
            getWindowManager().getDefaultDisplay();

        show("DISPLAY INFO",
            "Current refresh rate: " +
            d.getRefreshRate() + " Hz");
    }

    private void show(String title, String message) {
        new AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show();
    }
}
