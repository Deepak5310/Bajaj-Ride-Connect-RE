package com.bajaj.rideconnect.re;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Enterprise Android Media Controller and Session Listener for Spotify, YouTube Music, Apple Music.
 * Features:
 * - Real-time 1-second progress ticker with smooth elapsed time & progress bar synchronization
 * - Direct TransportControls with graceful fallback to media key events
 * - Album artwork extraction from MediaMetadata
 * - Direct UI observer callbacks (zero-latency in-process delivery)
 * - Streams now-playing track info to motorcycle LCD cluster via BLE GATT
 */
public class MediaStateListener {

    private static final String TAG = "MediaStateListener";
    public static final String ACTION_MEDIA_UPDATE = "com.bajaj.rideconnect.re.MEDIA_UPDATE";

    public interface MediaObserver {
        void onMediaUpdated(String title, String artist, String album, String source,
                            int playbackState, int posSec, int durSec, Bitmap artwork);
    }

    private static MediaStateListener instance;

    private final Context context;
    private final PulsarBleManager bleManager;
    private MediaSessionManager mediaSessionManager;
    private MediaController activeController;
    private MediaSessionManager.OnActiveSessionsChangedListener sessionsChangedListener;
    private final Handler handler = new Handler(Looper.getMainLooper());

    private final List<MediaObserver> observers = new CopyOnWriteArrayList<>();

    private String currentTitle = "";
    private String currentArtist = "";
    private String currentAlbum = "";
    private Bitmap currentAlbumArt = null;
    private int currentPlaybackState = 0; // 0=Stop/None, 1=Pause, 2=Play (matches Bajaj PlayStatus enum)
    private int currentPosSec = 0;
    private int currentDurSec = 0;
    private long lastPositionUpdateTime = 0;
    private float playbackSpeed = 1.0f;

    public static MediaStateListener getInstance() {
        return instance;
    }

