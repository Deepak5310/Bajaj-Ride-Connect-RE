package com.pulsar.ns400z.tbtbridge;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.session.MediaController;
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
    private final Handler handler = new Handler(Looper.getMainLooper());

    private String currentTitle = "";
    private String currentArtist = "";
    private String currentAlbum = "";
    private int currentPlaybackState = 0; // 0=Stop, 1=Play, 2=Pause

    public MediaStateListener(Context context, PulsarBleManager bleManager) {
        this.context = context.getApplicationContext();
        this.bleManager = bleManager;
        initMediaSessions();
    }

    public void initMediaSessions() {
        try {
            mediaSessionManager = (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
            ComponentName compName = new ComponentName(context, GoogleMapsNotificationListener.class);
            if (mediaSessionManager != null) {
                updateActiveController();
                mediaSessionManager.addOnActiveSessionsChangedListener(controllers -> {
                    updateActiveController();
                }, compName, handler);
            }
        } catch (SecurityException e) {
            Log.w(TAG, "Notification listener permission needed for MediaSessionManager: " + e.getMessage());
        }
    }

    private synchronized void updateActiveController() {
        try {
            if (mediaSessionManager == null) return;
            ComponentName compName = new ComponentName(context, GoogleMapsNotificationListener.class);
            List<MediaController> controllers = mediaSessionManager.getActiveSessions(compName);
            if (controllers != null && !controllers.isEmpty()) {
                MediaController newController = controllers.get(0);
                if (activeController != newController) {
                    if (activeController != null) {
                        activeController.unregisterCallback(controllerCallback);
                    }
                    activeController = newController;
                    activeController.registerCallback(controllerCallback, handler);
                    syncMetadata();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error updating media controller: " + e.getMessage());
        }
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

    public void syncMetadata() {
        if (activeController == null) return;
        MediaMetadata metadata = activeController.getMetadata();
        PlaybackState pbState = activeController.getPlaybackState();

        if (metadata != null) {
            currentTitle = metadata.getString(MediaMetadata.METADATA_KEY_TITLE);
            if (currentTitle == null) currentTitle = "";
            currentArtist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
            if (currentArtist == null) currentArtist = "";
            currentAlbum = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
            if (currentAlbum == null) currentAlbum = "";
        }

        int state = 0;
        int posSec = 0;
        int durSec = 0;

        if (pbState != null) {
            posSec = (int) (pbState.getPosition() / 1000);
            int pb = pbState.getState();
            if (pb == PlaybackState.STATE_PLAYING) {
                state = 1;
            } else if (pb == PlaybackState.STATE_PAUSED) {
                state = 2;
            } else {
                state = 0;
            }
        }
        currentPlaybackState = state;

        if (metadata != null) {
            durSec = (int) (metadata.getLong(MediaMetadata.METADATA_KEY_DURATION) / 1000);
        }

        bleManager.sendMedia(currentTitle, currentArtist, currentAlbum, posSec, durSec, state);
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
        return currentPlaybackState == 1;
    }
}
