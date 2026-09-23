package com.bajajconnect.music;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telecom.TelecomManager;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bajajconnect.MyNotificationService;
import com.bajajconnect.enums.music.PlayStatus;
import com.bajajconnect.interfaces.MusicCallback;
import com.bajajconnect.models.Item_song;
import com.bajajconnect.util.LogUtils;
import com.bajajconnect.variables.GlobalVar;
import com.facebook.common.util.UriUtil;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.maps.android.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaSessionListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Boolean isPaused = false;
    private static MediaSessionManager mMediaSessionManager;
    private static Timer timer;
    public Bitmap art;
    private final AudioManager audioManager;
    private Context ctx;
    private PlayStatus currentPlayState;
    private MediaSessionCompat.Token lastToken;
    ComponentName listenerComponent;
    public MediaControllerCompat mController;
    public MusicCallback musicCallback;
    private List<MediaSessionCompat.QueueItem> queueItems;
    ScheduledExecutorService scheduler;
    private long songDuration;
    private final TelecomManager telecomManager;
    public final ArrayList<Item_song> songNameList = new ArrayList<>();
    private long lastPosition = 0;
    private int restartCount = 0;
    private String name = "";
    private long checkCounter = 0;
    private final Map<String, Integer> artReloadAttempts = new HashMap();
    private int metadataGeneration = 0;
    private final AppListUpdatedCallback mSessionAppsUpdated = new AppListUpdatedCallback() { // from class: com.bajajconnect.music.MediaSessionListener.1
        @Override // com.bajajconnect.music.AppListUpdatedCallback
        public void onAppListUpdated(List<MediaAppDetails> list) {
            if (list.isEmpty()) {
                Log.d("MediaSession", "no active media sessions — clear cluster media/playlist NOW");
                MediaSessionListener.this.musicCallback.onMusicAppKilled();
                MediaSessionListener.this.stopTimer();
                MediaSessionListener.this.mController = null;
                MediaSessionListener.this.lastToken = null;
                MediaSessionListener.this.currentPlayState = PlayStatus.NONE;
                return;
            }
            String str = MusicCallbackImpl.ACTIVE_PACKAGE_NAME;
            if (str != null && !str.isEmpty()) {
                for (MediaAppDetails mediaAppDetails : list) {
                    if (mediaAppDetails == null || !str.equals(mediaAppDetails.packageName)) {
                    }
                }
                Log.d("MediaSession", "active package gone: " + str + " — will clear on switch to " + list.get(0).packageName);
            }
            MediaSessionListener.this.musicCallback.onActiveSessionFound(MediaSessionListener.this.ctx);
            MediaSessionListener mediaSessionListener = MediaSessionListener.this;
            mediaSessionListener.setupMediaController(mediaSessionListener.pickPreferredMediaApp(list));
        }
    };
    private final MediaSessionManager.OnActiveSessionsChangedListener mSessionsChangedListener = new MediaSessionManager.OnActiveSessionsChangedListener() { // from class: com.bajajconnect.music.MediaSessionListener$$ExternalSyntheticLambda1
        @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
        public final void onActiveSessionsChanged(List list) {
            this.f$0.lambda$new$0(list);
        }
    };
    private final MediaControllerCompat.Callback mCallback = new AnonymousClass4();

    public MediaSessionListener(Context context, MusicCallback musicCallback) {
        this.musicCallback = null;
        this.ctx = context.getApplicationContext();
        this.musicCallback = musicCallback;
        this.audioManager = (AudioManager) context.getSystemService("audio");
        this.telecomManager = (TelecomManager) this.ctx.getSystemService("telecom");
    }

    public static boolean isNotificationListenerEnabled(Context context) {
        return isEnabled(context);
    }

    public static boolean isEnabled(Context context) {
        return NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(List list) {
        this.mSessionAppsUpdated.onAppListUpdated(MediaAppControllerUtils.getMediaAppsFromControllers(list, this.ctx.getPackageManager(), this.ctx.getResources()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaAppDetails pickPreferredMediaApp(List<MediaAppDetails> list) {
        MediaAppDetails mediaAppDetails = list.get(0);
        MediaAppDetails mediaAppDetails2 = null;
        for (MediaAppDetails mediaAppDetails3 : list) {
            if (mediaAppDetails3 != null && mediaAppDetails3.sessionToken != null) {
                try {
                    PlaybackStateCompat playbackState = new MediaControllerCompat(this.ctx, mediaAppDetails3.sessionToken).getPlaybackState();
                    if (playbackState != null && playbackState.getState() == 3) {
                        Log.d("MediaSession", "prefer playing session: " + mediaAppDetails3.packageName);
                        return mediaAppDetails3;
                    }
                    if (mediaAppDetails2 == null && MusicCallbackImpl.ACTIVE_PACKAGE_NAME != null && MusicCallbackImpl.ACTIVE_PACKAGE_NAME.equals(mediaAppDetails3.packageName)) {
                        mediaAppDetails2 = mediaAppDetails3;
                    }
                } catch (Exception e) {
                    Log.d("MediaSession", "pickPreferredMediaApp inspect failed for " + mediaAppDetails3.packageName + ": " + e.getMessage());
                }
            }
        }
        return mediaAppDetails2 != null ? mediaAppDetails2 : mediaAppDetails;
    }

    public void ensurePreferredController() {
        List<MediaAppDetails> mediaAppsFromControllers;
        try {
            if (mMediaSessionManager == null) {
                mMediaSessionManager = (MediaSessionManager) this.ctx.getSystemService("media_session");
            }
            if (mMediaSessionManager == null) {
                return;
            }
            if (this.listenerComponent == null) {
                this.listenerComponent = new ComponentName(this.ctx, (Class<?>) MyNotificationService.class);
            }
            List<MediaController> activeSessions = mMediaSessionManager.getActiveSessions(this.listenerComponent);
            if (activeSessions != null && !activeSessions.isEmpty() && (mediaAppsFromControllers = MediaAppControllerUtils.getMediaAppsFromControllers(activeSessions, this.ctx.getPackageManager(), this.ctx.getResources())) != null && !mediaAppsFromControllers.isEmpty()) {
                setupMediaController(pickPreferredMediaApp(mediaAppsFromControllers));
            }
        } catch (Exception e) {
            Log.e("MediaSession", "ensurePreferredController failed", e);
        }
    }

    public void onCreate() {
        mMediaSessionManager = (MediaSessionManager) this.ctx.getSystemService("media_session");
    }

    public void onStart(Context context) {
        if (!isEnabled(context)) {
            context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
            return;
        }
        startScheduler();
        if (mMediaSessionManager == null) {
            mMediaSessionManager = (MediaSessionManager) this.ctx.getSystemService("media_session");
        }
        ComponentName componentName = new ComponentName(context, (Class<?>) MyNotificationService.class);
        this.listenerComponent = componentName;
        try {
            mMediaSessionManager.addOnActiveSessionsChangedListener(this.mSessionsChangedListener, componentName);
            this.mSessionAppsUpdated.onAppListUpdated(MediaAppControllerUtils.getMediaAppsFromControllers(mMediaSessionManager.getActiveSessions(this.listenerComponent), this.ctx.getPackageManager(), this.ctx.getResources()));
        } catch (Exception unused) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.music.MediaSessionListener$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStart$1();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$1() {
        mMediaSessionManager = null;
        onStart(this.ctx.getApplicationContext());
    }

    public void onStop() {
        MediaSessionManager mediaSessionManager = mMediaSessionManager;
        if (mediaSessionManager == null) {
            return;
        }
        mediaSessionManager.removeOnActiveSessionsChangedListener(this.mSessionsChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMediaController(MediaAppDetails mediaAppDetails) {
        if (this.mController != null && this.lastToken != null && mediaAppDetails.packageName.equals(this.mController.getPackageName()) && this.mController.isSessionReady() && this.lastToken == mediaAppDetails.sessionToken) {
            try {
                this.musicCallback.onSessionReady(this.mController.getPackageName());
                this.name = "";
                this.mCallback.onPlaybackStateChanged(this.mController.getPlaybackState());
                forceRefreshNowPlaying();
                fetchPlaylist();
                return;
            } catch (Exception e) {
                Log.w("BLE_MUSIC", "same-session refresh failed", e);
                return;
            }
        }
        if (ActivityCompat.checkSelfPermission(this.ctx.getApplicationContext(), "android.permission.READ_PHONE_STATE") == 0 && this.telecomManager.isInCall()) {
            return;
        }
        this.lastToken = mediaAppDetails.sessionToken;
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.ctx, mediaAppDetails.sessionToken);
        this.mController = mediaControllerCompat;
        mediaControllerCompat.registerCallback(this.mCallback);
        this.musicCallback.onSessionReady(this.mController.getPackageName());
        this.mCallback.onPlaybackStateChanged(this.mController.getPlaybackState());
        this.mCallback.onMetadataChanged(this.mController.getMetadata());
        fetchPlaylist();
    }

    public void fetchPlaylist() {
        try {
            MediaControllerCompat mediaControllerCompat = this.mController;
            if (mediaControllerCompat == null) {
                return;
            }
            List<MediaSessionCompat.QueueItem> queue = mediaControllerCompat.getQueue();
            this.queueItems = queue;
            replaceSongNameList(buildPlaybackOrderedPlaylist(queue));
            String packageName = this.mController.getPackageName();
            if (this.musicCallback != null && this.songNameList.size() > 0) {
                Log.d("PLAYLIST_DBG", "fetchPlaylist queueSize=" + this.songNameList.size() + " first=" + this.songNameList.get(0).getTitle() + " pkg=" + packageName);
                this.musicCallback.onQueueItemChange(this.songNameList, packageName);
                return;
            }
            if (this.musicCallback != null) {
                if (MusicCallbackImpl.SPOTIFY_PACKAGE_NAME.equals(packageName != null ? packageName : "")) {
                    Log.w("PLAYLIST_DBG", "fetchPlaylist: Spotify queue empty — not seeding fallback");
                    return;
                }
                Item_song item_songBuildCurrentTrackFallback = buildCurrentTrackFallback();
                if (item_songBuildCurrentTrackFallback == null) {
                    Log.w("PLAYLIST_DBG", "fetchPlaylist: empty queue and no metadata for pkg=" + packageName);
                    return;
                }
                ArrayList<Item_song> arrayList = new ArrayList<>();
                arrayList.add(item_songBuildCurrentTrackFallback);
                Log.d("PLAYLIST_DBG", "fetchPlaylist fallback title=" + item_songBuildCurrentTrackFallback.getTitle() + " pkg=" + packageName);
                this.musicCallback.onQueueItemChange(arrayList, packageName);
            }
        } catch (Exception e) {
            Log.e("PLAYLIST_DBG", "fetchPlaylist failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Item_song> buildPlaybackOrderedPlaylist(List<MediaSessionCompat.QueueItem> list) {
        ArrayList<Item_song> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            ArrayList<Item_song> arrayList2 = new ArrayList<>();
            int iMin = Math.min(list.size(), 195);
            int i = 0;
            for (int i2 = 0; i2 < iMin; i2++) {
                Item_song item_songQueueItemToSong = queueItemToSong(list.get(i2));
                if (item_songQueueItemToSong != null) {
                    arrayList2.add(item_songQueueItemToSong);
                }
            }
            if (arrayList2.isEmpty()) {
                return arrayList;
            }
            int iFindActiveQueueIndex = findActiveQueueIndex(list, arrayList2);
            if (iFindActiveQueueIndex >= 0 && iFindActiveQueueIndex < arrayList2.size()) {
                i = iFindActiveQueueIndex;
            }
            for (int i3 = i; i3 < arrayList2.size() && arrayList.size() < 195; i3++) {
                arrayList.add(arrayList2.get(i3));
            }
            Log.d("PLAYLIST_DBG", "ytm next-queue activeIdx=" + i + " rawSize=" + arrayList2.size() + " nextSize=" + arrayList.size() + " first5=" + firstTitles(arrayList, 5));
        }
        return arrayList;
    }

    private static String firstTitles(ArrayList<Item_song> arrayList, int i) {
        if (arrayList == null || arrayList.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i2 = 0; i2 < Math.min(i, arrayList.size()); i2++) {
            if (i2 > 0) {
                sb.append(" | ");
            }
            sb.append(arrayList.get(i2).getTitle());
        }
        sb.append("]");
        return sb.toString();
    }

    private Item_song queueItemToSong(MediaSessionCompat.QueueItem queueItem) {
        MediaDescriptionCompat description;
        String strResolveQueueItemTitle;
        if (queueItem == null || queueItem.getDescription() == null || (strResolveQueueItemTitle = resolveQueueItemTitle((description = queueItem.getDescription()))) == null || strResolveQueueItemTitle.isEmpty()) {
            return null;
        }
        return new Item_song(strResolveQueueItemTitle, description.getSubtitle() != null ? description.getSubtitle().toString() : "", queueItem.getQueueId(), description.getMediaUri(), description.getExtras(), description.getMediaId() != null ? description.getMediaId() : "");
    }

    static String resolveQueueItemTitle(MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return null;
        }
        if (mediaDescriptionCompat.getTitle() != null) {
            String strTrim = mediaDescriptionCompat.getTitle().toString().trim();
            if (!strTrim.isEmpty()) {
                return strTrim;
            }
        }
        Bundle extras = mediaDescriptionCompat.getExtras();
        if (extras != null) {
            String string = extras.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE);
            if (string != null && !string.trim().isEmpty()) {
                return string.trim();
            }
            String string2 = extras.getString("android.media.metadata.TITLE");
            if (string2 != null && !string2.trim().isEmpty()) {
                return string2.trim();
            }
        }
        return null;
    }

    private int findActiveQueueIndex(List<MediaSessionCompat.QueueItem> list, ArrayList<Item_song> arrayList) {
        long activeQueueItemId;
        String strResolveTrackTitle;
        String str;
        try {
            MediaControllerCompat mediaControllerCompat = this.mController;
            activeQueueItemId = (mediaControllerCompat == null || mediaControllerCompat.getPlaybackState() == null) ? -1L : this.mController.getPlaybackState().getActiveQueueItemId();
        } catch (Exception unused) {
        }
        if (activeQueueItemId != -1) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getId() == activeQueueItemId) {
                    return i;
                }
            }
            for (int i2 = 0; i2 < list.size() && i2 < 195; i2++) {
                if (list.get(i2).getQueueId() == activeQueueItemId) {
                    Item_song item_songQueueItemToSong = queueItemToSong(list.get(i2));
                    if (item_songQueueItemToSong == null) {
                        break;
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (arrayList.get(i3).getId() == item_songQueueItemToSong.getId()) {
                            return i3;
                        }
                    }
                    break;
                }
            }
        }
        String strTrim = null;
        try {
            MediaControllerCompat mediaControllerCompat2 = this.mController;
            if (mediaControllerCompat2 == null || mediaControllerCompat2.getMetadata() == null) {
                str = null;
            } else {
                strResolveTrackTitle = resolveTrackTitle(this.mController.getMetadata());
                try {
                    strTrim = this.mController.getMetadata().getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);
                } catch (Exception unused2) {
                }
                String str2 = strResolveTrackTitle;
                str = strTrim;
                strTrim = str2;
            }
        } catch (Exception unused3) {
            strResolveTrackTitle = null;
        }
        if ((strTrim == null || strTrim.isEmpty()) && GlobalVar.songName != null && !GlobalVar.songName.trim().isEmpty()) {
            strTrim = GlobalVar.songName.trim();
        }
        if (str != null && !str.isEmpty()) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (str.equals(arrayList.get(i4).getMediaId())) {
                    return i4;
                }
            }
        }
        if (strTrim != null && !strTrim.isEmpty()) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                if (titlesEqual(arrayList.get(i5).getTitle(), strTrim)) {
                    return i5;
                }
            }
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                if (titlesLooselyMatch(arrayList.get(i6).getTitle(), strTrim)) {
                    Log.d("PLAYLIST_DBG", "activeIdx loose title match i=" + i6 + " queue=" + arrayList.get(i6).getTitle() + " now=" + strTrim);
                    return i6;
                }
            }
        }
        Log.w("PLAYLIST_DBG", "activeIdx not found activeId=" + activeQueueItemId + " now=" + strTrim + " — defaulting to 0");
        return 0;
    }

    static boolean titlesEqual(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.trim().equalsIgnoreCase(str2.trim());
    }

    static boolean titlesLooselyMatch(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase();
        String lowerCase2 = str2.trim().toLowerCase();
        if (lowerCase.isEmpty() || lowerCase2.isEmpty()) {
            return false;
        }
        if (lowerCase.equals(lowerCase2)) {
            return true;
        }
        String str3 = lowerCase.length() <= lowerCase2.length() ? lowerCase : lowerCase2;
        if (lowerCase.length() <= lowerCase2.length()) {
            lowerCase = lowerCase2;
        }
        return str3.length() >= 4 && lowerCase.contains(str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSameQueueOrder(List<MediaSessionCompat.QueueItem> list, List<MediaSessionCompat.QueueItem> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int iMin = Math.min(list.size(), 195);
        for (int i = 0; i < iMin; i++) {
            if (list.get(i).getQueueId() != list2.get(i).getQueueId()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceSongNameList(ArrayList<Item_song> arrayList) {
        this.songNameList.clear();
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.songNameList.addAll(arrayList);
    }

    private Item_song buildCurrentTrackFallback() {
        MediaMetadataCompat metadata;
        String strResolveTrackTitle;
        try {
            MediaControllerCompat mediaControllerCompat = this.mController;
            if (mediaControllerCompat != null && mediaControllerCompat.getMetadata() != null && (strResolveTrackTitle = resolveTrackTitle((metadata = this.mController.getMetadata()))) != null && !strResolveTrackTitle.trim().isEmpty()) {
                String strResolveTrackArtist = resolveTrackArtist(metadata);
                String string = metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);
                if (string == null) {
                    string = "";
                }
                return new Item_song(strResolveTrackTitle, strResolveTrackArtist, 0L, null, null, string);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    static String resolveTrackTitle(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null) {
            return null;
        }
        String string = mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE);
        if (string != null && !string.trim().isEmpty()) {
            return string.trim();
        }
        String string2 = mediaMetadataCompat.getString("android.media.metadata.TITLE");
        if (string2 != null && !string2.trim().isEmpty()) {
            return string2.trim();
        }
        try {
            if (mediaMetadataCompat.getDescription() != null && mediaMetadataCompat.getDescription().getTitle() != null) {
                String strTrim = mediaMetadataCompat.getDescription().getTitle().toString().trim();
                if (!strTrim.isEmpty()) {
                    return strTrim;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    static String resolveTrackArtist(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null) {
            return "";
        }
        String string = mediaMetadataCompat.getString("android.media.metadata.ARTIST");
        if (string != null && !string.trim().isEmpty()) {
            return string.trim();
        }
        String string2 = mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE);
        if (string2 != null && !string2.trim().isEmpty()) {
            return string2.trim();
        }
        try {
            if (mediaMetadataCompat.getDescription() != null && mediaMetadataCompat.getDescription().getSubtitle() != null) {
                return mediaMetadataCompat.getDescription().getSubtitle().toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private void startScheduler() {
        if (this.scheduler == null) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.scheduler = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.bajajconnect.music.MediaSessionListener$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startScheduler$2();
                }
            }, 0L, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startScheduler$2() {
        if (ActivityCompat.checkSelfPermission(this.ctx.getApplicationContext(), "android.permission.READ_PHONE_STATE") == 0 && this.telecomManager.isInCall()) {
            return;
        }
        int i = this.restartCount;
        if (i > 0) {
            this.restartCount = i - 1;
        }
        if (!this.audioManager.isMusicActive()) {
            return;
        }
        try {
            MediaControllerCompat mediaControllerCompat = this.mController;
            if (mediaControllerCompat == null) {
                return;
            }
            long position = mediaControllerCompat.getPlaybackState().getPosition();
            if (this.lastPosition != position) {
                this.checkCounter = 0L;
                if (isPaused.booleanValue()) {
                    this.mCallback.onPlaybackStateChanged(this.mController.getPlaybackState());
                }
                this.lastPosition = position;
                this.musicCallback.onCurrentPositionChange(0, Long.valueOf(position));
            } else {
                long j = this.checkCounter + 1;
                this.checkCounter = j;
                if (j >= 5) {
                    this.checkCounter = 0L;
                    restart();
                }
            }
            try {
                MediaControllerCompat mediaControllerCompat2 = this.mController;
                if (mediaControllerCompat2 != null) {
                    GlobalVar.SHUFFLE_STATUS = mediaControllerCompat2.getShuffleMode();
                }
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            this.restartCount--;
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restart() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.music.MediaSessionListener.2
            @Override // java.lang.Runnable
            public void run() {
                MediaSessionListener.this.restartCount = 5;
                MediaSessionListener.this.mSessionAppsUpdated.onAppListUpdated(MediaAppControllerUtils.getMediaAppsFromControllers(MediaSessionListener.mMediaSessionManager.getActiveSessions(MediaSessionListener.this.listenerComponent), MediaSessionListener.this.ctx.getPackageManager(), MediaSessionListener.this.ctx.getResources()));
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTimer() {
        Timer timer2 = timer;
        if (timer2 != null) {
            timer2.cancel();
            timer.purge();
            timer = null;
        }
    }

    public void onClusterSkipRequested(String str) {
        this.metadataGeneration++;
        this.name = "";
        Log.d("BLE_MUSIC", "onClusterSkipRequested " + str + " gen=" + this.metadataGeneration);
        int i = this.metadataGeneration;
        String str2 = GlobalVar.songName != null ? GlobalVar.songName : "";
        long[] jArr = {250, 600, 1200, 2000, 3500};
        for (int i2 = 0; i2 < 5; i2++) {
            scheduleClusterSkipPoll(i, str, str2, jArr[i2]);
        }
    }

    private void scheduleClusterSkipPoll(final int i, final String str, final String str2, final long j) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.music.MediaSessionListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleClusterSkipPoll$3(i, str, j, str2);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleClusterSkipPoll$3(int i, String str, long j, String str2) {
        MediaControllerCompat mediaControllerCompat;
        MediaMetadataCompat metadata;
        String strResolveTrackTitle;
        try {
            if (i == this.metadataGeneration && (mediaControllerCompat = this.mController) != null && (metadata = mediaControllerCompat.getMetadata()) != null && (strResolveTrackTitle = resolveTrackTitle(metadata)) != null && !strResolveTrackTitle.isEmpty()) {
                String str3 = GlobalVar.songName == null ? "" : GlobalVar.songName;
                if (strResolveTrackTitle.equals(str3)) {
                    return;
                }
                Log.d("BLE_MUSIC", "clusterSkipPoll(" + str + " +" + j + "ms): metadataTitle=\"" + strResolveTrackTitle + "\" clusterTitle=\"" + str3 + "\" baseline=\"" + str2 + "\" — force push");
                StringBuilder sb = new StringBuilder("clusterSkipPoll:");
                sb.append(str);
                sb.append(":+");
                sb.append(j);
                sb.append("ms");
                pushTitleImmediateFromMetadata(metadata, strResolveTrackTitle, sb.toString());
            }
        } catch (Exception e) {
            Log.w("BLE_MUSIC", "clusterSkipPoll failed", e);
        }
    }

    private void pushTitleImmediateFromMetadata(MediaMetadataCompat mediaMetadataCompat, String str, String str2) {
        if (str != null) {
            try {
                if (str.trim().isEmpty()) {
                    return;
                }
                String strResolveTrackArtist = resolveTrackArtist(mediaMetadataCompat);
                String string = mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ALBUM);
                long j = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
                if (j >= 1) {
                    this.songDuration = j;
                }
                Bitmap bitmap = mediaMetadataCompat.getBitmap(MediaMetadataCompat.METADATA_KEY_ART);
                if (bitmap == null) {
                    bitmap = mediaMetadataCompat.getBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                }
                if (bitmap == null) {
                    try {
                        if (mediaMetadataCompat.getDescription() != null) {
                            bitmap = mediaMetadataCompat.getDescription().getIconBitmap();
                        }
                    } catch (Exception unused) {
                    }
                }
                if (bitmap != null) {
                    this.art = bitmap;
                }
                this.name = str;
                Log.d("BLE_MUSIC", "pushTitleImmediateFromMetadata reason=" + str2 + " title=\"" + str + "\"");
                this.musicCallback.onMetadataChange(str, 0, strResolveTrackArtist == null ? "" : strResolveTrackArtist, string == null ? "" : string, this.songDuration, this.art);
            } catch (Exception e) {
                Log.w("BLE_MUSIC", "pushTitleImmediateFromMetadata failed", e);
            }
        }
    }

    public void forceRefreshNowPlaying() throws IOException {
        MediaMetadataCompat metadata;
        String strResolveTrackTitle;
        MediaControllerCompat mediaControllerCompat = this.mController;
        if (mediaControllerCompat == null || (metadata = mediaControllerCompat.getMetadata()) == null || (strResolveTrackTitle = resolveTrackTitle(metadata)) == null || strResolveTrackTitle.isEmpty()) {
            return;
        }
        this.name = "";
        fetchMediaInfo(strResolveTrackTitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchMediaInfo(String str) throws IOException {
        MediaMetadataCompat metadata;
        int i = this.metadataGeneration;
        MediaControllerCompat mediaControllerCompat = this.mController;
        if (mediaControllerCompat == null || (metadata = mediaControllerCompat.getMetadata()) == null) {
            return;
        }
        if (metadata.getLong("android.media.metadata.ADVERTISEMENT") == 1) {
            long j = metadata.getLong("android.media.metadata.DURATION");
            if (j >= 1) {
                this.songDuration = j;
            }
            this.musicCallback.onMetadataChange("Advertisement", 0, "", "", this.songDuration, null);
            return;
        }
        final String strResolveTrackTitle = resolveTrackTitle(metadata);
        String strResolveTrackArtist = resolveTrackArtist(metadata);
        String string = metadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM);
        long j2 = metadata.getLong("android.media.metadata.DURATION");
        if (j2 >= 1) {
            this.songDuration = j2;
        }
        if (strResolveTrackTitle == null || strResolveTrackTitle.isEmpty()) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this.ctx, "android.permission.READ_PHONE_STATE") == 0 && this.telecomManager.isInCall()) {
            return;
        }
        final String string2 = metadata.getString(MediaMetadataCompat.METADATA_KEY_ART_URI);
        Bitmap bitmap = metadata.getBitmap(MediaMetadataCompat.METADATA_KEY_ART);
        this.art = bitmap;
        String string3 = BuildConfig.TRAVIS;
        final String str2 = "mediaSessionListener";
        if (bitmap != null) {
            try {
                LogUtils.debug("mediaSessionListener", "art acquired from METADATA_KEY_ART size=" + this.art.getWidth() + "x" + this.art.getHeight() + " config=" + (bitmap.getConfig() == null ? BuildConfig.TRAVIS : this.art.getConfig().toString()));
            } catch (Exception e) {
                LogUtils.debug("mediaSessionListener", "error logging art from METADATA_KEY_ART: " + e.getMessage());
            }
        }
        Bitmap bitmap2 = metadata.getBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
        try {
            if (this.art == null && metadata.getDescription() != null) {
                Bitmap iconBitmap = metadata.getDescription().getIconBitmap();
                this.art = iconBitmap;
                if (iconBitmap != null) {
                    LogUtils.debug("mediaSessionListener", "art acquired from description.getIconBitmap size=" + this.art.getWidth() + "x" + this.art.getHeight() + " config=" + (iconBitmap.getConfig() == null ? BuildConfig.TRAVIS : this.art.getConfig().toString()));
                }
            }
        } catch (Exception e2) {
            LogUtils.debug("mediaSessionListener", "exception while getting description icon: " + e2.getMessage());
        }
        if (this.art == null) {
            if (bitmap2 != null) {
                this.art = bitmap2;
                try {
                    if (bitmap2.getConfig() != null) {
                        string3 = this.art.getConfig().toString();
                    }
                    LogUtils.debug("mediaSessionListener", "art acquired from ALBUM_ART size=" + this.art.getWidth() + "x" + this.art.getHeight() + " config=" + string3);
                } catch (Exception e3) {
                    LogUtils.debug("mediaSessionListener", "error logging albumArt: " + e3.getMessage());
                }
            } else if (string2 != null) {
                new Thread() { // from class: com.bajajconnect.music.MediaSessionListener.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Bitmap bitmapDecodeStream = null;
                        for (int i2 = 1; i2 <= 3; i2++) {
                            try {
                                Uri uri = Uri.parse(string2);
                                LogUtils.debug(str2, "attempt " + i2 + " to load art from uri=" + string2 + " scheme=" + uri.getScheme());
                                String scheme = uri.getScheme();
                                if (scheme != null && (scheme.equals(UriUtil.HTTP_SCHEME) || scheme.equals(UriUtil.HTTPS_SCHEME))) {
                                    InputStream inputStream = ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(string2).openConnection())).getInputStream();
                                    if (inputStream != null) {
                                        try {
                                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                                        } catch (Throwable th) {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } else if (scheme != null && (scheme.equals("content") || scheme.equals("file"))) {
                                    try {
                                        InputStream inputStreamOpenInputStream = MediaSessionListener.this.ctx.getContentResolver().openInputStream(uri);
                                        if (inputStreamOpenInputStream != null) {
                                            try {
                                                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                                            } catch (Throwable th3) {
                                                if (inputStreamOpenInputStream != null) {
                                                    try {
                                                        inputStreamOpenInputStream.close();
                                                    } catch (Throwable th4) {
                                                        th3.addSuppressed(th4);
                                                    }
                                                }
                                                throw th3;
                                            }
                                        }
                                        if (inputStreamOpenInputStream != null) {
                                            inputStreamOpenInputStream.close();
                                        }
                                    } catch (Exception e4) {
                                        LogUtils.debug(str2, "content resolver openInputStream failed (attempt " + i2 + "): " + e4.getMessage() + ", will try URL fallback");
                                        try {
                                            InputStream inputStream2 = ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(string2).openConnection())).getInputStream();
                                            if (inputStream2 != null) {
                                                try {
                                                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream2);
                                                } catch (Throwable th5) {
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                        } catch (Throwable th6) {
                                                            th5.addSuppressed(th6);
                                                        }
                                                    }
                                                    throw th5;
                                                }
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                        } catch (Exception e5) {
                                            LogUtils.debug(str2, "URL fallback failed (attempt " + i2 + "): " + e5.getMessage());
                                        }
                                    }
                                } else {
                                    try {
                                        InputStream inputStream3 = ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(string2).openConnection())).getInputStream();
                                        if (inputStream3 != null) {
                                            try {
                                                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream3);
                                            } catch (Throwable th7) {
                                                if (inputStream3 != null) {
                                                    try {
                                                        inputStream3.close();
                                                    } catch (Throwable th8) {
                                                        th7.addSuppressed(th8);
                                                    }
                                                }
                                                throw th7;
                                            }
                                        }
                                        if (inputStream3 != null) {
                                            inputStream3.close();
                                        }
                                    } catch (Exception e6) {
                                        LogUtils.debug(str2, "unknown-scheme URL fetch failed (attempt " + i2 + "): " + e6.getMessage());
                                    }
                                }
                            } catch (Exception e7) {
                                LogUtils.debug(str2, "exception while loading art uri (attempt " + i2 + "): " + e7.getMessage());
                            }
                            if (bitmapDecodeStream != null) {
                                try {
                                    String string4 = bitmapDecodeStream.getConfig() == null ? BuildConfig.TRAVIS : bitmapDecodeStream.getConfig().toString();
                                    LogUtils.debug(str2, "art loaded from uri size=" + bitmapDecodeStream.getWidth() + "x" + bitmapDecodeStream.getHeight() + " config=" + string4 + " after attempt=" + i2);
                                    break;
                                } catch (Exception e8) {
                                    LogUtils.debug(str2, "error logging art from uri: " + e8.getMessage());
                                }
                            } else {
                                LogUtils.debug(str2, "attempt " + i2 + " failed to load art (returned null)");
                                if (i2 < 3) {
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException unused) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                            }
                        }
                        MediaSessionListener.this.art = bitmapDecodeStream;
                        if (bitmapDecodeStream == null) {
                            LogUtils.debug(str2, "failed to load art from uri after 3 attempts: returned null bitmap");
                        }
                    }
                }.run();
            }
        }
        if (i != this.metadataGeneration) {
            Log.d("BLE_MUSIC", "drop stale fetchMediaInfo gen=" + i + " now=" + this.metadataGeneration + " title=" + strResolveTrackTitle);
            return;
        }
        if (Objects.equals(this.name, strResolveTrackTitle)) {
            return;
        }
        this.name = strResolveTrackTitle;
        StringBuilder sb = new StringBuilder("metadata title=");
        sb.append(strResolveTrackTitle);
        sb.append(" artist=");
        sb.append(strResolveTrackArtist);
        sb.append(" pkg=");
        MediaControllerCompat mediaControllerCompat2 = this.mController;
        sb.append(mediaControllerCompat2 != null ? mediaControllerCompat2.getPackageName() : "?");
        Log.d("BLE_MUSIC", sb.toString());
        this.musicCallback.onMetadataChange(strResolveTrackTitle, 0, strResolveTrackArtist, string, this.songDuration, this.art);
        Bitmap bitmap3 = this.art;
        if (bitmap3 != null) {
            try {
                this.musicCallback.onArtworkReady(bitmap3);
                this.artReloadAttempts.remove(strResolveTrackTitle);
            } catch (Exception e4) {
                LogUtils.debug("mediaSessionListener", "onArtworkReady callback failed: " + e4.getMessage());
            }
        } else {
            int iIntValue = this.artReloadAttempts.containsKey(strResolveTrackTitle) ? this.artReloadAttempts.get(strResolveTrackTitle).intValue() : 0;
            if (iIntValue < 3) {
                int i2 = iIntValue + 1;
                this.artReloadAttempts.put(strResolveTrackTitle, Integer.valueOf(i2));
                long j3 = ((long) i2) * 500;
                final int i3 = this.metadataGeneration;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.music.MediaSessionListener$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$fetchMediaInfo$4(i3, strResolveTrackTitle, str2);
                    }
                }, j3);
            } else {
                this.artReloadAttempts.remove(strResolveTrackTitle);
            }
        }
        fetchPlaylist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchMediaInfo$4(int i, String str, String str2) {
        if (i != this.metadataGeneration) {
            return;
        }
        try {
            fetchMediaInfo(str);
        } catch (Exception e) {
            LogUtils.debug(str2, "delayed fetchMediaInfo failed: " + e.getMessage());
        }
    }

    public void playSongFromQueue(int i) {
        try {
            Log.e("Mediasession", "skip to track " + i);
            this.mController.getTransportControls().skipToQueueItem(MusicCallbackImpl.songsList.get(i).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlayStatus playbackStateToName(int i) {
        if (i == 3) {
            return PlayStatus.PLAY;
        }
        if (i == 1 || i == 0 || i == 7) {
            return PlayStatus.NONE;
        }
        return PlayStatus.PAUSED;
    }

    /* JADX INFO: renamed from: com.bajajconnect.music.MediaSessionListener$4, reason: invalid class name */
    class AnonymousClass4 extends MediaControllerCompat.Callback {
        AnonymousClass4() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            PlayStatus playStatusPlaybackStateToName;
            if (playbackStateCompat == null || MediaSessionListener.this.currentPlayState == (playStatusPlaybackStateToName = MediaSessionListener.this.playbackStateToName(playbackStateCompat.getState()))) {
                return;
            }
            MediaSessionListener.this.currentPlayState = playStatusPlaybackStateToName;
            if (MediaSessionListener.this.currentPlayState == PlayStatus.PLAY) {
                MediaSessionListener.this.musicCallback.onPlaybackStateChange(PlayStatus.PLAY);
                MediaSessionListener.isPaused = false;
            } else if (MediaSessionListener.this.currentPlayState == PlayStatus.PAUSED) {
                MediaSessionListener.this.musicCallback.onPlaybackStateChange(PlayStatus.PAUSED);
                MediaSessionListener.isPaused = true;
            } else if (MediaSessionListener.this.currentPlayState == PlayStatus.NONE) {
                MediaSessionListener.isPaused = true;
                try {
                    MediaSessionListener.this.musicCallback.onPlaybackStateChange(PlayStatus.NONE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback, android.os.IBinder.DeathRecipient
        public void binderDied() {
            super.binderDied();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            super.onSessionEvent(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
            super.onQueueChanged(list);
            if (list == null || list.isEmpty()) {
                return;
            }
            try {
                if (MediaSessionListener.isSameQueueOrder(MediaSessionListener.this.queueItems, list)) {
                    ArrayList arrayListBuildPlaybackOrderedPlaylist = MediaSessionListener.this.buildPlaybackOrderedPlaylist(list);
                    if (!arrayListBuildPlaybackOrderedPlaylist.isEmpty() && MediaSessionListener.this.songNameList.size() == arrayListBuildPlaybackOrderedPlaylist.size() && !MediaSessionListener.this.songNameList.isEmpty() && MediaSessionListener.this.songNameList.get(0).getId() == ((Item_song) arrayListBuildPlaybackOrderedPlaylist.get(0)).getId()) {
                        return;
                    }
                    MediaSessionListener.this.queueItems = list;
                    MediaSessionListener.this.replaceSongNameList(arrayListBuildPlaybackOrderedPlaylist);
                } else {
                    MediaSessionListener.this.queueItems = list;
                    MediaSessionListener mediaSessionListener = MediaSessionListener.this;
                    mediaSessionListener.replaceSongNameList(mediaSessionListener.buildPlaybackOrderedPlaylist(list));
                }
                if (MediaSessionListener.this.musicCallback == null || MediaSessionListener.this.songNameList == null || MediaSessionListener.this.songNameList.size() <= 0) {
                    return;
                }
                MediaSessionListener.this.musicCallback.onQueueItemChange(MediaSessionListener.this.songNameList, MediaSessionListener.this.mController != null ? MediaSessionListener.this.mController.getPackageName() : MediaSessionListener.this.ctx.getPackageName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat == null) {
                return;
            }
            try {
                String strResolveTrackTitle = MediaSessionListener.resolveTrackTitle(mediaMetadataCompat);
                if (strResolveTrackTitle != null && !strResolveTrackTitle.isEmpty()) {
                    long j = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
                    if (j != 0) {
                        GlobalVar.currentMusicTotalDuration = (int) (j / 1000);
                    } else {
                        GlobalVar.currentMusicTotalDuration = 0;
                    }
                    MediaSessionListener.this.fetchMediaInfo(strResolveTrackTitle);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            MediaSessionListener.this.stopTimer();
            if (MediaSessionListener.this.mController != null) {
                if (MediaSessionListener.this.queueItems != null) {
                    MediaSessionListener.this.queueItems.clear();
                }
                try {
                    try {
                        MediaSessionListener.this.musicCallback.onMusicAppKilled();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    MediaSessionListener.this.musicCallback.onCurrentSessionDestroyed();
                }
                try {
                    MediaSessionListener.this.mController.unregisterCallback(MediaSessionListener.this.mCallback);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MediaSessionListener.this.mController = null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onSessionReady() {
            Handler handler;
            super.onSessionReady();
            if (Looper.myLooper() != null) {
                handler = new Handler((Looper) Objects.requireNonNull(Looper.myLooper()));
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.postDelayed(new Runnable() { // from class: com.bajajconnect.music.MediaSessionListener$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSessionReady$0();
                }
            }, 1500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSessionReady$0() {
            try {
                if ((ActivityCompat.checkSelfPermission(MediaSessionListener.this.ctx, "android.permission.READ_PHONE_STATE") == 0 && MediaSessionListener.this.telecomManager.isInCall()) || Objects.equals(MediaSessionListener.mMediaSessionManager.getActiveSessions(MediaSessionListener.this.listenerComponent).get(0).getPackageName(), MediaSessionListener.this.mController.getPackageName())) {
                    return;
                }
                MediaSessionListener.this.restart();
            } catch (Exception unused) {
            }
        }
    }

    public List<MediaSessionCompat.QueueItem> getQueueItemsFromController() {
        MediaControllerCompat mediaControllerCompat = this.mController;
        if (mediaControllerCompat != null) {
            return mediaControllerCompat.getQueue();
        }
        return null;
    }
}
