package com.bajajconnect.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.CallLog;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.bajajconnect.enums.CallState;
import com.bajajconnect.enums.music.PlayStatus;
import com.bajajconnect.features.VehicleFeature;
import com.bajajconnect.interfaces.BleConnectionCallback;
import com.bajajconnect.interfaces.MusicCallback;
import com.bajajconnect.interfaces.NavigationCallback;
import com.bajajconnect.interfaces.SpotifySessionCallback;
import com.bajajconnect.interfaces.TakeMeHome;
import com.bajajconnect.models.Item_song;
import com.bajajconnect.models.SongInfo;
import com.bajajconnect.music.MediaSessionListener;
import com.bajajconnect.recievers.BleReceiver;
import com.bajajconnect.recievers.IPhoneState;
import com.bajajconnect.recievers.PhoneClassStateListener;
import com.bajajconnect.recievers.SmsReceiver;
import com.bajajconnect.utils.PhoneUtil;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.interfaces.RNEmiiterCallback;
import com.google.maps.android.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.lang3.StringUtils;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class BleFeatures {
    public static final String STOPSERVICE = "com.bajajconnect.ACTION_FOREGROUND_STOP";
    public static final String STOP_SERVICE = "com.bajajconnect.ACTION_FOREGROUND_STOP";
    public static IPhoneState iphoneState;
    public static NavigationCallback navigationCallback;
    private static BleFeatures sInstance;
    public static TakeMeHome takeMeHomeCallback;
    BleReceiver bleReceiver;
    private PhoneClassStateListener callStateListener;
    public BleConnectionCallback connectionCallback;
    public Context context;
    public Controls controls;
    private BluetoothAdapter mBluetoothAdapter;
    public MediaSessionListener mMediaSessionListener;
    MyPhoneStateListener mPhoneStateListener;
    private ContentObserver recentCallLogObserver;
    public RNEmiiterCallback rnEmiiterCallback;
    private BroadcastReceiver screenUnlockReceiver;
    private SmsReceiver smsReceiver;
    public SpotifySessionCallback spotifySessionCallback;
    Timer t;
    TelephonyManager telephonyManager;
    private ContentObserver volumeListener;
    private long millisecond = 0;
    public String phoneName = "";
    public String modelCode = "";
    public String currentPack = null;
    private int telephonyIdleMismatchTicks = 0;

    private int getBatteryLevel(int i) {
        if (i < 20) {
            return 0;
        }
        if (i < 40) {
            return 1;
        }
        if (i < 60) {
            return 2;
        }
        return i < 80 ? 3 : 4;
    }

    public static BleFeatures getInstance() {
        if (sInstance == null) {
            sInstance = new BleFeatures();
        }
        return sInstance;
    }

    public void registerBleCallback(BleConnectionCallback bleConnectionCallback) {
        this.connectionCallback = bleConnectionCallback;
    }

    public void init(Context context) {
        this.context = context.getApplicationContext();
        if (this.controls == null) {
            this.controls = new Controls(context);
        }
        if (this.mBluetoothAdapter == null) {
            this.mBluetoothAdapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        }
        this.phoneName = getDeviceName();
        Intent intent = new Intent(context, (Class<?>) BleService.class);
        intent.setAction("com.bajajconnect.ble.ACTION_BLE_START");
        context.startService(intent);
        registerReceivers(context.getApplicationContext());
        registerScreenUnlockReceiver(context.getApplicationContext());
        getBatteryPercentage(context.getApplicationContext());
        registerCallReceivers(context.getApplicationContext());
        lambda$registerVolumeListener$0(context.getApplicationContext());
        lambda$registerRecentCallLogObserver$2(context.getApplicationContext());
    }

    private void registerScreenUnlockReceiver(Context context) {
        if (this.screenUnlockReceiver != null) {
            return;
        }
        this.screenUnlockReceiver = new BroadcastReceiver() { // from class: com.bajajconnect.ble.BleFeatures.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null) {
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action) || "android.intent.action.SCREEN_ON".equals(action)) {
                    try {
                        BleFeatures.this.updateBatteryPercentageIfValid(context2.getApplicationContext());
                        BleFeatures.this.updateSignalStrengthIfPossible(context2.getApplicationContext());
                        BleFeatures.this.listenPhone(context2.getApplicationContext(), true);
                        if (BleService.isGattConnected() && GlobalVar.GENERAL_CHAR != null) {
                            BleService.prepareCharAndWrite(GlobalVar.GENERAL_CHAR, CallFrame.generalForVehicle());
                        }
                        Timber.d("SCREEN_ON/USER_PRESENT: forced General packet refresh", new Object[0]);
                    } catch (Exception e) {
                        Timber.w(e, "screen unlock refresh failed", new Object[0]);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        try {
            context.registerReceiver(this.screenUnlockReceiver, intentFilter);
        } catch (Exception unused) {
            this.screenUnlockReceiver = null;
        }
    }

    public String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.toLowerCase().startsWith(str.toLowerCase())) {
            return capitalize(str2);
        }
        return capitalize(str) + StringUtils.SPACE + str2;
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char cCharAt = str.charAt(0);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        return Character.toUpperCase(cCharAt) + str.substring(1);
    }

    public void stop(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Intent intent = new Intent(context, (Class<?>) BleService.class);
                intent.setAction("com.bajajconnect.ACTION_FOREGROUND_STOP");
                intent.setAction("com.bajajconnect.ACTION_FOREGROUND_STOP");
                context.startService(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void unregisterCallRecievers(Context context) {
        try {
            context.unregisterReceiver(this.callStateListener);
            context.unregisterReceiver(this.smsReceiver);
            this.callStateListener = null;
            this.smsReceiver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopBleTimer() {
        Timer timer = this.t;
        if (timer != null) {
            timer.cancel();
            this.t = null;
        }
    }

    public void listenPhone(Context context, Boolean bool) {
        MyPhoneStateListener myPhoneStateListener;
        try {
            if (bool.booleanValue()) {
                if (Build.VERSION.SDK_INT < 31) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                    this.telephonyManager = telephonyManager;
                    telephonyManager.listen(new PhoneStateListener() { // from class: com.bajajconnect.ble.BleFeatures.2
                        @Override // android.telephony.PhoneStateListener
                        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                            super.onSignalStrengthsChanged(signalStrength);
                            int level = signalStrength.getLevel();
                            GlobalVar.signalStrength = Math.max(0, Math.min(level, 4));
                            Log.d("BLE_SIGNAL", "onSignalStrengthsChanged (legacy): raw=" + level + " stored=" + GlobalVar.signalStrength);
                            if (BleFeatures.iphoneState != null) {
                                BleFeatures.iphoneState.onSignalStrengthChange(GlobalVar.signalStrength);
                            }
                        }
                    }, 256);
                    Log.i("BLE_SIGNAL", "listenPhone: legacy PhoneStateListener registered");
                } else {
                    TelephonyManager telephonyManager2 = (TelephonyManager) context.getApplicationContext().getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                    this.telephonyManager = telephonyManager2;
                    MyPhoneStateListener myPhoneStateListener2 = this.mPhoneStateListener;
                    if (myPhoneStateListener2 != null) {
                        try {
                            telephonyManager2.unregisterTelephonyCallback(myPhoneStateListener2);
                        } catch (Exception unused) {
                        }
                    }
                    this.mPhoneStateListener = new MyPhoneStateListener();
                    this.telephonyManager.registerTelephonyCallback(context.getApplicationContext().getMainExecutor(), this.mPhoneStateListener);
                    Log.i("BLE_SIGNAL", "listenPhone: TelephonyCallback registered (SDK=" + Build.VERSION.SDK_INT + ")");
                }
            } else if (Build.VERSION.SDK_INT >= 31 && (myPhoneStateListener = this.mPhoneStateListener) != null) {
                this.telephonyManager.unregisterTelephonyCallback(myPhoneStateListener);
                this.mPhoneStateListener = null;
                Log.i("BLE_SIGNAL", "listenPhone: TelephonyCallback unregistered");
            }
        } catch (Exception e) {
            Log.w("BLE_SIGNAL", "listenPhone failed: " + e.getMessage(), e);
        }
    }

    public void getBatteryPercentage(final Context context) {
        updateBatteryPercentageIfValid(context);
        updateSignalStrengthIfPossible(context);
        Timer timer = this.t;
        if (timer != null) {
            timer.cancel();
            this.t = null;
        }
        Timer timer2 = new Timer();
        this.t = timer2;
        timer2.schedule(new TimerTask() { // from class: com.bajajconnect.ble.BleFeatures.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - BleFeatures.this.millisecond >= 5000) {
                    BleFeatures.this.millisecond = System.currentTimeMillis();
                    BleFeatures.this.updateBatteryPercentageIfValid(context);
                }
                BleFeatures.this.updateSignalStrengthIfPossible(context);
                try {
                    if ((GlobalVar.callState == CallState.ACTIVE_CALL || GlobalVar.callState == CallState.INCOMING_CALL || GlobalVar.callState == CallState.OUTGOING_CALL) && BleFeatures.isTelephonyCallIdle(context)) {
                        BleFeatures.this.telephonyIdleMismatchTicks++;
                        if (BleFeatures.this.telephonyIdleMismatchTicks >= 2) {
                            BleService.clearStuckCallStateIfPhoneIdle("generalTimer");
                            BleFeatures.this.telephonyIdleMismatchTicks = 0;
                        }
                    } else {
                        BleFeatures.this.telephonyIdleMismatchTicks = 0;
                    }
                } catch (Exception unused) {
                }
                if (GlobalVar.callState == CallState.ACTIVE_CALL || GlobalVar.callState == CallState.OUTGOING_CALL) {
                    GlobalVar.callProgressCount++;
                } else if (GlobalVar.callState != CallState.INCOMING_CALL) {
                    GlobalVar.callProgressCount = 0;
                }
                if (BleFeatures.iphoneState != null) {
                    BleFeatures.iphoneState.onBatteryPercentageChange(GlobalVar.batteryPercentage);
                }
                if (BleService.isGattConnected() && GlobalVar.GENERAL_CHAR != null) {
                    BleService.prepareCharAndWrite(GlobalVar.GENERAL_CHAR, CallFrame.generalForVehicle());
                } else if (GlobalVar.isBlueToothConnected) {
                    Timber.d("Timer: connected but skipping write — GENERAL_CHAR=%s isMTUIncreased=%b", GlobalVar.GENERAL_CHAR != null ? "OK" : BuildConfig.TRAVIS, Boolean.valueOf(GlobalVar.isMTUIncreased));
                }
                if (BleFeatures.this.mBluetoothAdapter == null || BleFeatures.this.mBluetoothAdapter.isEnabled() || !GlobalVar.isBlueToothConnected) {
                    return;
                }
                GlobalVar.isBlueToothConnected = false;
                if (BleFeatures.getInstance().connectionCallback != null) {
                    BleFeatures.getInstance().connectionCallback.onStateChange(false);
                    if (BleFeatures.iphoneState != null) {
                        BleFeatures.iphoneState.onBluetoothDisconnected();
                    }
                }
            }
        }, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTelephonyCallIdle(Context context) {
        if (context == null) {
            return false;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            return telephonyManager == null || telephonyManager.getCallState() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBatteryPercentageIfValid(Context context) {
        int batteryStatus = PhoneUtil.getBatteryStatus(context);
        if (batteryStatus < 0) {
            Timber.w("Battery read invalid — keeping last bars=%d", Integer.valueOf(GlobalVar.batteryPercentage));
        } else {
            GlobalVar.batteryPercentage = getBatteryLevel(batteryStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSignalStrengthIfPossible(Context context) {
        SignalStrength signalStrength;
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        try {
            if (this.telephonyManager == null) {
                this.telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            }
            TelephonyManager telephonyManager = this.telephonyManager;
            if (telephonyManager == null || (signalStrength = telephonyManager.getSignalStrength()) == null) {
                return;
            }
            int level = signalStrength.getLevel();
            int iMax = Math.max(0, Math.min(level, 4));
            if (GlobalVar.signalStrength != iMax) {
                Log.d("BLE_SIGNAL", "polled signal via TelephonyManager.getSignalStrength(): raw=" + level + " stored=" + iMax + " (was=" + GlobalVar.signalStrength + ")");
                GlobalVar.signalStrength = iMax;
            }
        } catch (SecurityException unused) {
        } catch (Exception e) {
            Log.w("BLE_SIGNAL", "updateSignalStrengthIfPossible failed: " + e.getMessage());
        }
    }

    public void registerReceivers(Context context) {
        if (this.bleReceiver != null) {
            try {
                unRegisterReceivers(context);
            } catch (Exception unused) {
            }
        }
        if (this.bleReceiver == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            BleReceiver bleReceiver = new BleReceiver();
            this.bleReceiver = bleReceiver;
            context.registerReceiver(bleReceiver, intentFilter);
            Log.i("BLE_ADAPTER", "BleReceiver registered for ACTION_STATE_CHANGED + ACL/CONNECTION events");
        }
    }

    public void unRegisterReceivers(Context context) {
        try {
            context.unregisterReceiver(this.bleReceiver);
            this.bleReceiver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCallReceivers(Context context) {
        if (this.callStateListener == null) {
            this.callStateListener = new PhoneClassStateListener();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
            context.registerReceiver(this.callStateListener, intentFilter);
            this.smsReceiver = new SmsReceiver();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.provider.Telephony.SMS_RECEIVED");
            context.registerReceiver(this.smsReceiver, intentFilter2);
        }
    }

    public void unregisterCallReceivers(Context context) {
        try {
            context.unregisterReceiver(this.callStateListener);
            context.unregisterReceiver(this.smsReceiver);
            this.callStateListener = null;
            this.smsReceiver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: registerVolumeListener, reason: merged with bridge method [inline-methods] */
    public void lambda$registerVolumeListener$0(final Context context) {
        if (this.volumeListener == null) {
            this.volumeListener = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.bajajconnect.ble.BleFeatures.4
            };
            try {
                context.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.volumeListener);
            } catch (Exception e) {
                e.printStackTrace();
                this.volumeListener = null;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleFeatures$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$registerVolumeListener$0(context);
                    }
                }, 2000L);
            }
        }
    }

    /* JADX INFO: renamed from: registerRecentCallLogObserver, reason: merged with bridge method [inline-methods] */
    public void lambda$registerRecentCallLogObserver$2(Context context) {
        if (this.recentCallLogObserver != null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            final Handler handler = new Handler(Looper.getMainLooper());
            final Runnable runnable = new Runnable() { // from class: com.bajajconnect.ble.BleFeatures$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    BleFeatures.lambda$registerRecentCallLogObserver$1(applicationContext);
                }
            };
            this.recentCallLogObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.bajajconnect.ble.BleFeatures.5
                @Override // android.database.ContentObserver
                public void onChange(boolean z) {
                    onChange(z, null);
                }

                @Override // android.database.ContentObserver
                public void onChange(boolean z, Uri uri) {
                    handler.removeCallbacks(runnable);
                    handler.postDelayed(runnable, 300L);
                }
            };
            applicationContext.getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, true, this.recentCallLogObserver);
            Log.i("BLE_FAV_RC", "registered CallLog.Calls observer for real-time recent-calls push");
        } catch (SecurityException unused) {
            Log.w("BLE_FAV_RC", "registerRecentCallLogObserver: no READ_CALL_LOG yet; retry in 5 s");
            this.recentCallLogObserver = null;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleFeatures$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$registerRecentCallLogObserver$2(applicationContext);
                }
            }, 5000L);
        } catch (Exception e) {
            Log.w("BLE_FAV_RC", "registerRecentCallLogObserver failed: " + e.getMessage());
            this.recentCallLogObserver = null;
        }
    }

    static /* synthetic */ void lambda$registerRecentCallLogObserver$1(Context context) {
        try {
            if (VehicleFeature.BLE_FAV_RECENT_CALLS.isEnabledFor(getInstance().modelCode) && GlobalVar.isBlueToothConnected && GlobalVar.RECENT_CALLS_CHAR != null) {
                Log.i("BLE_FAV_RC", "CallLog changed → pushing recent calls (observer)");
                RecentCallsFrame.sendRecentCalls(context);
            }
        } catch (Exception e) {
            Log.w("BLE_FAV_RC", "recentCallLogObserver send failed: " + e.getMessage());
        }
    }

    public void unregisterRecentCallLogObserver(Context context) {
        if (this.recentCallLogObserver == null) {
            return;
        }
        try {
            context.getApplicationContext().getContentResolver().unregisterContentObserver(this.recentCallLogObserver);
        } catch (Exception unused) {
        }
        this.recentCallLogObserver = null;
    }

    public void setBleDeviceName(String str) {
        GlobalVar.bleDeviceName = str;
    }

    public void setBleDeviceAddress(String str) {
        GlobalVar.bleDeviceAddress = str;
    }

    public void resetSavedValuesOnKill() {
        GlobalVar.missedCallCount = 0;
        GlobalVar.smsCount = 0;
        GlobalVar.playStatus = PlayStatus.NONE;
        GlobalVar.callAccept = 0;
        GlobalVar.callReject = 0;
        GlobalVar.callRejectWithSms = 0;
        GlobalVar.pagePlaylist = 0;
        GlobalVar.takeMeHome = 0;
        GlobalVar.takeMeHomeAck = 0;
        GlobalVar.resumeSong = 0;
        GlobalVar.pauseSong = 0;
        GlobalVar.skipToNext = 0;
        GlobalVar.skipToPrev = 0;
        GlobalVar.stopSong = 0;
        GlobalVar.missedCallGet = 0;
        GlobalVar.alertGet = 0;
        GlobalVar.launchMediaPlayer = 0;
        GlobalVar.volumeToSet = 0;
        GlobalVar.missedCallName = "";
        GlobalVar.missedCallNumber = "";
        GlobalVar.TBT_INFO_CHAR = null;
        GlobalVar.GENERAL_CHAR = null;
        GlobalVar.MISSED_CALL_CHAR = null;
        GlobalVar.ALERTS_INFO_CHAR = null;
        GlobalVar.MEDIA_INFO_CHAR = null;
        GlobalVar.CONTROL_CHAR = null;
        GlobalVar.callState = CallState.NO_CALL;
    }

    public void resetSavedValues() {
        GlobalVar.missedCallCount = 0;
        GlobalVar.smsCount = 0;
        GlobalVar.playStatus = PlayStatus.NONE;
        GlobalVar.callAccept = 0;
        GlobalVar.callReject = 0;
        GlobalVar.callRejectWithSms = 0;
        GlobalVar.pagePlaylist = 0;
        GlobalVar.takeMeHome = 0;
        GlobalVar.takeMeHomeAck = 0;
        GlobalVar.resumeSong = 0;
        GlobalVar.pauseSong = 0;
        GlobalVar.skipToNext = 0;
        GlobalVar.skipToPrev = 0;
        GlobalVar.stopSong = 0;
        GlobalVar.missedCallGet = 0;
        GlobalVar.alertGet = 0;
        GlobalVar.launchMediaPlayer = 0;
        GlobalVar.volumeToSet = 0;
        GlobalVar.missedCallName = "";
        GlobalVar.missedCallNumber = "";
        GlobalVar.TBT_INFO_CHAR = null;
        GlobalVar.GENERAL_CHAR = null;
        GlobalVar.MISSED_CALL_CHAR = null;
        GlobalVar.ALERTS_INFO_CHAR = null;
        GlobalVar.MEDIA_INFO_CHAR = null;
        GlobalVar.CONTROL_CHAR = null;
        GlobalVar.callState = CallState.NO_CALL;
    }

    public void registerIphoneListener(IPhoneState iPhoneState) {
        iphoneState = iPhoneState;
    }

    public void registerNavigationCallback(NavigationCallback navigationCallback2) {
        navigationCallback = navigationCallback2;
    }

    public void registerTakeMeHomeCallback(TakeMeHome takeMeHome) {
        takeMeHomeCallback = takeMeHome;
    }

    public void listenMusic(final Context context, final MusicCallback musicCallback) {
        try {
            MediaSessionListener mediaSessionListener = this.mMediaSessionListener;
            if (mediaSessionListener != null) {
                mediaSessionListener.onStop();
                this.mMediaSessionListener = null;
            }
            this.mMediaSessionListener = new MediaSessionListener(context.getApplicationContext(), new MusicCallback() { // from class: com.bajajconnect.ble.BleFeatures.6
                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onPlaybackStateChange(PlayStatus playStatus) {
                    musicCallback.onPlaybackStateChange(playStatus);
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onMetadataChange(String str, int i, String str2, String str3, long j, Bitmap bitmap) {
                    musicCallback.onMetadataChange(str, i, str2, str3, j, bitmap);
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onQueueItemChange(ArrayList<Item_song> arrayList, String str) {
                    musicCallback.onQueueItemChange(arrayList, str);
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onCurrentSessionDestroyed() {
                    musicCallback.onCurrentSessionDestroyed();
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onMusicAppKilled() {
                    musicCallback.onMusicAppKilled();
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onActiveSessionFound(Context context2) {
                    musicCallback.onActiveSessionFound(context2);
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onCurrentPositionChange(int i, Long l) {
                    musicCallback.onCurrentPositionChange(i, l);
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onSessionReady(String str) {
                    musicCallback.onSessionReady(str);
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onSongSelected(int i) {
                    musicCallback.onSongSelected(i);
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onTrackListRequested(int i) {
                    musicCallback.onTrackListRequested(i);
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onFetchSpotifyPlaylist() {
                    musicCallback.onFetchSpotifyPlaylist();
                }

                @Override // com.bajajconnect.interfaces.MusicCallback
                public void onArtworkReady(Bitmap bitmap) {
                    try {
                        musicCallback.onArtworkReady(bitmap);
                    } catch (Exception unused) {
                    }
                }
            });
            if (MediaSessionListener.isNotificationListenerEnabled(context.getApplicationContext().getApplicationContext())) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleFeatures.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BleFeatures.this.mMediaSessionListener != null) {
                            BleFeatures.this.mMediaSessionListener.onCreate();
                            BleFeatures.this.mMediaSessionListener.onStart(context.getApplicationContext());
                        }
                    }
                }, 1500L);
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleFeatures$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$listenMusic$3(context, musicCallback);
                    }
                }, 5000L);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$listenMusic$3(Context context, MusicCallback musicCallback) {
        listenMusic(context.getApplicationContext(), musicCallback);
    }

    public void stopMusicListening() {
        try {
            MediaSessionListener mediaSessionListener = this.mMediaSessionListener;
            if (mediaSessionListener != null) {
                mediaSessionListener.onStop();
                this.mMediaSessionListener = null;
            }
        } catch (Exception unused) {
        }
    }

    public void sendPlaylistToCluster(List<SongInfo> list, int i) {
        Controls controls = this.controls;
        if (controls != null) {
            controls.sendPlaylist(list, i);
        }
    }

    public void sendResetPlaylistToCluster() {
        Controls controls = this.controls;
        if (controls != null) {
            controls.sendResetPlaylist();
        }
    }

    private static class MyPhoneStateListener extends TelephonyCallback implements TelephonyCallback.SignalStrengthsListener {
        private MyPhoneStateListener() {
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int level = signalStrength.getLevel();
            GlobalVar.signalStrength = Math.max(0, Math.min(level, 4));
            Log.d("BLE_SIGNAL", "onSignalStrengthsChanged (TelephonyCallback): raw=" + level + " stored=" + GlobalVar.signalStrength);
            if (BleFeatures.iphoneState != null) {
                BleFeatures.iphoneState.onSignalStrengthChange(GlobalVar.signalStrength);
            }
        }
    }

    public void setModelCode(String str) {
        this.modelCode = str;
    }

    public void setCurrentPack(String str) {
        this.currentPack = str;
    }
}
