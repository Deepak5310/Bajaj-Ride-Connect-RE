package com.bajaj.rideconnect.re

import android.content.ComponentName
import android.content.Context
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
import android.util.Log
import android.view.KeyEvent
import com.bajaj.rideconnect.re.ui.cockpit.MediaTrackInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MediaStateListener(context: Context) {

    private val context: Context = context.applicationContext
    private var mediaSessionManager: MediaSessionManager? = null
    private var activeController: MediaController? = null
    private var sessionsChangedListener: MediaSessionManager.OnActiveSessionsChangedListener? = null
    private val handler = Handler(Looper.getMainLooper())

    private var totalDurationSec: Int = 0
    private var lastPositionUpdateTime: Long = 0L
    private var playbackSpeed: Float = 1.0f

    private val _mediaTrackInfo = MutableStateFlow(
        MediaTrackInfo(
            hasPermission = PulsarNotificationService.isNotificationListenerGranted(context)
        )
    )
    val mediaTrackInfo: StateFlow<MediaTrackInfo> = _mediaTrackInfo.asStateFlow()

    private val sessionUpdateListener = PulsarNotificationService.SessionUpdateListener {
        refreshMediaSessions()
    }

    private val controllerCallback = object : MediaController.Callback() {
        override fun onMetadataChanged(metadata: MediaMetadata?) {
            syncMetadata()
        }

        override fun onPlaybackStateChanged(state: PlaybackState?) {
            syncMetadata()
        }

        override fun onSessionDestroyed() {
            updateActiveController()
        }
    }

    private val progressTicker = object : Runnable {
        override fun run() {
            val controller = activeController
            val isPlaying = _mediaTrackInfo.value.isPlaying
            if (controller != null && isPlaying) {
                updateProgressOnly(controller)
                handler.postDelayed(this, 1000L)
            }
        }
    }

    init {
        PulsarNotificationService.setSessionUpdateListener(sessionUpdateListener)
        initMediaSessions()
    }

    fun initMediaSessions() {
        val hasPerm = PulsarNotificationService.isNotificationListenerGranted(context)
        if (!hasPerm) {
            _mediaTrackInfo.value = _mediaTrackInfo.value.copy(hasPermission = false)
            Log.w(TAG, "Notification listener permission not granted.")
            return
        }

        _mediaTrackInfo.value = _mediaTrackInfo.value.copy(hasPermission = true)

        try {
            val msm =
                context.getSystemService(Context.MEDIA_SESSION_SERVICE) as? MediaSessionManager
            mediaSessionManager = msm
            if (msm == null) return

            val compName = ComponentName(context, PulsarNotificationService::class.java)

            sessionsChangedListener?.let { listener ->
                try {
                    msm.removeOnActiveSessionsChangedListener(listener)
                } catch (_: Exception) {
                }
            }

            val newListener = MediaSessionManager.OnActiveSessionsChangedListener {
                updateActiveController()
            }
            sessionsChangedListener = newListener
            msm.addOnActiveSessionsChangedListener(newListener, compName, handler)

            updateActiveController()
        } catch (e: SecurityException) {
            Log.w(TAG, "SecurityException initializing MediaSessionManager: ${e.message}")
            _mediaTrackInfo.value = _mediaTrackInfo.value.copy(hasPermission = false)
        } catch (e: Exception) {
            Log.e(TAG, "Error initializing MediaSessionManager: ${e.message}")
        }
    }

    fun refreshMediaSessions() {
        handler.post {
            val hasPerm = PulsarNotificationService.isNotificationListenerGranted(context)
            if (!hasPerm) {
                _mediaTrackInfo.value = _mediaTrackInfo.value.copy(hasPermission = false)
            } else {
                if (mediaSessionManager == null || sessionsChangedListener == null) {
                    initMediaSessions()
                } else {
                    updateActiveController()
                }
            }
        }
    }

    @Synchronized
    fun updateActiveController() {
        try {
            val hasPerm = PulsarNotificationService.isNotificationListenerGranted(context)
            if (!hasPerm) {
                _mediaTrackInfo.value = _mediaTrackInfo.value.copy(hasPermission = false)
                return
            }

            val msm = mediaSessionManager ?: run {
                initMediaSessions()
                mediaSessionManager ?: return
            }

            val compName = ComponentName(context, PulsarNotificationService::class.java)
            val controllers = msm.getActiveSessions(compName)

            if (controllers.isEmpty()) {
                if (activeController != null) {
                    try {
                        activeController?.unregisterCallback(controllerCallback)
                    } catch (_: Exception) {
                    }
                    activeController = null
                    totalDurationSec = 0
                    handler.removeCallbacks(progressTicker)
                    _mediaTrackInfo.value = MediaTrackInfo(hasPermission = true)
                }
                return
            }

            var playing: MediaController? = null
            var existing: MediaController? = null
            for (c in controllers) {
                val state = c.playbackState?.state ?: PlaybackState.STATE_NONE
                if (playing == null && state == PlaybackState.STATE_PLAYING) {
                    playing = c
                }
                if (existing == null && isSameSession(activeController, c)) {
                    existing = c
                }
            }

            val chosen = playing ?: (existing ?: controllers[0])

            if (!isSameSession(activeController, chosen)) {
                try {
                    activeController?.unregisterCallback(controllerCallback)
                } catch (_: Exception) {
                }
                activeController = chosen
                chosen.registerCallback(controllerCallback, handler)
                syncMetadata()
            }
        } catch (e: SecurityException) {
            Log.w(TAG, "SecurityException in updateActiveController: ${e.message}")
            _mediaTrackInfo.value = _mediaTrackInfo.value.copy(hasPermission = false)
        } catch (e: Exception) {
            Log.e(TAG, "Error in updateActiveController: ${e.message}")
        }
    }

    fun syncMetadata() {
        val controller = activeController ?: return
        val metadata = controller.metadata
        val pbState = controller.playbackState

        var title = ""
        var artist = ""
        var artwork: Bitmap? = null
        var durMs = 0L

        if (metadata != null) {
            title = metadata.getString(MediaMetadata.METADATA_KEY_TITLE) ?: metadata.getString(
                MediaMetadata.METADATA_KEY_DISPLAY_TITLE
            ) ?: ""

            artist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST) ?: metadata.getString(
                MediaMetadata.METADATA_KEY_ALBUM_ARTIST
            ) ?: metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE) ?: ""

            durMs = try {
                metadata.getLong(MediaMetadata.METADATA_KEY_DURATION)
            } catch (_: Exception) {
                0L
            }

            artwork = try {
                metadata.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART) ?: metadata.getBitmap(
                    MediaMetadata.METADATA_KEY_ART
                ) ?: metadata.getBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON)
            } catch (e: Exception) {
                Log.w(TAG, "Failed to load album artwork: ${e.message}")
                null
            }
        }

        totalDurationSec = if (durMs > 0L) (durMs / 1000L).toInt() else 0

        var isPlaying = false
        var currentMs = 0L

        if (pbState != null) {
            currentMs = pbState.position
            lastPositionUpdateTime = pbState.lastPositionUpdateTime
            playbackSpeed = if (pbState.playbackSpeed <= 0f) 1.0f else pbState.playbackSpeed

            if (pbState.state == PlaybackState.STATE_PLAYING) {
                val delta = SystemClock.elapsedRealtime() - lastPositionUpdateTime
                if (delta > 0) {
                    currentMs += (delta * playbackSpeed).toLong()
                }
                isPlaying = true
            }
        }

        val currentPosSec = (currentMs / 1000L).toInt().coerceAtLeast(0)
        val clampedPosSec =
            if (totalDurationSec > 0) currentPosSec.coerceAtMost(totalDurationSec) else currentPosSec
        val progress =
            if (totalDurationSec > 0) (clampedPosSec.toFloat() / totalDurationSec.toFloat()).coerceIn(
                0f, 1f
            ) else 0f
        val sourceLabel = formatSourceLabel(controller.packageName)

        _mediaTrackInfo.value = MediaTrackInfo(
            title = title,
            artist = artist,
            isPlaying = isPlaying,
            progress = progress,
            currentPosition = formatSeconds(clampedPosSec),
            totalDuration = if (totalDurationSec > 0) formatSeconds(totalDurationSec) else "--:--",
            source = sourceLabel,
            albumArt = artwork,
            hasPermission = true
        )

        handler.removeCallbacks(progressTicker)
        if (isPlaying) {
            handler.postDelayed(progressTicker, 1000L)
        }
    }

    private fun updateProgressOnly(controller: MediaController) {
        val pbState = controller.playbackState ?: return
        if (pbState.state != PlaybackState.STATE_PLAYING) return

        val delta = SystemClock.elapsedRealtime() - pbState.lastPositionUpdateTime
        var currentMs = pbState.position
        if (delta > 0) {
            val speed = if (pbState.playbackSpeed <= 0f) 1.0f else pbState.playbackSpeed
            currentMs += (delta * speed).toLong()
        }

        val currentPosSec = (currentMs / 1000L).toInt().coerceAtLeast(0)
        val clampedPosSec =
            if (totalDurationSec > 0) currentPosSec.coerceAtMost(totalDurationSec) else currentPosSec
        val progress =
            if (totalDurationSec > 0) (clampedPosSec.toFloat() / totalDurationSec.toFloat()).coerceIn(
                0f, 1f
            ) else 0f

        _mediaTrackInfo.value = _mediaTrackInfo.value.copy(
            progress = progress, currentPosition = formatSeconds(clampedPosSec)
        )
    }

    fun togglePlayPause() {
        val controller = activeController ?: run {
            updateActiveController()
            activeController
        }

        if (controller != null) {
            val ps = controller.playbackState
            val isCurrentlyPlaying = ps?.state == PlaybackState.STATE_PLAYING
            val tc = controller.transportControls
            try {
                if (isCurrentlyPlaying) {
                    tc.pause()
                } else {
                    tc.play()
                }
            } catch (e: Exception) {
                Log.w(
                    TAG,
                    "TransportControls play/pause failed: ${e.message}, falling back to media key"
                )
                val key =
                    if (isCurrentlyPlaying) KeyEvent.KEYCODE_MEDIA_PAUSE else KeyEvent.KEYCODE_MEDIA_PLAY
                try {
                    controller.dispatchMediaButtonEvent(KeyEvent(KeyEvent.ACTION_DOWN, key))
                    controller.dispatchMediaButtonEvent(KeyEvent(KeyEvent.ACTION_UP, key))
                } catch (_: Exception) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
        }
        handler.postDelayed({ syncMetadata() }, 300L)
    }

    fun skipNext() {
        val controller = activeController ?: run {
            updateActiveController()
            activeController
        }

        if (controller != null) {
            try {
                controller.transportControls.skipToNext()
            } catch (e: Exception) {
                Log.w(TAG, "TransportControls skipToNext failed: ${e.message}")
                try {
                    controller.dispatchMediaButtonEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT
                        )
                    )
                    controller.dispatchMediaButtonEvent(
                        KeyEvent(
                            KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_NEXT
                        )
                    )
                } catch (_: Exception) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT)
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT)
        }
        handler.postDelayed({ syncMetadata() }, 400L)
    }

    fun skipPrevious() {
        val controller = activeController ?: run {
            updateActiveController()
            activeController
        }

        if (controller != null) {
            try {
                controller.transportControls.skipToPrevious()
            } catch (e: Exception) {
                Log.w(TAG, "TransportControls skipToPrevious failed: ${e.message}")
                try {
                    controller.dispatchMediaButtonEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS
                        )
                    )
                    controller.dispatchMediaButtonEvent(
                        KeyEvent(
                            KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PREVIOUS
                        )
                    )
                } catch (_: Exception) {
                    sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS)
                }
            }
        } else {
            sendGlobalMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS)
        }
        handler.postDelayed({ syncMetadata() }, 400L)
    }

    fun seekTo(positionMs: Long) {
        val controller = activeController ?: run {
            updateActiveController()
            activeController
        }

        if (controller != null) {
            try {
                controller.transportControls.seekTo(positionMs)
                val currentPosSec = (positionMs / 1000L).toInt().coerceAtLeast(0)
                val clampedPosSec =
                    if (totalDurationSec > 0) currentPosSec.coerceAtMost(totalDurationSec) else currentPosSec
                val progress =
                    if (totalDurationSec > 0) (clampedPosSec.toFloat() / totalDurationSec.toFloat()).coerceIn(
                        0f, 1f
                    ) else 0f
                _mediaTrackInfo.value = _mediaTrackInfo.value.copy(
                    progress = progress, currentPosition = formatSeconds(clampedPosSec)
                )
            } catch (e: Exception) {
                Log.w(TAG, "TransportControls seekTo failed: ${e.message}")
            }
        }
        handler.postDelayed({ syncMetadata() }, 300L)
    }

    fun seekToRatio(fraction: Float) {
        if (totalDurationSec > 0) {
            val targetMs = (fraction.coerceIn(0f, 1f) * (totalDurationSec * 1000L)).toLong()
            seekTo(targetMs)
        }
    }

    private fun sendGlobalMediaKey(keyCode: Int) {
        val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager ?: return
        val now = SystemClock.uptimeMillis()
        am.dispatchMediaKeyEvent(KeyEvent(now, now, KeyEvent.ACTION_DOWN, keyCode, 0))
        am.dispatchMediaKeyEvent(KeyEvent(now, now, KeyEvent.ACTION_UP, keyCode, 0))
    }

    fun destroy() {
        PulsarNotificationService.setSessionUpdateListener(null)
        handler.removeCallbacksAndMessages(null)
        try {
            activeController?.unregisterCallback(controllerCallback)
        } catch (_: Exception) {
        }
        activeController = null

        sessionsChangedListener?.let { listener ->
            try {
                mediaSessionManager?.removeOnActiveSessionsChangedListener(listener)
            } catch (_: Exception) {
            }
        }
        sessionsChangedListener = null
    }

    companion object {
        private const val TAG = "MediaStateListener"

        private const val PKG_YT_MUSIC_MORPHE = "app.morphe.android.apps.youtube.music"
        private const val PKG_YT_MUSIC_OFFICIAL = "com.google.android.apps.youtube.music"
        private const val PKG_METROLIST = "com.metrolist.music"

        private fun isSameSession(a: MediaController?, b: MediaController?): Boolean {
            if (a == null || b == null) return false
            if (a === b) return true
            val ta: MediaSession.Token = a.sessionToken
            val tb: MediaSession.Token = b.sessionToken
            return ta == tb
        }

        private fun formatSeconds(seconds: Int): String {
            val m = seconds / 60
            val s = seconds % 60
            return "$m:${if (s < 10) "0$s" else "$s"}"
        }

        private fun formatSourceLabel(packageName: String?): String {
            if (packageName.isNullOrEmpty()) return ""
            return when (packageName) {
                PKG_YT_MUSIC_MORPHE, PKG_YT_MUSIC_OFFICIAL -> "YT MUSIC"
                PKG_METROLIST -> "METROLIST"
                else -> {
                    val lower = packageName.lowercase()
                    if (lower.contains("youtube.music")) {
                        "YT MUSIC"
                    } else if (lower.contains("metrolist")) {
                        "METROLIST"
                    } else {
                        "MUSIC"
                    }
                }
            }
        }
    }
}