package com.beast.toolkit;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.os.StatFs;
import android.os.Environment;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
import java.io.File;

public class MainActivity extends Activity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 30, 20, 20);
        root.setBackgroundColor(Color.rgb(10, 12, 15));

        TextView title = new TextView(this);
        title.setText("BEAST TOOLKIT");
        title.setTextSize(27);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        addCard("RAM MONITOR");
        addCard("STORAGE MONITOR");
        addCard("BATTERY");
        addCard("GAMING MODE");
        addCard("REFRESH RATE");

        setContentView(root);
    }

    private void addCard(String name) {
        Button button = new Button(this);
        button.setText(name);
        button.setTextColor(Color.WHITE);
        button.setBackgroundTintList(
            android.content.res.ColorStateList.valueOf(
                Color.rgb(30, 65, 40)
            )
        );

        button.setOnClickListener(v -> {
            if (name.equals("RAM MONITOR")) {
                showRAM();
            } else if (name.equals("STORAGE MONITOR")) {
                showStorage();
            } else {
                Toast.makeText(this,
                    "Coming Soon!",
                    Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(-1, 85);

        params.setMargins(0, 12, 0, 0);
        root.addView(button, params);
    }

    private void showRAM() {
        ActivityManager manager =
            (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo info =
            new ActivityManager.MemoryInfo();

        manager.getMemoryInfo(info);

        long total = info.totalMem / (1024 * 1024);
        long free = info.availMem / (1024 * 1024);
        long used = total - free;

        new android.app.AlertDialog.Builder(this)
            .setTitle("RAM MONITOR")
            .setMessage(
                "Total RAM: " + total + " MB\n" +
                "Used RAM: " + used + " MB\n" +
                "Free RAM: " + free + " MB"
            )
            .setPositiveButton("OK", null)
            .show();
    }

    private void showStorage() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());

        long total = stat.getTotalBytes() / (1024 * 1024);
        long free = stat.getAvailableBytes() / (1024 * 1024);
        long used = total - free;

        new android.app.AlertDialog.Builder(this)
            .setTitle("STORAGE MONITOR")
            .setMessage(
                "Total: " + total + " MB\n" +
                "Used: " + used + " MB\n" +
                "Free: " + free + " MB"
            )
            .setPositiveButton("OK", null)
            .show();
    }
}
