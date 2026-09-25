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
import java.util.LinkedList
import java.util.Queue
import java.util.UUID
import java.util.concurrent.CopyOnWriteArrayList

class PulsarBleManager private constructor(context: Context) {

    interface BleListener {
        fun onConnectionStateChanged(connected: Boolean, deviceName: String, deviceAddress: String)
        fun onPacketSent(charUuid: String, frame: ByteArray?, success: Boolean)
        fun onHandlebarEvent(event: PulsarProtocol.HandlebarEvent)
    }

    private val context: Context = context.applicationContext
    private var bluetoothAdapter: BluetoothAdapter? = null
    private var bluetoothGatt: BluetoothGatt? = null

    private var charTelemetry: BluetoothGattCharacteristic? = null
    private var charMedia: BluetoothGattCharacteristic? = null
    private var charControls: BluetoothGattCharacteristic? = null

    var isConnected: Boolean = false
        private set
    var isConnecting: Boolean = false
        private set

    var connectedDeviceName: String = ""
        private set
    var connectedDeviceAddress: String = ""
        private set

    private val listeners = CopyOnWriteArrayList<BleListener>()
    private val mainHandler = Handler(Looper.getMainLooper())
    private var isScanning = false
    private var autoReconnect = true
    private var telemetrySeq: Byte = 0

    private class GattWriteTask(
        val characteristic: BluetoothGattCharacteristic,
        val data: ByteArray,
        val writeType: Int
    )

    private val writeQueue: Queue<GattWriteTask> = LinkedList()
    private var isWriting = false
    private var currentTask: GattWriteTask? = null

    private val reconnectRunnable = Runnable {
        if (!isConnected && autoReconnect) {
            Log.i(TAG, "Triggering automatic cluster reconnect...")
            startScanOrConnect()
        }
    }

    private val controlsPollRunnable: Runnable = object : Runnable {
        override fun run() {
            if (isConnected && bluetoothGatt != null && charControls != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                    context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
                synchronized(writeQueue) {
                    if (!isWriting) {
                        try {
                            bluetoothGatt?.readCharacteristic(charControls)
                        } catch (e: Exception) {
                            Log.w(TAG, "Error polling handlebar controls: ${e.message}")
                        }
                    }
                }
                mainHandler.postDelayed(this, 500)
            }
        }
    }

    init {
        val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        manager?.let { this.bluetoothAdapter = it.adapter }
    }

