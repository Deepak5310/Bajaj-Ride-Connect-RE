package com.pulsar.ns400z.tbtbridge;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Main Dashboard Activity for Bajaj Pulsar NS400Z TBT Bridge.
 */
public class MainActivity extends Activity implements TbtBleDispatcher.BleStateCallback {

    private TextView tvBleStatus;
    private TextView tvDeviceInfo;
    private TextView tvNotifStatus;
    private TextView tvNavManeuver;
    private TextView tvNavDetails;
    private TextView tvNavStreet;
    private TextView tvRawHex;
    private Button btnConnectBle;
    private Button btnGrantNotif;
    private Button btnTestLeft;
    private Button btnTestRight;
    private Button btnTestClear;

    private TbtBleDispatcher bleDispatcher;

    private final BroadcastReceiver tbtReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (GoogleMapsNotificationListener.ACTION_TBT_UPDATE.equals(intent.getAction())) {
                String maneuver = intent.getStringExtra("maneuver");
                double stepDist = intent.getDoubleExtra("step_dist", 0.0);
                double totalDist = intent.getDoubleExtra("total_dist", 0.0);
                int etaHour = intent.getIntExtra("eta_hour", 12);
                int etaMin = intent.getIntExtra("eta_min", 0);
                boolean isPm = intent.getBooleanExtra("is_pm", false);
                String street = intent.getStringExtra("street");
                String hex = intent.getStringExtra("hex");

                tvNavManeuver.setText("Maneuver: " + maneuver);
                String stepStr = stepDist >= 1000 ? String.format("%.1f km", stepDist / 1000.0) : String.format("%.0f m", stepDist);
                String totStr = totalDist >= 1000 ? String.format("%.1f km", totalDist / 1000.0) : String.format("%.0f m", totalDist);
                String etaStr = String.format("%02d:%02d %s", etaHour, etaMin, isPm ? "PM" : "AM");

                tvNavDetails.setText(String.format("Step: %s | Total: %s | ETA: %s", stepStr, totStr, etaStr));
                tvNavStreet.setText("Street: " + (street != null && !street.isEmpty() ? street : "--"));
                tvRawHex.setText("Raw BLE Frame:\n" + hex);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBleStatus = findViewById(R.id.tvBleStatus);
        tvDeviceInfo = findViewById(R.id.tvDeviceInfo);
        tvNotifStatus = findViewById(R.id.tvNotifStatus);
        tvNavManeuver = findViewById(R.id.tvNavManeuver);
        tvNavDetails = findViewById(R.id.tvNavDetails);
        tvNavStreet = findViewById(R.id.tvNavStreet);
        tvRawHex = findViewById(R.id.tvRawHex);

        btnConnectBle = findViewById(R.id.btnConnectBle);
        btnGrantNotif = findViewById(R.id.btnGrantNotif);
        btnTestLeft = findViewById(R.id.btnTestLeft);
        btnTestRight = findViewById(R.id.btnTestRight);
        btnTestClear = findViewById(R.id.btnTestClear);

        bleDispatcher = TbtBleDispatcher.getInstance(this);
        bleDispatcher.setCallback(this);

        btnConnectBle.setOnClickListener(v -> {
            requestBlePermissions();
            bleDispatcher.startScanOrConnect();
            tvBleStatus.setText("Status: Scanning & Connecting...");
            tvBleStatus.setTextColor(0xFF38BDF8); // Blue
        });

        btnGrantNotif.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
            startActivity(intent);
        });

        // Test buttons
        btnTestLeft.setOnClickListener(v -> {
            byte[] frame = TbtFrameBuilder.buildFrame(
                    TbtFrameBuilder.Maneuver.TURN_LEFT,
                    250.0,
                    8500.0,
                    7,
                    45,
                    true,
                    "MG ROAD",
                    true,
                    0
            );
            boolean sent = bleDispatcher.sendTbtFrame(frame);
            tvNavManeuver.setText("Maneuver: TURN_LEFT (TEST)");
            tvNavDetails.setText("Step: 250 m | Total: 8.5 km | ETA: 07:45 PM");
            tvNavStreet.setText("Street: MG ROAD");
            tvRawHex.setText("Raw BLE Frame (" + (sent ? "SENT" : "QUEUED") + "):\n" + bytesToHex(frame));
            Toast.makeText(this, sent ? "Dispatched Left Turn to Cluster!" : "Sent (Cluster not yet connected)", Toast.LENGTH_SHORT).show();
        });

        btnTestRight.setOnClickListener(v -> {
            byte[] frame = TbtFrameBuilder.buildFrame(
                    TbtFrameBuilder.Maneuver.TURN_RIGHT,
                    500.0,
                    12000.0,
                    8,
                    15,
                    true,
                    "NH 48 HIGHWAY",
                    true,
                    0
            );
            boolean sent = bleDispatcher.sendTbtFrame(frame);
            tvNavManeuver.setText("Maneuver: TURN_RIGHT (TEST)");
            tvNavDetails.setText("Step: 500 m | Total: 12.0 km | ETA: 08:15 PM");
            tvNavStreet.setText("Street: NH 48 HIGHWAY");
            tvRawHex.setText("Raw BLE Frame (" + (sent ? "SENT" : "QUEUED") + "):\n" + bytesToHex(frame));
            Toast.makeText(this, sent ? "Dispatched Right Turn to Cluster!" : "Sent (Cluster not yet connected)", Toast.LENGTH_SHORT).show();
        });

        btnTestClear.setOnClickListener(v -> {
            byte[] frame = new byte[48];
            boolean sent = bleDispatcher.sendTbtFrame(frame);
            tvNavManeuver.setText("Maneuver: IDLE / STOPPED");
            tvNavDetails.setText("Step: -- | Total: -- | ETA: --");
            tvNavStreet.setText("Street: --");
            tvRawHex.setText("Raw BLE Frame:\n" + bytesToHex(frame));
            Toast.makeText(this, "Cleared Cluster Navigation Display.", Toast.LENGTH_SHORT).show();
        });

        requestBlePermissions();
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

        if (!bleDispatcher.isConnected()) {
            bleDispatcher.startScanOrConnect();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(tbtReceiver);
    }

    private void checkNotificationPermission() {
        String pkg = getPackageName();
        String flat = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
        boolean enabled = flat != null && flat.contains(pkg);
        if (enabled) {
            tvNotifStatus.setText("Notification Hook: ACTIVE (Listening to G-Maps)");
            tvNotifStatus.setTextColor(0xFF22C55E); // Green
            btnGrantNotif.setVisibility(View.GONE);
        } else {
            tvNotifStatus.setText("Notification Hook: DISABLED (Permission needed)");
            tvNotifStatus.setTextColor(0xFFEF4444); // Red
            btnGrantNotif.setVisibility(View.VISIBLE);
        }
    }

    private void requestBlePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.BLUETOOTH_SCAN,
                        Manifest.permission.BLUETOOTH_CONNECT,
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, 101);
            }
        }
    }

    @Override
    public void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress) {
        runOnUiThread(() -> {
            if (connected) {
                tvBleStatus.setText("Status: Connected to NS400Z Cluster");
                tvBleStatus.setTextColor(0xFF22C55E); // Green
                tvDeviceInfo.setText("Target: " + deviceName + " [" + deviceAddress + "]");
            } else {
                tvBleStatus.setText("Status: Disconnected");
                tvBleStatus.setTextColor(0xFFEF4444); // Red
                tvDeviceInfo.setText("Target: " + (deviceName.isEmpty() ? "Auto-detecting OTC / NS400Z" : deviceName));
            }
        });
    }

    @Override
    public void onPacketSent(byte[] frame, boolean success) {
        // Updated via broadcast / callbacks
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
