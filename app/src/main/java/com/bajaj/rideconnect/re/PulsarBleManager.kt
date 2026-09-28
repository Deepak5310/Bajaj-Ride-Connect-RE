package com.bajaj.rideconnect.re

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.BluetoothStatusCodes
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.LinkedList
import java.util.Queue
import java.util.UUID

data class BleConnectionState(
    val isConnected: Boolean = false,
    val isConnecting: Boolean = false,
    val isBound: Boolean = false,
    val deviceName: String = "",
    val deviceAddress: String = ""
)

class PulsarBleManager(context: Context) {

    private val context: Context = context.applicationContext
    private var bluetoothAdapter: BluetoothAdapter? = null
    private var bluetoothGatt: BluetoothGatt? = null

    private var charTelemetry: BluetoothGattCharacteristic? = null
    private var charMedia: BluetoothGattCharacteristic? = null
    private var charControls: BluetoothGattCharacteristic? = null

    private val _connectionState = MutableStateFlow(BleConnectionState())
    val connectionState: StateFlow<BleConnectionState> = _connectionState.asStateFlow()

    var handlebarListener: ((PulsarProtocol.HandlebarEvent) -> Unit)? = null
    var onConnectedListener: (() -> Unit)? = null

    private val mainHandler = Handler(Looper.getMainLooper())
    private var isScanning = false
    private var autoReconnect = true
    private var telemetrySeq: Byte = 0

