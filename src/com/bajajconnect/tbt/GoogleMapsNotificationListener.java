package com.bajajconnect.tbt;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lightweight Android Notification Listener Service.
 * Hooks into Google Maps active navigation notifications and converts them into
 * real-time BLE GATT packets for the Bajaj Pulsar NS400Z digital cluster.
 */
public class GoogleMapsNotificationListener extends NotificationListenerService {

    private static final String TAG = "GoogleMapsTbtListener";
    private static final String GOOGLE_MAPS_PKG = "com.google.android.apps.maps";

    // Regex for parsing typical turn prompts: "In 350 m, turn left on MG Road"
    private static final Pattern DISTANCE_PATTERN = Pattern.compile("(?i)(\\d+(?:\\.\\d+)?)\\s*(m|km|ft|mi)");

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

        Log.d(TAG, String.format("G-Maps Nav: Title='%s', Text='%s', SubText='%s'", title, text, subText));

        // Parse maneuver and distance
        TbtFrameBuilder.Maneuver maneuver = parseManeuver(title + " " + text);
        double distanceMeters = parseDistance(title + " " + text);

        // Dispatch frame via BLE manager
        byte[] tbtPacket = TbtFrameBuilder.buildFrame(
                maneuver,
                distanceMeters,
                0.0,
                12,
                0,
                false,
                text,
                true,
                0
        );

        TbtBleDispatcher.getInstance(getApplicationContext()).sendTbtFrame(tbtPacket);
    }

    private TbtFrameBuilder.Maneuver parseManeuver(String input) {
        String lower = input.toLowerCase();
        if (lower.contains("sharp left")) return TbtFrameBuilder.Maneuver.SHARP_LEFT;
        if (lower.contains("sharp right")) return TbtFrameBuilder.Maneuver.SHARP_RIGHT;
        if (lower.contains("slight left")) return TbtFrameBuilder.Maneuver.SLIGHT_LEFT;
        if (lower.contains("slight right")) return TbtFrameBuilder.Maneuver.SLIGHT_RIGHT;
        if (lower.contains("turn left") || lower.contains("left")) return TbtFrameBuilder.Maneuver.TURN_LEFT;
        if (lower.contains("turn right") || lower.contains("right")) return TbtFrameBuilder.Maneuver.TURN_RIGHT;
        if (lower.contains("u-turn") || lower.contains("uturn")) return TbtFrameBuilder.Maneuver.U_TURN_LEFT;
        if (lower.contains("roundabout")) return TbtFrameBuilder.Maneuver.ROUNDABOUT_CW;
        if (lower.contains("destination") || lower.contains("arrived")) return TbtFrameBuilder.Maneuver.DESTINATION;
        return TbtFrameBuilder.Maneuver.STRAIGHT;
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

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        if (GOOGLE_MAPS_PKG.equals(sbn.getPackageName())) {
            Log.d(TAG, "G-Maps Navigation Stopped.");
            byte[] stopPacket = new byte[48]; // all zeros = navigation stopped
            TbtBleDispatcher.getInstance(getApplicationContext()).sendTbtFrame(stopPacket);
        }
    }
}
