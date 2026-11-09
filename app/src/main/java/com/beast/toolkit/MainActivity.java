package com.beast.toolkit;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;

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
        title.setText("⚡ BEAST TOOLKIT");
        title.setTextSize(27);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        addCard("🚀 QUICK BOOST", "Safe maintenance shortcuts");
        addCard("🧠 RAM MONITOR", "Monitor memory usage");
        addCard("💾 STORAGE", "Check available storage");
        addCard("🔋 BATTERY", "View battery status");
        addCard("🎮 GAMING MODE", "Gaming settings shortcuts");
        addCard("🖥️ REFRESH RATE", "Check supported display Hz");

        setContentView(root);
    }

    private void addCard(String heading, String description) {
        Button button = new Button(this);
        button.setText(heading + "\n" + description);
        button.setTextColor(Color.WHITE);
        button.setTextSize(15);
        button.setBackgroundTintList(
            android.content.res.ColorStateList.valueOf(Color.rgb(30, 65, 40))
        );

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 90
            );
        params.setMargins(0, 12, 0, 0);

        root.addView(button, params);
    }
}
