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
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
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

    private var charMedia: BluetoothGattCharacteristic? = null
    private var charControls: BluetoothGattCharacteristic? = null

    private val _connectionState = MutableStateFlow(BleConnectionState())
    val connectionState: StateFlow<BleConnectionState> = _connectionState.asStateFlow()

    var handlebarListener: ((PulsarProtocol.HandlebarEvent) -> Unit)? = null

    private val mainHandler = Handler(Looper.getMainLooper())
    private var isScanning = false
    private var autoReconnect = true

    private class GattWriteTask(
        val characteristic: BluetoothGattCharacteristic, val data: ByteArray
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
                mainHandler.postDelayed(this, 500L)
            }
        }
    }

    init {
        val manager = this.context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        manager?.let { this.bluetoothAdapter = it.adapter }
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

    fun startScanOrConnect() {
        val adapter = getAdapter()
        if (adapter == null || !adapter.isEnabled) {
            Log.e(TAG, "Bluetooth not available or disabled.")
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
        charMedia = null
        charControls = null
        synchronized(writeQueue) {
            writeQueue.clear()
            isWriting = false
        }
        _connectionState.value = BleConnectionState()
    }

    fun simulateConnection(connected: Boolean, deviceName: String = "PULSAR_N250") {
        Log.i(TAG, "simulateConnection: connected=$connected, name=$deviceName")
        _connectionState.value = if (connected) {
            BleConnectionState(
                isConnected = true,
                isConnecting = false,
                isBound = true,
                deviceName = deviceName,
                deviceAddress = TARGET_MAC
            )
        } else {
            BleConnectionState(
                isConnected = false,
                isConnecting = false,
                isBound = false,
                deviceName = "",
                deviceAddress = ""
            )
        }
    }

    fun simulateHandlebarEvent(event: PulsarProtocol.HandlebarEvent) {
        Log.i(TAG, "simulateHandlebarEvent: $event")
        mainHandler.post {
            handlebarListener?.invoke(event)
        }
    }

    fun sendMedia(
        title: String?, artist: String?, album: String?, posSec: Int, durSec: Int, state: Int
    ): Boolean {
        val targetChar = charMedia ?: return false
        if (!_connectionState.value.isConnected) return false
        val frame = PulsarProtocol.buildMediaFrame(title, artist, album, posSec, durSec, state)
        enqueueWrite(targetChar, frame)
        return true
    }

    private fun enqueueWrite(characteristic: BluetoothGattCharacteristic, data: ByteArray) {
        synchronized(writeQueue) {
            writeQueue.add(GattWriteTask(characteristic, data))
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
                writeCharacteristicCompat(gatt, task.characteristic, task.data)
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
        gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, data: ByteArray
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
                    characteristic, data, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
                )
                status == BluetoothStatusCodes.SUCCESS
            } else {
                characteristic.value = data
                characteristic.writeType = BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
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
                    charMedia = service.getCharacteristic(CHAR_MEDIA_UUID)
                    charControls = service.getCharacteristic(CHAR_CONTROLS_UUID)

                    Log.i(
                        TAG,
                        "Characteristics bound: Media=${charMedia != null}, Controls=${charControls != null}"
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
                        Log.i(TAG, "Starting periodic 500ms Handlebar Controls poller (0a10)...")
                        mainHandler.postDelayed(controlsPollRunnable, 500L)
                    }

                    val isBound = charMedia != null
                    _connectionState.value = _connectionState.value.copy(isBound = isBound)
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
        disconnect()
        mainHandler.removeCallbacksAndMessages(null)
    }

    companion object {
        private const val TAG = "PulsarBleManager"
        private const val TARGET_MAC = "C0:63:80:2D:0C:42"

        val SERVICE_UUID: UUID = UUID.fromString(PulsarProtocol.SERVICE_UUID)
        val CHAR_MEDIA_UUID: UUID = UUID.fromString(PulsarProtocol.CHAR_MEDIA_UUID)
        val CHAR_CONTROLS_UUID: UUID = UUID.fromString(PulsarProtocol.CHAR_CONTROLS_UUID)
        val CCCD_UUID: UUID = UUID.fromString(PulsarProtocol.CCCD_DESCRIPTOR_UUID)
    }
}
