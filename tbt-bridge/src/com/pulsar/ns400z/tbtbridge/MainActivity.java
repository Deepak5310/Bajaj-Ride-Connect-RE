package com.pulsar.ns400z.tbtbridge;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Enterprise Dashboard Activity for Pulsar Connect (NS400Z).
 * Provides live LCD cluster simulation, real-time Google Maps feed monitoring,
 * and diagnostic simulation tools.
 */
public class MainActivity extends Activity implements PulsarBleManager.BleListener {

    private TextView tvStatusPill;
    private TextView tvDeviceInfo;
    private TextView tvGattDetail;
    private TextView tvNotifStatus;

    // LCD Simulator Views
    private TextView tvLcdManeuverGlyph;
    private TextView tvLcdStepDist;
    private TextView tvLcdManeuverDesc;
    private TextView tvLcdEta;
    private TextView tvLcdTotalDist;
    private TextView tvLcdStreet;
    private TextView tvLcdBattery;
    private TextView tvLcdSignal;
    private TextView tvLcdMediaTrack;
    private TextView tvRawHex;

    // Buttons
    private Button btnConnectBle;
    private Button btnDisconnectBle;
    private Button btnGrantNotif;
    private Button btnTestLeft;
    private Button btnTestRight;
    private Button btnTestRoundabout;
    private Button btnTestDestination;
    private Button btnTestCall;
    private Button btnTestMusic;
    private Button btnTestClear;
    private View cardPermissions;

    private PulsarBleManager bleManager;

    private final BroadcastReceiver tbtReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (GoogleMapsNotificationListener.ACTION_TBT_UPDATE.equals(intent.getAction())) {
                String maneuver = intent.getStringExtra("maneuver");
                String desc = intent.getStringExtra("maneuver_desc");
                double stepDist = intent.getDoubleExtra("step_dist", 0.0);
                double totalDist = intent.getDoubleExtra("total_dist", 0.0);
                int etaHour = intent.getIntExtra("eta_hour", 12);
                int etaMin = intent.getIntExtra("eta_min", 0);
                boolean isPm = intent.getBooleanExtra("is_pm", false);
                String street = intent.getStringExtra("street");
                String hex = intent.getStringExtra("hex");

                updateLcdNavigation(maneuver, desc, stepDist, totalDist, etaHour, etaMin, isPm, street, hex);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupEdgeToEdge();
        setContentView(R.layout.activity_main);

        bindViews();
        setupListeners();

        bleManager = PulsarBleManager.getInstance(this);
        bleManager.addListener(this);

        // Start Persistent Background Service
        PulsarForegroundService.start(this);

        requestAppPermissions();
    }

    private void setupEdgeToEdge() {
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
    }

    private void bindViews() {
        tvStatusPill = findViewById(R.id.tvStatusPill);
        tvDeviceInfo = findViewById(R.id.tvDeviceInfo);
        tvGattDetail = findViewById(R.id.tvGattDetail);
        tvNotifStatus = findViewById(R.id.tvNotifStatus);
        cardPermissions = findViewById(R.id.cardPermissions);

        tvLcdManeuverGlyph = findViewById(R.id.tvLcdManeuverGlyph);
        tvLcdStepDist = findViewById(R.id.tvLcdStepDist);
        tvLcdManeuverDesc = findViewById(R.id.tvLcdManeuverDesc);
        tvLcdEta = findViewById(R.id.tvLcdEta);
        tvLcdTotalDist = findViewById(R.id.tvLcdTotalDist);
        tvLcdStreet = findViewById(R.id.tvLcdStreet);
        tvLcdBattery = findViewById(R.id.tvLcdBattery);
        tvLcdSignal = findViewById(R.id.tvLcdSignal);
        tvLcdMediaTrack = findViewById(R.id.tvLcdMediaTrack);
        tvRawHex = findViewById(R.id.tvRawHex);

        btnConnectBle = findViewById(R.id.btnConnectBle);
        btnDisconnectBle = findViewById(R.id.btnDisconnectBle);
        btnGrantNotif = findViewById(R.id.btnGrantNotif);
        btnTestLeft = findViewById(R.id.btnTestLeft);
        btnTestRight = findViewById(R.id.btnTestRight);
        btnTestRoundabout = findViewById(R.id.btnTestRoundabout);
        btnTestDestination = findViewById(R.id.btnTestDestination);
        btnTestCall = findViewById(R.id.btnTestCall);
        btnTestMusic = findViewById(R.id.btnTestMusic);
        btnTestClear = findViewById(R.id.btnTestClear);
    }

