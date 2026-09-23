package com.pulsar.ns400z.tbtbridge;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;

import java.util.List;

/**
 * Android Media Controller and Session Listener for Spotify, YouTube Music, Apple Music.
 * Streams track info to NS400Z cluster and translates handlebar switches to playback actions.
 */
public class MediaStateListener {

    private static final String TAG = "MediaStateListener";

    private final Context context;
    private final PulsarBleManager bleManager;
    private MediaSessionManager mediaSessionManager;
    private MediaController activeController;
    private MediaSessionManager.OnActiveSessionsChangedListener sessionsChangedListener;
    private final Handler handler = new Handler(Looper.getMainLooper());

    private String currentTitle = "";
    private String currentArtist = "";
    private String currentAlbum = "";
    private int currentPlaybackState = 0; // 0=Stop/None, 1=Pause, 2=Play (matches Bajaj PlayStatus enum)

    public MediaStateListener(Context context, PulsarBleManager bleManager) {
        this.context = context.getApplicationContext();
        this.bleManager = bleManager;
        initMediaSessions();
    }

    public void initMediaSessions() {
        try {
            mediaSessionManager = (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
            if (mediaSessionManager == null) {
                Log.w(TAG, "MediaSessionManager unavailable");
                return;
            }
            ComponentName compName = new ComponentName(context, GoogleMapsNotificationListener.class);

            // Called from the constructor and again from refreshMediaSessions();
            // drop the previous callback so we never stack duplicates.
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

    private synchronized void updateActiveController() {
        try {
            if (mediaSessionManager == null) return;
            ComponentName compName = new ComponentName(context, GoogleMapsNotificationListener.class);
            List<MediaController> controllers = mediaSessionManager.getActiveSessions(compName);

            if (controllers == null || controllers.isEmpty()) {
                Log.i(TAG, "No active media sessions.");
                if (activeController != null) {
                    activeController.unregisterCallback(controllerCallback);
                    activeController = null;
                    currentTitle = "";
                    currentArtist = "";
                    currentAlbum = "";
                    currentPlaybackState = 0;
                    boolean sent = bleManager.sendMedia("", "", "", 0, 0, 0);
                    Log.i(TAG, "Media session gone -> idle frame " + (sent ? "queued" : "dropped (cluster not connected)"));
                }
                return;
            }

            // Prefer the session that is actually playing. If none is, keep the
            // controller we already have if it is still present, otherwise fall
            // back to the system's top-priority session.
            MediaController playing = null;
            MediaController existing = null;
            for (MediaController c : controllers) {
                PlaybackState ps = c.getPlaybackState();
                int st = ps != null ? ps.getState() : PlaybackState.STATE_NONE;
                Log.i(TAG, "Session: " + c.getPackageName() + " state=" + st
                        + (isSameSession(activeController, c) ? " (current)" : ""));
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
     * Push the current now-playing state to the cluster. Safe to call at any time;
     * PulsarForegroundService invokes this on every BLE connect so state that was
     * dropped while disconnected gets re-sent.
     */
    public void syncMetadata() {
        if (activeController == null) {
            Log.d(TAG, "syncMetadata: no active controller");
            return;
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
        }

        int state = 0; // 0=None/Stopped, 1=Paused, 2=Playing (matches Bajaj PlayStatus enum)
        int posSec = 0;
        int durSec = 0;

        if (pbState != null) {
            posSec = (int) (pbState.getPosition() / 1000);
            int pb = pbState.getState();
            if (pb == PlaybackState.STATE_PLAYING) {
                state = 2; // PlayStatus.PLAY = 2
            } else if (pb == PlaybackState.STATE_PAUSED) {
                state = 1; // PlayStatus.PAUSED = 1
            } else {
                state = 0; // PlayStatus.NONE = 0
            }
        }
        currentPlaybackState = state;

        if (metadata != null) {
            durSec = (int) (metadata.getLong(MediaMetadata.METADATA_KEY_DURATION) / 1000);
        }

        boolean sent = bleManager.sendMedia(currentTitle, currentArtist, currentAlbum, posSec, durSec, state);
        Log.i(TAG, "sendMedia[" + activeController.getPackageName() + "] state=" + state
                + " '" + currentTitle + "' - '" + currentArtist + "' "
                + posSec + "/" + durSec + "s -> " + (sent ? "queued" : "dropped (cluster not connected)"));
    }

    public void handleHandlebarMedia(PulsarProtocol.HandlebarEvent ev) {
        if (ev == null) return;

        if (activeController != null && activeController.getTransportControls() != null) {
            try {
                if (ev.musicNext) {
                    Log.i(TAG, "Handlebar: Skip to NEXT track");
                    activeController.getTransportControls().skipToNext();
                } else if (ev.musicPrev) {
                    Log.i(TAG, "Handlebar: Skip to PREVIOUS track");
                    activeController.getTransportControls().skipToPrevious();
                } else if (ev.musicPlay) {
                    Log.i(TAG, "Handlebar: Music PLAY");
                    activeController.getTransportControls().play();
                } else if (ev.musicPause) {
                    Log.i(TAG, "Handlebar: Music PAUSE");
                    activeController.getTransportControls().pause();
                } else if (ev.musicStop) {
                    Log.i(TAG, "Handlebar: Music STOP");
                    activeController.getTransportControls().stop();
                }
                return;
            } catch (Exception e) {
                Log.e(TAG, "Transport controls error: " + e.getMessage());
            }
        }

        // Fallback: Send Audio Key Events via AudioManager
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (am != null) {
            if (ev.musicNext) {
                sendMediaKeyEvent(am, KeyEvent.KEYCODE_MEDIA_NEXT);
            } else if (ev.musicPrev) {
                sendMediaKeyEvent(am, KeyEvent.KEYCODE_MEDIA_PREVIOUS);
            } else if (ev.musicPlay || ev.musicPause) {
                sendMediaKeyEvent(am, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
            }
        }
    }

    private void sendMediaKeyEvent(AudioManager am, int keyCode) {
        am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
        am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, keyCode));
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public String getCurrentArtist() {
        return currentArtist;
    }

    public boolean isPlaying() {
        return currentPlaybackState == 2;
    }
}
