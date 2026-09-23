package com.pulsar.ns400z.tbtbridge;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.service.notification.NotificationListenerService;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Modern Digital Cockpit Activity for Pulsar Connect (NS400Z).
 * Minimalist, hardware-accelerated automotive dashboard interface
 * with real-time LCD simulation, pipeline status monitors, and diagnostic controls.
 */
public class MainActivity extends Activity implements PulsarBleManager.BleListener {

    private static final int PERMISSION_REQ_CODE = 101;

    // Header & Connection
    private View layoutStatusBadge;
    private View viewStatusDot;
    private TextView tvStatusBadge;
    private TextView tvDeviceTarget;
    private TextView tvQuickLinkAction;
    private ObjectAnimator pulseAnimator;

    // Hero Cockpit LCD Views
    private TextView tvLcdBattery;
    private TextView tvLcdSignal;
    private TextView tvLcdClock;
    private TextView tvLcdManeuverGlyph;
    private TextView tvLcdStepDist;
    private TextView tvLcdManeuverDesc;
    private TextView tvLcdTotalDist;
    private TextView tvLcdEta;
    private TextView tvLcdStreet;
    private TextView tvLcdMediaIcon;
    private TextView tvLcdMediaTrack;
    private TextView tvLcdMediaState;

    // Pipeline Health Chips
    private View chipBle;
    private TextView tvChipBleIcon;
    private TextView tvChipBleLabel;
    private View chipMaps;
    private TextView tvChipMapsIcon;
    private TextView tvChipMapsLabel;
    private View chipMedia;
    private TextView tvChipMediaIcon;
    private TextView tvChipMediaLabel;
    private View chipPhone;
    private TextView tvChipPhoneIcon;
    private TextView tvChipPhoneLabel;
    private View cardPermissionAlert;
    private Button btnGrantPermissions;

    // Simulation Controls
    private Button btnTestLeft;
    private Button btnTestRight;
    private Button btnTestRoundabout;
    private Button btnTestDestination;
    private Button btnTestCall;
    private Button btnTestMusic;
    private Button btnTestClear;
    private Button btnExitApp;

    // Packet Inspector
    private View layoutToggleTerminal;
    private View layoutTerminalBody;
    private TextView tvTerminalToggle;
    private TextView tvRawHex;
    private boolean isTerminalExpanded = true;

    private PulsarBleManager bleManager;
    private final Handler clockHandler = new Handler(Looper.getMainLooper());
    private final SimpleDateFormat clockFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

    private int currentBattery = -1;
    private boolean isCharging = false;
    private int currentSignalBars = -1;

    private final Runnable clockRunnable = new Runnable() {
        @Override
        public void run() {
            if (tvLcdClock != null) {
                tvLcdClock.setText(clockFormat.format(new Date()));
            }
            clockHandler.postDelayed(this, 10000);
        }
    };

