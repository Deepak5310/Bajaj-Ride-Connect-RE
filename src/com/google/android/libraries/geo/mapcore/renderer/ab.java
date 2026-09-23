package com.google.android.libraries.geo.mapcore.renderer;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ab {
    public final int a;
    public final int b;
    public final byte[] c;

    public ab(byte[] bArr) {
        if (!a(bArr)) {
            throw new IllegalArgumentException("Unrecognized compressed texture format");
        }
        this.c = bArr;
        ShortBuffer shortBufferAsShortBuffer = ByteBuffer.wrap(bArr).asShortBuffer();
        this.a = shortBufferAsShortBuffer.get(4);
        this.b = shortBufferAsShortBuffer.get(5);
    }

    public static boolean a(byte[] bArr) {
        return bArr[0] == 80 && bArr[1] == 75 && bArr[2] == 77 && bArr[3] == 32;
    }
}
