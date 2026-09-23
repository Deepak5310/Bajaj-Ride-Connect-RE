package com.pulsar.ns400z.tbtbridge;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enterprise Google Maps Notification Listener Service for Bajaj Pulsar NS400Z.
 * Intercepts active navigation turns and dispatches real-time BLE GATT frames
 * to the digital speedometer cluster.
 */
public class GoogleMapsNotificationListener extends NotificationListenerService {

    private static final String TAG = "GoogleMapsTbtListener";
    public static final String GOOGLE_MAPS_PKG = "com.google.android.apps.maps";
    public static final String ACTION_TBT_UPDATE = "com.pulsar.ns400z.tbtbridge.TBT_UPDATE";

    private static final Pattern DISTANCE_PATTERN = Pattern.compile("(?i)(\\d+(?:\\.\\d+)?)\\s*(m|km|ft|mi)");
    private static final Pattern ETA_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{2})\\s*(AM|PM)?", Pattern.CASE_INSENSITIVE);
    private static final Pattern ROUNDABOUT_PATTERN = Pattern.compile("(?i)(?:take the|exit)\\s*(\\d+)(?:st|nd|rd|th)?\\s*exit");

    public static boolean isServiceRunning = false;

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        isServiceRunning = true;
        Log.i(TAG, "Google Maps TBT Listener Connected & Active.");
        PulsarForegroundService.start(this);
        PulsarForegroundService svc = PulsarForegroundService.getInstance();
        if (svc != null) {
            svc.refreshMediaSessions();
        }
    }

    @Override
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        isServiceRunning = false;
        Log.i(TAG, "Google Maps TBT Listener Disconnected.");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (sbn == null || !GOOGLE_MAPS_PKG.equals(sbn.getPackageName())) {
            return;
        }

        Notification notification = sbn.getNotification();
        if (notification == null || notification.extras == null) {
            return;
        }

        Bundle extras = notification.extras;
        CharSequence titleSeq = extras.getCharSequence(Notification.EXTRA_TITLE);
        CharSequence textSeq = extras.getCharSequence(Notification.EXTRA_TEXT);
        CharSequence subTextSeq = extras.getCharSequence(Notification.EXTRA_SUB_TEXT);

        String title = titleSeq != null ? titleSeq.toString() : "";
        String text = textSeq != null ? textSeq.toString() : "";
        String subText = subTextSeq != null ? subTextSeq.toString() : "";

        String fullPrompt = (title + " " + text + " " + subText).trim();
        Log.d(TAG, String.format("G-Maps Nav: Title='%s', Text='%s', SubText='%s'", title, text, subText));

        // 1. Maneuver & Roundabout Exit
        PulsarProtocol.Maneuver maneuver = parseManeuver(fullPrompt);
        int roundaboutExit = parseRoundaboutExit(fullPrompt);

        // 2. Step Distance
        double stepDistMeters = parseDistance(title + " " + text);

        // 3. Total Distance
        double totalDistMeters = parseTotalDistance(subText + " " + text);

        // 4. ETA Calculation
        int etaHour = 12;
        int etaMin = 0;
        boolean isPm = false;
        Matcher etaM = ETA_PATTERN.matcher(fullPrompt);
        if (etaM.find()) {
            etaHour = Integer.parseInt(etaM.group(1));
            etaMin = Integer.parseInt(etaM.group(2));
            String ampm = etaM.group(3);
            if (ampm != null) {
                isPm = ampm.equalsIgnoreCase("PM");
            } else {
                isPm = etaHour >= 12;
                if (etaHour > 12) etaHour -= 12;
            }
        } else {
            Calendar c = Calendar.getInstance();
            etaHour = c.get(Calendar.HOUR);
            if (etaHour == 0) etaHour = 12;
            etaMin = c.get(Calendar.MINUTE);
            isPm = c.get(Calendar.AM_PM) == Calendar.PM;
        }

        // 5. Street / Destination Name
        String street = parseStreet(title, text);

        // Build 48-byte BLE packet
        byte[] frame = PulsarProtocol.buildTbtFrame(
                maneuver,
                stepDistMeters,
                totalDistMeters,
                etaHour,
                etaMin,
                isPm,
                street,
                true,
                roundaboutExit
        );

        // Dispatch directly to motorcycle cluster
        PulsarBleManager.getInstance(getApplicationContext()).sendTbtFrame(frame);

        PulsarForegroundService svc = PulsarForegroundService.getInstance();
        if (svc != null) {
            svc.updateNavStatus(maneuver.description, street);
        }

        // Broadcast update to MainActivity & Foreground Service
        Intent intent = new Intent(ACTION_TBT_UPDATE);
        intent.setPackage(getPackageName());
        intent.putExtra("maneuver", maneuver.name());
        intent.putExtra("maneuver_desc", maneuver.description);
        intent.putExtra("step_dist", stepDistMeters);
        intent.putExtra("total_dist", totalDistMeters);
        intent.putExtra("eta_hour", etaHour);
        intent.putExtra("eta_min", etaMin);
        intent.putExtra("is_pm", isPm);
        intent.putExtra("street", street);
        intent.putExtra("hex", PulsarProtocol.bytesToHex(frame));
        sendBroadcast(intent);
    }

    private PulsarProtocol.Maneuver parseManeuver(String input) {
        String lower = input.toLowerCase();
        if (lower.contains("sharp left")) return PulsarProtocol.Maneuver.SHARP_LEFT;
        if (lower.contains("sharp right")) return PulsarProtocol.Maneuver.SHARP_RIGHT;
        if (lower.contains("slight left")) return PulsarProtocol.Maneuver.SLIGHT_LEFT;
        if (lower.contains("slight right")) return PulsarProtocol.Maneuver.SLIGHT_RIGHT;
        if (lower.contains("keep left")) return PulsarProtocol.Maneuver.KEEP_LEFT;
        if (lower.contains("keep right")) return PulsarProtocol.Maneuver.KEEP_RIGHT;
        if (lower.contains("u-turn") || lower.contains("uturn")) return PulsarProtocol.Maneuver.U_TURN_LEFT;
        if (lower.contains("roundabout")) return PulsarProtocol.Maneuver.ROUNDABOUT_CW;
        if (lower.contains("destination") || lower.contains("arrived")) return PulsarProtocol.Maneuver.DESTINATION;
        if (lower.contains("turn left") || lower.contains("left")) return PulsarProtocol.Maneuver.TURN_LEFT;
        if (lower.contains("turn right") || lower.contains("right")) return PulsarProtocol.Maneuver.TURN_RIGHT;
        if (lower.contains("ramp left")) return PulsarProtocol.Maneuver.RAMP_LEFT;
        if (lower.contains("ramp right")) return PulsarProtocol.Maneuver.RAMP_RIGHT;
        if (lower.contains("merge")) return PulsarProtocol.Maneuver.MERGE;
        return PulsarProtocol.Maneuver.STRAIGHT;
    }

    private int parseRoundaboutExit(String input) {
        Matcher m = ROUNDABOUT_PATTERN.matcher(input);
        if (m.find()) {
            try {
                return Integer.parseInt(m.group(1));
            } catch (NumberFormatException ignored) {}
        }
        return 0;
    }

    private double parseDistance(String input) {
        Matcher m = DISTANCE_PATTERN.matcher(input);
        if (m.find()) {
            double val = Double.parseDouble(m.group(1));
            String unit = m.group(2).toLowerCase();
            if ("km".equals(unit)) return val * 1000.0;
            if ("m".equals(unit)) return val;
            if ("ft".equals(unit)) return val * 0.3048;
            if ("mi".equals(unit)) return val * 1609.34;
        }
        return 0.0;
    }

    private double parseTotalDistance(String input) {
        Matcher m = DISTANCE_PATTERN.matcher(input);
        double lastDist = 0.0;
        while (m.find()) {
            double val = Double.parseDouble(m.group(1));
            String unit = m.group(2).toLowerCase();
            if ("km".equals(unit)) lastDist = val * 1000.0;
            else if ("m".equals(unit)) lastDist = val;
            else if ("mi".equals(unit)) lastDist = val * 1609.34;
        }
        return lastDist;
    }

    private String parseStreet(String title, String text) {
        if (title.contains(" on ") || title.contains(" onto ")) {
            String[] parts = title.split("(?i)\\s+on(?:to)?\\s+");
            if (parts.length > 1) return parts[1].trim();
        }
        if (text.contains(" on ") || text.contains(" onto ")) {
            String[] parts = text.split("(?i)\\s+on(?:to)?\\s+");
            if (parts.length > 1) return parts[1].trim();
        }
        if (!text.isEmpty() && !text.contains("·")) {
            return text.trim();
        }
        return "";
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        if (sbn != null && GOOGLE_MAPS_PKG.equals(sbn.getPackageName())) {
            Log.i(TAG, "Google Maps Navigation ended -> Clearing NS400Z cluster.");
            byte[] stopPacket = PulsarProtocol.buildTbtClearFrame();
            PulsarBleManager.getInstance(getApplicationContext()).sendTbtFrame(stopPacket);

            PulsarForegroundService svc = PulsarForegroundService.getInstance();
            if (svc != null) {
                svc.updateNavStatus("Idle / Stopped", "--");
            }

            Intent intent = new Intent(ACTION_TBT_UPDATE);
            intent.setPackage(getPackageName());
            intent.putExtra("maneuver", "IDLE / STOPPED");
            intent.putExtra("maneuver_desc", "Navigation Idle");
            intent.putExtra("step_dist", 0.0);
            intent.putExtra("total_dist", 0.0);
            intent.putExtra("eta_hour", 0);
            intent.putExtra("eta_min", 0);
            intent.putExtra("is_pm", false);
            intent.putExtra("street", "");
            intent.putExtra("hex", PulsarProtocol.bytesToHex(stopPacket));
            sendBroadcast(intent);
        }
    }
}
