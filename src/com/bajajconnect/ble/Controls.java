package com.bajajconnect.ble;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.CallLog;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bajajconnect.MainActivity;
import com.bajajconnect.ble.protocol.NewBtProtocolSelector;
import com.bajajconnect.enums.CallState;
import com.bajajconnect.features.VehicleFeature;
import com.bajajconnect.models.AlertModel;
import com.bajajconnect.models.MissedCallModel;
import com.bajajconnect.models.SongInfo;
import com.bajajconnect.music.MediaSessionListener;
import com.bajajconnect.music.MusicCallbackImpl;
import com.bajajconnect.utils.SmsUtil;
import com.bajajconnect.utils.Util;
import com.bajajconnect.variables.GlobalVar;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class Controls {
    private static final long OPPOSITE_SKIP_LOCK_MS = 4000;
    private static final long PLAYLIST_SELECT_LOCK_MS = 10000;
    private static final long SKIP_DEBOUNCE_MS = 2800;
    public static long controlCount;
    private final Context context;
    public byte[] lastData;
    private final TelecomManager telecomManager;
    public int volumeSent;
    private int lastSeenVolumeNibble = -1;
    private int lastDialSource = 0;
    private int lastDialIndex = -1;
    private int lastDialTxn = -1;
    private boolean dialEdgesArmed = false;
    private final Handler dialHandler = new Handler(Looper.getMainLooper());
    private long lastDialConfirmAtMs = 0;
    private long lastControlSeenAtMs = 0;
    private long lastSkipAtMs = 0;
    private long playlistSelectLockUntilMs = 0;
    private int lastSelectPlaylistSongReq = -1;
    private final Object skipLock = new Object();
    private int lastExecutedSkipToNext = Integer.MIN_VALUE;
    private int lastExecutedSkipToPrev = Integer.MIN_VALUE;
    private String lastExecutedSkipDirection = null;

    public Controls(Context context) {
        this.context = context.getApplicationContext();
        this.telecomManager = (TelecomManager) context.getSystemService("telecom");
    }

    public void resetDialEdgeState() {
        this.lastDialSource = 0;
        this.lastDialIndex = -1;
        this.lastDialTxn = -1;
        this.dialEdgesArmed = false;
        this.lastDialConfirmAtMs = 0L;
        this.lastControlSeenAtMs = 0L;
        this.lastData = null;
        this.lastSeenVolumeNibble = -1;
        this.lastSkipAtMs = 0L;
        this.playlistSelectLockUntilMs = 0L;
        this.lastSelectPlaylistSongReq = -1;
        this.lastExecutedSkipToNext = Integer.MIN_VALUE;
        this.lastExecutedSkipToPrev = Integer.MIN_VALUE;
        this.lastExecutedSkipDirection = null;
    }

    public void processData(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str;
        if (bArr.length >= 20) {
            this.lastControlSeenAtMs = System.currentTimeMillis();
            int i8 = ((bArr[0] & 255) >> 6) & 3;
            int iMax = Math.max(0, Math.min(bArr.length > 16 ? bArr[16] & 255 : 0, 4));
            int i9 = bArr.length > 17 ? bArr[17] & 255 : 0;
            byte[] bArr2 = this.lastData;
            if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
                this.lastData = Arrays.copyOf(bArr, bArr.length);
                int iBitExtracted = Util.bitExtracted(bArr[0], 4, 1);
                byte b = bArr[1];
                byte b2 = bArr[2];
                byte b3 = bArr[3];
                byte b4 = bArr[5];
                byte b5 = bArr[6];
                byte b6 = bArr[7];
                byte b7 = bArr[8];
                byte b8 = bArr[9];
                byte b9 = bArr[10];
                byte b10 = bArr[11];
                byte b11 = bArr[12];
                byte b12 = bArr[13];
                int iBitExtracted2 = Util.bitExtracted(bArr[4], 6, 1);
                int i10 = i9;
                int iBitExtracted3 = Util.bitExtracted(bArr[4], 8, 7);
                int i11 = bArr[14] & 255;
                int i12 = bArr[15] & 255;
                if (controlCount == 0) {
                    GlobalVar.volumeToSet = iBitExtracted;
                    GlobalVar.callAccept = 0;
                    GlobalVar.callReject = 0;
                    GlobalVar.callRejectWithSms = 0;
                    GlobalVar.pagePlaylist = iBitExtracted2;
                    this.lastSelectPlaylistSongReq = i11;
                    GlobalVar.selectedPlaylistSong = i12;
                    GlobalVar.newPlaylistReq = iBitExtracted3;
                    GlobalVar.takeMeHome = b4;
                    GlobalVar.resumeSong = b5;
                    GlobalVar.pauseSong = b6;
                    GlobalVar.skipToNext = b7;
                    GlobalVar.skipToPrev = b8;
                    GlobalVar.stopSong = b9;
                    GlobalVar.missedCallGet = b10;
                    GlobalVar.alertGet = b11;
                    GlobalVar.launchMediaPlayer = b12;
                    this.lastDialSource = 0;
                    this.lastDialIndex = -1;
                    i2 = i10;
                    this.lastDialTxn = i2;
                    this.dialEdgesArmed = i8 == 0;
                    StringBuilder sb = new StringBuilder("bootstrap: ignore sticky dial source=");
                    i = i8;
                    sb.append(i);
                    sb.append(" index=");
                    i3 = iMax;
                    sb.append(i3);
                    sb.append(" txn=");
                    sb.append(i2);
                    sb.append(" armed=");
                    sb.append(this.dialEdgesArmed);
                    Log.d("BLE_ACTION", sb.toString());
                } else {
                    i = i8;
                    i2 = i10;
                    i3 = iMax;
                }
                controlCount++;
                if (iBitExtracted != this.lastSeenVolumeNibble) {
                    this.lastSeenVolumeNibble = iBitExtracted;
                    if (!NewBtProtocolSelector.useNewGeneralProtocol() && iBitExtracted == 0 && GlobalVar.volumeToSet > 1) {
                        Log.i("Controls", "ignore legacy CONTROL volume=0 pulse (keep tenths=" + GlobalVar.volumeToSet + " byte0=0x" + Integer.toHexString(bArr[0] & 255) + ")");
                    } else if (iBitExtracted != GlobalVar.volumeToSet) {
                        GlobalVar.volumeToSet = iBitExtracted;
                        setVolume(iBitExtracted, this.context);
                        GlobalVar.volumeToSetAck = iBitExtracted;
                    }
                }
                if (b != GlobalVar.callAccept) {
                    GlobalVar.callAccept = b;
                    GlobalVar.callAcceptAck = b;
                    aCallP();
                }
                if (b2 != GlobalVar.callReject) {
                    GlobalVar.callReject = b2;
                    GlobalVar.callRejectAck = b2;
                    String str2 = GlobalVar.callerNumber;
                    String str3 = GlobalVar.callRejectMsg;
                    i4 = i3;
                    boolean z = GlobalVar.callState == CallState.INCOMING_CALL;
                    rejectCallP();
                    if (z) {
                        SmsUtil.sendAutoReplyIfConfigured(this.context, str2, str3, "clusterReject");
                    }
                } else {
                    i4 = i3;
                }
                if (b3 != GlobalVar.callRejectWithSms) {
                    GlobalVar.callRejectWithSms = b3;
                    GlobalVar.callRejectWithSmsAck = b3;
                    if (GlobalVar.callState == CallState.INCOMING_CALL) {
                        String str4 = GlobalVar.callerNumber;
                        String str5 = GlobalVar.callRejectMsg;
                        rejectCallP();
                        if (str5 != null && !str5.trim().isEmpty()) {
                            SmsUtil.sendAutoReplyIfConfigured(this.context, str4, str5, "clusterRejectWithSms");
                        } else {
                            SmsUtil.sendSMS(this.context, str4, "");
                        }
                    }
                }
                if (b4 != GlobalVar.takeMeHome) {
                    GlobalVar.takeMeHome = b4;
                    GlobalVar.takeMeHomeAck = b4;
                    handleTakeMeHome();
                }
                if (b5 != GlobalVar.resumeSong) {
                    GlobalVar.resumeSong = b5;
                    i5 = 1;
                    GlobalVar.resumeSongAck++;
                    playSong();
                } else {
                    i5 = 1;
                }
                if (b6 != GlobalVar.pauseSong) {
                    GlobalVar.pauseSong = b6;
                    GlobalVar.pauseSongAck += i5;
                    pause();
                }
                boolean z2 = b7 != GlobalVar.skipToNext;
                boolean z3 = b8 != GlobalVar.skipToPrev;
                if (z2 && z3) {
                    Log.w("BLE_MUSIC", "skip next+prev both changed in one frame next=" + ((int) b7) + " prev=" + ((int) b8) + " — executing NEXT only");
                    GlobalVar.skipToNext = b7;
                    GlobalVar.skipToNextAck = b7;
                    GlobalVar.skipToPrev = b8;
                    GlobalVar.skipToPrevAck = b8;
                    if (shouldAcceptSkip("next", b7)) {
                        this.lastExecutedSkipToNext = b7;
                        Log.d("BLE_MUSIC", "skipToNext accepted req=" + ((int) b7));
                        playNext();
                    } else {
                        extendPlaylistSelectLock();
                        Log.d("BLE_MUSIC", "skipToNext ignored (debounce/dup) req=" + ((int) b7));
                    }
                } else {
                    if (z2) {
                        GlobalVar.skipToNext = b7;
                        GlobalVar.skipToNextAck = b7;
                        if (shouldAcceptSkip("next", b7)) {
                            this.lastExecutedSkipToNext = b7;
                            Log.d("BLE_MUSIC", "skipToNext accepted req=" + ((int) b7));
                            playNext();
                        } else {
                            extendPlaylistSelectLock();
                            Log.d("BLE_MUSIC", "skipToNext ignored (debounce/dup/lock) req=" + ((int) b7) + " lastExec=" + this.lastExecutedSkipToNext);
                        }
                    }
                    if (z3) {
                        GlobalVar.skipToPrev = b8;
                        GlobalVar.skipToPrevAck = b8;
                        if (shouldAcceptSkip("prev", b8)) {
                            this.lastExecutedSkipToPrev = b8;
                            Log.d("BLE_MUSIC", "skipToPrev accepted req=" + ((int) b8));
                            playPrev();
                        } else {
                            extendPlaylistSelectLock();
                            Log.d("BLE_MUSIC", "skipToPrev ignored (debounce/dup/lock) req=" + ((int) b8));
                        }
                    }
                }
                if (b9 != GlobalVar.stopSong) {
                    GlobalVar.stopSong = b9;
                    i6 = 1;
                    GlobalVar.stopSongAck++;
                } else {
                    i6 = 1;
                }
                if (b12 != GlobalVar.launchMediaPlayer) {
                    GlobalVar.launchMediaPlayerAck += i6;
                }
                if (b10 != GlobalVar.missedCallGet) {
                    GlobalVar.missedCallGet = b10;
                    sendMissedCall();
                }
                if (b11 != GlobalVar.alertGet) {
                    GlobalVar.alertGet = b11;
                    sendAlert();
                }
                try {
                    boolean zIsEnabledFor = VehicleFeature.BLE_FAV_RECENT_CALLS.isEnabledFor(BleFeatures.getInstance().modelCode);
                    if (i == 0) {
                        if (!this.dialEdgesArmed) {
                            this.dialEdgesArmed = true;
                            Log.d("BLE_ACTION", "dial edges armed (observed NoDial)");
                        }
                        this.lastDialSource = 0;
                        this.lastDialIndex = -1;
                    } else {
                        long j = controlCount;
                        if (j > 1) {
                            int i13 = this.lastDialTxn;
                            boolean z4 = i13 >= 0 && i2 != i13;
                            if (this.dialEdgesArmed) {
                                int i14 = i4;
                                boolean z5 = true;
                                int i15 = this.lastDialSource;
                                if (i15 != 0 || i == 0) {
                                    z5 = false;
                                }
                                if (z5 || z4) {
                                    StringBuilder sb2 = new StringBuilder("ACTION/Dial request received: source=");
                                    sb2.append(i);
                                    sb2.append(" index=");
                                    sb2.append(i14);
                                    sb2.append(" txn=");
                                    sb2.append(i2);
                                    if (z5) {
                                        str = " (rising edge from NoDial)";
                                    } else {
                                        str = " (txn confirm)";
                                    }
                                    sb2.append(str);
                                    Log.d("BLE_ACTION", sb2.toString());
                                    this.lastDialTxn = i2;
                                    this.lastDialSource = i;
                                    this.lastDialIndex = i14;
                                    performDialFromCluster(i, i14, zIsEnabledFor);
                                } else if (i != i15 || i14 != this.lastDialIndex) {
                                    Log.d("BLE_ACTION", "Dial highlight only (no dial): source=" + i + " index=" + i14 + " prevSource=" + this.lastDialSource + " prevIndex=" + this.lastDialIndex);
                                    this.lastDialSource = i;
                                    this.lastDialIndex = i14;
                                }
                            } else if (z4) {
                                this.dialEdgesArmed = true;
                                this.lastDialTxn = i2;
                                this.lastDialSource = i;
                                int i16 = i4;
                                this.lastDialIndex = i16;
                                Log.d("BLE_ACTION", "ACTION/Dial via txn while unarmed: source=" + i + " index=" + i16 + " txn=" + i2);
                                performDialFromCluster(i, i16, zIsEnabledFor);
                            } else {
                                int i17 = i4;
                                if (j >= 3) {
                                    this.dialEdgesArmed = true;
                                    this.lastDialSource = i;
                                    this.lastDialIndex = i17;
                                    this.lastDialTxn = i2;
                                    Log.d("BLE_ACTION", "dial edges armed after sticky settle source=" + i + " index=" + i17);
                                } else {
                                    Log.d("BLE_ACTION", "dial not armed yet — ignore sticky source=" + i + " index=" + i17 + " txn=" + i2);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.e("BLE_ACTION", "Error processing ACTION/Dial request: " + e.getMessage());
                }
                if (iBitExtracted2 != GlobalVar.pagePlaylistAck) {
                    Log.d("PLAYLIST_DBG", "CTRL: pageReq=" + iBitExtracted2 + " ack=" + GlobalVar.pagePlaylistAck + " newPL=" + iBitExtracted3 + " → sendPlaylist");
                    GlobalVar.pagePlaylist = iBitExtracted2;
                    GlobalVar.pagePlaylistAck = iBitExtracted2;
                    GlobalVar.newPlaylistReq = iBitExtracted3;
                    GlobalVar.newPlaylistAck = iBitExtracted3;
                    sendPlaylistToCluster(iBitExtracted2);
                } else if (iBitExtracted3 != GlobalVar.newPlaylistReq) {
                    Log.d("PLAYLIST_DBG", "CTRL: newPlayList changed req=" + iBitExtracted3 + " old=" + GlobalVar.newPlaylistReq + " page=" + iBitExtracted2);
                    GlobalVar.newPlaylistReq = iBitExtracted3;
                    GlobalVar.newPlaylistAck = iBitExtracted3;
                    sendPlaylistToCluster(iBitExtracted2);
                }
                if (i11 == this.lastSelectPlaylistSongReq) {
                    i7 = i12;
                    if (i7 == GlobalVar.selectedPlaylistSong) {
                        return;
                    }
                } else {
                    i7 = i12;
                }
                this.lastSelectPlaylistSongReq = i11;
                GlobalVar.selectedPlaylistSong = i7;
                GlobalVar.selectePlaylistSongAck = Math.max(0, Math.min(i7, 4));
                Log.d("BLE_DEBUG", "cluster select slot=" + i7 + " page=" + iBitExtracted2 + " trigger=" + i11);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis < this.playlistSelectLockUntilMs) {
                    Log.d("BLE_MUSIC", "playlist select suppressed after skip slot=" + i7 + " lockRemainMs=" + (this.playlistSelectLockUntilMs - jCurrentTimeMillis));
                    return;
                }
                if (iBitExtracted2 <= 0 && GlobalVar.pagePlaylistAck <= 0) {
                    Log.w("BLE_DEBUG", "cluster select ignored — no valid playlist page");
                } else {
                    playSongByIndex(iBitExtracted2, i7);
                }
            }
        }
    }

    private void extendPlaylistSelectLock() {
        long jCurrentTimeMillis = System.currentTimeMillis() + 10000;
        if (jCurrentTimeMillis > this.playlistSelectLockUntilMs) {
            this.playlistSelectLockUntilMs = jCurrentTimeMillis;
        }
    }

    private void performDialFromCluster(int i, int i2, boolean z) throws Throwable {
        if (GlobalVar.callState == CallState.INCOMING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL || GlobalVar.callState == CallState.END_CALL) {
            Log.i("BLE_ACTION", "Dial ignored — call already in progress state=" + GlobalVar.callState);
            return;
        }
        this.lastDialConfirmAtMs = System.currentTimeMillis();
        if (i == 1) {
            if (!z) {
                Log.i("BLE_ACTION", "Favourite dial ignored — SKU capability disabled");
                return;
            } else {
                dialFavoriteWithRetry(i2, 0);
                return;
            }
        }
        if (i == 2) {
            if (!z) {
                Log.i("BLE_ACTION", "Recent dial ignored — SKU capability disabled");
                return;
            }
            SimpleContact simpleContactLookupRecentContact = lookupRecentContact(this.context, i2);
            if (simpleContactLookupRecentContact != null) {
                initiateCallForNumber(simpleContactLookupRecentContact.name, simpleContactLookupRecentContact.number);
                return;
            }
            Log.w("BLE_ACTION", "Recent dial: no contact at index=" + i2);
            return;
        }
        if (i == 3) {
            SimpleContact simpleContactLookupMissedContact = lookupMissedContact(this.context, i2);
            if (simpleContactLookupMissedContact != null) {
                initiateCallForNumber(simpleContactLookupMissedContact.name, simpleContactLookupMissedContact.number);
                return;
            }
            Log.w("BLE_ACTION", "Missed dial: no contact at index=" + i2);
            return;
        }
        Log.d("BLE_ACTION", "Unknown Dial Source=" + i);
    }

    private void dialFavoriteWithRetry(final int i, final int i2) {
        SimpleContact simpleContactLookupFavoriteContact = lookupFavoriteContact(this.context, i);
        if (simpleContactLookupFavoriteContact != null) {
            initiateCallForNumber(simpleContactLookupFavoriteContact.name, simpleContactLookupFavoriteContact.number);
            return;
        }
        if (i2 >= 2) {
            Log.w("BLE_ACTION", "Favourite dial: no contact at index=" + i + " after retries");
            return;
        }
        Log.w("BLE_ACTION", "Favourite dial: empty slot index=" + i + " — retry attempt " + (i2 + 1));
        this.dialHandler.postDelayed(new Runnable() { // from class: com.bajajconnect.ble.Controls$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dialFavoriteWithRetry$0(i, i2);
            }
        }, 350L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialFavoriteWithRetry$0(int i, int i2) {
        dialFavoriteWithRetry(i, i2 + 1);
    }

    private void handleTakeMeHome() {
        String str = GlobalVar.takeMeHomeAddress;
        Double d = GlobalVar.takeMeHomeLat;
        Double d2 = GlobalVar.takeMeHomeLng;
        if (str == null || str.trim().isEmpty() || d == null || d2 == null) {
            Log.w("BLE_ACTION", "takeMeHome: home address not configured");
            return;
        }
        Log.d("BLE_ACTION", "takeMeHome request ack=" + GlobalVar.takeMeHomeAck);
        if (BleFeatures.takeMeHomeCallback != null) {
            BleFeatures.takeMeHomeCallback.onTakeMeHome(d, d2, str);
        }
    }

    public void sendMissedCall() {
        MissedCallModel missedCallModelPoll;
        if (BleService.missedCallList.isEmpty() || (missedCallModelPoll = BleService.missedCallList.poll()) == null || !GlobalVar.isBlueToothConnected || GlobalVar.MISSED_CALL_CHAR == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("sendMissedCall: nameLen=");
        sb.append(missedCallModelPoll.getName() != null ? missedCallModelPoll.getName().length() : 0);
        sb.append(" numberLen=");
        sb.append(missedCallModelPoll.getNumber() != null ? missedCallModelPoll.getNumber().length() : 0);
        Log.d("BLE_NOTIFY", sb.toString());
        BleService.prepareCharAndWrite(GlobalVar.MISSED_CALL_CHAR, CallFrame.missedCallForVehicle(missedCallModelPoll.getName(), missedCallModelPoll.getNumber(), missedCallModelPoll.getTimestamp()));
        GlobalVar.missedCallGetAck = GlobalVar.missedCallGet;
    }

    public void sendAlert() {
        AlertModel alertModelPoll;
        if (BleService.alertsList.isEmpty() || (alertModelPoll = BleService.alertsList.poll()) == null) {
            return;
        }
        Log.d("BLE_NOTIFY", "sendAlert: type=" + alertModelPoll.getType() + " name=" + alertModelPoll.getName());
        BleService.prepareCharAndWrite(GlobalVar.ALERTS_INFO_CHAR, CallFrame.alertsForVehicle(alertModelPoll.getType(), alertModelPoll.getName(), alertModelPoll.getTimestamp()));
        GlobalVar.alertsGetAck = GlobalVar.alertGet;
    }

    private boolean shouldAcceptSkip(String str, int i) {
        synchronized (this.skipLock) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if ("next".equals(str) && i == this.lastExecutedSkipToNext) {
                return false;
            }
            if ("prev".equals(str) && i == this.lastExecutedSkipToPrev) {
                return false;
            }
            String str2 = this.lastExecutedSkipDirection;
            if (str2 == null || str2.equals(str) || jCurrentTimeMillis - this.lastSkipAtMs >= OPPOSITE_SKIP_LOCK_MS) {
                if (jCurrentTimeMillis - this.lastSkipAtMs < SKIP_DEBOUNCE_MS) {
                    return false;
                }
                this.lastSkipAtMs = jCurrentTimeMillis;
                this.lastExecutedSkipDirection = str;
                this.playlistSelectLockUntilMs = jCurrentTimeMillis + 10000;
                return true;
            }
            Log.d("BLE_MUSIC", "skip " + str + " blocked — opposite lock after " + this.lastExecutedSkipDirection + " (" + (jCurrentTimeMillis - this.lastSkipAtMs) + "ms ago)");
            return false;
        }
    }

    public void playNext() {
        synchronized (this.skipLock) {
            playNextUnlocked();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0039 A[Catch: Exception -> 0x004a, TryCatch #1 {Exception -> 0x004a, blocks: (B:15:0x0031, B:17:0x0039, B:19:0x0040), top: B:31:0x0031, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0040 A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #1 {Exception -> 0x004a, blocks: (B:15:0x0031, B:17:0x0039, B:19:0x0040), top: B:31:0x0031, outer: #0 }] */
    private void playNextUnlocked() {
        MediaSessionListener mediaSessionListener;
        try {
            notifyListenerClusterSkip("next");
            try {
                if (MusicCallbackImpl.ACTIVE_PACKAGE_NAME != null && MusicCallbackImpl.ACTIVE_PACKAGE_NAME.equals(MusicCallbackImpl.SPOTIFY_PACKAGE_NAME) && MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) {
                    try {
                        MainActivity.spotifyAppRemote.getPlayerApi().skipNext();
                        return;
                    } catch (Exception e) {
                        Log.w("BLE_MUSIC", "Spotify skipNext failed, falling back", e);
                        mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
                        if (mediaSessionListener != null) {
                            mediaSessionListener.ensurePreferredController();
                            if (mediaSessionListener.mController != null) {
                                mediaSessionListener.mController.getTransportControls().skipToNext();
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            try {
                mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
                if (mediaSessionListener != null) {
                    mediaSessionListener.ensurePreferredController();
                    if (mediaSessionListener.mController != null) {
                        mediaSessionListener.mController.getTransportControls().skipToNext();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void notifyListenerClusterSkip(String str) {
        try {
            MediaSessionListener mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
            if (mediaSessionListener != null) {
                mediaSessionListener.onClusterSkipRequested(str);
            }
        } catch (Exception unused) {
        }
    }

    public void playPrev() {
        synchronized (this.skipLock) {
            playPrevUnlocked();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003a A[Catch: Exception -> 0x004b, TryCatch #1 {Exception -> 0x004b, blocks: (B:15:0x0032, B:17:0x003a, B:19:0x0041), top: B:29:0x0032, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0041 A[Catch: Exception -> 0x004b, TRY_LEAVE, TryCatch #1 {Exception -> 0x004b, blocks: (B:15:0x0032, B:17:0x003a, B:19:0x0041), top: B:29:0x0032, outer: #0 }] */
    private void playPrevUnlocked() {
        MediaSessionListener mediaSessionListener;
        try {
            notifyListenerClusterSkip("prev");
            try {
                if (MusicCallbackImpl.ACTIVE_PACKAGE_NAME != null && MusicCallbackImpl.ACTIVE_PACKAGE_NAME.equals(MusicCallbackImpl.SPOTIFY_PACKAGE_NAME) && MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) {
                    try {
                        MainActivity.spotifyAppRemote.getPlayerApi().skipPrevious();
                        return;
                    } catch (Exception e) {
                        Log.w("BLE_MUSIC", "Spotify skipPrevious failed, falling back", e);
                        mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
                        if (mediaSessionListener != null) {
                            mediaSessionListener.ensurePreferredController();
                            if (mediaSessionListener.mController != null) {
                                mediaSessionListener.mController.getTransportControls().skipToPrevious();
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            try {
                mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
                if (mediaSessionListener != null) {
                    mediaSessionListener.ensurePreferredController();
                    if (mediaSessionListener.mController != null) {
                        mediaSessionListener.mController.getTransportControls().skipToPrevious();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused2) {
        }
    }

    private static class SimpleContact {
        String name;
        String number;

        SimpleContact(String str, String str2) {
            this.name = str;
            this.number = str2;
        }
    }

    private SimpleContact lookupFavoriteContact(Context context, int i) {
        try {
            StarredContactsHelper.Entry starredContactAt = StarredContactsHelper.getStarredContactAt(context, i);
            if (starredContactAt != null) {
                return new SimpleContact(starredContactAt.name, starredContactAt.number);
            }
            return null;
        } catch (Exception e) {
            Log.e("BLE_ACTION", "lookupFavoriteContact error", e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007b A[PHI: r10
      0x007b: PHI (r10v4 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v5 android.database.Cursor) binds: [B:38:0x0079, B:29:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x0083  */
    private SimpleContact lookupRecentContact(Context context, int i) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"name", "number"}, null, null, "date DESC");
            try {
                try {
                    HashSet hashSet = new HashSet();
                    if (cursorQuery != null) {
                        int i2 = 0;
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            if (string2 != null) {
                                String strTrim = string2.trim();
                                String strLastTenDigits = RecentCallsFrame.lastTenDigits(strTrim);
                                if (!strLastTenDigits.isEmpty() && !hashSet.contains(strLastTenDigits)) {
                                    hashSet.add(strLastTenDigits);
                                    if (i2 == i) {
                                        if (string == null || string.isEmpty()) {
                                            string = strLastTenDigits;
                                        }
                                        SimpleContact simpleContact = new SimpleContact(string.trim(), strTrim);
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        return simpleContact;
                                    }
                                    i2++;
                                    if (i2 > 4) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e) {
                    e = e;
                    Log.e("BLE_ACTION", "lookupRecentContact error", e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    private SimpleContact lookupMissedContact(Context context, int i) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"name", "number"}, "type=3", null, "date DESC");
            if (cursorQuery != null) {
                int i2 = 0;
                while (cursorQuery.moveToNext()) {
                    try {
                        try {
                            if (i2 == i) {
                                String string = cursorQuery.getString(0);
                                String string2 = cursorQuery.getString(1);
                                if (string == null || string.isEmpty()) {
                                    string = string2 == null ? "" : string2;
                                }
                                if (string2 == null) {
                                    string2 = "";
                                }
                                SimpleContact simpleContact = new SimpleContact(string.trim(), string2.trim());
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return simpleContact;
                            }
                            i2++;
                            if (i2 > 4) {
                                break;
                            }
                        } catch (Exception e) {
                            e = e;
                            Log.e("BLE_ACTION", "lookupMissedContact error", e);
                            if (cursorQuery != null) {
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    private void initiateCallForNumber(String str, String str2) {
        if (str2 != null) {
            try {
                try {
                    if (!str2.isEmpty()) {
                        if (GlobalVar.callState != CallState.INCOMING_CALL && GlobalVar.callState != CallState.ACTIVE_CALL && GlobalVar.callState != CallState.END_CALL) {
                            String strTrim = str2.trim();
                            String strTrim2 = str == null ? "" : str.trim();
                            boolean z = (strTrim2.isEmpty() || strTrim2.equals(strTrim)) ? false : true;
                            GlobalVar.callerNumber = strTrim;
                            if (!z) {
                                strTrim2 = strTrim;
                            }
                            GlobalVar.callerName = strTrim2;
                            GlobalVar.callState = CallState.OUTGOING_CALL;
                            GlobalVar.callProgressCount = 0;
                            Log.d("BLE_ACTION", "initiateCallForNumber: haveRealName=" + z + " numberLen=" + strTrim.length());
                            try {
                                if (BleService.isGattConnected() && GlobalVar.GENERAL_CHAR != null) {
                                    BleService.prepareCharAndWrite(GlobalVar.GENERAL_CHAR, CallFrame.generalForVehicle());
                                }
                            } catch (Exception unused) {
                            }
                            BleService.startOutgoingAnswerWatchFromDial();
                            Uri uri = Uri.parse("tel:" + Uri.encode(str2));
                            if (ContextCompat.checkSelfPermission(this.context, "android.permission.CALL_PHONE") == 0) {
                                TelecomManager telecomManager = this.telecomManager;
                                if (telecomManager == null) {
                                    telecomManager = (TelecomManager) this.context.getSystemService("telecom");
                                }
                                if (telecomManager != null) {
                                    telecomManager.placeCall(uri, null);
                                    Log.d("BLE_ACTION", "Initiated TelecomManager.placeCall");
                                    return;
                                } else {
                                    Intent intent = new Intent("android.intent.action.CALL", uri);
                                    intent.addFlags(268435456);
                                    this.context.startActivity(intent);
                                    Log.d("BLE_ACTION", "Initiated ACTION_CALL");
                                    return;
                                }
                            }
                            Intent intent2 = new Intent("android.intent.action.DIAL", uri);
                            intent2.addFlags(268435456);
                            try {
                                this.context.startActivity(intent2);
                                Log.d("BLE_ACTION", "No CALL_PHONE permission; opened dialer");
                            } catch (Exception e) {
                                Log.e("BLE_ACTION", "ACTION_DIAL blocked in background — grant CALL_PHONE", e);
                            }
                            try {
                                Intent intent3 = new Intent("com.bajajconnect.REQUEST_CALL_PHONE_PERMISSION");
                                intent3.putExtra("phone_number", str2);
                                this.context.sendBroadcast(intent3);
                                return;
                            } catch (Exception unused2) {
                                return;
                            }
                        }
                        Log.i("BLE_ACTION", "initiateCallForNumber blocked — in-call state=" + GlobalVar.callState);
                        return;
                    }
                } catch (SecurityException e2) {
                    Log.e("BLE_ACTION", "SecurityException initiating call: " + e2.getMessage());
                    return;
                }
            } catch (Exception e3) {
                Log.e("BLE_ACTION", "Error initiating call", e3);
                return;
            }
        }
        Log.d("BLE_ACTION", "initiateCallForNumber: empty number");
    }

    public void playSong() {
        try {
            if (MusicCallbackImpl.ACTIVE_PACKAGE_NAME != null && MusicCallbackImpl.ACTIVE_PACKAGE_NAME.equals(MusicCallbackImpl.SPOTIFY_PACKAGE_NAME) && MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) {
                try {
                    MainActivity.spotifyAppRemote.getPlayerApi().resume();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
        try {
            dispatchTransportPlayPause(true);
        } catch (Exception unused2) {
        }
    }

    public void pause() {
        try {
            if (MusicCallbackImpl.ACTIVE_PACKAGE_NAME != null && MusicCallbackImpl.ACTIVE_PACKAGE_NAME.equals(MusicCallbackImpl.SPOTIFY_PACKAGE_NAME) && MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) {
                MainActivity.spotifyAppRemote.getPlayerApi().pause();
                return;
            }
        } catch (Exception unused) {
        }
        try {
            dispatchTransportPlayPause(false);
        } catch (Exception unused2) {
        }
    }

    private void dispatchTransportPlayPause(final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.ble.Controls$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dispatchTransportPlayPause$1(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$dispatchTransportPlayPause$1(boolean z) {
        Object obj;
        String str = "TransportControls failed play=";
        try {
            MediaSessionListener mediaSessionListener = BleFeatures.getInstance().mMediaSessionListener;
            if (mediaSessionListener == null) {
                Log.w("BLE_MUSIC", "No MediaSessionListener for play=" + z);
                return;
            }
            mediaSessionListener.ensurePreferredController();
            MediaControllerCompat mediaControllerCompat = mediaSessionListener.mController;
            int i = WebSocketProtocol.PAYLOAD_SHORT;
            if (mediaControllerCompat == null) {
                Log.w("BLE_MUSIC", "No MediaController for play=" + z + " — trying AudioManager keys");
                if (!z) {
                    i = 127;
                }
                dispatchAudioManagerMediaKey(i);
                return;
            }
            PlaybackStateCompat playbackState = mediaControllerCompat.getPlaybackState();
            long actions = playbackState != null ? playbackState.getActions() : 0L;
            StringBuilder sb = new StringBuilder("transportPlayPause play=");
            sb.append(z);
            sb.append(" pkg=");
            sb.append(mediaControllerCompat.getPackageName());
            sb.append(" state=");
            sb.append(playbackState != null ? playbackState.getState() : -1);
            sb.append(" actions=");
            sb.append(actions);
            Log.d("BLE_MUSIC", sb.toString());
            boolean z2 = true;
            try {
                if (z) {
                    mediaControllerCompat.getTransportControls().play();
                } else {
                    mediaControllerCompat.getTransportControls().pause();
                }
                str = 1;
                obj = str;
            } catch (Exception e) {
                Log.w("BLE_MUSIC", str + z, e);
                obj = null;
            }
            if (!z) {
                i = 127;
            }
            dispatchControllerMediaKey(mediaControllerCompat, i);
            dispatchAudioManagerMediaKey(i);
            boolean z3 = (4 & actions) != 0;
            boolean z4 = (2 & actions) != 0;
            if ((actions & 512) == 0) {
                z2 = false;
            }
            if (obj == null && z2) {
                if (z) {
                    if (z3) {
                        return;
                    }
                } else if (z4) {
                    return;
                }
                dispatchControllerMediaKey(mediaControllerCompat, 85);
                dispatchAudioManagerMediaKey(85);
            }
        } catch (Exception e2) {
            Log.e("BLE_MUSIC", "dispatchTransportPlayPause failed play=" + z, e2);
        }
    }

    private void dispatchControllerMediaKey(MediaControllerCompat mediaControllerCompat, int i) {
        try {
            mediaControllerCompat.dispatchMediaButtonEvent(new KeyEvent(0, i));
            mediaControllerCompat.dispatchMediaButtonEvent(new KeyEvent(1, i));
        } catch (Exception e) {
            Log.w("BLE_MUSIC", "controller media key failed keyCode=" + i, e);
        }
    }

    private void dispatchAudioManagerMediaKey(int i) {
        try {
            AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
            if (audioManager == null) {
                return;
            }
            audioManager.dispatchMediaKeyEvent(new KeyEvent(0, i));
            audioManager.dispatchMediaKeyEvent(new KeyEvent(1, i));
        } catch (Exception e) {
            Log.w("BLE_MUSIC", "AudioManager media key failed keyCode=" + i, e);
        }
    }

    public void setVolume(int i, Context context) {
        boolean zIsInCall;
        TelecomManager telecomManager;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
        if (audioManager == null) {
            Log.w("Controls", "setVolume skipped — AudioManager null");
            return;
        }
        int iMax = Math.max(0, Math.min(i, 10));
        boolean zIsAppProcessForeground = isAppProcessForeground(applicationContext);
        try {
            if (ActivityCompat.checkSelfPermission(applicationContext, "android.permission.READ_PHONE_STATE") != 0 || (telecomManager = this.telecomManager) == null) {
                zIsInCall = false;
            } else {
                try {
                    zIsInCall = telecomManager.isInCall();
                } catch (Exception e) {
                    Log.w("Controls", "isInCall check failed", e);
                    zIsInCall = false;
                }
            }
            int i2 = zIsInCall ? 0 : 3;
            int streamMaxVolume = audioManager.getStreamMaxVolume(i2);
            if (streamMaxVolume <= 0) {
                Log.w("Controls", "setVolume skipped — maxVolume=0 stream=" + i2);
                return;
            }
            double d = ((double) iMax) * (((double) streamMaxVolume) / 10.0d);
            int i3 = (int) d;
            if (d - ((double) i3) == 0.5d) {
                i3 = (int) (d + 0.5d);
            }
            int iMax2 = Math.max(0, Math.min(i3, streamMaxVolume));
            GlobalVar.currentVolume = iMax;
            audioManager.setStreamVolume(i2, iMax2, zIsAppProcessForeground ? 1 : 0);
            if (zIsAppProcessForeground && audioManager.getStreamVolume(i2) != iMax2) {
                audioManager.setStreamVolume(i2, iMax2, 0);
            }
            Log.i("Controls", "setVolume tenths=" + iMax + " stream=" + i2 + " level=" + iMax2 + RemoteSettings.FORWARD_SLASH_STRING + streamMaxVolume + " flags=" + (zIsAppProcessForeground ? 1 : 0) + " fg=" + zIsAppProcessForeground);
        } catch (Exception e2) {
            Log.e("Controls", "setVolume failed tenths=" + iMax, e2);
        }
    }

    private static boolean isAppProcessForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && packageName.equals(runningAppProcessInfo.processName)) {
                    return runningAppProcessInfo.importance <= 100;
                }
            }
        } catch (Exception e) {
            Log.w("Controls", "isAppProcessForeground failed", e);
        }
        return false;
    }

    private void rejectCallP() {
        try {
            if (ContextCompat.checkSelfPermission(this.context, "android.permission.ANSWER_PHONE_CALLS") == 0 && Build.VERSION.SDK_INT >= 28) {
                ((TelecomManager) this.context.getSystemService("telecom")).endCall();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void aCallP() {
        try {
            if (ContextCompat.checkSelfPermission(this.context, "android.permission.ANSWER_PHONE_CALLS") != 0) {
                return;
            }
            TelecomManager telecomManager = (TelecomManager) this.context.getSystemService("telecom");
            if (Build.VERSION.SDK_INT >= 26) {
                telecomManager.acceptRingingCall();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendPlaylistToCluster(int i) {
        MusicCallbackImpl musicCallbackImpl;
        final int iMax = Math.max(i, 1);
        Log.d("PLAYLIST_DBG", "sendPlaylistToCluster(" + i + ") → page=" + iMax + " ack(before)=" + GlobalVar.pagePlaylistAck);
        GlobalVar.pagePlaylistAck = iMax;
        try {
            if (BleFeatures.getInstance().mMediaSessionListener == null || BleFeatures.getInstance().mMediaSessionListener.musicCallback == null) {
                return;
            }
            try {
                if (MusicCallbackImpl.ACTIVE_PACKAGE_NAME != null && MusicCallbackImpl.ACTIVE_PACKAGE_NAME.equals(MusicCallbackImpl.SPOTIFY_PACKAGE_NAME) && (musicCallbackImpl = MusicCallbackImpl.getInstance()) != null && (musicCallbackImpl.spotifyPlaylist == null || musicCallbackImpl.spotifyPlaylist.isEmpty())) {
                    try {
                        BleFeatures.getInstance().mMediaSessionListener.musicCallback.onFetchSpotifyPlaylist();
                    } catch (Exception unused) {
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.Controls$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Controls.lambda$sendPlaylistToCluster$2(iMax);
                        }
                    }, 800L);
                    return;
                }
            } catch (Exception unused2) {
            }
            BleFeatures.getInstance().mMediaSessionListener.musicCallback.onTrackListRequested(iMax);
        } catch (Exception e) {
            Log.e("BLE_DEBUG", "sendPlaylistToCluster: error", e);
        }
    }

    static /* synthetic */ void lambda$sendPlaylistToCluster$2(int i) {
        try {
            if (BleFeatures.getInstance().mMediaSessionListener == null || BleFeatures.getInstance().mMediaSessionListener.musicCallback == null) {
                return;
            }
            BleFeatures.getInstance().mMediaSessionListener.musicCallback.onTrackListRequested(i);
        } catch (Exception unused) {
        }
    }

    private void playSongByIndex(int i, int i2) {
        try {
            if (BleFeatures.getInstance().mMediaSessionListener == null || BleFeatures.getInstance().mMediaSessionListener.musicCallback == null) {
                Log.w("BLE_DEBUG", "playSongByIndex: musicCallback null, cannot delegate song selection");
                return;
            }
            if (i <= 0) {
                i = Math.max(GlobalVar.pagePlaylistAck, 1);
            }
            int iMax = Math.max(0, Math.min(i2, 4));
            int i3 = ((i - 1) * 5) + iMax;
            Log.d("BLE_DEBUG", "playSongByIndex: slot=" + iMax + " page=" + i + " absoluteIndex=" + i3);
            GlobalVar.selectePlaylistSongAck = iMax;
            BleFeatures.getInstance().mMediaSessionListener.musicCallback.onSongSelected(i3);
        } catch (Exception e) {
            Log.e("BLE_DEBUG", "playSongByIndex: error", e);
        }
    }

    public void sendPlaylist(List<SongInfo> list, int i) {
        if (!GlobalVar.isBlueToothConnected || GlobalVar.PLAYLIST_INFO_CHAR == null) {
            return;
        }
        BleService.prepareCharAndWrite(GlobalVar.PLAYLIST_INFO_CHAR, CallFrame.playlist(list, i));
    }

    public void sendResetPlaylist() {
        if (!BleService.isGattConnected()) {
            Log.d("BLE_DEBUG", "sendResetPlaylist: GATT not connected, skipping");
        } else {
            if (GlobalVar.PLAYLIST_INFO_CHAR == null) {
                return;
            }
            GlobalVar.userChangePlaylistCounter++;
            BleService.prepareCharAndWrite(GlobalVar.PLAYLIST_INFO_CHAR, CallFrame.resetPlaylist());
        }
    }
}
