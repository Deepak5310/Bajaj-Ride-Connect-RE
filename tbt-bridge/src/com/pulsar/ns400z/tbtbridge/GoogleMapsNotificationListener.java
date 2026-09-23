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
 * Lightweight Android Notification Listener Service for Google Maps.
 * Intercepts active navigation turns and dispatches real-time BLE GATT frames
 * to the Bajaj Pulsar NS400Z motorcycle speedometer cluster.
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
    }

    @Override
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        isServiceRunning = false;
        Log.i(TAG, "Google Maps TBT Listener Disconnected.");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (!GOOGLE_MAPS_PKG.equals(sbn.getPackageName())) {
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
        TbtFrameBuilder.Maneuver maneuver = parseManeuver(fullPrompt);
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
        byte[] frame = TbtFrameBuilder.buildFrame(
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

        // Dispatch to motorcycle
        TbtBleDispatcher.getInstance(getApplicationContext()).sendTbtFrame(frame);

        // Broadcast update to MainActivity
        Intent intent = new Intent(ACTION_TBT_UPDATE);
        intent.setPackage(getPackageName());
        intent.putExtra("maneuver", maneuver.name());
        intent.putExtra("step_dist", stepDistMeters);
        intent.putExtra("total_dist", totalDistMeters);
        intent.putExtra("eta_hour", etaHour);
        intent.putExtra("eta_min", etaMin);
        intent.putExtra("is_pm", isPm);
        intent.putExtra("street", street);
        intent.putExtra("hex", bytesToHex(frame));
        sendBroadcast(intent);
    }

    private TbtFrameBuilder.Maneuver parseManeuver(String input) {
        String lower = input.toLowerCase();
        if (lower.contains("sharp left")) return TbtFrameBuilder.Maneuver.SHARP_LEFT;
        if (lower.contains("sharp right")) return TbtFrameBuilder.Maneuver.SHARP_RIGHT;
        if (lower.contains("slight left")) return TbtFrameBuilder.Maneuver.SLIGHT_LEFT;
        if (lower.contains("slight right")) return TbtFrameBuilder.Maneuver.SLIGHT_RIGHT;
        if (lower.contains("keep left")) return TbtFrameBuilder.Maneuver.KEEP_LEFT;
        if (lower.contains("keep right")) return TbtFrameBuilder.Maneuver.KEEP_RIGHT;
        if (lower.contains("u-turn") || lower.contains("uturn")) return TbtFrameBuilder.Maneuver.U_TURN_LEFT;
        if (lower.contains("roundabout")) return TbtFrameBuilder.Maneuver.ROUNDABOUT_CW;
        if (lower.contains("destination") || lower.contains("arrived")) return TbtFrameBuilder.Maneuver.DESTINATION;
        if (lower.contains("turn left") || lower.contains("left")) return TbtFrameBuilder.Maneuver.TURN_LEFT;
        if (lower.contains("turn right") || lower.contains("right")) return TbtFrameBuilder.Maneuver.TURN_RIGHT;
        if (lower.contains("merge")) return TbtFrameBuilder.Maneuver.MERGE;
        return TbtFrameBuilder.Maneuver.STRAIGHT;
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
        if (GOOGLE_MAPS_PKG.equals(sbn.getPackageName())) {
            Log.i(TAG, "Google Maps Navigation ended -> Clearing NS400Z cluster.");
            byte[] stopPacket = new byte[48]; // All zeros = Clear TBT
            TbtBleDispatcher.getInstance(getApplicationContext()).sendTbtFrame(stopPacket);

            Intent intent = new Intent(ACTION_TBT_UPDATE);
            intent.setPackage(getPackageName());
            intent.putExtra("maneuver", "IDLE / STOPPED");
            intent.putExtra("step_dist", 0.0);
            intent.putExtra("total_dist", 0.0);
            intent.putExtra("eta_hour", 0);
            intent.putExtra("eta_min", 0);
            intent.putExtra("is_pm", false);
            intent.putExtra("street", "");
            intent.putExtra("hex", bytesToHex(stopPacket));
            sendBroadcast(intent);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