    public static boolean isNotificationListenerEnabled(Context context) {
        if (context == null) return false;
        String pkgName = context.getPackageName();
        final String flat = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (flat != null && !flat.isEmpty()) {
            final String[] names = flat.split(":");
            for (String name : names) {
                final ComponentName cn = ComponentName.unflattenFromString(name);
                if (cn != null && pkgName.equals(cn.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public MediaStateListener(Context context, PulsarBleManager bleManager) {
        this.context = context.getApplicationContext();
        this.bleManager = bleManager;
        instance = this;
        initMediaSessions();
    }

    public void registerObserver(MediaObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
            observer.onMediaUpdated(currentTitle, currentArtist, currentAlbum, getCurrentSource(),
                    currentPlaybackState, currentPosSec, currentDurSec, currentAlbumArt);
        }
    }

    public void unregisterObserver(MediaObserver observer) {
        observers.remove(observer);
    }

    public void initMediaSessions() {
        try {
            mediaSessionManager = (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
            if (mediaSessionManager == null) {
                Log.w(TAG, "MediaSessionManager unavailable");
                return;
            }
            ComponentName compName = new ComponentName(context, PulsarNotificationService.class);

            if (sessionsChangedListener != null) {
                try {
                    mediaSessionManager.removeOnActiveSessionsChangedListener(sessionsChangedListener);
                } catch (Exception ignored) {}
            }
            sessionsChangedListener = controllers -> updateActiveController();
            mediaSessionManager.addOnActiveSessionsChangedListener(sessionsChangedListener, compName, handler);

            updateActiveController();
        } catch (SecurityException e) {
            Log.w(TAG, "Notification listener permission needed for MediaSessionManager: " + e.getMessage());
        }
    }

    public void refreshMediaSessions() {
        handler.post(this::updateActiveController);
    }

    public synchronized void updateActiveController() {
        try {
            if (mediaSessionManager == null) return;
            ComponentName compName = new ComponentName(context, PulsarNotificationService.class);
            List<MediaController> controllers = mediaSessionManager.getActiveSessions(compName);

            if (controllers == null || controllers.isEmpty()) {
                Log.i(TAG, "No active media sessions found.");
                if (activeController != null) {
                    activeController.unregisterCallback(controllerCallback);
                    activeController = null;
                    currentTitle = "";
                    currentArtist = "";
                    currentAlbum = "";
                    currentAlbumArt = null;
                    currentPlaybackState = 0;
                    currentPosSec = 0;
                    currentDurSec = 0;
                    handler.removeCallbacks(progressTicker);
                    dispatchMediaUpdate();
                    if (bleManager != null) {
                        bleManager.sendMedia("", "", "", 0, 0, 0);
                    }
                }
                return;
            }

            // Select active or playing controller
            MediaController playing = null;
            MediaController existing = null;
            for (MediaController c : controllers) {
                PlaybackState ps = c.getPlaybackState();
                int st = ps != null ? ps.getState() : PlaybackState.STATE_NONE;
                if (playing == null && st == PlaybackState.STATE_PLAYING) {
                    playing = c;
                }
                if (existing == null && isSameSession(activeController, c)) {
                    existing = c;
                }
            }

            MediaController chosen = playing != null ? playing
                    : existing != null ? existing
                    : controllers.get(0);

            if (!isSameSession(activeController, chosen)) {
                if (activeController != null) {
                    activeController.unregisterCallback(controllerCallback);
                }
                activeController = chosen;
                activeController.registerCallback(controllerCallback, handler);
                Log.i(TAG, "Active media controller -> " + chosen.getPackageName());
                syncMetadata();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error updating media controller: " + e.getMessage());
        }
    }

    private static boolean isSameSession(MediaController a, MediaController b) {
        if (a == null || b == null) return false;
        if (a == b) return true;
        MediaSession.Token ta = a.getSessionToken();
        MediaSession.Token tb = b.getSessionToken();
        return ta != null && ta.equals(tb);
    }

    private final MediaController.Callback controllerCallback = new MediaController.Callback() {
        @Override
        public void onMetadataChanged(MediaMetadata metadata) {
            syncMetadata();
        }

        @Override
        public void onPlaybackStateChanged(PlaybackState state) {
            syncMetadata();
        }
    };

    /**
     * Periodic 1-second progress ticker for active playing sessions.
     */
    private final Runnable progressTicker = new Runnable() {
        @Override
        public void run() {
            if (activeController != null && isPlaying()) {
                PlaybackState ps = activeController.getPlaybackState();
                if (ps != null && ps.getState() == PlaybackState.STATE_PLAYING) {
                    long currentMs = ps.getPosition();
                    long delta = SystemClock.elapsedRealtime() - ps.getLastPositionUpdateTime();
                    if (delta > 0) {
                        currentMs += (long) (delta * ps.getPlaybackSpeed());
                    }
                    currentPosSec = (int) (currentMs / 1000);
                    if (currentDurSec > 0 && currentPosSec > currentDurSec) {
                        currentPosSec = currentDurSec;
                    }
                    dispatchMediaUpdate();
                    handler.postDelayed(this, 1000);
                    return;
                }
            }
        }
    };

    /**
     * Synchronize latest track metadata, artwork, playback state, and notify UI + BLE.
     */
    public void syncMetadata() {
        if (activeController == null) {
            updateActiveController();
            if (activeController == null) {
                return;
            }
        }
        MediaMetadata metadata = activeController.getMetadata();
        PlaybackState pbState = activeController.getPlaybackState();

        if (metadata != null) {
            currentTitle = metadata.getString(MediaMetadata.METADATA_KEY_TITLE);
            if (currentTitle == null || currentTitle.trim().isEmpty()) {
                currentTitle = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE);
            }
            if (currentTitle == null) currentTitle = "";

            currentArtist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
            if (currentArtist == null || currentArtist.trim().isEmpty()) {
                currentArtist = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM_ARTIST);
            }
            if (currentArtist == null || currentArtist.trim().isEmpty()) {
                currentArtist = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE);
            }
            if (currentArtist == null) currentArtist = "";

            currentAlbum = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
            if (currentAlbum == null || currentAlbum.trim().isEmpty()) {
                currentAlbum = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_DESCRIPTION);
            }
            if (currentAlbum == null) currentAlbum = "";

            long durMs = metadata.getLong(MediaMetadata.METADATA_KEY_DURATION);
            if (durMs <= 0) {
                try {
                    String durStr = metadata.getString(MediaMetadata.METADATA_KEY_DURATION);
                    if (durStr != null) durMs = Long.parseLong(durStr);
                } catch (Exception ignored) {}
            }
            currentDurSec = (int) (durMs / 1000);

            // Extract Album Artwork
            Bitmap art = metadata.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART);
            if (art == null) {
                art = metadata.getBitmap(MediaMetadata.METADATA_KEY_ART);
            }
            if (art == null) {
                art = metadata.getBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON);
            }
            currentAlbumArt = art;
        }

        int state = 0; // 0=None, 1=Paused, 2=Playing
        if (pbState != null) {
            long currentMs = pbState.getPosition();
            lastPositionUpdateTime = pbState.getLastPositionUpdateTime();
            playbackSpeed = pbState.getPlaybackSpeed();
            if (playbackSpeed <= 0) playbackSpeed = 1.0f;

            if (pbState.getState() == PlaybackState.STATE_PLAYING) {
                long delta = SystemClock.elapsedRealtime() - lastPositionUpdateTime;
                if (delta > 0) {
                    currentMs += (long) (delta * playbackSpeed);
                }
                state = 2;
            } else if (pbState.getState() == PlaybackState.STATE_PAUSED) {
                state = 1;
            } else {
                state = (currentTitle.isEmpty()) ? 0 : 1;
            }
            currentPosSec = (int) (currentMs / 1000);
            if (currentDurSec > 0 && currentPosSec > currentDurSec) {
                currentPosSec = currentDurSec;
            }
        }
        currentPlaybackState = state;

        if (state == 2) {
            handler.removeCallbacks(progressTicker);
            handler.postDelayed(progressTicker, 1000);
        } else {
            handler.removeCallbacks(progressTicker);
        }

        dispatchMediaUpdate();

        if (bleManager != null) {
            bleManager.sendMedia(currentTitle, currentArtist, currentAlbum, currentPosSec, currentDurSec, state);
        }
    }

