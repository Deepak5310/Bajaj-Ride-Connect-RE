package com.google.android.libraries.navigation.internal.nw;

import android.opengl.GLES32;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static final a a = new a();
    private static final AtomicBoolean b = new AtomicBoolean(false);

    public static a a(String str) {
        if (c()) {
            return d(str);
        }
        return null;
    }

    public static final a b(String str, Enum r2) {
        if (c()) {
            return d(str.concat(String.valueOf(r2.name())));
        }
        return null;
    }

    public static final boolean c() {
        return b.get();
    }

    private static a d(String str) {
        if (c()) {
            GLES32.glPushDebugGroup(33354, 1, str.length(), str);
        }
        return a;
    }
}
