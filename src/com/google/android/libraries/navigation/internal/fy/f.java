package com.google.android.libraries.navigation.internal.fy;

import android.content.SharedPreferences;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements SharedPreferences.OnSharedPreferenceChangeListener {
    public URL a;
    public final a c;
    public final c d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    public e b = null;

    public f(URL url, c cVar, a aVar) {
        this.a = url;
        this.d = cVar;
        this.c = aVar;
    }

    public final synchronized URL a() {
        return this.a;
    }

    public final void b() {
        this.e.getAndSet(true);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }
}