    private void dispatchMediaUpdate() {
        String sourceName = getCurrentSource();

        // 1. In-process direct observers (UI instant delivery with Bitmap)
        for (MediaObserver obs : observers) {
            try {
                obs.onMediaUpdated(currentTitle, currentArtist, currentAlbum, sourceName,
                        currentPlaybackState, currentPosSec, currentDurSec, currentAlbumArt);
            } catch (Exception e) {
                Log.w(TAG, "Error notifying observer: " + e.getMessage());
            }
        }

        // 2. Broadcast for background components
        Intent intent = new Intent(ACTION_MEDIA_UPDATE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("title", currentTitle);
        intent.putExtra("artist", currentArtist);
        intent.putExtra("album", currentAlbum);
        intent.putExtra("source", sourceName);
        intent.putExtra("duration_sec", currentDurSec);
        intent.putExtra("position_sec", currentPosSec);
        intent.putExtra("playback_state", currentPlaybackState);
        context.sendBroadcast(intent);
    }

    private static String formatSourceLabel(String pkg) {
        if (pkg == null || pkg.isEmpty()) return "Music Player";
        String lower = pkg.toLowerCase();
        if (lower.contains("spotify")) return "Spotify";
        if (lower.contains("youtube") || lower.contains("music")) return "YT Music";
        if (lower.contains("apple")) return "Apple Music";
        if (lower.contains("amazon")) return "Amazon Music";
        if (lower.contains("wynk")) return "Wynk";
        if (lower.contains("jiosaavn")) return "JioSaavn";
        if (lower.contains("gaana")) return "Gaana";
        int dot = pkg.lastIndexOf('.');
        return dot >= 0 ? pkg.substring(dot + 1) : pkg;
    }

    public void togglePlayPause() {
        if (activeController == null) {
            updateActiveController();
        }
        if (activeController != null) {
            PlaybackState ps = activeController.getPlaybackState();
            int st = ps != null ? ps.getState() : PlaybackState.STATE_NONE;
            boolean isCurrentlyPlaying = (st == PlaybackState.STATE_PLAYING);

            MediaController.TransportControls tc = activeController.getTransportControls();
            try {
                if (isCurrentlyPlaying) {
                    tc.pause();
                    currentPlaybackState = 1;
                } else {
                    tc.play();
                    currentPlaybackState = 2;
                }
                dispatchMediaUpdate();
            } catch (Exception e) {
                Log.w(TAG, "TransportControls failed: " + e.getMessage() + ", trying dispatchMediaButtonEvent");
                int key = isCurrentlyPlaying ? KeyEvent.KEYCODE_MEDIA_PAUSE : KeyEvent.KEYCODE_MEDIA_PLAY;
                try {
                    activeController.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_DOWN, key));
                    activeController.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_UP, key));
                } catch (Exception ex) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
        }
        handler.postDelayed(this::syncMetadata, 300);
    }

    public void skipNext() {
        if (activeController == null) {
            updateActiveController();
        }
        if (activeController != null) {
            try {
                activeController.getTransportControls().skipToNext();
            } catch (Exception e) {
                Log.w(TAG, "skipToNext TransportControls failed: " + e.getMessage());
                try {
                    activeController.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
                    activeController.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_NEXT));
                } catch (Exception ex) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT);
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT);
        }
        handler.postDelayed(this::syncMetadata, 400);
    }

    public void skipPrevious() {
        if (activeController == null) {
            updateActiveController();
        }
        if (activeController != null) {
            try {
                activeController.getTransportControls().skipToPrevious();
            } catch (Exception e) {
                Log.w(TAG, "skipToPrevious TransportControls failed: " + e.getMessage());
                try {
                    activeController.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS));
                    activeController.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PREVIOUS));
                } catch (Exception ex) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
        }
        handler.postDelayed(this::syncMetadata, 400);
    }

    public void handleHandlebarMedia(PulsarProtocol.HandlebarEvent ev) {
        if (ev == null) return;
        Log.i(TAG, "handleHandlebarMedia: play=" + ev.musicPlay + " pause=" + ev.musicPause
                + " next=" + ev.musicNext + " prev=" + ev.musicPrev + " stop=" + ev.musicStop);

        if (activeController == null) {
            updateActiveController();
        }

        if (ev.musicNext) {
            skipNext();
        } else if (ev.musicPrev) {
            skipPrevious();
        } else if (ev.musicPlay) {
            if (activeController != null) {
                try {
                    activeController.getTransportControls().play();
                } catch (Exception e) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY);
                }
            } else {
                sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY);
            }
            handler.postDelayed(this::syncMetadata, 400);
        } else if (ev.musicPause) {
            if (activeController != null) {
                try {
                    activeController.getTransportControls().pause();
                } catch (Exception e) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PAUSE);
                }
            } else {
                sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PAUSE);
            }
            handler.postDelayed(this::syncMetadata, 400);
        } else if (ev.musicStop) {
            if (activeController != null) {
                try {
                    activeController.getTransportControls().stop();
                } catch (Exception e) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_STOP);
                }
            } else {
                sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_STOP);
            }
            handler.postDelayed(this::syncMetadata, 400);
        }
    }

    private void sendGlobalMediaKey(int keyCode) {
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (am != null) {
            long now = SystemClock.uptimeMillis();
            am.dispatchMediaKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, keyCode, 0));
            am.dispatchMediaKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_UP, keyCode, 0));
        }
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public String getCurrentArtist() {
        return currentArtist;
    }

    public String getCurrentAlbum() {
        return currentAlbum;
    }

    public Bitmap getCurrentAlbumArt() {
        return currentAlbumArt;
    }

    public String getCurrentSource() {
        return formatSourceLabel(activeController != null ? activeController.getPackageName() : "");
    }

    public boolean isPlaying() {
        if (activeController != null) {
            PlaybackState ps = activeController.getPlaybackState();
            if (ps != null) {
                return ps.getState() == PlaybackState.STATE_PLAYING;
            }
        }
        return currentPlaybackState == 2;
    }
}
