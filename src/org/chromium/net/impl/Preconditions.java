package org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkDirect(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
        }
    }

    public static void checkHasRemaining(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("ByteBuffer is already full.");
        }
    }
}
