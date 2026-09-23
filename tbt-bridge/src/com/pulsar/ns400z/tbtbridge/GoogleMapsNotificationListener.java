package com.pulsar.ns400z.tbtbridge;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    private static final Pattern DISTANCE_PATTERN = Pattern.compile("(?i)(\\d+(?:[.,]\\d+)?)\\s*(m|km|ft|mi|meter|kilomet|mile)");
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
        CharSequence bigTextSeq = extras.getCharSequence(Notification.EXTRA_BIG_TEXT);
        CharSequence titleBigSeq = extras.getCharSequence(Notification.EXTRA_TITLE_BIG);
        CharSequence tickerSeq = notification.tickerText;

        CharSequence[] linesSeq = extras.getCharSequenceArray(Notification.EXTRA_TEXT_LINES);
        StringBuilder linesBuilder = new StringBuilder();
        if (linesSeq != null) {
            for (CharSequence l : linesSeq) {
                if (l != null) linesBuilder.append(" ").append(clean(l.toString()));
            }
        }

        String title = clean(titleSeq != null ? titleSeq.toString() : (titleBigSeq != null ? titleBigSeq.toString() : ""));
        String text = clean(textSeq != null ? textSeq.toString() : (bigTextSeq != null ? bigTextSeq.toString() : ""));
        String subText = clean(subTextSeq != null ? subTextSeq.toString() : "");
        String ticker = clean(tickerSeq != null ? tickerSeq.toString() : "");

        String fullPrompt = (title + " " + text + " " + subText + " " + ticker + linesBuilder.toString()).trim();
        Log.i(TAG, String.format("G-Maps Nav Notification: Title='%s', Text='%s', SubText='%s', Full='%s'",
                title, text, subText, fullPrompt));

        // Parse distances: collect all matches
        List<Double> dists = parseAllDistances(fullPrompt);
        double stepDistMeters = !dists.isEmpty() ? dists.get(0) : 0.0;
        double totalDistMeters = dists.size() > 1 ? dists.get(dists.size() - 1) : stepDistMeters;

        // Maneuver & Roundabout Exit
        PulsarProtocol.Maneuver maneuver = parseManeuver(fullPrompt);
        int roundaboutExit = parseRoundaboutExit(fullPrompt);

        // ETA Calculation
        int etaHour = 12;
        int etaMin = 0;
        boolean isPm = false;
        Matcher etaM = ETA_PATTERN.matcher(fullPrompt);
        if (etaM.find()) {
            try {
                etaHour = Integer.parseInt(etaM.group(1));
                etaMin = Integer.parseInt(etaM.group(2));
                String ampm = etaM.group(3);
                if (ampm != null && !ampm.isEmpty()) {
                    isPm = ampm.equalsIgnoreCase("PM");
                } else {
                    isPm = etaHour >= 12;
                    if (etaHour > 12) etaHour -= 12;
                }
            } catch (Exception ignored) {}
        } else {
            Calendar c = Calendar.getInstance();
            etaHour = c.get(Calendar.HOUR);
            if (etaHour == 0) etaHour = 12;
            etaMin = c.get(Calendar.MINUTE);
            isPm = c.get(Calendar.AM_PM) == Calendar.PM;
        }

        // Street / Destination Name
        String street = parseStreet(title, text);

        Log.i(TAG, String.format("Parsed: %s, step=%.0fm, total=%.0fm, eta=%d:%02d %s, street='%s', exit=%d",
                maneuver.description, stepDistMeters, totalDistMeters, etaHour, etaMin, isPm ? "PM" : "AM", street, roundaboutExit));

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

    private static String clean(String s) {
        if (s == null) return "";
        return s.replace('\u00A0', ' ')
                .replace('\u202F', ' ')
                .replace('\u200B', ' ')
                .replace('\uFEFF', ' ')
                .trim();
    }

    private List<Double> parseAllDistances(String input) {
        List<Double> list = new ArrayList<>();
        Matcher m = DISTANCE_PATTERN.matcher(input);
        while (m.find()) {
            try {
                double val = Double.parseDouble(m.group(1).replace(',', '.'));
                String unit = m.group(2).toLowerCase();
                double meters;
                if (unit.startsWith("km") || unit.startsWith("kilomet")) {
                    meters = val * 1000.0;
                } else if (unit.startsWith("mi") || unit.startsWith("mile")) {
                    meters = val * 1609.34;
                } else if (unit.startsWith("ft")) {
                    meters = val * 0.3048;
                } else {
                    meters = val;
                }
                list.add(meters);
            } catch (Exception ignored) {}
        }
        return list;
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

    private String parseStreet(String title, String text) {
        if (title.contains(" on ") || title.contains(" onto ")) {
            String[] parts = title.split("(?i)\\s+on(?:to)?\\s+");
            if (parts.length > 1) return parts[1].trim();
        }
        if (text.contains(" on ") || text.contains(" onto ")) {
            String[] parts = text.split("(?i)\\s+on(?:to)?\\s+");
            if (parts.length > 1) return parts[1].trim();
        }
        if (text.contains("·")) {
            String candidate = text.split("·")[0].trim();
            if (!DISTANCE_PATTERN.matcher(candidate).find()) return candidate;
        }
        if (!text.isEmpty() && !DISTANCE_PATTERN.matcher(text).find()) {
            return text.trim();
        }
        if (!title.isEmpty() && !DISTANCE_PATTERN.matcher(title).find()) {
            return title.trim();
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
