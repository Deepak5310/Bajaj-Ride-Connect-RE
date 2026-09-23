package com.drew.lang;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class ByteConvert {
    public static int toInt32BigEndian(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[1] << Ascii.DLE) & 16711680) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    public static int toInt32LittleEndian(byte[] bArr) {
        return ((bArr[3] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | (bArr[0] & 255) | ((bArr[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr[2] << Ascii.DLE) & 16711680);
    }
}