    fun addListener(listener: BleListener?) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener)
            listener.onConnectionStateChanged(isConnected, connectedDeviceName, connectedDeviceAddress)
        }
    }

    fun removeListener(listener: BleListener?) {
        listeners.remove(listener)
    }

    private fun notifyConnectionState(connected: Boolean, name: String, addr: String) {
        mainHandler.post {
            for (l in listeners) {
                l.onConnectionStateChanged(connected, name, addr)
            }
        }
    }

    private fun notifyPacketSent(charUuid: String, frame: ByteArray?, success: Boolean) {
        mainHandler.post {
            for (l in listeners) {
                l.onPacketSent(charUuid, frame, success)
            }
        }
    }

    private fun notifyHandlebarEvent(event: PulsarProtocol.HandlebarEvent) {
        mainHandler.post {
            for (l in listeners) {
                l.onHandlebarEvent(event)
            }
        }
    }

    fun isBound(): Boolean = isConnected && charTelemetry != null

    fun setAutoReconnect(enabled: Boolean) {
        this.autoReconnect = enabled
        if (!enabled) {
            mainHandler.removeCallbacks(reconnectRunnable)
        }
    }

    private fun isMatchingClusterName(name: String?): Boolean {
        name ?: return false
        val upper = name.uppercase()
        return upper.contains("PULSAR") ||
            upper.contains("NS400") ||
            upper.contains("BAJAJ") ||
            upper.contains("OTC") ||
            upper.contains("CLUSTER") ||
            upper.contains("DOMINAR") ||
            upper.contains("CHETAK")
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.w(TAG, "BLUETOOTH_CONNECT permission not granted")
            return
        }

        val paired = adapter.bondedDevices
        if (paired != null) {
            for (dev in paired) {
                val name = dev.name
                if (isMatchingClusterName(name)) {
                    Log.i(TAG, "Connecting to paired NS400Z cluster: $name [${dev.address}]")
                    connect(dev.address, name)
                    return
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            context.checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.w(TAG, "BLUETOOTH_SCAN permission not granted")
            return
        }

        val scanner = adapter.bluetoothLeScanner
        if (scanner != null && !isScanning) {
            isScanning = true
            Log.i(TAG, "Starting BLE scan for NS400Z peripheral...")
            scanner.startScan(scanCallback)
            mainHandler.postDelayed({ stopScan() }, 20000)
        }
    }

    fun stopScan() {
        val adapter = getAdapter()
        if (isScanning && adapter != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                context.checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED
            ) {
                isScanning = false
                return
            }
            val scanner = adapter.bluetoothLeScanner
            scanner?.stopScan(scanCallback)
            isScanning = false
        }
    }

    private val scanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            val device = result.device
            var name: String? = null
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
            ) {
                name = device.name
            }
            if (name.isNullOrEmpty() && result.scanRecord != null) {
                name = result.scanRecord?.deviceName
            }
            if (isMatchingClusterName(name)) {
                Log.i(TAG, "Discovered Pulsar cluster in BLE scan: $name [${device.address}]")
                stopScan()
                connect(device.address, name)
            }
        }
    }

    @JvmOverloads
    fun connect(deviceAddress: String?, deviceName: String? = null) {
        val adapter = getAdapter()
        if (adapter == null || deviceAddress == null) return
        if (isConnected || isConnecting) {
            Log.d(TAG, "Already connected or connecting. Skipping duplicate connect request.")
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.w(TAG, "BLUETOOTH_CONNECT permission not granted for connect()")
            return
        }

        try {
            isConnecting = true
            val device = adapter.getRemoteDevice(deviceAddress)
            val devName = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
            ) {
                device.name
            } else null
            connectedDeviceName = when {
                !deviceName.isNullOrEmpty() -> deviceName
                !devName.isNullOrEmpty() -> devName
                else -> ""
            }
            connectedDeviceAddress = deviceAddress
            Log.i(TAG, "Initiating direct GATT connection to $deviceAddress" + if (connectedDeviceName.isEmpty()) "" else " ($connectedDeviceName)")

            bluetoothGatt?.let {
                try {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                        context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
                    ) {
                        it.disconnect()
                        it.close()
                    }
                } catch (ignored: Exception) {}
                bluetoothGatt = null
            }

            bluetoothGatt = device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE)
        } catch (e: Exception) {
            isConnecting = false
            Log.e(TAG, "Error connecting to GATT: ${e.message}")
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
            try {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                    context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
                ) {
                    it.disconnect()
                    it.close()
                }
            } catch (ignored: Exception) {}
            bluetoothGatt = null
        }
        isConnected = false
        isConnecting = false
        charTelemetry = null
        charMedia = null
        charControls = null
        connectedDeviceName = ""
        connectedDeviceAddress = ""
        synchronized(writeQueue) {
            writeQueue.clear()
            isWriting = false
        }
        notifyConnectionState(false, "", "")
    }

    @JvmOverloads
    fun sendTelemetry(
        batteryPercent: Int,
        signalBars: Int,
        callState: Int,
        callerNameOrNumber: String?,
        missedCalls: Int,
        unreadSms: Int,
        volumeLevel: Int = 5,
        isHeadset: Boolean = false
    ): Boolean {
        val targetChar = charTelemetry ?: return false
        if (!isConnected) return false
        telemetrySeq++
        val frame = PulsarProtocol.buildCompactTelemetryFrame(
            batteryPercent,
            signalBars,
            callState,
            callerNameOrNumber,
            missedCalls,
            unreadSms,
            telemetrySeq,
            volumeLevel,
            isHeadset
        )
        enqueueWrite(targetChar, frame, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT)
        return true
    }

    fun sendMedia(
        title: String?,
        artist: String?,
        album: String?,
        posSec: Int,
        durSec: Int,
        state: Int
    ): Boolean {
        val targetChar = charMedia ?: return false
        if (!isConnected) return false
        val frame = PulsarProtocol.buildMediaFrame(title, artist, album, posSec, durSec, state)
        enqueueWrite(targetChar, frame, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE)
        return true
    }

    private fun enqueueWrite(characteristic: BluetoothGattCharacteristic, data: ByteArray, writeType: Int) {
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

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED
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

            val result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val status = gatt.writeCharacteristic(task.characteristic, task.data, task.writeType)
                status == BluetoothStatusCodes.SUCCESS
            } else {
                task.characteristic.value = task.data
                task.characteristic.writeType = task.writeType
                gatt.writeCharacteristic(task.characteristic)
            }

            if (task.writeType == BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE || !result) {
                isWriting = false
                currentTask = null
                notifyPacketSent(task.characteristic.uuid.toString(), task.data, result)
                mainHandler.post { processNextWrite() }
            }
        }
    }

    private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            Log.i(TAG, "onConnectionStateChange: status=$status, newState=$newState")
            isConnecting = false

            if (newState == BluetoothProfile.STATE_CONNECTED && status == BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "Connected to NS400Z GATT Server. Negotiating MTU 247...")
                isConnected = true
                mainHandler.removeCallbacks(reconnectRunnable)
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                    context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
                ) {
                    gatt.device?.let { dev ->
                        val gattName = dev.name
                        if (!gattName.isNullOrEmpty()) {
                            connectedDeviceName = gattName
                        }
                    }
                }
                notifyConnectionState(true, connectedDeviceName, connectedDeviceAddress)

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                    context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
                ) {
                    if (!gatt.requestMtu(247)) {
                        Log.i(TAG, "MTU request declined; discovering services directly...")
                        gatt.discoverServices()
                    }
                }
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED || status != BluetoothGatt.GATT_SUCCESS) {
                Log.i(TAG, "Disconnected from NS400Z (status=$status).")
                isConnected = false
                mainHandler.removeCallbacks(controlsPollRunnable)
                charTelemetry = null
                charMedia = null
                charControls = null

                bluetoothGatt?.let {
                    try {
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                            context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
                        ) {
                            it.close()
                        }
                    } catch (ignored: Exception) {}
                    bluetoothGatt = null
                }

                connectedDeviceName = ""
                connectedDeviceAddress = ""
                notifyConnectionState(false, "", "")
                PulsarProtocol.resetHandlebarCounters()

                if (autoReconnect) {
                    mainHandler.removeCallbacks(reconnectRunnable)
                    mainHandler.postDelayed(reconnectRunnable, 3500)
                }
            }
        }

        override fun onMtuChanged(gatt: BluetoothGatt, mtu: Int, status: Int) {
            Log.i(TAG, "onMtuChanged: mtu=$mtu, status=$status -> Discovering services...")
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
            ) {
                gatt.discoverServices()
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                    context.checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
                Log.i(TAG, "GATT Services discovered for $connectedDeviceName")
                val services = gatt.services
                if (services != null) {
                    for (s in services) {
                        Log.i(TAG, "[SERVICE] ${s.uuid}")
                        for (c in s.characteristics) {
                            Log.i(TAG, "  └── [CHAR] ${c.uuid} (props=0x${Integer.toHexString(c.properties)})")
                            for (d in c.descriptors) {
                                Log.i(TAG, "      └── [DESC] ${d.uuid}")
                            }
                        }
                    }
                }

                val service = gatt.getService(SERVICE_UUID)
                if (service != null) {
                    charTelemetry = service.getCharacteristic(CHAR_TELEMETRY_UUID)
                    charMedia = service.getCharacteristic(CHAR_MEDIA_UUID)
                    charControls = service.getCharacteristic(CHAR_CONTROLS_UUID)

                    Log.i(
                        TAG,
                        "GATT Characteristics bound: Telemetry=" + (charTelemetry != null) +
                            ", Media=" + (charMedia != null) +
                            ", Controls=" + (charControls != null)
                    )

                    for (c in service.characteristics) {
                        val props = c.properties
                        val hasNotify = (props and (BluetoothGattCharacteristic.PROPERTY_NOTIFY or BluetoothGattCharacteristic.PROPERTY_INDICATE)) != 0
                        val cccd = c.getDescriptor(CCCD_UUID)
                        if (hasNotify || cccd != null || CHAR_CONTROLS_UUID == c.uuid) {
                            gatt.setCharacteristicNotification(c, true)
                            if (cccd != null) {
                                val value = if ((props and BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0) {
                                    BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
                                } else {
                                    BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                                }
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                    gatt.writeDescriptor(cccd, value)
                                } else {
                                    cccd.value = value
                                    gatt.writeDescriptor(cccd)
                                }
                                Log.i(TAG, "Writing CCCD subscription for ${c.uuid}")
                            }
                        }
                    }

                    mainHandler.removeCallbacks(controlsPollRunnable)
                    if (charControls != null) {
                        Log.i(TAG, "Starting periodic 500ms Handlebar Controls poller (0a10)...")
                        mainHandler.postDelayed(controlsPollRunnable, 500)
                    }

                    notifyConnectionState(isConnected && charTelemetry != null, connectedDeviceName, connectedDeviceAddress)
                } else {
                    Log.e(TAG, "Primary Service $SERVICE_UUID not found!")
                }
            }
        }

        override fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
            Log.i(TAG, "onDescriptorWrite: ${descriptor.uuid} | status=$status")
        }

        @Deprecated("Deprecated in Java")
        override fun onCharacteristicRead(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                characteristic.value?.let { handleCharacteristicData(characteristic, it) }
            }
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

        override fun onCharacteristicWrite(
            gatt: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic,
            status: Int
        ) {
            synchronized(writeQueue) {
                isWriting = false
                val data = currentTask?.data
                currentTask = null
                Log.d(TAG, "Write completed: ${characteristic.uuid} | status=$status | len=${data?.size ?: 0}")
                notifyPacketSent(characteristic.uuid.toString(), data, status == BluetoothGatt.GATT_SUCCESS)
                processNextWrite()
            }
        }

        @Deprecated("Deprecated in Java")
        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
            characteristic.value?.let { handleCharacteristicData(characteristic, it) }
        }

        override fun onCharacteristicChanged(
            gatt: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic,
            value: ByteArray
        ) {
            handleCharacteristicData(characteristic, value)
        }

        private fun handleCharacteristicData(characteristic: BluetoothGattCharacteristic?, value: ByteArray?) {
            if (characteristic == null || value == null) return
            val hex = PulsarProtocol.bytesToHex(value)

            if (CHAR_CONTROLS_UUID == characteristic.uuid) {
                val event = PulsarProtocol.parseHandlebarPacket(value)
                if (event != null && event.hasAction()) {
                    Log.i(TAG, ">>> [HANDLEBAR ACTION] $event | Raw: $hex")
                    notifyHandlebarEvent(event)
                }
            } else {
                Log.i(TAG, ">>> RECV [${characteristic.uuid}] (${value.size}B): $hex")
            }
        }
    }

    companion object {
        private const val TAG = "PulsarBleManager"

        @JvmField val SERVICE_UUID: UUID = UUID.fromString(PulsarProtocol.SERVICE_UUID)
        @JvmField val CHAR_TELEMETRY_UUID: UUID = UUID.fromString(PulsarProtocol.CHAR_TELEMETRY_UUID)
        @JvmField val CHAR_MEDIA_UUID: UUID = UUID.fromString(PulsarProtocol.CHAR_MEDIA_UUID)
        @JvmField val CHAR_CONTROLS_UUID: UUID = UUID.fromString(PulsarProtocol.CHAR_CONTROLS_UUID)
        @JvmField val CCCD_UUID: UUID = UUID.fromString(PulsarProtocol.CCCD_DESCRIPTOR_UUID)

        @Volatile
        private var instance: PulsarBleManager? = null

        @JvmStatic
        fun getInstance(context: Context): PulsarBleManager {
            return instance ?: synchronized(this) {
                instance ?: PulsarBleManager(context).also { instance = it }
            }
        }
    }
}
