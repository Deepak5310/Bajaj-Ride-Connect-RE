package com.bajajconnect.navigate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bajajconnect.R;
import com.mappls.sdk.plugin.directions.view.ManeuverView;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_maneuver_view);
        ManeuverView maneuverView = (ManeuverView) findViewById(R.id.maneuver_view);
        if (maneuverView != null) {
            maneuverView.setManeuverTypeAndModifier("rotary", "left");
        }
    }
}