    private val bluetoothStateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == BluetoothAdapter.ACTION_STATE_CHANGED) {
                val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
                when (state) {
                    BluetoothAdapter.STATE_ON -> {
                        Log.i(TAG, "Bluetooth turned ON. Triggering auto-scan/connect...")
                        startScanOrConnect()
                    }

                    BluetoothAdapter.STATE_TURNING_OFF, BluetoothAdapter.STATE_OFF -> {
                        Log.i(TAG, "Bluetooth turned OFF. Resetting connection state...")
                        stopScan()
                        disconnect()
                        _connectionState.value = BleConnectionState()
                    }
                }
            }
        }
    }

    private class GattWriteTask(
        val characteristic: BluetoothGattCharacteristic,
        val data: ByteArray,
        val writeType: Int = BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
    )

    private val writeQueue: Queue<GattWriteTask> = LinkedList()
    private var isWriting = false
    private var currentTask: GattWriteTask? = null

    private val reconnectRunnable = Runnable {
        if (!_connectionState.value.isConnected && autoReconnect) {
            Log.i(TAG, "Triggering automatic cluster reconnect...")
            startScanOrConnect()
        }
    }

    private val controlsPollRunnable: Runnable = object : Runnable {
        override fun run() {
            val isConn = _connectionState.value.isConnected
            val gatt = bluetoothGatt
            val controls = charControls
            if (isConn && gatt != null && controls != null) {
                if (hasConnectPermission()) {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S || ContextCompat.checkSelfPermission(
                            context, Manifest.permission.BLUETOOTH_CONNECT
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        synchronized(writeQueue) {
                            if (!isWriting) {
                                try {
                                    gatt.readCharacteristic(controls)
                                } catch (e: SecurityException) {
                                    Log.w(TAG, "SecurityException polling controls: ${e.message}")
                                } catch (e: Exception) {
                                    Log.w(TAG, "Error polling handlebar controls: ${e.message}")
                                }
                            }
                        }
                    }
                }
                mainHandler.postDelayed(this, 350L)
            }
        }
    }

    init {
        val manager = this.context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        manager?.let { this.bluetoothAdapter = it.adapter }
        val filter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        ContextCompat.registerReceiver(
            this.context, bluetoothStateReceiver, filter, ContextCompat.RECEIVER_EXPORTED
        )
    }

    fun hasConnectPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_CONNECT
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun hasScanPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_SCAN
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_ADMIN
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun getDeviceName(device: BluetoothDevice?): String? {
        device ?: return null
        if (!hasConnectPermission()) return null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return null
        }
        return try {
            device.name
        } catch (e: SecurityException) {
            Log.w(TAG, "SecurityException reading device name: ${e.message}")
            null
        }
    }

    private fun isMatchingCluster(name: String?, address: String?): Boolean {
        if (address.equals(TARGET_MAC, ignoreCase = true)) return true
        name ?: return false
        val upper = name.uppercase()
        return upper.contains("PULSAR") || upper.contains("NS400") || upper.contains("DOMINAR") || upper.contains(
            "BAJAJ"
        ) || upper.contains("OTC") || upper.contains("CLUSTER")
    }

    private fun getAdapter(): BluetoothAdapter? {
        if (bluetoothAdapter == null || bluetoothAdapter?.isEnabled != true) {
            val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
            manager?.let { this.bluetoothAdapter = it.adapter }
        }
        return bluetoothAdapter
    }

    fun isBluetoothEnabled(): Boolean {
        val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        val adapter = manager?.adapter ?: bluetoothAdapter
        return adapter != null && adapter.isEnabled
    }

    fun requestEnableBluetooth(callingContext: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                callingContext, Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            try {
                val settingsIntent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                callingContext.startActivity(settingsIntent)
            } catch (e: Exception) {
                Log.w(TAG, "Could not launch Bluetooth settings: ${e.message}")
            }
            return
        }

        try {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            callingContext.startActivity(enableBtIntent)
        } catch (_: Exception) {
            try {
                val settingsIntent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                callingContext.startActivity(settingsIntent)
            } catch (e: Exception) {
                Log.w(TAG, "Could not launch Bluetooth settings: ${e.message}")
            }
        }
    }

    fun startScanOrConnect() {
        autoReconnect = true
        val adapter = getAdapter()
        if (adapter == null || !adapter.isEnabled) {
            Log.e(TAG, "Bluetooth not available or disabled.")
            if (_connectionState.value.isConnecting || _connectionState.value.isConnected) {
                _connectionState.value = BleConnectionState()
            }
            return
        }

        if (!hasConnectPermission()) {
            Log.w(TAG, "BLUETOOTH_CONNECT permission not granted")
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        val paired = try {
            adapter.bondedDevices
        } catch (e: SecurityException) {
            Log.w(TAG, "SecurityException reading bonded devices: ${e.message}")
            null
        }

        if (paired != null) {
            for (dev in paired) {
                val name = getDeviceName(dev)
                if (isMatchingCluster(name, dev.address)) {
                    Log.i(TAG, "Connecting to paired NS400Z cluster: $name [${dev.address}]")
                    connect(dev.address, name)
                    return
                }
            }
        }

        if (!hasScanPermission()) {
            Log.w(TAG, "BLUETOOTH_SCAN permission not granted")
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        val scanner = adapter.bluetoothLeScanner
        if (scanner != null && !isScanning) {
            isScanning = true
            Log.i(TAG, "Starting BLE scan for NS400Z peripheral...")
            try {
                scanner.startScan(scanCallback)
            } catch (e: SecurityException) {
                Log.w(TAG, "SecurityException starting BLE scan: ${e.message}")
                isScanning = false
                return
            }
            mainHandler.postDelayed({ stopScan() }, 20000L)
        }
    }

    fun stopScan() {
        val adapter = getAdapter()
        if (isScanning && adapter != null) {
            if (!hasScanPermission()) {
                isScanning = false
                return
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                    context, Manifest.permission.BLUETOOTH_SCAN
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                isScanning = false
                return
            }
            val scanner = adapter.bluetoothLeScanner
            try {
                scanner?.stopScan(scanCallback)
            } catch (e: SecurityException) {
                Log.w(TAG, "SecurityException stopping BLE scan: ${e.message}")
            } catch (e: Exception) {
                Log.w(TAG, "Error stopping BLE scan: ${e.message}")
            }
            isScanning = false
        }
    }

    private val scanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            val device = result.device
            var name = getDeviceName(device)
            if (name.isNullOrEmpty() && result.scanRecord != null) {
                name = result.scanRecord?.deviceName
            }
            if (isMatchingCluster(name, device.address)) {
                Log.i(TAG, "Discovered Pulsar cluster in BLE scan: $name [${device.address}]")
                stopScan()
                connect(device.address, name)
            }
        }
    }

    fun connect(deviceAddress: String, deviceName: String? = null) {
        val adapter = getAdapter() ?: return
        val current = _connectionState.value
        if (current.isConnected || current.isConnecting) {
            Log.d(TAG, "Already connected or connecting. Skipping duplicate connect request.")
            return
        }

        if (!hasConnectPermission()) {
            Log.w(TAG, "BLUETOOTH_CONNECT permission not granted for connect()")
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        try {
            val device = adapter.getRemoteDevice(deviceAddress)
            val devName = getDeviceName(device)
            val finalName = when {
                !deviceName.isNullOrEmpty() -> deviceName
                !devName.isNullOrEmpty() -> devName
                else -> ""
            }

            _connectionState.value = BleConnectionState(
                isConnecting = true, deviceName = finalName, deviceAddress = deviceAddress
            )

            Log.i(TAG, "Initiating direct GATT connection to $deviceAddress ($finalName)")

            bluetoothGatt?.let {
                try {
                    it.disconnect()
                    it.close()
                } catch (e: SecurityException) {
                    Log.w(TAG, "SecurityException closing previous GATT: ${e.message}")
                } catch (_: Exception) {
                }
                bluetoothGatt = null
            }

            bluetoothGatt = connectGattCompat(device)
        } catch (e: SecurityException) {
            _connectionState.value = BleConnectionState()
            Log.e(TAG, "SecurityException connecting to GATT: ${e.message}")
        } catch (e: Exception) {
            _connectionState.value = BleConnectionState()
            Log.e(TAG, "Error connecting to GATT: ${e.message}")
        }
    }

    @Suppress("DEPRECATION")
    private fun connectGattCompat(device: BluetoothDevice): BluetoothGatt? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return null
        }
        return try {
            if (Build.VERSION.SDK_INT >= 37) {
                val settings = android.bluetooth.BluetoothGattConnectionSettings.Builder()
                    .setAutoConnectEnabled(false).setTransport(BluetoothDevice.TRANSPORT_LE).build()
                device.connectGatt(settings, ContextCompat.getMainExecutor(context), gattCallback)
            } else {
                device.connectGatt(
                    context,
                    false,
                    gattCallback,
                    BluetoothDevice.TRANSPORT_LE,
                    BluetoothDevice.PHY_LE_1M_MASK
                )
            }
        } catch (e: SecurityException) {
            Log.w(TAG, "SecurityException connecting GATT: ${e.message}")
            null
        }
    }

    fun disconnect() {
        autoReconnect = false
        mainHandler.removeCallbacks(reconnectRunnable)
        mainHandler.removeCallbacks(controlsPollRunnable)
        if (isScanning) {
            stopScan()
        }
        bluetoothGatt?.let {
            if (hasConnectPermission()) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S || ContextCompat.checkSelfPermission(
                        context, Manifest.permission.BLUETOOTH_CONNECT
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    try {
                        it.disconnect()
                        it.close()
                    } catch (e: SecurityException) {
                        Log.w(TAG, "SecurityException disconnecting GATT: ${e.message}")
                    } catch (_: Exception) {
                    }
                }
            }
            bluetoothGatt = null
        }
        charTelemetry = null
        charMedia = null
        charControls = null
        synchronized(writeQueue) {
            writeQueue.clear()
            isWriting = false
        }
        _connectionState.value = BleConnectionState()
    }

    fun sendTelemetry(
        batteryPercent: Int,
        signalBars: Int,
        callState: Int = 0,
        callerNameOrNumber: String? = null,
        missedCalls: Int = 0,
        unreadSms: Int = 0,
        volumeLevel: Int = 5,
        isHeadset: Boolean = false
    ): Boolean {
        val targetChar = charTelemetry ?: return false
        if (!_connectionState.value.isConnected) return false
        telemetrySeq++
        val frame = PulsarProtocol.buildCompactTelemetryFrame(
            batteryPercent = batteryPercent,
            signalBars = signalBars,
            callState = callState,
            callerNameOrNumber = callerNameOrNumber,
            missedCalls = missedCalls,
            unreadSms = unreadSms,
            seqCounter = telemetrySeq,
            volumeLevel = volumeLevel,
            isHeadset = isHeadset
        )
        enqueueWrite(targetChar, frame, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT)
        return true
    }

    fun sendMedia(
        title: String?, artist: String?, album: String?, posSec: Int, durSec: Int, state: Int
    ): Boolean {
        val targetChar = charMedia ?: return false
        if (!_connectionState.value.isConnected) return false
        val frame = PulsarProtocol.buildMediaFrame(title, artist, album, posSec, durSec, state)
        enqueueWrite(targetChar, frame, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE)
        return true
    }

    private fun enqueueWrite(
        characteristic: BluetoothGattCharacteristic,
        data: ByteArray,
        writeType: Int = BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
    ) {
        synchronized(writeQueue) {
            writeQueue.add(GattWriteTask(characteristic, data, writeType))
            if (!isWriting) {
                processNextWrite()
            }
        }
    }

    private fun processNextWrite() {
        synchronized(writeQueue) {
            val gatt = bluetoothGatt
            if (writeQueue.isEmpty() || gatt == null) {
                isWriting = false
                return
            }

            if (!hasConnectPermission()) {
                isWriting = false
                return
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                    context, Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                isWriting = false
                return
            }

            val task = writeQueue.poll() ?: run {
                isWriting = false
                return
            }

            isWriting = true
            currentTask = task

            val result = try {
                writeCharacteristicCompat(gatt, task.characteristic, task.data, task.writeType)
            } catch (e: SecurityException) {
                Log.w(TAG, "SecurityException writing characteristic: ${e.message}")
                false
            } catch (e: Exception) {
                Log.w(TAG, "Error writing characteristic: ${e.message}")
                false
            }

            if (!result) {
                isWriting = false
                currentTask = null
                mainHandler.post { processNextWrite() }
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun writeCharacteristicCompat(
        gatt: BluetoothGatt,
        characteristic: BluetoothGattCharacteristic,
        data: ByteArray,
        writeType: Int
    ): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return false
        }
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val status = gatt.writeCharacteristic(
                    characteristic, data, writeType
                )
                status == BluetoothStatusCodes.SUCCESS
            } else {
                characteristic.value = data
                characteristic.writeType = writeType
                gatt.writeCharacteristic(characteristic)
            }
        } catch (e: SecurityException) {
            Log.w(TAG, "SecurityException writing characteristic: ${e.message}")
            false
        }
    }

    @Suppress("DEPRECATION")
    private fun writeDescriptorCompat(
        gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, value: ByteArray
    ): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return false
        }
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val status = gatt.writeDescriptor(descriptor, value)
                status == BluetoothStatusCodes.SUCCESS
            } else {
                descriptor.value = value
                gatt.writeDescriptor(descriptor)
            }
        } catch (e: SecurityException) {
            Log.w(TAG, "SecurityException writing descriptor: ${e.message}")
            false
        }
    }

    private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            Log.i(TAG, "onConnectionStateChange: status=$status, newState=$newState")

            if (newState == BluetoothProfile.STATE_CONNECTED && status == BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "Connected to NS400Z GATT Server. Negotiating MTU 247...")
                mainHandler.removeCallbacks(reconnectRunnable)

                val devName = getDeviceName(gatt.device) ?: _connectionState.value.deviceName
                _connectionState.value = BleConnectionState(
                    isConnected = true,
                    isConnecting = false,
                    isBound = false,
                    deviceName = devName,
                    deviceAddress = gatt.device.address
                )

                if (hasConnectPermission()) {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S || ContextCompat.checkSelfPermission(
                            context, Manifest.permission.BLUETOOTH_CONNECT
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        try {
                            if (!gatt.requestMtu(247)) {
                                Log.i(TAG, "MTU request declined; discovering services directly...")
                                gatt.discoverServices()
                            }
                        } catch (e: SecurityException) {
                            Log.w(TAG, "SecurityException requesting MTU: ${e.message}")
                        }
                    }
                }
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED || status != BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "Disconnected from NS400Z (status=$status).")
                mainHandler.removeCallbacks(controlsPollRunnable)
                charMedia = null
                charControls = null

                bluetoothGatt?.let {
                    if (hasConnectPermission()) {
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S || ContextCompat.checkSelfPermission(
                                context, Manifest.permission.BLUETOOTH_CONNECT
                            ) == PackageManager.PERMISSION_GRANTED
                        ) {
                            try {
                                it.close()
                            } catch (e: SecurityException) {
                                Log.w(TAG, "SecurityException closing GATT: ${e.message}")
                            } catch (_: Exception) {
                            }
                        }
                    }
                    bluetoothGatt = null
                }

                _connectionState.value = BleConnectionState()
                PulsarProtocol.resetHandlebarCounters()

                if (autoReconnect) {
                    mainHandler.removeCallbacks(reconnectRunnable)
                    mainHandler.postDelayed(reconnectRunnable, 3500L)
                }
            }
        }

        override fun onMtuChanged(gatt: BluetoothGatt, mtu: Int, status: Int) {
            Log.i(TAG, "onMtuChanged: mtu=$mtu, status=$status -> Discovering services...")
            if (hasConnectPermission()) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S || ContextCompat.checkSelfPermission(
                        context, Manifest.permission.BLUETOOTH_CONNECT
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    try {
                        gatt.discoverServices()
                    } catch (e: SecurityException) {
                        Log.w(TAG, "SecurityException discovering services: ${e.message}")
                    }
                }
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                if (!hasConnectPermission()) return
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && ContextCompat.checkSelfPermission(
                        context, Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
                Log.i(TAG, "GATT Services discovered for ${_connectionState.value.deviceName}")

                val service = gatt.getService(SERVICE_UUID)
                if (service != null) {
                    charTelemetry = service.getCharacteristic(CHAR_TELEMETRY_UUID)
                    charMedia = service.getCharacteristic(CHAR_MEDIA_UUID)
                    charControls = service.getCharacteristic(CHAR_CONTROLS_UUID)

                    Log.i(
                        TAG,
                        "Characteristics bound: Telemetry=${charTelemetry != null}, Media=${charMedia != null}, Controls=${charControls != null}"
                    )

                    for (c in service.characteristics) {
                        val props = c.properties
                        val hasNotify =
                            (props and (BluetoothGattCharacteristic.PROPERTY_NOTIFY or BluetoothGattCharacteristic.PROPERTY_INDICATE)) != 0
                        val cccd = c.getDescriptor(CCCD_UUID)
                        if (hasNotify || cccd != null || CHAR_CONTROLS_UUID == c.uuid) {
                            try {
                                gatt.setCharacteristicNotification(c, true)
                                if (cccd != null) {
                                    val value =
                                        if ((props and BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0) {
                                            BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
                                        } else {
                                            BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                                        }
                                    writeDescriptorCompat(gatt, cccd, value)
                                    Log.i(TAG, "Writing CCCD subscription for ${c.uuid}")
                                }
                            } catch (e: SecurityException) {
                                Log.w(TAG, "SecurityException setting notification: ${e.message}")
                            }
                        }
                    }

                    mainHandler.removeCallbacks(controlsPollRunnable)
                    if (charControls != null) {
                        Log.i(TAG, "Starting periodic 350ms Handlebar Controls poller (0a10)...")
                        mainHandler.postDelayed(controlsPollRunnable, 350L)
                    }

                    val isBound = charMedia != null && charTelemetry != null
                    _connectionState.value = _connectionState.value.copy(isBound = isBound)
                    mainHandler.post { onConnectedListener?.invoke() }
                } else {
                    Log.e(TAG, "Primary Service $SERVICE_UUID not found!")
                }
            }
        }

        override fun onDescriptorWrite(
            gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int
        ) {
            Log.i(TAG, "onDescriptorWrite: ${descriptor.uuid} | status=$status")
        }

        override fun onCharacteristicRead(
            gatt: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic,
            value: ByteArray,
            status: Int
        ) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                handleCharacteristicData(characteristic, value)
            }
        }

        @Deprecated("Deprecated in Java")
        @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
        override fun onCharacteristicRead(
            gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int
        ) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && status == BluetoothGatt.GATT_SUCCESS) {
                characteristic.value?.let { handleCharacteristicData(characteristic, it) }
            }
        }

        override fun onCharacteristicWrite(
            gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int
        ) {
            synchronized(writeQueue) {
                isWriting = false
                currentTask = null
                processNextWrite()
            }
        }

        override fun onCharacteristicChanged(
            gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray
        ) {
            handleCharacteristicData(characteristic, value)
        }

        @Deprecated("Deprecated in Java")
        @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
        override fun onCharacteristicChanged(
            gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic
        ) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                characteristic.value?.let { handleCharacteristicData(characteristic, it) }
            }
        }

        private fun handleCharacteristicData(
            characteristic: BluetoothGattCharacteristic?, value: ByteArray?
        ) {
            if (characteristic == null || value == null) return

            if (CHAR_CONTROLS_UUID == characteristic.uuid) {
                val event = PulsarProtocol.parseHandlebarPacket(value)
                if (event != null && event.hasAction()) {
                    Log.i(TAG, ">>> [HANDLEBAR ACTION] $event")
                    mainHandler.post {
                        handlebarListener?.invoke(event)
                    }
                }
            }
        }
    }

    fun destroy() {
        try {
            context.unregisterReceiver(bluetoothStateReceiver)
        } catch (_: Exception) {
        }
        disconnect()
        mainHandler.removeCallbacksAndMessages(null)
    }

    companion object {
        private const val TAG = "PulsarBleManager"
        private const val TARGET_MAC = "C0:63:80:2D:0C:42"

        val SERVICE_UUID: UUID = UUID.fromString(PulsarProtocol.SERVICE_UUID)
        val CHAR_TELEMETRY_UUID: UUID = UUID.fromString(PulsarProtocol.CHAR_TELEMETRY_UUID)
        val CHAR_MEDIA_UUID: UUID = UUID.fromString(PulsarProtocol.CHAR_MEDIA_UUID)
        val CHAR_CONTROLS_UUID: UUID = UUID.fromString(PulsarProtocol.CHAR_CONTROLS_UUID)
        val CCCD_UUID: UUID = UUID.fromString(PulsarProtocol.CCCD_DESCRIPTOR_UUID)
    }
}