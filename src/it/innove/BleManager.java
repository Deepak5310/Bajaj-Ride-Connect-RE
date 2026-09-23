package it.innove;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Ascii;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes4.dex */
class BleManager extends ReactContextBaseJavaModule {
    private static final int ENABLE_REQUEST = 539;
    public static final String LOG_TAG = "ReactNativeBleManager";
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static ReadableMap moduleOptions;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothManager bluetoothManager;
    private BondRequest bondRequest;
    private Context context;
    private Callback enableBluetoothCallback;
    private boolean forceLegacy;
    private final ActivityEventListener mActivityEventListener;
    private final BroadcastReceiver mReceiver;
    private final Map<String, Peripheral> peripherals;
    private ReactApplicationContext reactContext;
    private BondRequest removeBondRequest;
    private ScanManager scanManager;

    static /* synthetic */ void lambda$onCatalystInstanceDestroy$0(Object[] objArr) {
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    private static class BondRequest {
        private Callback callback;
        private String pin;
        private String uuid;

        BondRequest(String str, Callback callback) {
            this.uuid = str;
            this.callback = callback;
        }

        BondRequest(String str, String str2, Callback callback) {
            this.uuid = str;
            this.pin = str2;
            this.callback = callback;
        }
    }

    public ReactApplicationContext getReactContext() {
        return this.reactContext;
    }

    public BleManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        BaseActivityEventListener baseActivityEventListener = new BaseActivityEventListener() { // from class: it.innove.BleManager.1
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                Log.d(BleManager.LOG_TAG, "onActivityResult");
                if (i != 539 || BleManager.this.enableBluetoothCallback == null) {
                    return;
                }
                if (i2 == -1) {
                    BleManager.this.enableBluetoothCallback.invoke(new Object[0]);
                } else {
                    BleManager.this.enableBluetoothCallback.invoke("User refused to enable");
                }
                BleManager.this.enableBluetoothCallback = null;
            }
        };
        this.mActivityEventListener = baseActivityEventListener;
        this.peripherals = new LinkedHashMap();
        this.mReceiver = new BroadcastReceiver() { // from class: it.innove.BleManager.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                BluetoothDevice bluetoothDevice;
                BluetoothDevice bluetoothDevice2;
                String str;
                Peripheral peripheral;
                Log.d(BleManager.LOG_TAG, "onReceive");
                String action = intent.getAction();
                if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                    String str2 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                    switch (intExtra) {
                        case 10:
                            BleManager.this.clearPeripherals();
                            break;
                        case 11:
                            str2 = "turning_on";
                            break;
                        case 12:
                            str2 = "on";
                            break;
                        case 13:
                            BleManager.this.disconnectPeripherals();
                            str2 = "turning_off";
                            break;
                    }
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString("state", str2);
                    Log.d(BleManager.LOG_TAG, "state: ".concat(str2));
                    BleManager.this.sendEvent("BleManagerDidUpdateState", writableMapCreateMap);
                    return;
                }
                if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                    int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                    int intExtra3 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
                    if (Build.VERSION.SDK_INT >= 33) {
                        bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
                    } else {
                        bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    }
                    switch (intExtra2) {
                        case 10:
                            str = "BOND_NONE";
                            break;
                        case 11:
                            str = "BOND_BONDING";
                            break;
                        case 12:
                            str = "BOND_BONDED";
                            break;
                        default:
                            str = "UNKNOWN";
                            break;
                    }
                    Log.d(BleManager.LOG_TAG, "bond state: ".concat(str));
                    if (BleManager.this.bondRequest != null && BleManager.this.bondRequest.uuid.equals(bluetoothDevice2.getAddress())) {
                        if (intExtra2 == 12) {
                            BleManager.this.bondRequest.callback.invoke(new Object[0]);
                            BleManager.this.bondRequest = null;
                        } else if (intExtra2 == 10 || intExtra2 == Integer.MIN_VALUE) {
                            BleManager.this.bondRequest.callback.invoke("Bond request has been denied");
                            BleManager.this.bondRequest = null;
                        }
                    }
                    if (intExtra2 == 12) {
                        if (!BleManager.this.forceLegacy) {
                            peripheral = new DefaultPeripheral(bluetoothDevice2, BleManager.this.reactContext);
                        } else {
                            peripheral = new Peripheral(bluetoothDevice2, BleManager.this.reactContext);
                        }
                        BleManager.this.sendEvent("BleManagerPeripheralDidBond", peripheral.asWritableMap());
                    }
                    if (BleManager.this.removeBondRequest != null && BleManager.this.removeBondRequest.uuid.equals(bluetoothDevice2.getAddress()) && intExtra2 == 10 && intExtra3 == 12) {
                        BleManager.this.removeBondRequest.callback.invoke(new Object[0]);
                        BleManager.this.removeBondRequest = null;
                        return;
                    }
                    return;
                }
                if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
                    } else {
                        bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    }
                    if (BleManager.this.bondRequest == null || !BleManager.this.bondRequest.uuid.equals(bluetoothDevice.getAddress()) || BleManager.this.bondRequest.pin == null) {
                        return;
                    }
                    bluetoothDevice.setPin(BleManager.this.bondRequest.pin.getBytes());
                    bluetoothDevice.createBond();
                }
            }
        };
        this.context = reactApplicationContext;
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(baseActivityEventListener);
        Log.d(LOG_TAG, "BleManager created");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "BleManager";
    }

    private BluetoothAdapter getBluetoothAdapter() {
        if (this.bluetoothAdapter == null) {
            this.bluetoothAdapter = ((BluetoothManager) this.context.getSystemService("bluetooth")).getAdapter();
        }
        return this.bluetoothAdapter;
    }

    private BluetoothManager getBluetoothManager() {
        if (this.bluetoothManager == null) {
            this.bluetoothManager = (BluetoothManager) this.context.getSystemService("bluetooth");
        }
        return this.bluetoothManager;
    }

    public void sendEvent(String str, WritableMap writableMap) {
        ((RCTNativeAppEventEmitter) getReactApplicationContext().getJSModule(RCTNativeAppEventEmitter.class)).emit(str, writableMap);
    }

    @ReactMethod
    public void start(ReadableMap readableMap, Callback callback) {
        Log.d(LOG_TAG, ViewProps.START);
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
            return;
        }
        this.forceLegacy = false;
        moduleOptions = readableMap;
        if (readableMap.hasKey("forceLegacy")) {
            this.forceLegacy = readableMap.getBoolean("forceLegacy");
        }
        if (!this.forceLegacy) {
            this.scanManager = new DefaultScanManager(this.reactContext, this);
        } else {
            this.scanManager = new LegacyScanManager(this.reactContext, this);
        }
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        this.context.registerReceiver(this.mReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter("android.bluetooth.device.action.PAIRING_REQUEST");
        intentFilter2.setPriority(1000);
        this.context.registerReceiver(this.mReceiver, intentFilter2);
        callback.invoke(new Object[0]);
        Log.d(LOG_TAG, "BleManager initialized");
    }

    @ReactMethod
    public void enableBluetooth(Callback callback) {
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
            return;
        }
        if (!getBluetoothAdapter().isEnabled()) {
            this.enableBluetoothCallback = callback;
            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
            if (getCurrentActivity() == null) {
                callback.invoke("Current activity not available");
                return;
            }
            try {
                getCurrentActivity().startActivityForResult(intent, 539);
                return;
            } catch (Exception unused) {
                callback.invoke("Current activity not available");
                return;
            }
        }
        callback.invoke(new Object[0]);
    }

    @ReactMethod
    public void scan(ReadableArray readableArray, int i, boolean z, ReadableMap readableMap, Callback callback) {
        Log.d(LOG_TAG, "scan");
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
            return;
        }
        if (getBluetoothAdapter().isEnabled()) {
            synchronized (this.peripherals) {
                Iterator<Map.Entry<String, Peripheral>> it2 = this.peripherals.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry<String, Peripheral> next = it2.next();
                    if (!next.getValue().isConnected() && !next.getValue().isConnecting()) {
                        it2.remove();
                    }
                }
            }
            ScanManager scanManager = this.scanManager;
            if (scanManager != null) {
                scanManager.scan(readableArray, i, readableMap, callback);
            }
        }
    }

    @ReactMethod
    public void stopScan(Callback callback) {
        Log.d(LOG_TAG, "Stop scan");
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
        } else {
            if (!getBluetoothAdapter().isEnabled()) {
                callback.invoke(new Object[0]);
                return;
            }
            ScanManager scanManager = this.scanManager;
            if (scanManager != null) {
                scanManager.stopScan(callback);
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt(NotificationCompat.CATEGORY_STATUS, 0);
                sendEvent("BleManagerStopScan", writableMapCreateMap);
            }
        }
    }

    @ReactMethod
    public void createBond(String str, String str2, Callback callback) {
        Log.d(LOG_TAG, "Request bond to: " + str);
        Iterator<BluetoothDevice> it2 = getBluetoothAdapter().getBondedDevices().iterator();
        while (it2.hasNext()) {
            if (str.equalsIgnoreCase(it2.next().getAddress())) {
                callback.invoke(new Object[0]);
                return;
            }
        }
        Peripheral peripheralRetrieveOrCreatePeripheral = retrieveOrCreatePeripheral(str);
        if (peripheralRetrieveOrCreatePeripheral == null) {
            callback.invoke("Invalid peripheral uuid");
            return;
        }
        if (this.bondRequest != null) {
            callback.invoke("Only allow one bond request at a time");
            return;
        }
        if (peripheralRetrieveOrCreatePeripheral.getDevice().createBond()) {
            Log.d(LOG_TAG, "Request bond successful for: " + str);
            this.bondRequest = new BondRequest(str, str2, callback);
            return;
        }
        callback.invoke("Create bond request fail");
    }

    @ReactMethod
    private void removeBond(String str, Callback callback) {
        Log.d(LOG_TAG, "Remove bond to: " + str);
        Peripheral peripheralRetrieveOrCreatePeripheral = retrieveOrCreatePeripheral(str);
        if (peripheralRetrieveOrCreatePeripheral == null) {
            callback.invoke("Invalid peripheral uuid");
            return;
        }
        try {
            peripheralRetrieveOrCreatePeripheral.getDevice().getClass().getMethod("removeBond", null).invoke(peripheralRetrieveOrCreatePeripheral.getDevice(), null);
            this.removeBondRequest = new BondRequest(str, callback);
        } catch (Exception e) {
            Log.d(LOG_TAG, "Error in remove bond: " + str, e);
            callback.invoke("Remove bond request fail");
        }
    }

    @ReactMethod
    public void connect(String str, ReadableMap readableMap, Callback callback) {
        Log.d(LOG_TAG, "Connect to: " + str);
        Peripheral peripheralRetrieveOrCreatePeripheral = retrieveOrCreatePeripheral(str);
        if (peripheralRetrieveOrCreatePeripheral == null) {
            callback.invoke("Invalid peripheral uuid");
        } else {
            peripheralRetrieveOrCreatePeripheral.connect(callback, getCurrentActivity(), readableMap);
        }
    }

    @ReactMethod
    public void disconnect(String str, boolean z, Callback callback) {
        Log.d(LOG_TAG, "Disconnect from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.disconnect(callback, z);
        } else {
            callback.invoke("Peripheral not found");
        }
    }

    @ReactMethod
    public void startNotificationUseBuffer(String str, String str2, String str3, Integer num, Callback callback) {
        Log.d(LOG_TAG, "startNotification");
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.registerNotify(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), num, callback);
        } else {
            callback.invoke("Peripheral not found");
        }
    }

    @ReactMethod
    public void startNotification(String str, String str2, String str3, Callback callback) {
        Log.d(LOG_TAG, "startNotification");
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.registerNotify(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), 1, callback);
        } else {
            callback.invoke("Peripheral not found");
        }
    }

    @ReactMethod
    public void stopNotification(String str, String str2, String str3, Callback callback) {
        Log.d(LOG_TAG, "stopNotification");
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.removeNotify(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), callback);
        } else {
            callback.invoke("Peripheral not found");
        }
    }

    @ReactMethod
    public void write(String str, String str2, String str3, ReadableArray readableArray, Integer num, Callback callback) {
        Log.d(LOG_TAG, "Write to: " + str);
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            int size = readableArray.size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = Integer.valueOf(readableArray.getInt(i)).byteValue();
            }
            Log.d(LOG_TAG, "Message(" + size + "): " + bytesToHex(bArr));
            peripheral.write(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), bArr, num, null, callback, 2);
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void writeWithoutResponse(String str, String str2, String str3, ReadableArray readableArray, Integer num, Integer num2, Callback callback) {
        Log.d(LOG_TAG, "Write without response to: " + str);
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            int size = readableArray.size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = Integer.valueOf(readableArray.getInt(i)).byteValue();
            }
            Log.d(LOG_TAG, "Message(" + size + "): " + bytesToHex(bArr));
            peripheral.write(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), bArr, num, num2, callback, 1);
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void read(String str, String str2, String str3, Callback callback) {
        Log.d(LOG_TAG, "Read from: " + str);
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.read(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), callback);
        } else {
            callback.invoke("Peripheral not found", null);
        }
    }

    @ReactMethod
    public void readDescriptor(String str, String str2, String str3, String str4, Callback callback) {
        Log.d(LOG_TAG, "Read descriptor from: " + str);
        if (str2 == null || str3 == null || str4 == null) {
            callback.invoke("ServiceUUID, CharacteristicUUID and descriptorUUID required.", null);
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral == null) {
            callback.invoke("Peripheral not found", null);
        }
        peripheral.readDescriptor(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), UUIDHelper.uuidFromString(str4), callback);
    }

    @ReactMethod
    public void writeDescriptor(String str, String str2, String str3, String str4, ReadableArray readableArray, Callback callback) {
        Log.d(LOG_TAG, "Write descriptor from: " + str);
        if (str2 == null || str3 == null || str4 == null) {
            callback.invoke("ServiceUUID, CharacteristicUUID and descriptorUUID required.", null);
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral == null) {
            callback.invoke("Peripheral not found", null);
            return;
        }
        int size = readableArray.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < readableArray.size(); i++) {
            bArr[i] = Integer.valueOf(readableArray.getInt(i)).byteValue();
        }
        Log.d(LOG_TAG, "Message(" + size + "): " + bytesToHex(bArr));
        peripheral.writeDescriptor(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), UUIDHelper.uuidFromString(str4), bArr, callback);
    }

    @ReactMethod
    public void retrieveServices(String str, ReadableArray readableArray, Callback callback) {
        Log.d(LOG_TAG, "Retrieve services from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.retrieveServices(callback);
        } else {
            callback.invoke("Peripheral not found", null);
        }
    }

    @ReactMethod
    public void refreshCache(String str, Callback callback) {
        Log.d(LOG_TAG, "Refreshing cache for: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.refreshCache(callback);
        } else {
            callback.invoke("Peripheral not found");
        }
    }

    @ReactMethod
    public void readRSSI(String str, Callback callback) {
        Log.d(LOG_TAG, "Read RSSI from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.readRSSI(callback);
        } else {
            callback.invoke("Peripheral not found", null);
        }
    }

    private Peripheral savePeripheral(BluetoothDevice bluetoothDevice) {
        Peripheral peripheral;
        String address = bluetoothDevice.getAddress();
        synchronized (this.peripherals) {
            if (!this.peripherals.containsKey(address)) {
                if (!this.forceLegacy) {
                    peripheral = new DefaultPeripheral(bluetoothDevice, this.reactContext);
                } else {
                    peripheral = new Peripheral(bluetoothDevice, this.reactContext);
                }
                this.peripherals.put(bluetoothDevice.getAddress(), peripheral);
            }
        }
        return this.peripherals.get(address);
    }

    public Peripheral getPeripheral(BluetoothDevice bluetoothDevice) {
        return this.peripherals.get(bluetoothDevice.getAddress());
    }

    public Peripheral savePeripheral(Peripheral peripheral) {
        synchronized (this.peripherals) {
            this.peripherals.put(peripheral.getDevice().getAddress(), peripheral);
        }
        return peripheral;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    @ReactMethod
    public void checkState(Callback callback) {
        String str;
        Log.d(LOG_TAG, "checkState");
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        if (!this.context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            str = "unsupported";
        } else if (bluetoothAdapter == null) {
            str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        } else {
            switch (bluetoothAdapter.getState()) {
                case 11:
                    str = "turning_on";
                    break;
                case 12:
                    str = "on";
                    break;
                case 13:
                    str = "turning_off";
                    break;
                default:
                    str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                    break;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("state", str);
        Log.d(LOG_TAG, "state:".concat(str));
        sendEvent("BleManagerDidUpdateState", writableMapCreateMap);
        callback.invoke(str);
    }

    @ReactMethod
    public void isScanning(Callback callback) {
        ScanManager scanManager = this.scanManager;
        if (scanManager != null) {
            callback.invoke(null, Boolean.valueOf(scanManager.isScanning()));
        } else {
            callback.invoke(null, false);
        }
    }

    @ReactMethod
    public void setName(String str) {
        getBluetoothAdapter().setName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPeripherals() {
        if (this.peripherals.isEmpty()) {
            return;
        }
        synchronized (this.peripherals) {
            this.peripherals.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectPeripherals() {
        if (this.peripherals.isEmpty()) {
            return;
        }
        synchronized (this.peripherals) {
            for (Peripheral peripheral : this.peripherals.values()) {
                if (peripheral.isConnected()) {
                    peripheral.disconnect(null, true);
                }
            }
        }
    }

    @ReactMethod
    public void getDiscoveredPeripherals(Callback callback) {
        Log.d(LOG_TAG, "Get discovered peripherals");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        synchronized (this.peripherals) {
            Iterator<Map.Entry<String, Peripheral>> it2 = this.peripherals.entrySet().iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray.pushMap(it2.next().getValue().asWritableMap());
            }
        }
        callback.invoke(null, writableArrayCreateArray);
    }

    @ReactMethod
    public void getConnectedPeripherals(ReadableArray readableArray, Callback callback) {
        Log.d(LOG_TAG, "Get connected peripherals");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
        } else {
            Iterator<BluetoothDevice> it2 = getBluetoothManager().getConnectedDevices(7).iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray.pushMap(savePeripheral(it2.next()).asWritableMap());
            }
            callback.invoke(null, writableArrayCreateArray);
        }
    }

    @ReactMethod
    public void getBondedPeripherals(Callback callback) {
        Peripheral peripheral;
        Log.d(LOG_TAG, "Get bonded peripherals");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (BluetoothDevice bluetoothDevice : getBluetoothAdapter().getBondedDevices()) {
            if (!this.forceLegacy) {
                peripheral = new DefaultPeripheral(bluetoothDevice, this.reactContext);
            } else {
                peripheral = new Peripheral(bluetoothDevice, this.reactContext);
            }
            writableArrayCreateArray.pushMap(peripheral.asWritableMap());
        }
        callback.invoke(null, writableArrayCreateArray);
    }

    @ReactMethod
    public void removePeripheral(String str, Callback callback) {
        Log.d(LOG_TAG, "Removing from list: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            synchronized (this.peripherals) {
                if (peripheral.isConnected()) {
                    callback.invoke("Peripheral can not be removed while connected");
                } else {
                    this.peripherals.remove(str);
                    callback.invoke(new Object[0]);
                }
            }
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void requestConnectionPriority(String str, int i, Callback callback) {
        Log.d(LOG_TAG, "Request connection priority of " + i + " from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.requestConnectionPriority(i, callback);
        } else {
            callback.invoke("Peripheral not found", null);
        }
    }

    @ReactMethod
    public void requestMTU(String str, int i, Callback callback) {
        Log.d(LOG_TAG, "Request MTU of " + i + " bytes from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.requestMTU(i, callback);
        } else {
            callback.invoke("Peripheral not found", null);
        }
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static WritableArray bytesToWritableArray(byte[] bArr) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (byte b : bArr) {
            writableArrayCreateArray.pushInt(b & 255);
        }
        return writableArrayCreateArray;
    }

    private Peripheral retrieveOrCreatePeripheral(String str) {
        Peripheral peripheral;
        Peripheral peripheral2 = this.peripherals.get(str);
        if (peripheral2 == null) {
            synchronized (this.peripherals) {
                if (str != null) {
                    str = str.toUpperCase();
                }
                if (BluetoothAdapter.checkBluetoothAddress(str)) {
                    BluetoothDevice remoteDevice = this.bluetoothAdapter.getRemoteDevice(str);
                    if (!this.forceLegacy) {
                        peripheral = new DefaultPeripheral(remoteDevice, this.reactContext);
                    } else {
                        peripheral = new Peripheral(remoteDevice, this.reactContext);
                    }
                    this.peripherals.put(str, peripheral);
                    peripheral2 = peripheral;
                }
            }
        }
        return peripheral2;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        try {
            disconnectPeripherals();
        } catch (Exception e) {
            Log.d(LOG_TAG, "Could not disconnect peripherals", e);
        }
        ScanManager scanManager = this.scanManager;
        if (scanManager != null) {
            scanManager.stopScan(new Callback() { // from class: it.innove.BleManager$$ExternalSyntheticLambda0
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object[] objArr) {
                    BleManager.lambda$onCatalystInstanceDestroy$0(objArr);
                }
            });
        }
    }
}
