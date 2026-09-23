package com.bajajconnect.ble;

import android.app.NotificationManager;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.CallLog;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import com.bajajconnect.MyNotificationService;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.ble.protocol.NewBtProtocolSelector;
import com.bajajconnect.enums.Alert;
import com.bajajconnect.enums.CallState;
import com.bajajconnect.enums.GpsStatus;
import com.bajajconnect.enums.PrimaryTurns;
import com.bajajconnect.enums.VehicleType;
import com.bajajconnect.features.VehicleFeature;
import com.bajajconnect.gMaps.ClusterNavigationLauncher;
import com.bajajconnect.interfaces.ContactCallback;
import com.bajajconnect.interfaces.NavigationCallback;
import com.bajajconnect.interfaces.TakeMeHome;
import com.bajajconnect.models.AlertModel;
import com.bajajconnect.models.MissedCallModel;
import com.bajajconnect.music.MusicCallbackImpl;
import com.bajajconnect.recievers.DialerCallGate;
import com.bajajconnect.recievers.IPhoneState;
import com.bajajconnect.utils.ContactsUtil;
import com.bajajconnect.utils.NavigationHelper;
import com.bajajconnect.utils.TbtNavFrame;
import com.bajajconnect.utils.Util;
import com.bajajconnect.variables.GlobalVar;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.google.maps.android.BuildConfig;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.models.LegStep;
import it.innove.Peripheral$$ExternalSyntheticApiModelOutline0;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class BleService extends Service implements IPhoneState, NavigationCallback, TakeMeHome {
    public static final String ACTION_CONNECT = "com.bajajconnect.ble.ACTION_BLE_CONNECT";
    public static final String ACTION_DISCONNECT = "com.bajajconnect.ble.ACTION_BLE_DISCONNECT";
    public static final String ACTION_START_BLE = "com.bajajconnect.ble.ACTION_BLE_START";
    public static final String ACTION_START_FOREGROUND = "com.bajajconnect.ble.ACTION_BLE_START_FOREGROUND";
    public static final String CHANNEL_ID = "ForegroundNotificationChannel";
    private static final String CPU_WAKE_LOCK_TAG = "BajajRideConnect:BleServiceCpuWakeLock";
    private static final long END_CALL_HOLD_MS = 500;
    private static final long MIN_OUTGOING_DISPLAY_MS = 2000;
    private static final long OUTGOING_ANSWER_POLL_MS = 500;
    private static final long SCAN_PERIOD = 10000;
    private static final long TBT_REROUTE_HOLD_MS = 12000;
    private static final int WRITE_RETRY_MAX = 5;
    private static BluetoothGatt mBluetoothGatt;
    private static volatile BleService sInstance;
    private BluetoothDevice bluetoothDevice;
    BluetoothLeScanner bluetoothLeScanner;
    private PowerManager.WakeLock cpuWakeLock;
    private Runnable endCallClearRunnable;
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothManager mBluetoothManager;
    private Handler mHandler;
    private Runnable outgoingAnswerWatchRunnable;
    private Runnable pendingReconnectRunnable;
    private Runnable scanTimeoutRunnable;
    public static final Queue<AlertModel> alertsList = new LinkedList();
    public static final Queue<MissedCallModel> missedCallList = new LinkedList();
    private static final Queue<String> descriptorWriteQueueS = new LinkedList();
    private static final Queue<BluetoothGattCharacteristic> characteristicReadQueue = new LinkedList();
    private static final Queue<PendingWrite> characteristicWriteQueue = new LinkedList();
    private static final Queue<BleRequest> characteristicQueue = new LinkedList();
    private static final long[] RECONNECT_BACKOFF_MS = {1500, 2500, 4000, 6000, 8000};
    private static final UUID CCCD_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private final ScanFilter scanFilter = new ScanFilter.Builder().build();
    private long lastTbtMillis = 0;
    public boolean shouldConnect = true;
    public boolean isSecondCall = false;
    int resetQueueTimer = 2;
    private long millisec = 1;
    private boolean readFlag = false;
    private long writeCounter = 1;
    private long writeCounterCheck = 1;
    private int reconnectAttempt = 0;
    private volatile boolean autoConnectInProgress = false;
    private ScheduledExecutorService readScheduler = null;
    private volatile NavInfo latestGoogleNavInfo = null;
    private ScheduledExecutorService googleTbtScheduler = null;
    private volatile boolean googleDestinationReachedAnnounced = false;
    private volatile long tbtRerouteHoldUntilMs = 0;
    private volatile int lastTbtStepMeters = 0;
    private volatile int lastTbtTotalMeters = 0;
    private volatile int lastTbtEtaHour = 0;
    private volatile int lastTbtEtaMinute = 0;
    private volatile boolean lastTbtEtaAm = true;
    private boolean hasSentFavRecentForCurrentConnection = false;
    private boolean hasRePushedMediaForCurrentConnection = false;
    private final Map<String, String> scanNameCache = new HashMap();
    private volatile String bondingInProgressAddress = null;
    private final Handler callStateHandler = new Handler(Looper.getMainLooper());
    private long outgoingDialStartedAtMs = 0;
    private long outgoingNotifWhenBaseline = -1;
    private final BluetoothGattCallback mGattCallback = new AnonymousClass3();
    private final BroadcastReceiver mPairReceiver = new BroadcastReceiver() { // from class: com.bajajconnect.ble.BleService.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
                if (intExtra != 12 || intExtra2 != 11) {
                    if (intExtra == 10 && intExtra2 == 11) {
                        Log.w("BLE", "bond failed or cancelled; clearing bonding guard");
                        BleService.this.bondingInProgressAddress = null;
                        return;
                    }
                    return;
                }
                Log.e("BluetoothService", "device bonded");
                BleService.this.bondingInProgressAddress = null;
                BleService bleService = BleService.this;
                bleService.connect(bleService.bluetoothDevice.getAddress());
                try {
                    BleService.this.unregisterReceiver(this);
                } catch (Exception unused) {
                }
            }
        }
    };
    private final ScanCallback mLeScanCallback = new ScanCallback() { // from class: com.bajajconnect.ble.BleService.5
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            Log.d("BLE", "onScanResult: mLeScanCallback");
            try {
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    String strResolveScanDeviceName = BleService.this.resolveScanDeviceName(scanResult);
                    String address = scanResult.getDevice().getAddress();
                    boolean z = (address == null || GlobalVar.bleDeviceAddress == null || GlobalVar.bleDeviceAddress.isEmpty() || !address.equalsIgnoreCase(GlobalVar.bleDeviceAddress)) ? false : true;
                    boolean zClusterNamesMatch = BleService.clusterNamesMatch(GlobalVar.bleDeviceName, strResolveScanDeviceName);
                    Log.d("BLE", "onScanResult: name=" + strResolveScanDeviceName + " mac=" + address + " targetName=" + GlobalVar.bleDeviceName + " targetMac=" + GlobalVar.bleDeviceAddress + " nameMatch=" + zClusterNamesMatch + " macMatch=" + z);
                    if (zClusterNamesMatch || z) {
                        if (strResolveScanDeviceName == null) {
                            strResolveScanDeviceName = GlobalVar.bleDeviceName;
                        }
                        GlobalVar.vehicleType = VehicleType.fromDeviceName(strResolveScanDeviceName);
                        Log.d("BLE", "Target matched — connecting. vehicleType=" + GlobalVar.vehicleType + " mac=" + address);
                        BleService.this.scanLeDevice(false);
                        if (!GlobalVar.isBlueToothConnected) {
                            BleService.this.bluetoothDevice = scanResult.getDevice();
                            int bondState = BleService.this.bluetoothDevice.getBondState();
                            if (bondState == 12) {
                                BleService.this.connect(scanResult.getDevice().getAddress());
                            } else if (bondState == 11) {
                                Log.d("BLE", "createBond skipped — already BOND_BONDING mac=" + address);
                                BleService bleService = BleService.this;
                                bleService.registerReceiver(bleService.mPairReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
                            } else {
                                String str = BleService.this.bondingInProgressAddress;
                                if (str == null || !str.equalsIgnoreCase(address)) {
                                    BleService.this.bondingInProgressAddress = address;
                                    try {
                                        BleService bleService2 = BleService.this;
                                        bleService2.registerReceiver(bleService2.mPairReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
                                    } catch (Exception unused) {
                                    }
                                    boolean zCreateBond = BleService.this.bluetoothDevice.createBond();
                                    Log.d("BLE", "createBond(" + address + ") started=" + zCreateBond);
                                    if (!zCreateBond) {
                                        BleService.this.bondingInProgressAddress = null;
                                    }
                                } else {
                                    Log.d("BLE", "createBond skipped — already in flight mac=" + address);
                                }
                            }
                        }
                    }
                    super.onScanResult(i, scanResult);
                }
            } catch (Exception unused2) {
            }
        }
    };

    public static class BleRequest {
        public BluetoothGattCharacteristic characteristic;
        public BluetoothGattDescriptor descriptor;
        public int id;
        public BleRequestOperation operation;
    }

    public enum BleRequestOperation {
        write,
        read,
        enableNotification
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onHeadsetConnected() {
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onHeadsetDisconnected() {
    }

    private ScanSettings getScanSettings() {
        return new ScanSettings.Builder().setScanMode(2).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushGeneralStatusIfReady(String str) {
        if (GlobalVar.isBlueToothConnected) {
            if (!GlobalVar.isMTUIncreased || GlobalVar.GENERAL_CHAR == null) {
                StringBuilder sb = new StringBuilder("pushGeneralStatusIfReady skipped (");
                sb.append(str);
                sb.append(") mtu=");
                sb.append(GlobalVar.isMTUIncreased);
                sb.append(" generalChar=");
                sb.append(GlobalVar.GENERAL_CHAR != null);
                Log.d("BLE", sb.toString());
                return;
            }
            try {
                prepareCharAndWrite(GlobalVar.GENERAL_CHAR, CallFrame.generalForVehicle());
                Log.i("BLE", "pushGeneralStatusIfReady ok (" + str + ")");
            } catch (Exception e) {
                Log.w("BLE", "pushGeneralStatusIfReady failed (" + str + ")", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleFavRecentSendIfNeeded(String str) {
        if (!VehicleFeature.BLE_FAV_RECENT_CALLS.isEnabledFor(BleFeatures.getInstance().modelCode)) {
            Log.i("BLE_FAV_RC", str + ": skipped — SKU has no fav/recent capability");
            return;
        }
        if (this.hasSentFavRecentForCurrentConnection) {
            Log.i("BLE_FAV_RC", str + ": fav/recent already sent for this connection; skipping");
            return;
        }
        this.hasSentFavRecentForCurrentConnection = true;
        Log.i("BLE_FAV_RC", str + ": scheduling fav contacts + recent calls for " + GlobalVar.vehicleType);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleFavRecentSendIfNeeded$1();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleFavRecentSendIfNeeded$1() {
        try {
            Log.i("BLE_FAV_RC", "Sending fav contacts now...");
            FavContactsFrame.sendFavContacts(getApplicationContext());
        } catch (Exception e) {
            Log.e("BLE_FAV_RC", "FavContacts send failed", e);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleFavRecentSendIfNeeded$0();
            }
        }, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleFavRecentSendIfNeeded$0() {
        try {
            Log.i("BLE_FAV_RC", "Sending recent calls now...");
            RecentCallsFrame.sendRecentCalls(getApplicationContext());
        } catch (Exception e) {
            Log.e("BLE_FAV_RC", "RecentCalls send failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleMediaRePushIfNeeded(final String str) {
        if (this.hasRePushedMediaForCurrentConnection) {
            Log.i("BLE_MUSIC", str + ": media re-push already scheduled/done for this connection; skipping");
            return;
        }
        this.hasRePushedMediaForCurrentConnection = true;
        Log.i("BLE_MUSIC", str + ": scheduling now-playing re-push after reconnect");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                BleService.lambda$scheduleMediaRePushIfNeeded$2(str);
            }
        }, 900L);
    }

    static /* synthetic */ void lambda$scheduleMediaRePushIfNeeded$2(String str) {
        try {
            if (GlobalVar.isBlueToothConnected && GlobalVar.isMTUIncreased) {
                Log.i("BLE_MUSIC", "rePushMediaAfterBleReconnect(" + str + ") now");
                MusicCallbackImpl.rePushMediaAfterBleReconnect(str);
                return;
            }
            Log.w("BLE_MUSIC", "media re-push aborted — BLE not ready");
        } catch (Exception e) {
            Log.e("BLE_MUSIC", "media re-push failed", e);
        }
    }

    public static String bytesToHex(byte[] bArr) {
        if (bArr == null) {
            return BuildConfig.TRAVIS;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
            if (i < bArr.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static boolean isGattConnected() {
        return mBluetoothGatt != null && GlobalVar.isMTUIncreased;
    }

    private static int writeTypeForCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (bluetoothGattCharacteristic == null) {
            return 1;
        }
        String lowerCase = bluetoothGattCharacteristic.getUuid().toString().toLowerCase();
        int properties = bluetoothGattCharacteristic.getProperties();
        return (lowerCase.contains(GlobalVar.PLAYLIST_INFO.toLowerCase()) || (properties & 8) != 0 || (properties & 4) == 0) ? 2 : 1;
    }

    public static void prepareCharAndWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        if (bluetoothGattCharacteristic == null) {
            Timber.tag("BLE_DEBUG").d("prepareCharAndWrite: characteristic is null, cannot write playlist/notification", new Object[0]);
            return;
        }
        if (!GlobalVar.isMTUIncreased) {
            Timber.tag("BLE_DEBUG").d("prepareCharAndWrite: skipping write because MTU not increased. UUID=%s", bluetoothGattCharacteristic.getUuid().toString());
            return;
        }
        try {
            String string = bluetoothGattCharacteristic.getUuid().toString();
            int length = bArr != null ? bArr.length : 0;
            String lowerCase = string == null ? "" : string.toLowerCase();
            try {
                if (lowerCase.contains(GlobalVar.FAV_CONTACTS.toLowerCase()) || lowerCase.contains(GlobalVar.RECENT_CALLS.toLowerCase()) || lowerCase.contains(GlobalVar.PLAYLIST_INFO.toLowerCase()) || lowerCase.contains("0210676e-6972-6565-6e69-676e4543544f".toLowerCase()) || lowerCase.contains(GlobalVar.MEDIA_INFO.toLowerCase()) || lowerCase.contains(GlobalVar.MISSED_CALL.toLowerCase()) || lowerCase.contains(GlobalVar.ALERTS_INFO.toLowerCase())) {
                    Log.i("BLE_PACKET", "prepareCharAndWrite: UUID=" + string + " dataLen=" + length + " vehicle=" + GlobalVar.vehicleType + " sku=" + BleFeatures.getInstance().modelCode);
                }
            } catch (Exception unused) {
            }
            int iWriteTypeForCharacteristic = writeTypeForCharacteristic(bluetoothGattCharacteristic, length);
            bluetoothGattCharacteristic.setWriteType(iWriteTypeForCharacteristic);
            Log.i("BLE_PACKET", "prepareCharAndWrite: writeType=" + iWriteTypeForCharacteristic + " props=" + bluetoothGattCharacteristic.getProperties() + " UUID=" + string + " dataLen=" + length + " vehicle=" + GlobalVar.vehicleType);
        } catch (Exception unused2) {
            try {
                bluetoothGattCharacteristic.setWriteType(1);
            } catch (Exception unused3) {
            }
        }
        writeCharacteristic(new PendingWrite(bluetoothGattCharacteristic, bArr != null ? Arrays.copyOf(bArr, bArr.length) : null));
    }

    private static void writeHeadOfQueue() {
        PendingWrite pendingWriteElement;
        if (mBluetoothGatt != null) {
            Queue<PendingWrite> queue = characteristicWriteQueue;
            if (queue.isEmpty() || (pendingWriteElement = queue.element()) == null || pendingWriteElement.characteristic == null) {
                return;
            }
            refreshGeneralPayloadIfNeeded(pendingWriteElement);
            pendingWriteElement.characteristic.setValue(pendingWriteElement.payload);
            mBluetoothGatt.writeCharacteristic(pendingWriteElement.characteristic);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void refreshGeneralPayloadIfNeeded(PendingWrite pendingWrite) {
        if (pendingWrite != null) {
            try {
                if (pendingWrite.characteristic == null || GlobalVar.GENERAL_CHAR == null || !pendingWrite.characteristic.getUuid().equals(GlobalVar.GENERAL_CHAR.getUuid())) {
                    return;
                }
                pendingWrite.payload = CallFrame.generalForVehicle();
            } catch (Exception unused) {
            }
        }
    }

    private static void dropQueuedGeneralWritesExceptHead() {
        try {
            if (GlobalVar.GENERAL_CHAR == null) {
                return;
            }
            Iterator<PendingWrite> it2 = characteristicWriteQueue.iterator();
            boolean z = true;
            while (it2.hasNext()) {
                PendingWrite next = it2.next();
                if (z) {
                    z = false;
                } else if (next != null && next.characteristic != null && next.characteristic.getUuid().equals(GlobalVar.GENERAL_CHAR.getUuid())) {
                    it2.remove();
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void drainNoResponseWrite(final PendingWrite pendingWrite) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                BleService.lambda$drainNoResponseWrite$3(pendingWrite);
            }
        }, 40L);
    }

    static /* synthetic */ void lambda$drainNoResponseWrite$3(PendingWrite pendingWrite) {
        try {
            if (mBluetoothGatt != null) {
                Queue<PendingWrite> queue = characteristicWriteQueue;
                if (!queue.isEmpty() && queue.element() == pendingWrite) {
                    queue.remove();
                    if (queue.isEmpty()) {
                        return;
                    }
                    writeHeadOfQueue();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void writeCharacteristic(PendingWrite pendingWrite) {
        if (mBluetoothGatt == null) {
            Timber.tag("programming").d("BluetoothAdapter not initialized", new Object[0]);
            return;
        }
        if (pendingWrite != null) {
            try {
                if (pendingWrite.characteristic != null && GlobalVar.GENERAL_CHAR != null && pendingWrite.characteristic.getUuid().equals(GlobalVar.GENERAL_CHAR.getUuid())) {
                    dropQueuedGeneralWritesExceptHead();
                }
            } catch (Exception unused) {
            }
        }
        Queue<PendingWrite> queue = characteristicWriteQueue;
        queue.add(pendingWrite);
        if (queue.size() == 1) {
            try {
                final PendingWrite pendingWriteElement = queue.element();
                if (pendingWriteElement == null || pendingWriteElement.characteristic == null) {
                    return;
                }
                refreshGeneralPayloadIfNeeded(pendingWriteElement);
                pendingWriteElement.characteristic.setValue(pendingWriteElement.payload);
                boolean zWriteCharacteristic = mBluetoothGatt.writeCharacteristic(pendingWriteElement.characteristic);
                int length = pendingWriteElement.payload != null ? pendingWriteElement.payload.length : 0;
                int writeType = pendingWriteElement.characteristic.getWriteType();
                Log.i("BLE_PACKET", "writeCharacteristic: result=" + zWriteCharacteristic + " UUID=" + pendingWriteElement.characteristic.getUuid() + " len=" + length + " writeType=" + writeType);
                if (zWriteCharacteristic && writeType == 1) {
                    drainNoResponseWrite(pendingWriteElement);
                }
                if (zWriteCharacteristic) {
                    return;
                }
                if (pendingWriteElement.retryCount < 5) {
                    pendingWriteElement.retryCount++;
                    Timber.tag("BLE_DEBUG").d("writeCharacteristic: write returned false, scheduling retry %d for UUID=%s", Integer.valueOf(pendingWriteElement.retryCount), pendingWriteElement.characteristic.getUuid().toString());
                    final Handler handler = new Handler(Looper.getMainLooper());
                    final Runnable[] runnableArr = new Runnable[1];
                    runnableArr[0] = new Runnable() { // from class: com.bajajconnect.ble.BleService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (BleService.mBluetoothGatt != null && !BleService.characteristicWriteQueue.isEmpty()) {
                                    Object objElement = BleService.characteristicWriteQueue.element();
                                    PendingWrite pendingWrite2 = pendingWriteElement;
                                    if (objElement == pendingWrite2) {
                                        try {
                                            BleService.refreshGeneralPayloadIfNeeded(pendingWrite2);
                                            pendingWriteElement.characteristic.setValue(pendingWriteElement.payload);
                                            boolean zWriteCharacteristic2 = BleService.mBluetoothGatt.writeCharacteristic(pendingWriteElement.characteristic);
                                            Timber.tag("BLE_DEBUG").d("writeCharacteristic: retry %d result=%s UUID=%s", Integer.valueOf(pendingWriteElement.retryCount), String.valueOf(zWriteCharacteristic2), pendingWriteElement.characteristic.getUuid().toString());
                                            if (!zWriteCharacteristic2 && pendingWriteElement.retryCount < 5) {
                                                pendingWriteElement.retryCount++;
                                                handler.postDelayed(runnableArr[0], 200L);
                                            }
                                        } catch (Exception e) {
                                            Timber.tag("BLE_DEBUG").d("writeCharacteristic: retry exception: %s", e.getMessage());
                                        }
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                        }
                    };
                    handler.postDelayed(runnableArr[0], 200L);
                    return;
                }
                Timber.tag("BLE_DEBUG").d("writeCharacteristic: reached max retries for UUID=%s, giving up", pendingWriteElement.characteristic.getUuid().toString());
            } catch (Exception unused2) {
            }
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onSignalStrengthChange(int i) {
        Log.d("processData", "onSignalStrengthChange: " + i);
        if (GlobalVar.signalStrength != i) {
            GlobalVar.signalStrength = i;
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onBatteryPercentageChange(int i) {
        if (GlobalVar.batteryPercentage != i) {
            GlobalVar.batteryPercentage = i;
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onSmsReceived(Context context, final String str) {
        StringBuilder sb = new StringBuilder("onSmsReceived: numberLen=");
        sb.append(str != null ? str.length() : 0);
        sb.append(" btConnected=");
        sb.append(GlobalVar.isBlueToothConnected);
        Log.d("BLE_NOTIFY", sb.toString());
        if (GlobalVar.isBlueToothConnected) {
            GlobalVar.smsCount++;
            Log.d("BLE_NOTIFY", "smsCount incremented to " + GlobalVar.smsCount);
            ContactsUtil.getContactName(this, str, new ContactCallback() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda6
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BleService.lambda$onSmsReceived$4(str, str2);
                }
            });
        }
    }

    static /* synthetic */ void lambda$onSmsReceived$4(String str, String str2) {
        AlertModel alertModel;
        if (Objects.equals(str2, "") || Objects.equals(str2, StringUtils.SPACE)) {
            alertModel = new AlertModel(GlobalVar.smsCount, Alert.SMS, str, Util.getTimeStamp());
        } else {
            alertModel = new AlertModel(GlobalVar.smsCount, Alert.SMS, str2, Util.getTimeStamp());
        }
        alertsList.add(alertModel);
        Log.d("BLE_NOTIFY", "Writing SMS alert to ALERTS_INFO_CHAR: name=" + alertModel.getName());
        prepareCharAndWrite(GlobalVar.ALERTS_INFO_CHAR, CallFrame.alertsForVehicle(alertModel.getType(), alertModel.getName(), alertModel.getTimestamp()));
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onNotificationRecieved(Context context, String str) {
        Log.d("BLE_NOTIFY", "onNotificationRecieved: name=" + str + " btConnected=" + GlobalVar.isBlueToothConnected);
        if (GlobalVar.isBlueToothConnected) {
            GlobalVar.smsCount++;
            AlertModel alertModel = new AlertModel(GlobalVar.smsCount, Alert.WAPP, str, Util.getTimeStamp());
            alertsList.add(alertModel);
            Log.d("BLE_NOTIFY", "Writing WAPP alert to ALERTS_INFO_CHAR: name=" + alertModel.getName());
            prepareCharAndWrite(GlobalVar.ALERTS_INFO_CHAR, CallFrame.alertsForVehicle(alertModel.getType(), alertModel.getName(), alertModel.getTimestamp()));
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onIncoming(Context context, String str, Date date) {
        Log.d("BLE_NOTIFY", "onIncoming: number=" + str + " currentCallState=" + GlobalVar.callState);
        if (DialerCallGate.shouldSuppressTelephonyCallEvents(context)) {
            Log.d("BLE_NOTIFY", "onIncoming skipped — non-dialer/VoIP call");
            DialerCallGate.clearClusterCallState("onIncoming suppressed");
            return;
        }
        if (shouldAcceptIncomingRing()) {
            cancelPendingEndCallClear();
            applyIncomingCaller(context, str);
            return;
        }
        this.isSecondCall = true;
        Log.d("BLE_NOTIFY", "Second call detected, ignoring (state=" + GlobalVar.callState + " offhook=" + isTelephonyStillOffhook() + ")");
    }

    private boolean shouldAcceptIncomingRing() {
        CallState callState = GlobalVar.callState;
        if (callState != null && callState != CallState.NO_CALL && callState != CallState.INCOMING_CALL && callState != CallState.END_CALL) {
            if (isTelephonyStillOffhook()) {
                return false;
            }
            Log.w("BLE_NOTIFY", "onIncoming: replacing stale cluster state " + callState + " (modem not OFFHOOK)");
        }
        return true;
    }

    private void applyIncomingCaller(Context context, String str) {
        final String strTrim = str == null ? "" : str.trim();
        stopOutgoingAnswerWatch();
        GlobalVar.callProgressCount = 0;
        if (strTrim.isEmpty()) {
            GlobalVar.callerNumber = "";
            GlobalVar.callerName = "";
            GlobalVar.callState = CallState.INCOMING_CALL;
            Log.d("BLE_NOTIFY", "INCOMING CALL waiting for number — cleared stale caller, no name push");
            return;
        }
        GlobalVar.callState = CallState.INCOMING_CALL;
        GlobalVar.callerNumber = strTrim;
        GlobalVar.callerName = strTrim;
        Log.d("BLE_NOTIFY", "INCOMING CALL immediate: callerName=" + GlobalVar.callerName);
        pushGeneralFrameForCallState("incoming:immediate");
        try {
            ContactsUtil.getContactName(context, strTrim, new ContactCallback() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda13
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BleService.lambda$applyIncomingCaller$5(strTrim, str2);
                }
            });
        } catch (Exception e) {
            Log.d("BLE_NOTIFY", "Error in applyIncomingCaller: " + e.getMessage());
        }
    }

    static /* synthetic */ void lambda$applyIncomingCaller$5(String str, String str2) {
        if (GlobalVar.callState == CallState.INCOMING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL) {
            if (numbersLooselyMatch(GlobalVar.callerNumber, str) || Objects.equals(GlobalVar.callerNumber, str)) {
                if (str2 != null && !str2.trim().isEmpty()) {
                    str = str2.trim();
                }
                if (Objects.equals(GlobalVar.callerName, str)) {
                    pushGeneralFrameForCallState("incoming:lookupUnchanged");
                    return;
                }
                GlobalVar.callerName = str;
                Log.d("BLE_NOTIFY", "INCOMING CALL resolved: callerName=" + str);
                pushGeneralFrameForCallState("incoming:lookupResolved");
            }
        }
    }

    private void applyOutgoingCaller(Context context, String str) {
        String strTrim;
        String strTrim2 = "";
        final String strTrim3 = str == null ? "" : str.trim();
        if (strTrim3.isEmpty()) {
            if (GlobalVar.callerNumber == null) {
                strTrim3 = "";
            } else {
                strTrim3 = GlobalVar.callerNumber.trim();
            }
            if (strTrim3.isEmpty() || GlobalVar.callState != CallState.OUTGOING_CALL) {
                strTrim3 = peekLatestOutgoingNumber(context);
            }
        }
        if (strTrim3.isEmpty()) {
            Log.d("BLE_NOTIFY", "applyOutgoingCaller: no number yet — publishing OUTGOING placeholder");
            GlobalVar.callState = CallState.OUTGOING_CALL;
            GlobalVar.callProgressCount = 0;
            String strPeekCellularCallDisplayName = MyNotificationService.peekCellularCallDisplayName();
            if (GlobalVar.callerName == null || GlobalVar.callerName.trim().isEmpty() || "Outgoing".equalsIgnoreCase(GlobalVar.callerName.trim())) {
                if (!strPeekCellularCallDisplayName.isEmpty()) {
                    applyDialerIdentityToOutgoing(strPeekCellularCallDisplayName, "applyOutgoingCaller:noNumber");
                } else if (GlobalVar.callerName == null || GlobalVar.callerName.trim().isEmpty()) {
                    GlobalVar.callerName = "Outgoing";
                }
            }
            refreshAllQueuedGeneralPayloads();
            pushGeneralFrameForCallState("applyOutgoingCaller:noNumber");
            startOutgoingAnswerWatch();
            return;
        }
        if (GlobalVar.callerName == null) {
            strTrim = "";
        } else {
            strTrim = GlobalVar.callerName.trim();
        }
        if (GlobalVar.callerNumber != null) {
            strTrim2 = GlobalVar.callerNumber.trim();
        }
        final boolean z = (strTrim2.isEmpty() || !numbersLooselyMatch(strTrim2, strTrim3) || strTrim.isEmpty() || strTrim.equals(strTrim3) || strTrim.equals(strTrim2) || "Outgoing".equalsIgnoreCase(strTrim)) ? false : true;
        GlobalVar.callerNumber = strTrim3;
        GlobalVar.callState = CallState.OUTGOING_CALL;
        GlobalVar.callProgressCount = 0;
        if (z) {
            Log.d("BLE_NOTIFY", "OUTGOING CALL keeping pre-set name=\"" + strTrim + "\" (from handlebar dial) for number=" + strTrim3);
        } else {
            if (!strTrim.isEmpty() && !strTrim.equals(strTrim3) && !"Outgoing".equalsIgnoreCase(strTrim)) {
                Log.d("BLE_NOTIFY", "OUTGOING CALL discarding stale caller name=\"" + strTrim + "\" (prevNumber=\"" + strTrim2 + "\" != new " + strTrim3 + ")");
            }
            String strPeekCellularCallDisplayName2 = MyNotificationService.peekCellularCallDisplayName();
            if (!strPeekCellularCallDisplayName2.isEmpty() && !looksLikePhoneNumber(strPeekCellularCallDisplayName2) && !"Outgoing".equalsIgnoreCase(strPeekCellularCallDisplayName2)) {
                GlobalVar.callerName = strPeekCellularCallDisplayName2;
                Log.d("BLE_NOTIFY", "OUTGOING CALL using dialer notif name=\"" + strPeekCellularCallDisplayName2 + "\" for number=" + strTrim3);
            } else {
                GlobalVar.callerName = strTrim3;
            }
        }
        refreshAllQueuedGeneralPayloads();
        pushGeneralFrameForCallState("applyOutgoingCaller");
        startOutgoingAnswerWatch();
        try {
            ContactsUtil.getContactName(context, strTrim3, new ContactCallback() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda18
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BleService.lambda$applyOutgoingCaller$6(strTrim3, z, str2);
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void lambda$applyOutgoingCaller$6(String str, boolean z, String str2) {
        if (GlobalVar.callState == CallState.OUTGOING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL) {
            if (numbersLooselyMatch(GlobalVar.callerNumber, str) || Objects.equals(GlobalVar.callerNumber, str)) {
                String strTrim = str2 == null ? "" : str2.trim();
                if (strTrim.isEmpty()) {
                    Log.d("BLE_NOTIFY", "OUTGOING CALL lookup: no contact for " + str + " (preResolved=" + z + ")");
                    pushGeneralFrameForCallState("outgoing:lookupNoMatch");
                    return;
                }
                if (Objects.equals(GlobalVar.callerName, strTrim)) {
                    pushGeneralFrameForCallState("outgoing:lookupUnchanged");
                    return;
                }
                if (!z) {
                    String strTrim2 = GlobalVar.callerName != null ? GlobalVar.callerName.trim() : "";
                    if (!strTrim2.isEmpty() && !"Outgoing".equalsIgnoreCase(strTrim2) && !looksLikePhoneNumber(strTrim2) && !numbersLooselyMatch(strTrim2, str)) {
                        pushGeneralFrameForCallState("outgoing:lookupSkippedExistingName");
                        return;
                    }
                    GlobalVar.callerName = strTrim;
                    Log.d("BLE_NOTIFY", "OUTGOING CALL resolved: callerName=" + strTrim);
                    pushGeneralFrameForCallState("outgoing:lookupResolved");
                    return;
                }
                pushGeneralFrameForCallState("outgoing:lookupSkippedPreResolved");
            }
        }
    }

    public static void maybeUpgradeOutgoingCallerFromDialer(String str, String str2) {
        BleService bleService;
        if (str == null) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty() || GlobalVar.callState != CallState.OUTGOING_CALL || (bleService = sInstance) == null) {
            return;
        }
        bleService.applyDialerIdentityToOutgoing(strTrim, str2);
    }

    private void applyDialerIdentityToOutgoing(String str, final String str2) {
        if (str == null) {
            return;
        }
        final String strTrim = str.trim();
        if (strTrim.isEmpty() || "Outgoing".equalsIgnoreCase(strTrim) || GlobalVar.callState != CallState.OUTGOING_CALL) {
            return;
        }
        String strTrim2 = GlobalVar.callerName == null ? "" : GlobalVar.callerName.trim();
        String strTrim3 = GlobalVar.callerNumber != null ? GlobalVar.callerNumber.trim() : "";
        boolean z = strTrim2.isEmpty() || "Outgoing".equalsIgnoreCase(strTrim2) || looksLikePhoneNumber(strTrim2) || (!strTrim3.isEmpty() && (strTrim2.equals(strTrim3) || numbersLooselyMatch(strTrim2, strTrim3)));
        if (looksLikePhoneNumber(strTrim)) {
            if (strTrim3.isEmpty()) {
                GlobalVar.callerNumber = strTrim;
            }
            if (z && !Objects.equals(strTrim2, strTrim)) {
                GlobalVar.callerName = strTrim;
                refreshAllQueuedGeneralPayloads();
                pushGeneralFrameForCallState("dialerIdentity:number:" + str2);
            }
            if (z) {
                if (GlobalVar.callerNumber != null && !GlobalVar.callerNumber.trim().isEmpty()) {
                    strTrim = GlobalVar.callerNumber.trim();
                }
                try {
                    ContactsUtil.getContactName(this, strTrim, new ContactCallback() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda12
                        @Override // com.bajajconnect.interfaces.ContactCallback
                        public final void result(String str3) {
                            BleService.lambda$applyDialerIdentityToOutgoing$7(strTrim, str2, str3);
                        }
                    });
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        if ((z || strTrim2.isEmpty()) && !Objects.equals(strTrim2, strTrim)) {
            GlobalVar.callerName = strTrim;
            Log.d("BLE_NOTIFY", "OUTGOING caller upgraded from dialer: \"" + strTrim + "\" (" + str2 + ")");
            refreshAllQueuedGeneralPayloads();
            StringBuilder sb = new StringBuilder("dialerIdentity:name:");
            sb.append(str2);
            pushGeneralFrameForCallState(sb.toString());
        }
    }

    static /* synthetic */ void lambda$applyDialerIdentityToOutgoing$7(String str, String str2, String str3) {
        if (GlobalVar.callState == CallState.OUTGOING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL) {
            String strTrim = str3 == null ? "" : str3.trim();
            if (strTrim.isEmpty() || Objects.equals(GlobalVar.callerName, strTrim)) {
                return;
            }
            String strTrim2 = GlobalVar.callerName != null ? GlobalVar.callerName.trim() : "";
            if (strTrim2.isEmpty() || "Outgoing".equalsIgnoreCase(strTrim2) || looksLikePhoneNumber(strTrim2) || numbersLooselyMatch(strTrim2, str)) {
                GlobalVar.callerName = strTrim;
                refreshAllQueuedGeneralPayloads();
                pushGeneralFrameForCallState("dialerIdentity:lookup:" + str2);
            }
        }
    }

    private static boolean looksLikePhoneNumber(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return false;
        }
        String strReplaceAll = strTrim.replaceAll("\\D", "");
        if (strReplaceAll.length() < 5) {
            return false;
        }
        return strReplaceAll.length() * 2 >= strTrim.replaceAll("\\s", "").length();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a4 A[DONT_GENERATE, PHI: r4
      0x00a4: PHI (r4v1 android.database.Cursor) = (r4v0 android.database.Cursor), (r4v2 android.database.Cursor) binds: [B:32:0x00a2, B:26:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    private static String peekLatestOutgoingNumber(Context context) {
        if (context == null) {
            return "";
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "duration"}, "type=?", new String[]{String.valueOf(2)}, "date DESC LIMIT 1");
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                return "";
            }
            String string = cursorQuery.getString(0);
            long j = cursorQuery.getLong(1);
            int i = cursorQuery.getInt(2);
            long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : Long.MAX_VALUE;
            if (i <= 0 && jCurrentTimeMillis <= 60000) {
                return string != null ? string.trim() : "";
            }
            Log.d("BLE_NOTIFY", "peekLatestOutgoingNumber: ignoring CallLog row ageMs=" + jCurrentTimeMillis + " duration=" + i);
            return "";
        } catch (Exception e) {
            Log.w("BLE_NOTIFY", "peekLatestOutgoingNumber failed: " + e.getMessage());
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    private static boolean numbersLooselyMatch(String str, String str2) {
        if (str != null && str2 != null) {
            String strReplaceAll = str.replaceAll("\\D", "");
            String strReplaceAll2 = str2.replaceAll("\\D", "");
            if (!strReplaceAll.isEmpty() && !strReplaceAll2.isEmpty()) {
                if (strReplaceAll.length() > 10) {
                    strReplaceAll = strReplaceAll.substring(strReplaceAll.length() - 10);
                }
                if (strReplaceAll2.length() > 10) {
                    strReplaceAll2 = strReplaceAll2.substring(strReplaceAll2.length() - 10);
                }
                return strReplaceAll.equals(strReplaceAll2);
            }
        }
        return false;
    }

    private static void pushGeneralFrameForCallState(String str) {
        try {
            if (!isGattConnected() || GlobalVar.GENERAL_CHAR == null) {
                return;
            }
            byte[] bArrGeneralForVehicle = CallFrame.generalForVehicle();
            int i = bArrGeneralForVehicle.length > 1 ? bArrGeneralForVehicle[1] & 255 : -1;
            int i2 = i >= 0 ? i & 15 : -1;
            StringBuilder sb = new StringBuilder("pushGeneralFrameForCallState: ");
            sb.append(str);
            sb.append(" state=");
            sb.append(GlobalVar.callState);
            sb.append(" call_state_nibble=");
            sb.append(i2);
            sb.append(" byte1=0x");
            sb.append(Integer.toHexString(i));
            sb.append(" namePresent=");
            sb.append(bArrGeneralForVehicle.length > 18 ? bArrGeneralForVehicle[18] & 255 : -1);
            sb.append(" nameLen=");
            sb.append(bArrGeneralForVehicle.length > 19 ? bArrGeneralForVehicle[19] & 255 : -1);
            sb.append(" name=\"");
            sb.append(GlobalVar.callerName);
            sb.append("\"");
            Log.d("BLE_NOTIFY", sb.toString());
            prepareCharAndWrite(GlobalVar.GENERAL_CHAR, bArrGeneralForVehicle);
        } catch (Exception unused) {
        }
    }

    private void clearCallerInfo() {
        endCallAndClear("clearCallerInfo");
    }

    private void ensureCallerNameFallback() {
        if (GlobalVar.callerName == null || GlobalVar.callerName.trim().isEmpty()) {
            String strTrim = GlobalVar.callerNumber != null ? GlobalVar.callerNumber.trim() : "";
            if (strTrim.isEmpty()) {
                return;
            }
            GlobalVar.callerName = strTrim;
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onIncomingCallStarted(Context context, String str, Date date) {
        Log.d("BLE_NOTIFY", "onIncomingCallStarted (ANSWERED): " + str);
        if (DialerCallGate.shouldSuppressTelephonyCallEvents(context)) {
            Log.d("BLE_NOTIFY", "onIncomingCallStarted skipped — non-dialer/VoIP call");
            DialerCallGate.clearClusterCallState("onIncomingCallStarted suppressed");
        } else {
            GlobalVar.callState = CallState.ACTIVE_CALL;
            ensureCallerNameFallback();
            pushGeneralFrameForCallState("onIncomingCallStarted");
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onOutgoingCallStarted(Context context, String str, Date date) {
        Log.d("BLE_NOTIFY", "onOutgoingCallStarted: " + str);
        if (DialerCallGate.isWhatsAppVoipNotificationActive()) {
            Log.d("BLE_NOTIFY", "onOutgoingCallStarted skipped — WhatsApp VoIP active");
        } else {
            applyOutgoingCaller(context, str);
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onOutgoingCallConnected(Context context, String str, Date date) {
        Log.d("BLE_NOTIFY", "onOutgoingCallConnected (OFFHOOK/dialing): " + str);
        if (DialerCallGate.isWhatsAppVoipNotificationActive()) {
            Log.d("BLE_NOTIFY", "onOutgoingCallConnected skipped — WhatsApp VoIP active");
            DialerCallGate.clearClusterCallState("onOutgoingCallConnected whatsapp");
            stopOutgoingAnswerWatch();
            return;
        }
        String strTrim = "";
        final String strTrim2 = str == null ? "" : str.trim();
        if (strTrim2.isEmpty()) {
            if (GlobalVar.callerNumber != null) {
                strTrim = GlobalVar.callerNumber.trim();
            }
            strTrim2 = !strTrim.isEmpty() ? strTrim : peekLatestOutgoingNumber(context);
        }
        if (!strTrim2.isEmpty()) {
            GlobalVar.callerNumber = strTrim2;
            if (GlobalVar.callerName == null || GlobalVar.callerName.trim().isEmpty() || "Outgoing".equalsIgnoreCase(GlobalVar.callerName.trim())) {
                GlobalVar.callerName = strTrim2;
            }
        }
        GlobalVar.callState = CallState.OUTGOING_CALL;
        ensureCallerNameFallback();
        String strPeekCellularCallDisplayName = MyNotificationService.peekCellularCallDisplayName();
        if (!strPeekCellularCallDisplayName.isEmpty()) {
            applyDialerIdentityToOutgoing(strPeekCellularCallDisplayName, "onOutgoingCallConnected");
        }
        if (GlobalVar.callerName == null || GlobalVar.callerName.trim().isEmpty()) {
            GlobalVar.callerName = strTrim2.isEmpty() ? "Outgoing" : strTrim2;
        }
        refreshAllQueuedGeneralPayloads();
        pushGeneralFrameForCallState("onOutgoingCallConnected/stayOutgoing");
        startOutgoingAnswerWatch();
        if (strTrim2.isEmpty()) {
            return;
        }
        try {
            ContactsUtil.getContactName(context, strTrim2, new ContactCallback() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda11
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BleService.lambda$onOutgoingCallConnected$8(strTrim2, str2);
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void lambda$onOutgoingCallConnected$8(String str, String str2) {
        if (GlobalVar.callState == CallState.OUTGOING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL) {
            if (numbersLooselyMatch(GlobalVar.callerNumber, str) || Objects.equals(GlobalVar.callerNumber, str)) {
                String strTrim = str2 == null ? "" : str2.trim();
                if (strTrim.isEmpty() || Objects.equals(GlobalVar.callerName, strTrim)) {
                    return;
                }
                String strTrim2 = GlobalVar.callerName != null ? GlobalVar.callerName.trim() : "";
                if (strTrim2.isEmpty() || "Outgoing".equalsIgnoreCase(strTrim2) || looksLikePhoneNumber(strTrim2) || numbersLooselyMatch(strTrim2, str)) {
                    GlobalVar.callerName = strTrim;
                    pushGeneralFrameForCallState("outgoingOffhook:lookupResolved");
                }
            }
        }
    }

    public static void markOutgoingCallActive(String str) {
        if (GlobalVar.callState != CallState.OUTGOING_CALL) {
            return;
        }
        BleService bleService = sInstance;
        if (bleService != null && bleService.isTelephonyIdle()) {
            Log.d("BLE_NOTIFY", "markOutgoingCallActive skipped — telephony IDLE (" + str + ")");
            return;
        }
        if (bleService != null) {
            if (bleService.outgoingDialStartedAtMs <= 0) {
                bleService.outgoingDialStartedAtMs = System.currentTimeMillis();
                Log.d("BLE_NOTIFY", "markOutgoingCallActive deferred — started Outgoing clock (" + str + ")");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - bleService.outgoingDialStartedAtMs;
            if (jCurrentTimeMillis < MIN_OUTGOING_DISPLAY_MS) {
                Log.d("BLE_NOTIFY", "markOutgoingCallActive deferred — need Outgoing UI (" + jCurrentTimeMillis + "ms < 2000ms, reason=" + str + ")");
                return;
            }
        }
        GlobalVar.callState = CallState.ACTIVE_CALL;
        GlobalVar.callProgressCount = 0;
        Log.i("BLE_NOTIFY", "OUTGOING → ACTIVE (" + str + ") name=\"" + GlobalVar.callerName + "\" number=" + GlobalVar.callerNumber);
        refreshAllQueuedGeneralPayloads();
        StringBuilder sb = new StringBuilder("outgoingAnswered:");
        sb.append(str);
        pushGeneralFrameForCallState(sb.toString());
        if (bleService != null) {
            try {
                bleService.stopOutgoingAnswerWatch();
            } catch (Exception unused) {
            }
        }
    }

    public static long getOutgoingDialStartedAtMs() {
        BleService bleService = sInstance;
        if (bleService != null && GlobalVar.callState == CallState.OUTGOING_CALL) {
            return bleService.outgoingDialStartedAtMs;
        }
        return 0L;
    }

    public static void startOutgoingAnswerWatchFromDial() {
        BleService bleService = sInstance;
        if (bleService != null && GlobalVar.callState == CallState.OUTGOING_CALL) {
            bleService.startOutgoingAnswerWatch();
        }
    }

    private void startOutgoingAnswerWatch() {
        stopOutgoingAnswerWatch();
        this.outgoingDialStartedAtMs = System.currentTimeMillis();
        this.outgoingNotifWhenBaseline = -1L;
        Runnable runnable = new Runnable() { // from class: com.bajajconnect.ble.BleService.2
            int ticks = 0;

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (GlobalVar.callState != CallState.OUTGOING_CALL) {
                        return;
                    }
                    this.ticks++;
                    long jCurrentTimeMillis = System.currentTimeMillis() - BleService.this.outgoingDialStartedAtMs;
                    int i = this.ticks;
                    if (i <= 20 || i % 2 == 0) {
                        BleService.this.maybeRefreshOutgoingCallerIdentityWhileDialing();
                    }
                    if (jCurrentTimeMillis >= BleService.MIN_OUTGOING_DISPLAY_MS && MyNotificationService.isCellularCallChronometerActive()) {
                        BleService.markOutgoingCallActive("dialerNotif");
                        return;
                    }
                    long cellularCallNotificationWhen = MyNotificationService.getCellularCallNotificationWhen();
                    if (cellularCallNotificationWhen > 0) {
                        if (BleService.this.outgoingNotifWhenBaseline < 0) {
                            BleService.this.outgoingNotifWhenBaseline = cellularCallNotificationWhen;
                        } else if (cellularCallNotificationWhen > BleService.this.outgoingNotifWhenBaseline + 500 && jCurrentTimeMillis >= BleService.MIN_OUTGOING_DISPLAY_MS) {
                            BleService.markOutgoingCallActive("notifWhenAdvanced:" + BleService.this.outgoingNotifWhenBaseline + "→" + cellularCallNotificationWhen);
                            return;
                        }
                    }
                    if (jCurrentTimeMillis >= BleService.MIN_OUTGOING_DISPLAY_MS && BleService.this.isVoiceCallAudioActive()) {
                        BleService.markOutgoingCallActive("voiceCallAudio");
                        return;
                    }
                    if (this.ticks % 4 == 0) {
                        Log.d("BLE_NOTIFY", "outgoingAnswerWatch tick=" + this.ticks + " elapsedMs=" + jCurrentTimeMillis + " notifConnected=" + MyNotificationService.isCellularCallChronometerActive() + " notifWhen=" + cellularCallNotificationWhen + " whenBaseline=" + BleService.this.outgoingNotifWhenBaseline + " voiceAudio=" + BleService.this.isVoiceCallAudioActive());
                    }
                    if (this.ticks < 180) {
                        BleService.this.callStateHandler.postDelayed(this, 500L);
                    }
                } catch (Exception e) {
                    Log.w("BLE_NOTIFY", "outgoingAnswerWatch failed", e);
                }
            }
        };
        this.outgoingAnswerWatchRunnable = runnable;
        this.callStateHandler.postDelayed(runnable, 500L);
    }

    private void stopOutgoingAnswerWatch() {
        Runnable runnable = this.outgoingAnswerWatchRunnable;
        if (runnable != null) {
            this.callStateHandler.removeCallbacks(runnable);
            this.outgoingAnswerWatchRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeRefreshOutgoingCallerIdentityWhileDialing() {
        if (GlobalVar.callState != CallState.OUTGOING_CALL) {
            return;
        }
        String strTrim = GlobalVar.callerName == null ? "" : GlobalVar.callerName.trim();
        boolean z = strTrim.isEmpty() || "Outgoing".equalsIgnoreCase(strTrim) || looksLikePhoneNumber(strTrim);
        if (z) {
            String strPeekCellularCallDisplayName = MyNotificationService.peekCellularCallDisplayName();
            if (!strPeekCellularCallDisplayName.isEmpty()) {
                applyDialerIdentityToOutgoing(strPeekCellularCallDisplayName, "answerWatch");
                strTrim = GlobalVar.callerName == null ? "" : GlobalVar.callerName.trim();
                boolean z2 = strTrim.isEmpty() || "Outgoing".equalsIgnoreCase(strTrim) || looksLikePhoneNumber(strTrim);
                if (!z2) {
                    return;
                } else {
                    z = z2;
                }
            }
            if (GlobalVar.callerNumber == null || GlobalVar.callerNumber.trim().isEmpty() || z) {
                final String strPeekLatestOutgoingNumber = peekLatestOutgoingNumber(this);
                if (strPeekLatestOutgoingNumber.isEmpty()) {
                    return;
                }
                if (GlobalVar.callerNumber == null || GlobalVar.callerNumber.trim().isEmpty()) {
                    GlobalVar.callerNumber = strPeekLatestOutgoingNumber;
                }
                if (z) {
                    String strTrim2 = GlobalVar.callerNumber != null ? GlobalVar.callerNumber.trim() : "";
                    if (!strTrim2.isEmpty()) {
                        strPeekLatestOutgoingNumber = strTrim2;
                    }
                    if (strTrim.isEmpty() || "Outgoing".equalsIgnoreCase(strTrim)) {
                        GlobalVar.callerName = strPeekLatestOutgoingNumber;
                        refreshAllQueuedGeneralPayloads();
                        pushGeneralFrameForCallState("answerWatch:numberFromLog");
                    }
                    try {
                        ContactsUtil.getContactName(this, strPeekLatestOutgoingNumber, new ContactCallback() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda9
                            @Override // com.bajajconnect.interfaces.ContactCallback
                            public final void result(String str) {
                                BleService.lambda$maybeRefreshOutgoingCallerIdentityWhileDialing$9(strPeekLatestOutgoingNumber, str);
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    static /* synthetic */ void lambda$maybeRefreshOutgoingCallerIdentityWhileDialing$9(String str, String str2) {
        if (GlobalVar.callState == CallState.OUTGOING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL) {
            String strTrim = "";
            String strTrim2 = str2 == null ? "" : str2.trim();
            if (strTrim2.isEmpty() || Objects.equals(GlobalVar.callerName, strTrim2)) {
                return;
            }
            if (GlobalVar.callerName != null) {
                strTrim = GlobalVar.callerName.trim();
            }
            if (strTrim.isEmpty() || "Outgoing".equalsIgnoreCase(strTrim) || looksLikePhoneNumber(strTrim) || numbersLooselyMatch(strTrim, str)) {
                GlobalVar.callerName = strTrim2;
                refreshAllQueuedGeneralPayloads();
                pushGeneralFrameForCallState("answerWatch:lookupFromLog");
            }
        }
    }

    private boolean isTelephonyStillOffhook() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            return telephonyManager != null && telephonyManager.getCallState() == 2;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVoiceCallAudioActive() {
        int clientAudioSource;
        try {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (audioManager == null) {
                return false;
            }
            int mode = audioManager.getMode();
            if (mode != 2 && mode != 3) {
                return false;
            }
            for (AudioRecordingConfiguration audioRecordingConfiguration : audioManager.getActiveRecordingConfigurations()) {
                if (audioRecordingConfiguration != null && ((clientAudioSource = audioRecordingConfiguration.getClientAudioSource()) == 4 || clientAudioSource == 3 || clientAudioSource == 2 || clientAudioSource == 7)) {
                    return true;
                }
            }
            Iterator it2 = audioManager.getActivePlaybackConfigurations().iterator();
            while (it2.hasNext()) {
                AudioPlaybackConfiguration audioPlaybackConfigurationM2295m = Peripheral$$ExternalSyntheticApiModelOutline0.m2295m(it2.next());
                if (audioPlaybackConfigurationM2295m != null && audioPlaybackConfigurationM2295m.getAudioAttributes() != null && audioPlaybackConfigurationM2295m.getAudioAttributes().getUsage() == 2) {
                    return true;
                }
            }
        } catch (Exception e) {
            Log.w("BLE_NOTIFY", "isVoiceCallAudioActive failed: " + e.getMessage());
        }
        return false;
    }

    private void endCallAndClear(final String str) {
        stopOutgoingAnswerWatch();
        cancelPendingEndCallClear();
        dropQueuedGeneralWritesExceptHead();
        CallState callState = GlobalVar.callState;
        if (callState != CallState.NO_CALL && callState != CallState.END_CALL) {
            GlobalVar.callState = CallState.END_CALL;
            GlobalVar.callProgressCount = 0;
            refreshAllQueuedGeneralPayloads();
            pushGeneralFrameForCallState("endCall:" + str + " (was " + callState + ")");
            Runnable runnable = new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$endCallAndClear$10(str);
                }
            };
            this.endCallClearRunnable = runnable;
            this.callStateHandler.postDelayed(runnable, 500L);
            return;
        }
        GlobalVar.callState = CallState.NO_CALL;
        GlobalVar.callerName = "";
        GlobalVar.callerNumber = "";
        GlobalVar.callProgressCount = 0;
        refreshAllQueuedGeneralPayloads();
        pushGeneralFrameForCallState("clearIdle:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$endCallAndClear$10(String str) {
        dropQueuedGeneralWritesExceptHead();
        GlobalVar.callState = CallState.NO_CALL;
        GlobalVar.callerName = "";
        GlobalVar.callerNumber = "";
        GlobalVar.callProgressCount = 0;
        refreshAllQueuedGeneralPayloads();
        pushGeneralFrameForCallState("idleAfterEnd:" + str);
        this.endCallClearRunnable = null;
    }

    private void cancelPendingEndCallClear() {
        Runnable runnable = this.endCallClearRunnable;
        if (runnable != null) {
            this.callStateHandler.removeCallbacks(runnable);
            this.endCallClearRunnable = null;
        }
    }

    private static void refreshAllQueuedGeneralPayloads() {
        PendingWrite pendingWriteElement;
        try {
            if (GlobalVar.GENERAL_CHAR == null) {
                return;
            }
            Iterator<PendingWrite> it2 = characteristicWriteQueue.iterator();
            while (it2.hasNext()) {
                refreshGeneralPayloadIfNeeded(it2.next());
            }
            Queue<PendingWrite> queue = characteristicWriteQueue;
            if (queue.isEmpty() || (pendingWriteElement = queue.element()) == null || pendingWriteElement.characteristic == null || pendingWriteElement.payload == null || !pendingWriteElement.characteristic.getUuid().equals(GlobalVar.GENERAL_CHAR.getUuid())) {
                return;
            }
            pendingWriteElement.characteristic.setValue(pendingWriteElement.payload);
        } catch (Exception unused) {
        }
    }

    public static void forceClearClusterCall(String str) {
        BleService bleService = sInstance;
        if (bleService != null) {
            Log.w("BLE_NOTIFY", "forceClearClusterCall: " + str + " (was " + GlobalVar.callState + ")");
            StringBuilder sb = new StringBuilder("force:");
            sb.append(str);
            bleService.endCallAndClear(sb.toString());
            return;
        }
        GlobalVar.callState = CallState.NO_CALL;
        GlobalVar.callerName = "";
        GlobalVar.callerNumber = "";
        GlobalVar.callProgressCount = 0;
        refreshAllQueuedGeneralPayloads();
        pushGeneralFrameForCallState("force:" + str);
    }

    public static void clearStuckCallStateIfPhoneIdle(String str) {
        if (isClusterShowingInCall()) {
            if (GlobalVar.callState == CallState.OUTGOING_CALL) {
                BleService bleService = sInstance;
                if (bleService != null && bleService.outgoingAnswerWatchRunnable != null) {
                    Log.d("BLE_NOTIFY", "clearStuckCallStateIfPhoneIdle skipped — Outgoing dial watch active (" + str + ")");
                    return;
                }
                if (bleService != null && bleService.outgoingDialStartedAtMs > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - bleService.outgoingDialStartedAtMs;
                    if (jCurrentTimeMillis >= 0 && jCurrentTimeMillis < 90000) {
                        Log.d("BLE_NOTIFY", "clearStuckCallStateIfPhoneIdle skipped — Outgoing dial window (" + jCurrentTimeMillis + "ms, " + str + ")");
                        return;
                    }
                }
            }
            BleService bleService2 = sInstance;
            if (bleService2 != null) {
                if (bleService2.isTelephonyIdle()) {
                    Log.w("BLE_NOTIFY", "clearStuckCallStateIfPhoneIdle: " + str + " (was " + GlobalVar.callState + " number=" + GlobalVar.callerNumber + ")");
                    StringBuilder sb = new StringBuilder("stuckIdle:");
                    sb.append(str);
                    bleService2.endCallAndClear(sb.toString());
                    return;
                }
                return;
            }
            if (isTelephonyIdleStatic(null)) {
                Log.w("BLE_NOTIFY", "clearStuckCallStateIfPhoneIdle(no svc): " + str);
                GlobalVar.callState = CallState.NO_CALL;
                GlobalVar.callerName = "";
                GlobalVar.callerNumber = "";
                GlobalVar.callProgressCount = 0;
                refreshAllQueuedGeneralPayloads();
                pushGeneralFrameForCallState("stuckIdle:" + str);
            }
        }
    }

    private static boolean isClusterShowingInCall() {
        return GlobalVar.callState == CallState.ACTIVE_CALL || GlobalVar.callState == CallState.INCOMING_CALL || GlobalVar.callState == CallState.OUTGOING_CALL || GlobalVar.callState == CallState.END_CALL;
    }

    private boolean isTelephonyIdle() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            return telephonyManager == null || telephonyManager.getCallState() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isTelephonyIdleStatic(Context context) {
        if (context == null) {
            try {
                if (sInstance != null) {
                    context = sInstance;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        if (context == null) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        return telephonyManager == null || telephonyManager.getCallState() == 0;
    }

    private boolean shouldClearOnCallEnded(String str) {
        if (isTelephonyIdle()) {
            if (isEndEventForCurrentCall(str)) {
                return true;
            }
            Log.w("BLE_NOTIFY", "shouldClearOnCallEnded: number mismatch but telephony IDLE — forcing clear (end=\"" + str + "\" current=\"" + GlobalVar.callerNumber + "\" state=" + GlobalVar.callState + ")");
            return true;
        }
        boolean zIsEndEventForCurrentCall = isEndEventForCurrentCall(str);
        if (!zIsEndEventForCurrentCall) {
            Log.d("BLE_NOTIFY", "shouldClearOnCallEnded: skip — telephony still up and end=\"" + str + "\" != current=\"" + GlobalVar.callerNumber + "\"");
        }
        return zIsEndEventForCurrentCall;
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onIncomingCallEnded(Context context, String str, Date date, Date date2) {
        Log.d("BLE_NOTIFY", "onIncomingCallEnded: " + str + " state=" + GlobalVar.callState + " telephonyIdle=" + isTelephonyIdle());
        this.isSecondCall = false;
        String strFirstNonEmpty = firstNonEmpty(str, GlobalVar.callerNumber);
        if (GlobalVar.callState != CallState.ACTIVE_CALL) {
            CallState callState = GlobalVar.callState;
            CallState callState2 = CallState.INCOMING_CALL;
        }
        if (shouldClearOnCallEnded(str)) {
            clearCallerInfo();
        } else {
            Log.d("BLE_NOTIFY", "onIncomingCallEnded skipped clearCallerInfo — end event for " + str + " but current callerNumber=\"" + GlobalVar.callerNumber + "\" (state=" + GlobalVar.callState + "); likely late IDLE for a previous call");
        }
        refreshRecentCallsAfterCallEnd(context, "incomingEnd", strFirstNonEmpty, 1);
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onOutgoingCallEnded(Context context, String str, Date date, Date date2) {
        Log.d("BLE_NOTIFY", "onOutgoingCallEnded: " + str + " state=" + GlobalVar.callState + " telephonyIdle=" + isTelephonyIdle());
        String strFirstNonEmpty = firstNonEmpty(str, GlobalVar.callerNumber);
        if (shouldClearOnCallEnded(str)) {
            clearCallerInfo();
        } else {
            Log.d("BLE_NOTIFY", "onOutgoingCallEnded skipped clearCallerInfo — end event for " + str + " but current callerNumber=\"" + GlobalVar.callerNumber + "\" (state=" + GlobalVar.callState + "); likely late IDLE for a previous call");
        }
        refreshRecentCallsAfterCallEnd(context, "outgoingEnd", strFirstNonEmpty, 2);
    }

    private static String firstNonEmpty(String str, String str2) {
        if (str == null || str.trim().isEmpty()) {
            return (str2 == null || str2.trim().isEmpty()) ? "" : str2.trim();
        }
        return str.trim();
    }

    private static boolean isEndEventForCurrentCall(String str) {
        if (GlobalVar.callState == null || GlobalVar.callState == CallState.NO_CALL) {
            return true;
        }
        String strTrim = GlobalVar.callerNumber == null ? "" : GlobalVar.callerNumber.trim();
        if (strTrim.isEmpty()) {
            return true;
        }
        String strTrim2 = str != null ? str.trim() : "";
        if (strTrim2.isEmpty()) {
            return true;
        }
        return numbersLooselyMatch(strTrim, strTrim2);
    }

    private void refreshRecentCallsAfterCallEnd(Context context, final String str, String str2, final int i) {
        if (VehicleFeature.BLE_FAV_RECENT_CALLS.isEnabledFor(BleFeatures.getInstance().modelCode) && GlobalVar.isBlueToothConnected && GlobalVar.RECENT_CALLS_CHAR != null) {
            final Context applicationContext = context.getApplicationContext();
            String str3 = str2 == null ? "" : str2;
            long[] jArr = {0, 1500, 4000, 8000};
            for (int i2 = 0; i2 < 4; i2++) {
                final long j = jArr[i2];
                final String str4 = str3;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        BleService.lambda$refreshRecentCallsAfterCallEnd$11(str, j, str4, applicationContext, i);
                    }
                }, j);
            }
        }
    }

    static /* synthetic */ void lambda$refreshRecentCallsAfterCallEnd$11(String str, long j, String str2, Context context, int i) {
        String str3;
        try {
            if (GlobalVar.isBlueToothConnected && GlobalVar.RECENT_CALLS_CHAR != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" +");
                sb.append(j);
                sb.append("ms: refreshing recent calls after call end");
                if (str2.isEmpty()) {
                    str3 = "";
                } else {
                    str3 = " seed=" + str2;
                }
                sb.append(str3);
                Log.i("BLE_FAV_RC", sb.toString());
                RecentCallsFrame.sendRecentCalls(context, str2, i);
            }
        } catch (Exception e) {
            Log.e("BLE_FAV_RC", str + " +" + j + "ms: failed to refresh recent calls", e);
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.ble.BleService$3, reason: invalid class name */
    class AnonymousClass3 extends BluetoothGattCallback {
        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        }

        AnonymousClass3() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            String name;
            Log.d("BLE", "onConnectionStateChange: status=" + i + " newState=" + i2 + " isConnected=" + GlobalVar.isBlueToothConnected);
            if (i2 != 2) {
                if (i2 == 0) {
                    GlobalVar.isMTUIncreased = false;
                    BleService.alertsList.clear();
                    Controls.controlCount = 0L;
                    if (BleFeatures.getInstance().controls != null) {
                        BleFeatures.getInstance().controls.resetDialEdgeState();
                    }
                    BleService.this.releaseCpuWakeLockIfHeld("STATE_DISCONNECTED");
                    boolean z = GlobalVar.isBlueToothConnected;
                    BleService.this.autoConnectInProgress = false;
                    if (BleFeatures.getInstance().connectionCallback != null) {
                        BleFeatures.getInstance().connectionCallback.onStateChange(false);
                    }
                    BleFeatures.getInstance().resetSavedValues();
                    GlobalVar.isBlueToothConnected = false;
                    BleService.characteristicWriteQueue.clear();
                    if (!z || GlobalVar.bleDeviceAddress == null || GlobalVar.bleDeviceAddress.isEmpty()) {
                        return;
                    }
                    Log.d("BLE", "onConnectionStateChange: DISCONNECTED status=" + i + ", scheduling auto-reconnect");
                    BleService.this.scheduleAutoReconnect("gatt_drop_status_" + i);
                    return;
                }
                return;
            }
            BleService.alertsList.clear();
            Controls.controlCount = 0L;
            if (BleFeatures.getInstance().controls != null) {
                BleFeatures.getInstance().controls.resetDialEdgeState();
            }
            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                try {
                    BluetoothDevice device = bluetoothGatt.getDevice();
                    if (device != null && (name = device.getName()) != null && !name.isEmpty()) {
                        GlobalVar.vehicleType = VehicleType.fromDeviceName(name);
                        Log.d("BLE", "Vehicle type from GATT device name \"" + name + "\": " + GlobalVar.vehicleType);
                    }
                } catch (Exception unused) {
                }
                boolean z2 = GlobalVar.isBlueToothConnected;
                GlobalVar.isBlueToothConnected = true;
                BleService.this.autoConnectInProgress = false;
                BleService.this.reconnectAttempt = 0;
                BleService.this.cancelPendingReconnect();
                if (!z2 && BleFeatures.getInstance().connectionCallback != null) {
                    BleFeatures.getInstance().connectionCallback.onStateChange(true);
                }
                BleService.this.hasSentFavRecentForCurrentConnection = false;
                BleService.this.hasRePushedMediaForCurrentConnection = false;
                BleService.this.acquireCpuWakeLockIfNeeded("STATE_CONNECTED");
                if (Build.VERSION.SDK_INT >= 35) {
                    try {
                        Log.i("BLE", "onConnectionStateChange: requested CONNECTION_PRIORITY_BALANCED (Android 15+ compat) result=" + BleService.mBluetoothGatt.requestConnectionPriority(0));
                    } catch (Exception e) {
                        Log.w("BLE", "requestConnectionPriority(BALANCED) failed", e);
                    }
                    final BluetoothGatt bluetoothGatt2 = BleService.mBluetoothGatt;
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$3$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onConnectionStateChange$0(bluetoothGatt2);
                        }
                    }, 300L);
                } else {
                    BleService.mBluetoothGatt.discoverServices();
                }
                BleFeatures.getInstance().getBatteryPercentage(BleService.this.getApplicationContext());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onConnectionStateChange$1();
                    }
                }, 1200L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConnectionStateChange$0(BluetoothGatt bluetoothGatt) {
            try {
                if (GlobalVar.isBlueToothConnected && BleService.mBluetoothGatt != null && BleService.mBluetoothGatt == bluetoothGatt) {
                    if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                        Log.i("BLE", "onConnectionStateChange: starting delayed discoverServices() after BALANCED renegotiation window");
                        BleService.mBluetoothGatt.discoverServices();
                    }
                }
            } catch (Exception e) {
                Log.w("BLE", "delayed discoverServices failed", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConnectionStateChange$1() {
            if (GlobalVar.isBlueToothConnected) {
                BleService.this.resetCounter();
                BleService.characteristicWriteQueue.clear();
                BleService.characteristicReadQueue.clear();
                BleService.characteristicQueue.clear();
                BleService.this.startControlsTimer();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            Log.i("BLE", "onMtuChanged: mtu=" + i + " status=" + i2);
            if (i2 == 0) {
                GlobalVar.isMTUIncreased = true;
                GlobalVar.negotiatedMTU = i;
                BleService.this.pushGeneralStatusIfReady("onMtuChanged");
                BleService.this.scheduleFavRecentSendIfNeeded("onMtuChanged MTU=" + i);
                BleService.this.scheduleMediaRePushIfNeeded("onMtuChanged MTU=" + i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                displayGattServices(getSupportedGattServices());
                if (Build.VERSION.SDK_INT < 35) {
                    requestConnectionPriority(1);
                } else {
                    Log.i("BLE", "onServicesDiscovered: keeping CONNECTION_PRIORITY_BALANCED (API 35+ — avoid HIGH renegotiation / status=8 loop)");
                }
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    Log.i("BLE", "onServicesDiscovered: requestMtu(256) result=" + BleService.mBluetoothGatt.requestMtu(256));
                    BleService.characteristicWriteQueue.clear();
                    BleService.characteristicReadQueue.clear();
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$3$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onServicesDiscovered$2();
                        }
                    }, 2500L);
                    return;
                }
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BleService$3$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onServicesDiscovered$3();
                }
            }, BleService.MIN_OUTGOING_DISPLAY_MS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onServicesDiscovered$2() {
            if (GlobalVar.isBlueToothConnected) {
                if (!GlobalVar.isMTUIncreased) {
                    GlobalVar.isMTUIncreased = true;
                    Log.w("BLE", "onServicesDiscovered: MTU callback missing — enabling writes so cluster status can update");
                }
                BleService.this.pushGeneralStatusIfReady("onServicesDiscovered fallback");
                BleService.this.scheduleFavRecentSendIfNeeded("onServicesDiscovered fallback");
                BleService.this.scheduleMediaRePushIfNeeded("onServicesDiscovered fallback");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onServicesDiscovered$3() {
            if ((Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) && BleService.mBluetoothGatt != null) {
                BleService.mBluetoothGatt.discoverServices();
            }
        }

        public void requestConnectionPriority(int i) {
            if (BleService.mBluetoothGatt != null) {
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    BleService.mBluetoothGatt.requestConnectionPriority(i);
                }
            }
        }

        public List<BluetoothGattService> getSupportedGattServices() {
            if (BleService.mBluetoothGatt == null) {
                return null;
            }
            return BleService.mBluetoothGatt.getServices();
        }

        private void displayGattServices(List<BluetoothGattService> list) {
            Timber.d("DisplayGattServices", new Object[0]);
            if (list == null) {
                BleService.this.disconnect();
                return;
            }
            GlobalVar.mGattCharacteristics = new ArrayList<>();
            for (BluetoothGattService bluetoothGattService : list) {
                List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                Timber.d("%s", bluetoothGattService.getUuid().toString());
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    try {
                        Timber.tag("BLE_DEBUG").d("discovered characteristic: UUID=%s properties=%d", bluetoothGattCharacteristic.getUuid().toString(), Integer.valueOf(bluetoothGattCharacteristic.getProperties()));
                    } catch (Exception unused) {
                    }
                    String string = bluetoothGattCharacteristic.getUuid().toString();
                    string.hashCode();
                    switch (string) {
                        case "0210676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.GENERAL_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.GENERAL_CHAR = bluetoothGattCharacteristic;
                                BleService.this.pushGeneralStatusIfReady("GENERAL_CHAR assigned");
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "0510676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.PLAYLIST_INFO_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.PLAYLIST_INFO_CHAR = bluetoothGattCharacteristic;
                                Timber.tag("BLE_DEBUG").d("Assigned PLAYLIST_INFO_CHAR -> %s", bluetoothGattCharacteristic.getUuid().toString());
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "0b10676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.RECENT_CALLS_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.RECENT_CALLS_CHAR = bluetoothGattCharacteristic;
                                Timber.tag("BLE_DEBUG").d("Assigned RECENT_CALLS_CHAR -> %s", bluetoothGattCharacteristic.getUuid().toString());
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "0310676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.MISSED_CALL_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.MISSED_CALL_CHAR = bluetoothGattCharacteristic;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "0110676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.TBT_INFO_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.TBT_INFO_CHAR = bluetoothGattCharacteristic;
                                Timber.tag("BLE_DEBUG").d("Assigned TBT_INFO_CHAR -> %s", bluetoothGattCharacteristic.getUuid().toString());
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "0610676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.MEDIA_INFO_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.MEDIA_INFO_CHAR = bluetoothGattCharacteristic;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "0410676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.ALERTS_INFO_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.ALERTS_INFO_CHAR = bluetoothGattCharacteristic;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "0910676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.FAV_CONTACTS_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.FAV_CONTACTS_CHAR = bluetoothGattCharacteristic;
                                Timber.tag("BLE_DEBUG").d("Assigned FAV_CONTACTS_CHAR -> %s", bluetoothGattCharacteristic.getUuid().toString());
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "0a10676e-6972-6565-6e69-676e4543544f":
                            if (GlobalVar.CONTROL_CHAR != bluetoothGattCharacteristic) {
                                GlobalVar.CONTROL_CHAR = bluetoothGattCharacteristic;
                                Log.i("BLE", "Assigned CONTROL_CHAR props=" + bluetoothGattCharacteristic.getProperties());
                                break;
                            } else {
                                break;
                            }
                            break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder("GATT chars: GENERAL=");
            sb.append(GlobalVar.GENERAL_CHAR != null);
            sb.append(" MEDIA=");
            sb.append(GlobalVar.MEDIA_INFO_CHAR != null);
            sb.append(" MISSED=");
            sb.append(GlobalVar.MISSED_CALL_CHAR != null);
            sb.append(" ALERTS=");
            sb.append(GlobalVar.ALERTS_INFO_CHAR != null);
            sb.append(" PLAYLIST=");
            sb.append(GlobalVar.PLAYLIST_INFO_CHAR != null);
            sb.append(" CONTROL=");
            sb.append(GlobalVar.CONTROL_CHAR != null);
            sb.append(" TBT=");
            sb.append(GlobalVar.TBT_INFO_CHAR != null);
            Log.i("BLE", sb.toString());
            if (GlobalVar.CONTROL_CHAR != null) {
                BleService.this.enableControlNotifications(GlobalVar.CONTROL_CHAR);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                Log.i("BLE", "onDescriptorWrite: success");
            } else {
                Log.w("BLE", "onDescriptorWrite: error status=" + i);
            }
            BleService.characteristicQueue.remove();
            if (!BleService.characteristicWriteQueue.isEmpty()) {
                if (BleService.characteristicWriteQueue.element() != null) {
                    if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                        try {
                            PendingWrite pendingWrite = (PendingWrite) BleService.characteristicWriteQueue.element();
                            if (pendingWrite == null || pendingWrite.characteristic == null) {
                                return;
                            }
                            BleService.refreshGeneralPayloadIfNeeded(pendingWrite);
                            pendingWrite.characteristic.setValue(pendingWrite.payload);
                            BleService.mBluetoothGatt.writeCharacteristic(pendingWrite.characteristic);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (!BleService.characteristicReadQueue.isEmpty()) {
                if (BleService.characteristicReadQueue.element() != null) {
                    if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                        BleService.mBluetoothGatt.readCharacteristic((BluetoothGattCharacteristic) BleService.characteristicReadQueue.element());
                        return;
                    }
                    return;
                }
                return;
            }
            if (BleService.characteristicQueue.isEmpty()) {
                return;
            }
            BleRequest bleRequest = (BleRequest) BleService.characteristicQueue.element();
            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                int i2 = AnonymousClass6.$SwitchMap$com$bajajconnect$ble$BleService$BleRequestOperation[bleRequest.operation.ordinal()];
                if (i2 == 1) {
                    BleService.mBluetoothGatt.writeCharacteristic(bleRequest.characteristic);
                } else if (i2 == 2) {
                    BleService.mBluetoothGatt.readCharacteristic(bleRequest.characteristic);
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    BleService.mBluetoothGatt.writeDescriptor(bleRequest.descriptor);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            byte[] value;
            PendingWrite pendingWrite;
            String string;
            String string2 = BuildConfig.TRAVIS;
            if (bluetoothGattCharacteristic != null) {
                try {
                    value = bluetoothGattCharacteristic.getValue();
                } catch (Exception unused) {
                    Timber.Tree treeTag = Timber.tag("BLE_DEBUG");
                    Integer numValueOf = Integer.valueOf(i);
                    if (bluetoothGattCharacteristic != null) {
                        string2 = bluetoothGattCharacteristic.getUuid().toString();
                    }
                    treeTag.d("onCharacteristicWrite: status=%d UUID=%s (error formatting payload)", numValueOf, string2);
                }
            } else {
                value = null;
            }
            int length = value != null ? value.length : 0;
            if (bluetoothGattCharacteristic == null) {
                string = BuildConfig.TRAVIS;
            } else {
                string = bluetoothGattCharacteristic.getUuid().toString();
            }
            String string3 = Arrays.toString(value);
            Log.i("BLE_PACKET", "onCharacteristicWrite: status=" + i + " UUID=" + string + " len=" + length);
            Timber.tag("BLE_DEBUG").d("onCharacteristicWrite: status=%d UUID=%s len=%d data=%s", Integer.valueOf(i), string, Integer.valueOf(length), string3);
            BleService.this.writeCounter++;
            if (!BleService.characteristicWriteQueue.isEmpty()) {
                try {
                    BleService.characteristicWriteQueue.remove();
                    if (BleService.characteristicWriteQueue.isEmpty() || BleService.characteristicWriteQueue.element() == null) {
                        return;
                    }
                    if ((Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") != 0) || (pendingWrite = (PendingWrite) BleService.characteristicWriteQueue.element()) == null || pendingWrite.characteristic == null) {
                        return;
                    }
                    BleService.refreshGeneralPayloadIfNeeded(pendingWrite);
                    pendingWrite.characteristic.setValue(pendingWrite.payload);
                    BleService.mBluetoothGatt.writeCharacteristic(pendingWrite.characteristic);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (!BleService.descriptorWriteQueueS.isEmpty()) {
                if (BleService.descriptorWriteQueueS.element() != null) {
                    BleService.this.setCharacteristicNotificationNQ((String) BleService.descriptorWriteQueueS.element(), true);
                }
            } else {
                if (BleService.characteristicReadQueue.isEmpty() || BleService.characteristicReadQueue.element() == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    BleService.mBluetoothGatt.readCharacteristic((BluetoothGattCharacteristic) BleService.characteristicReadQueue.element());
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (!BleService.characteristicReadQueue.isEmpty()) {
                try {
                    BleService.characteristicReadQueue.remove();
                } catch (Exception unused) {
                }
            }
            if (i == 0) {
                if (bluetoothGattCharacteristic == GlobalVar.CONTROL_CHAR) {
                    BleService.this.readFlag = true;
                    BleService.this.resetQueueTimer = 2;
                    BleFeatures.getInstance().controls.processData(bluetoothGattCharacteristic.getValue());
                } else if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(GlobalVar.CONTROL)) {
                    GlobalVar.CONTROL_CHAR = bluetoothGattCharacteristic;
                    BleService.this.readFlag = true;
                    BleService.this.resetQueueTimer = 2;
                    BleFeatures.getInstance().controls.processData(bluetoothGattCharacteristic.getValue());
                }
            } else {
                Log.e("processData", "onCharactersticRead error: " + i);
            }
            if (!BleService.characteristicWriteQueue.isEmpty()) {
                if (BleService.characteristicWriteQueue.element() != null) {
                    if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                        try {
                            PendingWrite pendingWrite = (PendingWrite) BleService.characteristicWriteQueue.element();
                            if (pendingWrite == null || pendingWrite.characteristic == null) {
                                return;
                            }
                            BleService.refreshGeneralPayloadIfNeeded(pendingWrite);
                            pendingWrite.characteristic.setValue(pendingWrite.payload);
                            BleService.mBluetoothGatt.writeCharacteristic(pendingWrite.characteristic);
                            return;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (!BleService.descriptorWriteQueueS.isEmpty()) {
                if (BleService.descriptorWriteQueueS.element() != null) {
                    BleService.this.setCharacteristicNotificationNQ((String) BleService.descriptorWriteQueueS.element(), true);
                }
            } else {
                if (BleService.characteristicReadQueue.isEmpty() || BleService.characteristicReadQueue.element() == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    BleService.mBluetoothGatt.readCharacteristic((BluetoothGattCharacteristic) BleService.characteristicReadQueue.element());
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            byte[] value;
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            if (bluetoothGattCharacteristic == null) {
                return;
            }
            if ((GlobalVar.CONTROL.equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString()) || (GlobalVar.CONTROL_CHAR != null && bluetoothGattCharacteristic.getUuid().equals(GlobalVar.CONTROL_CHAR.getUuid()))) && (value = bluetoothGattCharacteristic.getValue()) != null && value.length > 0) {
                BleService.this.readFlag = true;
                BleService.this.resetQueueTimer = 2;
                BleFeatures.getInstance().controls.processData(value);
            }
        }
    }

    private void refreshRecentCallsAfterCallEnd(Context context, String str) {
        refreshRecentCallsAfterCallEnd(context, str, "", 0);
    }

    /* JADX INFO: renamed from: com.bajajconnect.ble.BleService$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$bajajconnect$ble$BleService$BleRequestOperation;

        static {
            int[] iArr = new int[BleRequestOperation.values().length];
            $SwitchMap$com$bajajconnect$ble$BleService$BleRequestOperation = iArr;
            try {
                iArr[BleRequestOperation.write.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bajajconnect$ble$BleService$BleRequestOperation[BleRequestOperation.read.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bajajconnect$ble$BleService$BleRequestOperation[BleRequestOperation.enableNotification.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onMissedCall(Context context, final String str, Date date) {
        Log.d("BLE_NOTIFY", "onMissedCall: number=" + str + " btConnected=" + GlobalVar.isBlueToothConnected);
        endCallAndClear("missedCall");
        if (GlobalVar.isBlueToothConnected) {
            GlobalVar.missedCallCount++;
            Log.d("BLE_NOTIFY", "missedCallCount incremented to " + GlobalVar.missedCallCount);
            ContactsUtil.getContactName(context, str, new ContactCallback() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda5
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BleService.lambda$onMissedCall$12(str, str2);
                }
            });
        }
        refreshRecentCallsAfterCallEnd(context, "missedCall", str, 3);
    }

    static /* synthetic */ void lambda$onMissedCall$12(String str, String str2) {
        if (Objects.equals(str2, "") || Objects.equals(str2, StringUtils.SPACE)) {
            GlobalVar.missedCallName = str;
        } else {
            GlobalVar.missedCallName = str2;
        }
        StringBuilder sb = new StringBuilder("Writing missed call to MISSED_CALL_CHAR: name=");
        sb.append(GlobalVar.missedCallName);
        sb.append(" number=");
        sb.append(str);
        sb.append(" charReady=");
        sb.append(GlobalVar.MISSED_CALL_CHAR != null);
        sb.append(" mtuReady=");
        sb.append(GlobalVar.isMTUIncreased);
        sb.append(" newProtocol=");
        sb.append(NewBtProtocolSelector.useNewMissedCallProtocol());
        sb.append(" sku=");
        sb.append(BleFeatures.getInstance().modelCode);
        Log.d("BLE_NOTIFY", sb.toString());
        missedCallList.add(new MissedCallModel(GlobalVar.missedCallCount, GlobalVar.missedCallName, str, Util.getTimeStamp()));
        prepareCharAndWrite(GlobalVar.MISSED_CALL_CHAR, CallFrame.missedCallForVehicle(GlobalVar.missedCallName, str, Util.getTimeStamp()));
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onBluetoothDisconnected() {
        GlobalVar.isBlueToothConnected = false;
        disconnect();
        characteristicWriteQueue.clear();
        characteristicReadQueue.clear();
        characteristicQueue.clear();
        BleFeatures.getInstance().resetSavedValues();
    }

    public void disconnect() {
        try {
            cancelPendingReconnect();
            if (mBluetoothGatt != null && this.mBluetoothAdapter != null) {
                if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
                    clearConnectedStateForJs();
                    return;
                } else {
                    try {
                        mBluetoothGatt.disconnect();
                    } catch (Exception unused) {
                    }
                    close();
                }
            }
            clearConnectedStateForJs();
        } catch (Exception e) {
            e.printStackTrace();
            clearConnectedStateForJs();
        }
    }

    private void clearConnectedStateForJs() {
        GlobalVar.isBlueToothConnected = false;
        GlobalVar.isMTUIncreased = false;
        if (BleFeatures.getInstance().connectionCallback != null) {
            BleFeatures.getInstance().connectionCallback.onStateChange(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelPendingReconnect() {
        Runnable runnable;
        Handler handler = this.mHandler;
        if (handler == null || (runnable = this.pendingReconnectRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.pendingReconnectRunnable = null;
    }

    private void closeGattQuietly() {
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        mBluetoothGatt = null;
        if (bluetoothGatt == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                try {
                    bluetoothGatt.disconnect();
                } catch (Exception unused) {
                }
                try {
                    bluetoothGatt.close();
                } catch (Exception unused2) {
                }
            }
        } catch (Exception e) {
            Log.w("BLE", "closeGattQuietly failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAutoReconnect(String str) {
        if (!this.shouldConnect) {
            Log.d("BLE", "scheduleAutoReconnect skipped (shouldConnect=false) reason=" + str);
            return;
        }
        final String str2 = GlobalVar.bleDeviceAddress;
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        cancelPendingReconnect();
        closeGattQuietly();
        int i = this.reconnectAttempt;
        long[] jArr = RECONNECT_BACKOFF_MS;
        long j = jArr[Math.min(i, jArr.length - 1)];
        this.reconnectAttempt = i + 1;
        Log.i("BLE", "scheduleAutoReconnect reason=" + str + " attempt=" + this.reconnectAttempt + " delayMs=" + j + " address=" + str2);
        Runnable runnable = new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleAutoReconnect$13(str2);
            }
        };
        this.pendingReconnectRunnable = runnable;
        this.mHandler.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleAutoReconnect$13(String str) {
        this.pendingReconnectRunnable = null;
        if (this.shouldConnect && !GlobalVar.isBlueToothConnected) {
            startAutoConnect(str);
        }
    }

    private void refreshGattCache(BluetoothGatt bluetoothGatt) {
        try {
            Timber.d("refreshGattCache: result=%s", (Boolean) bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null));
        } catch (Exception e) {
            Timber.d("refreshGattCache: failed - %s", e.getMessage());
        }
    }

    public void close() {
        if (mBluetoothGatt == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
            mBluetoothGatt.close();
            mBluetoothGatt = null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.mHandler = new Handler(Looper.getMainLooper());
        if (Objects.equals(intent.getAction(), "com.bajajconnect.ble.ACTION_BLE_DISCONNECT")) {
            this.shouldConnect = false;
            cancelPendingReconnect();
            disconnect();
        }
        if (Objects.equals(intent.getAction(), "com.bajajconnect.ble.ACTION_BLE_CONNECT")) {
            this.shouldConnect = true;
            this.reconnectAttempt = 0;
            initialize();
        } else if (Objects.equals(intent.getAction(), "com.bajajconnect.ACTION_FOREGROUND_STOP")) {
            this.shouldConnect = false;
            cancelPendingReconnect();
            if (mBluetoothGatt != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 31) {
                        if (ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                            if (GlobalVar.isBlueToothConnected) {
                                mBluetoothGatt.disconnect();
                            }
                            mBluetoothGatt.close();
                        }
                    } else {
                        if (GlobalVar.isBlueToothConnected) {
                            mBluetoothGatt.disconnect();
                        }
                        mBluetoothGatt.close();
                    }
                } catch (Exception unused) {
                }
                mBluetoothGatt = null;
                this.mBluetoothDeviceAddress = null;
                if (GlobalVar.isBlueToothConnected) {
                    BleFeatures.getInstance().connectionCallback.onStateChange(false);
                    GlobalVar.isBlueToothConnected = false;
                }
            }
            try {
                scanLeDevice(false);
            } catch (Exception unused2) {
            }
            if (GlobalVar.isBlueToothConnected) {
                clearConnectedStateForJs();
            }
        }
        if (Objects.equals(intent.getAction(), "com.bajajconnect.ble.ACTION_BLE_START")) {
            this.shouldConnect = true;
            initialize();
        }
        if (!Objects.equals(intent.getAction(), ACTION_START_FOREGROUND)) {
            return 2;
        }
        createNotificationChannel();
        startForeground(8909, new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Bluetooth Service Running").setContentText("Bajaj ride app uses bluetooth in background").build());
        BleFeatures.getInstance().registerIphoneListener(this);
        BleFeatures.getInstance().registerNavigationCallback(this);
        BleFeatures.getInstance().registerTakeMeHomeCallback(this);
        BleFeatures.getInstance().listenPhone(this, true);
        return 2;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(Peripheral$$ExternalSyntheticApiModelOutline0.m(CHANNEL_ID, "Foreground Service Channel", 3));
        }
    }

    public boolean initialize() {
        if (this.mBluetoothManager == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.mBluetoothManager = bluetoothManager;
            if (bluetoothManager == null) {
                return false;
            }
        }
        BluetoothAdapter adapter = this.mBluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter == null) {
            return false;
        }
        scanLeDevice(true);
        return true;
    }

    public void scanLeDevice(boolean z) {
        try {
            if (this.mBluetoothAdapter.isEnabled()) {
                if (this.bluetoothLeScanner == null) {
                    this.bluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
                }
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") == 0) {
                    if (z) {
                        this.scanNameCache.clear();
                        Runnable runnable = this.scanTimeoutRunnable;
                        if (runnable != null) {
                            this.mHandler.removeCallbacks(runnable);
                        }
                        Runnable runnable2 = new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda15
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$scanLeDevice$14();
                            }
                        };
                        this.scanTimeoutRunnable = runnable2;
                        this.mHandler.postDelayed(runnable2, 10000L);
                        BleFeatures.getInstance().connectionCallback.onScanning(true);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.scanFilter);
                        this.bluetoothLeScanner.startScan(arrayList, getScanSettings(), this.mLeScanCallback);
                        return;
                    }
                    Runnable runnable3 = this.scanTimeoutRunnable;
                    if (runnable3 != null) {
                        this.mHandler.removeCallbacks(runnable3);
                        this.scanTimeoutRunnable = null;
                    }
                    this.bluetoothLeScanner.stopScan(this.mLeScanCallback);
                }
            }
        } catch (Exception e) {
            Log.d("BLE", "scanLeDevice: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scanLeDevice$14() {
        String str;
        this.scanTimeoutRunnable = null;
        try {
            this.bluetoothLeScanner.stopScan(this.mLeScanCallback);
        } catch (Exception unused) {
        }
        BleFeatures.getInstance().connectionCallback.onScanning(false);
        if (GlobalVar.isBlueToothConnected || mBluetoothGatt != null || (str = GlobalVar.bleDeviceAddress) == null || str.isEmpty()) {
            return;
        }
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice != null && remoteDevice.getBondState() == 12) {
            startAutoConnect(str);
        } else {
            Log.d("BLE", "scan timeout: stale address, clearing auto-connect target");
            GlobalVar.bleDeviceAddress = "";
        }
    }

    public boolean startAutoConnect(String str) {
        if (this.autoConnectInProgress) {
            Log.d("BLE", "startAutoConnect: already in progress, skipping");
            return false;
        }
        this.autoConnectInProgress = true;
        GlobalVar.bleDeviceAddress = str;
        if (this.mBluetoothAdapter == null || str == null) {
            this.autoConnectInProgress = false;
            return false;
        }
        cancelPendingReconnect();
        closeGattQuietly();
        boolean zStartAutoConnectInternal = startAutoConnectInternal(str, true);
        if (!zStartAutoConnectInternal) {
            this.autoConnectInProgress = false;
        }
        return zStartAutoConnectInternal;
    }

    private boolean startAutoConnectInternal(String str, boolean z) {
        BluetoothDevice remoteDevice;
        if (this.mBluetoothAdapter == null || str == null) {
            return false;
        }
        if ((Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) || (remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str)) == null) {
            return false;
        }
        if (mBluetoothGatt != null) {
            closeGattQuietly();
        }
        Log.i("BLE", "startAutoConnectInternal: connectGatt(autoConnect=" + z + ") address=" + str);
        BluetoothGatt bluetoothGattConnectGatt = remoteDevice.connectGatt(this, z, this.mGattCallback);
        mBluetoothGatt = bluetoothGattConnectGatt;
        this.mBluetoothDeviceAddress = str;
        return bluetoothGattConnectGatt != null;
    }

    public boolean connect(String str) {
        StringBuilder sb = new StringBuilder("connect() called, address=");
        sb.append(str);
        sb.append(" existingGatt=");
        sb.append(mBluetoothGatt != null);
        Log.d("BLE", sb.toString());
        GlobalVar.bleDeviceAddress = str;
        if (this.mBluetoothAdapter == null || str == null) {
            return false;
        }
        cancelPendingReconnect();
        this.reconnectAttempt = 0;
        if (str.equals(this.mBluetoothDeviceAddress) && mBluetoothGatt != null) {
            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                return mBluetoothGatt.connect();
            }
            return false;
        }
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            return false;
        }
        closeGattQuietly();
        Log.i("BLE", "connect: connectGatt(autoConnect=false) address=" + str);
        BluetoothGatt bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        mBluetoothGatt = bluetoothGattConnectGatt;
        this.mBluetoothDeviceAddress = str;
        return bluetoothGattConnectGatt != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCounter() {
        this.writeCounterCheck = 1L;
        this.writeCounter = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startControlsTimer() {
        ScheduledExecutorService scheduledExecutorService = this.readScheduler;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.readScheduler = null;
        }
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.readScheduler = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startControlsTimer$15();
            }
        }, 0L, 700L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startControlsTimer$15() {
        if (GlobalVar.isBlueToothConnected && GlobalVar.CONTROL_CHAR != null && GlobalVar.isMTUIncreased) {
            int i = this.resetQueueTimer - 1;
            this.resetQueueTimer = i;
            if (!this.readFlag && i <= 0) {
                characteristicReadQueue.clear();
            }
            this.readFlag = false;
            readCharacteristic(GlobalVar.CONTROL_CHAR);
            if (System.currentTimeMillis() - this.millisec >= 3000) {
                this.millisec = System.currentTimeMillis();
                long j = this.writeCounter;
                if (j != this.writeCounterCheck) {
                    this.writeCounterCheck = j;
                    return;
                }
                try {
                    Queue<PendingWrite> queue = characteristicWriteQueue;
                    if (queue.isEmpty()) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                        try {
                            PendingWrite pendingWriteElement = queue.element();
                            if (pendingWriteElement == null || pendingWriteElement.characteristic == null) {
                                return;
                            }
                            refreshGeneralPayloadIfNeeded(pendingWriteElement);
                            pendingWriteElement.characteristic.setValue(pendingWriteElement.payload);
                            mBluetoothGatt.writeCharacteristic(pendingWriteElement.characteristic);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    Log.e("BluettohService", "Read: " + e);
                }
            }
        }
    }

    public void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothAdapter == null || mBluetoothGatt == null) {
            Timber.d("BluetoothAdapter not initialized", new Object[0]);
            return;
        }
        Timber.d("readCharacteristic", new Object[0]);
        Queue<BluetoothGattCharacteristic> queue = characteristicReadQueue;
        queue.add(bluetoothGattCharacteristic);
        if (queue.size() == 1 && descriptorWriteQueueS.size() == 0 && characteristicWriteQueue.size() == 0) {
            try {
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    mBluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCharacteristicNotificationNQ(String str, boolean z) {
        if (GlobalVar.CONTROL_CHAR != null) {
            enableControlNotifications(GlobalVar.CONTROL_CHAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableControlNotifications(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (mBluetoothGatt == null || bluetoothGattCharacteristic == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
            try {
                Log.i("BLE", "CONTROL setCharacteristicNotification=" + mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true));
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CCCD_UUID);
                if (descriptor == null) {
                    Log.w("BLE", "CONTROL CCCD descriptor missing");
                    return;
                }
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                if (characteristicWriteQueue.isEmpty() && characteristicReadQueue.isEmpty() && characteristicQueue.isEmpty()) {
                    Log.i("BLE", "CONTROL CCCD writeDescriptor=" + mBluetoothGatt.writeDescriptor(descriptor));
                    return;
                }
                BleRequest bleRequest = new BleRequest();
                bleRequest.operation = BleRequestOperation.enableNotification;
                bleRequest.descriptor = descriptor;
                bleRequest.characteristic = bluetoothGattCharacteristic;
                characteristicQueue.add(bleRequest);
                Log.i("BLE", "CONTROL CCCD write queued");
            } catch (Exception e) {
                Log.e("BLE", "enableControlNotifications failed", e);
            }
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        terminateAll();
    }

    private void terminateAll() {
        GlobalVar.bleDeviceName = "";
        GlobalVar.bleDeviceAddress = "";
        try {
            BleFeatures.getInstance().unRegisterReceivers(this);
            BleFeatures.getInstance().unregisterCallReceivers(this);
        } catch (Exception unused) {
        }
        releaseCpuWakeLockIfHeld("terminateAll");
        try {
            Log.e("Ble service", "kill the app");
            BleFeatures.getInstance().resetSavedValuesOnKill();
            disconnect();
            GlobalVar.isBlueToothConnected = false;
            stopForeground(true);
            stopSelf();
            stopService(new Intent(this, (Class<?>) BleService.class));
            System.exit(0);
        } catch (Exception e) {
            Log.e("Ble service", "kill the app error");
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acquireCpuWakeLockIfNeeded(String str) {
        try {
            PowerManager.WakeLock wakeLock = this.cpuWakeLock;
            if (wakeLock == null || !wakeLock.isHeld()) {
                PowerManager powerManager = (PowerManager) getSystemService("power");
                if (powerManager == null) {
                    Log.w("BLE_WAKELOCK", "PowerManager unavailable — cannot acquire wake lock");
                    return;
                }
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, CPU_WAKE_LOCK_TAG);
                this.cpuWakeLock = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
                this.cpuWakeLock.acquire();
                Log.i("BLE_WAKELOCK", "acquired PARTIAL_WAKE_LOCK (" + str + ") — keeps Timer + BLE writes alive during Doze");
            }
        } catch (Exception e) {
            Log.w("BLE_WAKELOCK", "acquireCpuWakeLockIfNeeded failed: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCpuWakeLockIfHeld(String str) {
        try {
            try {
                PowerManager.WakeLock wakeLock = this.cpuWakeLock;
                if (wakeLock != null && wakeLock.isHeld()) {
                    this.cpuWakeLock.release();
                    Log.i("BLE_WAKELOCK", "released PARTIAL_WAKE_LOCK (" + str + ")");
                }
            } catch (Exception e) {
                Log.w("BLE_WAKELOCK", "releaseCpuWakeLockIfHeld failed: " + e.getMessage());
            }
        } finally {
            this.cpuWakeLock = null;
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onNavigationStart() {
        if (isBleTbtEnabled()) {
            if (GlobalVar.gpsStatus != GpsStatus.ACTIVE) {
                GlobalVar.gpsStatus = GpsStatus.ACTIVE;
            }
            GlobalVar.isNavigationActive = true;
            this.googleDestinationReachedAnnounced = false;
            if (!GlobalVar.isBlueToothConnected || GlobalVar.TBT_INFO_CHAR == null) {
                return;
            }
            prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, buildNavHelperFrame(1, PrimaryTurns.STRAIGHT.getValue(), true, 0, 0, 0, 0, 0, ""));
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onNavigationStop() {
        if (!isBleTbtEnabled()) {
            stopGoogleTbtScheduler();
            return;
        }
        GlobalVar.isNavigationActive = false;
        this.googleDestinationReachedAnnounced = false;
        stopGoogleTbtScheduler();
        if (!GlobalVar.isBlueToothConnected || GlobalVar.TBT_INFO_CHAR == null) {
            return;
        }
        prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, buildNavHelperFrame(0, 0, true, 0, 0, 0, 0, 0, ""));
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onDestinationReached() {
        if (isBleTbtEnabled()) {
            int iRemainingMetersToGoogleDestination = remainingMetersToGoogleDestination();
            if (iRemainingMetersToGoogleDestination > 80) {
                Log.i("BLE_TBT", "ignore early onArrival — remaining=" + iRemainingMetersToGoogleDestination + "m (threshold=80m)");
                return;
            }
            if (this.googleDestinationReachedAnnounced) {
                return;
            }
            this.googleDestinationReachedAnnounced = true;
            prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, buildNavHelperFrame(1, PrimaryTurns.DESTINATION_REACHED.getValue(), true, 0, 0, 0, 0, 0, "Destination reached"));
            Log.i("BLE_TBT", "destination reached announced remaining=" + iRemainingMetersToGoogleDestination + "m");
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onRerouting() {
        if (isBleTbtEnabled()) {
            this.googleDestinationReachedAnnounced = false;
            this.latestGoogleNavInfo = null;
            this.tbtRerouteHoldUntilMs = System.currentTimeMillis() + TBT_REROUTE_HOLD_MS;
            Log.i("BLE_TBT", "onRerouting — holding stale TBT, sending Rerouting...");
            pushReroutingTbtFrame();
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onRouteReady() {
        onNavigationRouteReady();
    }

    public void onNavigationRouteReady() {
        if (this.tbtRerouteHoldUntilMs != 0) {
            Log.i("BLE_TBT", "route ready — releasing reroute TBT hold");
        }
        this.tbtRerouteHoldUntilMs = 0L;
    }

    private void pushReroutingTbtFrame() {
        try {
            if (GlobalVar.isBlueToothConnected && GlobalVar.TBT_INFO_CHAR != null) {
                prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, buildNavHelperFrame(1, PrimaryTurns.STRAIGHT.getValue(), this.lastTbtEtaAm, Math.max(0, this.lastTbtStepMeters), Math.max(0, this.lastTbtTotalMeters), this.lastTbtEtaHour, this.lastTbtEtaMinute, 0, "Rerouting..."));
                this.lastTbtMillis = System.currentTimeMillis();
            }
        } catch (Exception e) {
            Log.w("BLE_TBT", "pushReroutingTbtFrame failed: " + e.getMessage());
        }
    }

    private boolean isTbtRerouteHoldActive() {
        long j = this.tbtRerouteHoldUntilMs;
        if (j == 0) {
            return false;
        }
        if (System.currentTimeMillis() < j) {
            return true;
        }
        this.tbtRerouteHoldUntilMs = 0L;
        return false;
    }

    @Override // com.bajajconnect.interfaces.TakeMeHome
    public void onTakeMeHome(Double d, Double d2, String str) {
        if (!isAppNavigationEnabled()) {
            Log.i("BLE_TBT", "Take Me Home skipped — SKU has no navigation capability");
            return;
        }
        if (GlobalVar.isGoogleNavigation) {
            GlobalVar.lat = d;
            GlobalVar.lng = d2;
            ELocation eLocation = new ELocation();
            eLocation.placeName = str;
            NavApplication.eLocation = eLocation;
            ClusterNavigationLauncher.launchFromCluster(getApplicationContext(), GlobalVar.takeMeHomeActionStart);
            return;
        }
        if (GlobalVar.isIsTakeMeHomeNavStarting || GlobalVar.isNavigationActive) {
            return;
        }
        try {
            ELocation eLocation2 = new ELocation();
            eLocation2.latitude = d;
            eLocation2.longitude = d2;
            eLocation2.placeName = str;
            NavApplication.eLocation = eLocation2;
            if (GlobalVar.waypoints != null) {
                GlobalVar.waypoints.clear();
            }
            GlobalVar.waypoints = new ArrayList();
            ClusterNavigationLauncher.launchFromCluster(getApplicationContext(), GlobalVar.takeMeHomeActionStart);
        } catch (Exception unused) {
            Toast.makeText(getApplicationContext(), "Something went wrong", 0).show();
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onNavigationProgress(AdviseInfo adviseInfo) {
        if (isBleTbtEnabled() && GlobalVar.isNavigationActive) {
            if (isTbtRerouteHoldActive()) {
                if (System.currentTimeMillis() - this.lastTbtMillis >= 800) {
                    pushReroutingTbtFrame();
                }
            } else if (System.currentTimeMillis() - this.lastTbtMillis >= 1000) {
                processAdviseInfo(adviseInfo);
            }
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onNavigationProgress(AdviseInfo adviseInfo, NavInfo navInfo) {
        if (isBleTbtEnabled() && GlobalVar.isNavigationActive && GlobalVar.isBlueToothConnected && GlobalVar.TBT_INFO_CHAR != null) {
            if (navInfo != null && GlobalVar.isGoogleNavigation) {
                if (!isTbtRerouteHoldActive()) {
                    this.latestGoogleNavInfo = navInfo;
                    startGoogleTbtScheduler();
                    return;
                } else {
                    if (System.currentTimeMillis() - this.lastTbtMillis >= 800) {
                        pushReroutingTbtFrame();
                        return;
                    }
                    return;
                }
            }
            if (adviseInfo != null) {
                if (isTbtRerouteHoldActive()) {
                    if (System.currentTimeMillis() - this.lastTbtMillis >= 800) {
                        pushReroutingTbtFrame();
                    }
                } else if (System.currentTimeMillis() - this.lastTbtMillis >= 800) {
                    processAdviseInfo(adviseInfo);
                }
            }
        }
    }

    private void startGoogleTbtScheduler() {
        ScheduledExecutorService scheduledExecutorService = this.googleTbtScheduler;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.googleTbtScheduler = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.bajajconnect.ble.BleService$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startGoogleTbtScheduler$16();
                }
            }, 0L, 800L, TimeUnit.MILLISECONDS);
            Log.d("BleService", "Google TBT scheduler started (800ms interval)");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGoogleTbtScheduler$16() {
        try {
            if (GlobalVar.isNavigationActive) {
                if (isTbtRerouteHoldActive()) {
                    if (this.latestGoogleNavInfo == null) {
                        pushReroutingTbtFrame();
                    }
                } else {
                    NavInfo navInfo = this.latestGoogleNavInfo;
                    if (navInfo == null || !GlobalVar.isBlueToothConnected || GlobalVar.TBT_INFO_CHAR == null) {
                        return;
                    }
                    processAdviseInfoGoogle(navInfo);
                }
            }
        } catch (Exception e) {
            Log.e("BleService", "googleTbtScheduler error: " + e.getMessage());
        }
    }

    public void stopGoogleTbtScheduler() {
        this.latestGoogleNavInfo = null;
        this.tbtRerouteHoldUntilMs = 0L;
        ScheduledExecutorService scheduledExecutorService = this.googleTbtScheduler;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.googleTbtScheduler = null;
            Log.d("BleService", "Google TBT scheduler stopped");
        }
    }

    private void processAdviseInfo(AdviseInfo adviseInfo) {
        if (adviseInfo == null) {
            return;
        }
        try {
            if (adviseInfo.isRouteBeingRecalculated()) {
                Log.d("BLE_TBT", "skip AdviseInfo — routeBeingRecalculated");
                if (!isTbtRerouteHoldActive() || System.currentTimeMillis() - this.lastTbtMillis < 800) {
                    return;
                }
                pushReroutingTbtFrame();
                return;
            }
            int distanceToNextAdvise = adviseInfo.getDistanceToNextAdvise();
            int leftDistance = adviseInfo.getLeftDistance();
            if (!adviseInfo.isOnRoute() && distanceToNextAdvise <= 0 && leftDistance <= 0) {
                Log.d("BLE_TBT", "skip AdviseInfo — off-route with zero distances");
                return;
            }
            byte[] bArrSendNavigationData = new NavigationHelper(adviseInfo).sendNavigationData();
            StringBuilder sb = new StringBuilder("processAdviseInfo symbol=");
            boolean z = true;
            sb.append(bArrSendNavigationData[1] & 255);
            sb.append(" turnDist=");
            sb.append(distanceToNextAdvise);
            sb.append(" streetLen=");
            sb.append(bArrSendNavigationData[14] & 255);
            Log.d("BLE_TBT", sb.toString());
            prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, bArrSendNavigationData);
            this.lastTbtMillis = System.currentTimeMillis();
            if (distanceToNextAdvise > 0) {
                this.lastTbtStepMeters = distanceToNextAdvise;
            }
            if (leftDistance > 0) {
                this.lastTbtTotalMeters = leftDistance;
            }
            try {
                int leftTime = adviseInfo.getLeftTime();
                if (leftTime > 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(13, leftTime);
                    if (calendar.get(9) != 0) {
                        z = false;
                    }
                    this.lastTbtEtaAm = z;
                    int i = calendar.get(10);
                    if (i == 0) {
                        i = 12;
                    }
                    this.lastTbtEtaHour = i;
                    this.lastTbtEtaMinute = calendar.get(12);
                }
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processAdviseInfoGoogle(NavInfo navInfo) {
        if (navInfo == null) {
            return;
        }
        try {
            int iMax = Math.max(0, navInfo.getDistanceToFinalDestinationMeters().intValue());
            if (this.googleDestinationReachedAnnounced) {
                if (iMax <= 80) {
                    return;
                }
                Log.i("BLE_TBT", "post-arrival resume — remaining grew to " + iMax + "m");
                this.googleDestinationReachedAnnounced = false;
            }
            if (iMax <= 80) {
                onDestinationReached();
                return;
            }
            byte[] bArrFromGoogleNavInfo = TbtNavFrame.fromGoogleNavInfo(navInfo);
            if (bArrFromGoogleNavInfo != null) {
                Log.d("BLE_TBT", "processAdviseInfoGoogle symbol=" + (bArrFromGoogleNavInfo[1] & 255) + " stepDist=" + navInfo.getDistanceToCurrentStepMeters() + " streetLen=" + (bArrFromGoogleNavInfo[14] & 255));
                prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, bArrFromGoogleNavInfo);
                this.lastTbtMillis = System.currentTimeMillis();
                try {
                    int iMax2 = Math.max(0, navInfo.getDistanceToCurrentStepMeters().intValue());
                    int iMax3 = Math.max(0, navInfo.getDistanceToFinalDestinationMeters().intValue());
                    if (iMax2 > 0) {
                        this.lastTbtStepMeters = iMax2;
                    }
                    if (iMax3 > 0) {
                        this.lastTbtTotalMeters = iMax3;
                    }
                    int iMax4 = Math.max(0, navInfo.getTimeToFinalDestinationSeconds().intValue());
                    if (iMax4 > 0) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(13, iMax4);
                        this.lastTbtEtaAm = calendar.get(9) == 0;
                        int i = calendar.get(10);
                        if (i == 0) {
                            i = 12;
                        }
                        this.lastTbtEtaHour = i;
                        this.lastTbtEtaMinute = calendar.get(12);
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            Log.e("BleService", "processAdviseInfoGoogle error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int remainingMetersToGoogleDestination() {
        NavInfo navInfo = this.latestGoogleNavInfo;
        if (navInfo != null) {
            try {
                return Math.max(0, navInfo.getDistanceToFinalDestinationMeters().intValue());
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private byte[] buildNavHelperFrame(int i, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, String str) {
        return TbtNavFrame.buildNavHelperFrame(i, i2, z, i3, i4, i5, i6, i7, str);
    }

    private boolean isBleTbtEnabled() {
        String str = BleFeatures.getInstance().modelCode;
        return !VehicleFeature.BLE_GENERAL_PACKET_V2.isEnabledFor(str) || VehicleFeature.BLE_TBT.isEnabledFor(str);
    }

    private boolean isAppNavigationEnabled() {
        String str = BleFeatures.getInstance().modelCode;
        return !VehicleFeature.BLE_GENERAL_PACKET_V2.isEnabledFor(str) || VehicleFeature.APP_NAVIGATION.isEnabledFor(str);
    }

    private String getETAFromSeconds(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateTimeFormatter.ofPattern("hh:mm a").format(ZonedDateTime.now().plusSeconds(i));
        }
        return "12:00 AM";
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:23:0x003f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0042  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Switch 'out' block B:20:0x0036 for B:7:0x0011 already processed. Defaulting to fallback option. */
    private PrimaryTurns mapMyIndiaInstructionToHMC(Long l) {
        PrimaryTurns primaryTurns = PrimaryTurns.WRONG_WAY;
        int iIntValue = l.intValue();
        if (iIntValue == 36) {
            return PrimaryTurns.FERRY;
        }
        if (iIntValue != 41) {
            switch (iIntValue) {
                case 0:
                    return PrimaryTurns.TURN_LEFT;
                case 1:
                    return PrimaryTurns.TURN_SHARP_LEFT;
                case 2:
                    return PrimaryTurns.FORK_LEFT;
                case 3:
                    return PrimaryTurns.TURN_RIGHT;
                case 4:
                    return PrimaryTurns.TURN_SHARP_RIGHT;
                case 5:
                    return PrimaryTurns.FORK_RIGHT;
                case 6:
                    return PrimaryTurns.U_TURN_LEFT;
                case 7:
                    return PrimaryTurns.STRAIGHT;
                case 8:
                    return PrimaryTurns.DESTINATION_REACHED;
                default:
                    switch (iIntValue) {
                        case 11:
                        case 13:
                        case 22:
                        case 23:
                            return PrimaryTurns.TURN_LEFT;
                        case 12:
                        case 14:
                        case 24:
                        case 25:
                            return PrimaryTurns.TURN_RIGHT;
                        case 15:
                            return PrimaryTurns.TURN_SLIGHT_LEFT;
                        case 16:
                            return PrimaryTurns.TURN_SLIGHT_RIGHT;
                        case 17:
                            return PrimaryTurns.TURN_SHARP_LEFT;
                        case 18:
                            return PrimaryTurns.TURN_SHARP_RIGHT;
                        case 19:
                            return PrimaryTurns.KEEP_LEFT;
                        case 20:
                            return PrimaryTurns.KEEP_RIGHT;
                        default:
                            switch (iIntValue) {
                                case 50:
                                    break;
                                case 51:
                                case 52:
                                case 53:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 72:
                                    return PrimaryTurns.WRONG_WAY;
                                case 58:
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                    return PrimaryTurns.ROUNDABOUT_RIGHT;
                                case 65:
                                case 66:
                                case 67:
                                case 68:
                                case 69:
                                case 70:
                                case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                                    return PrimaryTurns.ROUNDABOUT_LEFT;
                                case 73:
                                case ReconyxHyperFireMakernoteDirectory.TAG_BRIGHTNESS /* 74 */:
                                    return PrimaryTurns.RAMP_LEFT;
                                case 75:
                                    return PrimaryTurns.RAMP_RIGHT;
                                default:
                                    return primaryTurns;
                            }
                        case 21:
                            return PrimaryTurns.STRAIGHT;
                    }
                    break;
            }
        } else {
            return PrimaryTurns.U_TURN_RIGHT;
        }
    }

    private int mapMyIndiaRoundabout(Long l) {
        switch (l.intValue()) {
            case 58:
            case 65:
                return 1;
            case 59:
            case 66:
                return 2;
            case 60:
            case 67:
                return 3;
            case 61:
            case 68:
                return 4;
            case 62:
            case 69:
                return 5;
            case 63:
            case 70:
                return 6;
            case 64:
            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                return 7;
            default:
                return 0;
        }
    }

    private int parseRoundaboutExit(AdviseInfo adviseInfo) {
        try {
            LegStep legStep = (LegStep) adviseInfo.getInfo();
            if (legStep.maneuver().exit() != null) {
                return legStep.maneuver().exit().intValue();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onGpsStateChange(boolean z) {
        if (z) {
            if (GlobalVar.gpsStatus != GpsStatus.ACTIVE) {
                GlobalVar.gpsStatus = GpsStatus.ACTIVE;
            }
        } else if (GlobalVar.gpsStatus == GpsStatus.ACTIVE) {
            GlobalVar.gpsStatus = GpsStatus.SEARCHING;
        }
    }

    public static class PendingWrite {
        public BluetoothGattCharacteristic characteristic;
        public byte[] payload;
        public int retryCount = 0;

        public PendingWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            this.characteristic = bluetoothGattCharacteristic;
            this.payload = bArr;
        }
    }

    private static String parseLocalNameFromAdvertisement(byte[] bArr) {
        int i;
        if (bArr != null && bArr.length >= 2) {
            int i2 = 0;
            while (i2 < bArr.length && (i = bArr[i2] & 255) != 0 && i2 + i < bArr.length) {
                int i3 = bArr[i2 + 1] & 255;
                if ((i3 == 8 || i3 == 9) && i >= 2) {
                    String strTrim = new String(bArr, i2 + 2, i - 1, StandardCharsets.UTF_8).trim();
                    if (!strTrim.isEmpty()) {
                        return strTrim;
                    }
                }
                i2 += i + 1;
            }
        }
        return null;
    }

    private static boolean scanBytesContainTarget(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0 || str == null || str.isEmpty()) {
            return false;
        }
        return new String(bArr, StandardCharsets.ISO_8859_1).toUpperCase(Locale.US).contains(str.trim().toUpperCase(Locale.US));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public String resolveScanDeviceName(ScanResult scanResult) {
        BluetoothAdapter bluetoothAdapter;
        if (scanResult != null && scanResult.getDevice() != null) {
            BluetoothDevice device = scanResult.getDevice();
            String address = device.getAddress();
            String name = device.getName();
            String str = ((name != null && !name.isEmpty()) || scanResult.getScanRecord() == null || (name = scanResult.getScanRecord().getDeviceName()) == null || name.isEmpty()) ? "device.getName" : "scanRecord.getDeviceName";
            if ((name == null || name.isEmpty()) && scanResult.getScanRecord() != null && (name = parseLocalNameFromAdvertisement(scanResult.getScanRecord().getBytes())) != null && !name.isEmpty()) {
                str = "adLocalName";
            }
            if ((name == null || name.isEmpty()) && scanResult.getScanRecord() != null && GlobalVar.bleDeviceName != null && !GlobalVar.bleDeviceName.isEmpty() && scanBytesContainTarget(scanResult.getScanRecord().getBytes(), GlobalVar.bleDeviceName)) {
                name = GlobalVar.bleDeviceName;
                str = "rawBytesContainTarget";
            }
            if ((name == null || name.isEmpty()) && address != null && (bluetoothAdapter = this.mBluetoothAdapter) != null) {
                try {
                    BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(address);
                    int bondState = remoteDevice != null ? remoteDevice.getBondState() : -1;
                    String name2 = remoteDevice != null ? remoteDevice.getName() : null;
                    if (bondState == 12 && name2 != null && !name2.isEmpty()) {
                        str = "bondedCache";
                        name = name2;
                    }
                } catch (Exception e) {
                    Log.w("BLE", "resolveScanDeviceName bond lookup failed: " + e.getMessage());
                }
            }
            if (name != null && !name.isEmpty() && address != null) {
                this.scanNameCache.put(address, name);
                if (!"device.getName".equals(str) && !"scanRecord.getDeviceName".equals(str)) {
                    Log.d("BLE", "resolveScanDeviceName: mac=" + address + " name=" + name + " via=" + str);
                }
                return name;
            }
            if (address != null && this.scanNameCache.containsKey(address)) {
                return this.scanNameCache.get(address);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean clusterNamesMatch(String str, String str2) {
        if (str != null && str2 != null) {
            String strTrim = str.trim();
            String strTrim2 = str2.trim();
            if (!strTrim.isEmpty() && !strTrim2.isEmpty()) {
                return strTrim.equalsIgnoreCase(strTrim2);
            }
        }
        return false;
    }
}
