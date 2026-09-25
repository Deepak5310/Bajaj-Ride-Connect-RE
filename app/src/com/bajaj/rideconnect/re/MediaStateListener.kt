package com.bajaj.rideconnect.re

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.database.ContentObserver
import android.graphics.Bitmap
import android.media.AudioManager
import android.media.MediaMetadata
import android.media.session.MediaController
import android.media.session.MediaSession
import android.media.session.MediaSessionManager
import android.media.session.PlaybackState
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.provider.Settings
import android.util.Log
import android.view.KeyEvent
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class MediaStateListener(
    context: Context,
    private val bleManager: PulsarBleManager?
) {

    fun interface MediaObserver {
        fun onMediaUpdated(
            title: String,
            artist: String,
            album: String,
            source: String,
            playbackState: Int,
            posSec: Int,
            durSec: Int,
            artwork: Bitmap?
        )
    }

    private val context: Context = context.applicationContext
    private var mediaSessionManager: MediaSessionManager? = null
    private var activeController: MediaController? = null
    private var sessionsChangedListener: MediaSessionManager.OnActiveSessionsChangedListener? = null
    private val handler = Handler(Looper.getMainLooper())

    private val observers = CopyOnWriteArrayList<MediaObserver>()

    var currentTitle: String = ""
        private set
    var currentArtist: String = ""
        private set
    var currentAlbum: String = ""
        private set
    var currentAlbumArt: Bitmap? = null
        private set
    var currentPlaybackState: Int = 0
        private set
    var currentPosSec: Int = 0
        private set
    var currentDurSec: Int = 0
        private set

    private var lastPositionUpdateTime: Long = 0
    private var playbackSpeed: Float = 1.0f

    val currentSource: String
        get() = formatSourceLabel(activeController?.packageName)

    val isPlaying: Boolean
        get() {
            val ps = activeController?.playbackState
            if (ps != null) {
                return ps.state == PlaybackState.STATE_PLAYING
            }
            return currentPlaybackState == 2
        }

    private var volumeObserver: ContentObserver? = null

    init {
        instance = this
        initMediaSessions()
        registerVolumeObserver()
    }

    private fun registerVolumeObserver() {
        if (volumeObserver == null) {
            volumeObserver = object : ContentObserver(handler) {
                override fun onChange(selfChange: Boolean) {
                    super.onChange(selfChange)
                    PhoneStateMonitor.instance?.triggerImmediateUpdate()
                }
            }
            try {
                context.contentResolver.registerContentObserver(
                    Settings.System.CONTENT_URI,
                    true,
                    volumeObserver as ContentObserver
                )
                Log.i(TAG, "Registered System Settings Volume ContentObserver")
            } catch (e: Exception) {
                Log.w(TAG, "Could not register volume ContentObserver: ${e.message}")
            }
        }
    }

    fun registerObserver(observer: MediaObserver?) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer)
            observer.onMediaUpdated(
                currentTitle, currentArtist, currentAlbum, currentSource,
                currentPlaybackState, currentPosSec, currentDurSec, currentAlbumArt
            )
        }
    }

    fun unregisterObserver(observer: MediaObserver?) {
        observers.remove(observer)
    }

    fun initMediaSessions() {
        try {
            mediaSessionManager = context.getSystemService(Context.MEDIA_SESSION_SERVICE) as? MediaSessionManager
            if (mediaSessionManager == null) {
                Log.w(TAG, "MediaSessionManager unavailable")
                return
            }
            val compName = ComponentName(context, PulsarNotificationService::class.java)

            sessionsChangedListener?.let {
                try {
                    mediaSessionManager?.removeOnActiveSessionsChangedListener(it)
                } catch (ignored: Exception) {}
            }
            val newListener = MediaSessionManager.OnActiveSessionsChangedListener { updateActiveController() }
            sessionsChangedListener = newListener
            mediaSessionManager?.addOnActiveSessionsChangedListener(newListener, compName, handler)

            updateActiveController()
        } catch (e: SecurityException) {
            Log.w(TAG, "Notification listener permission needed for MediaSessionManager: ${e.message}")
        }
    }

    fun refreshMediaSessions() {
        handler.post { updateActiveController() }
    }

    @Synchronized
    fun updateActiveController() {
        try {
            val msm = mediaSessionManager ?: return
            val compName = ComponentName(context, PulsarNotificationService::class.java)
            val controllers = msm.getActiveSessions(compName)

            if (controllers.isNullOrEmpty()) {
                Log.i(TAG, "No active media sessions found.")
                if (activeController != null) {
                    activeController?.unregisterCallback(controllerCallback)
                    activeController = null
                    currentTitle = ""
                    currentArtist = ""
                    currentAlbum = ""
                    currentAlbumArt = null
                    currentPlaybackState = 0
                    currentPosSec = 0
                    currentDurSec = 0
                    handler.removeCallbacks(progressTicker)
                    dispatchMediaUpdate()
                    bleManager?.sendMedia("", "", "", 0, 0, 0)
                }
                return
            }

            var playing: MediaController? = null
            var existing: MediaController? = null
            for (c in controllers) {
                val ps = c.playbackState
                val st = ps?.state ?: PlaybackState.STATE_NONE
                if (playing == null && st == PlaybackState.STATE_PLAYING) {
                    playing = c
                }
                if (existing == null && isSameSession(activeController, c)) {
                    existing = c
                }
            }

            val chosen = playing ?: (existing ?: controllers[0])

            if (!isSameSession(activeController, chosen)) {
                activeController?.unregisterCallback(controllerCallback)
                activeController = chosen
                chosen.registerCallback(controllerCallback, handler)
                Log.i(TAG, "Active media controller -> ${chosen.packageName}")
                syncMetadata()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error updating media controller: ${e.message}")
        }
    }

    private val controllerCallback = object : MediaController.Callback() {
        override fun onMetadataChanged(metadata: MediaMetadata?) {
            syncMetadata()
        }

        override fun onPlaybackStateChanged(state: PlaybackState?) {
            syncMetadata()
        }
    }

    private val progressTicker: Runnable = object : Runnable {
        override fun run() {
            val controller = activeController
            if (controller != null && isPlaying) {
                val ps = controller.playbackState
                if (ps != null && ps.state == PlaybackState.STATE_PLAYING) {
                    var currentMs = ps.position
                    val delta = SystemClock.elapsedRealtime() - ps.lastPositionUpdateTime
                    if (delta > 0) {
                        currentMs += (delta * ps.playbackSpeed).toLong()
                    }
                    currentPosSec = (currentMs / 1000).toInt()
                    if (currentDurSec > 0 && currentPosSec > currentDurSec) {
                        currentPosSec = currentDurSec
                    }
                    dispatchMediaUpdate()

                    if (bleManager != null && bleManager.isConnected) {
                        bleManager.sendMedia(currentTitle, currentArtist, currentAlbum, currentPosSec, currentDurSec, 2)
                    }

                    handler.postDelayed(this, 1000)
                }
            }
        }
    }

    fun syncMetadata() {
        if (activeController == null) {
            updateActiveController()
            if (activeController == null) {
                return
            }
        }
        val controller = activeController ?: return
        val metadata = controller.metadata
        val pbState = controller.playbackState

        if (metadata != null) {
            currentTitle = metadata.getString(MediaMetadata.METADATA_KEY_TITLE)
                ?: metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE)
                ?: ""

            currentArtist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST)
                ?: metadata.getString(MediaMetadata.METADATA_KEY_ALBUM_ARTIST)
                ?: metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE)
                ?: ""

            currentAlbum = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM)
                ?: metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_DESCRIPTION)
                ?: ""

            var durMs = 0L
            try {
                durMs = metadata.getLong(MediaMetadata.METADATA_KEY_DURATION)
            } catch (ignored: Exception) {}
            currentDurSec = (durMs / 1000).toInt()

            val art = metadata.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART)
                ?: metadata.getBitmap(MediaMetadata.METADATA_KEY_ART)
                ?: metadata.getBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON)
            currentAlbumArt = art
        }

        var state = 0
        if (pbState != null) {
            var currentMs = pbState.position
            lastPositionUpdateTime = pbState.lastPositionUpdateTime
            playbackSpeed = if (pbState.playbackSpeed <= 0) 1.0f else pbState.playbackSpeed

            if (pbState.state == PlaybackState.STATE_PLAYING) {
                val delta = SystemClock.elapsedRealtime() - lastPositionUpdateTime
                if (delta > 0) {
                    currentMs += (delta * playbackSpeed).toLong()
                }
                state = 2
            } else if (pbState.state == PlaybackState.STATE_PAUSED) {
                state = 1
            } else {
                state = if (currentTitle.isEmpty()) 0 else 1
            }
            currentPosSec = (currentMs / 1000).toInt()
            if (currentDurSec > 0 && currentPosSec > currentDurSec) {
                currentPosSec = currentDurSec
            }
        }
        currentPlaybackState = state

        if (state == 2) {
            handler.removeCallbacks(progressTicker)
            handler.postDelayed(progressTicker, 1000)
        } else {
            handler.removeCallbacks(progressTicker)
        }

        dispatchMediaUpdate()

        if (bleManager != null) {
            val sent = bleManager.sendMedia(currentTitle, currentArtist, currentAlbum, currentPosSec, currentDurSec, state)
            if (!sent) {
                handler.postDelayed({ syncMetadata() }, 1000)
            }
        }
    }

    private fun dispatchMediaUpdate() {
        val sourceName = currentSource

        for (obs in observers) {
            try {
                obs.onMediaUpdated(
                    currentTitle, currentArtist, currentAlbum, sourceName,
                    currentPlaybackState, currentPosSec, currentDurSec, currentAlbumArt
                )
            } catch (e: Exception) {
                Log.w(TAG, "Error notifying observer: ${e.message}")
            }
        }

        val intent = Intent(ACTION_MEDIA_UPDATE).apply {
            `package` = context.packageName
            putExtra("title", currentTitle)
            putExtra("artist", currentArtist)
            putExtra("album", currentAlbum)
            putExtra("source", sourceName)
            putExtra("duration_sec", currentDurSec)
            putExtra("position_sec", currentPosSec)
            putExtra("playback_state", currentPlaybackState)
        }
        context.sendBroadcast(intent)
    }

    fun togglePlayPause() {
        if (activeController == null) {
            updateActiveController()
        }
        val controller = activeController
        if (controller != null) {
            val ps = controller.playbackState
            val st = ps?.state ?: PlaybackState.STATE_NONE
            val isCurrentlyPlaying = (st == PlaybackState.STATE_PLAYING)

            val tc = controller.transportControls
            try {
                if (isCurrentlyPlaying) {
                    tc.pause()
                    currentPlaybackState = 1
                } else {
                    tc.play()
                    currentPlaybackState = 2
                }
                dispatchMediaUpdate()
            } catch (e: Exception) {
                Log.w(TAG, "TransportControls failed: ${e.message}, trying dispatchMediaButtonEvent")
                val key = if (isCurrentlyPlaying) KeyEvent.KEYCODE_MEDIA_PAUSE else KeyEvent.KEYCODE_MEDIA_PLAY
                try {
                    controller.dispatchMediaButtonEvent(KeyEvent(KeyEvent.ACTION_DOWN, key))
                    controller.dispatchMediaButtonEvent(KeyEvent(KeyEvent.ACTION_UP, key))
                } catch (ex: Exception) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
        }
        handler.postDelayed({ syncMetadata() }, 300)
    }

    fun skipNext() {
        if (activeController == null) {
            updateActiveController()
        }
        val controller = activeController
        if (controller != null) {
            try {
                controller.transportControls.skipToNext()
            } catch (e: Exception) {
                Log.w(TAG, "skipToNext TransportControls failed: ${e.message}")
                try {
                    controller.dispatchMediaButtonEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT))
                    controller.dispatchMediaButtonEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_NEXT))
                } catch (ex: Exception) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT)
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT)
        }
        handler.postDelayed({ syncMetadata() }, 400)
    }

    fun skipPrevious() {
        if (activeController == null) {
            updateActiveController()
        }
        val controller = activeController
        if (controller != null) {
            try {
                controller.transportControls.skipToPrevious()
            } catch (e: Exception) {
                Log.w(TAG, "skipToPrevious TransportControls failed: ${e.message}")
                try {
                    controller.dispatchMediaButtonEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS))
                    controller.dispatchMediaButtonEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PREVIOUS))
                } catch (ex: Exception) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS)
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS)
        }
        handler.postDelayed({ syncMetadata() }, 400)
    }

    fun seekTo(positionMs: Long) {
        if (activeController == null) {
            updateActiveController()
        }
        val controller = activeController
        if (controller != null) {
            try {
                controller.transportControls.seekTo(positionMs)
                currentPosSec = (positionMs / 1000).toInt()
                dispatchMediaUpdate()
            } catch (e: Exception) {
                Log.w(TAG, "seekTo TransportControls failed: ${e.message}")
            }
        }
        handler.postDelayed({ syncMetadata() }, 300)
    }

    fun setVolumeFromCluster(volumeNibble: Int) {
        if (volumeNibble !in 0..10) return
        try {
            val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager ?: return
            val maxVol = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            if (maxVol > 0) {
                val d = volumeNibble.toDouble() * (maxVol.toDouble() / 10.0)
                var targetVol = d.toInt()
                if (d - targetVol >= 0.5) {
                    targetVol = (d + 0.5).toInt()
                }
                targetVol = max(0, min(targetVol, maxVol))
                am.setStreamVolume(AudioManager.STREAM_MUSIC, targetVol, AudioManager.FLAG_SHOW_UI)
                Log.i(TAG, "Cluster volume adjusted: $volumeNibble/10 -> $targetVol/$maxVol")
            }
        } catch (e: Exception) {
            Log.w(TAG, "Error setting volume from cluster: ${e.message}")
        }
    }

    fun getCurrentVolumeTenths(): Int {
        try {
            val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager ?: return 5
            val maxVol = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            val curVol = am.getStreamVolume(AudioManager.STREAM_MUSIC)
            if (maxVol > 0) {
                return max(0, min(10, ((curVol * 10.0) / maxVol).roundToInt()))
            }
        } catch (ignored: Exception) {}
        return 5
    }

    fun handleHandlebarMedia(ev: PulsarProtocol.HandlebarEvent?) {
        ev ?: return
        Log.i(
            TAG,
            "handleHandlebarMedia: play=${ev.musicPlay} pause=${ev.musicPause} " +
                "next=${ev.musicNext} prev=${ev.musicPrev} stop=${ev.musicStop} " +
                "vol=${ev.volumeLevel} volChanged=${ev.volumeChanged}"
        )

        if (ev.volumeChanged) {
            val curVol = getCurrentVolumeTenths()
            if (ev.volumeLevel == 0 && curVol > 1) {
                Log.i(TAG, "Ignoring cluster volume=0 idle pulse (current phone volume=$curVol/10)")
            } else {
                setVolumeFromCluster(ev.volumeLevel)
                PhoneStateMonitor.instance?.triggerImmediateUpdate()
            }
        }

        if (activeController == null) {
            updateActiveController()
        }

        when {
            ev.musicNext -> skipNext()
            ev.musicPrev -> skipPrevious()
            ev.musicPlay -> {
                val controller = activeController
                if (controller != null) {
                    try {
                        controller.transportControls.play()
                    } catch (e: Exception) {
                        sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY)
                    }
                } else {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY)
                }
                handler.postDelayed({ syncMetadata() }, 400)
            }
            ev.musicPause -> {
                val controller = activeController
                if (controller != null) {
                    try {
                        controller.transportControls.pause()
                    } catch (e: Exception) {
                        sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PAUSE)
                    }
                } else {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PAUSE)
                }
                handler.postDelayed({ syncMetadata() }, 400)
            }
            ev.musicStop -> {
                val controller = activeController
                if (controller != null) {
                    try {
                        controller.transportControls.stop()
                    } catch (e: Exception) {
                        sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_STOP)
                    }
                } else {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_STOP)
                }
                handler.postDelayed({ syncMetadata() }, 400)
            }
        }
    }

    private fun sendGlobalMediaKey(keyCode: Int) {
        val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager ?: return
        val now = SystemClock.uptimeMillis()
        am.dispatchMediaKeyEvent(KeyEvent(now, now, KeyEvent.ACTION_DOWN, keyCode, 0))
        am.dispatchMediaKeyEvent(KeyEvent(now, now, KeyEvent.ACTION_UP, keyCode, 0))
    }

    companion object {
        private const val TAG = "MediaStateListener"
        const val ACTION_MEDIA_UPDATE: String = "com.bajaj.rideconnect.re.MEDIA_UPDATE"

        @Volatile
        @JvmStatic
        var instance: MediaStateListener? = null
            private set



        @JvmStatic
        fun isNotificationListenerEnabled(context: Context?): Boolean {
            context ?: return false
            val pkgName = context.packageName
            val flat = Settings.Secure.getString(context.contentResolver, "enabled_notification_listeners")
            if (!flat.isNullOrEmpty()) {
                val names = flat.split(":")
                for (name in names) {
                    val cn = ComponentName.unflattenFromString(name)
                    if (cn != null && pkgName == cn.packageName) {
                        return true
                    }
                }
            }
            return false
        }

        private fun isSameSession(a: MediaController?, b: MediaController?): Boolean {
            if (a == null || b == null) return false
            if (a === b) return true
            val ta: MediaSession.Token? = a.sessionToken
            val tb: MediaSession.Token? = b.sessionToken
            return ta != null && ta == tb
        }

        private fun formatSourceLabel(pkg: String?): String {
            if (pkg.isNullOrEmpty()) return "Music Player"
            val lower = pkg.lowercase()
            if (lower.contains("spotify")) return "Spotify"
            if (lower.contains("youtube") || lower.contains("music")) return "YT Music"
            if (lower.contains("apple")) return "Apple Music"
            if (lower.contains("amazon")) return "Amazon Music"
            if (lower.contains("wynk")) return "Wynk"
            if (lower.contains("jiosaavn")) return "JioSaavn"
            if (lower.contains("gaana")) return "Gaana"
            val dot = pkg.lastIndexOf('.')
            return if (dot >= 0) pkg.substring(dot + 1) else pkg
        }
    }
}
