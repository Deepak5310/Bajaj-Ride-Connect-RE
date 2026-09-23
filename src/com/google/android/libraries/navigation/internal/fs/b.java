package com.google.android.libraries.navigation.internal.fs;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.nw.e;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final int a = 12800000;
    private static volatile a b = new a();

    public static boolean a() {
        if (e.b("GcoreUtil.isFirstPartyApiAvailableAtOrAboveVersion") == null) {
            return false;
        }
        Trace.endSection();
        return false;
    }
}