    private final BroadcastReceiver systemUpdatesReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null) return;
            String action = intent.getAction();

            if (GoogleMapsNotificationListener.ACTION_TBT_UPDATE.equals(action)) {
                String maneuver = intent.getStringExtra("maneuver");
                String desc = intent.getStringExtra("maneuver_desc");
                double stepDist = intent.getDoubleExtra("step_dist", 0.0);
                double totalDist = intent.getDoubleExtra("total_dist", 0.0);
                int etaHour = intent.getIntExtra("eta_hour", 12);
                int etaMin = intent.getIntExtra("eta_min", 0);
                boolean isPm = intent.getBooleanExtra("is_pm", false);
                String street = intent.getStringExtra("street");
                String hex = intent.getStringExtra("hex");

                updateCockpitNavigation(maneuver, desc, stepDist, totalDist, etaHour, etaMin, isPm, street, hex);
            } else if (MediaStateListener.ACTION_MEDIA_UPDATE.equals(action)) {
                String title = intent.getStringExtra("title");
                String artist = intent.getStringExtra("artist");
                int state = intent.getIntExtra("playback_state", 0);
                updateCockpitMedia(title, artist, state);
            } else if (PhoneStateMonitor.ACTION_TELEMETRY_UPDATE.equals(action)) {
                int bat = intent.getIntExtra("battery", -1);
                int sig = intent.getIntExtra("signal", -1);
                if (bat >= 0) {
                    currentBattery = bat;
                    updateBatteryDisplay(currentBattery, isCharging);
                }
                if (sig >= 0) {
                    currentSignalBars = sig;
                    updateSignalDisplay(currentSignalBars);
                }
            } else if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING
                        || status == BatteryManager.BATTERY_STATUS_FULL);
                if (level >= 0 && scale > 0) {
                    currentBattery = (int) ((level / (float) scale) * 100);
                    updateBatteryDisplay(currentBattery, isCharging);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupEdgeToEdge();
        setContentView(R.layout.activity_main);

        initViews();
        setupWindowInsets();
        setupListeners();
        setupMicroAnimations();
        initLiveSystemSensors();

        bleManager = PulsarBleManager.getInstance(this);
        bleManager.addListener(this);

        PulsarForegroundService.start(this);

        requestAppPermissions();
    }

    private void setupEdgeToEdge() {
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        );
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
    }

    private void setupWindowInsets() {
        View root = findViewById(R.id.rootScrollView);
        if (root != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            root.setOnApplyWindowInsetsListener((v, insets) -> {
                int top = insets.getSystemWindowInsetTop();
                int bottom = insets.getSystemWindowInsetBottom();
                v.setPadding(v.getPaddingLeft(), top, v.getPaddingRight(), bottom);
                return insets.consumeSystemWindowInsets();
            });
        }
    }

    private void initViews() {
        layoutStatusBadge = findViewById(R.id.layoutStatusBadge);
        viewStatusDot = findViewById(R.id.viewStatusDot);
        tvStatusBadge = findViewById(R.id.tvStatusBadge);
        tvDeviceTarget = findViewById(R.id.tvDeviceTarget);
        tvQuickLinkAction = findViewById(R.id.tvQuickLinkAction);

        tvLcdBattery = findViewById(R.id.tvLcdBattery);
        tvLcdSignal = findViewById(R.id.tvLcdSignal);
        tvLcdClock = findViewById(R.id.tvLcdClock);
        tvLcdManeuverGlyph = findViewById(R.id.tvLcdManeuverGlyph);
        tvLcdStepDist = findViewById(R.id.tvLcdStepDist);
        tvLcdManeuverDesc = findViewById(R.id.tvLcdManeuverDesc);
        tvLcdTotalDist = findViewById(R.id.tvLcdTotalDist);
        tvLcdEta = findViewById(R.id.tvLcdEta);
        tvLcdStreet = findViewById(R.id.tvLcdStreet);
        tvLcdMediaIcon = findViewById(R.id.tvLcdMediaIcon);
        tvLcdMediaTrack = findViewById(R.id.tvLcdMediaTrack);
        tvLcdMediaState = findViewById(R.id.tvLcdMediaState);

        chipBle = findViewById(R.id.chipBle);
        tvChipBleIcon = findViewById(R.id.tvChipBleIcon);
        tvChipBleLabel = findViewById(R.id.tvChipBleLabel);
        chipMaps = findViewById(R.id.chipMaps);
        tvChipMapsIcon = findViewById(R.id.tvChipMapsIcon);
        tvChipMapsLabel = findViewById(R.id.tvChipMapsLabel);
        chipMedia = findViewById(R.id.chipMedia);
        tvChipMediaIcon = findViewById(R.id.tvChipMediaIcon);
        tvChipMediaLabel = findViewById(R.id.tvChipMediaLabel);
        chipPhone = findViewById(R.id.chipPhone);
        tvChipPhoneIcon = findViewById(R.id.tvChipPhoneIcon);
        tvChipPhoneLabel = findViewById(R.id.tvChipPhoneLabel);

        cardPermissionAlert = findViewById(R.id.cardPermissionAlert);
        btnGrantPermissions = findViewById(R.id.btnGrantPermissions);

        btnTestLeft = findViewById(R.id.btnTestLeft);
        btnTestRight = findViewById(R.id.btnTestRight);
        btnTestRoundabout = findViewById(R.id.btnTestRoundabout);
        btnTestDestination = findViewById(R.id.btnTestDestination);
        btnTestCall = findViewById(R.id.btnTestCall);
        btnTestMusic = findViewById(R.id.btnTestMusic);
        btnTestClear = findViewById(R.id.btnTestClear);
        btnExitApp = findViewById(R.id.btnExitApp);

        layoutToggleTerminal = findViewById(R.id.layoutToggleTerminal);
        layoutTerminalBody = findViewById(R.id.layoutTerminalBody);
        tvTerminalToggle = findViewById(R.id.tvTerminalToggle);
        tvRawHex = findViewById(R.id.tvRawHex);
    }

    private void initLiveSystemSensors() {
        // Read initial battery capacity directly from BatteryManager
        try {
            BatteryManager bm = (BatteryManager) getSystemService(Context.BATTERY_SERVICE);
            if (bm != null) {
                int cap = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
                int status = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_STATUS);
                isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING
                        || status == BatteryManager.BATTERY_STATUS_FULL);
                if (cap >= 0) {
                    currentBattery = cap;
                    updateBatteryDisplay(currentBattery, isCharging);
                }
            }
        } catch (Exception ignored) {}

        // Listen for Telephony signal strengths
        try {
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            if (tm != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                tm.registerTelephonyCallback(getMainExecutor(), new MainSignalCallback(this));
            }
        } catch (SecurityException ignored) {}
    }

    private static class MainSignalCallback extends TelephonyCallback implements TelephonyCallback.SignalStrengthsListener {
        private final MainActivity activity;

        MainSignalCallback(MainActivity activity) {
            this.activity = activity;
        }

        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength != null) {
                activity.currentSignalBars = signalStrength.getLevel();
                activity.runOnUiThread(() -> activity.updateSignalDisplay(activity.currentSignalBars));
            }
        }
    }

    private void updateBatteryDisplay(int percent, boolean charging) {
        if (percent < 0) {
            tvLcdBattery.setText("🔋 --%");
            return;
        }
        String icon = charging ? "⚡ " : (percent <= 20 ? "🪫 " : "🔋 ");
        tvLcdBattery.setText(icon + percent + "%");
        if (percent <= 20 && !charging) {
            tvLcdBattery.setTextColor(0xFFEF4444);
        } else if (charging) {
            tvLcdBattery.setTextColor(0xFFF59E0B);
        } else {
            tvLcdBattery.setTextColor(0xFF10B981);
        }
    }

    private void updateSignalDisplay(int bars) {
        if (bars < 0) {
            tvLcdSignal.setText("📶 --");
            return;
        }
        String graph = bars >= 4 ? "●●●●" : bars == 3 ? "●●●○" : bars == 2 ? "●●○○" : bars == 1 ? "●○○○" : "○○○○";
        tvLcdSignal.setText("📶 " + graph + " (" + bars + "/4)");
    }

    private void setupListeners() {
        // Quick Connect / Disconnect Action
        View.OnClickListener toggleConnect = v -> {
            if (bleManager.isConnected()) {
                bleManager.disconnect();
                Toast.makeText(this, "Disconnected from NS400Z", Toast.LENGTH_SHORT).show();
            } else {
                requestAppPermissions();
                bleManager.setAutoReconnect(true);
                bleManager.startScanOrConnect();
                setConnectingState();
            }
        };
        layoutStatusBadge.setOnClickListener(toggleConnect);
        tvQuickLinkAction.setOnClickListener(toggleConnect);
        chipBle.setOnClickListener(toggleConnect);

        // Permission Prompt
        btnGrantPermissions.setOnClickListener(v -> openNotificationSettings());
        chipMaps.setOnClickListener(v -> openNotificationSettings());

        // Pipeline Media Trigger
        chipMedia.setOnClickListener(v -> {
            PulsarForegroundService svc = PulsarForegroundService.getInstance();
            if (svc != null) {
                svc.refreshMediaSessions();
                Toast.makeText(this, "Refreshed active media sessions", Toast.LENGTH_SHORT).show();
            }
        });

        // Diagnostic Simulations
        btnTestLeft.setOnClickListener(v -> simulateNav(
                PulsarProtocol.Maneuver.TURN_LEFT, "Turn Left", 250.0, 8500.0, 7, 45, true, "MG ROAD", 0
        ));
        btnTestRight.setOnClickListener(v -> simulateNav(
                PulsarProtocol.Maneuver.TURN_RIGHT, "Turn Right", 500.0, 12000.0, 8, 15, true, "NH 48 HIGHWAY", 0
        ));
        btnTestRoundabout.setOnClickListener(v -> simulateNav(
                PulsarProtocol.Maneuver.ROUNDABOUT_CW, "Roundabout (Exit 2)", 150.0, 5200.0, 8, 30, true, "RING ROAD CIR.", 2
        ));
        btnTestDestination.setOnClickListener(v -> simulateNav(
                PulsarProtocol.Maneuver.DESTINATION, "Destination Reached", 0.0, 0.0, 8, 45, true, "DESTINATION REACHED", 0
        ));

        btnTestCall.setOnClickListener(v -> {
            int bat = currentBattery >= 0 ? currentBattery : 90;
            int sig = currentSignalBars >= 0 ? currentSignalBars : 4;
            bleManager.sendTelemetry(bat, sig, 1, "MOM (CALLING)", 0, 0);
            tvLcdStreet.setText("CALL: MOM");
            tvLcdManeuverDesc.setText("Incoming Call...");
            tvRawHex.setText("Raw Telemetry (0210):\n[CALL: MOM (RINGING)]");
            Toast.makeText(this, "Dispatched Incoming Call Simulation", Toast.LENGTH_SHORT).show();
        });

        btnTestMusic.setOnClickListener(v -> {
            bleManager.sendMedia("Blinding Lights", "The Weeknd", "After Hours", 45, 200, 2);
            updateCockpitMedia("Blinding Lights", "The Weeknd", 2);
            tvRawHex.setText("Raw Media (0610):\n[Blinding Lights - The Weeknd | PLAYING]");
            Toast.makeText(this, "Dispatched Media Simulation", Toast.LENGTH_SHORT).show();
        });

        btnTestClear.setOnClickListener(v -> {
            byte[] stopPacket = PulsarProtocol.buildTbtClearFrame();
            bleManager.sendTbtFrame(stopPacket);
            updateCockpitNavigation("IDLE", "Navigation Idle", 0.0, 0.0, 12, 0, false, "No Active Route", PulsarProtocol.bytesToHex(stopPacket));
            updateCockpitMedia("", "", 0);
            Toast.makeText(this, "Cleared Cluster LCD Display", Toast.LENGTH_SHORT).show();
        });

        // Packet Inspector Toggle
        layoutToggleTerminal.setOnClickListener(v -> {
            isTerminalExpanded = !isTerminalExpanded;
            layoutTerminalBody.setVisibility(isTerminalExpanded ? View.VISIBLE : View.GONE);
            tvTerminalToggle.setText(isTerminalExpanded ? "▼ HIDE" : "▶ EXPAND");
        });

        // Terminate & Exit Button
        btnExitApp.setOnClickListener(v -> terminateAppSession());
    }

    private void simulateNav(PulsarProtocol.Maneuver maneuver, String desc, double stepDist, double totalDist,
                            int hour, int min, boolean isPm, String street, int exit) {
        byte[] frame = PulsarProtocol.buildTbtFrame(
                maneuver, stepDist, totalDist, hour, min, isPm, street, true, exit
        );
        bleManager.sendTbtFrame(frame);
        updateCockpitNavigation(maneuver.name(), desc, stepDist, totalDist, hour, min, isPm, street, PulsarProtocol.bytesToHex(frame));
        Toast.makeText(this, "Dispatched: " + desc, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupMicroAnimations() {
        // Pulsing green dot for connected state
        pulseAnimator = ObjectAnimator.ofFloat(viewStatusDot, "alpha", 0.3f, 1.0f);
        pulseAnimator.setDuration(900);
        pulseAnimator.setRepeatMode(ValueAnimator.REVERSE);
        pulseAnimator.setRepeatCount(ValueAnimator.INFINITE);
        pulseAnimator.start();

        // Tactile Press Feedback for Interactive Action Chips & Buttons
        View.OnTouchListener tactileTouch = (v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.animate().scaleX(0.96f).scaleY(0.96f).setDuration(80).start();
            } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80).start();
            }
            return false;
        };

        View[] tactileViews = new View[]{
                layoutStatusBadge, btnTestLeft, btnTestRight, btnTestRoundabout, btnTestDestination,
                btnTestCall, btnTestMusic, btnTestClear, btnGrantPermissions, chipBle, chipMaps, chipMedia, chipPhone
        };
        for (View view : tactileViews) {
            if (view != null) view.setOnTouchListener(tactileTouch);
        }
    }

    private void updateCockpitNavigation(String maneuver, String desc, double stepDist, double totalDist,
                                        int etaHour, int etaMin, boolean isPm, String street, String hex) {
        runOnUiThread(() -> {
            tvLcdManeuverGlyph.setText(PulsarProtocol.getGlyphSymbol(maneuver));
            tvLcdManeuverDesc.setText(desc != null ? desc : "Navigation Idle");
            tvLcdStepDist.setText(PulsarProtocol.formatDistance(stepDist));
            tvLcdTotalDist.setText("Remaining: " + PulsarProtocol.formatDistance(totalDist));
            tvLcdEta.setText(PulsarProtocol.formatEta(etaHour, etaMin, isPm));
            tvLcdStreet.setText(street != null && !street.isEmpty() ? street : "Next Turn Point");

            if (hex != null && !hex.isEmpty()) {
                tvRawHex.setText("Raw Turn-by-Turn (0110):\n" + hex);
            }
        });
    }

    private void updateCockpitMedia(String title, String artist, int state) {
        runOnUiThread(() -> {
            if (title == null || title.trim().isEmpty() || state == 0) {
                tvLcdMediaTrack.setText("No media playing");
                tvLcdMediaState.setText("IDLE");
                tvLcdMediaState.setTextColor(0xFF64748B);
                tvLcdMediaIcon.setText("♫");
                tvChipMediaIcon.setText("⚪");
                tvChipMediaLabel.setText("IDLE");
            } else {
                String label = (artist != null && !artist.trim().isEmpty()) ? title + " • " + artist : title;
                tvLcdMediaTrack.setText(label);

                if (state == 2) { // 2 = Playing
                    tvLcdMediaState.setText("PLAYING");
                    tvLcdMediaState.setTextColor(0xFF10B981);
                    tvLcdMediaIcon.setText("▶");
                    tvChipMediaIcon.setText("♫");
                    tvChipMediaLabel.setText("PLAYING");
                } else if (state == 1) { // 1 = Paused
                    tvLcdMediaState.setText("PAUSED");
                    tvLcdMediaState.setTextColor(0xFFF59E0B);
                    tvLcdMediaIcon.setText("❚❚");
                    tvChipMediaIcon.setText("❚❚");
                    tvChipMediaLabel.setText("PAUSED");
                } else {
                    tvLcdMediaState.setText("IDLE");
                    tvLcdMediaState.setTextColor(0xFF64748B);
                    tvLcdMediaIcon.setText("♫");
                    tvChipMediaIcon.setText("⚪");
                    tvChipMediaLabel.setText("IDLE");
                }
            }
        });
    }

    private void setConnectingState() {
        tvStatusBadge.setText("CONNECTING");
        tvStatusBadge.setTextColor(0xFFF59E0B);
        layoutStatusBadge.setBackgroundResource(R.drawable.bg_badge_connecting);
        tvDeviceTarget.setText("SEARCHING FOR BIKE...");
        tvQuickLinkAction.setText("Connecting...");
        tvChipBleIcon.setText("⏳");
    }

    @Override
    public void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress) {
        runOnUiThread(() -> {
            if (connected) {
                tvStatusBadge.setText("CONNECTED");
                tvStatusBadge.setTextColor(0xFF10B981);
                layoutStatusBadge.setBackgroundResource(R.drawable.bg_badge_connected);
                String displayName = (deviceName != null && !deviceName.isEmpty()) ? deviceName : "CONNECTED BIKE";
                if (deviceAddress != null && !deviceAddress.isEmpty()) {
                    tvDeviceTarget.setText(displayName + " • " + deviceAddress);
                } else {
                    tvDeviceTarget.setText(displayName);
                }
                tvQuickLinkAction.setText("Disconnect");
                tvChipBleIcon.setText("⚡");
                tvChipBleLabel.setText("LINKED");
            } else {
                tvStatusBadge.setText("DISCONNECTED");
                tvStatusBadge.setTextColor(0xFFEF4444);
                layoutStatusBadge.setBackgroundResource(R.drawable.bg_badge_disconnected);
                tvDeviceTarget.setText("STANDBY • NO BIKE LINKED");
                tvQuickLinkAction.setText("Tap to Connect");
                tvChipBleIcon.setText("⚪");
                tvChipBleLabel.setText("BLE LINK");
            }
        });
    }

    private void terminateAppSession() {
        Toast.makeText(this, "Terminating all services and exiting...", Toast.LENGTH_SHORT).show();

        // 1. Stop BLE auto-reconnect and disconnect
        if (bleManager != null) {
            bleManager.setAutoReconnect(false);
            bleManager.stopScan();
            bleManager.disconnect();
        }

        // 2. Send ACTION_STOP to foreground service
        try {
            Intent stopIntent = new Intent(this, PulsarForegroundService.class);
            stopIntent.setAction(PulsarForegroundService.ACTION_STOP);
            startService(stopIntent);
        } catch (Exception ignored) {}

        // 3. Clear all system notifications
        try {
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (nm != null) {
                nm.cancelAll();
            }
        } catch (Exception ignored) {}

        // 4. Finish all activities
        finishAffinity();

        // 5. Terminate process cleanly
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }, 150);
    }

    @Override
    public void onPacketSent(String charUuid, byte[] frame, boolean success) {
        runOnUiThread(() -> {
            if (PulsarProtocol.CHAR_TBT_UUID.equalsIgnoreCase(charUuid)) {
                tvRawHex.setText("Sent TBT (0110, " + (frame != null ? frame.length : 0) + "B, " + (success ? "OK" : "QUEUED") + "):\n"
                        + PulsarProtocol.bytesToHex(frame));
            }
        });
    }

    @Override
    public void onHandlebarEvent(PulsarProtocol.HandlebarEvent event) {
        runOnUiThread(() -> {
            if (event.musicNext) Toast.makeText(this, "Handlebar: Track Next", Toast.LENGTH_SHORT).show();
            else if (event.musicPrev) Toast.makeText(this, "Handlebar: Track Prev", Toast.LENGTH_SHORT).show();
            else if (event.musicPlay) Toast.makeText(this, "Handlebar: Music Play", Toast.LENGTH_SHORT).show();
            else if (event.musicPause) Toast.makeText(this, "Handlebar: Music Pause", Toast.LENGTH_SHORT).show();
            else if (event.callAccept) Toast.makeText(this, "Handlebar: Answer Call", Toast.LENGTH_SHORT).show();
            else if (event.callReject) Toast.makeText(this, "Handlebar: End Call", Toast.LENGTH_SHORT).show();
        });
    }

    private void openNotificationSettings() {
        try {
            startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
        } catch (Exception e) {
            Toast.makeText(this, "Unable to open Notification settings", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkSystemHooks() {
        String pkg = getPackageName();
        String flat = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
        boolean notifGranted = flat != null && flat.contains(pkg);

        if (notifGranted) {
            tvChipMapsIcon.setText("✓");
            tvChipMapsLabel.setText("G-MAPS");
            cardPermissionAlert.setVisibility(View.GONE);
        } else {
            tvChipMapsIcon.setText("⚠");
            tvChipMapsLabel.setText("ACTION REQ");
            cardPermissionAlert.setVisibility(View.VISIBLE);
        }

        boolean phoneGranted = checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
        tvChipPhoneIcon.setText(phoneGranted ? "✓" : "⚠");
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
                requestPermissions(perms, PERMISSION_REQ_CODE);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkSystemHooks();
        clockHandler.post(clockRunnable);

        // Re-request system binding to GoogleMapsNotificationListener if enabled
        try {
            NotificationListenerService.requestRebind(new ComponentName(this, GoogleMapsNotificationListener.class));
        } catch (Exception ignored) {}

        // Query active media state on resume
        PulsarForegroundService svc = PulsarForegroundService.getInstance();
        if (svc != null && svc.getMediaListener() != null) {
            MediaStateListener ml = svc.getMediaListener();
            if (!ml.getCurrentTitle().isEmpty()) {
                updateCockpitMedia(ml.getCurrentTitle(), ml.getCurrentArtist(), ml.isPlaying() ? 2 : 1);
            }
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(GoogleMapsNotificationListener.ACTION_TBT_UPDATE);
        filter.addAction(MediaStateListener.ACTION_MEDIA_UPDATE);
        filter.addAction(PhoneStateMonitor.ACTION_TELEMETRY_UPDATE);
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(systemUpdatesReceiver, filter, Context.RECEIVER_NOT_EXPORTED);
        } else {
            registerReceiver(systemUpdatesReceiver, filter);
        }

        if (!bleManager.isConnected()) {
            bleManager.startScanOrConnect();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        clockHandler.removeCallbacks(clockRunnable);
        try {
            unregisterReceiver(systemUpdatesReceiver);
        } catch (Exception ignored) {}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pulseAnimator != null) {
            pulseAnimator.cancel();
        }
        if (bleManager != null) {
            bleManager.removeListener(this);
        }
    }
}
