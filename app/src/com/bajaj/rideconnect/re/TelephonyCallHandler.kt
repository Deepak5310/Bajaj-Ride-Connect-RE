package com.bajaj.rideconnect.re

import android.Manifest
import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioManager
import android.net.Uri
import android.os.Build
import android.provider.ContactsContract
import android.telecom.TelecomManager
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import android.view.KeyEvent

class TelephonyCallHandler(
    context: Context,
    private val bleManager: PulsarBleManager
) {

    private val context: Context = context.applicationContext
    private val telephonyManager: TelephonyManager? =
        this.context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager

    var currentCallState: Int = 0
        private set
    var activeCaller: String = ""
        private set

    init {
        registerCallListener()
    }

    @TargetApi(Build.VERSION_CODES.S)
    private class CallStateCallback(
        private val handler: TelephonyCallHandler
    ) : TelephonyCallback(), TelephonyCallback.CallStateListener {
        override fun onCallStateChanged(state: Int) {
            handler.handleStateChanged(state, null)
        }
    }

    private fun registerCallListener() {
        val tm = telephonyManager ?: return
        if (context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            Log.w(TAG, "READ_PHONE_STATE permission not granted for call listener")
            return
        }

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                tm.registerTelephonyCallback(
                    context.mainExecutor,
                    CallStateCallback(this)
                )
            } else {
                tm.listen(object : PhoneStateListener() {
                    @Deprecated("Deprecated in Java")
                    override fun onCallStateChanged(state: Int, phoneNumber: String?) {
                        handleStateChanged(state, phoneNumber)
                    }
                }, PhoneStateListener.LISTEN_CALL_STATE)
            }
        } catch (e: SecurityException) {
            Log.w(TAG, "READ_PHONE_STATE permission needed for Call handler: ${e.message}")
        }
    }

    fun handleStateChanged(state: Int, incomingNumber: String?) {
        this.currentCallState = state
        when (state) {
            TelephonyManager.CALL_STATE_RINGING -> {
                val name = resolveContactName(incomingNumber)
                this.activeCaller = name ?: (incomingNumber ?: "INCOMING CALL")
                Log.i(TAG, "Incoming Call: $activeCaller -> Pushing to Cluster LCD")
                pushCallTelemetry(1, activeCaller)
            }
            TelephonyManager.CALL_STATE_OFFHOOK -> {
                Log.i(TAG, "Call in progress (Offhook)")
                pushCallTelemetry(3, activeCaller)
            }
            else -> {
                Log.i(TAG, "Call Idle / Ended")
                this.activeCaller = ""
                pushCallTelemetry(0, "")
            }
        }
    }

    private fun pushCallTelemetry(callState: Int, caller: String) {
        var battery = 85
        var signal = 4
        val mon = PhoneStateMonitor.instance
        if (mon != null) {
            if (mon.batteryPercent >= 0) battery = mon.batteryPercent
            if (mon.signalBars >= 0) signal = mon.signalBars
        }
        val media = MediaStateListener.instance
        val vol = media?.getCurrentVolumeTenths() ?: 5
        bleManager.sendTelemetry(battery, signal, callState, caller, 0, 0, vol, false)
    }

    fun handleHandlebarCallAction(ev: PulsarProtocol.HandlebarEvent?) {
        ev ?: return

        try {
            val tm = context.getSystemService(Context.TELECOM_SERVICE) as? TelecomManager

            if (ev.callAccept && currentCallState == TelephonyManager.CALL_STATE_RINGING) {
                Log.i(TAG, "Handlebar: Answering Incoming Phone Call (TelecomManager + KeyEvent fallback)")
                var answered = false
                if (tm != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    try {
                        if (context.checkSelfPermission(Manifest.permission.ANSWER_PHONE_CALLS) == PackageManager.PERMISSION_GRANTED) {
                            tm.acceptRingingCall()
                            answered = true
                            Log.i(TAG, "Answered via TelecomManager.acceptRingingCall()")
                        }
                    } catch (se: SecurityException) {
                        Log.w(TAG, "ANSWER_PHONE_CALLS permission not granted: ${se.message}")
                    } catch (e: Exception) {
                        Log.w(TAG, "TelecomManager answer error: ${e.message}")
                    }
                }
                if (!answered) {
                    val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager
                    am?.let {
                        it.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK))
                        it.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK))
                    }
                }
            } else if (ev.callReject && (currentCallState == TelephonyManager.CALL_STATE_RINGING || currentCallState == TelephonyManager.CALL_STATE_OFFHOOK)) {
                Log.i(TAG, "Handlebar: Ending / Rejecting Phone Call (TelecomManager + KeyEvent fallback)")
                var ended = false
                if (tm != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    try {
                        if (context.checkSelfPermission(Manifest.permission.ANSWER_PHONE_CALLS) == PackageManager.PERMISSION_GRANTED) {
                            ended = tm.endCall()
                            Log.i(TAG, "Ended call via TelecomManager.endCall() -> $ended")
                        }
                    } catch (se: SecurityException) {
                        Log.w(TAG, "ANSWER_PHONE_CALLS permission not granted: ${se.message}")
                    } catch (e: Exception) {
                        Log.w(TAG, "TelecomManager endCall error: ${e.message}")
                    }
                }
                if (!ended) {
                    val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager
                    am?.let {
                        it.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENDCALL))
                        it.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENDCALL))
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Call answer/end error: ${e.message}")
        }
    }

    private fun resolveContactName(phoneNumber: String?): String? {
        if (phoneNumber.isNullOrEmpty()) return null
        try {
            val uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber))
            context.contentResolver.query(uri, arrayOf(ContactsContract.PhoneLookup.DISPLAY_NAME), null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val nameIdx = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME)
                    if (nameIdx >= 0) {
                        return cursor.getString(nameIdx)
                    }
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "Contact lookup error: ${e.message}")
        }
        return phoneNumber
    }

    companion object {
        private const val TAG = "TelephonyCallHandler"
    }
}
