package com.google.android.libraries.navigation.internal.pm;

import android.graphics.Bitmap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final AtomicLong a = new AtomicLong();
    private final ConcurrentHashMap b = new ConcurrentHashMap();

    public final String a(Bitmap bitmap) {
        String str = "direct-bitmap://" + this.a.incrementAndGet();
        this.b.put(str, bitmap);
        return str;
    }

    public final void b(String str) {
        this.b.remove(str);
    }
}