    private void setupListeners() {
        btnConnectBle.setOnClickListener(v -> {
            requestAppPermissions();
            bleManager.setAutoReconnect(true);
            bleManager.startScanOrConnect();
            tvStatusPill.setText("CONNECTING");
            tvStatusPill.setTextColor(0xFF38BDF8);
            tvStatusPill.setBackgroundResource(R.drawable.bg_pill_connected);
        });

        btnDisconnectBle.setOnClickListener(v -> {
            bleManager.disconnect();
            Toast.makeText(this, "Disconnected from cluster.", Toast.LENGTH_SHORT).show();
        });

        btnGrantNotif.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
            startActivity(intent);
        });

        // 1. Simulation: Left Turn
        btnTestLeft.setOnClickListener(v -> {
            byte[] frame = PulsarProtocol.buildTbtFrame(
                    PulsarProtocol.Maneuver.TURN_LEFT, 250.0, 8500.0, 7, 45, true, "MG ROAD", true, 0
            );
            bleManager.sendTbtFrame(frame);
            updateLcdNavigation("TURN_LEFT", "Turn Left", 250.0, 8500.0, 7, 45, true, "MG ROAD", bytesToHex(frame));
            Toast.makeText(this, "Dispatched Left Turn (250m)", Toast.LENGTH_SHORT).show();
        });

        // 2. Simulation: Right Turn
        btnTestRight.setOnClickListener(v -> {
            byte[] frame = PulsarProtocol.buildTbtFrame(
                    PulsarProtocol.Maneuver.TURN_RIGHT, 500.0, 12000.0, 8, 15, true, "NH 48 HIGHWAY", true, 0
            );
            bleManager.sendTbtFrame(frame);
            updateLcdNavigation("TURN_RIGHT", "Turn Right", 500.0, 12000.0, 8, 15, true, "NH 48 HIGHWAY", bytesToHex(frame));
            Toast.makeText(this, "Dispatched Right Turn (500m)", Toast.LENGTH_SHORT).show();
        });

        // 3. Simulation: Roundabout
        btnTestRoundabout.setOnClickListener(v -> {
            byte[] frame = PulsarProtocol.buildTbtFrame(
                    PulsarProtocol.Maneuver.ROUNDABOUT_CW, 150.0, 5200.0, 8, 30, true, "RING ROAD CIR.", true, 2
            );
            bleManager.sendTbtFrame(frame);
            updateLcdNavigation("ROUNDABOUT_CW", "Roundabout (Exit 2)", 150.0, 5200.0, 8, 30, true, "RING ROAD CIR.", bytesToHex(frame));
            Toast.makeText(this, "Dispatched Roundabout (Exit 2)", Toast.LENGTH_SHORT).show();
        });

        // 4. Simulation: Destination Reached
        btnTestDestination.setOnClickListener(v -> {
            byte[] frame = PulsarProtocol.buildTbtFrame(
                    PulsarProtocol.Maneuver.DESTINATION, 0.0, 0.0, 8, 45, true, "DESTINATION REACHED", true, 0
            );
            bleManager.sendTbtFrame(frame);
            updateLcdNavigation("DESTINATION", "Destination Reached", 0.0, 0.0, 8, 45, true, "DESTINATION REACHED", bytesToHex(frame));
            Toast.makeText(this, "Dispatched Destination Reached", Toast.LENGTH_SHORT).show();
        });

        // 5. Simulation: Caller ID
        btnTestCall.setOnClickListener(v -> {
            bleManager.sendTelemetry(90, 4, 1, "MOM (CALLING)", 0, 0);
            tvLcdStreet.setText("CALL: MOM");
            tvLcdManeuverDesc.setText("Incoming Call...");
            tvRawHex.setText("Raw Telemetry (0210): [CALL: MOM]");
            Toast.makeText(this, "Dispatched Caller ID Simulation", Toast.LENGTH_SHORT).show();
        });

        // 6. Simulation: Spotify Track
        btnTestMusic.setOnClickListener(v -> {
            bleManager.sendMedia("Blinding Lights", "The Weeknd", "After Hours", 45, 200, 2);
            tvLcdMediaTrack.setText("♫ Blinding Lights - The Weeknd");
            tvRawHex.setText("Raw Media (0610): [The Weeknd - Blinding Lights]");
            Toast.makeText(this, "Dispatched Spotify Media Simulation", Toast.LENGTH_SHORT).show();
        });

        // 7. Simulation: Clear Display
        btnTestClear.setOnClickListener(v -> {
            byte[] frame = PulsarProtocol.buildTbtClearFrame();
            bleManager.sendTbtFrame(frame);
            updateLcdNavigation("STRAIGHT", "Idle / Stopped", 0.0, 0.0, 12, 0, false, "--", bytesToHex(frame));
            Toast.makeText(this, "Cleared Cluster Navigation Screen", Toast.LENGTH_SHORT).show();
        });
    }

    private void updateLcdNavigation(
            String maneuverName,
            String desc,
            double stepDist,
            double totalDist,
            int etaHour,
            int etaMin,
            boolean isPm,
            String street,
            String hex
    ) {
        String glyph = getGlyphIcon(maneuverName);
        tvLcdManeuverGlyph.setText(glyph);

        String stepStr = stepDist >= 1000 ? String.format("%.1f km", stepDist / 1000.0) : String.format("%.0f m", stepDist);
        String totStr = totalDist >= 1000 ? String.format("%.1f km", totalDist / 1000.0) : String.format("%.0f m", totalDist);
        String etaStr = String.format("%02d:%02d %s", etaHour, etaMin, isPm ? "PM" : "AM");

        tvLcdStepDist.setText(stepDist > 0 ? stepStr : "--");
        tvLcdManeuverDesc.setText(desc != null ? desc : maneuverName);
        tvLcdEta.setText(etaStr);
        tvLcdTotalDist.setText(totalDist > 0 ? totStr + " tot" : "--");
        tvLcdStreet.setText(street != null && !street.isEmpty() ? street.toUpperCase() : "--");
        tvRawHex.setText("Frame (0110):\n" + hex);
    }

    private String getGlyphIcon(String maneuverName) {
        if (maneuverName == null) return "↑";
        switch (maneuverName) {
            case "TURN_LEFT":
            case "SHARP_LEFT": return "↰";
            case "TURN_RIGHT":
            case "SHARP_RIGHT": return "↱";
            case "SLIGHT_LEFT":
            case "KEEP_LEFT": return "↖";
            case "SLIGHT_RIGHT":
            case "KEEP_RIGHT": return "↗";
            case "U_TURN_LEFT":
            case "U_TURN_RIGHT": return "↺";
            case "ROUNDABOUT_CW":
            case "ROUNDABOUT_CCW": return "⮡";
            case "DESTINATION": return "🏁";
            default: return "↑";
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkNotificationPermission();

        IntentFilter filter = new IntentFilter(GoogleMapsNotificationListener.ACTION_TBT_UPDATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(tbtReceiver, filter, Context.RECEIVER_NOT_EXPORTED);
        } else {
            registerReceiver(tbtReceiver, filter);
        }

        if (!bleManager.isConnected()) {
            bleManager.startScanOrConnect();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(tbtReceiver);
        } catch (Exception ignored) {}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bleManager != null) {
            bleManager.removeListener(this);
        }
    }

    private void checkNotificationPermission() {
        String pkg = getPackageName();
        String flat = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
        boolean enabled = flat != null && flat.contains(pkg);
        if (enabled) {
            tvNotifStatus.setText("Notification Hook: ACTIVE (Listening to G-Maps & Media)");
            tvNotifStatus.setTextColor(0xFF10B981);
            btnGrantNotif.setVisibility(View.GONE);
            cardPermissions.setVisibility(View.GONE);
        } else {
            tvNotifStatus.setText("Notification Hook: DISABLED (Required for G-Maps navigation)");
            tvNotifStatus.setTextColor(0xFFEF4444);
            btnGrantNotif.setVisibility(View.VISIBLE);
            cardPermissions.setVisibility(View.VISIBLE);
        }
    }

    private void requestAppPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            String[] perms = new String[]{
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.POST_NOTIFICATIONS
            };
            boolean need = false;
            for (String p : perms) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    need = true;
                    break;
                }
            }
            if (need) {
                requestPermissions(perms, 102);
            }
        }
    }

    @Override
    public void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress) {
        runOnUiThread(() -> {
            if (connected) {
                tvStatusPill.setText("CONNECTED");
                tvStatusPill.setTextColor(0xFF10B981);
                tvStatusPill.setBackgroundResource(R.drawable.bg_pill_connected);
                tvDeviceInfo.setText("Target: " + deviceName + " [" + deviceAddress + "]");
                tvGattDetail.setText("MTU: 247 • Transport: LE • Link: Active");
            } else {
                tvStatusPill.setText("DISCONNECTED");
                tvStatusPill.setTextColor(0xFFEF4444);
                tvStatusPill.setBackgroundResource(R.drawable.bg_pill_disconnected);
                tvDeviceInfo.setText("Target: " + (deviceName.isEmpty() ? "PULSAR6741 (Auto-reconnecting)" : deviceName));
                tvGattDetail.setText("MTU: -- • Transport: LE • Auto-Reconnect: Active");
            }
        });
    }

    @Override
    public void onPacketSent(String charUuid, byte[] frame, boolean success) {
        runOnUiThread(() -> {
            if (PulsarProtocol.CHAR_TBT_UUID.equalsIgnoreCase(charUuid)) {
                tvRawHex.setText("Sent TBT (0110, " + frame.length + "B, " + (success ? "OK" : "QUEUED") + "):\n" + bytesToHex(frame));
            }
        });
    }

    @Override
    public void onHandlebarEvent(PulsarProtocol.HandlebarEvent event) {
        runOnUiThread(() -> {
            if (event.musicNext) Toast.makeText(this, "Handlebar: Music Next", Toast.LENGTH_SHORT).show();
            else if (event.musicPrev) Toast.makeText(this, "Handlebar: Music Prev", Toast.LENGTH_SHORT).show();
            else if (event.musicPlay || event.musicPause) Toast.makeText(this, "Handlebar: Play/Pause", Toast.LENGTH_SHORT).show();
            else if (event.callAccept) Toast.makeText(this, "Handlebar: Answer Call", Toast.LENGTH_SHORT).show();
            else if (event.callReject) Toast.makeText(this, "Handlebar: End Call", Toast.LENGTH_SHORT).show();
        });
    }

    private static String bytesToHex(byte[] bytes) {
        if (bytes == null) return "";
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
