package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cc {
    public String a = null;
    private Boolean b = null;

    public static ThreadFactory a(cc ccVar) {
        String str = ccVar.a;
        return new cb(Executors.defaultThreadFactory(), str, str != null ? new AtomicLong(0L) : null, ccVar.b);
    }

    public final void b() {
        this.b = true;
    }
}
