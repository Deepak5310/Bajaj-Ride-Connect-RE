package com.bajajconnect.music;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.bajajconnect.MainActivity;
import com.bajajconnect.NavApplication;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.ble.BleService;
import com.bajajconnect.ble.CallFrame;
import com.bajajconnect.enums.music.PlayStatus;
import com.bajajconnect.interfaces.MusicCallback;
import com.bajajconnect.models.Item_song;
import com.bajajconnect.models.SongInfo;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.TcpServerService;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class MusicCallbackImpl implements MusicCallback {
    public static final String GANNA_PACKAGE_NAME = "com.gaana";
    private static final long MEDIA_TITLE_DEBOUNCE_MS = 180;
    public static final int PLAYLIST_MAX_SONGS = 6;
    public static final int PLAYLIST_SONGS_PER_PAGE = 5;
    private static final long PROGRESS_MEDIA_MIN_INTERVAL_MS = 1000;
    public static final String RC_PACKAGE_NAME = "com.bajajconnect";
    public static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";
    private static final long SPOTIFY_PLAYLIST_RESEND_MS = 700;
    private static final long STALE_TITLE_GUARD_MS = 1600;
    public static MusicCallbackImpl sInstance;
    public AudioManager audioManager;
    public Bitmap bitmap;
    private Handler handler;
    private Handler mediaWriteHandler;
    public Handler musicPlayPauseHandler;
    private Runnable pendingClearRunnable;
    private Runnable pendingMediaWriteRunnable;
    private Runnable pendingPage2Send;
    private Runnable pendingSpotifyPlaylistResend;
    private Handler sessionClearHandler;
    public static ArrayList<Item_song> songsList = new ArrayList<>();
    public static int totalNumberOfPages = 0;
    public static int totalsongs = 0;
    public static int currentTrackNumber = 0;
    public static String ACTIVE_PACKAGE_NAME = "";
    private final ArrayList<Item_song> currentPage = new ArrayList<>();
    private final ArrayList<Item_song> prevPage = new ArrayList<>();
    private final ArrayList<Item_song> nextPage = new ArrayList<>();
    private String lastPublishedSongName = "";
    private String previousPublishedSongName = "";
    private long lastSongTitleChangeAtMs = 0;
    private long lastProgressMediaWriteAtMs = 0;
    public ArrayList<Item_song> spotifyPlaylist = new ArrayList<>();
    Runnable spotifyNewSongFetch = new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda6
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$2();
        }
    };
    Runnable r = new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda7
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$4();
        }
    };

    public static MusicCallbackImpl getInstance() {
        if (sInstance == null) {
            sInstance = new MusicCallbackImpl();
        }
        return sInstance;
    }

    private synchronized void prepareCharAndWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) {
        BleService.prepareCharAndWrite(bluetoothGattCharacteristic, bArr);
    }

    private static boolean bleReadyForWrite() {
        return BleService.isGattConnected();
    }

    private static int resolveCurrentTrackIndex(ArrayList<Item_song> arrayList) {
        String str;
        if (arrayList != null && !arrayList.isEmpty() && (str = GlobalVar.songName) != null && !str.trim().isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (MediaSessionListener.titlesEqual(arrayList.get(i).getTitle(), str)) {
                    return i;
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00a3 A[Catch: Exception -> 0x00a8, TRY_LEAVE, TryCatch #1 {Exception -> 0x00a8, blocks: (B:10:0x0037, B:12:0x003f, B:14:0x0043, B:16:0x004b, B:18:0x0051, B:20:0x005b, B:21:0x005d, B:23:0x0063, B:24:0x0065, B:26:0x006d, B:27:0x006f, B:29:0x007b, B:31:0x0081, B:32:0x0083, B:34:0x008b, B:41:0x0099, B:42:0x009e, B:43:0x00a3), top: B:76:0x0037, outer: #0 }] */
    public static void rePushMediaAfterBleReconnect(String str) {
        try {
            MusicCallbackImpl musicCallbackImpl = getInstance();
            if (musicCallbackImpl == null) {
                return;
            }
            Log.d("PLAYLIST_DBG", "rePushMediaAfterBleReconnect: " + str + " song=" + GlobalVar.songName + " pkg=" + ACTIVE_PACKAGE_NAME);
            if (bleReadyForWrite()) {
                try {
                    MediaSessionListener mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
                    if (mediaSessionListener != null && mediaSessionListener.mController != null) {
                        MediaMetadataCompat metadata = mediaSessionListener.mController.getMetadata();
                        if (metadata != null) {
                            String strResolveTrackTitle = MediaSessionListener.resolveTrackTitle(metadata);
                            if (strResolveTrackTitle != null && !strResolveTrackTitle.trim().isEmpty()) {
                                GlobalVar.songName = strResolveTrackTitle;
                            }
                            String strResolveTrackArtist = MediaSessionListener.resolveTrackArtist(metadata);
                            if (strResolveTrackArtist != null) {
                                GlobalVar.songArtist = strResolveTrackArtist;
                            }
                            String string = metadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM);
                            if (string != null) {
                                GlobalVar.songAlbum = string;
                            }
                            long j = metadata.getLong("android.media.metadata.DURATION");
                            GlobalVar.currentMusicTotalDuration = j > 0 ? (int) (j / 1000) : 0;
                        }
                        PlaybackStateCompat playbackState = mediaSessionListener.mController.getPlaybackState();
                        if (playbackState != null) {
                            int state = playbackState.getState();
                            if (state == 0 || state == 1) {
                                GlobalVar.playStatus = PlayStatus.NONE;
                            } else if (state == 3) {
                                GlobalVar.playStatus = PlayStatus.PLAY;
                            } else if (state != 7) {
                                GlobalVar.playStatus = PlayStatus.PAUSED;
                            } else {
                                GlobalVar.playStatus = PlayStatus.NONE;
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.w("PLAYLIST_DBG", "rePushMediaAfterBleReconnect: live session sync failed", e);
                }
                if (GlobalVar.MEDIA_INFO_CHAR != null && GlobalVar.songName != null && !GlobalVar.songName.trim().isEmpty()) {
                    BleService.prepareCharAndWrite(GlobalVar.MEDIA_INFO_CHAR, CallFrame.musicInfoForVehicle(GlobalVar.songName, GlobalVar.songAlbum, GlobalVar.songArtist, GlobalVar.currentMusicDuration, GlobalVar.currentMusicTotalDuration, GlobalVar.playStatus));
                }
                int iMax = Math.max(GlobalVar.pagePlaylistAck, 1);
                if (ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME)) {
                    ArrayList<Item_song> arrayList = musicCallbackImpl.spotifyPlaylist;
                    if (arrayList == null || arrayList.isEmpty()) {
                        return;
                    }
                    musicCallbackImpl.sendPlaylistPage(iMax);
                    return;
                }
                ArrayList<Item_song> arrayList2 = songsList;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    musicCallbackImpl.sendPlaylistPage(iMax);
                    return;
                }
                try {
                    MediaSessionListener mediaSessionListener2 = BleFeatures.getInstance().mMediaSessionListener;
                    if (mediaSessionListener2 != null) {
                        mediaSessionListener2.fetchPlaylist();
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            Log.e("PLAYLIST_DBG", "rePushMediaAfterBleReconnect failed", e2);
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onPlaybackStateChange(PlayStatus playStatus) {
        if (this.musicPlayPauseHandler == null) {
            this.musicPlayPauseHandler = new Handler(Looper.getMainLooper());
        }
        if (playStatus == null || GlobalVar.playStatus == playStatus) {
            return;
        }
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) BleFeatures.getInstance().context.getSystemService("audio");
        }
        if (playStatus == PlayStatus.PLAY) {
            GlobalVar.playStatus = PlayStatus.PLAY;
        } else if (playStatus == PlayStatus.NONE) {
            GlobalVar.playStatus = PlayStatus.NONE;
        } else {
            GlobalVar.playStatus = PlayStatus.PAUSED;
        }
        Log.d("MusicCallback", "onPlaybackStateChange: state=" + playStatus + " → byte104=" + GlobalVar.playStatus.getValue());
        if (playStatus == PlayStatus.PLAY && (GlobalVar.songName == null || GlobalVar.songName.trim().isEmpty())) {
            Log.d("MusicCallback", "skip media write — PLAY with empty title");
        } else {
            if (GlobalVar.MEDIA_INFO_CHAR == null || !bleReadyForWrite()) {
                return;
            }
            prepareCharAndWrite(GlobalVar.MEDIA_INFO_CHAR, CallFrame.musicInfoForVehicle(GlobalVar.songName, GlobalVar.songAlbum, GlobalVar.songArtist, GlobalVar.currentMusicDuration, GlobalVar.currentMusicTotalDuration, GlobalVar.playStatus), true);
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onMetadataChange(String str, int i, String str2, String str3, long j, Bitmap bitmap) {
        int i2;
        this.bitmap = bitmap;
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        if (!GlobalVar.spotifySongOneFlag) {
            GlobalVar.lastSpotifySong = str;
        }
        GlobalVar.currentMusicTotalDuration = (int) (j / 1000);
        if (Objects.equals(str, GlobalVar.songName)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str4 = this.previousPublishedSongName;
        if (str4 != null && !str4.isEmpty() && str.equals(this.previousPublishedSongName) && !str.equals(this.lastPublishedSongName) && jCurrentTimeMillis - this.lastSongTitleChangeAtMs < STALE_TITLE_GUARD_MS) {
            Log.d("BLE_MUSIC", "ignore stale title regression → \"" + str + "\"");
            return;
        }
        this.previousPublishedSongName = GlobalVar.songName != null ? GlobalVar.songName : "";
        GlobalVar.songName = str;
        this.lastPublishedSongName = str;
        this.lastSongTitleChangeAtMs = jCurrentTimeMillis;
        if (str3 != null) {
            GlobalVar.songAlbum = str3;
        }
        if (str2 != null) {
            GlobalVar.songArtist = str2;
        }
        if (ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME)) {
            if (this.handler == null) {
                if (Looper.myLooper() != null) {
                    this.handler = new Handler((Looper) Objects.requireNonNull(Looper.myLooper()));
                } else {
                    this.handler = new Handler(Looper.getMainLooper());
                }
            }
            this.handler.removeCallbacks(this.spotifyNewSongFetch);
            this.handler.postDelayed(this.spotifyNewSongFetch, 5000L);
            ArrayList<Item_song> arrayList = this.spotifyPlaylist;
            if (arrayList != null && arrayList.size() > 1) {
                boolean z = false;
                for (int i3 = 0; i3 <= this.spotifyPlaylist.size() - 1; i3++) {
                    if (Objects.equals(this.spotifyPlaylist.get(i3).getTitle(), str)) {
                        currentTrackNumber = i3;
                        z = true;
                    }
                }
                if (!z) {
                    if (GlobalVar.selectePlaylistSongAck > 0) {
                        i2 = GlobalVar.selectePlaylistSongAck;
                    } else {
                        i2 = GlobalVar.selectedPlaylistSong;
                    }
                    currentTrackNumber = i2;
                }
            }
        }
        scheduleNowPlayingMediaWrite("metadata:" + str);
        if (ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME)) {
            scheduleSpotifyPlaylistResend(str);
            return;
        }
        Log.d("PLAYLIST_DBG", "onMetadataChange: song=" + str + " — playlist send via fetchPlaylist next-queue");
    }

    private void scheduleNowPlayingMediaWrite(final String str) {
        if (this.mediaWriteHandler == null) {
            this.mediaWriteHandler = new Handler(Looper.getMainLooper());
        }
        Runnable runnable = this.pendingMediaWriteRunnable;
        if (runnable != null) {
            this.mediaWriteHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleNowPlayingMediaWrite$0(str);
            }
        };
        this.pendingMediaWriteRunnable = runnable2;
        this.mediaWriteHandler.postDelayed(runnable2, MEDIA_TITLE_DEBOUNCE_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleNowPlayingMediaWrite$0(String str) {
        this.pendingMediaWriteRunnable = null;
        pushNowPlayingMediaFrame(str);
    }

    private void pushNowPlayingMediaFrame(String str) {
        try {
            if (bleReadyForWrite() && GlobalVar.MEDIA_INFO_CHAR != null) {
                prepareCharAndWrite(GlobalVar.MEDIA_INFO_CHAR, CallFrame.musicInfoForVehicle(GlobalVar.songName, GlobalVar.songAlbum, GlobalVar.songArtist, 0, GlobalVar.currentMusicTotalDuration, GlobalVar.playStatus), true);
                this.lastProgressMediaWriteAtMs = System.currentTimeMillis();
                Log.d("BLE_MUSIC", "MEDIA title write reason=" + str + " song=\"" + GlobalVar.songName + "\"");
            }
        } catch (Exception e) {
            Log.e("BLE_MUSIC", "pushNowPlayingMediaFrame failed", e);
        }
    }

    private void scheduleSpotifyPlaylistResend(final String str) {
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        Runnable runnable = this.pendingSpotifyPlaylistResend;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleSpotifyPlaylistResend$1(str);
            }
        };
        this.pendingSpotifyPlaylistResend = runnable2;
        this.handler.postDelayed(runnable2, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleSpotifyPlaylistResend$1(String str) {
        this.pendingSpotifyPlaylistResend = null;
        try {
            if (currentTrackNumber == 0) {
                GlobalVar.userChangePlaylistCounter++;
            }
            Log.d("PLAYLIST_DBG", "onMetadataChange(debounced): song=" + str + " ack=" + GlobalVar.pagePlaylistAck + " → sendPlaylistPage");
            sendPlaylistPage(Math.max(GlobalVar.pagePlaylistAck, 1));
        } catch (Exception e) {
            Log.e("PLAYLIST_DBG", "spotify playlist resend failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() {
        if (currentTrackNumber > 1) {
            GlobalVar.LAST_SHUFFLE_STATUS = GlobalVar.SHUFFLE_STATUS;
            if (MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) {
                try {
                    MainActivity.spotifyAppRemote.getPlayerApi().setShuffle(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (NavApplication.activity instanceof MainActivity) {
                ((MainActivity) NavApplication.activity).connectToASpotifyRemot();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onSpotifySongChange();
                }
            }, 1000L);
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onQueueItemChange(ArrayList<Item_song> arrayList, String str) {
        if (str.equals(SPOTIFY_PACKAGE_NAME)) {
            return;
        }
        songsList = new ArrayList<>(arrayList.subList(0, Math.min(195, arrayList.size())));
        GlobalVar.userChangePlaylistCounter++;
        currentTrackNumber = 0;
        handlePlaylist();
    }

    private static int cappedPlaylistSize(List<?> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return Math.min(6, list.size());
    }

    private void sendAllPlaylistPages() {
        final int iMax = Math.max(GlobalVar.pagePlaylistAck, 1);
        sendPlaylistPage(1);
        if (totalNumberOfPages < 2) {
            return;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        Runnable runnable = this.pendingPage2Send;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendAllPlaylistPages$3(iMax);
            }
        };
        this.pendingPage2Send = runnable2;
        this.handler.postDelayed(runnable2, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendAllPlaylistPages$3(int i) {
        this.pendingPage2Send = null;
        try {
            try {
                sendPlaylistPage(2);
            } catch (Exception e) {
                Log.e("PLAYLIST_DBG", "page2 send failed", e);
            }
        } finally {
            GlobalVar.pagePlaylistAck = Math.min(i, totalNumberOfPages);
        }
    }

    public void handlePlaylist() {
        try {
            GlobalVar.userChangePlaylistCounter++;
            ArrayList<Item_song> arrayList = songsList;
            if (arrayList != null && !arrayList.isEmpty()) {
                int i = 0;
                currentTrackNumber = 0;
                GlobalVar.selectePlaylistSongAck = 0;
                int iCappedPlaylistSize = cappedPlaylistSize(songsList);
                totalsongs = iCappedPlaylistSize;
                if (iCappedPlaylistSize > 5) {
                    i = 2;
                } else if (iCappedPlaylistSize > 0) {
                    i = 1;
                }
                totalNumberOfPages = i;
                GlobalVar.pagePlaylistAck = 1;
                Log.d("PLAYLIST_DBG", "handlePlaylist cap=" + totalsongs + " pages=" + totalNumberOfPages);
                sendAllPlaylistPages();
                return;
            }
            Log.w("PLAYLIST_DBG", "handlePlaylist: empty songsList");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendPlaylistPage(int i) {
        ArrayList<Item_song> arrayList;
        int i2;
        ArrayList<Item_song> arrayList2;
        Log.d("PLAYLIST_DBG", "sendPlaylistPage(" + i + ") ack=" + GlobalVar.pagePlaylistAck + " olderAck=" + GlobalVar.olderplaylistAck + " caller=" + new Throwable().getStackTrace()[1].getMethodName());
        if (ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME) && (arrayList2 = this.spotifyPlaylist) != null && !arrayList2.isEmpty()) {
            arrayList = this.spotifyPlaylist;
        } else {
            ArrayList<Item_song> arrayList3 = songsList;
            if (arrayList3 == null || arrayList3.isEmpty()) {
                return;
            } else {
                arrayList = songsList;
            }
        }
        int iCappedPlaylistSize = cappedPlaylistSize(arrayList);
        if (iCappedPlaylistSize <= 0) {
            return;
        }
        totalsongs = iCappedPlaylistSize;
        int i3 = 0;
        int i4 = iCappedPlaylistSize > 5 ? 2 : iCappedPlaylistSize > 0 ? 1 : 0;
        totalNumberOfPages = i4;
        int iMax = Math.max(1, Math.min(i, Math.max(i4, 1)));
        try {
            this.prevPage.clear();
            this.currentPage.clear();
            this.nextPage.clear();
            int i5 = (iMax - 1) * 5;
            int iMin = Math.min(i5 + 5, iCappedPlaylistSize);
            while (i5 < iMin) {
                this.prevPage.add(arrayList.get(i5));
                i5++;
            }
            if (this.prevPage.isEmpty()) {
                Log.w("PLAYLIST_DBG", "sendPlaylistPage: empty page=" + iMax + " capped=" + iCappedPlaylistSize);
                return;
            }
            GlobalVar.pagePlaylistAck = iMax;
            String str = GlobalVar.songName;
            if (str != null && !str.trim().isEmpty()) {
                for (0; i2 < this.prevPage.size(); i2 + 1) {
                    i2 = (MediaSessionListener.titlesEqual(this.prevPage.get(i2).getTitle(), str) || MediaSessionListener.titlesLooselyMatch(this.prevPage.get(i2).getTitle(), str)) ? 0 : i2 + 1;
                    i3 = i2;
                }
            }
            currentTrackNumber = i3;
            GlobalVar.selectePlaylistSongAck = i3;
            Log.d("PLAYLIST_DBG", "playlistPage page=" + iMax + RemoteSettings.FORWARD_SLASH_STRING + totalNumberOfPages + " totalSongs=" + totalsongs + " songs=" + pageWindowTitles(this.prevPage) + " track#=" + currentTrackNumber);
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            this.r.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String pageWindowTitles(ArrayList<Item_song> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            String title = arrayList.get(i).getTitle();
            if (title == null) {
                title = "?";
            }
            sb.append(title);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4() {
        sendSinglePlaylistPacket();
        GlobalVar.newPlaylistAck = GlobalVar.newPlaylistReq;
    }

    private void clearClusterMediaAndPlaylist(String str) {
        Log.d("PLAYLIST_DBG", "clearClusterMediaAndPlaylist: " + str);
        try {
            ArrayList<Item_song> arrayList = songsList;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<Item_song> arrayList2 = this.spotifyPlaylist;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.prevPage.clear();
            this.currentPage.clear();
            this.nextPage.clear();
            totalsongs = 0;
            totalNumberOfPages = 0;
            currentTrackNumber = 0;
            GlobalVar.songName = "";
            GlobalVar.songAlbum = "";
            GlobalVar.songArtist = "";
            GlobalVar.currentMusicDuration = 0;
            GlobalVar.currentMusicTotalDuration = 0;
            GlobalVar.playStatus = PlayStatus.NONE;
            GlobalVar.userChangePlaylistCounter++;
            GlobalVar.pagePlaylistAck = 1;
            if (!bleReadyForWrite()) {
                Log.w("PLAYLIST_DBG", "clearClusterMediaAndPlaylist: BLE not ready — local state cleared only");
                return;
            }
            if (GlobalVar.PLAYLIST_INFO_CHAR != null) {
                prepareCharAndWrite(GlobalVar.PLAYLIST_INFO_CHAR, CallFrame.resetPlaylist(), false);
            }
            if (GlobalVar.MEDIA_INFO_CHAR != null) {
                prepareCharAndWrite(GlobalVar.MEDIA_INFO_CHAR, CallFrame.musicInfoForVehicle("", "", "", 0, 0, PlayStatus.NONE), true);
                Log.d("PLAYLIST_DBG", "MEDIA clear sent — byte104 PlayerStatus=0 (None) reason=" + str);
            }
        } catch (Exception e) {
            Log.e("PLAYLIST_DBG", "clearClusterMediaAndPlaylist failed", e);
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onMusicAppKilled() {
        Runnable runnable;
        try {
            Handler handler = this.sessionClearHandler;
            if (handler != null && (runnable = this.pendingClearRunnable) != null) {
                handler.removeCallbacks(runnable);
                this.pendingClearRunnable = null;
            }
        } catch (Exception unused) {
        }
        clearClusterMediaAndPlaylist("musicAppKilled:" + ACTIVE_PACKAGE_NAME);
        ACTIVE_PACKAGE_NAME = "";
        try {
            if (BleFeatures.getInstance().spotifySessionCallback != null) {
                BleFeatures.getInstance().spotifySessionCallback.onSession(false);
            }
        } catch (Exception unused2) {
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onCurrentSessionDestroyed() {
        final String str = ACTIVE_PACKAGE_NAME;
        if (this.sessionClearHandler == null) {
            this.sessionClearHandler = new Handler(Looper.getMainLooper());
        }
        Runnable runnable = this.pendingClearRunnable;
        if (runnable != null) {
            this.sessionClearHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCurrentSessionDestroyed$5(str);
            }
        };
        this.pendingClearRunnable = runnable2;
        this.sessionClearHandler.postDelayed(runnable2, 350L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCurrentSessionDestroyed$5(String str) {
        try {
            try {
                Log.d("PLAYLIST_DBG", "session destroyed settled — clearing cluster ui was=" + str);
                clearClusterMediaAndPlaylist("sessionDestroyed:" + str);
                ACTIVE_PACKAGE_NAME = "";
                try {
                    BleFeatures.getInstance().spotifySessionCallback.onSession(false);
                } catch (Exception unused) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.pendingClearRunnable = null;
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onActiveSessionFound(Context context) {
        ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(3);
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onCurrentPositionChange(int i, Long l) {
        try {
            GlobalVar.currentMusicDuration = l.longValue() < 1000 ? 0 : (int) (l.longValue() / 1000);
            int i2 = GlobalVar.currentMusicTotalDuration == 0 ? GlobalVar.inbuiltMusicTotalDuration : GlobalVar.currentMusicTotalDuration;
            if (this.pendingMediaWriteRunnable != null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastProgressMediaWriteAtMs >= 1000 && bleReadyForWrite() && GlobalVar.MEDIA_INFO_CHAR != null) {
                prepareCharAndWrite(GlobalVar.MEDIA_INFO_CHAR, CallFrame.musicInfoForVehicle(GlobalVar.songName, GlobalVar.songAlbum, GlobalVar.songArtist, GlobalVar.currentMusicDuration, i2, GlobalVar.playStatus), false);
                this.lastProgressMediaWriteAtMs = jCurrentTimeMillis;
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onSessionReady(final String str) {
        Runnable runnable;
        String strResolveTrackTitle;
        String str2;
        Runnable runnable2;
        try {
            if (!Objects.equals(ACTIVE_PACKAGE_NAME, str) && (str2 = ACTIVE_PACKAGE_NAME) != null && !str2.isEmpty()) {
                try {
                    Handler handler = this.sessionClearHandler;
                    if (handler != null && (runnable2 = this.pendingClearRunnable) != null) {
                        handler.removeCallbacks(runnable2);
                        this.pendingClearRunnable = null;
                    }
                } catch (Exception unused) {
                }
                clearClusterMediaAndPlaylist("packageSwitch:" + ACTIVE_PACKAGE_NAME + "→" + str);
            } else {
                try {
                    Handler handler2 = this.sessionClearHandler;
                    if (handler2 != null && (runnable = this.pendingClearRunnable) != null) {
                        handler2.removeCallbacks(runnable);
                        this.pendingClearRunnable = null;
                    }
                } catch (Exception unused2) {
                }
            }
            ACTIVE_PACKAGE_NAME = str;
            if (BleFeatures.getInstance().spotifySessionCallback != null) {
                BleFeatures.getInstance().spotifySessionCallback.onSession(ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME));
            }
            try {
                MediaSessionListener mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
                if (mediaSessionListener != null && mediaSessionListener.mController != null && mediaSessionListener.mController.getMetadata() != null && (strResolveTrackTitle = MediaSessionListener.resolveTrackTitle(mediaSessionListener.mController.getMetadata())) != null && !strResolveTrackTitle.isEmpty()) {
                    GlobalVar.songName = strResolveTrackTitle;
                }
            } catch (Exception unused3) {
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSessionReady$6(str);
                }
            }, 700L);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    MusicCallbackImpl.lambda$onSessionReady$7(str);
                }
            }, 2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSessionReady$6(String str) {
        try {
            if (Objects.equals(ACTIVE_PACKAGE_NAME, str)) {
                MediaSessionListener mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
                if (ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME)) {
                    onFetchSpotifyPlaylist();
                    ArrayList<Item_song> arrayList = this.spotifyPlaylist;
                    if (arrayList == null || arrayList.isEmpty()) {
                        Log.d("PLAYLIST_DBG", "Spotify queue empty — leave playlist cleared");
                        if (!bleReadyForWrite() || GlobalVar.PLAYLIST_INFO_CHAR == null) {
                            return;
                        }
                        GlobalVar.userChangePlaylistCounter++;
                        prepareCharAndWrite(GlobalVar.PLAYLIST_INFO_CHAR, CallFrame.resetPlaylist(), false);
                        return;
                    }
                    return;
                }
                if (mediaSessionListener != null) {
                    mediaSessionListener.fetchPlaylist();
                    ArrayList<Item_song> arrayList2 = songsList;
                    if ((arrayList2 != null && !arrayList2.isEmpty()) || GlobalVar.songName == null || GlobalVar.songName.isEmpty()) {
                        return;
                    }
                    ArrayList<Item_song> arrayList3 = new ArrayList<>();
                    arrayList3.add(new Item_song(GlobalVar.songName, GlobalVar.songArtist != null ? GlobalVar.songArtist : "", 0L, null, null, ""));
                    onQueueItemChange(arrayList3, str);
                }
            }
        } catch (Exception e) {
            Log.e("PLAYLIST_DBG", "delayed playlist refresh failed", e);
        }
    }

    static /* synthetic */ void lambda$onSessionReady$7(String str) {
        MediaSessionListener mediaSessionListener;
        try {
            if (Objects.equals(ACTIVE_PACKAGE_NAME, str) && !ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME)) {
                ArrayList<Item_song> arrayList = songsList;
                if ((arrayList == null || arrayList.isEmpty()) && (mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener) != null) {
                    Log.d("PLAYLIST_DBG", "retry fetchPlaylist for " + str);
                    mediaSessionListener.fetchPlaylist();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void sendSinglePlaylistPacket() {
        ArrayList arrayList = new ArrayList();
        for (Item_song item_song : this.prevPage) {
            try {
                arrayList.add(new SongInfo(item_song.getTitle(), item_song.getSubtitle()));
            } catch (Exception unused) {
            }
        }
        if (arrayList.isEmpty()) {
            Log.w("PLAYLIST_DBG", "sendSinglePlaylistPacket: no songs — skip");
            return;
        }
        byte[] bArrPlaylist = CallFrame.playlist(arrayList, 3);
        StringBuilder sb = new StringBuilder("sendSinglePlaylistPacket count=");
        sb.append(arrayList.size());
        sb.append(" bleReady=");
        sb.append(bleReadyForWrite());
        sb.append(" char=");
        sb.append(GlobalVar.PLAYLIST_INFO_CHAR != null);
        Log.d("PLAYLIST_DBG", sb.toString());
        if (!bleReadyForWrite() || GlobalVar.PLAYLIST_INFO_CHAR == null) {
            return;
        }
        prepareCharAndWrite(GlobalVar.PLAYLIST_INFO_CHAR, bArrPlaylist, false);
    }

    private void sendMusicListPage(int i) {
        ArrayList arrayList = new ArrayList();
        if (i != 1) {
            if (i == 2) {
                for (Item_song item_song : this.currentPage) {
                    try {
                        arrayList.add(new SongInfo(item_song.getTitle(), item_song.getSubtitle()));
                    } catch (Exception unused) {
                    }
                }
            } else if (i == 3) {
                for (Item_song item_song2 : this.nextPage) {
                    try {
                        arrayList.add(new SongInfo(item_song2.getTitle(), item_song2.getSubtitle()));
                    } catch (Exception unused2) {
                    }
                }
            }
        } else if (!this.prevPage.isEmpty()) {
            for (Item_song item_song3 : this.prevPage) {
                try {
                    arrayList.add(new SongInfo(item_song3.getTitle(), item_song3.getSubtitle()));
                } catch (Exception unused3) {
                }
            }
        }
        byte[] bArrPlaylist = CallFrame.playlist(arrayList, i);
        if (!bleReadyForWrite() || GlobalVar.PLAYLIST_INFO_CHAR == null) {
            return;
        }
        prepareCharAndWrite(GlobalVar.PLAYLIST_INFO_CHAR, bArrPlaylist, false);
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onSongSelected(int i) {
        boolean zPlaySpotifySongURI;
        Log.d("MusicCallback", "onSongSelected: activePackage=" + ACTIVE_PACKAGE_NAME + " requestedIndex=" + i);
        String str = ACTIVE_PACKAGE_NAME;
        str.hashCode();
        switch (str) {
            case "com.spotify.music":
                try {
                    Log.d("MusicCallback", "onSongSelected: spotifyAppRemoteConnected=" + (MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) + " spotifyPlaylistUri=" + MainActivity.spotifyPlaylistUri);
                    zPlaySpotifySongURI = MainActivity.playSpotifySongURI(i);
                    break;
                } catch (Exception e) {
                    Log.e("MusicCallback", "onSongSelected: Spotify App Remote skip failed", e);
                    zPlaySpotifySongURI = false;
                }
                if (!zPlaySpotifySongURI) {
                    Log.d("MusicCallback", "onSongSelected: App Remote skip unsuccessful, falling back to playSongFromQueue");
                    try {
                        ArrayList<Item_song> arrayList = this.spotifyPlaylist;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= this.spotifyPlaylist.size()) {
                                i = this.spotifyPlaylist.size() - 1;
                            }
                            long id = this.spotifyPlaylist.get(i).getId();
                            Log.d("MusicCallback", "onSongSelected: Spotify fallback skipToQueueItem idx=" + i + " queueItemId=" + id + " spotifyPlaylistSize=" + this.spotifyPlaylist.size());
                            if (BleFeatures.getInstance().mMediaSessionListener != null && BleFeatures.getInstance().mMediaSessionListener.mController != null) {
                                BleFeatures.getInstance().mMediaSessionListener.mController.getTransportControls().skipToQueueItem(id);
                            } else {
                                BleFeatures.getInstance().mMediaSessionListener.playSongFromQueue(i);
                            }
                        } else {
                            BleFeatures.getInstance().mMediaSessionListener.playSongFromQueue(i);
                        }
                    } catch (Exception e2) {
                        Log.e("MusicCallback", "onSongSelected: fallback playSongFromQueue failed", e2);
                    }
                    break;
                }
                break;
            case "com.bajajconnect":
            case "com.gaana":
                break;
            default:
                ArrayList<Item_song> arrayList2 = songsList;
                if (arrayList2 != null && i < arrayList2.size()) {
                    BleFeatures.getInstance().mMediaSessionListener.playSongFromQueue(i);
                    break;
                }
                break;
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onTrackListRequested(int i) {
        if (ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME)) {
            if (!this.spotifyPlaylist.isEmpty()) {
                int iCappedPlaylistSize = cappedPlaylistSize(this.spotifyPlaylist);
                totalsongs = iCappedPlaylistSize;
                totalNumberOfPages = iCappedPlaylistSize <= 5 ? iCappedPlaylistSize > 0 ? 1 : 0 : 2;
                for (int i2 = 0; i2 < iCappedPlaylistSize; i2++) {
                    if (Objects.equals(this.spotifyPlaylist.get(i2).getTitle(), GlobalVar.songName)) {
                        currentTrackNumber = i2 % 5;
                    }
                }
                sendPlaylistPage(i);
                return;
            }
            if (!bleReadyForWrite() || GlobalVar.PLAYLIST_INFO_CHAR == null) {
                return;
            }
            BleService.prepareCharAndWrite(GlobalVar.PLAYLIST_INFO_CHAR, CallFrame.resetPlaylist());
            return;
        }
        ArrayList<Item_song> arrayList = songsList;
        if (arrayList == null || arrayList.isEmpty()) {
            try {
                MediaSessionListener mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
                if (mediaSessionListener != null) {
                    mediaSessionListener.fetchPlaylist();
                }
            } catch (Exception unused) {
            }
        }
        ArrayList<Item_song> arrayList2 = songsList;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int iCappedPlaylistSize2 = cappedPlaylistSize(songsList);
            totalsongs = iCappedPlaylistSize2;
            totalNumberOfPages = iCappedPlaylistSize2 <= 5 ? iCappedPlaylistSize2 > 0 ? 1 : 0 : 2;
            currentTrackNumber = resolveCurrentTrackIndex(songsList) % 5;
            sendPlaylistPage(i);
            return;
        }
        Log.w("PLAYLIST_DBG", "onTrackListRequested: still empty — sending reset");
        if (!bleReadyForWrite() || GlobalVar.PLAYLIST_INFO_CHAR == null) {
            return;
        }
        BleService.prepareCharAndWrite(GlobalVar.PLAYLIST_INFO_CHAR, CallFrame.resetPlaylist());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002e  */
    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onArtworkReady(Bitmap bitmap) {
        boolean z;
        this.bitmap = bitmap;
        try {
            boolean z2 = NavApplication.streamingHandler != null;
            TcpServerService tcpServerService = z2 ? NavApplication.streamingHandler.tcpServerService : null;
            if (z2 && NavApplication.streamingHandler.onTcpReady() && tcpServerService != null) {
                if (tcpServerService.isTcpSocketReady()) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            StringBuilder sb = new StringBuilder("onArtworkReady: streamingHandler=");
            sb.append(z2);
            sb.append(" tcpServerService=");
            sb.append(tcpServerService != null);
            sb.append(" tcpReady=");
            sb.append(z);
            sb.append(" artPresent=");
            sb.append(bitmap != null);
            Log.d("MusicCallback", sb.toString());
            if (bitmap == null) {
                return;
            }
            if (tcpServerService != null) {
                new Thread(new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MusicCallbackImpl.lambda$onArtworkReady$8();
                    }
                }).start();
                return;
            }
            Log.d("MusicCallback", "onArtworkReady: tcp service not available yet, scheduling retries");
            Handler handler = new Handler(Looper.getMainLooper());
            for (final int i = 1; i <= 10; i++) {
                handler.postDelayed(new Runnable() { // from class: com.bajajconnect.music.MusicCallbackImpl$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        MusicCallbackImpl.lambda$onArtworkReady$9(i);
                    }
                }, ((long) i) * 500);
            }
        } catch (Exception e) {
            Log.e("MusicCallback", "onArtworkReady exception", e);
        }
    }

    static /* synthetic */ void lambda$onArtworkReady$8() {
        try {
            Log.d("MusicCallback", "calling TcpServerService.sendMusicCover() from onArtworkReady");
            NavApplication.streamingHandler.tcpServerService.sendMusicCover();
            Log.d("MusicCallback", "sendMusicCover: finished call");
        } catch (Exception e) {
            Log.e("MusicCallback", "sendMusicCover failed", e);
        }
    }

    static /* synthetic */ void lambda$onArtworkReady$9(int i) {
        try {
            boolean z = (NavApplication.streamingHandler == null || NavApplication.streamingHandler.tcpServerService == null) ? false : true;
            Log.d("MusicCallback", "retry sendMusicCover attempt=" + i + " ready=" + z);
            if (z) {
                try {
                    NavApplication.streamingHandler.tcpServerService.sendMusicCover();
                    Log.d("MusicCallback", "sendMusicCover: finished call on retry=" + i);
                } catch (Exception e) {
                    Log.e("MusicCallback", "sendMusicCover failed on retry=" + i, e);
                }
            }
        } catch (Exception e2) {
            Log.e("MusicCallback", "retry exception", e2);
        }
    }

    @Override // com.bajajconnect.interfaces.MusicCallback
    public void onFetchSpotifyPlaylist() {
        String string;
        if (ACTIVE_PACKAGE_NAME.equals(SPOTIFY_PACKAGE_NAME)) {
            GlobalVar.userChangePlaylistCounter++;
            try {
                List<MediaSessionCompat.QueueItem> queueItemsFromController = BleFeatures.getInstance().mMediaSessionListener.getQueueItemsFromController();
                this.spotifyPlaylist.clear();
                if (queueItemsFromController != null) {
                    for (int i = 0; i < Math.min(195, queueItemsFromController.size()); i++) {
                        MediaDescriptionCompat description = queueItemsFromController.get(i).getDescription();
                        long queueId = queueItemsFromController.get(i).getQueueId();
                        Uri mediaUri = queueItemsFromController.get(i).getDescription().getMediaUri();
                        Bundle extras = queueItemsFromController.get(i).getDescription().getExtras();
                        String mediaId = queueItemsFromController.get(i).getDescription().getMediaId();
                        if (description.getTitle() != null) {
                            String string2 = description.getTitle().toString();
                            if (description.getSubtitle() == null) {
                                string = "";
                            } else {
                                string = description.getSubtitle().toString();
                            }
                            this.spotifyPlaylist.add(new Item_song(string2, string, queueId, mediaUri, extras, mediaId));
                        }
                    }
                    int iCappedPlaylistSize = cappedPlaylistSize(this.spotifyPlaylist);
                    totalsongs = iCappedPlaylistSize;
                    totalNumberOfPages = iCappedPlaylistSize > 5 ? 2 : iCappedPlaylistSize > 0 ? 1 : 0;
                    if (!queueItemsFromController.isEmpty()) {
                        int iCappedPlaylistSize2 = cappedPlaylistSize(this.spotifyPlaylist);
                        int i2 = 0;
                        while (true) {
                            if (i2 < iCappedPlaylistSize2) {
                                if (Objects.equals(this.spotifyPlaylist.get(i2).getTitle(), GlobalVar.lastSpotifySong)) {
                                    int i3 = i2 % 5;
                                    currentTrackNumber = i3;
                                    GlobalVar.selectePlaylistSongAck = i3;
                                    break;
                                }
                                i2++;
                            } else {
                                currentTrackNumber = 0;
                                GlobalVar.selectePlaylistSongAck = 0;
                                break;
                            }
                        }
                    }
                    if (GlobalVar.LAST_SHUFFLE_STATUS == 1 || GlobalVar.LAST_SHUFFLE_STATUS == 2) {
                        try {
                            if (MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) {
                                MainActivity.spotifyAppRemote.getPlayerApi().setShuffle(true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (GlobalVar.pagePlaylistAck == 0) {
                        GlobalVar.pagePlaylistAck = 1;
                    }
                    Log.d("PLAYLIST_DBG", "onFetchSpotifyPlaylist: queueSize=" + this.spotifyPlaylist.size() + " cap=" + totalsongs + " pages=" + totalNumberOfPages + " → sendAllPlaylistPages");
                    sendAllPlaylistPages();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onSpotifySongChange() {
        List<MediaSessionCompat.QueueItem> queueItemsFromController = BleFeatures.getInstance().mMediaSessionListener.getQueueItemsFromController();
        if (queueItemsFromController == null || queueItemsFromController.isEmpty() || this.spotifyPlaylist.size() <= 1) {
            return;
        }
        ArrayList<Item_song> arrayList = this.spotifyPlaylist;
        String title = arrayList.get(arrayList.size() - 1).getTitle();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < queueItemsFromController.size(); i++) {
            MediaSessionCompat.QueueItem queueItem = queueItemsFromController.get(i);
            CharSequence title2 = (queueItem == null || queueItem.getDescription() == null) ? null : queueItem.getDescription().getTitle();
            if (title2 != null) {
                String string = title2.toString();
                if (z) {
                    this.spotifyPlaylist.add(new Item_song(string, "", i, null, null, null));
                    z2 = true;
                }
                if (Objects.equals(title, string)) {
                    z = true;
                }
            }
        }
        if ((GlobalVar.LAST_SHUFFLE_STATUS == 1 || GlobalVar.LAST_SHUFFLE_STATUS == 2) && MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) {
            try {
                MainActivity.spotifyAppRemote.getPlayerApi().setShuffle(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (z && z2) {
            GlobalVar.userChangePlaylistCounter++;
            int iCappedPlaylistSize = cappedPlaylistSize(this.spotifyPlaylist);
            if (iCappedPlaylistSize > 1) {
                for (int i2 = 0; i2 < iCappedPlaylistSize; i2++) {
                    if (Objects.equals(this.spotifyPlaylist.get(i2).getTitle(), GlobalVar.songName)) {
                        currentTrackNumber = i2 % 5;
                    }
                }
            }
            totalsongs = iCappedPlaylistSize;
            totalNumberOfPages = iCappedPlaylistSize > 5 ? 2 : iCappedPlaylistSize > 0 ? 1 : 0;
            if (GlobalVar.pagePlaylistAck == 0) {
                GlobalVar.pagePlaylistAck = 1;
            }
            sendAllPlaylistPages();
        }
    }
}
