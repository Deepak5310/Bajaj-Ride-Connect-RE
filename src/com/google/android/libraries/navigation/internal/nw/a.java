package com.google.android.libraries.navigation.internal.nw;

import android.opengl.GLES32;
import java.io.Closeable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (b.c()) {
            GLES32.glPopDebugGroup();
        }
    }
}
