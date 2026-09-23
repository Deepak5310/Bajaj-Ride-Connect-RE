package com.facebook.jni;

import de.patwoz.rn.bluetoothstatemanager.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class UnknownCppException extends CppException {
    public UnknownCppException() {
        super(Constants.BluetoothState.UNKNOWN);
    }

    public UnknownCppException(String str) {
        super(str);
    }
}
