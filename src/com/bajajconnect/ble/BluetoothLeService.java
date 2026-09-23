package com.bajajconnect.ble;

import android.app.Notification;
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
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelUuid;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.enums.Alert;
import com.bajajconnect.enums.CallState;
import com.bajajconnect.enums.GpsStatus;
import com.bajajconnect.enums.PrimaryTurns;
import com.bajajconnect.features.VehicleFeature;
import com.bajajconnect.gMaps.NavigationActivity;
import com.bajajconnect.interfaces.ContactCallback;
import com.bajajconnect.interfaces.NavigationCallback;
import com.bajajconnect.interfaces.TakeMeHome;
import com.bajajconnect.models.AlertModel;
import com.bajajconnect.models.MissedCallModel;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.recievers.DialerCallGate;
import com.bajajconnect.recievers.IPhoneState;
import com.bajajconnect.utils.ContactsUtil;
import com.bajajconnect.utils.NavigationHelper;
import com.bajajconnect.utils.TbtNavFrame;
import com.bajajconnect.utils.Util;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.models.LegStep;
import it.innove.Peripheral$$ExternalSyntheticApiModelOutline0;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import org.apache.commons.lang3.StringUtils;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothLeService extends Service implements IPhoneState, NavigationCallback, TakeMeHome {
    public static final String ACTION_CONNECT = "com.bajajconnect.ble.ACTION_BLE_CONNECT";
    public static final String ACTION_DISCONNECT = "com.bajajconnect.ble.ACTION_BLE_DISCONNECT";
    public static final String ACTION_STARTBLE = "com.bajajconnect.ble.ACTION_BLE_START";
    public static final String ACTION_START_FOREGROUND = "com.bajajconnect.ble.ACTION_BLE_START_Foreground";
    public static final String CHANNEL_ID = "ForegroundServiceChannel";
    private static final long SCAN_PERIOD = 10000;
    private static BluetoothGatt mBluetoothGatt;
    private HandlerThread bleHandler;
    private BluetoothDevice bluetoothDevice;
    BluetoothLeScanner bluetoothLeScanner;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothManager mBluetoothManager;
    private Handler mHandler;
    private static final Queue<BLEFrame> bleCommandQueue = new LinkedList();
    public static final Queue<AlertModel> alertsList = new LinkedList();
    public static final Queue<MissedCallModel> missedCallList = new LinkedList();
    static long commandId = 0;
    private ScheduledExecutorService readScheduler = null;
    private ScheduledExecutorService bleCommandController = null;
    private boolean readFlag = false;
    int resetQueueTimer = 2;
    private String mBluetoothDeviceAddress = "";
    public boolean shouldConnect = true;
    public boolean isSecondCall = false;
    private volatile boolean googleDestinationReachedAnnounced = false;
    private volatile NavInfo latestGoogleNavInfo = null;
    private int BLE_READ_TIME_PERIOD = 1000;
    private boolean isBleCommandActive = false;
    private BLEFrame currentBleFrame = null;
    private final BluetoothGattCallback mGattCallback = new AnonymousClass1();
    private final ScanSettings scanSettings = new ScanSettings.Builder().setScanMode(2).build();
    private final ScanCallback mLeScanCallback = new ScanCallback() { // from class: com.bajajconnect.ble.BluetoothLeService.2
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            try {
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BluetoothLeService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    if (Objects.equals(scanResult.getDevice().getName(), GlobalVar.bleDeviceName)) {
                        BluetoothLeService.this.scanLeDevice(false);
                        if (!GlobalVar.isBlueToothConnected) {
                            BluetoothLeService.this.bluetoothDevice = scanResult.getDevice();
                            if (BluetoothLeService.this.bluetoothDevice.getBondState() == 12) {
                                BluetoothLeService.this.connect(scanResult.getDevice().getAddress());
                            } else {
                                BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                                bluetoothLeService.registerReceiver(bluetoothLeService.mPairReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
                                BluetoothLeService.this.bluetoothDevice.createBond();
                            }
                        }
                    }
                    super.onScanResult(i, scanResult);
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            super.onScanFailed(i);
        }
    };
    private final BroadcastReceiver mPairReceiver = new BroadcastReceiver() { // from class: com.bajajconnect.ble.BluetoothLeService.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
                if (intExtra == 12 && intExtra2 == 11) {
                    BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                    bluetoothLeService.connect(bluetoothLeService.bluetoothDevice.getAddress());
                    try {
                        BluetoothLeService.this.unregisterReceiver(this);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onNavigationProgress(AdviseInfo adviseInfo) {
    }

    public static boolean isGattConnected() {
        return mBluetoothGatt != null && GlobalVar.isMTUIncreased;
    }

    public static synchronized void prepareCharAndWrite(final BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) {
        if (bluetoothGattCharacteristic != null) {
            if (GlobalVar.isMTUIncreased) {
                bluetoothGattCharacteristic.setWriteType(2);
                bluetoothGattCharacteristic.setValue(bArr);
                commandId++;
                if (bluetoothGattCharacteristic == GlobalVar.TBT_DATA_CHAR) {
                    bleCommandQueue.removeIf(new Predicate() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda2
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return BluetoothLeService.lambda$prepareCharAndWrite$0(bluetoothGattCharacteristic, (BLEFrame) obj);
                        }
                    });
                } else if (bluetoothGattCharacteristic == GlobalVar.TBT_INFO_CHAR) {
                    bleCommandQueue.removeIf(new Predicate() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda3
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return BluetoothLeService.lambda$prepareCharAndWrite$1(bluetoothGattCharacteristic, (BLEFrame) obj);
                        }
                    });
                }
                bleCommandQueue.add(new BLEFrame(commandId, bluetoothGattCharacteristic, BleCommandType.WRITE, bArr, z));
            }
        }
    }

    static /* synthetic */ boolean lambda$prepareCharAndWrite$0(BluetoothGattCharacteristic bluetoothGattCharacteristic, BLEFrame bLEFrame) {
        return bLEFrame.characteristic == bluetoothGattCharacteristic && !bLEFrame.shouldWaitForResponse;
    }

    static /* synthetic */ boolean lambda$prepareCharAndWrite$1(BluetoothGattCharacteristic bluetoothGattCharacteristic, BLEFrame bLEFrame) {
        return bLEFrame.characteristic == bluetoothGattCharacteristic && !bLEFrame.shouldWaitForResponse;
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onSignalStrengthChange(int i) {
        if (GlobalVar.signalStrength != i) {
            GlobalVar.signalStrength = i;
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onBatteryPercentageChange(int i) {
        GlobalVar.batteryPercentage = i;
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onSmsReceived(Context context, final String str) {
        if (GlobalVar.isBlueToothConnected) {
            GlobalVar.smsCount++;
            ContactsUtil.getContactName(this, str, new ContactCallback() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda6
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BluetoothLeService.lambda$onSmsReceived$2(str, str2);
                }
            });
        }
    }

    static /* synthetic */ void lambda$onSmsReceived$2(String str, String str2) {
        AlertModel alertModel;
        if (Objects.equals(str2, "") || Objects.equals(str2, StringUtils.SPACE)) {
            alertModel = new AlertModel(GlobalVar.smsCount, Alert.SMS, str, Util.getTimeStamp());
        } else {
            alertModel = new AlertModel(GlobalVar.smsCount, Alert.SMS, str2, Util.getTimeStamp());
        }
        alertsList.add(alertModel);
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onNotificationRecieved(Context context, String str) {
        if (GlobalVar.isBlueToothConnected) {
            GlobalVar.smsCount++;
            alertsList.add(new AlertModel(GlobalVar.smsCount, Alert.WAPP, str, Util.getTimeStamp()));
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onHeadsetConnected() {
        GlobalVar.isHeadsetConnected = true;
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onHeadsetDisconnected() {
        GlobalVar.isHeadsetConnected = false;
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onIncoming(Context context, String str, Date date) {
        if (DialerCallGate.shouldSuppressTelephonyCallEvents(context)) {
            DialerCallGate.clearClusterCallState("onIncoming suppressed");
        } else if (GlobalVar.callState == CallState.NO_CALL || GlobalVar.callState == CallState.INCOMING_CALL) {
            applyIncomingCaller(context, str);
        } else {
            this.isSecondCall = true;
        }
    }

    private void applyIncomingCaller(Context context, String str) {
        if (str == null) {
            return;
        }
        final String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        GlobalVar.callerNumber = strTrim;
        GlobalVar.callState = CallState.INCOMING_CALL;
        GlobalVar.callerName = strTrim;
        try {
            ContactsUtil.getContactName(context, strTrim, new ContactCallback() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda11
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BluetoothLeService.lambda$applyIncomingCaller$3(strTrim, str2);
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void lambda$applyIncomingCaller$3(String str, String str2) {
        if ((GlobalVar.callState == CallState.INCOMING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL) && Objects.equals(GlobalVar.callerNumber, str)) {
            if (str2 != null && !str2.trim().isEmpty()) {
                str = str2.trim();
            }
            GlobalVar.callerName = str;
        }
    }

    private void applyOutgoingCaller(Context context, String str) {
        if (str == null) {
            return;
        }
        final String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        GlobalVar.callerNumber = strTrim;
        GlobalVar.callState = CallState.OUTGOING_CALL;
        GlobalVar.callerName = strTrim;
        try {
            ContactsUtil.getContactName(context, strTrim, new ContactCallback() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda10
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BluetoothLeService.lambda$applyOutgoingCaller$4(strTrim, str2);
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void lambda$applyOutgoingCaller$4(String str, String str2) {
        if ((GlobalVar.callState == CallState.OUTGOING_CALL || GlobalVar.callState == CallState.ACTIVE_CALL) && Objects.equals(GlobalVar.callerNumber, str)) {
            if (str2 != null && !str2.trim().isEmpty()) {
                str = str2.trim();
            }
            GlobalVar.callerName = str;
        }
    }

    private void clearCallerInfo() {
        GlobalVar.callState = CallState.NO_CALL;
        GlobalVar.callerName = "";
        GlobalVar.callerNumber = "";
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onIncomingCallStarted(Context context, String str, Date date) {
        if (DialerCallGate.shouldSuppressTelephonyCallEvents(context)) {
            DialerCallGate.clearClusterCallState("onIncomingCallStarted suppressed");
            return;
        }
        GlobalVar.callState = CallState.ACTIVE_CALL;
        if (GlobalVar.callerName == null || GlobalVar.callerName.trim().isEmpty()) {
            String strTrim = GlobalVar.callerNumber != null ? GlobalVar.callerNumber.trim() : "";
            if (strTrim.isEmpty()) {
                return;
            }
            GlobalVar.callerName = strTrim;
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onOutgoingCallStarted(Context context, String str, Date date) {
        if (DialerCallGate.shouldSuppressTelephonyCallEvents(context)) {
            DialerCallGate.clearClusterCallState("onOutgoingCallStarted suppressed");
        } else {
            applyOutgoingCaller(context, str);
            GlobalVar.callProgressCount = 0;
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onOutgoingCallConnected(Context context, String str, Date date) {
        if (DialerCallGate.shouldSuppressTelephonyCallEvents(context)) {
            DialerCallGate.clearClusterCallState("onOutgoingCallConnected suppressed");
            return;
        }
        if (GlobalVar.callState != CallState.ACTIVE_CALL) {
            GlobalVar.callState = CallState.OUTGOING_CALL;
        }
        if (GlobalVar.callerName == null || GlobalVar.callerName.trim().isEmpty()) {
            String strTrim = GlobalVar.callerNumber != null ? GlobalVar.callerNumber.trim() : "";
            if (strTrim.isEmpty()) {
                return;
            }
            GlobalVar.callerName = strTrim;
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onIncomingCallEnded(Context context, String str, Date date, Date date2) {
        this.isSecondCall = false;
        clearCallerInfo();
        refreshRecentCallsAfterCallEnd(context, "incomingEnd");
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onOutgoingCallEnded(Context context, String str, Date date, Date date2) {
        clearCallerInfo();
        refreshRecentCallsAfterCallEnd(context, "outgoingEnd");
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onMissedCall(Context context, final String str, Date date) {
        GlobalVar.callState = CallState.NO_CALL;
        if (GlobalVar.isBlueToothConnected) {
            GlobalVar.missedCallCount++;
            ContactsUtil.getContactName(context, str, new ContactCallback() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda8
                @Override // com.bajajconnect.interfaces.ContactCallback
                public final void result(String str2) {
                    BluetoothLeService.lambda$onMissedCall$5(str, str2);
                }
            });
        }
        refreshRecentCallsAfterCallEnd(context, "missedCall");
    }

    static /* synthetic */ void lambda$onMissedCall$5(String str, String str2) {
        if (Objects.equals(str2, "") || Objects.equals(str2, StringUtils.SPACE)) {
            GlobalVar.missedCallName = str;
        } else {
            GlobalVar.missedCallName = str2;
        }
        if (Objects.equals(str2, "") || Objects.equals(str2, StringUtils.SPACE)) {
            return;
        }
        missedCallList.add(new MissedCallModel(GlobalVar.missedCallCount, GlobalVar.missedCallName, str, Util.getTimeStamp()));
    }

    private void refreshRecentCallsAfterCallEnd(final Context context, final String str) {
        if (VehicleFeature.BLE_FAV_RECENT_CALLS.isEnabledFor(BleFeatures.getInstance().modelCode) && GlobalVar.isBlueToothConnected && GlobalVar.RECENT_CALLS_CHAR != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    BluetoothLeService.lambda$refreshRecentCallsAfterCallEnd$6(str, context);
                }
            }, 1500L);
        }
    }

    static /* synthetic */ void lambda$refreshRecentCallsAfterCallEnd$6(String str, Context context) {
        try {
            Log.i("BLE_FAV_RC", str + ": refreshing recent calls after call end");
            RecentCallsFrame.sendRecentCalls(context.getApplicationContext());
        } catch (Exception e) {
            Log.e("BLE_FAV_RC", str + ": failed to refresh recent calls", e);
        }
    }

    @Override // com.bajajconnect.recievers.IPhoneState
    public void onBluetoothDisconnected() {
        GlobalVar.isBlueToothConnected = false;
        disconnect();
        bleCommandQueue.clear();
        BleFeatures.getInstance().resetSavedValues();
        if (BleFeatures.getInstance().controls != null) {
            BleFeatures.getInstance().controls.lastData = null;
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onNavigationStart() {
        if (isBleTbtEnabled()) {
            this.googleDestinationReachedAnnounced = false;
            this.latestGoogleNavInfo = null;
            if (GlobalVar.gpsStatus != GpsStatus.ACTIVE) {
                GlobalVar.gpsStatus = GpsStatus.ACTIVE;
            }
            GlobalVar.isNavigationActive = true;
            if (!GlobalVar.isBlueToothConnected || GlobalVar.TBT_INFO_CHAR == null) {
                return;
            }
            prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, TbtNavFrame.buildNavHelperFrame(1, PrimaryTurns.STRAIGHT.getValue(), true, 0, 0, 0, 0, 0, ""), true);
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onNavigationStop() {
        if (isBleTbtEnabled()) {
            GlobalVar.isNavigationActive = false;
            this.googleDestinationReachedAnnounced = false;
            this.latestGoogleNavInfo = null;
            if (!GlobalVar.isBlueToothConnected || GlobalVar.TBT_INFO_CHAR == null) {
                return;
            }
            prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, TbtNavFrame.buildNavHelperFrame(0, 0, true, 0, 0, 0, 0, 0, ""), true);
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onDestinationReached() {
        int iMax;
        if (isBleTbtEnabled()) {
            NavInfo navInfo = this.latestGoogleNavInfo;
            if (navInfo != null) {
                try {
                    iMax = Math.max(0, navInfo.getDistanceToFinalDestinationMeters().intValue());
                } catch (Exception unused) {
                    iMax = 0;
                }
            } else {
                iMax = 0;
            }
            if (iMax > 80) {
                Log.i("BLE_TBT", "ignore early onArrival — remaining=" + iMax + "m");
                return;
            }
            if (this.googleDestinationReachedAnnounced) {
                return;
            }
            this.googleDestinationReachedAnnounced = true;
            prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, TbtNavFrame.buildNavHelperFrame(1, PrimaryTurns.DESTINATION_REACHED.getValue(), true, 0, 0, 0, 0, 0, "Destination reached"), false);
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onRerouting() {
        if (isBleTbtEnabled()) {
            this.googleDestinationReachedAnnounced = false;
            Log.i("BLE_TBT", "onRerouting — sending reroute TBT to cluster");
            prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, TbtNavFrame.buildNavHelperFrame(1, PrimaryTurns.STRAIGHT.getValue(), true, 0, 0, 0, 0, 0, "Rerouting..."), false);
        }
    }

    @Override // com.bajajconnect.interfaces.NavigationCallback
    public void onNavigationProgress(AdviseInfo adviseInfo, NavInfo navInfo) {
        if (isBleTbtEnabled()) {
            if (navInfo != null) {
                this.latestGoogleNavInfo = navInfo;
            }
            if (!GlobalVar.isBlueToothConnected || GlobalVar.TBT_INFO_CHAR == null) {
                return;
            }
            if (GlobalVar.isGoogleNavigation) {
                processAdviseInfoGoogle(navInfo);
            } else {
                processAdviseInfo(adviseInfo);
            }
        }
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
            Intent intentCreateLaunchIntent = NavigationActivity.createLaunchIntent(getApplicationContext());
            intentCreateLaunchIntent.setAction(GlobalVar.takeMeHomeActionStart);
            getApplicationContext().startActivity(intentCreateLaunchIntent);
            return;
        }
        if (GlobalVar.isIsTakeMeHomeNavStarting || GlobalVar.isNavigationActive) {
            return;
        }
        try {
            GlobalVar.lat = Double.valueOf(29.94569d);
            GlobalVar.lng = Double.valueOf(78.164246d);
            ELocation eLocation2 = new ELocation();
            eLocation2.latitude = d;
            eLocation2.longitude = d2;
            eLocation2.placeName = str;
            NavApplication.eLocation = eLocation2;
            if (GlobalVar.waypoints != null) {
                GlobalVar.waypoints.clear();
            }
            GlobalVar.waypoints = new ArrayList();
            Intent intent = new Intent(this, (Class<?>) HomeActivity.class);
            intent.addFlags(268435456);
            intent.setAction(GlobalVar.takeMeHomeActionStart);
            getApplicationContext().startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(getApplicationContext(), "Something went wrong", 0).show();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.mHandler = new Handler(Looper.getMainLooper());
        if (Objects.equals(intent.getAction(), "com.bajajconnect.ble.ACTION_BLE_DISCONNECT")) {
            this.shouldConnect = false;
            if (GlobalVar.isBlueToothConnected) {
                disconnect();
            }
        }
        if (Objects.equals(intent.getAction(), "com.bajajconnect.ble.ACTION_BLE_CONNECT")) {
            this.shouldConnect = true;
            scanLeDevice(true);
        } else if (Objects.equals(intent.getAction(), "com.bajajconnect.ACTION_FOREGROUND_STOP")) {
            try {
                this.shouldConnect = false;
                if (GlobalVar.isBlueToothConnected) {
                    disconnect();
                }
                scanLeDevice(false);
            } catch (Exception unused) {
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
        Notification notificationBuild = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Bluetooth Service").setContentText("Ride Connect app uses bluetooth in background").build();
        if (Build.VERSION.SDK_INT >= 34) {
            startForeground(8909, notificationBuild, 16);
        } else {
            startForeground(8909, notificationBuild);
        }
        HandlerThread handlerThread = this.bleHandler;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.bleHandler = null;
        }
        HandlerThread handlerThread2 = new HandlerThread("BleHandler");
        this.bleHandler = handlerThread2;
        handlerThread2.start();
        BleFeatures.getInstance().registerIphoneListener(this);
        BleFeatures.getInstance().registerNavigationCallback(this);
        BleFeatures.getInstance().registerTakeMeHomeCallback(this);
        BleFeatures.getInstance().listenPhone(this, true);
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        terminatAll();
    }

    private void terminatAll() {
        try {
            BleFeatures.getInstance().stopMusicListening();
            BleFeatures.getInstance().unRegisterReceivers(this);
            BleFeatures.getInstance().unregisterCallRecievers(this);
        } catch (Exception unused) {
        }
        try {
            Log.e("Ble service", "kill the app");
            BleFeatures.getInstance().resetSavedValuesOnKill();
            disconnect();
            BleFeatures.getInstance().spotifySessionCallback.onSession(false);
            GlobalVar.isBlueToothConnected = false;
            stopForeground(true);
            stopSelf();
            stopService(new Intent(this, (Class<?>) BluetoothLeService.class));
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.ble.BluetoothLeService$1, reason: invalid class name */
    class AnonymousClass1 extends BluetoothGattCallback {
        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        }

        AnonymousClass1() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 2) {
                BluetoothLeService.alertsList.clear();
                Controls.controlCount = 0L;
                if (BleFeatures.getInstance().controls != null) {
                    BleFeatures.getInstance().controls.resetDialEdgeState();
                }
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BluetoothLeService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    boolean z = GlobalVar.isBlueToothConnected;
                    GlobalVar.isBlueToothConnected = true;
                    if (!z && BleFeatures.getInstance().connectionCallback != null) {
                        BleFeatures.getInstance().connectionCallback.onStateChange(true);
                    }
                    BluetoothLeService.mBluetoothGatt.discoverServices();
                    return;
                }
                return;
            }
            if (i2 == 0) {
                GlobalVar.isMTUIncreased = false;
                BluetoothLeService.alertsList.clear();
                Controls.controlCount = 0L;
                if (BleFeatures.getInstance().controls != null) {
                    BleFeatures.getInstance().controls.resetDialEdgeState();
                }
                if (BleFeatures.getInstance().connectionCallback != null) {
                    BleFeatures.getInstance().connectionCallback.onStateChange(false);
                }
                BleFeatures.getInstance().resetSavedValues();
                GlobalVar.isBlueToothConnected = false;
                BluetoothLeService.this.stopControlsTimer();
                BleFeatures.getInstance().stopBleTimer();
                BluetoothLeService.bleCommandQueue.clear();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            GlobalVar.isMTUIncreased = true;
            BluetoothLeService.this.startWriteController();
            BluetoothLeService.this.startControlsTimer();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                bluetoothLeService.displayGattServices(bluetoothLeService.getSupportedGattServices());
                BluetoothLeService.this.requestConnectionPriority(1);
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BluetoothLeService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    BluetoothLeService.mBluetoothGatt.requestMtu(256);
                    GlobalVar.isBlueToothConnected = true;
                    BleFeatures.getInstance().getBatteryPercentage(BluetoothLeService.this.getApplicationContext());
                    if (GlobalVar.isNavigationActive && GlobalVar.isBlueToothConnected && GlobalVar.TBT_INFO_CHAR != null) {
                        BluetoothLeService.prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, TbtNavFrame.buildNavHelperFrame(1, PrimaryTurns.STRAIGHT.getValue(), true, 0, 0, 0, 0, 0, ""), false);
                        return;
                    }
                    return;
                }
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BluetoothLeService$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onServicesDiscovered$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onServicesDiscovered$0() {
            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BluetoothLeService.this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                BluetoothLeService.mBluetoothGatt.discoverServices();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                Timber.d("Callback: wrote GATT Descriptor succesfully.", new Object[0]);
            } else {
                Timber.d("Callback: Error writing GATT Descriptor: %s", Integer.valueOf(i));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public synchronized void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (BluetoothLeService.this.currentBleFrame.shouldWaitForResponse) {
                BluetoothLeService.this.isBleCommandActive = false;
            }
            if (i != 0) {
                if (i == 13) {
                    Timber.d("onCharacteristicWrite() invalid attribute length", new Object[0]);
                } else {
                    Timber.d("onCharacteristicWrite() failed. Status = %d", Integer.valueOf(i));
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public synchronized void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            try {
                if (i == 0) {
                    if (bluetoothGattCharacteristic == GlobalVar.CONTROL_CHAR) {
                        Log.e("BluetoothService", "read success");
                        GlobalVar.CONTROL_CHAR = bluetoothGattCharacteristic;
                        BleFeatures.getInstance().controls.processData(bluetoothGattCharacteristic.getValue());
                    }
                } else {
                    Log.e("BluettohService", "onCharactersticRead error: " + i);
                }
                BluetoothLeService.this.isBleCommandActive = false;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            Timber.d("onCharacteristicChanged", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayGattServices(List<BluetoothGattService> list) {
        Timber.d("DisplayGattServices", new Object[0]);
        if (list == null) {
            disconnect();
            return;
        }
        GlobalVar.mGattCharacteristics = new ArrayList<>();
        Iterator<BluetoothGattService> it2 = list.iterator();
        while (it2.hasNext()) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : it2.next().getCharacteristics()) {
                String string = bluetoothGattCharacteristic.getUuid().toString();
                string.hashCode();
                switch (string) {
                    case "0210676e-6972-6565-6e69-676e4543544f":
                        if (GlobalVar.TBT_DATA_CHAR != bluetoothGattCharacteristic) {
                            GlobalVar.TBT_DATA_CHAR = bluetoothGattCharacteristic;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "0510676e-6972-6565-6e69-676e4543544f":
                        if (GlobalVar.PLAYLIST_INFO_CHAR != bluetoothGattCharacteristic) {
                            GlobalVar.PLAYLIST_INFO_CHAR = bluetoothGattCharacteristic;
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
                    case "0a10676e-6972-6565-6e69-676e4543544f":
                        if (GlobalVar.CONTROL_CHAR != bluetoothGattCharacteristic) {
                            GlobalVar.CONTROL_CHAR = bluetoothGattCharacteristic;
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
        }
    }

    public void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothAdapter == null || mBluetoothGatt == null) {
            Timber.d("BluetoothAdapter not initialized", new Object[0]);
        } else {
            bleCommandQueue.add(new BLEFrame(commandId, bluetoothGattCharacteristic, BleCommandType.READ, null, true));
        }
    }

    public void setCharacteristicNotificationNQ(String str, boolean z) {
        if (this.mBluetoothAdapter == null || mBluetoothGatt == null) {
            Timber.d("BluetoothAdapter not initialized", new Object[0]);
        }
    }

    public void requestConnectionPriority(int i) {
        if (mBluetoothGatt != null) {
            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                mBluetoothGatt.requestConnectionPriority(1);
            }
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(Peripheral$$ExternalSyntheticApiModelOutline0.m(CHANNEL_ID, "Foreground Service Channel", 3));
        }
    }

    public void initialize() {
        if (this.mBluetoothManager == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.mBluetoothManager = bluetoothManager;
            if (bluetoothManager == null) {
                return;
            }
        }
        BluetoothAdapter adapter = this.mBluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter == null) {
            return;
        }
        scanLeDevice(true);
    }

    public void connect(String str) {
        GlobalVar.bleDeviceAddress = str;
        if (this.mBluetoothAdapter == null || str == null) {
            return;
        }
        if (str.equals(this.mBluetoothDeviceAddress) && mBluetoothGatt != null) {
            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                mBluetoothGatt.connect();
                return;
            }
            return;
        }
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            mBluetoothGatt = remoteDevice.connectGatt(this, true, this.mGattCallback, 2, 1, new Handler(this.bleHandler.getLooper()));
        } else {
            mBluetoothGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        }
    }

    public void disconnect() {
        try {
            if (this.mBluetoothAdapter != null && mBluetoothGatt != null) {
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    mBluetoothGatt.disconnect();
                    close();
                    BleFeatures.getInstance().connectionCallback.onStateChange(false);
                    GlobalVar.isBlueToothConnected = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public List<BluetoothGattService> getSupportedGattServices() {
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public void scanLeDevice(boolean z) {
        try {
            Log.e("Bleservice", "connect " + GlobalVar.bleDeviceName);
            if (this.mBluetoothAdapter.isEnabled()) {
                if (this.bluetoothLeScanner == null) {
                    this.bluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
                }
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") == 0) {
                    if (z) {
                        this.mHandler.postDelayed(new Runnable() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$scanLeDevice$7();
                            }
                        }, 10000L);
                        BleFeatures.getInstance().connectionCallback.onScanning(true);
                        ParcelUuid.fromString(GlobalVar.MAIN_SERVICE);
                        ScanFilter scanFilterBuild = new ScanFilter.Builder().build();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(scanFilterBuild);
                        this.bluetoothLeScanner.startScan(arrayList, this.scanSettings, this.mLeScanCallback);
                        return;
                    }
                    this.bluetoothLeScanner.stopScan(this.mLeScanCallback);
                    this.bluetoothLeScanner = null;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scanLeDevice$7() {
        if (this.bluetoothLeScanner != null) {
            try {
                if (!this.mBluetoothAdapter.isEnabled()) {
                    return;
                } else {
                    this.bluetoothLeScanner.stopScan(this.mLeScanCallback);
                }
            } catch (Exception unused) {
            }
        }
        BleFeatures.getInstance().connectionCallback.onScanning(false);
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
                prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, bArrFromGoogleNavInfo, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getETAFromSeconds(int i) {
        return DateTimeFormatter.ofPattern("hh:mm a").format(ZonedDateTime.now().plusSeconds(i));
    }

    private PrimaryTurns mapmyIndiaInstructionToHMCGoogle(int i) {
        PrimaryTurns primaryTurns = PrimaryTurns.WRONG_WAY;
        if (i == 19) {
            return PrimaryTurns.FORK_LEFT;
        }
        if (i == 20) {
            return PrimaryTurns.FORK_RIGHT;
        }
        if (i != 43) {
            if (i != 44) {
                if (i != 47 && i != 49) {
                    if (i == 61) {
                        return PrimaryTurns.ROUNDABOUT_LEFT;
                    }
                    if (i != 62) {
                        switch (i) {
                            case 0:
                                return PrimaryTurns.WRONG_WAY;
                            case 1:
                            case 5:
                                return PrimaryTurns.STRAIGHT;
                            case 2:
                            case 3:
                            case 4:
                                return PrimaryTurns.DESTINATION_REACHED;
                            case 6:
                                return PrimaryTurns.TURN_LEFT;
                            case 7:
                                return PrimaryTurns.TURN_RIGHT;
                            case 8:
                                return PrimaryTurns.KEEP_LEFT;
                            case 9:
                                return PrimaryTurns.KEEP_RIGHT;
                            case 10:
                                return PrimaryTurns.TURN_SLIGHT_LEFT;
                            case 11:
                                return PrimaryTurns.TURN_SLIGHT_RIGHT;
                            case 12:
                                return PrimaryTurns.TURN_SHARP_LEFT;
                            case 13:
                                return PrimaryTurns.TURN_SHARP_RIGHT;
                            case 14:
                                return PrimaryTurns.U_TURN_RIGHT;
                            case 15:
                                return PrimaryTurns.U_TURN_LEFT;
                            default:
                                switch (i) {
                                    case 55:
                                    case 57:
                                        break;
                                    case 56:
                                    case 58:
                                        break;
                                    default:
                                        return primaryTurns;
                                }
                                break;
                        }
                    } else {
                        return PrimaryTurns.ROUNDABOUT_RIGHT;
                    }
                }
            }
            return PrimaryTurns.ROUNDABOUT_RIGHT;
        }
        return PrimaryTurns.ROUNDABOUT_LEFT;
    }

    private void processAdviseInfo(AdviseInfo adviseInfo) {
        if (adviseInfo != null) {
            try {
                prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, new NavigationHelper(adviseInfo).sendNavigationData(), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isBleTbtEnabled() {
        String str = BleFeatures.getInstance().modelCode;
        return !VehicleFeature.BLE_GENERAL_PACKET_V2.isEnabledFor(str) || VehicleFeature.BLE_TBT.isEnabledFor(str);
    }

    private boolean isAppNavigationEnabled() {
        String str = BleFeatures.getInstance().modelCode;
        return !VehicleFeature.BLE_GENERAL_PACKET_V2.isEnabledFor(str) || VehicleFeature.APP_NAVIGATION.isEnabledFor(str);
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

    private int mapmyIndiaRoundabout(Long l) {
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

    /* JADX WARN: Code duplicated, block: B:20:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:23:0x003f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0042  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Switch 'out' block B:20:0x0036 for B:7:0x0011 already processed. Defaulting to fallback option. */
    private PrimaryTurns mapmyIndiaInstructionToHMC(Long l) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void stopControlsTimer() {
        ScheduledExecutorService scheduledExecutorService = this.readScheduler;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.readScheduler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWriteController() {
        ScheduledExecutorService scheduledExecutorService = this.bleCommandController;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.bleCommandController = null;
        }
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.bleCommandController = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startWriteController$8();
            }
        }, 0L, 130L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startWriteController$8() {
        Queue<BLEFrame> queue = bleCommandQueue;
        if (queue.isEmpty()) {
            return;
        }
        this.currentBleFrame = queue.poll();
        if (GlobalVar.isBlueToothConnected && GlobalVar.isMTUIncreased && !this.isBleCommandActive) {
            if (this.currentBleFrame.bleCommandType == BleCommandType.WRITE) {
                this.currentBleFrame.characteristic.setValue(this.currentBleFrame.data);
                this.currentBleFrame.characteristic.setWriteType(this.currentBleFrame.shouldWaitForResponse ? 2 : 1);
                mBluetoothGatt.writeCharacteristic(this.currentBleFrame.characteristic);
            } else {
                if (this.currentBleFrame.bleCommandType != BleCommandType.READ || GlobalVar.pauseBleReading) {
                    return;
                }
                this.isBleCommandActive = true;
                mBluetoothGatt.readCharacteristic(GlobalVar.CONTROL_CHAR);
            }
        }
    }

    public static void cleanCommandQueue() {
        bleCommandQueue.clear();
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
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.bajajconnect.ble.BluetoothLeService$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startControlsTimer$9();
            }
        }, 30L, this.BLE_READ_TIME_PERIOD, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startControlsTimer$9() {
        if (GlobalVar.isBlueToothConnected && GlobalVar.CONTROL_CHAR != null && GlobalVar.isMTUIncreased) {
            readCharacteristic(GlobalVar.CONTROL_CHAR);
            if (MirroringGlobarVar.isWifiConnected) {
                this.BLE_READ_TIME_PERIOD = 1000;
            } else {
                this.BLE_READ_TIME_PERIOD = 1000;
            }
        }
    }
}
